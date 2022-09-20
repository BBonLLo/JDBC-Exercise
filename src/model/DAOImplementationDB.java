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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author unaiz
 */
public class DAOImplementationDB implements DAO {
    private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();
    
    /**
     *
     * @param customer
     * @throws ExceptionManager
     */
    @Override
    public void createCustomer(Customer customer)throws ExceptionManager {
  
        	// Abrimos la conexiï¿½n
		con = conection.openConnection();
        try{        
        final String createCustomerSQL = "INSERT INTO CUSTOMER VALUES (id, city, email, firstName, lastName, middleInitial, phone, state, street, zip) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(createCustomerSQL);
			stmt.setString(2, customer.getCity());
			stmt.setString(3, customer.getEmail());
			stmt.setString(4, customer.getFirstName());
			stmt.setString(5, customer.getLastName());
			stmt.setString(6, customer.getMiddleInitial());
			stmt.setInt(7, customer.getPhone());
			stmt.setString(8, customer.getState());
			stmt.setString(9, customer.getStreet());
                        stmt.setInt(10, customer.getZip());
                        
                        
                        
                        stmt.executeUpdate();
			stmt.close();

        } catch (SQLException e1) {

			String error = "This customer already exist";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
    }

    @Override
    public Customer getCustomerData(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getCustomerAccounts(Customer customer) {
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
