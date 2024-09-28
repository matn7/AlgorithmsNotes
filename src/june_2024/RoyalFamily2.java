package june_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoyalFamily2 implements Monarchy2 {

    Map<String, Person2> tree;
    String familyFounder;

    public RoyalFamily2(String familyFounder) {
        this.familyFounder = familyFounder;
        this.tree = new HashMap<>();
        Person2 founder = new Person2(familyFounder);
        this.tree.put(familyFounder, founder);
    }

    @Override
    public void birth(String childName, String parentName) {
        Person2 parent = this.tree.get(parentName);
        Person2 child = new Person2(childName);
        parent.addChild(child);
        this.tree.put(childName, child);
    }

    @Override
    public void death(String name) {
        Person2 person = this.tree.get(name);
        person.died();
    }

    @Override
    public List<Person2> getOrderOfSuccession() {
        List<Person2> succession = new ArrayList<>();
        Person2 founder = this.tree.get(familyFounder);

        dfs(founder, succession);
        return succession;
    }

    private void dfs(Person2 person, List<Person2> succession) {
        if (person.isAlive()) {
            succession.add(person);
        }
        List<Person2> childrens = person.getChildrens();
        for (Person2 child : childrens) {
            dfs(child, succession);
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        RoyalFamily2 royalFamily = new RoyalFamily2("Jake");
        royalFamily.birth("Catchy", "Jake");
        royalFamily.birth("Tom", "Jake");
        royalFamily.birth("Jane", "Catchy");
        royalFamily.birth("Celie", "Jake");
        royalFamily.birth("Mark", "Catchy");
        royalFamily.birth("TomII", "Celie");
        royalFamily.birth("Farah", "Jane");
        royalFamily.birth("MarkII", "Mark");

        royalFamily.death("Tom");
        royalFamily.death("Jake");
        royalFamily.death("Catchy");

        List<Person2> orderOfSuccession = royalFamily.getOrderOfSuccession();
        System.out.println();
        for (Person2 person2 : orderOfSuccession) {
            System.out.print(person2.getName() + " -> ");
        }
    }
}

interface Monarchy2 {
    void birth(String childName, String parentName);
    void death(String name);
    List<Person2> getOrderOfSuccession();
}

class Person2 {
    private final String name;
    private boolean isAlive;
    private final List<Person2> childrens;

    public Person2(String name) {
        this.name = name;
        this.isAlive = true;
        this.childrens = new ArrayList<>();
    }

    public void addChild(Person2 child) {
        this.childrens.add(child);
    }

    public void died() {
        this.isAlive = false;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public List<Person2> getChildrens() {
        return childrens;
    }
}