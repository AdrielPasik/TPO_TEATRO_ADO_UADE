package entity;

import lombok.Getter;

@Getter
public enum TipoZona {

    PLATEA(50),
    PALCO_ALTO(40),
    PALCO_BAJO(45),
    CAZUELA(30),
    TERTULIA(25),
    PARAISO(20);

    private final int precio;

    TipoZona(int precio) {
        this.precio = precio;
    }

}