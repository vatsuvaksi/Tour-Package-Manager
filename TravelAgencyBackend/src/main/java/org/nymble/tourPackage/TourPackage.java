package org.nymble.tourPackage;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.nymble.destination.Destination;
import org.nymble.passenger.Passenger;
import java.util.List;


/**
 * Entity for TourPackage
 * @author  Vatsal Gupta
 * @version 1.0
 * @since   2023-07-01
 */
@Data
@Builder
public class TourPackage {
    private String name;
    @NonNull
    private final int id;
    @NonNull
    private int passengerCapacity;
    private List<Destination> destinationList;
    private List<Passenger> passengerList;
}
