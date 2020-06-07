/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.dao;

import com.sg.thevendingmachine.dto.Inventory;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author travi
 */
public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        List<Inventory>inventoryList = dao.getAllInventory();
        for (Inventory inventory : inventoryList){
            dao.removeInventory(inventory.getItemName());       
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addInventory method, of class VendingMachineDao.
     */
    @Test
    public void testAddInventory() throws Exception {
        Inventory inventory = new Inventory("Shoes");
        inventory.setItemCost("50");
        inventory.setNumberOfItemsInInventory("12");
       
        dao.addInventory(inventory.getItemName(), inventory);
        Inventory fromDao = dao.getInventory(inventory.getItemName());
        assertEquals(inventory, fromDao); 
    }

    /**
     * Test of getAllInventory method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveInventory() throws Exception {
        Inventory inventory2 = new Inventory("Shirts");
        inventory2.setItemCost("50");
        inventory2.setNumberOfItemsInInventory("12");       
        dao.addInventory(inventory2.getItemName(), inventory2);
        
        Inventory inventory3 = new Inventory("Belts");
        inventory3.setItemCost("50");
        inventory3.setNumberOfItemsInInventory("12");       
        dao.addInventory(inventory3.getItemName(), inventory3);
        
        dao.removeInventory(inventory2.getItemName());
        assertEquals(1, dao.getAllInventory().size());
        assertNull(dao.getInventory(inventory2.getItemName()));
        
        dao.removeInventory(inventory3.getItemName());
        assertEquals(0, dao.getAllInventory().size());
        assertNull(dao.getInventory(inventory3.getItemName()));
        
    }

    /**
     * Test of getInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllInventory() throws Exception {
        Inventory inventory = new Inventory("Shoes");
        inventory.setItemCost("50");
        inventory.setNumberOfItemsInInventory("12");       
        dao.addInventory(inventory.getItemName(), inventory);
        
        inventory = new Inventory("Pants");
        inventory.setItemCost("50");
        inventory.setNumberOfItemsInInventory("12");       
        dao.addInventory(inventory.getItemName(), inventory);
        
        assertEquals(2, dao.getAllInventory().size());
        
    }

    /**
     * Test of removeInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetInventory() throws Exception {
       // This test is part of the "addInventory" test.         
    }

       
    
}
