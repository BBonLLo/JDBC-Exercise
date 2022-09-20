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
import java.io.ObjectInputStream;

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
        if (fich.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            Customer newCustomer = new Customer();

        } else {

        }
        return null;
    }

    @Override
    public Account getCustomerAccounts(Customer customer) throws ExceptionManager {
        if (fich.exists()) {

        } else {

        }
        return null;
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
