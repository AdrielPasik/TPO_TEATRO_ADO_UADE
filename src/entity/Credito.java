package entity;

public class Credito implements MedioDePago {
    private int cuotas;

    public Credito(int cuotas) {
        this.cuotas = cuotas;
    }

    @Override
    public double calcularMonto(double monto) {
        switch (cuotas) {
            case 2:
                return monto * 1.06;
            case 3:
                return monto * 1.12;
            case 6:
                return monto * 1.2;
            default:
                System.out.println("El número de cuotas no es correcto"); //podemos agregar manejo de errores aca y devolver un error con el mensaje
                return 0;
        }
    }
}
