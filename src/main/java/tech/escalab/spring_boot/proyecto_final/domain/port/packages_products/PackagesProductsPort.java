package tech.escalab.spring_boot.proyecto_final.domain.port.packages_products;


import tech.escalab.spring_boot.proyecto_final.domain.model.packages_products.PackagesProducts;

import java.util.UUID;

public interface PackagesProductsPort {

    void deleteByUuid(UUID uuid);

    PackagesProducts findByUuid(UUID uuid);

    PackagesProducts save(PackagesProducts packages);

    PackagesProducts update(PackagesProducts toUpdate, PackagesProducts found);

}
