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
public class  ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;
    @Builder.Default
    private List<ArticuloManufacturadoDetalle> artManuDetalles = new ArrayList<>();

    public void agregarArtManuDetalles(ArticuloManufacturadoDetalle artManuDetalles) {
        this.artManuDetalles.add(artManuDetalles);
    }
}
