public class Arma {
    protected String nombreArma;
    protected int dano; //daño que infringe

    public Arma(String nombreArma, int dano) {
        this.nombreArma = nombreArma;
        this.dano = dano;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    @Override
    public String toString() {
        return nombreArma + "(Daño: " + dano + ")";
    }
}
