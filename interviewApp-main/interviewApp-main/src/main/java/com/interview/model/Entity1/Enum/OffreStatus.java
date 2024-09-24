package com.interview.model.Entity1.Enum;

public enum OffreStatus {
    ACCEPTED("accepted"),
    PENDING("pending"),
    REJECTED("rejected");

    private final String value;

    OffreStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OffreStatus fromValue(String value) {
        for (OffreStatus status : OffreStatus.values()) {
            if (status.value.equalsIgnoreCase(value)) { // Use equalsIgnoreCase for flexibility
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
