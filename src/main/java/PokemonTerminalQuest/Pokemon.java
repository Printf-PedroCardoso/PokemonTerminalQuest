package PokemonTerminalQuest;

import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {

    private String nome;
    private String tipo;
    private int vidaMaxima;
    private int vidaAtual;
    private int nivel;
    private ArrayList<Habilidade> Skills;
    private ArrayList<Item> Itens;
    private ArrayList<EstagioEvolutivo> cadeiaEvolutiva;
    private int estagioEvolutivoAtual;


    public Pokemon(String nome, String tipo, int nivel) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vidaMaxima = nivel * 5;
        this.vidaAtual = vidaMaxima;
        this.cadeiaEvolutiva = new ArrayList<>(); // Lista vazia
        this.estagioEvolutivoAtual = 0;
        Skills = new ArrayList<>();
        Habilidade habilidade = new Habilidade("Bite", "Normal", 3);
        Skills.add(habilidade);
        Itens = new ArrayList<>();
        ItemCura pocao = new ItemCura("Pocao de cura", "Cura 10 pontos de vida", 10);
        ItemEvolucao pedraDoTrovao = new ItemEvolucao("Pedra do Trovão", "Evolui o pokemon Pikachu para Raichu");
        Itens.add(pocao);
        Itens.add(pedraDoTrovao);
    }

    public Pokemon(String nome, String tipo, int nivel, ArrayList<EstagioEvolutivo> cadeiaEvolutiva, int estagioInicial) {
        this(nome, tipo, nivel); // Chama o construtor principal
        this.cadeiaEvolutiva = cadeiaEvolutiva;
        this.estagioEvolutivoAtual = estagioInicial;
    }

    public Habilidade atacar ()
    {
        Scanner scanner = new Scanner(System.in);
        Habilidade habilidade;
        int num;

        System.out.println("\n ---Selecione uma habilidade de ataque---");
        for (int i = 0 ; i < Skills.size() ; i++)
        {
            habilidade = Skills.get(i);
            System.out.println(
                    i+1 + ". "
                    + habilidade.getNome() + " / Tipo: "
                    + habilidade.getTipo() + " / Poder: "
                    + habilidade.getPoder());
        }

        num = scanner.nextInt();
        habilidade = Skills.get(num-1);
        return habilidade;
    }

    public void receberDano(int dano)
    {
        this.vidaAtual = this.vidaAtual - dano;
    }

    public void verificarEvolucaoPorNivel() {
        if (estagioEvolutivoAtual < cadeiaEvolutiva.size()) {
            EstagioEvolutivo proximoEstagio = cadeiaEvolutiva.get(estagioEvolutivoAtual);

            // Verifica se é uma evolução por nível (item é nulo) e se o nível foi atingido
            if (proximoEstagio.getItemParaEvoluir() == null && this.nivel >= proximoEstagio.getNivelParaEvoluir()) {
                evoluir(proximoEstagio);
                this.estagioEvolutivoAtual++; // Incrementa para a próxima evolução linear
            }
        }
    }

        public void tentarEvoluirComItem(ItemEvolucao itemUsado) {
        System.out.println("Usando " + itemUsado.getNome() + " em " + this.nome + "...");

        // Procura na sua própria cadeia evolutiva por uma correspondência
        for (EstagioEvolutivo estagio : this.cadeiaEvolutiva) {

            // A condição principal: o estágio precisa de um item E o nome do item bate
            if (estagio.getItemParaEvoluir() != null && estagio.getItemParaEvoluir().equals(itemUsado.getNome())) {

                // Se encontrou, executa a lógica de evolução
                evoluir(estagio);
                return; // Para a busca, pois já evoluiu
            }
        }

        // Se o loop terminar sem encontrar uma correspondência
        System.out.println("Não teve efeito...");
    }

    // Metodo privado que realiza a evolução para não repetir código
    private void evoluir (EstagioEvolutivo estagio) {
        String nomeAntigo = this.nome;
        System.out.println("O que? " + nomeAntigo + " está evoluindo!");

        Pokemon moldeEvolucao = estagio.getPokemonResultado();
        this.nome = moldeEvolucao.getNome();
        this.tipo = moldeEvolucao.getTipo();

        if (moldeEvolucao.getNivel() > this.nivel) this.nivel = moldeEvolucao.getNivel();

        // ... Lógica de aumento de status ...
        this.vidaMaxima += 30;
        this.vidaAtual = this.vidaMaxima;

        System.out.println("Parabéns! Seu " + nomeAntigo + " evoluiu para " + this.nome + "!");
    }


    //Getters

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getNivel() {
        return nivel;
    }

    public ArrayList<Habilidade> getSkills() { return Skills;}

    public ArrayList<Item> getItens() {
        return Itens;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVidaAtual(int vida) {
        this.vidaAtual = vida;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setSkills(ArrayList<Habilidade> skills) {
        Skills = skills;
    }

    public void setItens(ArrayList<Item> itens) {
        Itens = itens;
    }
}
