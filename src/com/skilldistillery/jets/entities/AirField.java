//************************************************************************
//  Author: David Taylor
//  Date: 10/23/2023
//  Purpose: Jet Fleet Management Application
//
//  Description:
//  This Java application allows users to manage a fleet of jets with various capabilities. 
//  It provides a menu-driven interface to list the fleet, perform actions like flying jets,
//  viewing the fastest and longest-range jets, loading cargo for cargo planes, 
//  and initiating dogfights for fighter jets. Users can also add custom jets to the fleet 
//  and remove jets from the fleet. The program continues until the user selects the "Quit" option.
//
//************************************************************************

package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField extends Jet{
    protected List<Jet> fleet;
    Scanner scan = new Scanner(System.in);

    // Constructor
    public AirField(){
       fleet = readFile(); // Initialize the fleet by reading data from a file
    }

    @Override
    public void fly() {}

    // List details of all jets in the fleet
    public void listFleet(){
        for(Jet plane : fleet){
            // Display information about each jet
            System.out.println("\tModel: " + plane.model);
            System.out.printf("\tSpeed: %.2f (MACH) or %.2f (MPH)\n", plane.getSpeedInMach(), plane.speed);
            System.out.printf("\tRange: %d miles\n", plane.range);
            System.out.println("\tPrice: $" + plane.price);
            System.out.println();
        }
    }

    // Simulate flying all jets in the fleet
    public void flyAll(){
        for(Jet plane : fleet){
            plane.fly(); // Call the fly method for each jet
        }
    }

    // Find and display information about the fastest jet in the fleet
    public void viewFastestJet(){
        Jet fastest = fleet.get(0);
        double nextPlaneSpeed;

        for(int i = 1; i < fleet.size(); i++){
            nextPlaneSpeed = fleet.get(i).speed;
            if(nextPlaneSpeed > fastest.speed){
                fastest = fleet.get(i);
            }
        }

        System.out.printf("\tThe fastest plane is the %s.\n", fastest.model);
        fastest.fly(); // Call the fly method for the fastest jet
    }

    // Find and display information about the jet with the longest range in the fleet
    public void viewLongestRange(){
        Jet longestRange = fleet.get(0);
        int nextPlaneSpeed;

        for(int i = 1; i < fleet.size(); i++){
            nextPlaneSpeed = fleet.get(i).range;
            if(nextPlaneSpeed > longestRange.range){
                longestRange = fleet.get(i);
            }
        }
        System.out.printf("\tThe plane with the longest range is the %s.\n", longestRange.model);
        longestRange.fly(); // Call the fly method for the jet with the longest range
    }

    // Load cargo for all cargo planes in the fleet
    public void loadAllCargoJets(){
        for(Jet plane : fleet){
            if(plane instanceof CargoPlane){
                ((CargoPlane) plane).loadCargo(); // Call the loadCargo method for cargo planes
            }
        }
        System.out.println();
    }

    // Initiate combat preparations for fighter jets in the fleet
    public void dogFight(){
        for(Jet plane : fleet){
            if(plane instanceof FighterJet){
                ((FighterJet) plane).fight(); // Call the fight method for fighter jets
            }
        }
        System.out.println();
    }

    // Add a new jet to the fleet based on user input
    public void addJet(){
        int choice = 4;
        while(choice < 1 || choice > 3){
            System.out.println("\tWhat is the plane type?");

            System.out.println("\t1.) Cargo");
            System.out.println("\t2.) Fighter");
            System.out.println("\t3.) Passenger/Other");
            System.out.print("\nPlease select an option: ");
            choice = scan.nextInt();

            if(choice < 1 || choice > 3){
                System.err.println("\nInvalid input\n");
            }

        }
        scan.nextLine();

        System.out.print("\tModel of the Plane: ");
        String model = scan.nextLine();

        System.out.print("\tSpeed of the Plane (MPH): ");
        double speed = scan.nextDouble();

        System.out.print("\tRange of the Plane (miles): ");
        int range = scan.nextInt();

        System.out.print("\tPrice of the Plane: ");
        long price = scan.nextLong();

        switch (choice) {
            case 1:
                fleet.add(new CargoPlane(model, speed, range, price));
                break;
            case 2:
                fleet.add(new FighterJet(model, speed, range, price));
                break;
            case 3:
                fleet.add(new PassengerJet(model, speed, range, price));
                break;
        }
        System.out.println();
    }

    // Remove a jet from the fleet based on user input
    public void removeJet(){
        int count = 1;
        for(Jet plane : fleet){
            System.out.printf("#%d %s\n", count, plane.model);
            count++;
        }
        System.out.print("\nRemove #");
        int choice = scan.nextInt();
        System.out.printf("%s removed\n", fleet.get(choice-1).model);
        fleet.remove(choice-1);
    }

    // Read data from a file and populate the fleet
    public List<Jet> readFile() {
        List<Jet> fleet = new ArrayList<>();

        try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
            String line;
            while ((line = bufIn.readLine()) != null) {
                String[] customerRecord = line.split(", ");
                String type = customerRecord[0];
                String model = customerRecord[1];
                double speed = Double.parseDouble(customerRecord[2]);
                int range = Integer.parseInt(customerRecord[3]);
                long price = Long.parseLong(customerRecord[4]);

                if(type.equalsIgnoreCase("cargo")){
                    fleet.add(new CargoPlane(model, speed, range, price));
                }
                else if(type.equalsIgnoreCase("fighter")){
                    fleet.add(new FighterJet(model, speed, range, price));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fleet;
    }
}

