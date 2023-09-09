package tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.exception.base.DomainExceptionCode;
import tech.escalab.spring_boot.proyecto_final.domain.exception.general.StatusInvalidException;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Status;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages.PackagesPort;

import java.util.UUID;

@AllArgsConstructor
@Component
public class UpdateStatusPackagesUseCase {
    private PackagesPort port;

    public void execute(UUID uuid, String newStatus){

        Status status = Status.valueOf(newStatus);
        if(status == null){
            throw new StatusInvalidException(DomainExceptionCode.PACKAGES_STATUS_INVALID);
        }
        var driverFound = port.findByUuid(uuid);
        var packages = driverFound;
        packages.setStatus(status);

        port.update(packages, driverFound);
    }
}
