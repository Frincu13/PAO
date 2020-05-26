package ro.unibuc.fmi.repository;


import ro.unibuc.fmi.Masina;
import ro.unibuc.fmi.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class MasinaRepository {

    private static MasinaRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO masina(nrUnic,pret, combustibil, anFabricatie,tip,marca,model) VALUES (?, ?,?, ?,?, ?,?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM masina WHERE nrUnic = ?";
    private static final String UPDATE_STATEMENT = "UPDATE masina SET pret = ?,combustibil = ?,anFabricatie = ?,tip = ?,marca = ?,model = ? WHERE nrUnic = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM masina WHERE nrUnic=?";

    private MasinaRepository() {
    }

    public static MasinaRepository getInstance() {
        if (instance == null) {
            instance = new MasinaRepository();
        }

        return instance;
    }

    public Masina saveMasina(Masina masina) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, masina.getNrUnic());
            statement.setInt(2, masina.getPret());
            statement.setInt(3, masina.getCombustibil());
            statement.setInt(4, masina.getAnFabricatie());
            statement.setInt(5, masina.getTiuprile());
            statement.setString(6, masina.getMarca());
            statement.setString(7, masina.getModel());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new masina was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new masina: " + e.getMessage());
            return new Masina();
        }
        return masina;
    }


    public Masina updateMasina(Masina masina) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(7, masina.getNrUnic());
            statement.setInt(1, masina.getPret());
            statement.setInt(2, masina.getCombustibil());
            statement.setInt(3, masina.getAnFabricatie());
            statement.setInt(4, masina.getTiuprile());
            statement.setString(5, masina.getMarca());
            statement.setString(6, masina.getModel());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Masina was updated successfully!");
                return masina;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update masina: " + e.getMessage());
            return new Masina();
        }

        System.out.println("Something went wrong when trying to update masina: Masina was not found!");
        return new Masina();
    }

    public boolean deleteMasina(int nrUnic) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, nrUnic);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Masina was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete masina: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete masina: Masina was not found!");
        return false;
    }

    public Masina findMasina(int nrUnic) {
        Masina masina = new Masina();
        masina.setNrUnic(-1);
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, nrUnic);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    return masina;
                }
                masina.setNrUnic(result.getInt("nrUnic"));
                masina.setCombustibil(result.getInt("combustibil"));
                masina.setAnfabricatie(result.getInt("anFabricatie"));
                masina.setTiuprile(result.getInt("tip"));
                masina.setPret(result.getInt("pret"));
                masina.setMarca(result.getString("marca"));
                masina.setModel(result.getString("model"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find masina: " + e.getMessage());
        }
        return masina;
    }


}
