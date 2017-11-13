/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.shoppingcart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adriana
 */
@Entity
@Table(name = "shipping")
public class Shipping {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "amount")
    private int amount;
    
    public Shipping() {
        
    }

    public Shipping(int id, String address, String state) {
        this.id = id;
        this.address = address;
        this.state = state;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }   
    

    @Override
    public String toString() {
        return "Shipping{" + "id=" + id + ", address=" + address + ", state=" + state + '}';
    }  
    
    
}
