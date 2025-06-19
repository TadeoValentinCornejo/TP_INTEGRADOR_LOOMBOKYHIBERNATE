package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString (exclude = {"sucursal","pedidos","clientes"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Domicilio extends Base {
    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;
    private Sucursal sucursal;
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    @Builder.Default
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
