package com.unintendeduse.compass;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.compass.core.Compass;
import org.compass.gps.CompassGps;
import org.compass.gps.CompassGpsDevice;
import org.compass.gps.impl.SingleCompassGps;

public class CompassGpsProvider implements Provider<CompassGps> {
    private Compass compassCore;

    @Inject
    public CompassGpsProvider(Compass compassCore) {
        this.compassCore = compassCore;
    }

    @Override
    public CompassGps get() {

        SingleCompassGps compassGps = new SingleCompassGps(compassCore);

        CompassGpsDevice titleIndexer = new SienaGpsDevice("titles");

        compassGps.addGpsDevice(titleIndexer);

        compassGps.start();

        return compassGps;
    }

}

