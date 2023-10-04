package com.jayagra.csa_codeorg_store_mgmt;

import com.jayagra.ansi.Escapes;

public class Can extends Item {
    private String flavor;
    private boolean sparkling;

    public Can() {
        this("LimonCello", true);
    }

    public Can(final String flavor_, final boolean sparkling_) {
        this.flavor = flavor_;
        this.sparkling = sparkling_;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public boolean getSparkling() {
        return this.sparkling;
    }

    public void setFlavor(final String newFlavor) {
        this.flavor = newFlavor;
    }

    public void setSparkling(final boolean newSparkling) {
        this.sparkling = newSparkling;
    }

    public String customerWants() {
        return this.sparkling ? Escapes.colorString(this.flavor, Escapes.ANSI_PURPLE) + " " + Escapes.colorString("sparkling", Escapes.ANSI_PURPLE) + " water" : Escapes.colorString(this.flavor, Escapes.ANSI_PURPLE) + " " + Escapes.colorString("flat", Escapes.ANSI_PURPLE) + " water";
    }

    public String toString() {
        return customerWants();
    }
}
