package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String company;
    private String car;
    private List<String> pokemons;
    private List<String> parents;
    private List<String> children;

    public Person(String name) {
        this.name = name;
        this.company = "";
        this.car = "";
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(String company)
    {
        this.company = company;
    }
    public void setCar(String car)
    {
        this.car = car;
    }

    public List<String> getPokemons() {
        return this.pokemons;
    }

    public List<String> getParents() {
        return this.parents;
    }

    public List<String> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String result = this.name + "\nCompany:";
        if(!(this.company.isBlank()))
        result = result + "\n" + this.company;
        result = result + "\nCar:";
        if(!(this.car.isBlank()))
        result = result + "\n" + this.car;
        result = result + "\nPokemon:";
        if(!this.pokemons.isEmpty())
        for (String pokemon : this.pokemons)
        result = result + "\n" + pokemon;
        result = result + "\nParents:";
        if(!this.parents.isEmpty())
        for (String parent : this.parents)
        result = result + "\n" + parent;
        result = result + "\nChildren:";
        if(!this.children.isEmpty())
        for (String child : this.children)
        result = result + "\n" + child;
        return result;
    }
}