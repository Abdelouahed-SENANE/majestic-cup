package ma.youcode.majesticcup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class MajesticCupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MajesticCupApplication.class, args);
    }

}
