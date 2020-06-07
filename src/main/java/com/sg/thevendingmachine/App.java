/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine;

import com.sg.thevendingmachine.controller.VendingMachineController;
import com.sg.thevendingmachine.dao.VendingMachineAuditDao;
import com.sg.thevendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.sg.thevendingmachine.dao.VendingMachineDao;
import com.sg.thevendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.thevendingmachine.dao.VendingMachinePersistenceException;
import com.sg.thevendingmachine.dto.Change;
import com.sg.thevendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.thevendingmachine.service.VendingMachineNoItemInventoryException;
import com.sg.thevendingmachine.service.VendingMachineServiceLayer;
import com.sg.thevendingmachine.service.VendingMachineServiceLayerImpl;
import com.sg.thevendingmachine.ui.UserIO;
import com.sg.thevendingmachine.ui.UserIOConsoleImpl;
import com.sg.thevendingmachine.ui.VendingMachineView;



/**
 *
 * @author travi
 */
public class App {
    
    public static void main(String[] args) throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException, VendingMachineInsufficientFundsException {
            //VendingMachineNoItemInventoryException, VendingMachineInsufficientFundsException {
        
        UserIO myIO = new UserIOConsoleImpl();
        Change myChange = new Change();
        VendingMachineView myView = new VendingMachineView(myIO, myChange);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        VendingMachineController controller = 
                new VendingMachineController(myService, myView);        
       controller.run();
       controller.productMenu();
        
    }
}
