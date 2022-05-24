package dao.daoImpl;

import dao.DaoForAll;
import model.Address;
import service.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class AddressDaoImpl implements DaoForAll<Address> {
    @Override
    public Address findByID(int id) {
        String query = "select country,city from address where id= " + id;
        Address address = null;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            if (resultSet.next()) {
                address = new Address(resultSet.getString("country"),
                        resultSet.getString("city"));
            }
        } catch (SQLException e) {
            System.out.println("Wrong query for Address with id = " + id);
        }
        return address;
    }

    @Override
    public void create(Address address) {
        String query = "Insert into address(country,city) values('" + address.getCountry() + "','" + address.getCity() + "');";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getID(String country, String city) {
        int id = -1;
        String query = "Select id from address where country='" + country + "'and city='" + city + "'";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                id = res.getInt("ID_adrs");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from address where id=" + id;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Address address) {
        String query = "update  address set country='" + address.getCountry() + "',city='"
                + address.getCity() + "' where id=" + id;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set<Address> findAll() {
        String query = "select * from address";
        Set<Address> cmp = new HashSet<>();
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                cmp.add(new Address(res.getString("country"), res.getString("city")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmp;
    }

    @Override
    public Set<Address> get(int offset, int perPage, String sort) {
        return null;
    }
}