/**
 * Vishnuvardan
 */
package com.resume;

//import com.itextpdf.text.*;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Rectangle;
////import com.itextpdf.text.pdf.*;
//import com.itextpdf.text.pdf.draw.LineSeparator;
//
//import com.itextpdf.text.Document;
////import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
////import com.itextpdf.text.Font;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.LineSeparator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.List;
import java.io.File;
import java.io.FileOutputStream;

//import resumePack.Education;
//import resumePack.EducationDetail;


//@SuppressWarnings("serial")
public class MainResume /* extends JFrame */
{
    private JFrame frame;
    private JTextField nameField;
    private JTextField graduationField;
    private JTextField institutionField;
    private JTextField phoneField;
    private JTextField collegeEmailField;
    private JTextField personalEmailField;
    private JTextField linkedInField;
    private JTextArea profileSummaryArea;
    
    
//    private java.util.List<EducationDetails> educationDetailsList;
//    private java.util.List<ExperienceDetails> experienceDetailsList;
//    private java.util.List<ProjectDetails> projectDetailsList;
    
    private Education education;
    private Experience experience;
    private Project project;
    private TechnicalSkills technicalSkills;
    private RelevantCourses relevantCourses;
    private Achievement achievement;
    private Hobbie hobbie;

    public static void main(String[] args) 
    {
    	System.out.println(System.getProperty("java.class.path"));
        SwingUtilities.invokeLater(() -> {
            try {
                MainResume window = new MainResume();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

//    education = new Education();

    public MainResume() 
    {
        education = new Education(); // Initialize the education object
        experience = new Experience();
        project = new Project(); // Initialize the project object
        technicalSkills = new TechnicalSkills(); // Initialize the technical skills object
        relevantCourses = new RelevantCourses(); // Initialize the relevant courses object
        achievement = new Achievement(); // Initialize the achievement object
        hobbie = new Hobbie(); // Initialize the hobbie object
        initialize();
    }

    private void initialize()
    {
    	frame = new JFrame();
        frame.setBounds(100, 100, 500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JFrame inputFrame = new JFrame();
        inputFrame.setLayout(new GridLayout(8, 2, 10, 10));
        inputFrame.setVisible(true);

        inputFrame.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputFrame.add(nameField);

        inputFrame.add(new JLabel("Graduation:"));
        graduationField = new JTextField();
        inputFrame.add(graduationField);

        inputFrame.add(new JLabel("Institution:"));
        institutionField = new JTextField();
        inputFrame.add(institutionField);

        inputFrame.add(new JLabel("Phone number:"));
        phoneField = new JTextField();
        inputFrame.add(phoneField);

        inputFrame.add(new JLabel("College email:"));
        collegeEmailField = new JTextField();
        inputFrame.add(collegeEmailField);

        inputFrame.add(new JLabel("Personal email:"));
        personalEmailField = new JTextField();
        inputFrame.add(personalEmailField);

        inputFrame.add(new JLabel("LinkedIn:"));
        linkedInField = new JTextField();
        inputFrame.add(linkedInField);

        inputFrame.add(new JLabel("Profile Summary:"));
        profileSummaryArea = new JTextArea(3, 20);
        inputFrame.add(new JScrollPane(profileSummaryArea));
        
        frame.getContentPane().add(inputFrame.getContentPane());

        JFrame buttonFrame = new JFrame();
        buttonFrame.setLayout(new GridLayout(5, 1, 10, 10));
        buttonFrame.setVisible(true);

        JButton educationButton = new JButton("Education Details");
        educationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to Education section
//                JOptionPane.showMessageDialog(frame, "Navigate to Education Section");
                // Add navigation code here
            	if (education == null) {
                    education = new Education(); // Ensure the object is created if not already done
                }
                education.showEducationForm();
            }
        });
        buttonFrame.add(educationButton);

        JButton experienceButton = new JButton("Experience Details");
        experienceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to Experience section
//                JOptionPane.showMessageDialog(frame, "Navigate to Experience Section");
                // Add navigation code here
            	if(experience == null ) {
            		experience = new Experience();
            	}
            	experience.showExperienceForm();
            }
        });
        buttonFrame.add(experienceButton);
        
        JButton projectsButton = new JButton("Projects Details");
        projectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(project == null ) {
            		project = new Project();
            	}
                project.showProjectForm();
            }
        });
        buttonFrame.add(projectsButton);
        

        JButton technicalSkillsButton = new JButton("Add Technical Skills");
        technicalSkillsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (technicalSkills == null) {
                    technicalSkills = new TechnicalSkills();
                }
                technicalSkills.showTechnicalSkillsForm();
            }
        });
        buttonFrame.add(technicalSkillsButton);
        
        JButton relevantCoursesButton = new JButton("Add Relevant Courses");
        relevantCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (relevantCourses == null) {
                    relevantCourses = new RelevantCourses();
                }
                relevantCourses.showRelevantCoursesForm();
            }
        });
        buttonFrame.add(relevantCoursesButton);
        
        JButton achievementButton = new JButton("Add Achievements");
        achievementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (achievement == null) {
                    achievement = new Achievement();
                }
                achievement.showAchievementForm();
            }
        });
        buttonFrame.add(achievementButton);
        
        JButton hobbieButton = new JButton("Add Hobbies");
        hobbieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hobbie == null) {
                    hobbie = new Hobbie();
                }
                hobbie.showHobbieForm();
            }
        });
        buttonFrame.add(hobbieButton);

        

        JButton generatePdfButton = new JButton("Generate PDF");
        generatePdfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTemplateSelectionFrame();
            }
        });
        buttonFrame.add(generatePdfButton);

        frame.getContentPane().add(buttonFrame.getContentPane());     
    }
        
    private void showTemplateSelectionFrame() {
        JFrame templateFrame = new JFrame("Select Template");
        templateFrame.setSize(300, 200);
        templateFrame.setLayout(new GridLayout(3, 1, 10, 10));
        
        JButton template1Button = new JButton("Template-1");
        template1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TemplateOneGeneratePDF.generatePDF(
                    nameField.getText(), graduationField.getText(), institutionField.getText(), phoneField.getText(), 
                    collegeEmailField.getText(), personalEmailField.getText(), linkedInField.getText(), 
                    profileSummaryArea.getText(), education, experience, project, technicalSkills, relevantCourses, 
                    achievement, hobbie
                );
            }
        });
        templateFrame.add(template1Button);
        
