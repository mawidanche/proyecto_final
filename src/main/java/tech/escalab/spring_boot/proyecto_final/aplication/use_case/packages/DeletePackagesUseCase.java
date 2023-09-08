package tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages.PackagesPort;

import java.util.UUID;

@AllArgsConstructor
@Component
public class DeletePackagesUseCase {
    private PackagesPort port;

    public void execute(UUID uuid) {
        port.findByUuid(uuid);
        port.deleteByUuid(uuid);
    }

}
