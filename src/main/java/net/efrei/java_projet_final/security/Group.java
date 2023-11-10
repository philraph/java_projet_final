package net.efrei.java_projet_final.security;

public enum Group {
    ADMIN("ADMIN", "Administrateur"),
    ECOLE("ECOLE", "Ecole"),
    ENSEIGNANT("ENSEIGNANT", "Enseignant"),
    VALID_USER("VALID_USER", "Utilisateur"),
    USER("USER", "Utilisateur"),
    GUEST("GUEST", "Invité");

    private final String name;
    private final String displayName;

    Group(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }
}