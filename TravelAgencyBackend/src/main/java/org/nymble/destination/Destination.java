package org.nymble.destination;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.nymble.activity.Activity;

import java.util.List;


/**
 * Entity for Destination
 * @author  Vatsal Gupta
 * @version 1.0
 * @since   2023-07-01
 */
@Data
@Builder
public class Destination {
    private String name;
    @NonNull
    private final int id;
    /*Removed as Circular Dependency may harm the software*/
    private List<Activity> activityList;
}
