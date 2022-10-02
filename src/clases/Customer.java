/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import utility.Util;


/**
 *
 * @author unaib
 */
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private Integer phone;
    private String email;
    private List<Account> accounts;


    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;

    }

    public void setState(String state) {
        this.state = state;
    }


    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> Accounts) {
        this.accounts = Accounts;
    }
    
    public void setDatos(int id){
        this.id = id;
        firstName = Util.introducirCadena("Insert the first name of the customer: ");
        lastName = Util.introducirCadena("Insert the last name of the customer: ");
        middleInitial = Util.introducirCadena("Insert the middle initial of the customer: ");
        street = Util.introducirCadena("Insert the street of the customer: ");
        city = Util.introducirCadena("Insert the city of the customer: ");
        state = Util.introducirCadena("Insert the state of the customer: ");
        zip = Util.leerInt("Insert the zip of the customer: ");
        phone = Util.leerInt("Insert the phone of the customer: ");
        email = Util.introducirCadena("Insert the email of the customer: ");
    }
    
    public String getDatos() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", Accounts=" + accounts + '}';

    }

    public void setAccounts(List<Account>[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", accounts=" + accounts + '}';
    }

   

}
