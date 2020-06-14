/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.advice;

import com.sg.thevendingmachine.dao.VendingMachineAuditDao;
import com.sg.thevendingmachine.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

/**
 *
 * @author travi
 */
public class LoggingAdvice {
    
    VendingMachineAuditDao auditDao;
    
    public LoggingAdvice(VendingMachineAuditDao auditDao){
        this.auditDao = auditDao;
    }
    
     public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
     
//@AfterThrowing(pointcut="execution(* com.sg.thevendingmachine.service.VendingMachineServiceLayer.validatePrice(..))",
        //throwing="error")      
@AfterThrowing(pointcut="execution(* com.sg.thevendingmachine.service.VendingMachineServiceLayer.validatePrice(..), validateItemInInventory(..))",
        throwing="error")            
    public void testAuditEntry(JoinPoint jp, Throwable error) throws Throwable{
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName()+""+error.getMessage();
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        
       try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
