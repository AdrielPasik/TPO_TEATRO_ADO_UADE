package entity;

public class PalcoAlto extends Zona{
    public PalcoAlto() {
        super();
    }
    public double calcularPrecio(){
        return this.getPrecio()*1.5;
    }
}
