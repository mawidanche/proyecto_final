package tech.escalab.spring_boot.proyecto_final.infrastructure.api.controller.packages_products;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages_products.DeletePackagesProductsUseCase;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages_products.SavePackagesProductsUseCase;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.request.PackagesProductsRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.response.PackagesProductsResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.packages_products.PackagesProductsApiMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.packages_products.PackagesProductsSwagger;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages_products")
public class PackagesProductsController implements PackagesProductsSwagger {
    private SavePackagesProductsUseCase saveUseCase;
    private DeletePackagesProductsUseCase deletePackagesProductsUseCase;
    private PackagesProductsApiMapper apiMapper;

    @Override
    @PostMapping
    public PackagesProductsResponseDto save(@RequestBody PackagesProductsRequestDto request) {
        var saved = saveUseCase.execute(
                apiMapper.toDomain(request)
        );
        return apiMapper.toResponse(saved);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        deletePackagesProductsUseCase.execute(uuid);
    }


}
