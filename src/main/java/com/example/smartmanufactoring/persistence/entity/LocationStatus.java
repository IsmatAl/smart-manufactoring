package com.example.smartmanufactoring.persistence.entity;

public enum LocationStatus {
    ACTIVE(LocationStatus.StatusType.ACTIVE),
    NOT_ACTIVE(LocationStatus.StatusType.NOT_ACTIVE);


    public interface StatusType {
        public static final String ACTIVE = "ACTIVE";
        public static final String NOT_ACTIVE = "NOT_ACTIVE";
    }

    private final String label;

    public String toString() {
        return this.label;
    }

    private LocationStatus(String label) {
        this.label = label;
    }
}
