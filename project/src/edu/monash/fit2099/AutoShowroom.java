package edu.monash.fit2099;


import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DS
 */

public class AutoShowroom {

    private ArrayList<Vehicle> vehicles = new ArrayList();
    private ArrayList<Buyer> buyers = new ArrayList();
    private Buyer buyer;

    /**
     * Method to create a new Sedan and add it to the vehicles arraylist
     * @throws SedanException, VehicleException
     * @see Sedan
     */
    public void createSedan()throws SedanException, VehicleException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the maker of Sedan: ");
        String maker = sc.nextLine();
        System.out.print("Enter the model of Sedan: ");
        String model = sc.nextLine();
        System.out.print("Enter the number of seats of Sedan: ");
        int seats = sc.nextInt();
        try{
            Sedan newSedan = new Sedan(maker, model, seats);
            vehicles.add(newSedan);
        }
        catch (SedanException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to create a new Truck and add it to the vehicles arraylist
     * @see Truck
     */
    public void createTruck() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the maker of the Truck: ");
        String maker = sc.nextLine();
        System.out.println("Enter the model of the Truck: ");
        String model = sc.nextLine();
        int seats;
        while (true) {
            try {
                System.out.println("Enter the number of seats of the Truck: ");
                seats = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
                System.out.println("Invalid Entry");
            }
        }
        int wheels;
        while (true) {
            try {
                System.out.println("Enter number of wheels of the Truck: ");
                wheels = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
                System.out.println("Invalid Entry");
            }
        }

        try {
            vehicles.add(new Truck(maker, model, seats, wheels));
        } catch (TruckException truckException) {
            System.out.println(truckException.getMessage());
        } catch (VehicleException vehicleException) {
            System.out.println(vehicleException.getMessage());
        }

    }

    /**
     * Method to create a new buyer and add it to the buyers arraylist
     * @see Buyer
     */
    public void createBuyer() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the buyer's given name: ");
        String givenName = sc.nextLine();
        System.out.print("Enter the buyer's family name: ");
        String familyName = sc.nextLine();

        Buyer newBuyer = Buyer.getInstance(givenName, familyName);
        if (newBuyer != null){
            buyers.add(newBuyer);
        }else{
            System.out.println("Something wrong with the buyer's values!!!");
        }
    }

    /**
     * Method to create a new bid and add it to BidsManager
     * @throws BidException- catch runtime error from Bid class
     * @see edu.monash.fit2099.bids.Bid
     */
    public void createBid() throws BidException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the vehicle ID: ");
        int vId = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the buyer ID: ");
        int buyerID = Integer.parseInt(sc.nextLine());

        int bidId = Vehicle.nextID();

        System.out.println("Enter the bid price: ");
        double price;
        while (true) {
            try {
                price = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
                System.out.println("Invalid Entry");
            }
        }
        System.out.println("Enter the bid date[DD/MM/YYYY]: ");
        String date = sc.nextLine();

        Vehicle v = getVehicle(vId);
        v.getBids().addBid(getBuyers(buyerID), price, date);

    }

    /**
     * Method to print bid of highest value for a given vehicle
     */
    public void getBestBid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vehicle ID: ");
        int vId = sc.nextInt();

        for(Vehicle v:vehicles){
            if (vId == v.getVId()){
                System.out.println(v.getBids().displayBestBid());
            }
        }
    }

    /**
     * Method to print bid of lowest value for a given vehicle
     */
    public void getWorstBid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vehicle ID");
        int vId = sc.nextInt();

        for(Vehicle vehicle:vehicles){
            if (vId == vehicle.getVId()){
                System.out.println(vehicle.getBids().displayWorstBid());
            }
        }
    }

    /**
     * Method to delete a particular bid based on vehicle id
     */
    public void deleteBid(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vehicle ID");
        int vId = sc.nextInt();

        System.out.println("Enter bid ID");
        int bidId = sc.nextInt();

        for(Vehicle vehicle:vehicles){
            if (vId == vehicle.getVId()){
                vehicle.getBids().removeBid(bidId);
            }
        }
    }

    /**
     * Method to print list of vehicles from vehicles arrayList
     */
    public void displayFleet() {
        for (Vehicle obj : vehicles) {
            if (obj instanceof Sedan) {
                Sedan sedan = (Sedan) obj;
                System.out.println(sedan.toString());
            } else if (obj instanceof Truck) {
                Truck truck = (Truck) obj;
                System.out.println(truck.toString());
            }
            BidsManager bids = obj.getBids();
            bids.displayBids();
        }
    }

    /**
     * Method to print list of buyers from buyers arrayList
     */
    public void displayBuyers() {
        for (Buyer obj : buyers) {
            System.out.println(obj.toString());
        }
    }

    /**
     * Method to get list of vehicles from vehicles arrayList
     * @param id - id of the vehicle
     */
    public Vehicle getVehicle(int id) {
        for (Vehicle v : vehicles) {
            if (v.getVId() == id) {
                if (v instanceof Sedan) {
                    return  v;
                } else if (v instanceof Truck) {
                    return v;
                }
            }
        }
        return null;
    }

    /**
     * Method to get list of buyers from array list
     * @param id- id of the vehicle
     * @returns Buyer
     */
    public Buyer getBuyers(int id) {
        for (Buyer v : buyers) {
            if (v.getBuyerId() == id) {
                return v;
            }
        }
        return null;
    }

}
