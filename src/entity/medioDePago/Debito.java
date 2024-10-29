package entity.medioDePago;

import interfaz.MedioDePago;

public class Debito implements MedioDePago {
    @Override
    public double calcularMonto(double monto) {
        return 0;
    }
}
