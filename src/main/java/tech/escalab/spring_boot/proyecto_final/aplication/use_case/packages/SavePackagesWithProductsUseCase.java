package tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages_products.PackagesProducts;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages.PackagesPort;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages_products.PackagesProductsPort;

import java.util.List;

@AllArgsConstructor
@Component
public class SavePackagesWithProductsUseCase {
    private PackagesPort port;
    private PackagesProductsPort productsPort;

    public Packages execute(Packages packages) {
        List<PackagesProducts> productos = packages.getPackagesProducts();
        packages.setPackagesProducts(null);
        Packages p = port.save(packages);

        for (PackagesProducts producto :productos) {
            producto.setPackages(p);
            productsPort.save(producto);
        }

        p = port.findByUuid(p.getUuid());

        return p;
    }
}
