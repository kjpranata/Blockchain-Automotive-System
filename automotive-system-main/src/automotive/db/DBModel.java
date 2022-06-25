package automotive.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBModel {

    String tableName;
    String databaseDirectory = "C:\\Users\\renir\\OneDrive - Asia Pacific University\\BCD\\automotive.db";
//    String databaseDirectory = "D:\\GitHubRepo\\Java\\automotive-system\\automotive.db";

    /**
     * Connect to the database. Please update the databaseDirectory.
     *
     * @return Connection
     */
    public Connection connect() {
        Connection con = null;
        try {
            String url = "jdbc:sqlite:" + databaseDirectory;
            con = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    /**
     * Delete a record from a table.
     *
     * @param id the id of the record that will be deleted
     */
    public void delete(int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reset the id of the table.
     */
    public void reset() {
        String sql = "UPDATE `sqlite_sequence` SET `seq` = 0 WHERE `name` = ?";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tableName);
            ps.executeUpdate();
            System.out.println(tableName + " reset.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
