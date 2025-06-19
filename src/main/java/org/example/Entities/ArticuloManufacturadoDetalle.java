package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString (exclude = {"artManufacturado","artInsumo"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ArticuloManufacturadoDetalle extends Base {
    private Integer cantidad;
    private ArticuloManufacturado artManufacturado;
    private ArticuloInsumo artInsumo;
}
