import service.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        CreateTables.CreateTables();
        new AddInformation().addPassenger();
        new AddInformation().addCompany();
        new AddInformation().addTrip();
        new AddInformation().passInTrip();
        System.out.println(new AddressService().read(15L));
    }
}