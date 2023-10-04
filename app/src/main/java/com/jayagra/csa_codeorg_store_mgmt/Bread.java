package com.jayagra.csa_codeorg_store_mgmt;

import com.jayagra.ansi.Escapes;

public class Bread extends Item {
    private String type;

    public Bread() {
        this("sourdough");
    }

    public Bread(final String type_) {
        super("bread");
        this.type = type_;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String newType) {
        this.type = newType;
    }

    public String customerWants() {
        return "piece(s) of " + Escapes.colorString(this.type, Escapes.ANSI_PURPLE) + " bread";
    }

    public String toString() {
        return Escapes.colorString(this.type, Escapes.ANSI_PURPLE) + " bread";
    }
}
