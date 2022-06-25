package automotive.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Product extends DBModel {

    public Product() {
        this.tableName = "product";
    }

    /**
     * Add new record of product.
     *
     * @param manufacturer
     * @param model
     * @param stock
     * @param price
     */
    public void addProduct(String manufacturer, String model, int stock, int price) {
        String sql = "INSERT INTO product(manufacturer, model, stock, price) VALUES(?, ?, ?, ?)";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, manufacturer);
            ps.setString(2, model);
            ps.setInt(3, stock);
            ps.setInt(4, price);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Edit an existing product record.
     *
     * @param id
     * @param manufacturer
     * @param model
     * @param stock
     * @param price
     */
    public void editProduct(int id, String manufacturer, String model, int stock, int price) {
        String sql = "UPDATE product "
                + "SET manufacturer = ?, "
                + "model = ?, "
                + "stock = ?, "
                + "price = ?"
                + "WHERE id = ?";

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, manufacturer);
            ps.setString(2, model);
            ps.setInt(3, stock);
            ps.setInt(4, price);
            ps.setInt(5, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * List of all product recorded.
     *
     * @return the product list.
     */
    public List<List<String>> listProduct() {
        String sql = "SELECT * FROM product ORDER BY manufacturer ASC, model ASC;";
        List<List<String>> data = new ArrayList<>();

        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String manufacturer = rs.getString("manufacturer");
                String model = rs.getString("model");
                int stock = rs.getInt("stock");
                int price = rs.getInt("price");

                List<String> temp = new ArrayList<>();
                temp.add(Integer.toString(id));
                temp.add(manufacturer);
                temp.add(model);
                temp.add(Integer.toString(stock));
                temp.add(Integer.toString(price));
                data.add(temp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    /**
     * Get specific product record.
     *
     * @param id Product ID
     * @return the employee list.
     */
    public List<String> getProduct(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        List<String> data = new ArrayList<>();

        try (Connection conn = this.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String manufacturer = rs.getString("manufacturer");
                String model = rs.getString("model");
                int stock = rs.getInt("stock");
                int price = rs.getInt("price");

                data.add(Integer.toString(id));
                data.add(manufacturer);
                data.add(model);
                data.add(Integer.toString(stock));
                data.add(Integer.toString(price));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
