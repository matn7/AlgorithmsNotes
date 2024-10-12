package udemy.faang;

import java.util.*;

public class MonarchyTree implements Monarchy {

    String name;
    Person root;
    Map<String, Person> familyTree;

    public MonarchyTree(String name) {
        this.name = name;
        this.root = new Person(name);
        this.familyTree = new HashMap<>();
        this.familyTree.put(name, this.root);
    }

    @Override
    public void birth(String child, String parent) {
        Person parentNode = this.familyTree.get(parent);
        Person newChild = parentNode.addChildren(child);
        this.familyTree.put(child, newChild);
    }

    @Override
    public void death(String name) {
        Person person = this.familyTree.get(name);
        person.alive = false;
    }

    @Override
    public List<String> getOrderOfSuccession() {
        List<String> order = new ArrayList<>();
        Person current = this.root;
        populateOrderOfSuccession(current, order);
        return order;
    }

    private void populateOrderOfSuccession(Person person, List<String> order) {
        if (root == null) {
            return;
        }
        if (person.alive) {
            order.add(person.name);
        }
        List<Person> children = person.children;
        for (Person child : children) {
            populateOrderOfSuccession(child, order);
        }
    }

    private void populateOrderOfSuccession2(Person person, List<String> order) {
        if (root == null) {
            return;
        }
        Queue<Person> queue = new LinkedList<>();
        queue.add(person);
        while (!queue.isEmpty()) {
            Person current = queue.poll();
            if (current.alive) {
                order.add(current.name);
            }
            List<Person> children = current.children;
            for (Person child : children) {
                populateOrderOfSuccession(child, order);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MonarchyTree monarchyTree = new MonarchyTree("Jake");
        monarchyTree.birth("Catherine", "Jake");
        monarchyTree.birth("Jane", "Catherine");
        monarchyTree.birth("Farah", "Jane");
        monarchyTree.birth("Tom", "Jake");
        monarchyTree.birth("Celine", "Jake");
        monarchyTree.birth("Mark", "Catherine");
        monarchyTree.birth("Peter", "Celine");
        List<String> orderOfSuccession = monarchyTree.getOrderOfSuccession();
        System.out.println();
        monarchyTree.death("Jake");
        monarchyTree.death("Jane");
        orderOfSuccession = monarchyTree.getOrderOfSuccession();
        System.out.println();
    }
}

class Person  {
    String name;
    List<Person> children;
    boolean alive;

    public Person(String name) {
        this.name = name;
        this.alive = true;
        this.children = new ArrayList<>();
    }

    public Person addChildren(String name) {
        Person newChild = new Person(name);
        this.children.add(newChild);
        return newChild;
    }
}

interface Monarchy {
    void birth(String child, String parent);
    void death(String name);
    List<String> getOrderOfSuccession();
}