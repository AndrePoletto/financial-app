package model.dao;

import logic.Account;

public class Test {
    public static void main(String[] args) {

//        Account acc1 = new Account();
//
//        acc1.setName("Lorem ips cadna asdndflksa ndfl");
//        acc1.setNote("knsdolkanjhsdfklhjasdfnhaios");
//        acc1.setIconLetters("dsfasdfsdfasd");
//        acc1.setSituation(true);
//        acc1.setValue((float) 12.36);
//
//        Account acc2 = new Account();
//
//        acc2.setName("Lorem rola pinto cadna asdndflksa ndfl");
//        acc2.setNote("knsdolkanjhsdfklhjasdfnhaios");
//        acc2.setIconLetters("dsfasdfsdfasd");
//        acc2.setSituation(false);
//        acc2.setValue((float) 158.36);
//
//        AccountDAO dao1 = new AccountDAO();
//
//        dao1.create(acc1);
//        dao1.create(acc2);
//
//        dao1.print();
//
//        AccountDAO dao2 = new AccountDAO();
//
//        Account acc3 = new Account();
//        acc3.setName("Luz");
//        acc3.setNote("knsdolkanjhsdfklhjasdfnhaios");
//        acc3.setIconLetters("dsfasdfsdfasd");
//        acc3.setSituation(true);
//        acc3.setValue((float) 30.36);
//
//        dao2.create(acc3);
//
//        System.out.println("\n\n--------------------\n");
//
//        dao1.print();
//
//        AccountDAO.persist();

        AccountDAO accDAO = new AccountDAO();

        accDAO.print();

    }

}
