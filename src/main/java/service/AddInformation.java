package service;

import model.*;
import repository.*;
import java.io.*;
import java.sql.*;

public class AddInformation {
    BufferedReader bufferedReader;
    public void addPassenger() {
        PassengerRepo passengerRepo = new PassengerRepo();
        String[] read = new String[4];
        String s = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\passengers.txt"));
            s = bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                passengerRepo.create(new Passenger(read[0], read[1], (new Address(read[2], read[3]))));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCompany() {
        CompanyRepo companyDao = new CompanyRepo();
        String[] read;
        String s = "";
        String[] dt;
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\\\main\\\\resources\\\\companies.txt"));
            bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                dt = read[1].split("/");
                companyDao.create(new Company(read[0], Date.valueOf(dt[2] + "-" + dt[0] + "-" + dt[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTrip() {
        TripRepo tripRepo = new TripRepo();
        CompanyRepo companyRepo = new CompanyRepo();
        String[] read;
        String s = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\\\main\\\\resources\\\\trips.txt"));
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                String time_out = read[5].split(" ")[1].substring(0, 8);
                String time_in = read[6].split(" ")[1].substring(0, 8);
                tripRepo.create(new Trip(Long.valueOf(read[0]), companyRepo.read(Long.valueOf(read[1])),
                        read[2], read[3], read[4], Time.valueOf(time_out), Time.valueOf(time_in)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void passInTrip() {
        PassInTripRepo passInTrip=new PassInTripRepo();

        String[] read;
        String s = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\\\main\\\\resources\\\\pass_in_trip.txt"));
            bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                passInTrip.create(new PassInTrip(new PassInTrip.PassInTripId(Long.valueOf(read[0]),Long.valueOf(read[1]),Date.valueOf(read[2].split(" ")[0])),read[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}