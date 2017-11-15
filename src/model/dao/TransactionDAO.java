package model.dao;

import model.bean.Transaction;
import model.connection.ConnectionFactory;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    private static final String TABLE_NAME = "Transactions";
    Connection connection;

    public TransactionDAO() { connection = ConnectionFactory.getConnection(); }

    private LocalDate fromDate(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                .toLocalDate();
    }

    private Transaction resultToTransaction(ResultSet result) throws SQLException {
        return new Transaction(
                result.getInt("idTransaction"),
                result.getFloat("value"),
                result.getString("description"),
                result.getString("note"),
                result.getString("type"),
                fromDate(result.getDate("date")),
                fromDate(result.getDate("remider")),
                result.getBoolean("consolidate")
        );
    }

    private void transactionToStatement(PreparedStatement stmt, Transaction trans) throws SQLException {
        stmt.setFloat(1, trans.getValue());
        stmt.setString(2, trans.getDescription());
        stmt.setString(3, trans.getNote());
        stmt.setString(4, trans.getType());
        stmt.setDate(5, Date.valueOf(trans.getDate()));
        stmt.setDate(6, Date.valueOf(trans.getReminder()));
        stmt.setBoolean(7, trans.getConsolidate());
        stmt.setInt(8, trans.getCategory().getId());
        stmt.setInt(9, trans.getAccount().getId());
    }

    public boolean create(Transaction trans) {
        PreparedStatement stmt;
        String sql = "INSERT INTO " + TABLE_NAME + " (value, description, note, type, date, reminder, consolidate, account_idAccount, category_idCategory, account_idAccount  )VALUES(?,?,?,?,?,?,?,? )";
        ResultSet result;
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            transactionToStatement(stmt, trans);
            stmt.executeUpdate();
            result = stmt.getGeneratedKeys();
            result.next();
            trans.setId(result.getInt(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public List<Transaction> read() {
        PreparedStatement stmt;
        ResultSet result;
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Transaction> transactions = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result.next()) {
                transactions.add(resultToTransaction(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return transactions;
    }

    public boolean update(Transaction trans) {
        PreparedStatement stmt;
        String sql = "UPDATE " + TABLE_NAME + " SET values = ?, description = ?, note = ?, type = ?, date = ?, reminder = ?, consolidate = ?, categories_idCategories = ?, account_idAccount = ?";
        try {
            stmt = connection.prepareStatement(sql);
            transactionToStatement(stmt, trans);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Transaction trans) {
        PreparedStatement stmt;
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, trans.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
