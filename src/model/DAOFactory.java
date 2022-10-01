/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ResourceBundle;

/**
 *
 * @author unaiz
 */
public class DAOFactory {
      private static DAO data;

    /**
     * Load the data variable, if it is not previously loaded
     * @return data Model
     */
    public static DAO getModel() throws UnknownModelTypeException {

        switch (ResourceBundle.getBundle("JBDC-Ecercise.model/config").getString("MODEL")) {
            case "FILE":
                data = new DAOImplementationFich();
                break;

            case "BD":
                data = new DAOImplementationDB();
                break;
            default:
                throw new UnknownModelTypeException("That type of model is not valid.");
        }

        return data;
    }
}
