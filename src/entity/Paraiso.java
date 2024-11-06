package entity;

public class Paraiso extends Zona{
    public Paraiso() {
        super();
    }
    public double calcularPrecio(){
        return this.getPrecio()*1.3;
    }
}
