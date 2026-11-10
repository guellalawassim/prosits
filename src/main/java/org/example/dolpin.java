package org.example;

import excepetions.InvalidAgeException;

public class Dolphin extends Aquatic {

    private float swimmingSpeed;

    public Dolphin() {
        super();
    }

    // Prosit 7 - Added throws InvalidAgeException
    public Dolphin(String family, String name, int age,
                   boolean isMammal, String habitat,
                   float swimmingSpeed) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", swimmingSpeed=" + swimmingSpeed;
    }

    @Override
    public void swim() {
        System.out.println("This dolphin is swimming");
    }
}