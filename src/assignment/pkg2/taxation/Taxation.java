/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment.pkg2.taxation;

/**
 *
 * @author almuk
 */

/**
 * CSCI1130 Java Assignment 2 Taxation
 *
 * Remark: Name your class, variables, methods, etc. properly.
 * You should write comment for your work and follow good styles.
 *
 * I declare that the assignment here submitted is original except for source
 * material explicitly acknowledged, and that the same or closely related
 * material has not been previously submitted for another course. I also
 * acknowledge that I am aware of University policy and regulations on honesty
 * in academic work, and of the disciplinary guidelines and procedures
 * applicable to breaches of such policy and regulations, as contained in the
 * website.
 *
 * University Guideline on Academic Honesty:
 * http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 * https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Student Name: Mitul Mohammad Abdullah Al Mukit
 * Student ID : 1155165211
 * Date : 6/10/2022
 */

import java.util.Scanner;

public class Taxation {
// package and class declaration
 // starting point of the program
 public static void main(String[] args) {
 // create a new Scanner object, named keyboard
 Scanner keyboard = new Scanner(System.in);
 
 System.out.print("Total Income: $");
 double totalIncome = keyboard.nextDouble();
 if (Math.signum(totalIncome) < 0){
     System.out.println("Invalid Input!");
     System.exit(0);
 }
 
 System.out.print("Deductions: $");
 double deductions = keyboard.nextDouble();
  if (Math.signum(deductions) < 0){
     System.out.println("Invalid Input!");
     System.exit(0);
 }
  
 System.out.print("Allowances: $");
 double allowances = keyboard.nextDouble();
  if (Math.signum(allowances) < 0){
     System.out.println("Invalid Input!");
     System.exit(0);
 }

 double netIncome = totalIncome - deductions;
 double netChargableIncome = netIncome - allowances;
 
 // Progressive Tax
 double[] taxChargingRate = new double[]{0.02 ,0.06,0.1,0.14}; 
 double progressiveTaxAmount = 0;
 for (int i=0; i <=3; i++) {
     if (netChargableIncome >= 50000){
        progressiveTaxAmount = progressiveTaxAmount+ 50000 * taxChargingRate[i];
        netChargableIncome = netChargableIncome -50000;
     } else {
             if (i != 3){
             progressiveTaxAmount = progressiveTaxAmount + netChargableIncome*taxChargingRate[i];
             break;
             }
             }
     if (i == 3){
         progressiveTaxAmount = progressiveTaxAmount + netChargableIncome * 0.17;
     }
 
 }
 System.out.print("Progressive Tax= $");
  System.out.printf("%.1f\n",progressiveTaxAmount);
 
 //Standard Tax
 double standardTax = netIncome*0.15;
 System.out.print("Standard Tax= $");
  System.out.printf("%.1f\n",standardTax);
 
 //Amount of Salaries Tax
 double salariesTax = Math.min(progressiveTaxAmount,standardTax);
 System.out.print("Amount of Salaries Tax = $");
 System.out.printf("%.1f\n",salariesTax);
 
 //Final Salaries Tax Payable
 if (salariesTax >= 10000){
     salariesTax = salariesTax - 10000;
 }
 System.out.print("Final Salaries Tax Payable = $");
 System.out.printf("%.1f\n",salariesTax);
 } 
    
}
