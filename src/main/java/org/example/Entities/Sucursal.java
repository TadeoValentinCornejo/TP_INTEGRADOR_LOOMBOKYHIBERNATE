package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString (exclude = {"promociones","categorias","pedidos"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)
@SuperBuilder
public class Sucursal extends Base {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Empresa empresa;
    private Domicilio domicilio;
    @Builder.Default
    private List<Promocion> promociones = new ArrayList<>();
    @Builder.Default
    private List<Categoria> categorias  = new ArrayList<>();
    @Builder.Default
    private List<Pedido> pedidos  = new ArrayList<>();

    public void agregarPromociones(Promocion promocion) {
        this.promociones.add(promocion);
    }

    public void agregarCategorias(Categoria categoria) {
        this.categorias.add(categoria);
    }

    public void agregarPedidos(Pedido pedido) {
        this.pedidos.add(pedido);
    }

}
