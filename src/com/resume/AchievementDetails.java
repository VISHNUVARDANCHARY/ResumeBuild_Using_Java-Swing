package com.resume;

public class AchievementDetails {
    private String achievementName;
    private String impact;

    public AchievementDetails(String achievementName, String impact) {
        this.achievementName = achievementName;
        this.impact = impact;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }
}
