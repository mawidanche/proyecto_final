package tech.escalab.spring_boot.proyecto_final.aplication.use_case.packages_products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import tech.escalab.spring_boot.proyecto_final.domain.exception.base.DomainExceptionCode;
import tech.escalab.spring_boot.proyecto_final.domain.exception.general.StatusInvalidException;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Status;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages_products.PackagesProducts;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages.PackagesPort;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages_products.PackagesProductsPort;

import java.util.UUID;

@AllArgsConstructor
@Component
public class DeletePackagesProductsUseCase {
    private PackagesProductsPort port;

    public void execute(UUID uuid) throws StatusInvalidException {
        PackagesProducts producto = port.findByUuid(uuid);

        if(producto.getPackages() != null && !Status.LOADED.equals(producto.getPackages().getStatus()) ) {
            throw new StatusInvalidException(DomainExceptionCode.PACKAGES_STATUS_INVALID);
        }
        port.deleteByUuid(uuid);
    }

}
