package org.example.Entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Imagen extends Base{
    private String denominacion;
    private Cliente cliente;
    private Articulo articulo;
    private Promocion promocion;
}
