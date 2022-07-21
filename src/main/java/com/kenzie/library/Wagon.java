package com.kenzie.library;

public class Wagon {
    private int capacity;
    private Traveler[] passengers;

    public Wagon(int capacity) {
        this.capacity = capacity;
        this.passengers = new Traveler[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Traveler[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Traveler[] passengers) {
        this.passengers = passengers;
    }

    public int getAvailableSeatCount() {
        int numTravelers = 0;

        for (int i = 0; i < capacity; i++) {
            if (passengers[i] != null) {
                numTravelers++;
            }
        }

        return capacity - numTravelers;
    }

    public void join(Traveler traveler) {
        int availableSlot = capacity - getAvailableSeatCount();

        if (availableSlot < capacity) {
            passengers[availableSlot] = traveler;
        }
    }

    public boolean shouldQuarantine() {
        boolean someoneUnhealthy = false;

        for (int i = 0; i < capacity - getAvailableSeatCount(); i++) {
            if (!passengers[i].getIsHealthy()) {
                someoneUnhealthy = true;
            }
        }

        return someoneUnhealthy;
    }

    public int totalFood() {
        int totalFood = 0;

        for (int i = 0; i < capacity - getAvailableSeatCount(); i++) {
            totalFood += passengers[i].getFood();
        }

        return totalFood;
    }

    public void loadWagon(int numTravelers, int numHunters, int numDoctors) {
        int totalNumToAdd = numTravelers + numHunters + numDoctors;
        int numTravelerToAdd, numHunterToAdd, numDoctorToAdd;

        if (totalNumToAdd > capacity) {
            totalNumToAdd = capacity;
        }

        if (totalNumToAdd >= numTravelers) {
            numTravelerToAdd = numTravelers;
        } else {
            numTravelerToAdd = capacity;
        }

        if (totalNumToAdd - numTravelerToAdd > 0 && numTravelerToAdd + numHunters <= capacity) {
            numHunterToAdd = numHunters;
        } else if (numTravelerToAdd + numHunters > capacity) {
            numHunterToAdd = capacity - numTravelerToAdd;
        } else {
            numHunterToAdd = 0;
        }

        if (totalNumToAdd - numTravelerToAdd - numHunterToAdd > 0
                && numTravelerToAdd + numHunterToAdd + numDoctors <= capacity) {
            numDoctorToAdd = numDoctors;
        } else if (numTravelerToAdd + numHunterToAdd + numDoctors > capacity) {
            numDoctorToAdd = capacity - numTravelerToAdd - numHunterToAdd;
        } else {
            numDoctorToAdd = 0;
        }

        for (int i = 0; i < numTravelerToAdd; i++) {
            this.join(new Traveler());
        }
        for (int i = 0; i < numHunterToAdd; i++) {
            this.join(new Hunter());
        }
        for (int i = 0; i < numDoctorToAdd; i++) {
            this.join(new Doctor());
        }
    }
}
