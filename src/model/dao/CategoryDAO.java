package model.dao;

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

    private static List<Category> data = new ArrayList<Category>();

    public CategoryDAO() {
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

        File dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        File dataFile = new File(dataDir, "category.db");

        try {
            FileWriter db = new FileWriter(dataFile, false);

            // Write head
            db.write("type, name, categoryColor, note\n");

            // Write Data
            for (Category c : data) {
                db.append(c.getCsvFormat());
            }

            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void loadData() {
        File dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        File dataFile = new File(dataDir, "category.db");


        try {
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader db = new BufferedReader(fileReader);

            // Step header
            db.readLine();

            // Read data and load to data:List
            while (db.ready()) {
                /*
                * Here we read a line from the file
                * and split using , then instantiate
                * a Categpry and add to data:List
                */

                String line = db.readLine();
                String[] splitedLine = line.split(",");

                Category cat = new Category();

                cat.setType(splitedLine[0]);
                cat.setName(splitedLine[1]);
                cat.setCategoryColor(splitedLine[2]);
                cat.setNote(splitedLine[3]);


                data.add(cat);
            }


            db.close();
        } catch (IOException e) {
            e.printStackTrace();
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
