package org.example;

import excepetions.InvalidAgeException;

public class Penguin extends Aquatic {

    private float swimmingDepth;

    public Penguin() {
        super();
    }

    // Prosit 7 - Added throws InvalidAgeException
    public Penguin(String family, String name, int age,
                   boolean isMammal, String habitat,
                   float swimmingDepth) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", swimmingDepth=" + swimmingDepth;
    }

    @Override
    public void swim() {
        System.out.println("This penguin is swimming");
    }
}