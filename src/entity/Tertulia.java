package entity;

public class Tertulia extends Zona{
    public Tertulia() {
        super();
    }
    public double calcularPrecio(){
        return this.getPrecio()*1.1;
    }
}
