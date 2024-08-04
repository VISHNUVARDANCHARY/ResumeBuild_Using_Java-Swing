package com.resume;

public class TechnicalSkillsDetails {
    private String programmingLanguages;
    private String tools;

    public TechnicalSkillsDetails(String programmingLanguages, String tools) {
        this.programmingLanguages = programmingLanguages;
        this.tools = tools;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public String getTools() {
        return tools;
    }
}
