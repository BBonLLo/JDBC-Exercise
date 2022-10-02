/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import utility.Util;

/**
 *
 * @author unaib
 */
public class Movement {

    private Integer id;
    private String description;
    private Double balance;
    private LocalDate timestamp;
    private Double amount;
    

    public Movement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDatos(Double balancesIntro) {
        boolean rigthMovementType = false;

        description = Util.introducirCadena("Write a description of the movement: ");
        balance = balancesIntro;
        amount = Util.leerDouble("Insert the amount to operate with: ");
        do {
            switch (Util.introducirCadena("The movement is a deposit or a withdraw? [dep / with]")) {
                case "dep":
                    balance = balance + amount;
                    rigthMovementType = true;
                    break;
                case "with":
                    balance = balance - amount;
                    rigthMovementType = true;
                    break;
                default:
                    System.out.println("Not valid argument.");
                    break;
            }
        } while (!rigthMovementType);
        timestamp = LocalDate.now();
    }

    public String getDatos() {
        return "Movement{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", timestamp=" + timestamp + ", amount=" + amount + '}';
    }
}
