package com.jayagra.csa_codeorg_store_mgmt;

public class Item {
    private String description;

    public Item() {
        this("nothing");
    }

    public Item(final String desc_) {
        this.description = desc_;
    }

    public String getDescription() {
        return this.description;
    }

    public void setType(final String newDesc) {
        this.description = newDesc;
    }

    public String customerWants() {
        return "nothing";
    }
}
