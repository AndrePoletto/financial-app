package model.dao;

import model.connection.ConnectionFactory;
import model.logic.Account;
import model.logic.Category;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    /*
     * Essa class não esta tratando unicidade
     * ou seja se create for usado para objetos q ja estão na lista
     * eles vão estar duplicado e foda se :)
     *
     */

    private static ArrayList<Category> data;
    private static File dataDir;
    private static File dataFile;
    private static Connection connection;

    public CategoryDAO() {

        connection = ConnectionFactory.getConnection();
        // Open file

    }

    /**
     * Add to a Category to the data list
     *
     * @param cat
     */
    public void create(Category cat) {
            PreparedStatement stmt;
            String sql = "INSERT INTO category (name, type, categoryColor, note)VALUES(?,?,?,?)";

            try {
                stmt = connection.prepareStatement(sql);

                stmt.setString(1,cat.getName());
                stmt.setString(2,cat.getType());
                stmt.setString(3,cat.getCategoryColor());
                stmt.setString(4,cat.getNote());

                stmt.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }

    }

    /**
     * Return all Category
     *
     * @return
     */
    public List readAll() {
        return data;
    }

    /**
     * Return Category
     *
     * @param id
     * @return
     */
    public Category read(int id) {
        return data.get(id);
    }

    /**
     * Update a Category on data
     *
     * @param id
     * @param cat
     */
    public void update(int id, Category cat) {
        data.set(id, cat);
    }

    /**
     * Remove a Category using the ID
     *
     * @param id
     */
    public void delete(int id) {
        data.remove(id);
    }

    /**
     * Remove a Category using a Category Instance
     *
     * @param cat
     */
    public void delete(Category cat) {
        data.remove(cat);
    }


    public static void persist() {
        PersistArrayHandler.save(dataFile, data);
    }


    public static void loadData() {

        ArrayList dataBuffer = (ArrayList<Category>) PersistArrayHandler.read(dataFile);

        if (dataBuffer != null) {
            data.addAll(dataBuffer);
        } else {
            System.out.println("No Data");
        }

    }


    /**
     * Print on console all data Account
     */
    public void print() {
        for (Category c : data) {
            c.print();
        }
    }
}
