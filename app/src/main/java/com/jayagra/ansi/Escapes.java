package com.jayagra.ansi;

public final class Escapes {
    public static final String ANSI_BLACK = "\033[30m";
    public static final String ANSI_RED = "\033[31m";
    public static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_YELLOW = "\033[33m";
    public static final String ANSI_BLUE = "\033[34m";
    public static final String ANSI_PURPLE = "\033[35m";
    public static final String ANSI_CYAN = "\033[36m";
    public static final String ANSI_WHITE = "\033[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String colorString(final String string, final String color) {
        return color + string + ANSI_RESET;
    }
}