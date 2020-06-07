/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thevendingmachine.dto;

/**
 *
 * @author travi
 */
public class Change {
    
    private double pennies = .01;
    private double nickels = .05;
    private double dimes = .10;
    private double quarters = .25;

    public double getPennies() {
        return pennies;
    }

    public double getNickels() {
        return nickels;
    }

    public double getDimes() {
        return dimes;
    }

    public double getQuarters() {
        return quarters;
    }

    

      
}
