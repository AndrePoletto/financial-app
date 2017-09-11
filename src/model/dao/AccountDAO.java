package model.dao;

import model.logic.Account;

import java.io.*;
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

        File dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        File dataFile = new File(dataDir, "account.db");

        try {
            FileWriter db = new FileWriter(dataFile, false);

            // Write head
            db.write("name,iconLetters,note,value,situation\n");

            // Write Data
            for(Account a : data){
                db.append(a.getCsvFormat());
            }

            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void loadData() {
        File dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        File dataFile = new File(dataDir, "account.db");


        try {
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader db = new BufferedReader(fileReader);

            // Step header
            db.readLine();

            // Read data and load to data:List
            while (db.ready()){
                /*
                * Here we read a line from the file
                * and split using , then instantiate
                * a Account and add to data:List
                */

                String line = db.readLine();
                String[] splitedLine = line.split(",");

                Account acc = new Account();

                acc.setName(splitedLine[0]);
                acc.setIconLetters(splitedLine[1]);
                acc.setNote(splitedLine[2]);
                acc.setValue(Float.valueOf(splitedLine[3]));
                acc.setSituation(Boolean.valueOf(splitedLine[4]));

                data.add(acc);
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
        for (Account a : data) {
            a.print();
        }
    }


}
