/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptionManager.ExceptionManager;
import clases.Customer;
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
        int id = Util.leerInt("Introduce el ID del customer: ");
        customer.setId(id);
        customer= model.getCustomerData(customer);
        customer.getDatos();
    }

    private static void getCustomerAccounts(DAO model) {
        
    }

    private static void createCustomerAccount(DAO model) {
        
    }

    private static void addClientToAccount(DAO model) {
        
    }

    private static void getAccountData(DAO model) {
        
    }

    private static void makeAccountMovement(DAO model) {
        
    }

    private static void getAccountMovement(DAO model) {
        
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
                    System.out.println("Good bye");
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