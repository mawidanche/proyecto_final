package tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages_products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages_products.PackagesProducts;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages_products.PackagesProductsPort;

@AllArgsConstructor
@Component
public class SavePackagesProductsUseCase {
    private PackagesProductsPort port;

    public PackagesProducts execute(PackagesProducts p){

        return port.save(p);
    }
}
