package com.resume;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.draw.LineSeparator;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;

public class TemplateTwoGeneratePDF 
{
	
	/*
	  public static void generatePDF(
	            String name, String graduation, String institution, String phone, String collegeEmail, String personalEmail, 
	            String linkedIn, String profileSummary, Education education, Experience experience, Project project, 
	            TechnicalSkills technicalSkills, RelevantCourses relevantCourses, Achievement achievement, Hobbie hobbies
	    )
	 */
	
	 public static void generatePDF(
	            String name, String phone, String personalEmail, 
	            String linkedIn, String profileSummary, Education education, Experience experience, Project project, 
	            TechnicalSkills technicalSkills, RelevantCourses relevantCourses, Achievement achievement, Hobbie hobbies
	    ) {
		 String userName = name.replaceAll("\\s+", ""); // Remove spaces from the name
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showSaveDialog(null);

        //fileChooser.setDialogTitle("Select a File");
        //int result = fileChooser.showSaveDialog(null);

        if (option  == JFileChooser.APPROVE_OPTION) 
        {
        	
            File selectedDirectory = fileChooser.getSelectedFile();
        	//File selectedFile = fileChooser.getSelectedFile();
        	
        	if (selectedDirectory != null && selectedDirectory.exists()) 
        	{
        		
        		System.out.println("Selected file: " + selectedDirectory.getAbsolutePath());
        	
            String filePath = selectedDirectory.getAbsolutePath() + File.separator + userName + "Resume_Template2.pdf";

            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                // Add content for Template 2 here
                
                Font nameFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
                Font headingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
                Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
                
                
                // Center align the name
                Paragraph nameParagraph = new Paragraph(name, nameFont);
                nameParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(nameParagraph);
                //document.add(new Paragraph(" ")); // Add a blank line for space

             // Add Profile Summary
//                Paragraph profileSummaryHeader = new Paragraph("PROFILE SUMMARY", headingFont);
//                Paragraph profileSummaryHeader = new Paragraph();
//                profileSummaryHeader.setAlignment(Element.ALIGN_CENTER);
//                profileSummaryHeader.setSpacingBefore(20);
//                document.add(profileSummaryHeader);

                LineSeparator profileSummarySeparator = new LineSeparator();
                profileSummarySeparator.setOffset(-2); // Adjust offset if needed
//                document.add(profileSummarySeparator);

                document.add(new Paragraph(" ")); // Add a blank line for space

                Paragraph profileSummaryParagraph = new Paragraph(profileSummary, normalFont);
                profileSummaryParagraph.setAlignment(Element.ALIGN_MIDDLE);
                profileSummaryParagraph.setSpacingAfter(15);
                document.add(profileSummaryParagraph);

                // Add contact, email, LinkedIn in the same line
                Paragraph contactParagraph = new Paragraph( phone + " | " + personalEmail + " | " + linkedIn, normalFont);
                contactParagraph.setAlignment(Element.ALIGN_CENTER);
                contactParagraph.setSpacingAfter(15);
                document.add(contactParagraph);

	
	             // Add a dotted line separator
	             LineSeparator dottedLine = new LineSeparator();
	             dottedLine.setOffset(-1); // Create a dotted line pattern
	             document.add(dottedLine);
	
	             document.add(new Paragraph(" ")); // Add a blank line for space

	             
	          // Add EDUCATION section
	             Paragraph educationHeader = new Paragraph("EDUCATION", headingFont);
	             educationHeader.setSpacingBefore(20);
	             document.add(educationHeader);

	             LineSeparator educationSeparator = new LineSeparator();
	             educationSeparator.setOffset(-2); // Adjust offset if needed
	             document.add(educationSeparator);

	             document.add(new Paragraph(" ")); // Add a blank line for space

	             // Loop through education details and add them to the PDF
	             for (EducationDetail educationDetail : education.getEducationDetails()) 
	             {
	                 // Degree/Year
	                 PdfPTable degreeYearTable = new PdfPTable(2);
	                 degreeYearTable.setWidthPercentage(100);
	                 PdfPCell degreeCell = new PdfPCell(new Phrase("• " + educationDetail.getDegree(), headingFont));
	                 degreeCell.setBorder(Rectangle.NO_BORDER);
	                 degreeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                 PdfPCell yearCell = new PdfPCell(new Phrase(educationDetail.getYear(), headingFont));
	                 yearCell.setBorder(Rectangle.NO_BORDER);
	                 yearCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                 degreeYearTable.addCell(degreeCell);
	                 degreeYearTable.addCell(yearCell);
	                 document.add(degreeYearTable);

	                 // Institute/CGPA
	                 PdfPTable instituteCgpaTable = new PdfPTable(2);
	                 instituteCgpaTable.setWidthPercentage(100);
	                 PdfPCell instituteCell = new PdfPCell(new Phrase("   - " + educationDetail.getInstitute(), normalFont));
	                 instituteCell.setBorder(Rectangle.NO_BORDER);
	                 instituteCell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                 PdfPCell cgpaCell = new PdfPCell(new Phrase(educationDetail.getCgpa(), normalFont));
	                 cgpaCell.setBorder(Rectangle.NO_BORDER);
	                 cgpaCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                 instituteCgpaTable.addCell(instituteCell);
	                 instituteCgpaTable.addCell(cgpaCell);
	                 document.add(instituteCgpaTable);
	             }

	             
	             // Add Experience section
	                document.add(new Paragraph(" "));
	                Paragraph experienceHeader = new Paragraph("EXPERIENCE", headingFont);
	                document.add(experienceHeader);

	                LineSeparator experienceSeparator = new LineSeparator();
	                experienceSeparator.setOffset(-2);
	                document.add(experienceSeparator);

	                document.add(new Paragraph(" "));

	                for (ExperienceDetail details : experience.getExperienceDetails()) {
	                    PdfPTable experienceTable = new PdfPTable(2);
	                    experienceTable.setWidthPercentage(100);
	                    experienceTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

	                    PdfPCell companyCell = new PdfPCell(new Phrase("• " + details.getCompanyName(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
	                    companyCell.setBorder(Rectangle.NO_BORDER);
	                    experienceTable.addCell(companyCell);

	                    PdfPCell durationCell = new PdfPCell(new Phrase(details.getDuration(), normalFont));
	                    durationCell.setBorder(Rectangle.NO_BORDER);
	                    durationCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                    experienceTable.addCell(durationCell);

	                    PdfPCell roleCell = new PdfPCell(new Phrase("  "+details.getJobRole(), normalFont));
	                    roleCell.setBorder(Rectangle.NO_BORDER);
	                    experienceTable.addCell(roleCell);

	                    PdfPCell jobTypeCell = new PdfPCell(new Phrase(details.getJobType(), normalFont));
	                    jobTypeCell.setBorder(Rectangle.NO_BORDER);
	                    jobTypeCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                    experienceTable.addCell(jobTypeCell);

	                    document.add(experienceTable);

	                    Paragraph contributionParagraph = new Paragraph("    - " + details.getContribution(), normalFont);
	                    document.add(contributionParagraph);
	                }
	                
	             // Add Project section
	                document.add(new Paragraph(" "));
	                Paragraph projectHeader = new Paragraph("PROJECTS", headingFont);
	                document.add(projectHeader);

	                LineSeparator projectSeparator = new LineSeparator();
	                projectSeparator.setOffset(-2);
	                document.add(projectSeparator);

	                document.add(new Paragraph(" "));

	                for (ProjectDetail details : project.getProjectDetails()) {
	                    PdfPTable projectTable = new PdfPTable(2);
	                    projectTable.setWidthPercentage(100);
	                    projectTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

	                    PdfPCell titleCell = new PdfPCell(new Phrase("• " + details.getProjectName(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
	                    titleCell.setBorder(Rectangle.NO_BORDER);
	                    projectTable.addCell(titleCell);

	                    PdfPCell linkCell = new PdfPCell(new Phrase(details.getGitHubLink(), normalFont));
	                    linkCell.setBorder(Rectangle.NO_BORDER);
	                    linkCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                    projectTable.addCell(linkCell);

	                    document.add(projectTable);

	                    Paragraph descriptionParagraph = new Paragraph("    - " + details.getAboutProject(), normalFont);
	                    document.add(descriptionParagraph);
	                    document.add(new Paragraph(" "));
	                }
	                
	                
	                // Add Technical Skills section
	                
	                TechnicalSkillsDetails technicalSkillsDetails = technicalSkills.getTechnicalSkillsDetails();
	                if (technicalSkillsDetails != null) {
	                    // Add Technical Skills section here
	                
	                document.add(new Paragraph(" "));
	                Paragraph technicalSkillsHeader = new Paragraph("TECHNICAL SKILLS", headingFont);
	                document.add(technicalSkillsHeader);

	                LineSeparator technicalSkillsSeparator = new LineSeparator();
	                technicalSkillsSeparator.setOffset(-2);
	                document.add(technicalSkillsSeparator);

	                document.add(new Paragraph(" "));

//	                TechnicalSkillsDetails technicalSkillsDetails = technicalSkills.getTechnicalSkillsDetails();

	                Paragraph programmingLanguagesHeader = new Paragraph("Programming Languages: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
	                document.add(programmingLanguagesHeader);

	                Paragraph programmingLanguagesContent = new Paragraph("  "+technicalSkillsDetails.getProgrammingLanguages(), normalFont);
	                document.add(programmingLanguagesContent);

	                Paragraph toolsHeader = new Paragraph("Tools: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
	                document.add(toolsHeader);

	                Paragraph toolsContent = new Paragraph("  "+technicalSkillsDetails.getTools(), normalFont);
	                document.add(toolsContent);
	                }
	                else
	                {	                	
	                        JOptionPane.showMessageDialog(null, "Technical Skills details are not provided.");	                    
	                }
	                
	             // Add Relevant Courses section
	                document.add(new Paragraph(" "));
	                Paragraph relevantCoursesHeader = new Paragraph("RELEVANT COURSES", headingFont);
	                document.add(relevantCoursesHeader);

	                LineSeparator relevantCoursesSeparator = new LineSeparator();
	                relevantCoursesSeparator.setOffset(-2);
	                document.add(relevantCoursesSeparator);

	                document.add(new Paragraph(" "));

	                RelevantCoursesDetails relevantCoursesDetails = relevantCourses.getRelevantCoursesDetails();

	                Paragraph academicCoursesHeader = new Paragraph("Academic Courses: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
	                document.add(academicCoursesHeader);

	                Paragraph academicCoursesContent = new Paragraph("  "+relevantCoursesDetails.getAcademicCourses(), normalFont);
	                document.add(academicCoursesContent);

	                Paragraph certificateCoursesHeader = new Paragraph("Certificate Courses: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
	                document.add(certificateCoursesHeader);

	                Paragraph certificateCoursesContent = new Paragraph("  "+relevantCoursesDetails.getCertificateCourses(), normalFont);
	                document.add(certificateCoursesContent);

	                Paragraph otherCoursesHeader = new Paragraph("Other Courses: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
	                document.add(otherCoursesHeader);

	                Paragraph otherCoursesContent = new Paragraph("  "+relevantCoursesDetails.getOtherCourses(), normalFont);
	                document.add(otherCoursesContent);

	                
	             // Add Achievements section
	                document.add(new Paragraph(" "));
	                Paragraph achievementsHeader = new Paragraph("ACHIEVEMENTS", headingFont);
	                document.add(achievementsHeader);

	                LineSeparator achievementsSeparator = new LineSeparator();
	                achievementsSeparator.setOffset(-2);
	                document.add(achievementsSeparator);

	                document.add(new Paragraph(" "));

	                for (AchievementDetails achievementDetail : achievement.getAchievements()) {
	                    Paragraph achievementName = new Paragraph("• " + achievementDetail.getAchievementName(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
	                    document.add(achievementName);

	                    Paragraph impact = new Paragraph("  "+achievementDetail.getImpact(), normalFont);
	                    document.add(impact);
	                }

	                
	             // Adding Hobbies section
	                document.add(new Paragraph(" "));
	                Paragraph hobbiesHeader = new Paragraph("HOBBIES", headingFont);
	                document.add(hobbiesHeader);

	                LineSeparator hobbiesSeparator = new LineSeparator();
	                hobbiesSeparator.setOffset(-2);
	                document.add(hobbiesSeparator);

	                document.add(new Paragraph(" "));

	                for (HobbieDetails hobbieDetail : hobbies.getHobbies()) {
	                    Paragraph hobbieName = new Paragraph("• " + hobbieDetail.getHobbieName(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
	                    document.add(hobbieName);

	                    Paragraph impact = new Paragraph("  "+hobbieDetail.getImpact(), normalFont);
	                    document.add(impact);
	                }
	                
	                
                

                document.close();
                JOptionPane.showMessageDialog(null, "PDF created successfully using Template 2!");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error creating PDF using Template 2: " + ex.getMessage());
            }
            
        	} else {
                // Handle the case where the selection is not a valid file or directory
                JOptionPane.showMessageDialog(null, "Please select a valid file or directory.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "No folder selected. PDF generation canceled.");
        }
    }
}
