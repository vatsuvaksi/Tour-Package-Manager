package org.nymble.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.nymble.destination.Destination;


/**
 * Entity for Activity
 * @author  Vatsal Gupta
 * @version 1.0
 * @since   2023-07-01
 */
@Data
@Builder
public class Activity {
    private String name;
    @NonNull
    private final int id;
    private String description;
    @NonNull
    private double cost;
    private int capacity;

}
