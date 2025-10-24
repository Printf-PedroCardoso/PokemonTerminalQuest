# 🎮 Pokémon Terminal Quest

**Pokémon Terminal Quest** é um projeto em Java que simula batalhas, evolução e uso de itens entre treinadores Pokémon — inspirado no universo clássico da franquia Pokémon.  
O objetivo é exercitar conceitos fundamentais de **Programação Orientada a Objetos (POO)**, como herança, polimorfismo, encapsulamento e abstração, dentro de uma aplicação divertida e modular.

---

## 🧩 Estrutura do Projeto

O sistema é composto por diversas classes, cada uma representando um aspecto do mundo Pokémon:

| Classe | Descrição |
|--------|------------|
| `Main` | Ponto de entrada do programa. Cria os objetos principais (Pokémons, Itens, Treinadores) e executa uma simulação de batalha. |
| `Pokemon` | Representa um Pokémon, com atributos como nome, tipo, HP, nível, estágio evolutivo e habilidades. |
| `EstagioEvolutivo` | Define os estágios de evolução de um Pokémon e suas condições para evoluir. |
| `Habilidade` | Modela uma habilidade que um Pokémon pode usar em batalha, com nome, dano e tipo. |
| `Item` | Classe abstrata base para todos os tipos de itens. |
| `ItemCura` | Herda de `Item`; restaura a vida de um Pokémon. |
| `ItemEvolucao` | Herda de `Item`; permite evoluir um Pokémon que esteja apto. |
| `Treinador` | Representa um treinador, com uma lista de Pokémon e itens disponíveis. Controla ações durante a batalha. |
| `Batalha` | Gerencia o fluxo de uma batalha entre dois treinadores, controlando ataques, uso de itens e evolução. |

---

## ⚙️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Conceitos aplicados:**  
  - Herança e polimorfismo  
  - Classes e objetos  
  - Encapsulamento  
  - Enumerações (`enum`)  
  - Estruturas de controle e lógica de combate  

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Printf-PedroCardoso/PokemonTerminalQuest.git
   ```

2. **Entre na pasta do projeto:**
   ```bash
   cd PokemonTerminalQuest
   ```

3. **Compile os arquivos Java:**
   ```bash
   javac *.java
   ```

4. **Execute o programa:**
   ```bash
   java Main
   ```

---

## 🧠 Conceitos de POO Aplicados

Este projeto foi desenvolvido como exercício prático de **modelagem orientada a objetos**, demonstrando:

- **Herança:**  
  `ItemCura` e `ItemEvolucao` herdam de `Item`.

- **Polimorfismo:**  
  Métodos sobrepostos em classes derivadas (como diferentes ações de itens).

- **Encapsulamento:**  
  Atributos privados com getters e setters controlando o acesso.

- **Abstração:**  
  Classe `Item` serve como modelo genérico para outros tipos de itens.

---

## ⚔️ Exemplo de Execução (Simulação)

```text
Ash escolhe Pikachu!
Gary escolhe Charmander!

➡️ Pikachu usa Choque do Trovão! (Dano: 25)
⬅️ Charmander usa Brasas! (Dano: 20)

Pikachu está quase evoluindo...
Ash usa Pedra do Trovão! ⚡
Pikachu evoluiu para Raichu!

🏆 Raichu venceu a batalha!
```

---

## 🧑‍💻 Autor

**Pedro Cardoso**  
Estudante de Ciência da Computação e entusiasta de programação orientada a objetos.  
GitHub: [Printf-PedroCardoso](https://github.com/Printf-PedroCardoso)

---

## 📄 Licença

Este projeto é distribuído sob a licença **MIT**.  
Sinta-se livre para usar, modificar e distribuir com os devidos créditos.

---

## 🌟 Sugestões Futuras

- Interface gráfica (JavaFX ou Swing)
- Sistema de tipos e fraquezas entre Pokémon
- Persistência de dados (salvar progresso)
- Batalhas multiplayer (via rede ou socket)
```
