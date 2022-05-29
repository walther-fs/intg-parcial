package parcial.isil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootClientApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
