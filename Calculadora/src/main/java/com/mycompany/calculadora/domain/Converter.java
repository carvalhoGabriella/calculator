/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora.domain;

import com.mycompany.calculadora.view.Printer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gabri
 */
public class Converter {

    private static final String OPERATORS = "-+/*";
    private static final String OPERANDS = "0123456789";

    public static ArrayList<String> convertToList(String expression) throws Exception {
        try {
            char[] charArray = convertToArray(expression);

            ArrayList<String> treatmentedExpression = treatmentArray(charArray);
            
            //verifyExpression(treatmentedExpression);
            
            return treatmentedExpression;
        } catch (Exception e) {
            Printer.error(e);
            
            throw new Exception(e);
        }
    }

    private static char[] convertToArray(String expression) {
        char[] chars = expression.toCharArray();

        return chars;
    }

    private static ArrayList treatmentArray(char[] expression) throws Exception {
        ArrayList<String> treatmentedExpression = new ArrayList<>();
        int index = 0;

        for (char element : expression) {
            if (isOperand(element)) {
                if (treatmentedExpression.isEmpty()) {
                    treatmentedExpression.add(index, String.valueOf(element));
                    continue;
                }

                if (isOperand(treatmentedExpression.get(index).charAt(0))) {
                    treatmentedExpression.set(index, treatmentedExpression.get(index) + element);
                    continue;
                }

                treatmentedExpression.add(++index, String.valueOf(element));
                continue;
            }

            if (isOperator(element)) {
                if(treatmentedExpression.isEmpty()){
                    treatmentedExpression.add(index, String.valueOf(element));
                    continue;
                }

                treatmentedExpression.add(++index, String.valueOf(element));
            }
        }

        //treatmentedExpression.forEach(System.out::println);

        return treatmentedExpression;
    }
    
    /*
    private static boolean verifyExpression(ArrayList treatmentedExpression) throws Exception{
        System.out.println(treatmentedExpression.get(0).charAt(0));
        if(isOperator(treatmentedExpression.get(0).charAt(0))){
            throw new Exception("Uma operacao nao pode comecar com um operador!");
        }
        
        return true;
    }
    */

    private static boolean isOperator(char val) {
        return OPERATORS.indexOf(val) >= 0;
    }

    private static boolean isOperand(char val) {
        return OPERANDS.indexOf(val) >= 0;
    }

}
