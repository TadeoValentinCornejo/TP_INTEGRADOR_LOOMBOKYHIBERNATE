package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString (exclude = {"provincia","domicilios"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Localidad extends Base{
    private String nombre;
    @Builder.Default
    private List<Domicilio> domicilios  = new ArrayList<>();
    private Provincia provincia;

    public void agregarDomicilio(Domicilio domicilio) {
        this.domicilios.add(domicilio);
    }
}
