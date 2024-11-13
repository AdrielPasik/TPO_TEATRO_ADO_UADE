package view;

import entity.Asiento;
import entity.Zona;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsientoView {
    private int idAsiento;
    private Zona tipoZona;
    private boolean libre;

    public static AsientoView map(Asiento asiento) {
        return new AsientoView(asiento.getIdAsiento(), asiento.getTipoZona(), asiento.isLibre());
    }

    @Override
    public String toString() {
        return "idAsiento=" + idAsiento +
                ", tipoZona=" + tipoZona.getClass().getName().substring(7) +
                ", libre=" + libre
                ;
    }
}
