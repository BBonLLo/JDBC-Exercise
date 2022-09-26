/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ExceptionManager.ExceptionManager;
import clases.Account;
import clases.Customer;
import clases.Movement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import utility.MyObjectOutputStream;
import utility.Util;

/**
 *
 * @author unaib, Leire
 */
public class DAOImplementationFich implements DAO {

    String fichero = "bankdb.dat";
    File fich = new File(fichero);

    @Override
    public void createCustomer(Customer customer) throws ExceptionManager {
        FileOutputStream fos = null;
        MyObjectOutputStream moos = null;
        ObjectOutputStream oos = null;
        Customer newCustomer = new Customer();

        try {
            if (fich.exists()) {
                fos = new FileOutputStream(fich, true);
                moos = new MyObjectOutputStream(fos);

                newCustomer = getCustomerData(customer.getId());
                if (newCustomer == null) {
                    moos.writeObject(customer);
                } else {
                    ExceptionManager e = new ExceptionManager("The user exist");
                    throw e;
                }
            } else {
                fos = new FileOutputStream(fich);
                oos = new ObjectOutputStream(fos);
            }
            moos.close();
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            ExceptionManager e = new ExceptionManager("The file doesn't exist");
            throw e;
        } catch (IOException ex) {
            ExceptionManager e = new ExceptionManager("Don't work");
            throw e;
        }
    }

    @Override
    public Customer getCustomerData(int id) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getCustomerAccounts(Customer customer) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCustomerAccount(Customer customer, Account account) throws ExceptionManager {
        FileOutputStream fos = null;
        MyObjectOutputStream moos = null;
        ObjectOutputStream oos = null;
        List<Account> accounts = new ArrayList<Account>();

        try {
            if (fich.exists()) {
                fos = new FileOutputStream(fich, true);
                moos = new MyObjectOutputStream(fos);

                accounts = getCustomerAccounts(customer);
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getId() == account.getId()) {
                        ExceptionManager e = new ExceptionManager("The account exist");
                        throw e;
                    } else {
                        moos.writeObject(account);
                    }
                }
            } else {
                fos = new FileOutputStream(fich);
                oos = new ObjectOutputStream(fos);
            }
            moos.close();
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            ExceptionManager e = new ExceptionManager("The file doesn't exist");
            throw e;
        } catch (IOException ex) {
            ExceptionManager e = new ExceptionManager("Don't work");
            throw e;
        }
    }

    @Override
    public void addClientToAccount(Customer customer, Account account) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccountData(Account account) throws ExceptionManager {
        Account newAccount = null;

        if (fich.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fich);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fich);

                for (int i = 0; i < count; i++) {
                    newAccount = new Account();
                    newAccount = (Account) ois.readObject();

                    if (newAccount.getId() == account.getId()) {
                        return newAccount;
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
        } else {
            ExceptionManager e = new ExceptionManager("The file doesn't exist");
            throw e;
        }
        return newAccount;
    }

    @Override
    public void makeAccountMovement(Account account, Movement movement) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movement> getAccountMovement(Account account) throws ExceptionManager {
        Account newAccount = null;
        List<Movement> movements = new ArrayList<>();

        if (fich.exists()) {
           FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fich);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fich);

                for (int i = 0; i < count; i++) {
                    newAccount = new Account();
                    newAccount = (Account) ois.readObject();

                    if (newAccount.getId() == account.getId()) {
                        movements = newAccount.getMovements();
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
        } else {
            ExceptionManager e = new ExceptionManager("The file doesn't exist");
            throw e;
        }
        return movements;
    }
}
