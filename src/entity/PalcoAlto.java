package entity;

public class PalcoAlto extends Zona{
    public PalcoAlto() {
        super();
    }
    public double calcularPrecio(double precio){
        return precio*1.7;
    }
}