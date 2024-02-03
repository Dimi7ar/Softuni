package Family_Tree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birth;
    private List<Person> parents;
    private List<Person> children;

    public Person(String string) {
        if (string.split("\\s+").length == 2) {
            this.name = string;
            this.birth = "";
        } else {
            this.name = "";
            this.birth = string;
        }
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, String birth) {
        this.name = name;
        this.birth = birth;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }

    public String getBirth() {
        return this.birth;
    }

    @Override
    public String toString() {
        String result = this.name + " " + this.birth + "\nParents:";
        if (!this.parents.isEmpty())
            for (Person parent : this.parents)
                result = result + "\n" + parent.name + " " + parent.birth;
        result = result + "\nChildren:";
        if (!this.children.isEmpty())
            for (Person child : this.children)
                result = result + "\n" + child.name + " " + child.birth;
        return result;
    }
}