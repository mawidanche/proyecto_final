package tech.escalab.spring_boot.proyecto_final.infrastructure.api.controller.trucks;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.trucks.DeleteTrucksUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.trucks.FindTrucksByUuidUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.trucks.SaveTrucksUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.trucks.UpdateTrucksUseCase;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.request.TrucksRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.response.TrucksResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.trucks.TrucksApiMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.trucks.TrucksSwagger;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/trucks")
public class TrucksController implements TrucksSwagger {
    private SaveTrucksUseCase saveUseCase;
    private FindTrucksByUuidUseCase findByUuidUseCase;
    private UpdateTrucksUseCase updateUseCase;
    private DeleteTrucksUseCase deleteUseCase;
    private TrucksApiMapper apiMapper;
    

    @Override
    @PostMapping
    public TrucksResponseDto save(@RequestBody TrucksRequestDto request){
       var saved = saveUseCase.execute(
               apiMapper.toDomain(request)
       );
        return apiMapper.toResponse(saved);
    }
    @Override
    @GetMapping("/{uuid}")
    public TrucksResponseDto findById( @PathVariable UUID uuid) {
        var findDrivers  = findByUuidUseCase.execute(uuid);
        return apiMapper.toResponse(findDrivers);
    }
    @Override
    @PutMapping("/{uuid}")
    public void update( @PathVariable UUID uuid, @RequestBody TrucksRequestDto request) {
        updateUseCase.execute(uuid, apiMapper.toDomain(request));
    }

    @Override
    @DeleteMapping("/{uuid}")
    public void delete( @PathVariable UUID uuid) {
        deleteUseCase.execute(uuid);
    }


}
