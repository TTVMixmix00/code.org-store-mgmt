package com.jayagra.csa_codeorg_store_mgmt;

import com.jayagra.ansi.Escapes;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.jayagra.type_conversion.ToBoolean;
import com.jayagra.type_conversion.ToInteger;

public class GameLoop {
    public void run(Scanner eee, Order answers[], int i) {
        eee.reset();
        try {
            Order userResponse = new Order();
            System.out.println(Escapes.ANSI_CYAN + "==>\t" + Escapes.ANSI_RESET + "The customer wants " + Escapes.colorString(String.valueOf(answers[i].getQuantity()), Escapes.ANSI_PURPLE) + " " + answers[i].getItem().customerWants());
            switch (i % 3) {
                case 2: {
                    System.out.print("\t\t" + Escapes.ANSI_BLUE + "enter can flavor, followed by sparkling (true/false), and the quantity. (ex. \"unflavored true 1\")\n\t\t" + Escapes.ANSI_RESET);
                    String[] inputs = eee.nextLine().split(" ");
                    userResponse.setItem(new Can(inputs[0], ToBoolean.fromString(inputs[1])));
                    userResponse.setQuantity(ToInteger.fromString(inputs[2]));
                    break;
                }
                case 1: {
                    System.out.print("\t\t" + Escapes.ANSI_BLUE + "enter drink type, followed by hot (true/false), and the quantity. (ex. \"tea true 1\")\n\t\t" + Escapes.ANSI_RESET);
                    String[] inputs = eee.nextLine().split(" ");
                    userResponse.setItem(new Drink(inputs[0], ToBoolean.fromString(inputs[1])));
                    userResponse.setQuantity(ToInteger.fromString(inputs[2]));
                    break;
                }
                case 0: {
                    System.out.print("\t\t" + Escapes.ANSI_BLUE + "enter bread type, followed by the quantity. (ex. \"white 2\")\n\t\t" + Escapes.ANSI_RESET);
                    String[] inputs = eee.nextLine().split(" ");
                    userResponse.setItem(new Bread(inputs[0]));
                    userResponse.setQuantity(ToInteger.fromString(inputs[1]));
                    break;
                }
            }

            final String userRespC = userResponse.getItem().toString() + " " + userResponse.getQuantity();
            final String answerC = answers[i].getItem().toString() + " " + answers[i].getQuantity();
            if (userRespC.equals(answerC)) {
                System.out.println(Escapes.ANSI_GREEN + "==>\t" + "Correct\n\n");
            } else {
                System.out.println(Escapes.ANSI_RED + "==>\t" + "nope- you're fired.");
                throw new StupidException("ya failed");
            }
        } catch(Exception err) {
            if (err instanceof InputMismatchException) {
                System.out.println(Escapes.ANSI_RED + "\n\nYou entered the wrong type!\n\n" + Escapes.ANSI_RESET);
            } else if (err instanceof StupidException) {
                System.exit(0);
            } else {
                System.out.println(Escapes.ANSI_RED + "\n\nUnexpected error.\n\n" + Escapes.ANSI_RESET);
            }
        }
    }
}
