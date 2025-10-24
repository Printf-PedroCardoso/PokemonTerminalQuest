package PokemonAdventure;

public class Habilidade {
    private String nome;
    private String tipo;
    private int poder;

    public Habilidade(String nome, String tipo, int poder) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
    }

    public void usar ()
    {
        System.out.println("A habilidade " + this.nome + "do tipo "
                + this.tipo + " foi usada!");
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

}
