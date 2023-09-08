package tech.escalab.spring_boot.proyecto_final.infrastructure.api.controller.drivers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.drivers.DeleteDriversUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.drivers.FindDriversByUuidUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.drivers.SaveDriversUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.drivers.UpdateDriversUseCase;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.request.DriversRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.response.DriversResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.drivers.DriversApiMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.drivers.DriversSwagger;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/drivers")
public class DriversController implements DriversSwagger {
    private SaveDriversUseCase saveDriversUseCase;
    private FindDriversByUuidUseCase findDriversByUuidUseCase;
    private UpdateDriversUseCase updateDriversUseCase;
    private DriversApiMapper driversApiMapper;
    private DeleteDriversUseCase deleteDriversUseCase;

    @Override
    @PostMapping
    public DriversResponseDto save(@RequestBody DriversRequestDto request){
       var savedDrivers = saveDriversUseCase.execute(
               driversApiMapper.toDomain(request)
       );

        return driversApiMapper.toResponse(savedDrivers);
    }
    @Override
    @GetMapping("/{uuid}")
    public DriversResponseDto findById( @PathVariable UUID uuid) {
        var findDrivers  = findDriversByUuidUseCase.execute(uuid);
        return driversApiMapper.toResponse(findDrivers);
    }
    @Override
    @PutMapping("/{uuid}")
    public void update( @PathVariable UUID uuid, @RequestBody DriversRequestDto request) {
        updateDriversUseCase.execute(uuid, driversApiMapper.toDomain(request));
    }

    @Override
    @DeleteMapping("/{uuid}")
    public void delete( @PathVariable UUID uuid) {
        deleteDriversUseCase.execute(uuid);
    }


}
