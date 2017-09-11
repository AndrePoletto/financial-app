package model.dao;

import logic.Account;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class AccountDAO {

    /*
     * Essa class não esta tratando unicidade
     * ou seja se create for usado para objetos q ja estão na lista
     * eles vão estar duplicado e foda se :)
     *
     */

    private static List<Account> data = new ArrayList<Account>();

    public AccountDAO() {
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
    public List readAll() {
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
        File dataDir = new File("../data/");
        File dataFile = new File(dataDir, "account.data");


        FileWriter fw = null;
        try {
            fw = new FileWriter(dataFile, true);
            fw.write("Teste");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void loadData() {
        System.out.println("Reading data ....");
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
