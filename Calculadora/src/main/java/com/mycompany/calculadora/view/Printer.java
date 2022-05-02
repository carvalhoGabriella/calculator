/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora.view;

import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Printer {
    public static void initialMessage(){
        System.out.println("Bem vindo a Calculadora");
    }
    
    public static void writeExpression(){
        System.out.println("Escreva a expressão: ");
    }
    
    public static void writeResult(ArrayList result){
        System.out.println("O resultado é: " + result.get(0));
    }
    
    public static void finalMessage(){
        System.out.println("Fechando Calculadora");
    }

    public static void error(Exception e) {
        System.out.println("Error: " + e);
    }
}
