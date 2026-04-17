package hm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActorDAO {

    public void create(Actor actor) throws SQLException {
        String sql = "INSERT INTO actors (name) VALUES (?)";

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, actor.getName());
            pstmt.executeUpdate();
        }
    }
}