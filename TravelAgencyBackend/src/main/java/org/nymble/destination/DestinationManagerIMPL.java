package org.nymble.destination;

import org.nymble.activity.Activity;

import java.util.ArrayList;

public class DestinationManagerIMPL implements DestinationManager{
    /**
     * @param destination
     * @param activity
     * @return
     */
    @Override
    public void addActivity(Destination destination, Activity activity) {
        if(destination.getActivityList() == null)
            destination.setActivityList(new ArrayList<>());

        destination.getActivityList().add(activity);

    }
}
