package Pokemon_Trainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Trainer> list = new ArrayList();
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("Tournament")) {
            String trainerName = input[0];
            Trainer trainer = new Trainer(trainerName);
            String pokemonName = input[1];
            String pokemonElement = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);
            if (!list.stream().anyMatch(e -> e.getName().equals(trainerName)))
                list.add(trainer);
            list.stream().filter(e -> e.getName().equals(trainerName)).findFirst().get()
                    .addPokemon(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            ;
            input = scanner.nextLine().split("\\s+");
        }
        input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("End")) {
            String element = input[0];
            for (Trainer trainer : list) {
                List<Pokemon> temp = trainer.getPokemons();
                if (temp.stream().anyMatch(e -> e.getElement().equals(element)))
                    trainer.addBadge();
                else {
                    trainer.getPokemons().forEach(Pokemon::loseHP);
                    trainer.getPokemons().removeIf(e -> e.getHealth() <= 0);
                }
            }
            input = scanner.nextLine().split("\\s+");
        }
        list.stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(e -> System.out.println(e.toString()));
    }
}
