package PokemonAdventure;

public class ItemEvolucao extends Item{

    public ItemEvolucao(String nome, String efeito) {
        super(nome, efeito);
    }

    @Override
    public void aplicar(Pokemon p) {
        p.tentarEvoluirComItem(this);
    }

}
