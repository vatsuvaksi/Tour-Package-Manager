package org.nymble.activity;


import org.nymble.destination.Destination;

import java.util.List;

/**
 * Implementation class or Service class for Activity
 * @author  Vatsal Gupta
 * @version 1.0
 * @since   2023-07-01
 */
public class ActivityManagerIMPL implements ActivityManager{
    /**
     * @param activity
     * @return
     */
    @Override
    public boolean addPassengerToActivity(Activity activity) {
        if(checkCapacity(activity)){
            activity.setCapacity(activity.getCapacity() - 1);
            return true;
        }
        return false;
    }

    /**
     * @param activity
     * @return
     */
    @Override
    public boolean checkCapacity(Activity activity) {
        return activity.getCapacity() > 0;
    }


}
