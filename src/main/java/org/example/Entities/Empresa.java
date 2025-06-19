package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString (exclude = "sucursales")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Empresa extends Base {
    public String nombre;
    private String razonSocial;
    private Integer cuil;
    @Builder.Default
    private List<Sucursal> sucursales = new ArrayList<>();

    public void agregarSucursales(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }
}
