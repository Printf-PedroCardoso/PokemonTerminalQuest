package PokemonAdventure;

import java.util.ArrayList;

public class Treinador {

    private String nome;
    private int idade;
    private ArrayList<Pokemon> pokedex = new ArrayList<>();

    public Treinador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void capturarPokemons(Pokemon p) {
        if (p != null) {
            this.pokedex.add(p);
            System.out.println(p.getNome() + " Lv:"
                    + p.getNivel() + " foi capturado por "
                        + this.nome + " com sucesso!");
        }
    }

    public void listarPokemons() {
        System.out.println("--- Pokémons de " + this.nome + " ---");

        if (pokedex.isEmpty()) {
            System.out.println("Nenhum Pokémon na Pokédex.");
        } else {
            for (int i = 0 ; i < pokedex.size() ; i++ ) {
                Pokemon pokemon = pokedex.get(i);
                System.out.println(
                    i+1 + ". "
                    + pokemon.getNome() + " / Lv:"
                    + pokemon.getNivel() + " / Hp:"
                    + pokemon.getVidaAtual() + "/"
                    + pokemon.getVidaMaxima() + " / "
                    + pokemon.getTipo());
            }
            //System.out.println("Total de Pokémons: " + pokedex.size());
            //System.out.println("---------------------------");
        }
    }

    // Getters

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public ArrayList<Pokemon> getPokedex() {
        return pokedex;
    }

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPokedex(ArrayList<Pokemon> pokedex) {
        this.pokedex = pokedex;
    }

}
