package edu.monash.fit2099;

import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Scanner;

public class AutoShowroomDriver {
    public static void main(String[] args) throws BidException {
        AutoShowroom autoShowroom = new AutoShowroom();

        int choice;

        do{
            choice = MenuItem();
            switch(choice){
                case 1:
                    try {
                        autoShowroom.createSedan();
                    } catch (VehicleException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    autoShowroom.createTruck();
                    break;
                case 3:
                    autoShowroom.displayFleet();
                    break;
                case 4:
                    autoShowroom.createBuyer();
                    break;
                case 5:
                    autoShowroom.displayBuyers();
                    break;
                case 6:
                    autoShowroom.createBid();
                    break;
                case 7:
                    autoShowroom.getBestBid();
                    break;
                case 8:
                    autoShowroom.getWorstBid();
                    break;
                case 9:
                    autoShowroom.deleteBid();
                    break;
            }
        } while (choice!=10);
        System.out.println("Thank you for visiting FIT2099 Showroom.");
    }

    public static int MenuItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("+-------------------------------------------------+");
        System.out.println("|             Welcome to the Bidding              |");
        System.out.println("|                    System                       |");
        System.out.println("+-------------------------------------------------+");
        System.out.println("1) New Sedan");
        System.out.println("2) New Truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add Bid");
        System.out.println("7) Get best bid");
        System.out.println("8) Get worst bid");
        System.out.println("9) Delete bid");
        System.out.println("10) Exit");

        System.out.print("Select your option: ");
        int choice = scanner.nextInt();
        return choice;
    }
}


