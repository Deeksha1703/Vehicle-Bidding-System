package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.exceptions.VehicleException;
import java.util.Random;

/**
 *
 * @author DS
 */

public abstract class Vehicle {

    private int vId;
    BidsManager bids;
    private String maker;
    private String model;

    /**
     * @param maker - maker of Vehicle
     * @param model - model of vehicle
     * @throws VehicleException - catch runtime error in vehicle class
     */

    public Vehicle(String maker, String model) throws VehicleException {
        if (this.setMaker(maker) && this.setModel(model)) {
            this.vId = nextID();
            bids = new BidsManager();
        } else {
            throw new VehicleException("Incorrect maker or model");
        }
    }

    /**
     * Get the value of model
     * @return value of model
     */
    public String getModel() {
        return model;
    }

    /**
     * Set value of model
     * @param model - a new value of model
     * @return true/false
     */

    public boolean setModel(String model) {
        boolean isValid = false;
        if (model.length() >= 3 && model.length() <= 15) {
            isValid = true;
            this.model = model;
        }
        return isValid;

    }
    /**
     * Get the value of maker
     * @return value of maker
     */
    public String getMaker() {
        return maker;
    }


    /**
     * Set the value of maker
     * @param maker - a new value of maker
     * @return true/false
     */

    public boolean setMaker(String maker) {
        boolean isValid = false;
        if (maker.length() >= 3 && maker.length() <= 15) {
            isValid = true;
            this.maker = maker;
        }
        return isValid;

    }

    /**
     * Get the value of VId
     * @return value of vId
     */
    public int getVId() {
        return vId;
    }

    /**
     * @return value of maker,model and vId
     */
    // Description() method
    public String description() {
        return "Maker:" + maker + ", Model:" + model + ", Vehicle ID:" + vId;
    }

    /**
     * @return r
     */
    public static int nextID() {
        Random r = new Random();
        return r.nextInt(99999 - 10000) + 10000;
    }

    /**
     * Get the value of bids
     * @return value of bids
     */
    public BidsManager getBids() {
        return bids;
    }

    @Override
    public String toString() {
        return ("Model: " + this.model + " Make: " + this.maker);
    }

}
