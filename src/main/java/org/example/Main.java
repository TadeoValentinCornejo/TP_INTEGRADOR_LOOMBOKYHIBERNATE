package org.example;

import org.example.Entities.*;
import org.example.Enums.Estado;
import org.example.Enums.FormaPago;
import org.example.Enums.TipoEnvio;
import org.example.Enums.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = Empresa.builder()
                .nombre("Muebleria Don Jorge")
                .razonSocial("Muebleria Jorge S.A")
                .cuil(23214512)
                .build();

        UnidadMedida unidad = UnidadMedida.builder()
                .denominacion("litros")
                .build();

        UnidadMedida unidad2 = UnidadMedida.builder()
                .denominacion("Unidad")
                .build();

        Categoria catPadre = Categoria.builder()
                .denominacion("Articulos del hogar")
                .build();

        Categoria subcat1 = Categoria.builder()
                .denominacion("Mesitas de luz")
                .build();

        Categoria subcat2 = Categoria.builder()
                .denominacion("Juegos de mesa")
                .build();

        Categoria categoria = Categoria.builder()
                .denominacion("Muebles")
                .categoriaPadre(catPadre)
                .build();

        categoria.agregarSubCategoria(subcat1);
        categoria.agregarSubCategoria(subcat2);
        catPadre.agregarSubCategoria(categoria);

        ArticuloInsumo insumo = ArticuloInsumo.builder()
                .denominacion("Pintura")
                .precioCompra(40.0)
                .precioVenta(50.0)
                .stockActual(20)
                .stockMaximo(40)
                .esParaElaborar(true)
                .unidadMedida(unidad)
                .categoria(categoria)
                .build();

        ArticuloManufacturado manufacturado = ArticuloManufacturado.builder()
                .denominacion("Silla de madera")
                .descripcion("Silla echa de madre de algarrobo,comoda y robusta")
                .tiempoEstimado(30)
                .precioVenta(200.0)
                .preparacion("aplicar cola en cada caja y unirla con su espiga")
                .unidadMedida(unidad2)
                .categoria(categoria)
                .build();

         ArticuloManufacturadoDetalle detalle = ArticuloManufacturadoDetalle.builder()
                .cantidad(4)
                 .artInsumo(insumo)
                .artManufacturado(manufacturado)
                .build();


        manufacturado.agregarArtManuDetalles(detalle);
        insumo.agregarArtManuDetalles(detalle);

        ImagenCliente imagenCliente = ImagenCliente.builder()
                .denominacion("foto.png")
                .build();

        Pais pais = Pais.builder().nombre("Argentina").build();
        Provincia provincia1 = Provincia.builder().nombre("Mendoza").pais(pais).build();
        Provincia provincia2 = Provincia.builder().nombre("Cordoba").pais(pais).build();
        Localidad localidad1 = Localidad.builder().nombre("Las Heras").provincia(provincia1).build();
        Localidad localidad2 = Localidad.builder().nombre("Maipu").provincia(provincia1).build();
        Domicilio domicilio1 = Domicilio.builder()
                .calle("Av San Martin")
                .numero(123)
                .cp(5534)
                .localidad(localidad1)
                .build();

        Domicilio domicilio2 = Domicilio.builder()
                .calle("Sarmiento")
                .numero(864)
                .cp(5537)
                .localidad(localidad2)
                .build();

        localidad1.agregarDomicilio(domicilio1);
        localidad2.agregarDomicilio(domicilio2);
        provincia1.agregarLocalidad(localidad2);
        provincia1.agregarLocalidad(localidad1);
        pais.agregarProvincia(provincia1);
        pais.agregarProvincia(provincia2);

        Usuario usuario = Usuario.builder()
                .username("Juan")
                .auth0Id("auth0|176")
                .build();

        Cliente cliente = Cliente.builder()
                .nombre("Pedro")
                .apellido("Gómez")
                .email("pedro@example.com")
                .telefono("123456789").
                fechaNacimiento(LocalDate.of(2003, 4, 29))
                .usuario(usuario)
                .imagenCliente(imagenCliente)
                .build();

        imagenCliente.setCliente(cliente);
        usuario.agregarClientes(cliente);

        Sucursal sucursal2 = Sucursal.builder()
                .nombre("Sucursal Maipu")
                .horarioApertura(LocalTime.of(12, 00))
                .horarioCierre(LocalTime.of(23, 00))
                .empresa(empresa)
                .domicilio(domicilio2)
                .build();

        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal Centro")
                .horarioApertura(LocalTime.of(12, 00))
                .horarioCierre(LocalTime.of(23, 00))
                .empresa(empresa)
                .domicilio(domicilio1)
                .build();

        categoria.agregarSucursal(sucursal1);
        domicilio1.setSucursal(sucursal1);
        domicilio2.setSucursal(sucursal2);
        empresa.agregarSucursales(sucursal1);
        empresa.agregarSucursales(sucursal2);


        Pedido pedido = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.of(21, 30))
                .total(300.00)
                .totalCosto(400.00)
                .tipoEnvio(TipoEnvio.TAKEAWAY)
                .estado(Estado.PENDIENTE)
                .formaPago(FormaPago.MERCADOPAGO)
                .fechaPedido(LocalDate.of(2025, 5, 5))
                .sucursal(sucursal1)
                .domicilio(domicilio1)
                .cliente(cliente)
                .build();

        domicilio1.agregarPedido(pedido);
        domicilio1.agregarCliente(cliente);

        cliente.agregarPedido(pedido);
        cliente.agregarDomicilio(domicilio1);
        cliente.agregarDomicilio(domicilio2);

        Factura factura = Factura.builder()
                .fechaFacturacion(LocalDate.of(2025, 5, 5))
                .mpPaymentId(23)
                .mpMerchantOrderId(21)
                .mpPreferenceId("23")
                .mpPaymentType("Mercado Pago")
                .formaPago(FormaPago.MERCADOPAGO)
                .totalVenta(300.00)
                .pedido(pedido)
                .build();

        pedido.setFactura(factura);

        DetallePedido detallePedido = DetallePedido.builder()
                .cantidad(2)
                .precio(pedido.getTotal())
                .articulo(manufacturado)
                .pedido(pedido)
                .build();

        DetallePedido detallePedido2 = DetallePedido.builder()
                .cantidad(5)
                .precio(pedido.getTotal())
                .articulo(insumo)
                .pedido(pedido)
                .build();

        pedido.agregarDetallePedido(detallePedido);
        manufacturado.agregarDetalle(detallePedido);
        insumo.agregarDetalle(detallePedido2);

        ImagenPromocion imagenPromo = ImagenPromocion.builder()
                .denominacion("Promo de Sillas")
                .articulo(manufacturado)
                .build();

        manufacturado.agregarImagen(imagenPromo);

        Promocion promocion = Promocion.builder()
                .denominacion("Promo 2x1")
                .descripcionDescuento("Llevá 2 pagá 1")
                .fechaDesde(LocalDate.of(2025, 5, 5))
                .fechaHasta(LocalDate.of(2025, 5, 12))
                .horaDesde(LocalTime.of(18, 00))
                .horaHasta(LocalTime.of(22, 00))
                .precioPromocional(150.00)
                .tipoPromocion(TipoPromocion.HAPPYHOUR)
                .build();

        imagenPromo.setPromocion(promocion);
        promocion.agregarArticulos(manufacturado);
        promocion.agregarImagenes(imagenPromo);
        promocion.agregarSucursales(sucursal1);
        promocion.agregarSucursales(sucursal2);

    }
}

