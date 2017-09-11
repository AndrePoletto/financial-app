package model.dao;

import logic.Transaction;

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

    private static List<Transaction> data = new ArrayList<Transaction>();

    public TransactionDAO() {
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

        File dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        File dataFile = new File(dataDir, "transaction.db");

        try {
            FileWriter db = new FileWriter(dataFile, false);

            // Write head
            db.write("value, description, category, account, note, date, reminder, consolidate, type\n");

            // Write Data
            for(Transaction t : data){
                db.append(t.getCsvFormat());
            }

            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void loadData() {
        File dataDir = new File("src" + File.separator + "model" + File.separator + "data");
        File dataFile = new File(dataDir, "transaction.db");


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
                * a Transaction and add to data:List
                */

                String line = db.readLine();
                String[] splitedLine = line.split(",");

                Transaction trans = new Transaction();

                trans.setValue(Float.valueOf(splitedLine[0]));
                trans.setDescription(splitedLine[1]);
                trans.setCategory(splitedLine[2]);
                trans.setAccount(splitedLine[3]);
                trans.setNote(splitedLine[4]);
                trans.setDate(LocalDate.parse(splitedLine[5]));
                trans.setReminder(LocalDate.parse(splitedLine[6]));
                trans.setType(splitedLine[7]);

                data.add(trans);
            }


            db.close();
        } catch (IOException e) {
            e.printStackTrace();
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
