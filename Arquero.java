import java.util.ArrayList;

public class Arquero extends Heroe{
    protected int precision;

    public Arquero(String nombreHeroe, int nivel, int puntosDeVida, ArrayList<Arma> armas, int precision) {
        super(nombreHeroe, nivel, puntosDeVida, armas);
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void disparar(){
        System.out.println("El arquero ha disparado con su arco.");
    }

    @Override
    public String toString() {
        return "Nombre del Arquero: " + nombreHeroe +
                " Nivel: " + nivel +
                " Puntos de vida: " + puntosDeVida +
                " Precisión: " + precision +
                " Arma: " + armas;
    }
}
