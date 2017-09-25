package model.dao;

import model.logic.Account;
import model.logic.Category;

import java.io.*;
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

    public CategoryDAO() {

        // Open file
        dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        dataFile = new File(dataDir, "category.bin");

        data = new ArrayList<Category>();

        loadData();
    }

    /**
     * Add to a Category to the data list
     *
     * @param cat
     */
    public void create(Category cat) {
        data.add(cat);
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
