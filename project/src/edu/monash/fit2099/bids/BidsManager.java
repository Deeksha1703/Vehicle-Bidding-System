package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DS
 */

public class BidsManager {

    // the key is the buyers ID and the value is the Bid object
    private HashMap<Integer, Bid> bidsList;
    private String bestBid;
    private String worstBid;

    /**
     * Constructor for BidsManager class
     */
    public BidsManager() {
        bidsList = new HashMap<>();
    }

    /**
     * Method to create a new bid and add it to bidsList
     */
    public void addBid(Buyer buyer, double bidPrice, String bidDate) {
        try{
            Bid newBid = new Bid(Vehicle.nextID(), buyer, bidPrice, bidDate);
            bidsList.put(buyer.getBuyerId(), newBid);
        }
        catch (BidException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to display list of bids
     */
    public void displayBids() {
        for (Map.Entry e : bidsList.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    /**
     * Method to get best bid of a particular vehicle
     */
    public String displayBestBid(){
        double bestBidPrice = 0;
        for (Integer i : bidsList.keySet()) {
            if (bidsList.get(i).getPrice()>bestBidPrice){
                bestBidPrice = bidsList.get(i).getPrice();
                bestBid =  bidsList.get(i).toString();
            }
        }
        return bestBid;
    }

    /**
     * Method to get worst bid of a particular vehicle
     */
    public String displayWorstBid(){
        double worstBidPrice = Double.POSITIVE_INFINITY;
        for (Integer i : bidsList.keySet()){
            if (bidsList.get(i).getPrice()<worstBidPrice){
                worstBidPrice=bidsList.get(i).getPrice();
                worstBid = bidsList.get(i).toString();
            }
        }
        return worstBid;
    }

    /**
     * Method to delete a particular bid
     */
    public void removeBid(int bidID){
        for (Map.Entry<Integer, Bid> i:bidsList.entrySet()){
            if (i.getValue().getBidId()==bidID){
                bidsList.remove(i.getKey(), i.getValue());
            }
        }
    }
}
