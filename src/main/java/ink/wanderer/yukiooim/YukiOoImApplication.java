package ink.wanderer.yukiooim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class YukiOoImApplication {

    public static void main(String[] args) {
        SpringApplication.run(YukiOoImApplication.class, args);
    }

}
