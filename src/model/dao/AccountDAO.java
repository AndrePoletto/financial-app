package model.dao;

import model.connection.ConnectionFactory;
import model.logic.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    /*
     * Essa class não esta tratando unicidade
     * ou seja se create for usado para objetos q ja estão na lista
     * eles vão estar duplicado e foda se :)
     *
     */
    private Connection connection;

    public AccountDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public boolean create(Account acc) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO account (name, iconLetters, note, value, situation)VALUES(?,?,?,?,?)";
        ResultSet result = null;
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, acc.getName());
            stmt.setString(2, acc.getIconLetters());
            stmt.setString(3, acc.getNote());
            stmt.setFloat(4, acc.getValue());
            stmt.setBoolean(5, acc.isSituation());
            stmt.executeUpdate();
            result = stmt.getGeneratedKeys();
            result.next();
            acc.setId(result.getInt(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Account> read() {
        PreparedStatement stmt = null;
        ResultSet result = null;
        String sql = "SELECT * FROM account";
        List<Account> accounts = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result.next()) {
                Account acc = new Account(
                        result.getInt("idaccount"),
                        result.getString("name"),
                        result.getString("iconLetters"),
                        result.getString("note"),
                        result.getFloat("value"),
                        result.getBoolean("situation")
                );
                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return accounts;
    }

    public boolean update(Account acc) {
        PreparedStatement stmt = null;
        String sql = "UPDATE account SET name = ?, iconLetters = ?, note = ?, value = ?, situation = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, acc.getName());
            stmt.setString(2, acc.getIconLetters());
            stmt.setString(3, acc.getNote());
            stmt.setFloat(4, acc.getValue());
            stmt.setBoolean(5, acc.isSituation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
        return true;
    }

    public boolean delete(Account acc) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM account WHERE id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, acc.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int getIdByName(String name) {
        PreparedStatement stmt = null;
        ResultSet result = null;
        String sql = "SELECT * FROM account WHERE name = ?";
        int id;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            result = stmt.executeQuery();
            id = result.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return id;
    }
}
