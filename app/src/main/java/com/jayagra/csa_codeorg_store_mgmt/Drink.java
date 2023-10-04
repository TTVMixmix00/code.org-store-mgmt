package com.jayagra.csa_codeorg_store_mgmt;

import com.jayagra.ansi.Escapes;

public class Drink extends Item {
    private String type;
    private boolean isHot;

    public Drink() {
        this("tea", true);
    }

    public Drink(final String type_, final boolean isHot_) {
        super("a drink");
        this.type = type_;
        this.isHot = isHot_;
    }

    public String getType() {
        return this.type;
    }

    public boolean getIsHot() {
        return this.isHot;
    }

    public void setType(final String newType) {
        this.type = newType;
    }

    public void setIsHot(final boolean newIsHot) {
        this.isHot = newIsHot;
    }

    public String customerWants() {
        return this.isHot ? Escapes.colorString("hot", Escapes.ANSI_PURPLE) + " drink(s) of " + Escapes.colorString(this.type, Escapes.ANSI_PURPLE) + ", " : Escapes.colorString("cold", Escapes.ANSI_PURPLE) + " drink(s) of " + Escapes.colorString(this.type, Escapes.ANSI_PURPLE) + ", ";
    }

    public String toString() {
        return this.isHot ? "Hot" + Escapes.colorString(this.type, Escapes.ANSI_PURPLE) : "Cold " + Escapes.colorString(this.type, Escapes.ANSI_PURPLE);
    }
}
