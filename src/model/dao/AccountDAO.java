package model.dao;

import model.logic.Account;

import java.io.*;
import java.util.ArrayList;

public class AccountDAO {

    /*
     * Essa class não esta tratando unicidade
     * ou seja se create for usado para objetos q ja estão na lista
     * eles vão estar duplicado e foda se :)
     *
     */

    private static ArrayList<Account> data;
    private static File dataDir;
    private static File dataFile;

    public AccountDAO() {

        // Open file
        dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        dataFile = new File(dataDir, "account.bin");

        data = new ArrayList<Account>();

        loadData();
    }

    /**
     * Add to a Account to the data list
     *
     * @param acc
     */
    public void create(Account acc) {
        data.add(acc);
    }

    /**
     * Return all Accounts
     *
     * @return
     */
    public ArrayList<Account> readAll() {
        return data;
    }

    /**
     * Return Account
     *
     * @param id
     * @return
     */
    public Account read(int id) {
        return data.get(id);
    }

    /**
     * Update a Account on data
     *
     * @param id
     * @param acc
     */
    public void update(int id, Account acc) {
        data.set(id, acc);
    }

    /**
     * Remove a Account using the ID
     *
     * @param id
     */
    public void delete(int id) {
        data.remove(id);
    }

    /**
     * Remove a Account using a Account Instance
     *
     * @param acc
     */
    public void delete(Account acc) {
        data.remove(acc);
    }


    public static void persist() {
        PersistArrayHandler.save(dataFile, data);
    }


    public static void loadData() {

        ArrayList dataBuffer = (ArrayList<Account>) PersistArrayHandler.read(dataFile);

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
        for (Account a : data) {
            a.print();
        }
    }


}
