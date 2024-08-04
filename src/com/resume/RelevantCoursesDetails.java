package com.resume;

public class RelevantCoursesDetails {
    private String academicCourses;
    private String certificateCourses;
    private String otherCourses;

    public RelevantCoursesDetails(String academicCourses, String certificateCourses, String otherCourses) {
        this.academicCourses = academicCourses;
        this.certificateCourses = certificateCourses;
        this.otherCourses = otherCourses;
    }

    public String getAcademicCourses() {
        return academicCourses;
    }

    public String getCertificateCourses() {
        return certificateCourses;
    }

    public String getOtherCourses() {
        return otherCourses;
    }
}
