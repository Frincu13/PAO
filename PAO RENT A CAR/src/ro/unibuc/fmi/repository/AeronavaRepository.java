package ro.unibuc.fmi.repository;


import ro.unibuc.fmi.Aeronava;
import ro.unibuc.fmi.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AeronavaRepository {

    private static AeronavaRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO aeronava(nrUnic,pret, combustibil, anFabricatie,tip,tipul) VALUES (?, ?,?, ?,?,?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM aeronava WHERE nrUnic = ?";
    private static final String UPDATE_STATEMENT = "UPDATE aeronava SET pret = ?,combustibil = ?,anFabricatie = ?,tip = ?,tipul= ? WHERE nrUnic = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM aeronava WHERE nrUnic=?";

    private AeronavaRepository() {
    }

    public static AeronavaRepository getInstance() {
        if (instance == null) {
            instance = new AeronavaRepository();
        }

        return instance;
    }

    public Aeronava saveAeronava(Aeronava aeronava) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, aeronava.getNrUnic());
            statement.setInt(2, aeronava.getPret());
            statement.setInt(3, aeronava.getCombustibil());
            statement.setInt(4, aeronava.getAnFabricatie());
            statement.setInt(5, aeronava.getTiuprile());
            statement.setString(6, aeronava.getType());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new aeronava was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new aeronava: " + e.getMessage());
            return new Aeronava();
        }
        return aeronava;
    }


    public Aeronava updateAeronava(Aeronava aeronava) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(6, aeronava.getNrUnic());
            statement.setInt(1, aeronava.getPret());
            statement.setInt(2, aeronava.getCombustibil());
            statement.setInt(3, aeronava.getAnFabricatie());
            statement.setInt(4, aeronava.getTiuprile());
            statement.setString(5, aeronava.getType());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Aeronava was updated successfully!");
                return aeronava;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update aeronava: " + e.getMessage());
            return new Aeronava();
        }

        System.out.println("Something went wrong when trying to update aeronava: Aeronava was not found!");
        return new Aeronava();
    }

    public boolean deleteAeronava(int nrUnic) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, nrUnic);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Aeronava was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete aeronava: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete aeronava: Aeronava was not found!");
        return false;
    }

    public Aeronava findAeronava(int nrUnic) {
        Aeronava aeronava = new Aeronava();
        aeronava.setNrUnic(-1);
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, nrUnic);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    return aeronava;
                }
                aeronava.setNrUnic(result.getInt("nrUnic"));
                aeronava.setCombustibil(result.getInt("combustibil"));
                aeronava.setAnfabricatie(result.getInt("anFabricatie"));
                aeronava.setTiuprile(result.getInt("tip"));
                aeronava.setPret(result.getInt("pret"));
                aeronava.setType(result.getString("tipul"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find aeronava: " + e.getMessage());
        }
        return aeronava;
    }


}
