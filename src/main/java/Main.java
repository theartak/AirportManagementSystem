import model.Address;
import model.Company;
import model.Passenger;
import model.Trip;
import service.*;


public class Main {
    public static void main(String[] args) {
        AddInformation.addAddressInfo();
        AddInformation.addPassengersInfo();
        AddInformation.addCompaniesInfo();
        AddInformation.addTripsInfo();
        AddInformation.addPass_In_TripInfo();

        for (Company c : new CompanyService().get(1, 10, "name_cmp")) {
            System.out.println(c);
        }

        for (Trip t : new TripService().get(5, 10, "trip_no")) {
            System.out.println(t);
        }

        for (Trip t : new TripService().getTripsFrom("Paris")) {
            System.out.println(t);
        }

        for (Trip t : new TripService().getTripsTo("Paris")) {
            System.out.println(t);
        }

        for (Passenger p : new PassengerService().getPassengersOfTrip(1181)) {
            System.out.println(p);
        }
    }
}