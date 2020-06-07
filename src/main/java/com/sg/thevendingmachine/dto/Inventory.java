/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.dto;

import java.util.Objects;

/**
 *
 * @author travi
 */
public class Inventory {
    
    private String itemName;
    private String itemCost;
    private String numberOfItemsInInventory;
    
    
    public Inventory(String itemName) {
        this.itemName = itemName;
    }    

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getNumberOfItemsInInventory() {
        return numberOfItemsInInventory;
    }

    public void setNumberOfItemsInInventory(String numberOfItemsInInventory) {
        this.numberOfItemsInInventory = numberOfItemsInInventory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.itemName);
        hash = 89 * hash + Objects.hashCode(this.itemCost);
        hash = 89 * hash + Objects.hashCode(this.numberOfItemsInInventory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemCost, other.itemCost)) {
            return false;
        }
        if (!Objects.equals(this.numberOfItemsInInventory, other.numberOfItemsInInventory)) {
            return false;
        }
        return true;
    }
}
