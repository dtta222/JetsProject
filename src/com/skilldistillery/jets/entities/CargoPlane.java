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

public class CargoPlane extends Jet implements CargoCarrier {
    // Constructor
    CargoPlane(String model, double speed, int range, long price) {
        super(model, speed, range, price);
    }

    // Override the fly method to display information about the cargo plane
    @Override
    public void fly() {
        // Display details about the cargo plane
        System.out.println("\tModel: " + model);
        System.out.printf("\tSpeed: %.2f (MACH) or %.2f (MPH)\n", getSpeedInMach(), speed);
        System.out.printf("\tRange: %d miles\n", range);
        System.out.println("\tPrice: $" + price);
        double flightTime = (double) range / speed;
        System.out.printf("\tThe %s can fly for approximately %.2f hours.\n", model, flightTime);
        System.out.println();
    }

    // Implement the loadCargo method required by the CargoCarrier interface
    @Override
    public void loadCargo() {
        // Display a message indicating the cargo loading process
        System.out.printf("\tLoading cargo for: %s%n", model);
    }
}
