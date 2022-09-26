/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ExceptionManager.ExceptionManager;
import clases.Account;
import clases.AccountType;
import clases.Customer;
import clases.Movement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void createCustomer(Customer customer) throws ExceptionManager {

        // Abrimos la conexiï¿½n
        con = conection.openConnection();
        try {
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
    public Customer getCustomerData(Customer customer) throws ExceptionManager {
        ResultSet rs = null;

        Customer getCustomer = null;

        con = conection.openConnection();
        final String SEARCHcustomer = "SELECT * from customer where id = ?";
        try {
            stmt = con.prepareStatement(SEARCHcustomer);

            stmt.setInt(1, customer.getId());
            rs = stmt.executeQuery();
            if (rs.next()) {
                getCustomer = new Customer();
                getCustomer.setId(rs.getInt("id"));
                getCustomer.setEmail(rs.getString("email"));
                getCustomer.setFirstName(rs.getString("firstName"));
                getCustomer.setLastName(rs.getString("lastName"));
                getCustomer.setPhone(rs.getInt("phone"));
                getCustomer.setState(rs.getString("state"));
                getCustomer.setStreet(rs.getString("street"));
                getCustomer.setZip(rs.getInt("zip"));

            }
            if (rs != null) {
                rs.close();
            }
            conection.closeConnection(stmt, con);
        } catch (SQLException e) {
            String msg = "CANT RECOVER CUSTOMER INFO";
            ExceptionManager x = new ExceptionManager(msg);
            throw x;
        }
        return getCustomer;

    }

    @Override
    public List<Account> getCustomerAccounts(Customer customer) throws ExceptionManager {
        List<Account> accounts = new ArrayList<>();
        Account getAccount = null;
        ResultSet rs = null;
        Customer customers = null;
        Integer customers_id = customer.getId();

        con = conection.openConnection();
        String SEARCHAllAccountsFromCustomer = "SELECT accounts_id FROM customer_account where customers_id = ?";

        try {
            stmt = con.prepareStatement(SEARCHAllAccountsFromCustomer);
            stmt.setInt(1, customers_id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                getAccount.setId(rs.getInt("accounts_id"));

                accounts.add(getAccount);
            }

            if (rs != null) {
                rs.close();
            }
            conection.closeConnection(stmt, con);
        } catch (SQLException e) {
            String msg = "Error en recoger las cuentas";
            ExceptionManager x = new ExceptionManager(msg);
            throw x;
        }

        return accounts;
    }

    @Override
    public void createCustomerAccount(Customer customer, Movement movement) throws ExceptionManager {

    }

    @Override
    public void addClientToAccount(Customer customer, Account account) throws ExceptionManager {

    }

    @Override
    public Account getAccountData(Account account) throws ExceptionManager {
        ResultSet rs = null;
        Account getAccount = null;

        con = conection.openConnection();
        final String SEARCHcustomer = "SELECT * from Account where id = ?";
        try {
            stmt = con.prepareStatement(SEARCHcustomer);

            stmt.setInt(1, account.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                getAccount = new Account();
                getAccount.setId(rs.getInt("id"));
                getAccount.setBalance(rs.getDouble("balance"));
                getAccount.setBeginBalance(rs.getDouble("beginBalance"));
                getAccount.setBeginBalanceTimestamp(rs.getDate("beginBalanceTimpestamp").toLocalDate());
                getAccount.setCreditLine(rs.getDouble("creditLine"));
                getAccount.setDescription(rs.getString("description"));
                AccountType accountType = null;
                for (AccountType a : AccountType.values()) {
                    if (a.ordinal() == rs.getInt("type")) {
                        accountType = a;
                    }
                }
                getAccount.setType(accountType);
            }
            if (rs != null) {
                rs.close();
            }
            conection.closeConnection(stmt, con);
        } catch (SQLException e) {
            String msg = "CANT RECOVER ACCOUNT DATA";
            ExceptionManager x = new ExceptionManager(msg);
            throw x;
        }
        return getAccount;

    }

    @Override
    public void makeAccountMovement(Account account, Movement movement) throws ExceptionManager {

    }

    @Override
    public Account getAccountMovement(Account account) throws ExceptionManager {
        return null;

    }

}
