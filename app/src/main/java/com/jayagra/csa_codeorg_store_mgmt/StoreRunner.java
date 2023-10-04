package com.jayagra.csa_codeorg_store_mgmt;

import com.jayagra.ansi.Escapes;
import java.util.Scanner;

public class StoreRunner {
    // answer objects to each round
    static final Order answers[] = {
        new Order(new Bread("wheat"), 10),
        new Order(new Drink("green_tea", false), 1),
        new Order(new Can("unflavored", false), 8),
        new Order(new Bread("muffin"), 89),
        new Order(new Drink("battery_acid", true), 2),
        new Order(new Can("lime", true), 8),
        new Order(new Bread("cake"), 1),
        new Order(new Drink("expired_milk", false), 15),
        new Order(new Can("limoncello", true), Integer.MAX_VALUE),
        new Order(new Bread("cookie"), 204),
    };
    public static void main(final String[] args) {
        // run game 
        checkTime(startGameLoop());
    }

    /**
     * starts the game loop
     * @return the System.nanoTime() of when the "game" was started
     */
    private static long startGameLoop() {
        System.out.println(Escapes.colorString("give the customer the correct object.", Escapes.ANSI_CYAN));
        final long startTime = System.nanoTime();

        Scanner eee = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            new GameLoop().run(eee, answers, i);
        }
        eee.close();

        return startTime;
    }

    /**
     * checks to make sure game was completed in under 45 seconds, and returns game result
     * @param startTime the System.nanoTime() of the game start
     */
    private static void checkTime(final long startTime) {
        final long elapsed = (Math.abs(System.nanoTime() - startTime));
        if (elapsed < 45000000000L) {
            System.out.println(Escapes.colorString("\ttruly insane 🤯", Escapes.ANSI_YELLOW));
        } else {
            System.out.println(Escapes.colorString("\ttoo slow- you're fired", Escapes.ANSI_RED));
        }
    }
}
