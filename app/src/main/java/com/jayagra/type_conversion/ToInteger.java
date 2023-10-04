package com.jayagra.type_conversion;

public class ToInteger {
    public static int fromString(final java.lang.String s) {
        try {
            return java.lang.Integer.parseInt(s);
        } catch (NumberFormatException err) {
            return 0;
        }
    }

    public static int fromDouble(final double d) {
        return (int) d;
    }

    public static int fromBoolean(final boolean b) {
        return b ? 1 : 0;
    }
}
