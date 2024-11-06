package entity;

public class Efectivo implements MedioDePago {
    @Override
    public double calcularMonto(double monto) {
        return monto * 0.9;
    }
}
