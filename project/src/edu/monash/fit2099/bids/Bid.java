package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;

/**
 *
 * @author DS
 */

public class Bid {
    private int bidId;
    private Buyer buyer;
    private double price;
    private String date;

    /**
     * @param bidId - id of the bid
     * @param buyer - buyer object
     * @param price - bid price
     * @param date - bid date
     * @throws BidException - catch runtime error from Bid class
     */
    public Bid(int bidId, Buyer buyer, double price, String date) throws BidException {
        if (setBidPrice(price) && setBidDate(date)){ //CHECK BID DATE ALSO
            this.bidId = bidId;
            this.buyer = buyer;
        } else{
            throw new BidException("Incorrect price OR incorrect bid date");
        }
    }

    /**
     * Get value of bidId
     *
     * @return value of bidId
     */
    public int getBidId() {
        return bidId;
    }

    /**
     * Set value of bidId
     *
     * @param bidId - id of the bid
     */
    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    /**
     * Get value of buyer
     *
     * @return value of buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Set value of buyer
     *
     * @param buyer - buyer object
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    /**
     * Get value of price
     *
     * @return value of price
     */

    public double getPrice() {
        return price;
    }

    /**
     * Set  value of price
     *
     * @param price - a new value of price
     */
    public boolean setBidPrice(double price) {
        boolean isValid = false;
        if (price>=0){
            isValid=true;
            this.price = price;
        }
        return isValid;
    }

    /**
     * Get value of date
     *
     * @return value of date
     */
    public String getBidDate() {
        return date;
    }

    /**
     * Set the value of date
     * @param bidDate - a new value of date
     * @return true/false
     */
    public boolean setBidDate(String bidDate) {
        boolean isValid = false;
        if (!bidDate.contains("/")){
        }
        else{
            String[] dd_mm_yy = bidDate.split("/");
            int date = Integer.parseInt(dd_mm_yy[0]);
            int month = Integer.parseInt(dd_mm_yy[1]);
            int year = Integer.parseInt(dd_mm_yy[2]);
            if((date>=1 && date<=31) && (month>=1 && month<=12) && (year>=1930 && year<=2021)){
                isValid = true;
                this.date = bidDate;
            }
        }
        return isValid;
    }

    @Override
    public String toString() {
        return "Bid[bidId: " + bidId
                + ", Buyer[ " + buyer.description()
                + ", Price: " + price +
                ", Date: " + date +  "]";
    }
}
