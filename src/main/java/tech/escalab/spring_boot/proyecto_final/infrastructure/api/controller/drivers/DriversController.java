package tech.escalab.spring_boot.proyecto_final.infrastructure.api.controller.drivers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.escalab.spring_boot.proyecto_final.aplication.use_case.drivers.SaveDriversUseCase;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.request.DriversRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.response.DriversResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.drivers.DriversApiMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.drivers.DriversSwagger;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/drivers")
public class DriversController implements DriversSwagger {
    private SaveDriversUseCase saveDriversUseCase;
    private DriversApiMapper driversApiMapper;

    @Override
    @PostMapping
    public DriversResponseDto save(@RequestBody DriversRequestDto request){
       var savedDrivers = saveDriversUseCase.execute(
               driversApiMapper.toDomain(request)
       );

        return driversApiMapper.toResponse(savedDrivers);
    }
}
