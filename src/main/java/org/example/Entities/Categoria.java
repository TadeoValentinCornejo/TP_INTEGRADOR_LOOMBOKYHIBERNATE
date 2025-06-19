package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude ={"categoriaPadre","subCategorias","articulos"} )
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class  Categoria extends Base {
    private String denominacion;
    @Builder.Default
    private List<Sucursal> sucursales = new ArrayList<>();
    private Categoria categoriaPadre;
    @Builder.Default
    private List<Categoria> subCategorias = new ArrayList<>();
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<>();

    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public void agregarArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }

    public void agregarSubCategoria(Categoria categoria) {
        this.subCategorias.add(categoria);
    }
}
