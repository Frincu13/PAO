package ro.unibuc.fmi.repository;


import ro.unibuc.fmi.Tir;
import ro.unibuc.fmi.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TirRepository {

    private static TirRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO tir(nrUnic,pret, combustibil, anFabricatie,tip,capacitate) VALUES (?, ?,?, ?,?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM tir WHERE nrUnic = ?";
    private static final String UPDATE_STATEMENT = "UPDATE tir SET pret = ?,combustibil = ?,anFabricatie = ?,tip = ?,capacitate = ? WHERE nrUnic = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM tir WHERE nrUnic=?";

    private TirRepository() {
    }

    public static TirRepository getInstance() {
        if (instance == null) {
            instance = new TirRepository();
        }

        return instance;
    }

    public Tir saveTir(Tir tir) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, tir.getNrUnic());
            statement.setInt(2, tir.getPret());
            statement.setInt(3, tir.getCombustibil());
            statement.setInt(4, tir.getAnFabricatie());
            statement.setInt(5, tir.getTiuprile());
            statement.setInt(6, tir.getCapacitate());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new tir was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new tir: " + e.getMessage());
            return new Tir();
        }
        return tir;
    }


    public Tir updateTir(Tir tir) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(6, tir.getNrUnic());
            statement.setInt(1, tir.getPret());
            statement.setInt(2, tir.getCombustibil());
            statement.setInt(3, tir.getAnFabricatie());
            statement.setInt(4, tir.getTiuprile());
            statement.setInt(5, tir.getCapacitate());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Tir was updated successfully!");
                return tir;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update tir: " + e.getMessage());
            return new Tir();
        }

        System.out.println("Something went wrong when trying to update tir: Tir was not found!");
        return new Tir();
    }

    public boolean deleteTir(int nrUnic) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, nrUnic);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Tir was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete tir: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete tir: Tir was not found!");
        return false;
    }

    public Tir findTir(int nrUnic) {
        Tir tir = new Tir();
        tir.setNrUnic(-1);
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, nrUnic);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    return tir;
                }
                tir.setNrUnic(result.getInt("nrUnic"));
                tir.setCombustibil(result.getInt("combustibil"));
                tir.setAnfabricatie(result.getInt("anFabricatie"));
                tir.setTiuprile(result.getInt("tip"));
                tir.setPret(result.getInt("pret"));
                tir.setCapacitate(result.getInt("capacitate"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find tir: " + e.getMessage());
        }
        return tir;
    }


}
