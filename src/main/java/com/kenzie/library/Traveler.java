package com.kenzie.library;
git
public class Traveler {
    //TODO: Code Traveler class
    protected String name;
    protected int food;
    protected boolean isHealthy;

    public Traveler() {
        this("");
    }

    public Traveler(String name) {
        this.name = name;
        this.food = 1;
        this.isHealthy = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean getIsHealthy() {
        return isHealthy;
    }

    public void setIsHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
    }

    public void hunt() {
        this.food += 2;
    }

    public void eat() {
        if (this.food > 0) {
            this.food--;
        } else {
            this.isHealthy = false;
        }
    }
}

class Doctor extends Traveler {
    //TODO: Code Doctor class
    public Doctor() {
        super();
    }

    public Doctor(String name) {
        super(name);
    }

    public void heal(Traveler traveler) {
        traveler.isHealthy = true;
    }
}

class Hunter extends Traveler {
//TODO: Code Hunter class

    public Hunter() {
        super();
        food++;
    }

    public Hunter(String name) {
        super(name);
        food++;
    }

    @Override
    public void hunt() {
        food += 5;
    }

    @Override
    public void eat() {
        if (food < 2) {
            food = 0;
            isHealthy = false;
        } else {
            food -= 2;
        }
    }

    public void giveFood(Traveler traveler, int numOfFoodUnits) {
        if (this.food >= numOfFoodUnits && numOfFoodUnits > 0) {
            this.food -= numOfFoodUnits;
            traveler.food += numOfFoodUnits;
        }
    }
}

