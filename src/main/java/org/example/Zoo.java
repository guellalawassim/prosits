package org.example;

public class Zoo {

    private Animal[] animals;
    private String name;
    private String city;
    private int nbrAnimals;

    // Prosit 7: reduced to 3 for testing
    public static final int NBR_CAGES = 3;

    private Aquatic[] aquaticAnimals;
    private int nbrAquaticAnimals;

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        animals = new Animal[NBR_CAGES];

        aquaticAnimals = new Aquatic[10];
        nbrAquaticAnimals = 0;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Zoo name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public void displayZoo() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + NBR_CAGES);
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + NBR_CAGES +
                '}';
    }

    public boolean isZooFull() {
        return nbrAnimals >= NBR_CAGES;
    }

    // Prosit 7 - Instructions 32 and 33
    public void addAnimal(Animal animal) throws ZooFullException {

        if (animal == null) {
            return;
        }

        // Reject duplicate animals
        if (searchAnimal(animal) != -1) {
            System.out.println("Animal already exists: "
                    + animal.getName());
            return;
        }

        // Throw exception instead of returning false
        if (nbrAnimals >= animals.length) {
            throw new ZooFullException(
                    "The zoo is full! Cannot add "
                            + animal.getName());
        }

        animals[nbrAnimals] = animal;
        nbrAnimals++;
    }

    public void displayAnimals() {
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        if (animal == null) {
            return -1;
        }

        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }

        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals) {
            return z1;
        }
        return z2;
    }

    // Prosit 6
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquatic != null &&
                nbrAquaticAnimals < aquaticAnimals.length) {
            aquaticAnimals[nbrAquaticAnimals] = aquatic;
            nbrAquaticAnimals++;
        }
    }

    public void makeAquaticsSwim() {
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0;

        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];

                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphins = 0;
        int penguins = 0;

        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguins++;
            }
        }

        System.out.println("Number of dolphins: " + dolphins);
        System.out.println("Number of penguins: " + penguins);
    }
}