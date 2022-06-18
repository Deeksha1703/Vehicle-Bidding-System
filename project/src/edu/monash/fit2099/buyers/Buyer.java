package edu.monash.fit2099.buyers;

import edu.monash.fit2099.vehicles.Vehicle;

/**
 *
 * @author DS
 */

public class Buyer {
    private int buyerId;
    private String givenName;
    private String familyName;

    /**
     * Constructor for Buyer class
     */
    private Buyer(int newBuyerId) {
        this.buyerId = newBuyerId;
    }

    /**
     * Constructor for Buyer class
     */
    private Buyer(int newBuyerId, String newGivenName, String newFamilyName) {
        this.buyerId = newBuyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    /**
     * Constructor for Buyer class
     */
    private Buyer() {
    }

    /**
     * Method to create a new instance of Buyer class
     * @returns Buyer
     */
    public static Buyer getInstance(String givenName, String familyName){
        Buyer newBuyer = new Buyer();
        newBuyer.setGivenName(givenName);
        newBuyer.setFamilyName(familyName);
        newBuyer.setBuyerId(Vehicle.nextID());
        if (newBuyer.setGivenName(givenName) && newBuyer.setFamilyName(familyName)){
            return newBuyer;
        } else{
            return null;
        }
    }

    /**
     * Set value of givenName
     *
     * @param givenName - given Name
     */
    public boolean setGivenName(String givenName) {
        boolean isValid=false;
        if(givenName.getClass().getSimpleName().equals("String") && givenName.length()>=2 && givenName.length()<=15){
            isValid=true;
            this.givenName = givenName;
        }
        return isValid;
    }

    /**
     * Set value of familyName
     *
     * @param familyName - family Name
     * @returns true/false
     */
    public boolean setFamilyName(String familyName) {
        boolean isValid=false;
        if(familyName.getClass().getSimpleName().equals("String") && familyName.length()>=2 && familyName.length()<=15){
            isValid=true;
            this.familyName = familyName;
        }
        return isValid;
    }

    /**
     * Get value of buyer id
     *
     * @return value of buyer id
     */
    public int getBuyerId() {
        return buyerId;
    }

    /**
     * Set value of buyerId
     *
     * @param buyerId - buyer id
     */
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * Method that prints buyer id, given name and family name
     */
    public String description(){
        return "Buyer ID: " + buyerId + ", Given Name: " + givenName + ", Family Name: " + familyName;
    }
    @Override
    public String toString() {
        return "Buyer{"
                + "Buyer ID: " + buyerId
                + ", Given Name: " + givenName
                + ", Family Name: " + familyName + "}" ;
    }
}

