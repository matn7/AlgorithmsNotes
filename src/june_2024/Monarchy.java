package june_2024;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Monarchy {
    void birth(String childName, String parentName);
    void death(String name);
    List<Person> getOrderOfSuccession();
}

class RoyalFamily implements Monarchy {
    public static void main(String[] args) {
        Monarchy monarchy = new RoyalFamily("Jake");
        monarchy.birth("Catherine", "Jake");
        monarchy.birth("Jane", "Catherine");
        monarchy.birth("Farah", "Jane");
        monarchy.birth("Tom", "Jake");
        monarchy.birth("Celine", "Jake");
        monarchy.birth("Mark", "Catherine");
        monarchy.birth("Pater", "Celine");

        List<Person> orderOfSuccession = monarchy.getOrderOfSuccession();
        System.out.println();

        monarchy.death("Jake");
        monarchy.death("Jane");
        List<Person> orderOfSuccession1 = monarchy.getOrderOfSuccession();
        System.out.println();
    }

    private final Person king;
    private final Map<String, Person> persons = new HashMap<>();

    public RoyalFamily(String king) {
        this.king = new Person(king);
        this.persons.put(king, this.king);
    }

    // O(1) time
    public void birth(String childName, String parentName) {
        Person parent = this.persons.get(parentName);
        Person newChild = new Person(childName);
        parent.addChildren(newChild);
        this.persons.put(childName, newChild);
    }

    // O(1) time
    public void death(String name) {
        if (!this.persons.containsKey(name)) {
            return;
        }
        Person person = this.persons.get(name);
        person.setAlive(false);
    }

    // O(n) time
    public List<Person> getOrderOfSuccession() {
        List<Person> order = new ArrayList<>();

        dfs(this.king, order);

        return order;
    }

    private void dfs(Person currentPerson, List<Person> order) {
        if (currentPerson.isAlive()) {
            order.add(currentPerson);
        }
        List<Person> childrens = currentPerson.getChildren();
        for (Person child : childrens) {
            dfs(child, order);
        }
    }
}

class Person {
    private final String name;
    private boolean isAlive;
    private final List<Person> children;

    public Person(String name) {
        this.name = name;
        this.isAlive = true;
        this.children = new ArrayList<>();
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void addChildren(Person child) {
        this.children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }
}