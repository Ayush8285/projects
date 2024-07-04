package com.ayush.payroll;

import java.text.DateFormat;
import java.text.NumberFormat;      //used for currency format
import java.util.Date;
import java.util.Locale;     //it is used for different language access
import java.util.ResourceBundle;
import java.util.Scanner;

public class PayrollApplication {
    static ResourceBundle rb;
    static Locale locale ;   // Member of a class (Class Member Variable) - bind with the class
    
    static void loadBundle(){
        rb =ResourceBundle.getBundle("message", locale);
    }
    static String properCase(String name){
        //rAm KuMar sHarMA
        //names[0] = rAm
        //names[1] = KuMar
        //names[2] = sHarMA
        String fullName = "";
        String names[] = name.split(" ");
        for(int i = 0 ; i < names.length ; i++){
            String n = String.valueOf(names[i].charAt(0)).toUpperCase() +
             names[i].substring(1).toLowerCase();
            fullName = fullName+n+" ";
            // String val = names[i];
            // char firstLetter = val.charAt(0);
            // String firstCapLetter = String.valueOf(firstLetter).toUpperCase();
            // String remName = names[i].substring(1).toLowerCase();
            // String n = firstCapLetter + remName;
            // fullName = fullName+n+" ";
        }
        return fullName;
    }
    static String currencyFormat(double val){
        // 10000.0
        // $10,000 - String
        NumberFormat obj = NumberFormat.getCurrencyInstance(locale);
        return obj.format(val);
    }
    static String dateFormat(){
        //System Date
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,locale);    //FULL,MEDIUM,SHORT,ETC..
        return df.format(date);
    }

    //SRP -> single responsiblility principle
    static void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 for English");
        System.out.println("हिंदी के लिए 2 दबाएँ");
        int choice = scanner.nextInt();
        //ISO code 
        if(choice == 1){
            locale = new Locale("en","US");
        }else if(choice == 2){
            locale = new Locale("hi","IN");
        }else{
            locale = new Locale("en","US");
            System.out.println("Wrong Choice... Taking English as Default");
        }
        loadBundle();
        System.out.println(rb.getString("id.msg"));
        int id = scanner.nextInt();
        scanner.nextLine();     // eat \n
        System.out.println(rb.getString("name.msg"));
        String name = scanner.nextLine();
        System.out.println(rb.getString("salary.msg"));
        double basicSalary = scanner.nextDouble();
        compute(name,basicSalary);
        scanner.close();
    }
    static void compute(String name ,double basicSalary){
        double hra = basicSalary * 0.50;        //50%
        double ta = basicSalary * 0.40;         //40%
        double ma = basicSalary * 0.25;         //25%
        double da = basicSalary * 0.20;         //20%
        double pf = basicSalary * 0.05;         //5%
        double gs = basicSalary + hra + da + ta + ma;
        double tax = computeTax(gs);
        double ns = gs - pf - tax;
        print(name,gs,hra, ta, ma, da, pf,tax,ns);
    }
    static double computeTax(double gs){
        double annual = gs * 12;
        if(annual > 500000 && annual < 700000){
            return (annual * 0.10)/12;           //10%
        }else if(annual > 700000 && annual < 900000){
            return (annual * 0.20)/12;           //20%
        }else if(annual > 900000){
            return (annual * 0.30)/12;           //30%
        }
        return 0.0;
    }
    static void print(String name,double gs,double hra , double ta,double ma,double da,double pf,double tax,double ns){
        System.out.println(rb.getString("date.msg")+dateFormat());
        System.out.println("Emp Name "+properCase(name));
        System.out.println(rb.getString("allowances.msg")+"  \t Deduction");
        System.out.println("HRA "+currencyFormat(hra)+"\t\t PF "+currencyFormat(pf));
        System.out.println("TA  "+currencyFormat(ta)+"\t\t TAX "+currencyFormat(tax));
        System.out.println("MA  "+currencyFormat(ma));
        System.out.println("DA  "+currencyFormat(da));
        System.out.println("GS  "+currencyFormat(gs));
        System.out.println("NS  "+currencyFormat(ns));
    }
    public static void main(String[] args) {
        // PayrollApplication payrollApplication = new PayrollApplication();
        // payrollApplication.input();
        input();
    }
}

