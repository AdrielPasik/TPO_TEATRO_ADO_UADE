package entity;

public class PalcoBajo extends Zona{
    public PalcoBajo() {
        super();
    }
    public double calcularPrecio(){
        return this.getPrecio()*2;
    }
}
