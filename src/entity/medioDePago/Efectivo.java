package entity.medioDePago;

import interfaz.MedioDePago;

public class Efectivo implements MedioDePago {
    @Override
    public double calcularMonto(double monto) {
        return monto * 0.9;
    }
}
