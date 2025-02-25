import java.util.ArrayList;

public class Mago extends Heroe{
    protected int mana;

    public Mago(String nombreHeroe, int nivel, int puntosDeVida, ArrayList<Arma> armas, int mana) {
        super(nombreHeroe, nivel, puntosDeVida, armas);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void hechizar(){
        System.out.println("El mago ha realizado un hechizo.");
    }

    @Override
    public String toString() {
        return "Nombre del Mago: " + nombreHeroe +
                ", Nivel: " + nivel +
                ", Puntos de vida: " + puntosDeVida +
                ", Mana: " + mana +
                ", Arma: " + armas;
    }
}
