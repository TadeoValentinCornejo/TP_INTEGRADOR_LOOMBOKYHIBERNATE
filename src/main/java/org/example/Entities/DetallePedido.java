package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DetallePedido extends Base{
    private Integer cantidad;
    private Double precio;
    private Pedido pedido;
    private Articulo articulo;
}
