package tech.escalab.spring_boot.proyecto_final.aplication.use_case.drivers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.port.drivers.DriversPort;

import java.util.UUID;

@AllArgsConstructor
@Component
public class DeleteDriversUseCase {
    private DriversPort driversPort;

    public void execute(UUID uuid) {
        driversPort.findByUuid(uuid);
        driversPort.deleteByUuid(uuid);
    }

}
