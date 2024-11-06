package entity;

public class Platea extends Zona{
    public Platea() {
        super();
    }
    public double calcularPrecio(){
        return this.getPrecio()*1.8;
    }
}