//        JButton template2Button = new JButton("Template-2");
//        template2Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String name = nameField.getText();
//                String graduation = ""; // Collect graduation value if applicable
//                String institution = ""; // Collect institution value if applicable
//                String phone = phoneField.getText();
//                String collegeEmail = ""; // Collect college email if applicable
//                String personalEmail = personalEmailField.getText();
//                String linkedIn = linkedInField.getText();
//                String profileSummary = profileSummaryArea.getText();
//
//                Education education = new Education();
//                Experience experience = new Experience(); // Collect experience details if applicable
//                Project project = new Project(); // Collect project details if applicable
//                TechnicalSkills technicalSkills = new TechnicalSkills(); // Collect technical skills details if applicable
//                RelevantCourses relevantCourses = new RelevantCourses(); // Collect relevant courses details if applicable
//                Achievement achievement = new Achievement(); // Collect achievement details if applicable
//                Hobbie hobbies = new Hobbie(); // Collect hobbies details if applicable
//
//                TemplateTwoGeneratePDF.generatePDF(
//                    name, /*graduation, institution,*/ phone, /*collegeEmail,*/ personalEmail, 
//                    linkedIn, profileSummary, education, experience, project, 
//                    technicalSkills, relevantCourses, achievement, hobbies
//                );
//            }
//        });
//        templateFrame.add(template2Button);
//        templateFrame.setVisible(true);


        
        JButton template2Button = new JButton("Template-2");
        template2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TemplateTwoGeneratePDF.generatePDF(
                    nameField.getText(), phoneField.getText(), personalEmailField.getText(), linkedInField.getText(), 
                    profileSummaryArea.getText(), education, experience, project, technicalSkills, relevantCourses, 
                    achievement, hobbie
                );
            }
        });
        templateFrame.add(template2Button);
        templateFrame.setVisible(true);
    }
}    
    
    
         
    
    
    /*
    private void generatePDF() 
    {
    	
    	String userName = nameField.getText().replaceAll("\\s+", ""); // Remove spaces from the name

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Set to directories only
        int option = fileChooser.showSaveDialog(frame);

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
                leftTable.addCell(new PdfPCell(new Phrase(nameField.getText(), nameFont))).setBorder(Rectangle.NO_BORDER);
                leftTable.addCell(new PdfPCell(new Phrase(graduationField.getText(), normalFont))).setBorder(Rectangle.NO_BORDER);
                leftTable.addCell(new PdfPCell(new Phrase(institutionField.getText(), normalFont))).setBorder(Rectangle.NO_BORDER);

                PdfPCell leftCell = new PdfPCell(leftTable);
                leftCell.setBorder(Rectangle.NO_BORDER);
                detailsTable.addCell(leftCell);

                PdfPTable rightTable = new PdfPTable(1);
                rightTable.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Remove cell borders
                rightTable.addCell(new PdfPCell(new Phrase(phoneField.getText(), normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(collegeEmailField.getText(), normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(personalEmailField.getText(), normalFont))).setBorder(Rectangle.NO_BORDER);
                rightTable.addCell(new PdfPCell(new Phrase(linkedInField.getText(), normalFont))).setBorder(Rectangle.NO_BORDER);

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

                Paragraph profileSummaryParagraph = new Paragraph(profileSummaryArea.getText(), normalFont);
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
                document.add(new Paragraph("Technical Skills", headingFont));
                document.add(new LineSeparator());

                // Add Technical Skills data
                if (technicalSkills != null) {
                    TechnicalSkillsDetails details = technicalSkills.getTechnicalSkillsDetails();
                    document.add(new Paragraph("Programming Languages: " + details.getProgrammingLanguages(), normalFont));
                    document.add(new Paragraph("Tools: " + details.getTools(), normalFont));
                }

             // Add Relevant Courses section
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Relevant Courses", headingFont));
                document.add(new LineSeparator());

                // Add Relevant Courses data
                if (relevantCourses != null) {
                    RelevantCoursesDetails details = relevantCourses.getRelevantCoursesDetails();
                    document.add(new Paragraph("Academic Courses: " + details.getAcademicCourses(), normalFont));
                    document.add(new Paragraph("Certificate Courses: " + details.getCertificateCourses(), normalFont));
                    document.add(new Paragraph("Other Courses: " + details.getOtherCourses(), normalFont));
                }

                
                

                document.close();
                JOptionPane.showMessageDialog(frame, "PDF created successfully!");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error creating PDF: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No folder selected. PDF generation canceled.");
        }
    }

    private void addCellToTable(PdfPTable table, String text, Font font, boolean isHeader) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        if (isHeader) {
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        }
        table.addCell(cell);
    }
    	
    	
}
*/
