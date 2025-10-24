package PokemonTerminalQuest;

public class ItemCura extends Item {
    private int quantidadeCura;

    public ItemCura(String nome, String efeito, int quantidadeCura) {
        super(nome, efeito);
        this.quantidadeCura = quantidadeCura;
    }

    // Correção
    @Override
    public void aplicar(Pokemon p) {
        int novaVida = p.getVidaAtual() + this.quantidadeCura;
        if (novaVida > p.getVidaMaxima()) { // Assumindo que existe um getVidaMaxima()
            p.setVidaAtual(p.getVidaMaxima());
        } else {
            p.setVidaAtual(novaVida);
        }
    }

    //Getter

    public int getQuantidadeCura() {
        return quantidadeCura;
    }

    //Setter

    public void setQuantidadeCura(int quantidadeCura) {
        this.quantidadeCura = quantidadeCura;
    }
}
