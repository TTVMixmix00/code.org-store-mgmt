package com.jayagra.type_conversion;

public class ToDouble {
    public static double fromInteger(final int i) {
        return (double) i;
    }

    public static double fromBoolean(final boolean b) {
        return b ? 1.0 : 0.0;
    }

    public static double fromString(final java.lang.String s) {
        try {
            return java.lang.Double.parseDouble(s);
        } catch (NumberFormatException err) {
            return 0.0;
        }
    }
}
