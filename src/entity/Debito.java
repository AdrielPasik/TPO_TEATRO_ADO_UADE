package entity;

public class Debito implements MedioDePago {
    @Override
    public double calcularMonto(double monto) {
        return monto;
    }
}
