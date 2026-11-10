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