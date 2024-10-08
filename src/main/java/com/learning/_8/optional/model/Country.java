package com.learning._8.optional.model;

public class Country {
    private String name;
    private String iso_code;

    public Country(String name, String iso_code) {
        super();
        this.name = name;
        this.iso_code = iso_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", iso_code='" + iso_code + '\'' +
                '}';
    }
}
