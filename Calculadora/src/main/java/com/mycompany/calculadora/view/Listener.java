/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora.view;

import com.mycompany.calculadora.domain.Converter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class Listener {

    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> expression() {
        try {
            Printer.writeExpression();

            String expressionText = getString();

            ArrayList<String> expressionList = Converter.convertToList(expressionText);

            return expressionList;
        } catch (Exception e) {
            return expression();
        }
    }

    public static String getString() {
        try {
            String value = scanner.nextLine();
            return value;
        } catch (Exception err) {
            return getString();
        }
    }
    
    public static char getChar() {
        try {
            char value = scanner.next().charAt(0);
            return value;
        } catch (Exception err) {
            return getChar();
        }
    }

    public static char anotherExpression() {  
        try {
            System.out.println("Gostaria de realizar outra conta? (N: Não / S: Sim)");
            char value = scanner.next().charAt(0);
            return value;
        } catch (Exception err) {
            return getChar();
        }
    }
}
