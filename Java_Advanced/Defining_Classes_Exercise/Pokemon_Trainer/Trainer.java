package Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name)
    {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public int getBadges()
    {
        return this.badges;
    }

    public List<Pokemon> getPokemons()
    {
        return pokemons;
    }


    public void addPokemon(Pokemon pokemon)
    {
        this.pokemons.add(pokemon);
    }

    public void addBadge()
    {
        this.badges++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}