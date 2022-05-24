package dao.daoImpl;

import dao.DaoForAll;
import model.Company;
import service.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CompanyDaoImpl implements DaoForAll<Company> {

    @Override
    public Company findByID(int id) {
        String query = "select name_cmp, date_found from companies where ID_cmp=" + id;
        Company company = null;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {

            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                company = new Company(res.getString("name_cmp"), res.getDate("date_found"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Company company) {
        String query = "Insert into companies(name_cmp,date_found) values('" + company.getName_cmp() + "','" + company.getDate_found() + "');";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from companies where ID_cmp=" + id;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Company o) {
        String query = "update  companies set name_cmp='" + o.getName_cmp() + "',date_found='" + o.getDate_found() + "' where ID_cmp=" + id;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Company> findAll() {

        Set<Company> cmp = new HashSet<>();
        String query = "select * from companies";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                cmp.add(new Company(res.getString("name_cmp"), res.getDate("date_found")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmp;
    }

    @Override
    public Set<Company> get(int offset, int perPage, String sort) {
        Company company;
        Set<Company> cmp = new LinkedHashSet<>();
        String query = "SELECT * from companies " +
                "ORDER BY " + sort + " " +
                "LIMIT " + offset + " ," + perPage + " ";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {

            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                company = new Company(resultSet.getString("name_cmp"), resultSet.getDate("date_found"));
                cmp.add(company);
            }
        } catch (SQLException e) {
            System.out.println("no");
        }
        return cmp;
    }
}