package SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.*;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        CreateTables.CreateTables();
        new AddInformation().addPassenger();
        new AddInformation().addCompany();
        new AddInformation().addTrip();
        new AddInformation().passInTrip();
        System.out.println(new AddressService().read(15L));
    }
}
