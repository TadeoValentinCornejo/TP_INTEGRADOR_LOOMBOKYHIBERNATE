package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Enums.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = {"imagenesPromos","sucursales","articulos"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Promocion extends Base{
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    @Builder.Default
    private List<Sucursal> sucursales = new ArrayList<>();
    @Builder.Default
    private List<ImagenPromocion> imagenesPromos = new ArrayList<>();
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<>();

    public void agregarArticulos(Articulo articulo) {
        this.articulos.add(articulo);
    }

    public void agregarSucursales(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public void agregarImagenes(ImagenPromocion imagenPromo) {
        this.imagenesPromos.add(imagenPromo);
    }
}

