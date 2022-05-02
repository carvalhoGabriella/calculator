/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

import com.mycompany.calculadora.view.Listener;
import com.mycompany.calculadora.view.Printer;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Main {

    public static void main(String[] args) {
        Printer.initialMessage();

        calculate();

        Printer.finalMessage();
    }

    public static void calculate() {
        boolean retry = true;
        
        /*do {*/
            ArrayList<String> expression = Listener.expression();

            for (int i = 1; i < expression.size(); i = i + 2) {
                if (expression.get(i).charAt(0) == '*' || expression.get(i).charAt(0) == '/') {
                    float number1 = Float.parseFloat(expression.get(i - 1));
                    float number2 = Float.parseFloat(expression.get(i + 1));
                    float res = 0;

                    switch (expression.get(i).charAt(0)) {
                        case '*':
                            res = number2 * number1;
                            break;
                        case '/':
                            res = number1 / number2;
                            break;
                    }

                    expression.set(i - 1, Float.toString(res));
                    expression.remove(i + 1);
                    expression.remove(i);

                    i = i - 2;
                }
            }

            for (int i = 1; i < expression.size(); i = i + 2) {
                float number1 = Float.parseFloat(expression.get(i - 1));
                float number2 = Float.parseFloat(expression.get(i + 1));
                float res = 0;

                switch (expression.get(i).charAt(0)) {
                    case '+':
                        res = number2 + number1;
                        break;
                    case '-':
                        res = number1 - number2;
                        break;
                }

                expression.set(i - 1, Float.toString(res));
                expression.remove(i + 1);
                expression.remove(i);

                i = i - 2;
            }

            Printer.writeResult(expression);
            
            /*
            char aux = Listener.anotherExpression();
            if (aux == 'N') {
                retry = false;
            } else {
                retry = true;
            }
        } while(retry == true);
            */
    }
}
