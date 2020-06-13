/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.service;

import com.sg.thevendingmachine.dao.VendingMachineAuditDao;
import com.sg.thevendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.sg.thevendingmachine.dao.VendingMachineDao;
import com.sg.thevendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.thevendingmachine.dto.Inventory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author travi
 */
public class VendingMachineServiceLayerTest {
    
    private VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerTest() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
        
        /*VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();        
        service = new VendingMachineServiceLayerImpl(dao, auditDao);
        */
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testCreateInventory() throws Exception {
        Inventory inventory = new Inventory("Skirts");
        inventory.setItemCost("50");
        inventory.setNumberOfItemsInInventory("15");
        service.createInventory(inventory);  
    }

    /**
     * Test of editInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testCreateInventoryDuplicateID() throws Exception {
        Inventory inventory = new Inventory("Bags");
        inventory.setItemCost("50");
        inventory.setNumberOfItemsInInventory("15");       
        try {
            service.createInventory(inventory); 
            fail("Expected VendingMachineDuplicateItemException not thrown");
            } catch (VendingMachineDuplicateItemException e) {
            return;
        }
    }

    /**
     * Test of getAllInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testCreateInventoryInvalidData() throws Exception {
        Inventory inventory = new Inventory("Jeans");
        inventory.setItemCost("");
        inventory.setNumberOfItemsInInventory("15");       
        try {
            service.createInventory(inventory); 
            fail("Expected VendingMachineDataValidationException not thrown");
            } catch (VendingMachineDataValidationException e) {
            return;
        }
    }

    /**
     * Test of getInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllInventory() throws Exception {
        assertEquals(1, service.getAllInventory().size());
    }

    /**
     * Test of removeInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetInventory() throws Exception {
        Inventory inventory = service.getInventory("Bags");
        assertNotNull(inventory);
        
        inventory = service.getInventory("None");
        assertNull(inventory);
    }

    /**
     * Test of validateItemInInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testRemoveInventory() throws Exception {
        Inventory inventory = service.removeInventory("Bags");
        assertNotNull(inventory);
        
        inventory = service.removeInventory("None");
        assertNull(inventory);
    }

    /**
     * Test of validatePrice method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testValidateItemInInventory() throws Exception {
        
        try {
            service.validateItemInInventory(0, "Chips");
            fail("Expected VendingMachineNoItemInventoryException; not thrown");
            } catch (VendingMachineNoItemInventoryException e) {
            return;
        }
    }
    
    
    /**
     * Test of validatePrice method, of class VendingMachineServiceLayer.
     */
    @Test // -- BuSINESS LOGIC --
    private void testValidatePrice() throws Exception {
             
        try {
            service.validatePrice(.50);            
            fail("Expected VendingMachineInsufficientFundsException; not thrown");
            } catch (VendingMachineInsufficientFundsException e) {
            return;
            }                      
    }    

        
    
}
