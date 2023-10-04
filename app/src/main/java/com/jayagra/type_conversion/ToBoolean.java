package com.jayagra.type_conversion;

public class ToBoolean {
    public static boolean fromString(final java.lang.String s) {
        return "true".equalsIgnoreCase(s) ? true : false;
    }

    public static boolean fromInteger(final int i) {
        return i == 1 ? true : false;
    }

    public static boolean fromDouble(final double d) {
        return d == 1.0 ? true : d != 0.0;
    }
}
