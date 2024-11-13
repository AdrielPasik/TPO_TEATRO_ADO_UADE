package entity;

public class Paraiso extends Zona{
    public Paraiso() {
        super();
    }
    public double calcularPrecio(double precio){
        return precio*1.2;
    }

}