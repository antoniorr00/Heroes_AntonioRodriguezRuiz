import java.util.ArrayList;

public class Guerrero extends Heroe{
    protected int fuerza;

    public Guerrero(String nombreHeroe, int nivel, int puntosDeVida, ArrayList<Arma> armas, int fuerza) {
        super(nombreHeroe, nivel, puntosDeVida, armas);
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void atacar(){
        System.out.println("El guerrero ha atacado con un golpe fuerte.");
    }

    @Override
    public String toString() {
        return "Nombre del Guerrero: " + nombreHeroe +
                ", Nivel: " + nivel +
                ", Puntos de vida: " + puntosDeVida +
                ", Fuerza: " + fuerza +
                ", Arma: " + armas;
    }
}
