package com.ayush.payroll;

class Validation{
    private static Validation obj;
    private Validation(){

    }
    static Validation getInstance(){
        if(obj == null){
            obj = new Validation();
        }
        return obj;
    }
}
public class SingleTon {
    public static void main(String[] args) {
        // Validation v1 = new Validation();
        Validation v1 = Validation.getInstance();
        Validation v2 = Validation.getInstance();
        Validation v3 = Validation.getInstance();
        System.out.println(v1 == v2 && v2 == v3);
        
    }
}
