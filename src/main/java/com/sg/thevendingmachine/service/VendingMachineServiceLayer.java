/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.service;

import com.sg.thevendingmachine.dao.VendingMachinePersistenceException;
import com.sg.thevendingmachine.dto.Inventory;
import java.util.List;



/**
 *
 * @author travi
 */
public interface VendingMachineServiceLayer {
    
    public void createInventory(Inventory inventory) throws            
            VendingMachinePersistenceException, VendingMachineDuplicateItemException,
            VendingMachineDataValidationException;
    
    public void editInventory(Inventory inventory) throws VendingMachinePersistenceException,
            VendingMachineDataValidationException;
 
    public List<Inventory> getAllInventory() throws
            VendingMachinePersistenceException;
 
    public Inventory getInventory(String itemName) throws
            VendingMachinePersistenceException;
 
    public Inventory removeInventory(String itemName) throws
            VendingMachinePersistenceException;
    
   public void validateItemInInventory(int itemsRemaining, String nameOfItem) throws 
        VendingMachinePersistenceException, VendingMachineNoItemInventoryException;
    
    public double validatePrice(double itemPrice) throws 
        VendingMachinePersistenceException, VendingMachineInsufficientFundsException;    
    
    public int auditLog(int itemsRemaining, String nameOfItem, String priceOfItem) 
            throws VendingMachinePersistenceException;        
    
}
