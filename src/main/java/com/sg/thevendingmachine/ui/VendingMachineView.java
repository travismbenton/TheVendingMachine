/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.ui;

import com.sg.thevendingmachine.dao.VendingMachinePersistenceException;
import com.sg.thevendingmachine.dto.Change;
import com.sg.thevendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;



/**
 *
 * @author travi
 */
public class VendingMachineView {
    
    private UserIO io;
    Change cents;
    
    // -- CONSTRUCTOR --
    public VendingMachineView(UserIO io, Change cents){
        this.io = io;
        this.cents = cents;
    }
    // -- "END" CONSTRUCTOR --
    
    public int printRunMenuGetUserSelection(){
        
        io.print("Welcome - MAIN MENU");
        io.print("1. Add ");
        io.print("2. Edit ");
        io.print("3. List All ");
        io.print("4. Find ");
        io.print("5. Remove ");        
        io.print("6. Exit");
            
        return io.readInt("Please select from the menue above. ", 1, 6);
    } 
    
    //---------------------------------------------------------| 
    
    public int printProductMenuGetUserSelection() throws VendingMachinePersistenceException {
        
        io.print("Welcome - Vending Mart");
            io.print("1. Chips $.50 ");
            io.print("2. Candy Bar $.75 ");
            io.print("3. Soda $.65 ");
            io.print("4. Sandwich $1.00 ");
            io.print("5. Cookies $1.25 ");
            io.print("6. Exit ");
          
        return io.readInt("Please select item. ", 1, 6);  
    
    }    
    //---------------------------------------------------------|
    
    // -- ERROR MESSAGE SECTION --
    public void displayErrorMessage(String errorMsg) {
	io.print("=== ERROR ===");
	io.print(errorMsg);
    }
    public void displayProductErrorMessage(String errorMsg) {
	io.print("=== Out of stock! ===");
        io.print("* Please make another selection *");
	//io.print(errorMsg);
    }    
    // -- "END" ERROR MESSAGE SECTION --
    
    //---------------------------------------------------------|
    
    // -- Menu Section --
    // -- MENU SECTION --
    public void displayUnknownMenuBanner(){
        io.print("Please select from the menu above.");
    }        
    public void displayExitMenuBanner(){
        io.print("Thank you. Shop again!");
    } 
    public void displayExitRunMenuBanner(){
        io.print("Bye!");
    }
    // -- "END" Menu Section --
    
    // ---------------------------------------------| 
 
    // -- ADD  SECTION --    
    public void displayAddInventoryBanner(){
        io.print("=== Create New Item ===");
    }
    public Inventory getNewInventoryInfo(){
        
        String itemName = io.readString("Please enter Item Name. ");
        String itemCost = io.readString("Please enter Item Price. ");
        String numberOfItemsInInventory = io.readString("Please enter amount in inventory. ");
        
        Inventory currentInventory = new Inventory(itemName);       
        currentInventory.setItemCost(itemCost);
        currentInventory.setNumberOfItemsInInventory(numberOfItemsInInventory);
        return currentInventory;
    }    
    public void displayAddInventorySuccessfulBanner(){
        io.print("=== New Item Created ===");
    }
    // -- "END" ADD  SECTION --
    
    //---------------------------------------------------------|      
        
    // -- EDIT  SECTION --    
     public void displayEditInventoryBanner() {
	    io.print("=== Edit Inventory ===");
    }    
    public void displayEditInventorySuccessfulBanner(){
        io.print("=== Edit Successful ===");
    }  
    public void displayItemToAudit(Inventory item, String nameOfItem){
        if (nameOfItem.equals("Chips")){
            io.print("Item Name: "+item.getItemName());
            io.print("Item Price: $"+item.getItemCost());
            io.print("Item Inventory: "+item.getNumberOfItemsInInventory());
            System.out.println("Item Name: "+item.getItemName());
        } else {
            io.print("What Next?");
        }
    }        
    // -- "END" EDIT  SECTION --
    
    //---------------------------------------------------------|    
        
    // -- LIST  SECTION --    
    public void displayListAllInventoryBanner(){
    io.print("=== List All Items in Inventory ===");
    }   
    public void listAllInventory(List<Inventory> inventoryList){
        for (Inventory currentInventory : inventoryList){
            io.print("Item Name: "+currentInventory.getItemName());
            io.print("Item Price: $"+currentInventory.getItemCost());
            io.print("Item Inventory: "+currentInventory.getNumberOfItemsInInventory());
            io.print("==== NEXT ITEM ====");
        }
        io.readString("Press enter to continue.");
    }
    // -- "END" LIST  SECTION --
    
    //---------------------------------------------------------|
    
