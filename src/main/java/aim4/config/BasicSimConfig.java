package aim4.config;

import aim4.gui.Viewer;
import aim4.sim.setup.BasicSimSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class BasicSimConfig {
    private Logger logger = LoggerFactory.getLogger("aim4.config.BasicSimConfig");

    @Autowired
    private Environment environment;

    @Bean
    public Viewer viewer() {
        boolean isRunNow = Boolean.parseBoolean(environment.getRequiredProperty("sim.isRunNow"));
        logger.info("isRunNow: {}", isRunNow);

        BasicSimSetup initSimSetup = new BasicSimSetup(
                Integer.parseInt(environment.getRequiredProperty("sim.columns")),
                Integer.parseInt(environment.getRequiredProperty("sim.rows")),
                Double.parseDouble(environment.getRequiredProperty("sim.lane_width")),
                Double.parseDouble(environment.getRequiredProperty("sim.speed_limit")),
                Integer.parseInt(environment.getRequiredProperty("sim.lanes_per_road")),
                Double.parseDouble(environment.getRequiredProperty("sim.median_size")),
                Double.parseDouble(environment.getRequiredProperty("sim.distance_between")),
                Double.parseDouble(environment.getRequiredProperty("sim.traffic_level")),
                Double.parseDouble(environment.getRequiredProperty("sim.stop_distance_before_intersection"))
        );
        logger.info("initSimSetup: {}", initSimSetup);

        return new Viewer(initSimSetup, isRunNow);
    }
}
