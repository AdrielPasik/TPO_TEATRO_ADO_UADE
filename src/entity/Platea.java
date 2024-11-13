package entity;

public class Platea extends Zona{
    public Platea() {
        super();
    }
    public double calcularPrecio(double precio){
        return precio*1.75;
    }

}