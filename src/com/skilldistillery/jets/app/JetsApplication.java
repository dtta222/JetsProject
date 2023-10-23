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

package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {

    Scanner scan = new Scanner(System.in);
    private AirField airField = new AirField();

    public static void main(String[] args) {
        JetsApplication jetsApplication = new JetsApplication();
        jetsApplication.launch();
    }

    public void launch() {
        displayUserMenu();
    }

    public void displayUserMenu() {
        boolean quit = false;

        while (!quit) {
            printMenu();
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
	            case 1:
	                System.out.println("\nListing Planes..........");
	                System.out.println("---------------------------------------");
	                airField.listFleet();
	                break;
	            case 2:
	                System.out.println("\nFlying Planes..........");
	                System.out.println("---------------------------------------");
	                airField.flyAll();
	                break;
	            case 3:
	                System.out.println("\nFinding Fastest Plane..........");
	                System.out.println("---------------------------------------");
	                airField.viewFastestJet();
	                break;
	            case 4:
	                System.out.println("\nFinding Longest Range..........");
	                System.out.println("---------------------------------------");
	                airField.viewLongestRange();
	                break;
	            case 5:
	                System.out.println("\nLoading Cargo Planes..........");
	                System.out.println("---------------------------------------");
	                airField.loadAllCargoJets();
	                break;
	            case 6:
	                System.out.println("\nFighting the Dogs..........");
	                System.out.println("---------------------------------------");
	                airField.dogFight();
	                break;
	            case 7:
	                System.out.println("\nAdd Your Own Plane..........");
	                System.out.println("---------------------------------------");
	                airField.addJet();
	                break;
	            case 8:
	                System.out.println("\nRemove Plane...........");
	                System.out.println("---------------------------------------");
	                System.out.println("What plane do you want to remove?");
	                airField.removeJet();
	                break;
	            case 9:
	                System.out.println("\nThank you for using the Jet App.");
	                quit = true;
	                break;
	            default:
	                System.out.println("\n\tInvalid Input");
	                break;
	        }
            System.out.println("---------------------------------------");
        }
    }

    public void printMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("\t1. List fleet");
        System.out.println("\t2. Fly all jets");
        System.out.println("\t3. View fastest jet");
        System.out.println("\t4. View jet with the longest range");
        System.out.println("\t5. Load all Cargo Jets");
        System.out.println("\t6. Dogfight!");
        System.out.println("\t7. Add a jet to Fleet");
        System.out.println("\t8. Remove a jet from Fleet");
        System.out.println("\t9. Quit");
        System.out.print("\nPlease select an option: ");
    }
}
