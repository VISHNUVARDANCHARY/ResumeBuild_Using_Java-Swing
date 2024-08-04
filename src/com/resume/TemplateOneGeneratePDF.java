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


public class TemplateOneGeneratePDF {
	public static void generatePDF(
		    String name, String graduation, String institution, String phone, String collegeEmail, String personalEmail, 
		    String linkedIn, String profileSummary, Education education, Experience experience, Project project, 
		    TechnicalSkills technicalSkills, RelevantCourses relevantCourses, Achievement achievement, Hobbie hobbies
		)  {
        String userName = name.replaceAll("\\s+", ""); // Remove spaces from the name

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String filePath = selectedDirectory.getAbsolutePath() + File.separator + userName + "Resume.pdf";

            try {
            	Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                Font nameFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
                Font headingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
                Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
                PdfPTable detailsTable = new PdfPTable(2);
                detailsTable.setWidthPercentage(100);
                detailsTable.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Remove table borders

                PdfPTable leftTable = new PdfPTable(1);
                leftTable.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Remove cell borders
                leftTable.addCell(new PdfPCell(new Phrase(name, nameFont))).setBorder(Rectangle.NO_BORDER);
                leftTable.addCell(new PdfPCell(new Phrase(graduation, normalFont))).setBorder(Rectangle.NO_BORDER);
                leftTable.addCell(new PdfPCell(new Phrase(institution, normalFont))).setBorder(Rectangle.NO_BORDER);

                PdfPCell leftCell = new PdfPCell(leftTable);
                leftCell.setBorder(Rectangle.NO_BORDER);
                detailsTable.addCell(leftCell);

                PdfPTable rightTable = new PdfPTable(1);
                rightTable.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Remove cell borders
                rightTable.addCell(new PdfPCell(new Phrase(phone, normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(collegeEmail, normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(personalEmail, normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(linkedIn, normalFont))).setBorder(Rectangle.NO_BORDER);

                for (int i = 0; i < rightTable.getRows().size(); i++) {
                    PdfPCell cell = rightTable.getRow(i).getCells()[0];
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                }

                PdfPCell rightCell = new PdfPCell(rightTable);
                rightCell.setBorder(Rectangle.NO_BORDER);
                detailsTable.addCell(rightCell);

                document.add(detailsTable);

                // Add Profile Summary
                Paragraph profileSummaryHeader = new Paragraph("PROFILE SUMMARY", headingFont);
                profileSummaryHeader.setSpacingBefore(20);
                document.add(profileSummaryHeader);

                LineSeparator profileSummarySeparator = new LineSeparator();
                profileSummarySeparator.setOffset(-2); // Adjust offset if needed
                document.add(profileSummarySeparator);

                document.add(new Paragraph(" ")); // Add a blank line for space

                Paragraph profileSummaryParagraph = new Paragraph(profileSummary, normalFont);
                profileSummaryParagraph.setSpacingAfter(20);
                document.add(profileSummaryParagraph);

                // Add Education section
                Paragraph educationHeader = new Paragraph("EDUCATION", headingFont);
                educationHeader.setSpacingBefore(20);
                document.add(educationHeader);

                LineSeparator educationSeparator = new LineSeparator();
                educationSeparator.setOffset(-2); // Adjust offset if needed
                document.add(educationSeparator);

                document.add(new Paragraph(" ")); // Add a blank line for space

                PdfPTable educationTable = new PdfPTable(4);
                educationTable.setWidthPercentage(100);

                addCellToTable(educationTable, "Degree/Certificate", headingFont, true);
                addCellToTable(educationTable, "Institute", headingFont, true);
                addCellToTable(educationTable, "CGPA/Percentage", headingFont, true);
                addCellToTable(educationTable, "Year", headingFont, true);

                for (EducationDetail details : education.getEducationDetails()) {
                    addCellToTable(educationTable, details.getDegree(), normalFont, false);
                    addCellToTable(educationTable, details.getInstitute(), normalFont, false);
                    addCellToTable(educationTable, details.getCgpa(), normalFont, false);
                    addCellToTable(educationTable, details.getYear(), normalFont, false);
                }

                document.add(educationTable);

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

                    PdfPCell roleCell = new PdfPCell(new Phrase(details.getJobRole(), normalFont));
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
                }

                // Add Projects section
//                document.add(new Paragraph(" "));
//                Paragraph projectHeader = new Paragraph("PROJECTS", headingFont);
//                document.add(projectHeader);
//
//                LineSeparator projectSeparator = new LineSeparator();
//                projectSeparator.setOffset(-2);
//                document.add(projectSeparator);
//
//                document.add(new Paragraph(" "));

//                for (ProjectDetail details : project.getProjectDetails()) {
//                    PdfPTable projectTable = new PdfPTable(2);
//                    projectTable.setWidthPercentage(100);
//                    projectTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
//
//                    PdfPCell titleCell = new PdfPCell(new Phrase("• " + details.getProjectTitle(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
//                    titleCell.setBorder(Rectangle.NO_BORDER);
//                    projectTable.addCell(titleCell);
//
//                    PdfPCell projectDurationCell = new PdfPCell(new Phrase(details.getDuration(), normalFont));
//                    projectDurationCell.setBorder(Rectangle.NO_BORDER);
//                    projectDurationCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                    projectTable.addCell(projectDurationCell);
//
//                    document.add(projectTable);
//
//                    Paragraph descriptionParagraph = new Paragraph("    - " + details.getDescription(), normalFont);
//                    document.add(descriptionParagraph);
//                }

                
             // Add Technical Skills section
                document.add(new Paragraph(" "));
                Paragraph technicalSkillsHeader = new Paragraph("TECHNICAL SKILLS", headingFont);
                document.add(technicalSkillsHeader);

                LineSeparator technicalSkillsSeparator = new LineSeparator();
                technicalSkillsSeparator.setOffset(-2);
                document.add(technicalSkillsSeparator);

                document.add(new Paragraph(" "));

                TechnicalSkillsDetails technicalSkillsDetails = technicalSkills.getTechnicalSkillsDetails();

                Paragraph programmingLanguagesHeader = new Paragraph("Programming Languages: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
                document.add(programmingLanguagesHeader);

                Paragraph programmingLanguagesContent = new Paragraph("  "+technicalSkillsDetails.getProgrammingLanguages(), normalFont);
                document.add(programmingLanguagesContent);

                Paragraph toolsHeader = new Paragraph("Tools: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
                document.add(toolsHeader);

                Paragraph toolsContent = new Paragraph("  "+technicalSkillsDetails.getTools(), normalFont);
                document.add(toolsContent);

                
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
                JOptionPane.showMessageDialog(null, "PDF generated successfully!");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error generating PDF: " + e.getMessage());
            }
        }
    }

    private static void addCellToTable(PdfPTable table, String content, Font font, boolean isHeader) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        if (isHeader) {
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        }
        table.addCell(cell);
    }
}









/*
public class TemplateOneGeneratePDF {
    public static void generatePDF(String name, String graduation, String institution, String phone, 
                                   String collegeEmail, String personalEmail, String linkedIn, 
                                   String profileSummary, Education education, Experience experience, 
                                   Project project, TechnicalSkills technicalSkills, RelevantCourses relevantCourses) {
        String userName = name.replaceAll("\\s+", ""); // Remove spaces from the name

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Set to directories only
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String filePath = selectedDirectory.getAbsolutePath() + File.separator + userName + "Resume.pdf";

            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                Font nameFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
                Font headingFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
                Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
                PdfPTable detailsTable = new PdfPTable(2);
                detailsTable.setWidthPercentage(100);
                detailsTable.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Remove table borders

                PdfPTable leftTable = new PdfPTable(1);
                leftTable.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Remove cell borders
                leftTable.addCell(new PdfPCell(new Phrase(name, nameFont))).setBorder(Rectangle.NO_BORDER);
                leftTable.addCell(new PdfPCell(new Phrase(graduation, normalFont))).setBorder(Rectangle.NO_BORDER);
                leftTable.addCell(new PdfPCell(new Phrase(institution, normalFont))).setBorder(Rectangle.NO_BORDER);

                PdfPCell leftCell = new PdfPCell(leftTable);
                leftCell.setBorder(Rectangle.NO_BORDER);
                detailsTable.addCell(leftCell);

                PdfPTable rightTable = new PdfPTable(1);
                rightTable.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Remove cell borders
                rightTable.addCell(new PdfPCell(new Phrase(phone, normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(collegeEmail, normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(personalEmail, normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(linkedIn, normalFont))).setBorder(Rectangle.NO_BORDER);

                for (int i = 0; i < rightTable.getRows().size(); i++) {
                    PdfPCell cell = rightTable.getRow(i).getCells()[0];
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                }

                PdfPCell rightCell = new PdfPCell(rightTable);
                rightCell.setBorder(Rectangle.NO_BORDER);
                detailsTable.addCell(rightCell);

                document.add(detailsTable);

                // Add Profile Summary
                Paragraph profileSummaryHeader = new Paragraph("PROFILE SUMMARY", headingFont);
                profileSummaryHeader.setSpacingBefore(20);
                document.add(profileSummaryHeader);

                LineSeparator profileSummarySeparator = new LineSeparator();
                profileSummarySeparator.setOffset(-2); // Adjust offset if needed
                document.add(profileSummarySeparator);

                document.add(new Paragraph(" ")); // Add a blank line for space

                Paragraph profileSummaryParagraph = new Paragraph(profileSummary, normalFont);
                profileSummaryParagraph.setSpacingAfter(20);
                document.add(profileSummaryParagraph);

                // Add Education section
                Paragraph educationHeader = new Paragraph("EDUCATION", headingFont);
                educationHeader.setSpacingBefore(20);
                document.add(educationHeader);

                LineSeparator educationSeparator = new LineSeparator();
                educationSeparator.setOffset(-2); // Adjust offset if needed
                document.add(educationSeparator);

                document.add(new Paragraph(" ")); // Add a blank line for space

                PdfPTable educationTable = new PdfPTable(4);
                educationTable.setWidthPercentage(100);

                addCellToTable(educationTable, "Degree/Certificate", headingFont, true);
                addCellToTable(educationTable, "Institute", headingFont, true);
                addCellToTable(educationTable, "CGPA/Percentage", headingFont, true);
                addCellToTable(educationTable, "Year", headingFont, true);

                for (EducationDetail details : education.getEducationDetails()) {
                    addCellToTable(educationTable, details.getDegree(), normalFont, false);
                    addCellToTable(educationTable, details.getInstitute(), normalFont, false);
                    addCellToTable(educationTable, details.getCgpa(), normalFont, false);
                    addCellToTable(educationTable, details.getYear(), normalFont, false);
                }

                document.add(educationTable);

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

                    PdfPCell roleCell = new PdfPCell(new Phrase(details.getJobRole(), normalFont));
                    roleCell.setBorder(Rectangle.NO_BORDER);
                    experienceTable.addCell(roleCell);

                    PdfPCell jobTypeCell = new PdfPCell(new Phrase(details.getJobType(), normalFont));
                    jobTypeCell.setBorder(Rectangle.NO_BORDER);
                    jobTypeCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    experienceTable.addCell(jobTypeCell);

                    document.add(experienceTable);

                    Paragraph contributionParagraph = new Paragraph("    - " + details.getContribution(), normalFont);
                    document.add(contributionParagraph);

                    document.add(new Paragraph(" "));
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

                    PdfPCell projectNameCell = new PdfPCell(new Phrase("• " + details.getProjectName(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
                    projectNameCell.setBorder(Rectangle.NO_BORDER);
                    projectTable.addCell(projectNameCell);

                    PdfPCell gitHubLinkCell = new PdfPCell(new Phrase(details.getGitHubLink(), normalFont));
                    gitHubLinkCell.setBorder(Rectangle.NO_BORDER);
                    gitHubLinkCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    projectTable.addCell(gitHubLinkCell);

                    document.add(projectTable);

                    Paragraph aboutProjectParagraph = new Paragraph(details.getAboutProject(), normalFont);
                    document.add(aboutProjectParagraph);

                    document.add(new Paragraph(" "));
                }

                // Add Technical Skills section
                document.add(new Paragraph("\n"));
                Paragraph technicalSkillsHeader = new Paragraph("TECHNICAL SKILLS", headingFont);
                document.add(technicalSkillsHeader);

                LineSeparator technicalSkillsSeparator = new LineSeparator();
                technicalSkillsSeparator.setOffset(-2); // Adjust offset if needed
                document.add(technicalSkillsSeparator);

                document.add(new Paragraph(" ")); // Add a blank line for space

                TechnicalSkillsDetails techSkillsDetails = technicalSkills.getTechnicalSkillsDetails();
                document.add(new Paragraph("Programming Languages: " + techSkillsDetails.getProgrammingLanguages(), normalFont));
                document.add(new Paragraph("Tools: " + techSkillsDetails.getTools(), normalFont));

                // Add Relevant Courses section
                document.add(new Paragraph("\n"));
                Paragraph relevantCoursesHeader = new Paragraph("RELEVANT COURSES", headingFont);
                document.add(relevantCoursesHeader);

                LineSeparator relevantCoursesSeparator = new LineSeparator();
                relevantCoursesSeparator.setOffset(-2); // Adjust offset if needed
                document.add(relevantCoursesSeparator);

                document.add(new Paragraph(" ")); // Add a blank line for space

                RelevantCoursesDetails relevantCoursesDetails = relevantCourses.getRelevantCoursesDetails();
                document.add(new Paragraph("Academic Courses: " + relevantCoursesDetails.getAcademicCourses(), normalFont));
                document.add(new Paragraph("Certificate Courses: " + relevantCoursesDetails.getCertificateCourses(), normalFont));
                document.add(new Paragraph("Other Courses: " + relevantCoursesDetails.getOtherCourses(), normalFont));

                document.close();
                JOptionPane.showMessageDialog(null, "PDF created successfully!");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error creating PDF: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No folder selected. PDF generation canceled.");
        }
    }

    private static void addCellToTable(PdfPTable table, String text, Font font, boolean isHeader) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        if (isHeader) {
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        }
        table.addCell(cell);
    }
}
*/
