package model.dao;

import model.connection.ConnectionFactory;
import model.bean.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    private static final String TABLE_NAME = "Accounts";
    private Connection connection;

    public AccountDAO() {
        connection = ConnectionFactory.getConnection();
    }

    private Account resultToAccount(ResultSet result) throws SQLException {
            return  new Account(
                    result.getInt("idAccount"),
                    result.getString("name"),
                    result.getString("iconLetters"),
                    result.getString("note"),
                    result.getFloat("value"),
                    result.getBoolean("situation")
            );
    }

    private void accountToStatement(PreparedStatement stmt, Account acc ) throws SQLException {
        stmt.setString(1, acc.getName());
        stmt.setString(2, acc.getIconLetters());
        stmt.setString(3, acc.getNote());
        stmt.setFloat(4, acc.getValue());
        stmt.setBoolean(5, acc.isSituation());
    }

    public boolean create(Account acc) {
        PreparedStatement stmt;
        String sql = "INSERT INTO "+ TABLE_NAME +" (name, iconLetters, note, value, situation)VALUES(?,?,?,?,?)";
        ResultSet result;
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            accountToStatement(stmt, acc);
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
        PreparedStatement stmt;
        ResultSet result;
        String sql = "SELECT * FROM "+ TABLE_NAME;
        List<Account> accounts = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result.next()){
                accounts.add(resultToAccount(result));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return accounts;
    }

    public boolean update(Account acc) {
        PreparedStatement stmt;
        String sql = "UPDATE "+ TABLE_NAME +" SET name = ?, iconLetters = ?, note = ?, value = ?, situation = ?";
        try {
            stmt = connection.prepareStatement(sql);
            accountToStatement(stmt, acc);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Account acc) {
        PreparedStatement stmt;
        String sql = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
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

    public Account getByName(String name) {
        PreparedStatement stmt;
        ResultSet result;
        String sql = "SELECT * FROM "+ TABLE_NAME +" WHERE name = ?";
        Account acc;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            result = stmt.executeQuery();
            result.next();
            acc = resultToAccount(result);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return acc;
    }

}
