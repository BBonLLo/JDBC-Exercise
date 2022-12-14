/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author unaib
 */
public class Account {

    private Integer id;
    private String description;
    private Double balance;
    private Double creditLine;
    private Double beginBalance;
    private LocalDate beginBalanceTimestamp;
    private AccountType type;
    private List<Movement>[] movements;
    private List<Customer>[] customers;

    public Account() {
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

    public Double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Double creditLine) {
        this.creditLine = creditLine;
    }

    public Double getBeginBalance() {
        return beginBalance;
    }

    public void setBeginBalance(Double beginBalance) {
        this.beginBalance = beginBalance;
    }

    public LocalDate getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(LocalDate beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public List<Movement>[] getMovements() {
        return movements;
    }

    public void setMovements(List<Movement>[] movements) {
        this.movements = movements;
    }

    public List<Customer>[] getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer>[] customers) {
        this.customers = customers;
    }

    public String getDatos() {
        return "Account{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", creditLine=" + creditLine + ", beginBalance=" + beginBalance + ", beginBalanceTimestamp=" + beginBalanceTimestamp + ", type=" + type + ", movements=" + movements + ", customers=" + customers + '}';
    }
}
