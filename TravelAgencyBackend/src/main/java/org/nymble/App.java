package org.nymble;


import org.nymble.activity.Activity;
import org.nymble.activity.ActivityManagerIMPL;
import org.nymble.destination.Destination;
import org.nymble.destination.DestinationManager;
import org.nymble.destination.DestinationManagerIMPL;
import org.nymble.enums.Membership;
import org.nymble.passenger.Passenger;
import org.nymble.passenger.PassengerManager;
import org.nymble.passenger.PassengerManagerIMPL;
import org.nymble.tourPackage.TourPackage;
import org.nymble.tourPackage.TourPackageManager;
import org.nymble.tourPackage.TourPackageManagerIMPL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is the Entry point of the application.
 * This contains all the static information about destinations ,activities, passengers etc etc.
 * @author  Vatsal Gupta
 * @version 1.0
 * @since   2023-07-01 
 */
public class App 
{
    private static Map<Integer , TourPackage> tourPackageList ;
    private static List<Destination> destinationList;
    private static List<Activity> activitiesList;
    private static List<Passenger> passengerList;
    private static final TourPackageManager tourPackageManager = new TourPackageManagerIMPL();

    private static final PassengerManager passengerManager = new PassengerManagerIMPL(
                new ActivityManagerIMPL()
            );

    private static final DestinationManager destinationManager = new DestinationManagerIMPL();

    /**
     *
     * @param args
     */
    public static void main( String[] args )
    {
        System.out.println( "*********** Welcome to Travel Agency Manager ***********" );
        System.out.println();
        // Setting up Mock Static Data 
        setUpTourPackages();
        setUpDestinations();
        setUpActivities();
        setUpPassengers();
        
        //Functionalities
        functionality1();
        functionality2();
        functionality3();
        functionality4();
        System.out.println( "*********** Exiting The Application ***********" );
    }

    private static void functionality4() {
        System.out.println();
        System.out.println("### Requirement 4 ####");
        System.out.println("Activities with space : ");
        activitiesList.stream().forEach(activity -> {
            if(activity.getCapacity() > 0){
                System.out.println("Activity : " + activity.getName());
                System.out.println("Capoacity :" + activity.getCapacity());
            }
        });
    }

    private static void functionality3() {
        System.out.println();
        System.out.println("#### Requirement 3 ####");
        System.out.println("Passenger Details ");
        passengerList
                .forEach(passenger -> System.out.println(passenger.toString()));
    }

    private static void functionality2() {
        System.out.println();
        System.out.println("## Requirement 2 ##");
        System.out.println("Package Name 01 : " + tourPackageList.get(1).getName());
        System.out.println("Passenger Capacity : " + tourPackageList.get(1).getPassengerCapacity());
        System.out.println("Details of passenger currently enrolled in : ");
        tourPackageList.get(1).getPassengerList().forEach(passenger -> {
            System.out.println("Passenger Name :" + passenger.getName());
            System.out.println("Passenger Num : " + passenger.getPassengerNum());
        });
    }

    private static void functionality1() {
        /*01 : Print itenary of the travle package including details from id*/
        System.out.println();
        System.out.println("## Requirement 1 ##");
        System.out.println("Package Name 01 : " + tourPackageList.get(1).getName());
        System.out.println("Destinations And Activities Present : " );
        tourPackageList
                .get(1)
                .getDestinationList()
                .forEach(destination -> {
                    System.out.println(destination.getName());
                    System.out.println(destination.getActivityList());
                });
    }

