/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.dao;

import com.sg.thevendingmachine.dto.Inventory;
import java.util.List;



/**
 *
 * @author travi
 */
public interface VendingMachineDao {
    
    public Inventory addInventory(String itemName, Inventory inventory)
            throws VendingMachinePersistenceException;
     
     public List<Inventory> getAllInventory()
            throws VendingMachinePersistenceException;
    
    public Inventory getInventory(String itemName)
            throws VendingMachinePersistenceException;
    
    public Inventory removeInventory(String itemName)
            throws VendingMachinePersistenceException; 
    
    public void loadInventory() throws 
            VendingMachinePersistenceException;
    
    public void writeInventory() throws 
            VendingMachinePersistenceException;
}
