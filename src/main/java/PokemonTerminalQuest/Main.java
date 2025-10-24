package PokemonTerminalQuest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ===================================================================================
        // --- SEÇÃO 1: CONFIGURAÇÃO GERAL DO MUNDO POKÉMON ---
        // ===================================================================================
        System.out.println("############################################################");
        System.out.println("###       BEM VINDO A POKEMON TERMINAL QUEST            ###");
        System.out.println("############################################################\n");

        // --- 1.1: Criando Treinadores ---
        Treinador ash = new Treinador("Ash Ketchum", 10);
        Treinador misty = new Treinador("Misty", 12);
        Treinador wildPokemonHost = new Treinador("Pokémon Selvagem", 99); // Treinador para gerenciar os selvagens

        // --- 1.2: Criando Habilidades (Moves) ---
        // Habilidades de Fogo
        Habilidade ember = new Habilidade("Ember", "Fogo", 40);
        Habilidade fireFang = new Habilidade("Fire Fang", "Fogo", 65);

        // Habilidades de Água
        Habilidade waterGun = new Habilidade("Water Gun", "Água", 40);
        Habilidade bubblebeam = new Habilidade("Bubblebeam", "Água", 65);
        Habilidade hydroPump = new Habilidade("Hydro Pump", "Água", 110);

        // Habilidades de Planta
        Habilidade vineWhip = new Habilidade("Vine Whip", "Planta", 45);
        Habilidade razorLeaf = new Habilidade("Razor Leaf", "Planta", 55);

        // Habilidades Elétricas
        Habilidade thunderShock = new Habilidade("Thunder Shock", "Elétrico", 40);
        Habilidade thunderbolt = new Habilidade("Thunderbolt", "Elétrico", 90);

        // Habilidades de Inseto
        Habilidade bugBite = new Habilidade("Bug Bite", "Inseto", 60);
        Habilidade stringShot = new Habilidade("String Shot", "Inseto", 0); // Efeito de status (não implementado)

        // Habilidades Normais
        Habilidade tackle = new Habilidade("Tackle", "Normal", 40);
        Habilidade quickAttack = new Habilidade("Quick Attack", "Normal", 40);
        Habilidade scratch = new Habilidade("Scratch", "Normal", 35);


        // --- 1.3: Criando Itens ---
        ItemCura potion = new ItemCura("Potion", "Cura 20 de HP", 20);
        ItemCura superPotion = new ItemCura("Super Potion", "Cura 50 de HP", 50);
        ItemEvolucao thunderStone = new ItemEvolucao("Pedra do Trovão", "Evolui certos tipos de Pokémon Elétrico");
        ItemEvolucao fireStone = new ItemEvolucao("Pedra do Fogo", "Evolui certos tipos de Pokémon de Fogo");
        ItemEvolucao waterStone = new ItemEvolucao("Pedra da Água", "Evolui certos tipos de Pokémon de Água");


        // --- 1.4: Criando Moldes e Cadeias Evolutivas ---

        // Cadeia Bulbasaur -> Ivysaur -> Venusaur (Nível)
        Pokemon ivysaurMolde = new Pokemon("Ivysaur", "Planta", 16);
        Pokemon venusaurMolde = new Pokemon("Venusaur", "Planta", 32);
        ArrayList<EstagioEvolutivo> cadeiaBulbasaur = new ArrayList<>(Arrays.asList(
                new EstagioEvolutivo(16, ivysaurMolde),
                new EstagioEvolutivo(32, venusaurMolde)
        ));

        // Cadeia Charmander -> Charmeleon -> Charizard (Nível)
        Pokemon charmeleonMolde = new Pokemon("Charmeleon", "Fogo", 16);
        Pokemon charizardMolde = new Pokemon("Charizard", "Fogo", 36);
        ArrayList<EstagioEvolutivo> cadeiaCharmander = new ArrayList<>(Arrays.asList(
                new EstagioEvolutivo(16, charmeleonMolde),
                new EstagioEvolutivo(36, charizardMolde)
        ));

        // Cadeia Squirtle -> Wartortle -> Blastoise (Nível)
        Pokemon wartortleMolde = new Pokemon("Wartortle", "Água", 16);
        Pokemon blastoiseMolde = new Pokemon("Blastoise", "Água", 36);
        ArrayList<EstagioEvolutivo> cadeiaSquirtle = new ArrayList<>(Arrays.asList(
                new EstagioEvolutivo(16, wartortleMolde),
                new EstagioEvolutivo(36, blastoiseMolde)
        ));

        // Cadeia Pikachu -> Raichu (Item)
        Pokemon raichuMolde = new Pokemon("Raichu", "Elétrico", 25);
        ArrayList<EstagioEvolutivo> cadeiaPikachu = new ArrayList<>(Arrays.asList(
                new EstagioEvolutivo(thunderStone.getNome(), raichuMolde)
        ));

        // Cadeia Caterpie -> Metapod -> Butterfree (Nível)
        Pokemon metapodMolde = new Pokemon("Metapod", "Inseto", 7);
        Pokemon butterfreeMolde = new Pokemon("Butterfree", "Inseto", 10);
        ArrayList<EstagioEvolutivo> cadeiaCaterpie = new ArrayList<>(Arrays.asList(
                new EstagioEvolutivo(7, metapodMolde),
                new EstagioEvolutivo(10, butterfreeMolde)
        ));


        // --- 1.5: Criando Instâncias de Pokémon para o Jogo ---
        // Pokémon Iniciais
        Pokemon pikachu = new Pokemon("Pikachu", "Elétrico", 5, cadeiaPikachu, 0);
        pikachu.setSkills(new ArrayList<>(Arrays.asList(thunderShock, quickAttack)));
        // OBS: Pela arquitetura atual, itens são adicionados diretamente no Pokémon.
        // O ideal seria o Treinador ter uma mochila.
        pikachu.setItens(new ArrayList<>(Arrays.asList(potion, thunderStone)));


        Pokemon caterpie = new Pokemon("Caterpie", "Inseto", 3, cadeiaCaterpie, 0);
        caterpie.setSkills(new ArrayList<>(Arrays.asList(tackle, stringShot)));
        caterpie.setItens(new ArrayList<>()); // Sem item inicial

        // Pokémon da Misty
        Pokemon staryu = new Pokemon("Staryu", "Água", 18);
        staryu.setSkills(new ArrayList<>(Arrays.asList(tackle, waterGun)));
        staryu.setItens(new ArrayList<>(Arrays.asList(potion)));

        Pokemon starmie = new Pokemon("Starmie", "Água", 21);
        starmie.setSkills(new ArrayList<>(Arrays.asList(bubblebeam, hydroPump)));
        starmie.setItens(new ArrayList<>(Arrays.asList(superPotion)));

        System.out.println("Configuração do mundo concluída!\n");
        System.out.println("A jornada de Ash está prestes a começar...\n");
        esperar(2000);


        // ===================================================================================
        // --- SEÇÃO 2: A JORNADA DE ASH COMEÇA ---
        // ===================================================================================
        System.out.println("############################################################");
        System.out.println("###       CAPÍTULO 1: O INÍCIO E A PRIMEIRA CAPTURA        ###");
        System.out.println("############################################################\n");

        ash.capturarPokemons(pikachu);
        ash.capturarPokemons(caterpie);

        System.out.println("\nPokémons iniciais de Ash:");
        ash.listarPokemons();
        esperar(3000);

        // ===================================================================================
        // --- SEÇÃO 3: TREINAMENTO E EVOLUÇÃO ---
        // ===================================================================================
        System.out.println("\n############################################################");
        System.out.println("###       CAPÍTULO 2: TREINANDO NA FLORESTA DE VIRIDIAN    ###");
        System.out.println("############################################################\n");

        System.out.println("Ash decide treinar seu Caterpie contra Pokémons selvagens.\n");
        esperar(2000);

        // Simulação de batalhas rápidas para ganhar XP
        Pokemon caterpieDoAsh = ash.getPokedex().get(1); // Pega o Caterpie

        // Batalha 1 -> Caterpie ganha 4 níveis
        System.out.println(caterpieDoAsh.getNome() + " (Nível " + caterpieDoAsh.getNivel() + ") encontrou um Pidgey selvagem!");
        System.out.println("Após uma batalha rápida, Caterpie venceu e subiu de nível!");
        caterpieDoAsh.setNivel(caterpieDoAsh.getNivel() + 4);
        System.out.println(caterpieDoAsh.getNome() + " agora está no nível " + caterpieDoAsh.getNivel() + ".");

        // Verificação de evolução
        // OBS: Na arquitetura atual, o método de evolução precisa ser chamado sequencialmente
        // para evoluções em cadeia. O ideal seria usar um loop 'while' dentro do método.
        caterpieDoAsh.verificarEvolucaoPorNivel(); // Caterpie (7) -> Metapod
        esperar(3000);

        // Batalha 2 -> Metapod ganha 3 níveis
        System.out.println("\n" + caterpieDoAsh.getNome() + " (Nível " + caterpieDoAsh.getNivel() + ") encontrou um Weedle selvagem!");
        System.out.println("Após outra batalha, " + caterpieDoAsh.getNome() + " venceu novamente!");
        caterpieDoAsh.setNivel(caterpieDoAsh.getNivel() + 3);
        System.out.println(caterpieDoAsh.getNome() + " agora está no nível " + caterpieDoAsh.getNivel() + ".");

        // Verificação de evolução
        caterpieDoAsh.verificarEvolucaoPorNivel(); // Metapod (10) -> Butterfree
        esperar(3000);

        System.out.println("\nO treinamento de Ash deu frutos! Pokémons atuais:");
        ash.listarPokemons();
        esperar(3000);


        // ===================================================================================
        // --- SEÇÃO 4: BATALHA DE GINÁSIO ---
        // ===================================================================================
        System.out.println("\n############################################################");
        System.out.println("###       CAPÍTULO 3: DESAFIO NO GINÁSIO DE CERULEAN       ###");
        System.out.println("############################################################\n");

        System.out.println("Ash chega ao ginásio de Cerulean para desafiar a líder, Misty!");
        misty.capturarPokemons(staryu);
        misty.capturarPokemons(starmie);

        Batalha batalhaDeGinasio = new Batalha(ash, misty);
        batalhaDeGinasio.iniciar();

        System.out.println("\nBatalha de ginásio encerrada.");
        System.out.println("\n--- ESTADO DOS TREINADORES PÓS-BATALHA ---");
        ash.listarPokemons();
        misty.listarPokemons();
        esperar(4000);


        // ===================================================================================
        // --- SEÇÃO 5: EVOLUÇÃO POR ITEM ---
        // ===================================================================================
        System.out.println("\n############################################################");
        System.out.println("###       CAPÍTULO 4: O PODER DA PEDRA DO TROVÃO           ###");
        System.out.println("############################################################\n");

        Pokemon pikachuDoAsh = ash.getPokedex().get(0);
        System.out.println("Ash está pensando se deve usar a Pedra do Trovão em seu " + pikachuDoAsh.getNome() + ".");

        // Interação com o usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja usar a 'Pedra do Trovão' no Pikachu? (s/n): ");
        String escolha = scanner.nextLine();

        if (escolha.equalsIgnoreCase("s")) {
            // OBS: Acessando o item diretamente do Pokémon, como manda a arquitetura atual.
            ItemEvolucao pedra = (ItemEvolucao) pikachuDoAsh.getItens().get(1); // Pega a pedra
            pedra.aplicar(pikachuDoAsh);
        } else {
            System.out.println("Ash decidiu não usar a pedra por enquanto.");
        }
        esperar(3000);


        // ===================================================================================
        // --- SEÇÃO 6: ESTADO FINAL ---
        // ===================================================================================
        System.out.println("\n############################################################");
        System.out.println("###               FIM DA DEMONSTRAÇÃO                    ###");
        System.out.println("############################################################\n");

        System.out.println("A jornada de Ash continua... Veja o estado final de seu time:");
        ash.listarPokemons();
        System.out.println("\n------------------------------------------------------------");

        scanner.close();
    }

    /**
     * Pausa a execução do programa por um determinado tempo em milissegundos.
     * @param milissegundos Tempo da pausa.
     */
    private static void esperar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}