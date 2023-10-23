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

public abstract class Jet {
    protected String model;
    protected double speed;
    protected int range;
    protected long price;
    private final double oneMach = 767.269;

    // Constructor for initializing properties
    Jet(String model, double speed, int range, long price) {
        this.model = model;
        this.speed = speed;
        this.range = range;
        this.price = price;
    }

    // Default constructor (no-argument constructor)
    Jet() {}

    // Abstract method for simulating flight (to be implemented by subclasses)
    public abstract void fly();

    // Calculate and return speed in Mach units
    public double getSpeedInMach() {
        return speed / oneMach;
    }
}

