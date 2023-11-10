package net.efrei.java_projet_final.security;

public enum Group {
    ADMIN("ADMIN"),
    ECOLE("ECOLE"),
    ENSEIGNANT("ENSEIGNANT"),
    VALID_USER("VALID_USER"),
    USER("USER"),
    GUEST("GUEST");

    private final String name;

    Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}