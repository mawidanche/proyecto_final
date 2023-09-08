package tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages.PackagesPort;

import java.util.UUID;

@AllArgsConstructor
@Component
public class FindPackagesByUuidUseCase {
    private PackagesPort port;

    public Packages execute(UUID uuid){
        return port.findByUuid(uuid);
    }
}
