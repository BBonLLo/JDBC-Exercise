/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ExceptionManager.ExceptionManager;
import clases.*;

/**
 *
 * @author unaib
 */
public interface DAO {

    public void createCustomer(Customer customer)throws ExceptionManager;

    public Customer getCustomerData(Customer customer)throws ExceptionManager;

    public Account getCustomerAccounts(Customer customer)throws ExceptionManager;

    public void createCustomerAccount(Customer customer) throws ExceptionManager;

    public void addClientToAccount(Customer customer, Account account) throws ExceptionManager;

    public Account getAccountData(Account account) throws ExceptionManager;

    public void makeAccountMovement(Account account, Movement movement) throws ExceptionManager;

    public Account getAccountMovement(Account account) throws ExceptionManager;

}
