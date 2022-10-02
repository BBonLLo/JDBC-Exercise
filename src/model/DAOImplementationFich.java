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
import utils.Util;

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
        customer.setId(Util.calculoFichero(fichCustomer));

        try {
            if (fichCustomer.exists()) {
                fos = new FileOutputStream(fichCustomer, true);
                moos = new MyObjectOutputStream(fos);

                newCustomer = getCustomerData(customer);
                if (newCustomer == null) {
                    moos.writeObject(customer);
                } else {
                    ExceptionManager e = new ExceptionManager("The user exist");
                    throw e;
                }
            } else {
                fos = new FileOutputStream(fichCustomer);
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
    public Customer getCustomerData(Customer customer) throws ExceptionManager {

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
        File fichCustomer2 = new File("bankdbCustomer2.dat");
        FileOutputStream fosC = null;
        ObjectInputStream oisC = null;
        FileInputStream fisC = null;
        ObjectOutputStream oosC = null;
        FileOutputStream fosA = null;
        MyObjectOutputStream moosA = null;
        ObjectOutputStream oosA = null;
        List<Account> accounts = new ArrayList<>(customer.getAccounts());
        Customer auxCustomer = new Customer();

        try {
            if (fichCustomer.exists() && fichAccount.exists()) {
                fosC = new FileOutputStream(fichCustomer2);
                oosC = new ObjectOutputStream(fosC);
                fisC = new FileInputStream(fichCustomer);
                oisC = new ObjectInputStream(fisC);
                fosA = new FileOutputStream(fichAccount, true);
                moosA = new MyObjectOutputStream(fosA);

                int count = Util.calculoFichero(fichCustomer);
                for (int i = 0; i < count; i++) {
                    auxCustomer = new Customer();
                    auxCustomer = (Customer) oisC.readObject();
                    if (auxCustomer.getId() == customer.getId()) {
                        accounts.add(account);
                        customer.setAccounts(accounts);
                        oosC.writeObject(customer);

                    } else {
                        oosC.writeObject(auxCustomer);
                    }
                }

                moosA.writeObject(account);

                fichCustomer.delete();
                fichCustomer2.renameTo(fichCustomer);

            } else {
                fosC = new FileOutputStream(fichCustomer);
                oosC = new ObjectOutputStream(fosC);
                fosA = new FileOutputStream(fichAccount);
                oosA = new ObjectOutputStream(fosA);

                accounts.add(account);
                customer.setAccounts(accounts);
                oosC.writeObject(customer);
                oosA.writeObject(account);
            }
            oosC.close();
            fosC.close();
            oisC.close();
            fisC.close();
            moosA.close();
            oosA.close();
            fosA.close();
        } catch (FileNotFoundException cex) {
            ExceptionManager e = new ExceptionManager("The file doesn't exist");
            throw e;
        } catch (IOException ex) {
            ExceptionManager e = new ExceptionManager("Don't work");
            throw e;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOImplementationFich.class.getName()).log(Level.SEVERE, null, ex);
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

        if (fichAccount.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fichAccount);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fichAccount);

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
        FileOutputStream fosM1;
        FileOutputStream fosM2;
        ObjectOutputStream oos;
        MyObjectOutputStream moosM1;
        ObjectOutputStream oosM2;
        FileInputStream fis;
        ObjectInputStream ois;
        Account auxAccount = new Account();
        int lengthFichCustomer = Util.calculoFichero(fichAccount);
        boolean changes = false;
        boolean exists = false;

        try {
            fos = new FileOutputStream(fichAccount2);
            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream(fichAccount);
            ois = new ObjectInputStream(fis);
            fosM1 = new FileOutputStream(fichMovement, true);
            fosM2 = new FileOutputStream(fichMovement, true);
            moosM1 = new MyObjectOutputStream(fosM1);
            oosM2 = new ObjectOutputStream(fosM2);

            int count = Util.calculoFichero(fichAccount);

            if (fichAccount.exists()) {
                accountMovements.add(movement);
                for (int i = 0; i < count; i++) {
                    auxAccount = new Account();
                    auxAccount = (Account) ois.readObject();
                    if (auxAccount.getId() == account.getId()) {
                        auxAccount.setMovements(accountMovements);
                        oos.writeObject(auxAccount);
                    } else {
                        oos.writeObject(auxAccount);
                    }
                }
                changes = true;
                if (fichMovement.exists()) {
                    moosM1.writeObject(movement);
                } else {
                    oosM2.writeObject(movement);
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
            ExceptionManager e = new ExceptionManager("The file doesn't exist");
            throw e;
        } catch (ClassNotFoundException ex) {
            ExceptionManager e = new ExceptionManager("Class not found");
            throw e;
        } catch (IOException ex) {
            ExceptionManager e = new ExceptionManager("Don't work");
            throw e;
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

        if (fichAccount.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(fichAccount);
                ois = new ObjectInputStream(fis);

                int count = Util.calculoFichero(fichAccount);

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
