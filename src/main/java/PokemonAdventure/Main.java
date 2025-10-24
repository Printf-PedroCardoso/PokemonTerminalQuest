package PokemonAdventure;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // --- Seção 1: Configuração Inicial (Treinadores e Moldes de Pokémon) ---
        System.out.println("### INICIANDO CONFIGURAÇÃO DO JOGO ###");

        // Criando Treinadores
        Treinador ash = new Treinador("Ash Ketchum", 10);
        Treinador misty = new Treinador("Misty", 12);

        // --- Criando as Cadeias Evolutivas ---

        // 1. Cadeia Evolutiva do Squirtle (Evolução por Nível)
        ArrayList<EstagioEvolutivo> cadeiaSquirtle = new ArrayList<>();
        Pokemon wartortleMolde = new Pokemon("Wartortle", "Água", 16);
        Pokemon blastoiseMolde = new Pokemon("Blastoise", "Água", 36);
        cadeiaSquirtle.add(new EstagioEvolutivo(16, wartortleMolde)); // Squirtle -> Wartortle no Nv. 16
        cadeiaSquirtle.add(new EstagioEvolutivo(36, blastoiseMolde)); // Wartortle -> Blastoise no Nv. 36

        // 2. Cadeia Evolutiva do Pikachu (Evolução por Item)
        ArrayList<EstagioEvolutivo> cadeiaPikachu = new ArrayList<>();
        Pokemon raichuMolde = new Pokemon("Raichu", "Elétrico", 25);
        // A evolução ocorre com o item "Pedra do Trovão", independentemente do nível
        cadeiaPikachu.add(new EstagioEvolutivo("Pedra do Trovão", raichuMolde));

        // --- Criando os Pokémons para captura ---
        Pokemon squirtle = new Pokemon("Squirtle", "Água", 7, cadeiaSquirtle, 0);
        Pokemon pikachu = new Pokemon("Pikachu", "Elétrico", 10, cadeiaPikachu, 0);
        Pokemon staryu = new Pokemon("Staryu", "Água", 9); // Pokémon sem evolução para simplificar

        System.out.println("Criando e atribuindo habilidades...");

        // 1. Habilidades Elétricas e Normais
        Habilidade thunderShock = new Habilidade("Thunder Shock", "Elétrico", 50);
        Habilidade quickAttack = new Habilidade("Quick Attack", "Normal", 14);

        // 2. Habilidades de Água e Normais
        Habilidade waterGun = new Habilidade("Water Gun", "Água", 40);
        Habilidade tackle = new Habilidade("Tackle", "Normal", 23);
        Habilidade bubble = new Habilidade("Bubble", "Água", 13);

        // --- Criando e atribuindo os "movesets" ---

        // Moveset do Pikachu
        ArrayList<Habilidade> skillsPikachu = new ArrayList<>();
        skillsPikachu.add(thunderShock);
        skillsPikachu.add(quickAttack);
        pikachu.setSkills(skillsPikachu);

        // Moveset do Squirtle
        ArrayList<Habilidade> skillsSquirtle = new ArrayList<>();
        skillsSquirtle.add(waterGun);
        skillsSquirtle.add(tackle);
        squirtle.setSkills(skillsSquirtle);

        // Moveset do Staryu
        ArrayList<Habilidade> skillsStaryu = new ArrayList<>();
        skillsStaryu.add(bubble);
        skillsStaryu.add(tackle);
        staryu.setSkills(skillsStaryu);


        System.out.println("Configuração concluída.\n");

        // --- Seção 2: Teste de Captura de Pokémons ---
        System.out.println("### TESTE 1: Captura de Pokémons ###");
        ash.capturarPokemons(pikachu);
        ash.capturarPokemons(squirtle);

        misty.capturarPokemons(staryu);

        System.out.println("\nListando Pokémons após a captura:");
        ash.listarPokemons();
        misty.listarPokemons();
        System.out.println("----------------------------------------\n");


        // --- Seção 3: Teste de Aplicação de Item de Cura ---
        System.out.println("### TESTE 2: Uso de Item de Cura ###");
        Pokemon pikachuDoAsh = ash.getPokedex().get(0);
        System.out.println(pikachuDoAsh.getNome() + " (antes da cura): HP " + pikachuDoAsh.getVidaAtual());

        // Simulando dano
        pikachuDoAsh.setVidaAtual(15);
        System.out.println(pikachuDoAsh.getNome() + " foi ferido e está com " + pikachuDoAsh.getVidaAtual() + " de HP.");

        // Usando o item de cura que já vem no Pokémon por padrão
        Item pocao = pikachuDoAsh.getItens().get(0); // Pega a "Pocao de cura"
        System.out.println(ash.getNome() + " usa " + pocao.getNome() + " em " + pikachuDoAsh.getNome() + ".");
        pocao.aplicar(pikachuDoAsh); // Aplica o efeito

        System.out.println(pikachuDoAsh.getNome() + " (depois da cura): HP " + pikachuDoAsh.getVidaAtual());
        System.out.println("----------------------------------------\n");


        // --- Seção 4: Teste de Evolução por Item ---
        System.out.println("### TESTE 3: Evolução por Item ###");
        System.out.println("Ash vai tentar evoluir seu " + pikachuDoAsh.getNome() + ".");

        // Pegando a "Pedra do Trovão" que já vem no Pokémon por padrão
        ItemEvolucao pedraDoTrovao = (ItemEvolucao) pikachuDoAsh.getItens().get(1);
        pedraDoTrovao.aplicar(pikachuDoAsh);

        System.out.println("\nListando Pokémons do Ash após a tentativa de evolução:");
        ash.listarPokemons();
        System.out.println("----------------------------------------\n");


        // --- Seção 5: Teste de Evolução por Nível ---
        System.out.println("### TESTE 4: Evolução por Nível ###");
        Pokemon squirtleDoAsh = ash.getPokedex().get(1);
        System.out.println(squirtleDoAsh.getNome() + " ganhou muita experiência e subiu para o nível 40!");
        squirtleDoAsh.setNivel(40);

        // Primeira verificação de evolução (deverá evoluir para Wartortle)
        squirtleDoAsh.verificarEvolucaoPorNivel();
        // Segunda verificação (agora como Wartortle, deverá evoluir para Blastoise)
        squirtleDoAsh.verificarEvolucaoPorNivel();

        System.out.println("\nListando Pokémons do Ash após a evolução por nível:");
        ash.listarPokemons();
        System.out.println("----------------------------------------\n");


        // --- Seção 6: Teste de Batalha e Resultado Final ---
        System.out.println("### TESTE 5: Batalha Pokémon! ###");
        System.out.println("Uma batalha está prestes a começar entre " + ash.getNome() + " e " + misty.getNome() + "!");

        Batalha batalhaFinal = new Batalha(ash, misty);
        batalhaFinal.iniciar(); // A batalha ocorrerá aqui

        System.out.println("\nBatalha encerrada.");
        System.out.println("\n--- ESTADO FINAL DOS TREINADORES ---");
        ash.listarPokemons();
        misty.listarPokemons();
        System.out.println("----------------------------------------");
    }
}