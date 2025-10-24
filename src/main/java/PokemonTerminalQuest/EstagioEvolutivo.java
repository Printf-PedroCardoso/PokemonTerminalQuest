package PokemonTerminalQuest;

public class EstagioEvolutivo {
    private int nivelParaEvoluir;
    private String itemParaEvoluir;
    private Pokemon pokemonResultado;

    // Construtor principal que aceita tudo
    public EstagioEvolutivo(int nivel, String item, Pokemon resultado) {
        this.nivelParaEvoluir = nivel;
        this.itemParaEvoluir = item;
        this.pokemonResultado = resultado;
    }

    // Construtor conveniente para evolução APENAS POR NÍVEL
    public EstagioEvolutivo(int nivel, Pokemon resultado) {
        this(nivel, null, resultado); // O item é nulo
    }

    // Construtor conveniente para evolução APENAS POR ITEM
    public EstagioEvolutivo(String item, Pokemon resultado) {
        this(1, item, resultado); // O nível pode ser 1 (ou qualquer valor baixo), pois não será usado como condição principal
    }

    // Getters
    public int getNivelParaEvoluir() {
        return nivelParaEvoluir;
    }

    public String getItemParaEvoluir() {
        return itemParaEvoluir;
    }

    public Pokemon getPokemonResultado() {
        return pokemonResultado;
    }
}