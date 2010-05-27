package namespace.compass;

import com.google.inject.Provider;
import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;
import org.compass.core.config.CompassEnvironment;

public class CompassProvider implements Provider<Compass> {

    @Override
    public Compass get() {

        return new CompassConfiguration().setConnection("gae://index")
                .setSetting(CompassEnvironment.ExecutorManager.EXECUTOR_MANAGER_TYPE, "disabled")
                .addScan("namespace.models")
                .buildCompass();
    }

}