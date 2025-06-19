package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString (exclude = "artManuDetalles")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private Integer tiempoEstimado;
    private String preparacion;
    @Builder.Default
    private List<ArticuloManufacturadoDetalle> artManuDetalles = new ArrayList<>();

    public void agregarArtManuDetalles(ArticuloManufacturadoDetalle artManuDetalles) {
        this.artManuDetalles.add(artManuDetalles);
    }
}
