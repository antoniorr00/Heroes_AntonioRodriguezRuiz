import java.util.ArrayList;


public class Heroe {
    protected String nombreHeroe;
    protected int nivel;
    protected int puntosDeVida;
    protected ArrayList<Arma> armas;

    public Heroe(String nombreHeroe, int nivel, int puntosDeVida, ArrayList<Arma> armas) {
        this.nombreHeroe = nombreHeroe;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
        this.armas = armas;
    }

    public String getNombreHeroe() {
        return nombreHeroe;
    }

    public void setNombreHeroe(String nombreHeroe) {
        this.nombreHeroe = nombreHeroe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }

    @Override
    public String toString() {
        return  "Nombre del Heroe: " + nombreHeroe +
                ", Nivel: " + nivel +
                ", Puntos de vida: " + puntosDeVida +
                ", Arma: " + armas;
    }
}
