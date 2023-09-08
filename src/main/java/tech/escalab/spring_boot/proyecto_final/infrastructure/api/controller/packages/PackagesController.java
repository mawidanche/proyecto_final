package tech.escalab.spring_boot.proyecto_final.infrastructure.api.controller.packages;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages.DeletePackagesUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages.FindPackagesByUuidUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages.SavePackagesUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages.UpdatePackagesUseCase;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.request.PackagesRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.response.PackagesResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.request.TrucksRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.response.TrucksResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.packages.PackagesApiMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.packages.PackagesSwagger;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/trucks")
public class PackagesController implements PackagesSwagger {
    private SavePackagesUseCase saveUseCase;
    private FindPackagesByUuidUseCase findByUuidUseCase;
    private UpdatePackagesUseCase updateUseCase;
    private DeletePackagesUseCase deleteUseCase;
    private PackagesApiMapper apiMapper;
    

    @Override
    @PostMapping
    public PackagesResponseDto save(@RequestBody PackagesRequestDto request){
       var saved = saveUseCase.execute(
               apiMapper.toDomain(request)
       );
        return apiMapper.toResponse(saved);
    }
    @Override
    @GetMapping("/{uuid}")
    public PackagesResponseDto findById( @PathVariable UUID uuid) {
        var findDrivers  = findByUuidUseCase.execute(uuid);
        return apiMapper.toResponse(findDrivers);
    }
    @Override
    @PutMapping("/{uuid}")
    public void update( @PathVariable UUID uuid, @RequestBody PackagesRequestDto request) {
        updateUseCase.execute(uuid, apiMapper.toDomain(request));
    }

    @Override
    @DeleteMapping("/{uuid}")
    public void delete( @PathVariable UUID uuid) {
        deleteUseCase.execute(uuid);
    }


}
