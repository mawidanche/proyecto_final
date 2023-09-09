package tech.escalab.spring_boot.proyecto_final.infrastructure.api.controller.packages_products;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages_products.SavePackagesProductsUseCase;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.request.PackagesProductsRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.response.PackagesProductsResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.packages_products.PackagesProductsApiMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.packages_products.PackagesProductsSwagger;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages_products")
public class PackagesProductsController implements PackagesProductsSwagger {
    private SavePackagesProductsUseCase saveUseCase;
    private PackagesProductsApiMapper apiMapper;

    @Override
    @PostMapping
    public PackagesProductsResponseDto save(@RequestBody PackagesProductsRequestDto request) {
        var saved = saveUseCase.execute(
                apiMapper.toDomain(request)
        );
        return apiMapper.toResponse(saved);
    }
}
