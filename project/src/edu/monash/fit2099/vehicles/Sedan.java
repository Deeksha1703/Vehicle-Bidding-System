package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.VehicleException;

/**
 *
 * @author DS
 */

public class Sedan extends Vehicle {

    private int seats;

    /**
     * @param maker - maker of Sedan
     * @param model - model of Sedan
     * @param seats - number of seats of Sedan
     * @throws edu.monash.fit2099.exceptions.SedanException - catch runtime error in Sedan class
     */

    public Sedan(String maker, String model, int seats) throws SedanException, VehicleException {
        super(maker, model);
        if (this.setSeats(seats)) {
            this.setSeats(seats);
        } else {
            throw new SedanException("Number of seats must be between 4 and 5");
        }
    }
    /**
     * Get the value of seats
     * @return value of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Set the value of seats
     * @param seats - a new value of seats
     * @return true/false
     */

    public boolean setSeats(int seats) {

        boolean isValid = false;
        if (seats >= 4 && seats <= 5) {
            isValid = true;
            this.seats = seats;
        }
        return isValid;

    }

    @Override
    public String toString() {
        return "Sedan [" + super.toString() + ", Seats: " + seats + ", Vehicle ID: " + super.getVId() + "]";
    }

}

