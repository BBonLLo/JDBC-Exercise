/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptionManager.ExceptionManager;
import clases.Account;
import clases.Customer;
import clases.Movement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Util;

/**
 *
 * @author unaib
 */
public class DAOImplementationFich implements DAO {

    String fichero = "bankdb.dat";
    File fich = new File(fichero);

    @Override
    public void createCustomer(Customer customer) throws ExceptionManager {
        if (fich.exists()) {

        } else {

        }
    }

    @Override
    public Customer getCustomerData(int id) throws ExceptionManager {
        Customer newCustomer = null;

        if (fich.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fich);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fich);

                for (int i = 0; i < count; i++) {
                    newCustomer = new Customer();
                    newCustomer = (Customer) ois.readObject();

                    if (newCustomer.getId() == id) {
                        i = count;
                    }
                }

            } catch (FileNotFoundException ex) {
                ExceptionManager e = new ExceptionManager("The file doesn't exist");
                throw e;
            } catch (ClassNotFoundException ex) {
                ExceptionManager e = new ExceptionManager("Class not found");
                throw e;
            } catch (IOException ex) {
                ExceptionManager e = new ExceptionManager("Don't work");
                throw e;
            }
            return newCustomer;

        } else {
            ExceptionManager e = new ExceptionManager("Thhe file doesn't exist");
            throw e;
        }
    }

    @Override
    public List<Account> getCustomerAccounts(Customer customer) throws ExceptionManager {
        List<Account> accounts = new ArrayList<>();
        Customer newCustomer = null;

        if (fich.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fich);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fich);

                for (int i = 0; i < count; i++) {
                    newCustomer = new Customer();
                    newCustomer = (Customer) ois.readObject();

                    if (newCustomer.getId() == customer.getId()) {
                        accounts = newCustomer.getAccounts();
                    }
                }

            } catch (FileNotFoundException ex) {
                ExceptionManager e = new ExceptionManager("The file doesn't exist");
                throw e;
            } catch (ClassNotFoundException ex) {
                ExceptionManager e = new ExceptionManager("Class not found");
                throw e;
            } catch (IOException ex) {
                ExceptionManager e = new ExceptionManager("Don't work");
                throw e;
            }

            return accounts;
        } else {
            ExceptionManager e = new ExceptionManager("Thhe file doesn't exist");
            throw e;
        }
    }

    @Override
    public void createCustomerAccount(Customer customer) throws ExceptionManager {
        if (fich.exists()) {

        } else {

        }
    }

    @Override
    public void addClientToAccount(Customer customer, Account account) throws ExceptionManager {
        if (fich.exists()) {

        } else {

        }
    }

    @Override
    public Account getAccountData(Account account) throws ExceptionManager {
        if (fich.exists()) {

        } else {

        }
        return null;
    }

    @Override
    public void makeAccountMovement(Account account, Movement movement) throws ExceptionManager {
        if (fich.exists()) {

        } else {

        }
    }

    @Override
    public Account getAccountMovement(Account account) throws ExceptionManager {
        if (fich.exists()) {

        } else {

        }
        return null;
    }

}
