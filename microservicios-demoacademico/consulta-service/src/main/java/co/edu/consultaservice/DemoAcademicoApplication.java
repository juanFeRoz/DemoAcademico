package co.edu.consultaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoAcademicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAcademicoApplication.class, args);
    }

}
