package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)
@SuperBuilder
public abstract class Articulo extends Base{
    protected String denominacion;
    protected double precioVenta;
    private Categoria categoria;
    private UnidadMedida unidadMedida;
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();
    @Builder.Default
    private List<ImagenPromocion> imagenesPromos = new ArrayList<>();
    @Builder.Default
    private List<Promocion> promociones = new ArrayList<>();

    public void agregarPromocion(Promocion promocion) {
        this.promociones.add(promocion);
    }

    public void agregarDetalle(DetallePedido detallePedido) {
        this.detallePedidos.add(detallePedido);
    }

    public void agregarImagen(ImagenPromocion imagenPromo) {
        this.imagenesPromos.add(imagenPromo);
    }
}
