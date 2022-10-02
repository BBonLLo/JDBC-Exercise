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
import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.MyObjectOutputStream;
import utility.Util;


/**
 *
 * @author unaib, Leire
 */
public class DAOImplementationFich implements DAO {


    String ficheroCus = "bankdbCustomer.dat";
    File fichCustomer = new File(ficheroCus);
    String ficheroAcc = "bankdbAccount.dat";
    File fichAccount = new File(ficheroAcc);
    String ficheroMov = "bankdbMovement.dat";
    File fichMovement = new File(ficheroMov);

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

        Customer newCustomer = null;

        if (fichCustomer.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fichCustomer);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fichCustomer);

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

        if (fichCustomer.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fichCustomer);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fichCustomer);

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
            ExceptionManager e = new ExceptionManager("The file doesn't exist");
            throw e;
        }
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

        File fichCustomer2 = new File("bankdbCustomer2.dat");
        ArrayList<Account> accountsCustomer = (ArrayList<Account>) getCustomerAccounts(customer);
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        Customer auxCustomer = new Customer();
        int lengthFichCustomer = Util.calculoFichero(fichCustomer);
        boolean changes = false;
        boolean exists = false;

        try {
            fos = new FileOutputStream(fichCustomer2);
            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream(fichCustomer);
            ois = new ObjectInputStream(fis);
            if (fichCustomer.exists()) {
                for (int i = 0; i < accountsCustomer.size(); i++) {
                    if (accountsCustomer.get(i).getId() == account.getId()) {
                        exists = true;
                        ExceptionManager em = new ExceptionManager("The customer has access to the account");
                        throw em;
                    }
                }
                if (!exists) {
                    accountsCustomer.add(account);
                    for (int i = 0; i < lengthFichCustomer; i++) {
                        auxCustomer = new Customer();
                        auxCustomer = (Customer) ois.readObject();
                        if (auxCustomer.getId() == customer.getId()) {
                            oos.writeObject(customer);
                        } else {
                            oos.writeObject(auxCustomer);
                        }
                    }
                    changes = true;
                }
            } else {
                ExceptionManager e = new ExceptionManager("The file doesn't exist");
                throw e;
            }

            ois.close();
            fis.close();
            oos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOImplementationFich.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOImplementationFich.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOImplementationFich.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (changes) {
            fichCustomer.delete();
            fichCustomer2.renameTo(fichCustomer);
        }

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

        File fichAccount2 = new File("bankdbAccount2.dat");
        ArrayList<Movement> accountMovements = (ArrayList<Movement>) getAccountMovement(account);
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        int lengthFichCustomer = Util.calculoFichero(fichAccount);
        boolean changes = false;
        boolean exists = false;

        try {
            fos = new FileOutputStream(fichAccount2);
            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream(fichAccount);
            ois = new ObjectInputStream(fis);
            if (fichAccount.exists()) {
                for (int i = 0; i < accountMovements.size(); i++) {
                    if (accountMovements.get(i).getId() == account.getId()) {
                        exists = true;
                        ExceptionManager em = new ExceptionManager("The customer has access to the account");
                        throw em;
                    }
                }
                if (!exists) {
                    accountMovements.add(movement);
                    for (int i = 0; i < lengthFichCustomer; i++) {
                        oos.writeObject(accountMovements.get(i));
                    }
                    changes = true;
                }
            } else {
                ExceptionManager e = new ExceptionManager("The file doesn't exist");
                throw e;
            }

            ois.close();
            fis.close();
            oos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOImplementationFich.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOImplementationFich.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (changes) {
            fichAccount.delete();
            fichAccount2.renameTo(fichAccount);
        }

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
