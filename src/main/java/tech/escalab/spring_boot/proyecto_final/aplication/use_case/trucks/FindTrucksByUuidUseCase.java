package tech.escalab.spring_boot.proyecto_final.aplication.use_case.trucks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;
import tech.escalab.spring_boot.proyecto_final.domain.port.trucks.TrucksPort;

import java.util.UUID;

@AllArgsConstructor
@Component
public class FindTrucksByUuidUseCase {
    private TrucksPort port;

    public Trucks execute(UUID uuid){
        return port.findByUuid(uuid);
    }
}