    // -- FIND  SECTION --    
    public void displayFindItemBanner(){
        io.print("=== Find Item ===");
    }
    public String getItemChoice(){
        return io.readString("Please select Item Name. ");
    }
    public void displayItem(Inventory item){
        if (item != null){
            io.print("Item Name: "+item.getItemName());
            io.print("Item Price: $"+item.getItemCost());
            io.print("Item Inventory: "+item.getNumberOfItemsInInventory());
        } else {
            io.print("No such \"Item\" exist.");
        }
        io.print("Press enter to continue");
    }      
    // -- "END" FIND  SECTION --
    
    //---------------------------------------------------------| 
        
    // -- REMOVE  SECTION -- 
    public String getItemChoiceToRemove(){
        return io.readString("Please select Item Name to remove. ");
    }
    public void displayItemToRemove(Inventory item){
        if (item != null){
            io.print("Item Name: "+item.getItemName());
            io.print("Item Price: $"+item.getItemCost());
            io.print("Item Inventory: "+item.getNumberOfItemsInInventory());
        } else {
            io.print("No such \"Item\" exist.");
        }
        //io.print("Press enter to continue");
    }
    public void displayRemoveItemSuccessBanner(){
    io.print("=== Item Removed ===");
    }   
    // -- "END" REMOVE  SECTION --
    
    //---------------------------------------------------------|  
    
     
    //---------------------------------------------------------| 
    
    // -- PRODUCT SECTION --
    
    //---------------------------------------------------------| 
    
    
    //---------------------------------------------------------|
     
    // -- CHANGE CALCULATIONS  SECTION --
    public void changeCalculations(double userMoney, double itemPrice) throws 
            VendingMachinePersistenceException{
        double quarter=0, dime=0, nickel=0, pennies=0, change=0;      
        
        if (userMoney == itemPrice){
            io.print("No Change! Thank you for your purchase.");            
            //sc.close();
        } else {
            
        BigDecimal decimalItemPrice = new BigDecimal(Double.toString(itemPrice));    
        BigDecimal decimalUserMoney = new BigDecimal(Double.toString(userMoney));
        BigDecimal decimalChange = new BigDecimal(Double.toString(change));
        BigDecimal decimalQuarter = new BigDecimal(Double.toString(quarter)); 
        BigDecimal decimalDime = new BigDecimal(Double.toString(dime));
        BigDecimal decimalNickel = new BigDecimal(Double.toString(nickel));
        BigDecimal decimalPennies = new BigDecimal(Double.toString(pennies));
        BigDecimal op1 = new BigDecimal(".25");
        BigDecimal op2 = new BigDecimal(".10");
        BigDecimal op3 = new BigDecimal(".05");
        BigDecimal op4 = new BigDecimal(".01");
        BigDecimal decimalGetQuarters = new BigDecimal(Double.toString(cents.getQuarters()));
        BigDecimal decimalGetDimes = new BigDecimal(Double.toString(cents.getDimes()));
        BigDecimal decimalGetNickels = new BigDecimal(Double.toString(cents.getNickels()));
        BigDecimal decimalGetPennies = new BigDecimal(Double.toString(cents.getPennies()));

        
            decimalChange = decimalUserMoney.subtract(decimalItemPrice);
            //System.out.println("Dec.Change Start: "+decimalChange);           
            decimalQuarter = decimalChange.divide(op1, 0, RoundingMode.FLOOR);
            //System.out.println("Dec.Quarter: "+decimalQuarter);
            decimalChange = decimalChange.subtract((decimalQuarter).multiply(decimalGetQuarters));            
            //System.out.println("Dec.Change from Quarter: "+decimalChange);            
            decimalDime = decimalChange.divide(op2, 0, RoundingMode.FLOOR);
            //System.out.println("Dec.Dime: "+decimalDime);
            decimalChange = decimalChange.subtract((decimalDime).multiply(decimalGetDimes));
            //System.out.println("Dec.Change from Dime: "+decimalChange);            
            decimalNickel = decimalChange.divide(op3, 0, RoundingMode.FLOOR);
            decimalChange = decimalChange.subtract((decimalNickel).multiply(decimalGetNickels));            
            decimalPennies = decimalChange.divide(op4, 0, RoundingMode.HALF_UP);            
            
            System.out.println("Change Returned:");
            System.out.println(decimalQuarter + " quarters");
            System.out.println(decimalDime + " dimes");
            System.out.println(decimalNickel + " nickels");
            System.out.println(decimalPennies + " pennies");
            io.print("Thank you for your purchase.");
        
        }  
    }    
    // -- "END" CHANGE CALCULATIONS SECTION --
    
    // ---------------------------------------------|     
      
    // -- PRODUCT SECTION -- 
    public String displayItemName(Inventory item){        
        return item.getItemName();
    }
    public String displayItemPrice(Inventory item){        
        return item.getItemCost();
    }
    public String displayItemsRemaining(Inventory item){        
        return item.getNumberOfItemsInInventory();
    }
    // -- "END" PRODUCT  SECTION --
    
    //---------------------------------------------------------|  
     
     
     
     
     
     
     
     
     
}
