package model.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistArrayHandler {

    private static ObjectOutputStream createBinWriter(File file, boolean append){
        ObjectOutputStream out = null;

        try{

            // Verifica se o arquivo existe, caso exista ele
            // não cria cabelçalho

            if (file.exists()){

                FileOutputStream fos = new FileOutputStream(file, append);

                out = new ObjectOutputStream(fos){
                    @Override
                    protected void writeStreamHeader(){
                        // não escreve o cabeçalho
                    }
                };
            }
            else {
                FileOutputStream fos = new FileOutputStream(file, append);
                out = new ObjectOutputStream(fos);
            }

        }
        catch (IOException e){
            System.out.println(e);
        }
        return out;
    }

    private static ObjectInputStream createBinReader(File file){
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
        }
        catch (IOException e){
            System.out.println(e);
        }

        return ois;
    }

    private static void writeObj(ObjectOutputStream oos, Object obj, boolean flush){
        try{
            oos.writeObject(obj);
            if (flush) oos.flush();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    private static Object readObj(ObjectInputStream ois){
        Object obj = null;
        try {
            obj = ois.readObject();
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
        catch (java.io.EOFException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println("Hello");
            System.out.println(e);
        }
        finally {
            return obj;
        }
    }

    public static void save(File file, List data){
        ObjectOutputStream writer = createBinWriter(file, false);
        writeObj(writer, data, false);
    }

    public static Object read(File file){
        ObjectInputStream reader = createBinReader(file);
        return readObj(reader);
    }

}