    /**
     * Creating Fake Passengers
     */
    private static void setUpPassengers() {
        passengerList = new ArrayList<>();
        passengerList.add(
                Passenger.builder()
                        .passengerNum(1)
                        .name("Vatsal Gupta")
                        .balance(1000.0)
                        .membership(Membership.STANDARD)
                        .activityList(null)
                        .destinationList(null)
                        .build()
        );
        passengerList.add(
                Passenger.builder()
                        .passengerNum(2)
                        .name("Aathira Vinod")
                        .balance(100.0)
                        .membership(Membership.GOLD)
                        .activityList(null)
                        .destinationList(null)
                        .build()
        );
        passengerList.add(
                Passenger.builder()
                        .passengerNum(3)
                        .name("Rohin Malhotra")
                        .membership(Membership.PREMIUM)
                        .activityList(null)
                        .destinationList(null)
                        .build()
        );


        passengerManager.addDestination(destinationList.get(0) , passengerList.get(0));
        passengerManager.addDestination(destinationList.get(1) , passengerList.get(0));

        passengerManager.addDestination(destinationList.get(2) , passengerList.get(1));
        passengerManager.addDestination(destinationList.get(3) , passengerList.get(1));

        passengerManager.addDestination(destinationList.get(4) , passengerList.get(2));

        passengerManager.addActivity(passengerList.get(0) , activitiesList.get(0));
        passengerManager.addActivity(passengerList.get(0) , activitiesList.get(1));

        passengerManager.addActivity(passengerList.get(1) , activitiesList.get(5));

        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(0));
        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(1));
        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(2));
        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(3));


        tourPackageManager.addPassenger(passengerList.get(0) , tourPackageList.get(1));
        tourPackageManager.addPassenger(passengerList.get(1) , tourPackageList.get(1));
        tourPackageManager.addPassenger(passengerList.get(2) , tourPackageList.get(3));

    }



    /**
     * Creating Fake Activities
     */
    private static void setUpActivities() {
        activitiesList = new ArrayList<>();
        activitiesList.add(
                Activity.builder()
                        .id(1)
                        .name("Kempty Fall")
                        .description("Falls in hill station")
                        .capacity(20)
                        .cost(100.0)
                        .build()
                        );
        activitiesList.add(
                Activity.builder()
                        .id(2)
                        .name("Mall Road")
                        .description("Market in hill station")
                        .capacity(20)
                        .cost(100.0)
                        .build()
        );

        activitiesList.add(
                Activity.builder()
                        .id(3)
                        .name("Wood Forest")
                        .description("Forest in rural area")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(4)
                        .name("Wheat Harvesting")
                        .description("Harvesting in rural area")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(5)
                        .name("Milk Industry")
                        .description("Industry in rural area")
                        .capacity(10)
                        .cost(500.0)
                        .build()
        );

        activitiesList.add(
                Activity.builder()
                        .id(6)
                        .name("Beach1")
                        .description("Beach in Puri")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(7)
                        .name("Beach2")
                        .description("Beach in Puri")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(8)
                        .name("Shimla Falls")
                        .description("Fall in Shimla")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(9)
                        .name("International Beach 1")
                        .description("Beach in Goa")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        destinationManager.addActivity(destinationList.get(0) , activitiesList.get(0));
        destinationManager.addActivity(destinationList.get(0) , activitiesList.get(1));
        destinationManager.addActivity(destinationList.get(1) , activitiesList.get(2));
        destinationManager.addActivity(destinationList.get(1) , activitiesList.get(3));
        destinationManager.addActivity(destinationList.get(1) , activitiesList.get(4));
        destinationManager.addActivity(destinationList.get(2) , activitiesList.get(5));
        destinationManager.addActivity(destinationList.get(2) , activitiesList.get(6));
        destinationManager.addActivity(destinationList.get(4) , activitiesList.get(7));
        destinationManager.addActivity(destinationList.get(3) , activitiesList.get(8));

    }

    /**
     * Creating Fake Destinations
     */
    private static void setUpDestinations() {
        destinationList = new ArrayList<>();
        destinationList.add(
                Destination.builder()
                        .id(1)
                        .name("Musoorie")
                        .activityList(null)
                        .build()
        );
        destinationList.add(
                Destination.builder()
                        .id(2)
                        .name("Unnao")
                        .activityList(null)
                        .build()
        );
        destinationList.add(
                Destination.builder()
                        .id(3)
                        .name("Puri")
                        .activityList(null)
                        .build()
        );destinationList.add(
                Destination.builder()
                        .id(4)
                        .name("Goa")
                        .activityList(null)
                        .build()
        );
        destinationList.add(
                Destination.builder()
                        .id(5)
                        .name("Shimla")
                        .activityList(null)
                        .build()
        );

        tourPackageManager.addDestination(destinationList.get(0) , tourPackageList.get(1));
        tourPackageManager.addDestination(destinationList.get(1) , tourPackageList.get(3));
        tourPackageManager.addDestination(destinationList.get(2) , tourPackageList.get(2));
        tourPackageManager.addDestination(destinationList.get(3) , tourPackageList.get(2));
        tourPackageManager.addDestination(destinationList.get(4) , tourPackageList.get(1));
    }

    /**
     * Creating Tour Packages
     */
    private static void setUpTourPackages() {
        tourPackageList = new HashMap<>();
        tourPackageList.put(1 , TourPackage.builder()
                .id(1)
                .name("Hill Station")
                .passengerCapacity(500)
                .passengerList(null)
                .destinationList(null)
                .build());
        tourPackageList.put(2 , TourPackage.builder()
                .id(2)
                .name("Beach ")
                .passengerCapacity(500)
                .passengerList(null)
                .destinationList(null)
                .build());
        tourPackageList.put(3 , TourPackage.builder()
                .id(3)
                .name("Rural Areas")
                .passengerCapacity(500)
                .passengerList(null)
                .destinationList(null)
                .build());
    }
}
