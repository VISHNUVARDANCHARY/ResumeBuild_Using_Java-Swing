package com.resume;


public class ProjectDetail {
    private String projectName;
    private String gitHubLink;
    private String aboutProject;

    public ProjectDetail(String projectName, String gitHubLink, String aboutProject) {
        this.projectName = projectName;
        this.gitHubLink = gitHubLink;
        this.aboutProject = aboutProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public String getAboutProject() {
        return aboutProject;
    }
}
