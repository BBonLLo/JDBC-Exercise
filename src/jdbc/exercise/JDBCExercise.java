/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.exercise;
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAOFactory;

/**
 *
 * @author unaib
 */
public class JDBCExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            new Controller().run(DAOFactory.getModel());
        }  catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        
        
    }
    
}
