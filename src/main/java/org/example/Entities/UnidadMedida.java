package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString (exclude = "articulos")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UnidadMedida extends Base {
    private String denominacion;
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<>();

    public void agregarArticulos(Articulo articulo) {
        this.articulos.add(articulo);
    }
}
