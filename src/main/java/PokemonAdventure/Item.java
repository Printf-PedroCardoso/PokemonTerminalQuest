package PokemonAdventure;

public abstract class Item {
    private String nome;
    private String efeito;

    public Item(String nome, String efeito) {
        this.nome = nome;
        this.efeito = efeito;
    }

    abstract void aplicar(Pokemon p);

    // Getters

    public String getNome() {
        return nome;
    }

    public String getEfeito() {
        return efeito;
    }

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
}
