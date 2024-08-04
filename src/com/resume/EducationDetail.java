package com.resume;

public class EducationDetail 
{
    private String degree;
    private String institute;
    private String cgpa;
    private String year;

    public EducationDetail(String degree, String institute, String cgpa, String year) {
        this.degree = degree;
        this.institute = institute;
        this.cgpa = cgpa;
        this.year = year;
    }

    // Getters
    public String getDegree() 
    {
        return degree;
    }

    public String getInstitute() 
    {
        return institute;
    }

    public String getCgpa() 
    {
        return cgpa;
    }

    public String getYear() 
    {
        return year;
    }
}
