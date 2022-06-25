package automotive.db;

import automotive.crypto.Hasher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employee extends DBModel {

    public Employee() {
        this.tableName = "employee";
    }

    /**
     * Register new employee to the record.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param username
     * @param password
     */
    public void register(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
        String sql = "INSERT INTO employee(first_name, last_name, email, phone_number, username, password) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            String passwordHash = Hasher.hash(password, "MD5");

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phoneNumber);
            ps.setString(5, username);
            ps.setString(6, passwordHash);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Login the user to the system, it verify the user and password to the
     * database.
     *
     * @param username
     * @param password
     * @return -1 if username and password is wrong, the employee ID if valid.
     */
    public int login(String username, String password) {
        String sql = "SELECT id,password FROM employee WHERE username = ?";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String passwordDB = rs.getString("password");
                int id = rs.getInt("id");

                String passwordHash = Hasher.hash(password, "MD5");

                if (passwordDB.equals(passwordHash)) {
                    return id;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    /**
     * Edit employee record, it will check the validation of the username.
     *
     * @param id Employee ID
     * @param firstName the new first name
     * @param lastName the new last name
     * @param email the new email
     * @param phoneNumber the new phone number
     * @param username the new username
     * @param password the new password
     * @return success or error message
     */
    public Boolean edit(int id, String firstName, String lastName, String email, String phoneNumber, String username, String password) {
        int duplicatedUsernameID = this.duplicatedUsernameID(username);

        if (duplicatedUsernameID != id && duplicatedUsernameID != -1) {
            return false;
        }

        String sql = "UPDATE employee "
                + "SET first_name = ?, "
                + "last_name = ?, "
                + "email = ?, "
                + "phone_number = ?, "
                + "username = ?, "
                + "password = ? "
                + "WHERE id = ?";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            String passwordHash = Hasher.hash(password, "MD5");

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phoneNumber);
            ps.setString(5, username);
            ps.setString(6, passwordHash);
            ps.setInt(7, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * Get specific employee record.
     *
     * @param id Employee ID
     * @return the employee list.
     */
    public List<String> getEmployee(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        List<String> data = new ArrayList<>();

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String username = rs.getString("username");

                data.add(Integer.toString(id));
                data.add(first_name);
                data.add(last_name);
                data.add(email);
                data.add(phone_number);
                data.add(username);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    /**
     * Check duplicated username in employee data, it will return the ID if the
     * username found, it will return -1 if the username is not found.
     *
     * @param username the username that will be checked.
     * @return -1 if not found, the duplicated username ID if found.
     */
    public int duplicatedUsernameID(String username) {
        String sql = "SELECT id FROM employee WHERE username = ?";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                return id;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
