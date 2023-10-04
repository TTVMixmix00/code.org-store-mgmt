package com.jayagra.csa_codeorg_store_mgmt;

import com.jayagra.ansi.Escapes;
import java.util.Scanner;

public class StoreRunner {
    public static void main(String[] args) {
        System.out.println(Escapes.ANSI_CYAN + "Give the customer the correct object. There are 10 items." + Escapes.ANSI_RESET);
        final Order answers[] = {
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

        long startTime = System.nanoTime();
        Scanner eee = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            new GameLoop().run(eee, answers, i);
        }
        eee.close();

        long elapsed = (Math.abs(System.nanoTime() - startTime));
        if (elapsed < 45000000000L) {
            System.out.println(Escapes.ANSI_YELLOW + "\ttruly insane 🤯");
        } else {
            System.out.println(Escapes.ANSI_RED + "\ttoo slow- you're fired");
        }
    }
}
