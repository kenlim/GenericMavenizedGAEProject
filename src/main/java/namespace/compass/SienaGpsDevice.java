package namespace.compass;


import namespace.models.ElGenerico;
import org.compass.core.CompassSession;
import org.compass.gps.CompassGpsException;
import org.compass.gps.IndexPlan;
import org.compass.gps.device.AbstractGpsDevice;

import java.util.List;

public class SienaGpsDevice extends AbstractGpsDevice {

    public SienaGpsDevice(String name) {
        setName(name);
    }

    @Override
    protected void doIndex(CompassSession compassSession, IndexPlan indexPlan) throws CompassGpsException {
        // indexplan is ignored for now.

        // wipe out the old id

        // get all titles
        List<ElGenerico> titleList = ElGenerico.all().fetch();


        // create new entries
        for (ElGenerico title : titleList) {
            compassSession.create(title);
        }


    }
}
