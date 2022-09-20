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
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import utility.MyObjectOutputStream;

/**
 *
 * @author unaib, Leire
 */
public class DAOImplementationFich implements DAO{
    String fichero = "bankdb.dat";
    File fich = new File(fichero);
    
    @Override
    public void createCustomer(Customer customer) throws ExceptionManager{
        FileOutputStream fos = null;
        MyObjectOutputStream moos = null;
        ObjectOutputStream oos = null;
        Customer newCustomer = new Customer();
        
        try {
            if (fich.exists()) {
                fos = new FileOutputStream(fich, true);
                moos = new MyObjectOutputStream(fos);
                
                newCustomer = getCustomerData(customer.getId());
                if(newCustomer == null){
                    moos.writeObject(customer);
                }else{
                    
                }
            } 
            else {
                fos = new FileOutputStream(fich);
                oos = new ObjectOutputStream(fos);
            }
            moos.close();
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    @Override
    public Customer getCustomerData(int id) throws ExceptionManager{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getCustomerAccounts(Customer customer) throws ExceptionManager{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCustomerAccount(Customer customer) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addClientToAccount(Customer customer, Account account) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccountData(Account account) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeAccountMovement(Account account, Movement movement) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccountMovement(Account account) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
