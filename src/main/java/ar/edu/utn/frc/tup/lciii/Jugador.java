package ar.edu.utn.frc.tup.lciii;

import lombok.Data;

@Data
public class Jugador {

    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
}
