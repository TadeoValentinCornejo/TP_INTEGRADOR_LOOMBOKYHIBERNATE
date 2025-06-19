package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString (exclude = {"localidades"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Provincia extends Base {
    private String nombre;
    @Builder.Default
    private List<Localidad> localidades = new ArrayList<>();
    private Pais pais;

    public void agregarLocalidad(Localidad localidad) {
        this.localidades.add(localidad);
    }
}
