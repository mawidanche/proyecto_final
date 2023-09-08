package tech.escalab.spring_boot.proyecto_final.aplication.use_case.trucks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;
import tech.escalab.spring_boot.proyecto_final.domain.port.trucks.TrucksPort;

@AllArgsConstructor
@Component
public class SaveTrucksUseCase {
    private TrucksPort port;

    public Trucks execute(Trucks trucks){
        return port.save(trucks);
    }
}
