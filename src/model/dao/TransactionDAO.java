package model.dao;

import model.logic.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
     /*
     * Essa class não esta tratando unicidade
     * ou seja se create for usado para objetos q ja estão na lista
     * eles vão estar duplicado e foda se :)
     *
     */

    private static ArrayList<Transaction> data;
    private static File dataDir;
    private static File dataFile;

    public TransactionDAO() {

        // Open file
        dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        dataFile = new File(dataDir, "transaction.bin");

        data = new ArrayList<Transaction>();

        loadData();

    }

    /**
     * Add to a Transaction to the data list
     *
     * @param trans
     */
    public void create(Transaction trans) {
        data.add(trans);
    }

    /**
     * Return all Transaction
     *
     * @return
     */
    public List readAll() {
        return data;
    }

    /**
     * Return Transaction
     *
     * @param id
     * @return
     */
    public Transaction read(int id) {
        return data.get(id);
    }

    /**
     * Update a Transaction on data
     *
     * @param id
     * @param trans
     */
    public void update(int id, Transaction trans) {
        data.set(id, trans);
    }

    /**
     * Remove a Transaction using the ID
     *
     * @param id
     */
    public void delete(int id) {
        data.remove(id);
    }

    /**
     * Remove a Transaction using a Transaction Instance
     *
     * @param trans
     */
    public void delete(Transaction trans) {
        data.remove(trans);
    }


    public static void persist() {
        PersistArrayHandler.save(dataFile, data);
    }


    public static void loadData() {

        ArrayList dataBuffer = (ArrayList<Transaction>) PersistArrayHandler.read(dataFile);

        if (dataBuffer != null) {
            data.addAll(dataBuffer);
        } else {
            System.out.println("No Data");
        }

    }


    /**
     * Print on console all data Transaction
     */
    public void print() {
        for (Transaction t : data) {
            t.print();
        }
    }


}
