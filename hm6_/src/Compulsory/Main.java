package Compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            GenreDAO genres = new GenreDAO();

            genres.create("Action");
            System.out.println("Genul a fost adăugat cu succes.");

            Database.getConnection().commit();

            Integer id = genres.findByName("Action");
            System.out.println("ID-ul pentru 'Action' este: " + id);


            if (id != null) {
                String name = genres.findById(id);
                System.out.println("Numele genului cu ID-ul " + id + " este: " + name);
            }

        } catch (SQLException e) {
            System.err.println("Eroare de bază de date: " + e.getMessage());
            try {

                Database.getConnection().rollback();
            } catch (SQLException ex) {
                System.err.println("Eroare la rollback: " + ex.getMessage());
            }
        } finally {
            Database.closeConnection();
        }
    }
}