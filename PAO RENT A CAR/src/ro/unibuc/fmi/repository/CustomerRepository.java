package ro.unibuc.fmi.repository;


import ro.unibuc.fmi.Customer;
import ro.unibuc.fmi.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerRepository {

    private static CustomerRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO customer(nume, spend) VALUES (?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM customer WHERE nume = ?";
    private static final String UPDATE_STATEMENT = "UPDATE customer SET spend = ? WHERE nume = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM customer WHERE nume=?";

    private CustomerRepository() {
    }

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }

        return instance;
    }

    public Customer saveCustomer(Customer customer) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getSpend());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new customer was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new customer: " + e.getMessage());
            return new Customer();
        }
        return customer;
    }


    public Customer updateCustomer(Customer customer) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, customer.getSpend());
            statement.setString(2, customer.getName());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer was updated successfully!");
                return customer;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update customer: " + e.getMessage());
            return new Customer();
        }

        System.out.println("Something went wrong when trying to update customer: Customer was not found!");
        return new Customer();
    }

    public boolean deleteCustomer(String nume) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, nume);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Customer was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete customer: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete customer: Customer was not found!");
        return false;
    }

    public Customer findCustomer(String nume) {
        Customer customer = new Customer();
        customer.setName("NULL");
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, nume);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    return customer;
                }
                customer.setSpend(result.getInt("spend"));
                customer.setName(result.getString("nume"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find customer: " + e.getMessage());
        }
        return customer;
    }


}