package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Enums.FormaPago;

import java.time.LocalDate;

@Data
@ToString(exclude = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Factura extends Base{
    private LocalDate fechaFacturacion;
    private Integer mpPaymentId;
    private Integer mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;
    private FormaPago formaPago;
    private Double totalVenta;
    private Pedido pedido;

}
