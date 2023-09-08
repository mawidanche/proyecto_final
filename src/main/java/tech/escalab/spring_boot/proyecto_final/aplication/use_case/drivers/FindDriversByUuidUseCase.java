package tech.escalab.spring_boot.proyecto_final.aplication.use_case.drivers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.drivers.Drivers;
import tech.escalab.spring_boot.proyecto_final.domain.port.drivers.DriversPort;

import java.util.UUID;

@AllArgsConstructor
@Component
public class FindDriversByUuidUseCase {
    private DriversPort driversPort;

    public Drivers execute(UUID uuid){
        return driversPort.findByUuid(uuid);
    }
}
