package entity;

public class Cazuela extends Zona{
    public Cazuela() {
        super();
    }
    public double calcularPrecio(){
        return this.getPrecio()*1.8;
    }
}
