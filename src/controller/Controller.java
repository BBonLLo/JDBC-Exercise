/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clases.Account;
import exceptionManager.ExceptionManager;
import clases.Customer;
import clases.Movement;
import java.io.File;
import model.DAO;
import utils.Util;

/**
 *
 * @author unaiz
 */
public class Controller {

    private static void createCustomer(DAO model) throws ExceptionManager {
        Customer customer = new Customer();
        customer.setDatos(0);
        model.createCustomer(customer);
    }

    private static void getCustomerData(DAO model) throws ExceptionManager {
        Customer customer = new Customer();
        int id = Util.leerInt("Enter the customer ID: ");
        customer.setId(id);
        customer = model.getCustomerData(customer);
        customer.getDatos();
    }

    //TODO corregir
    private static void getCustomerAccounts(DAO model) throws ExceptionManager {
        Customer customer = new Customer();
        int id = Util.leerInt("Enter the customer ID: ");
        customer.setId(id);
        customer = (Customer) model.getCustomerAccounts(customer);
        customer.getDatos();
    }

    //TODO :-:
    private static void createCustomerAccount(DAO model) throws ExceptionManager {
        Customer customer = new Customer();
        Account account = new Account();
        int id = Util.leerInt("Enter the customer ID: ");
        customer.setId(id);

    }

    //TODO :-:
    private static void addClientToAccount(DAO model) throws ExceptionManager {
        Customer customer = new Customer();
        Account account = new Account();
    }

    //TODO corregir
    private static void getAccountData(DAO model) throws ExceptionManager {
        Account account = new Account();
        account = model.getAccountData(account);
        account.getDatos();
    }

    //TODO :-:
    private static void makeAccountMovement(DAO model) throws ExceptionManager {
        Account account = new Account();
        Movement movement = new Movement();

    }

    //TODO corregir
    private static void getAccountMovement(DAO model) throws ExceptionManager {
        Account account = new Account();
        account = (Account) model.getAccountMovement(account);
        account.getDatos();
    }

    public void run(DAO model) throws ExceptionManager {

        int opt;
        do {
            opt = menuListadosEnunciado();
            switch (opt) {
                case 1:
                    createCustomer(model);
                    break;

                case 2:
                    getCustomerData(model);
                    break;

                case 3:
                    getCustomerAccounts(model);
                    break;

                case 4:
                    createCustomerAccount(model);
                    break;

                case 5:
                    addClientToAccount(model);
                    break;

                case 6:
                    getAccountData(model);
                    break;

                case 7:
                    makeAccountMovement(model);
                    break;

                case 8:
                    getAccountMovement(model);
                    break;

                case 9:
                    break;
            }
        } while (opt != 9);
    }

    private static int menuListadosEnunciado() {
        System.out.println("1: Create customer.\n\t"
                + "2: Get customer data.\n\t"
                + "3: Get customer account.\n\t"
                + "4: Create customer account.\n\t"
                + "5: Add client to account.\n\t"
                + "6: Get account data.\n\t"
                + "7: Make account movement.\n\t"
                + "8: Get account movement.\n\t"
                + "9: Leave.\n\t");
        return Util.leerInt("Introduce un número del 1 al 9: ", 1, 9);
    }
}
