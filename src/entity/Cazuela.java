package entity;

public class Cazuela extends Zona{
    public Cazuela() {
        super();
    }
    public double calcularPrecio(double precio){
        return precio*1.3;
    }
}
