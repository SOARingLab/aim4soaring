package aim4.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Prop {
    public String getProperty(String key) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return Optional.ofNullable(p.getProperty(key)).orElse("");
    }
}
