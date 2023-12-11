package org.example.Controler;

public enum Priority {
    HIGH("High", 3),
    MEDIUM("Medium", 2),
    LOW("Low", 1);

    private String name;
    private int value;

    // Constructor
    Priority(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
