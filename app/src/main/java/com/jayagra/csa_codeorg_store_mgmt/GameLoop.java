package com.jayagra.csa_codeorg_store_mgmt;

import com.jayagra.ansi.Escapes;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.jayagra.type_conversion.ToBoolean;
import com.jayagra.type_conversion.ToInteger;

public class GameLoop {
    /**
     * runs the game loop. almost all game logic is contained in this function
     * @param eee the scanner created in main
     * @param answers the array of answer objects
     * @param i the current iteration
     */
    public void run(final Scanner eee, final Order answers[], final int i) {
        // wrapped in try catch for error handling
        try {
            // create "empty" object to contain order
            Order userResponse = new Order();
            // prompt user
            System.out.println(Escapes.ANSI_CYAN + "==>\t" + Escapes.ANSI_RESET + "customer wants " + Escapes.colorString(String.valueOf(answers[i].getQuantity()), Escapes.ANSI_PURPLE) + " " + answers[i].getItem().customerWants());
            // depending on type of item, run specific code block
            switch (i % 3) {
                case 2: {
                    // for a can of water
                    System.out.print(Escapes.colorString("\t\tenter can flavor, followed by sparkling (true/false), and the quantity. (ex. \"unflavored true 1\")\n\t\t", Escapes.ANSI_BLUE));
                    // get inputs, split, and check length
                    String[] inputs = eee.nextLine().split(" ");
                    checkInputsLength(inputs.length, 3);
                    // update the object
                    userResponse.setItem(new Can(inputs[0], ToBoolean.fromString(inputs[1])));
                    userResponse.setQuantity(ToInteger.fromString(inputs[2]));
                    break;
                }
                case 1: {
                    // for a generic drink
                    System.out.print(Escapes.colorString("\t\tenter drink type, followed by hot (true/false), and the quantity. (ex. \"tea true 1\")\n\t\t", Escapes.ANSI_BLUE));
                    String[] inputs = eee.nextLine().split(" ");
                    checkInputsLength(inputs.length, 3);
                    userResponse.setItem(new Drink(inputs[0], ToBoolean.fromString(inputs[1])));
                    userResponse.setQuantity(ToInteger.fromString(inputs[2]));
                    break;
                }
                case 0: {
                    // for bread
                    System.out.print(Escapes.colorString("\t\tenter bread type, followed by the quantity. (ex. \"white 2\")\n\t\t", Escapes.ANSI_BLUE));
                    String[] inputs = eee.nextLine().split(" ");
                    checkInputsLength(inputs.length, 2);
                    userResponse.setItem(new Bread(inputs[0]));
                    userResponse.setQuantity(ToInteger.fromString(inputs[1]));
                    break;
                }
            }

            // compares the toStrings of each item and qty
            final String userRespC = userResponse.getItem().toString() + " " + userResponse.getQuantity();
            final String answerC = answers[i].getItem().toString() + " " + answers[i].getQuantity();
            if (userRespC.equals(answerC)) {
                System.out.println(Escapes.colorString("==>\t" + "correct\n\n", Escapes.ANSI_GREEN));
            } else {
                System.out.println(Escapes.colorString("==>\t" + "nope- you're fired.", Escapes.ANSI_RED));
                throw new StupidException("ya failed");
            }
        } catch(Exception err) {
            if (err instanceof InputMismatchException) {
                // wrong type. this block is no longer used.
                System.out.println(Escapes.colorString("\n\nyou entered the wrong type- you're fired.\n\n", Escapes.ANSI_RED));
                System.exit(0);
            } else if (err instanceof StupidException) {
                // stupid exception :~)
                System.exit(0);
            } else {
                // all other errors
                System.out.println(Escapes.colorString("\n\nunexpected error (non-fatal)\n\n", Escapes.ANSI_RED));
            }
        }
    }

    /**
     * checks to make sure that you entered correct number of arguments
     * @param length length of splitting the string returned from scanner
     * @param expected expected number of arguments
     * @throws StupidException throws a stupid exception if you were stupid and had the wrong number of args
     */
    private void checkInputsLength(final int length, final int expected) throws StupidException {
        if (length != expected) {
            System.out.println(Escapes.colorString("==>\t" + "invalid input length- you're fired.", Escapes.ANSI_RED));
            throw new StupidException("bad inputs");
        }
    }
 }
