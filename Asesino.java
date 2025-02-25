import java.util.ArrayList;

public class Asesino extends Heroe{
    protected int sigilo;

    public Asesino(String nombreHeroe, int nivel, int puntosDeVida, ArrayList<Arma> armas, int sigilo) {
        super(nombreHeroe, nivel, puntosDeVida, armas);
        this.sigilo = sigilo;
    }

    public int getSigilo() {
        return sigilo;
    }

    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }

    @Override
    public String toString() {
        return "Nombre del Asesino: " + nombreHeroe +
                ", Nivel: " + nivel +
                ", Puntos de vida: " + puntosDeVida +
                ", Sigilo: " + sigilo +
                ", Arma: " + armas;
    }
}
