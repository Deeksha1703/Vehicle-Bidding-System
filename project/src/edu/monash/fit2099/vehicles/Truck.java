package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;

/**
 *
 * @author DS
 */
public class Truck extends Vehicle {

    private int wheels;
    private int seats;

    /**
     * @param maker - maker of Truck
     * @param model - model of Truck
     * @param seats - number of seats of Truck
     * @param wheels - number of wheels of Truck
     * @throws TruckException
     */

    public Truck(String maker, String model, int seats, int wheels) throws TruckException, VehicleException {
        super(maker, model);
        if (this.setWheels(wheels) && this.setSeats(seats)) {
            this.setWheels(wheels);
            this.setSeats(seats);
        } else {
            throw new TruckException("Number of wheels must be between 4 and 16 & capacity must be between 1 and 15");
        }
    }

    /**
     * Get  value of wheels
     * @return value of wheels
     */
    public int getWheels() {
        return wheels;
    }

    /**
     * Set  value of wheels
     * @param wheels - a new value of wheels
     * @return true/false
     */

    public boolean setWheels(int wheels) {

        boolean isValid = false;
        if (wheels >= 4 && wheels <= 16) {
            isValid = true;
            this.wheels = wheels;
        }
        return isValid;

    }
    /**
     * Get value of capacity
     * @return value of capacity
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Set value of capacity
     * @param seats- a new value of capacity
     * @return true/false
     */

    public boolean setSeats(int seats) {

        boolean isValid = false;
        if (seats >= 1 && seats <= 15) {
            isValid = true;
            this.seats = seats;
        }
        return isValid;

    }

    @Override
    public String toString() {
        return "Truck [" + super.toString() + ", Capacity: " + seats
                + ", Wheels: " + wheels + ", Vehicle ID: " + super.getVId() + " ]";
    }


}

