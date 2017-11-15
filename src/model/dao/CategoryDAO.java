package model.dao;

import model.bean.Category;
import model.connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private static final String TABLE_NAME = "Categories";
    private static Connection connection;

    public CategoryDAO() { connection = ConnectionFactory.getConnection(); }

    private Category resultToCategory(ResultSet result) throws SQLException {
        return new Category(
                        result.getInt("idCategory"),
                        result.getString("name"),
                        result.getString("type"),
                        result.getString("note"),
                        result.getString("categoryColor")
                );
    }

    private void categoryToStatement(PreparedStatement stmt, Category cat) throws SQLException {
        stmt.setString(1, cat.getName());
        stmt.setString(2, cat.getType());
        stmt.setString(3, cat.getCategoryColor());
        stmt.setString(4, cat.getNote());
    }

    public boolean create(Category cat) {
            PreparedStatement stmt;
            ResultSet result;
            String sql = "INSERT INTO "+ TABLE_NAME +" (name, type, categoryColor, note)VALUES(?,?,?,?)";

            try {
                stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                categoryToStatement(stmt, cat);
                stmt.executeUpdate();
                result = stmt.getGeneratedKeys();
                result.next();
                cat.setId(result.getInt(1));
            } catch (SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
            return true;
    }

    public List<Category> read() {
        PreparedStatement stmt;
        ResultSet result;
        String sql = "SELECT * FROM "+ TABLE_NAME;
        List<Category> categories = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result.next()) {
                categories.add(resultToCategory(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return categories;
    }

    public boolean update(Category cat) {
        PreparedStatement stmt;
        String sql = "UPDATE "+ TABLE_NAME +" SET name = ?, type = ?, categoryColor = ?, note = ?";
        try {
            stmt = connection.prepareStatement(sql);
            categoryToStatement(stmt, cat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete( Category cat) {
        PreparedStatement stmt;
        String sql = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cat.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Category getByName(String name) {
        PreparedStatement stmt;
        ResultSet result;
        String sql = "SELECT * FROM "+ TABLE_NAME +" WHERE name = ?";
        Category cat;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            result = stmt.executeQuery();
            result.next();
            cat = resultToCategory(result);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return cat;
    }

}
