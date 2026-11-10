package org.example;

import java.util.Objects;

public abstract class Aquatic extends Animal {

    protected String habitat;

    public Aquatic() {
        super();
    }

    // Prosit 7 - Added throws InvalidAgeException
    public Aquatic(String family, String name, int age,
                   boolean isMammal, String habitat)
            throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + "'";
    }

    // Instruction 28
    public abstract void swim();

    // Instruction 31
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Aquatic)) {
            return false;
        }

        Aquatic other = (Aquatic) obj;

        return getAge() == other.getAge()
                && Objects.equals(getName(), other.getName())
                && Objects.equals(habitat, other.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), habitat);
    }
}
Imen

package org.example;

public class Main {

    public static void main(String[] args) throws InvalidAgeException {

        // ==================================
        // PROSIT 2
        // ==================================

        Zoo myZoo = new Zoo("Belvedere", "Tunis");
        Zoo zoo2 = new Zoo("Friguia", "Hammamet");

        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal elephant = new Animal("Elephantidae", "Dumbo", 10, true);
        Animal zebra = new Animal("Equidae", "Marty", 4, true);
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);

        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(lion);

        // Add animals and display count
        addAndDisplay(myZoo, lion);
        addAndDisplay(myZoo, elephant);
        addAndDisplay(myZoo, zebra);

        System.out.println("\nAnimals in myZoo:");
        myZoo.displayAnimals();

        System.out.println("\nLion index: " + myZoo.searchAnimal(lion));

        Animal lion2 = new Animal("Felidae", "Simba", 5, true);
        addAndDisplay(myZoo, lion2);

        System.out.println("Removing Dumbo: "
                + myZoo.removeAnimal(elephant));

        System.out.println("\nAnimals after removal:");
        myZoo.displayAnimals();

        // ==================================
        // PROSIT 3
        // ==================================

        System.out.println("\nIs myZoo full? "
                + myZoo.isZooFull());

        addAndDisplay(zoo2, tiger);

        Zoo biggerZoo = myZoo.compareZoo(myZoo, zoo2);
        System.out.println("\nZoo with the most animals:");
        System.out.println(biggerZoo);

        // ==================================
        // PROSIT 4
        // ==================================

        try {
            Animal invalidAnimal = new Animal(
                    "Felidae", "Test", -3, true);
        } catch (InvalidAgeException e) {
            System.out.println("\nNegative age test: "
                    + e.getMessage());
        }

        try {
            Zoo invalidZoo = new Zoo("", "Tunis");
        } catch (IllegalArgumentException e) {
            System.out.println("Empty zoo name test: "
                    + e.getMessage());
        }

        try {
            lion.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age update: "
                    + e.getMessage());
        }

        System.out.println("Lion age: " + lion.getAge());

        // ==================================
        // PROSIT 5
        // ==================================

        Aquatic aquatic = new Dolphin();
        Terrestrial terrestrial = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();

        Terrestrial terrestrial2 = new Terrestrial(
                "Felidae", "Tiger", 4, true, 4);

        Dolphin dolphin2 = new Dolphin(
                "Delphinidae", "Flipper", 5, true,
                "Ocean", 45.5f);

        Penguin penguin2 = new Penguin(
                "Spheniscidae", "Pingu", 3, false,
                "Antarctica", 100.0f);

        Penguin penguin3 = new Penguin(
                "Spheniscidae", "Pingo", 4, false,
                "Antarctica", 150.0f);

        System.out.println("\n--- PROSIT 5 ---");
        System.out.println(terrestrial2);
        System.out.println(dolphin2);
        System.out.println(penguin2);

        aquatic.swim();
        dolphin.swim();
        penguin.swim();

        // ==================================
        // PROSIT 6
        // ==================================

        myZoo.addAquaticAnimal(dolphin2);
        myZoo.addAquaticAnimal(penguin2);
        myZoo.addAquaticAnimal(penguin3);

        System.out.println("\n--- Aquatic animals swimming ---");
        myZoo.makeAquaticsSwim();

        System.out.println("\nMaximum penguin swimming depth: "
                + myZoo.maxPenguinSwimmingDepth());

        System.out.println("\nAquatic animals by type:");
        myZoo.displayNumberOfAquaticsByType();

        Dolphin sameDolphin = new Dolphin(
                "Delphinidae", "Flipper", 5, true,
                "Ocean", 60.0f);

        System.out.println("\nAre the dolphins equal? "
                + dolphin2.equals(sameDolphin));

        // ==================================
        // PROSIT 7
        // ==================================

        System.out.println("\n--- PROSIT 7 ---");

        Zoo smallZoo = new Zoo("Small Zoo", "Tunis");

        // Maximum capacity is 3
        addAndDisplay(smallZoo, lion);
        addAndDisplay(smallZoo, elephant);
        addAndDisplay(smallZoo, zebra);

        // Fourth animal triggers ZooFullException
        addAndDisplay(smallZoo, tiger);

        // Test InvalidAgeException
        try {
            Animal invalid = new Animal(
                    "Felidae", "Invalid Lion", -2, true);
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: "
                    + e.getMessage());
        }

        System.out.println("\nProsit 7 tests completed.");
    }

    // Helper method: add an animal and display the count
    public static void addAndDisplay(Zoo zoo, Animal animal) {
        try {
            zoo.addAnimal(animal);
        } catch (ZooFullException e) {
            System.out.println("Caught ZooFullException: "
                    + e.getMessage());
        }

        System.out.println("Number of animals: "
                + zoo.getNbrAnimals());
    }
}
