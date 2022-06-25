package automotive.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Customer extends DBModel {

    public Customer() {
        this.tableName = "customer";
    }

    /**
     * Add new record of customer.
     *
     * @param first_name
     * @param last_name
     * @param address
     * @param zip
     * @param city
     * @param state
     * @param email
     * @param phone_number
     */
    public void addCustomer(String first_name, String last_name, String address, String zip, String city, String state, String email, String phone_number) {
        String sql = "INSERT INTO customer (first_name, last_name, address, zip, city, state, email, phone_number) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, address);
            ps.setString(4, zip);
            ps.setString(5, city);
            ps.setString(6, state);
            ps.setString(7, email);
            ps.setString(8, phone_number);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Edit an existing customer record.
     *
     * @param id
     * @param first_name
     * @param last_name
     * @param address
     * @param zip
     * @param city
     * @param state
     * @param email
     * @param phone_number
     * @return
     */
    public String editCustomer(int id, String first_name, String last_name, String address, String zip, String city, String state, String email, String phone_number) {
        String sql = "UPDATE customer "
                + "SET first_name = ?, "
                + "last_name = ?, "
                + "address = ?, "
                + "zip = ?, "
                + "city = ?, "
                + "state = ?, "
                + "email = ?, "
                + "phone_number = ?"
                + "WHERE id = ?";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, address);
            ps.setString(4, zip);
            ps.setString(5, city);
            ps.setString(6, state);
            ps.setString(7, email);
            ps.setString(8, phone_number);
            ps.setInt(9, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Product detail updated";
    }

    /**
     * List of all customer recorded.
     *
     * @return the customer list.
     */
    public List<List<String>> listCustomer() {
        String sql = "SELECT * FROM customer ORDER BY id ASC";
        List<List<String>> data = new ArrayList<>();

        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String address = rs.getString("address");
                String zip = rs.getString("zip");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");

                List<String> temp = new ArrayList<>();
                temp.add(Integer.toString(id));
                temp.add(first_name);
                temp.add(last_name);
                temp.add(address);
                temp.add(zip);
                temp.add(city);
                temp.add(state);
                temp.add(email);
                temp.add(phone_number);
                data.add(temp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    /**
     * Get specific customer record.
     *
     * @param id Customer ID
     * @return the employee list.
     */
    public List<String> getCustomer(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        List<String> data = new ArrayList<>();

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String address = rs.getString("address");
                String zip = rs.getString("zip");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");

                data.add(Integer.toString(id));
                data.add(first_name);
                data.add(last_name);
                data.add(address);
                data.add(zip);
                data.add(city);
                data.add(state);
                data.add(email);
                data.add(phone_number);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
