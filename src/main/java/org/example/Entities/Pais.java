package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "provincias")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Pais extends Base{
    private String nombre;
    @Builder.Default
    private List<Provincia> provincias  = new ArrayList<>();

    public void agregarProvincia(Provincia provincia) {
        this.provincias.add(provincia);
    }
}
