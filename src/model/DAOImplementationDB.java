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
import clases.Movement;;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getInt;


/**
 *
 * @author unaib
 */
public class DAOImplementationDB implements DAO {

    private Connection con;
    private PreparedStatement stmt;
    private ConnectionOpenClose conection = new ConnectionOpenClose();

    @Override
    public void createCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void createCustomerAccount(Customer customer, Account account) throws ExceptionManager {
        
        con = conection.openConnection();
        
        try {
            final String createCustomerAC = "INSERT INTO CUSTOMER VALUES (id, balance, beingBalance, beingBalanceTimestamp, creditLine, description, type) VALUES(?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(createCustomerAC);

            stmt.setDouble(2, account.getBalance());
            stmt.setDouble(3, account.getBeginBalance());

            Timestamp ts = Timestamp.valueOf(account.getBeginBalanceTimestamp().Localdate);
            stmt.setTimestamp(4, ts);

            stmt.setDouble(5, account.getCreditLine());
            stmt.setString(6, account.getDescription());
            
            Account getAccount = null;
            AccountType accountType;
            accountType = null;
            for(AccountType a : AccountType.values()){
                if(a.ordinal() == getInt("type")){
                    accountType = a;
                }
            }
            getAccount.setType(accountType);
            
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e1) {

            String error = "This customer account already exist";
            ExceptionManager uwu = new ExceptionManager(error);
            throw uwu;
        }
    }

    @Override
    public void addClientToAccount(Customer customer, Account account) throws ExceptionManager {       
    }

    @Override
    public Account getAccountData(Account account) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeAccountMovement(Account account, Movement movement) throws ExceptionManager {
       
        con = conection.openConnection();
        
        try {
            final String makeAccountMove = "INSERT INTO CUSTOMER VALUES (id, amount, balance, description, timestamp, account_id) VALUES(?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(makeAccountMove);

            stmt.setDouble(2, movement.getAmount());
            stmt.setDouble(3, movement.getBalance());
            stmt.setString(4, movement.getDescription());
            stmt.setDateTime(5, movement.getTimestamp());
            stmt.setDate(6, movement.account_id());   
            
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e1) {

            String error = "This customer account is replaced";
            ExceptionManager uwu = new ExceptionManager(error);
            throw uwu;
        }
    }

    @Override
    public List<Movement> getAccountMovement(Account account) throws ExceptionManager {
        
        List<Movement> movements = new ArrayList<>();
        Movement getMovement = null;
        ResultSet rs = null;
        Integer accounts_id = account.getId();
        
        con = conection.openConnection();
        String SEARCHMovementsFromAccount = "SELECT movements_id FROM account_movement where accounts_id = ?";
        
        try{
            stmt = con.prepareStatement(SEARCHMovementsFromAccount);
            stmt.setInt(1, accounts_id);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                getMovement.setId(rs.getInt("movements_id"));
                movements.add(getMovement);
            }
            if (rs != null){
                rs.close();
            }
            
            conection.closeConnection(stmt, con);
            
        }catch (SQLException e){
            String msg = "Error en recoger las movemientos";
            ExceptionManager x = new ExceptionManager(msg);
            throw x;
        }
        return movements;
    }
}
