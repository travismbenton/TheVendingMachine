/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.dao;

import com.sg.thevendingmachine.dto.Inventory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



/**
 *
 * @author travi
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao{
    
   Map<String, Inventory> inventoryMap = new HashMap<>();
    
    public static final String THEINVENTORY_FILE = "theinventory.txt";
    public static final String DELIMITER = "::";
    

    @Override
    public Inventory addInventory(String itemName, Inventory inventory) 
        throws VendingMachinePersistenceException{
        Inventory newInventory = inventoryMap.put(itemName, inventory);
        writeInventory();
        return newInventory;
    }
    
    @Override
    public List<Inventory> getAllInventory() 
        throws VendingMachinePersistenceException{
        loadInventory();
        return new ArrayList<Inventory>(inventoryMap.values());
    }
    
    @Override
    public Inventory getInventory(String itemName) 
        throws VendingMachinePersistenceException{
        loadInventory();
        return inventoryMap.get(itemName);
    }
    
    @Override
    public Inventory removeInventory(String itemName) 
        throws VendingMachinePersistenceException{
        Inventory removeInventory = inventoryMap.remove(itemName); 
        writeInventory();
        return removeInventory;
    }
    
    
    
    // -- LOAD - ROSTER --
   @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        
        try {            
            scanner = new Scanner(
                    new BufferedReader(
                        new FileReader(THEINVENTORY_FILE)));
        } catch (FileNotFoundException e){
            throw new VendingMachinePersistenceException(
                    "-_- Could not load vending data into memory", e);
        }
        
        String currentLine;
        String[] currentTokens;        
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);           
            
            Inventory currentInventory = new Inventory(currentTokens[0]);            
	    currentInventory.setItemCost(currentTokens[1]);
	    currentInventory.setNumberOfItemsInInventory(currentTokens[2]);
            
            inventoryMap.put(currentInventory.getItemName(), currentInventory);           
        }
        scanner.close(); 
        
    } // -- loadRoster() --  

    
    
    // -- WRITE - ROSTER --
   @Override
    public void writeInventory() throws VendingMachinePersistenceException {
	    
	    PrintWriter out;
	    
	    try {                
	        out = new PrintWriter(new FileWriter(THEINVENTORY_FILE));
	    } catch (IOException e) {
	        throw new VendingMachinePersistenceException(
	                "Could not save vending data.", e);
	    }	    
	    
	    List<Inventory> inventoryList = this.getAllInventory();
	    for (Inventory currentInventory : inventoryList) {
	        // write the Inventory object to the file
	        out.println(currentInventory.getItemName() + DELIMITER
	                + currentInventory.getItemCost() + DELIMITER 
	                + currentInventory.getNumberOfItemsInInventory());
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
            
    } // -- writeRoster() --
    
    
}

    

