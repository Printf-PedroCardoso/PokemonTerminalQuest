package PokemonAdventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Batalha {
    private Treinador treinador1;
    private Treinador treinador2;

    public Batalha(Treinador treinador1, Treinador treinador2) {
        this.treinador1 = treinador1;
        this.treinador2 = treinador2;
    }

    public void iniciar()
    {
        Scanner scanner = new Scanner(System.in);
        int num;
        ArrayList<Pokemon> pokedex;

        System.out.println("\n" + treinador1.getNome() + ". Qual pokemon deseja deseja selecionar? (digite o numero)");
        treinador1.listarPokemons();

        num = scanner.nextInt();
        pokedex = treinador1.getPokedex();
        Pokemon pokemon1 = pokedex.get(num-1);

        System.out.println(treinador2.getNome() + ". Qual pokemon deseja deseja selecionar? (digite o numero)");
        treinador2.listarPokemons();

        num = scanner.nextInt();
        pokedex = treinador2.getPokedex();
        Pokemon pokemon2 = pokedex.get(num-1);

        registrarTurno(pokemon1, pokemon2);
    }

    public void registrarTurno(Pokemon pokemon1, Pokemon pokemon2)
    {
        Scanner scanner = new Scanner(System.in);
        int turno=1, opcao;
        boolean sair = false, valido = false;
        Pokemon pokemonAtacante, pokemonOponente;

        while (!sair) {

            if (turno % 2 == 1) {
                pokemonAtacante = pokemon1;
                pokemonOponente = pokemon2;
            }
            else {
                pokemonAtacante = pokemon2;
                pokemonOponente = pokemon1;
            }

            System.out.println("O que o " + pokemonAtacante.getNome() + " vai fazer?");
            System.out.println("1. Atacar");
            System.out.println("2. Mochila");
            System.out.println("3. Fugir");

            do {
                opcao = scanner.nextInt();
                valido = true;

                switch (opcao) {
                    case 1:
                        Habilidade habilidadeEscolhida = pokemonAtacante.atacar();
                        int dano = habilidadeEscolhida.getPoder();

                        System.out.println(pokemonAtacante.getNome()
                                + " usou "
                                + habilidadeEscolhida.getNome()
                                + " e deu " + dano + " de dano em "
                                + pokemonOponente.getNome());

                        pokemonOponente.receberDano(dano);

                        if (pokemonOponente.getVidaAtual() < 0)
                            pokemonOponente.setVidaAtual(0);

                        System.out.println(pokemonOponente.getNome() + " ficou com "
                                + pokemonOponente.getVidaAtual() + " pontos de vida");
                        break;
                    case 2:
                        System.out.println("Escolha um item para utilizar no pokemon");
                        ArrayList<Item> Itens = pokemonAtacante.getItens();
                        Item item;
                        int num;

                        for ( int i = 0 ; i < Itens.size() ; i++)
                        {
                            item = Itens.get(i);
                            System.out.println(i+1 + ". " + item.getNome() + " / "
                                                + item.getEfeito());
                        }

                        num = scanner.nextInt();
                        item = Itens.get(num-1);

                        System.out.println(pokemonAtacante.getNome() + " usou "
                                            + item.getNome());

                        item.aplicar(pokemonAtacante);

                        break;
                    case 3:
                        sair = true;
                        break;
                    default:
                        System.out.println("Escolha inválida. Digite um número de escolha válido. Tente novamente:");
                        valido = false;
                }
            } while (!valido);

            if (pokemonOponente.getVidaAtual() == 0)
            {
                int nivelUpado = 3;
                System.out.println(pokemonOponente.getNome() + " foi com Deus");
                System.out.println(pokemonAtacante.getNome() + " venceu a batalha e subiu "
                        + nivelUpado + " nive" + (nivelUpado>1 ? "is" : "l"));
                pokemonAtacante.setNivel(pokemonAtacante.getNivel() + nivelUpado);
                pokemonAtacante.verificarEvolucaoPorNivel();
                sair = true;
            }
            turno++;
        }
    }
}
