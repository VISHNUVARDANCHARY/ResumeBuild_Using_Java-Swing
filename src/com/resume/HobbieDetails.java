package com.resume;

public class HobbieDetails {
    private String hobbieName;
    private String impact;

    public HobbieDetails(String hobbieName, String impact) {
        this.hobbieName = hobbieName;
        this.impact = impact;
    }

    public String getHobbieName() {
        return hobbieName;
    }

    public void setHobbieName(String hobbieName) {
        this.hobbieName = hobbieName;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }
}
