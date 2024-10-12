package august_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoyalFamily implements Monarchy {

    private final Person king;
    private final Map<String, Person> familyMembers;

    public RoyalFamily(String name) {
        this.king = new Person(name);
        familyMembers = new HashMap<>();
        familyMembers.put(name, king);
    }

    @Override
    public void birth(String childName, String parentName) {
        if (!familyMembers.containsKey(parentName)) {
            throw new RuntimeException("Family member does not exists!");
        }
        Person parent = familyMembers.get(parentName);
        Person child = new Person(childName);
        parent.addChildren(child);
        familyMembers.put(childName, child);
    }

    @Override
    public void death(String name) {
        if (!familyMembers.containsKey(name)) {
            throw new RuntimeException("Family member does not exists!");
        }
        Person person = familyMembers.get(name);
        person.die();
    }

    @Override
    public List<Person> getOrderOfSuccession() {
        List<Person> orderOfSuccession = new ArrayList<>();
        dfs(king, orderOfSuccession);
        return orderOfSuccession;
    }

    private void dfs(Person person, List<Person> orderOfSuccession) {
        if (person.isAlive()) {
            orderOfSuccession.add(person);
        }
        List<Person> childrens = person.getChildrens();
        for (Person child : childrens) {
            dfs(child, orderOfSuccession);
        }
    }
}

class MainTest {
    public static void main(String[] args) {
        RoyalFamily royalFamily = new RoyalFamily("Jack");

        royalFamily.birth("Catchy", "Jack");
        royalFamily.birth("Tom", "Jack");
        royalFamily.birth("Jane", "Catchy");
        royalFamily.birth("Celie", "Jack");
        royalFamily.birth("Mark", "Catchy");
        royalFamily.birth("Peter", "Celie");
        royalFamily.birth("Farah", "Jane");

        royalFamily.death("Jack");
        royalFamily.death("Celie");

        List<Person> orderOfSuccession = royalFamily.getOrderOfSuccession();
        for (Person person : orderOfSuccession) {
            System.out.print(person.getName() + " -> ");
        }

    }
}

interface Monarchy {
    void birth(String childName, String parentName);
    void death(String name);
    List<Person> getOrderOfSuccession();
}

class Person {
    private final String name;
    private boolean isAlive;
    private final List<Person> childrens;

    public Person(String name) {
        this.name = name;
        this.isAlive = true;
        this.childrens = new ArrayList<>();
    }

    public void addChildren(Person child) {
        this.childrens.add(child);
    }

    public void die() {
        this.isAlive = false;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public List<Person> getChildrens() {
        return childrens;
    }
}