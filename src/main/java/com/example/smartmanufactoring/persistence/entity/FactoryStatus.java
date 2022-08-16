package com.example.smartmanufactoring.persistence.entity;

public enum FactoryStatus {
    OPERATIVE(StatusType.OPERATIVE),
    IDLE(StatusType.IDLE),
    DISMISSED(StatusType.DISMISSED);


    public interface StatusType {
        public static final String OPERATIVE = "OPERATIVE";
        public static final String IDLE = "IDLE";
        public static final String DISMISSED = "DISMISSED";
    }

    private final String label;

    public String toString() {
        return this.label;
    }

    private FactoryStatus(String label) {
        this.label = label;
    }
}
