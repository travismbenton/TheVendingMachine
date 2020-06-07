/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.dao;

import com.sg.thevendingmachine.dto.Inventory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author travi
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{  
    
    Inventory onlyInventory;
    List<Inventory> inventoryList = new ArrayList<>();
    
    // -- CONSTRUCTOR --     
    public VendingMachineDaoStubImpl(){
        onlyInventory = new Inventory("Bags");
        onlyInventory.setItemCost("300");
        onlyInventory.setNumberOfItemsInInventory("5");
        
        inventoryList.add(onlyInventory);
        
    }
    // -- "END" CONSTRUCTOR --

    @Override
    public Inventory addInventory(String itemName, Inventory inventory) throws VendingMachinePersistenceException {
        //If you add a student that has an existing Id, it will return that student.
        //If you add a student without and existing Id, return null.
        if (itemName.equals(onlyInventory.getItemName())){
            return onlyInventory;
        } else {
            return null;
        }
        
    }

    @Override
    public List<Inventory> getAllInventory() throws VendingMachinePersistenceException {
        //Return the student list
        return inventoryList;
    }

    @Override
    public Inventory getInventory(String itemName) throws VendingMachinePersistenceException {
        if (itemName.equals(onlyInventory.getItemName())){
            return onlyInventory;
        } else {
            return null;
        }
    }

    @Override
    public Inventory removeInventory(String itemName) throws VendingMachinePersistenceException {
        //If you try to remove a student that has an existing Id, it will return that student.
        //If you try to remove a student without an existing Id, return null.
        if (itemName.equals(onlyInventory.getItemName())){
            return onlyInventory;
        } else {
            return null;
        }
    }

    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
