package se.iths;

import se.iths.entity.Country;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Countries countries = new Countries();
        Educators educators = new Educators();
        Students students = new Students();
        Schools schools = new Schools();
        Courses courses = new Courses();

        boolean mainQuit = false;
        mainMenu();
        while (!mainQuit) {
            System.out.println("\nChoose 6 to show alternatives again");
            int mainMenuAction = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuAction) {
                case 0 -> {
                    System.out.println("\nClosing program");
                    mainQuit = true;
                }
                case 1 -> {
                    boolean countryQuit = false;
                    while (!countryQuit) {
                        System.out.println("""
                                 Choose alternative for Country
                                0  - Create
                                1  - Read
                                2  - Update
                                3  - Delete
                                4  - Return to main menu
                                """);
                        int countryAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (countryAction) {
                            //Create
                            case 0 -> {
                                System.out.print("Enter name of country:");
                                String saveCountry = scanner.nextLine();
                                countries.save(saveCountry);
                                }
                            //Read
                            case 1 -> {
                                System.out.println("""
                                        Choose read alternative
                                        0 show all countries
                                        1 Search for an country
                                        """);
                                int countryReadAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (countryReadAction) {
                                    case 0 -> countries.findAll().forEach(System.out::println);
                                    case 1 -> {
                                        System.out.print("Enter name of country:");
                                        String findCountry = scanner.nextLine();
                                        System.out.println(countries.findByName(findCountry));
                                    }
                                }
                            }
                            //Update
                            case 2 -> {
                                System.out.print("Enter old name of country:");
                                String updateCountryOldName = scanner.nextLine();
                                System.out.print("Enter new name of country: ");
                                String updateCountryNewName = scanner.nextLine();
                                countries.update(updateCountryOldName, updateCountryNewName);
                            }
                            //Delete
                            case 3 -> {
                                System.out.print("Enter name of country you want to delete:");
                                String deleteCountry = scanner.nextLine();
                                countries.delete(deleteCountry);
                            }
                            //Return to main menu
                            case 4 -> {
                                countryQuit = true;
                                mainMenu();
                            }
                        }
                    }
                }
                case 2 -> {
                    boolean schoolQuit = false;
                    while (!schoolQuit) {
                        System.out.println("""
                                 Choose alternative for School
                                0  - Create
                                1  - Read
                                2  - Update
                                3  - Delete
                                4  - Return to main menu
                                """);
                        int schoolAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (schoolAction) {
                            //Create
                            case 0 -> {
                                System.out.print("Enter school name: ");
                                String schoolName = scanner.nextLine();
                                System.out.print("Enter school country: ");
                                String schoolCountry = scanner.nextLine();
                                schools.save(schoolName, schoolCountry);
                            }
                            //Read
                            case 1 -> {
                                System.out.print("""
                                        0 - Show all schools
                                        1 - Search for a school
                                        """);
                                int schoolReadAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (schoolReadAction) {
                                    case 0 -> schools.findAll().forEach(System.out::println);
                                    case 1 -> {
                                        System.out.print("Enter school name: ");
                                        String schoolName = scanner.nextLine();
                                        System.out.println(schools.findByName(schoolName));
                                    }
                                }
                            }
                            //Update
                            case 2 -> {
                                System.out.print("Enter name of school to update: ");
                                String schoolName = scanner.nextLine();
                                System.out.print("Enter new school name: ");
                                String updateSchoolName = scanner.nextLine();
                                System.out.print("Enter new school country: ");
                                String updateSchoolCountry = scanner.nextLine();

                                Optional<Country> countryOptional = Optional.ofNullable(countries.findByName(updateSchoolCountry));
                                if (countryOptional.isEmpty()) {
                                    System.out.println("Country not found: " + updateSchoolCountry);
                                    break;
                                }

                                Country newCountry = countryOptional.get();

                                schools.update(schoolName, updateSchoolName, newCountry);
                            }
                            //Delete
                            case 3 -> {
                                System.out.print("Enter name of school to delete: ");
                                String deleteSchool = scanner.nextLine();
                                schools.delete(deleteSchool);
                            }
                            //Return to main menu
                            case 4 -> {
                                schoolQuit = true;
                                mainMenu();
                            }
                        }
                    }
                }
                case 3 -> {
                    boolean studentQuit = false;
                    while (!studentQuit) {
                        System.out.println("""
                                 Choose alternative for Student
                                0  - Create
                                1  - Read
                                2  - Update
                                3  - Delete
                                4  - Return to main menu
                                """);
                        int studentAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (studentAction) {
                            //Create
                            case 0 -> {
                                System.out.print("Enter student name: ");
                                String studentName = scanner.nextLine();
                                System.out.print("Enter school name: ");
                                String studentSchool = scanner.nextLine();
                                System.out.print("Enter course name: ");
                                String studentCourse = scanner.nextLine();
                                System.out.print("Enter country name: ");
                                String studentCountry = scanner.nextLine();

                                students.save(studentName, studentSchool, studentCourse, studentCountry);
                                System.out.println("Student created successfully!");
                            }
                            //Read
                            case 1 -> {
                                System.out.print("""
                                        Choose read alternative:
                                        0 - Show all students
                                        1 - Search for a student
                                        """);

                                int studentReadAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (studentReadAction) {
                                    case 0 -> students.findAll().forEach(System.out::println);
                                    case 1 -> {
                                        System.out.print("Enter student name: ");
                                        String studentName = scanner.nextLine();
                                        students.findByName(studentName);
                                    }
                                }
                            }
                            //Update
                            case 2 -> {
                                System.out.print("Enter name of student to update: ");
                                String updateStudentName = scanner.nextLine();
                                System.out.print("Enter new name of student: ");

                                System.out.print("Enter new school name: ");
                                String updateStudentSchool = scanner.nextLine();

                                System.out.print("Enter new course name: ");
                                String updateStudentCourse = scanner.nextLine();
                                students.update(updateStudentName, updateStudentSchool, updateStudentCourse);
                            }
                            //Delete
                            case 3 -> {
                                System.out.print("Enter name of student to delete: ");
                                String deleteStudent = scanner.nextLine();
                                students.delete(deleteStudent);
                            }
                            //Return to main menu
                            case 4 -> {
                                studentQuit = true;
                                mainMenu();
                            }
                        }
                    }
                }
                case 4 -> {
                    boolean educatorQuit = false;
                    while (!educatorQuit) {
                        System.out.println("""
                                 Choose alternative for Educator
                                0  - Create
                                1  - Read
                                2  - Update
                                3  - Delete
                                4  - Return to main menu
                                """);
                        int educatorAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (educatorAction) {
                            //Create
                            case 0 -> {
                                System.out.print("Enter name of educator:");
                                String saveEducator = scanner.nextLine();
                                System.out.print("Enter school the educator works at: ");
                                String saveSchool = scanner.nextLine();
                                educators.save(saveEducator, saveSchool);
                            }
                            //Read
                            case 1 -> {
                                System.out.println("""
                                        Choose read alternative
                                        0 show all educators
                                        1 Search for an educator
                                        """);
                                int educatorReadAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (educatorReadAction) {
                                    case 0 -> educators.findAll();
                                    case 1 -> {
                                        System.out.print("Enter name of educator:");
                                        String findEducator = scanner.nextLine();
                                        System.out.println(educators.findByName(findEducator));
                                    }
                                }
                            }
                            //Update
                            case 2 -> {
                                System.out.print("Enter old name of educator:");
                                String updateEducatorOldName = scanner.nextLine();
                                System.out.print("Enter new name of educator: ");
                                String updateEducatorNewName = scanner.nextLine();
                                System.out.print("Enter school the educator works at: ");
                                String updateEducatorSchool = scanner.nextLine();
                                educators.update(updateEducatorOldName, updateEducatorNewName, updateEducatorSchool);
                            }
                            //Delete
                            case 3 -> {
                                System.out.print("Enter name of educator you want to delete:");
                                String deleteEducator = scanner.nextLine();
                                educators.delete(deleteEducator);
                            }
                            //Return to main menu
                            case 4 -> {
                                educatorQuit = true;
                                mainMenu();
                            }
                        }
                    }
                }
                case 5 -> {
                    boolean courseQuit = false;
                    while (!courseQuit) {
                        System.out.println("""
                                 Choose alternative for Course
                                0  - Create
                                1  - Read
                                2  - Update
                                3  - Delete
                                4  - Return to main menu
                                """);
                        int courseAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (courseAction) {
                            //Create
                            case 0 -> {
                                System.out.print("Enter course code: ");
                                String courseCode = scanner.nextLine();

                                System.out.print("Enter name of course:");
                                String courseName = scanner.nextLine();

                                System.out.print("Enter educator for course: ");
                                String courseEducator = scanner.nextLine();

                                System.out.print("Enter school for course: ");
                                String courseSchool = scanner.nextLine();
                                courses.save(courseCode, courseName, courseEducator, courseSchool);
                            }
                            //Read
                            case 1 -> {
                                System.out.print("""
                                        Choose an alternative to view courses:
                                        0 - Show all courses
                                        1 - Search for a course
                                        """);
                                int readCourseAction = scanner.nextInt();
                                scanner.nextLine();

                                switch(readCourseAction){
                                    case 0 -> courses.findAll();
                                    case 1 -> {System.out.print("Enter course code: ");
                                        String courseCode = scanner.nextLine();
                                        System.out.print(courses.findById(courseCode));
                                    }
                                }
                            }
                            //Update
                            case 2 -> {
                                System.out.print("Enter old course name: ");
                                String updateOldCourseName = scanner.nextLine();

                                System.out.print("Enter new course name: ");
                                String updateNewCourseName = scanner.nextLine();

                                System.out.print("Enter new educator name: ");
                                String updateCourseEducator = scanner.nextLine();

                                System.out.print("Enter new school name: ");
                                String updateCourseSchool = scanner.nextLine();

                                courses.update(updateOldCourseName, updateNewCourseName, updateCourseEducator, updateCourseSchool);
                            }
                            //Delete
                            case 3 -> {
                                System.out.print("Enter the name of the course to delete: ");
                                String deleteCourseName = scanner.nextLine();
                                courses.delete(deleteCourseName);
                            }
                            //Return to main menu
                            case 4 -> {
                                courseQuit = true;
                                mainMenu();
                            }
                        }
                    }
                }
                case 6 -> {
                    boolean statisticsQuit = false;
                    while (!statisticsQuit) {
                        System.out.println("""
                                 Choose alternative for Statistics
                                0  - Students per school
                                1  - Students per country
                                2  - Students per course
                                3  - Course per educator
                                4  - School per country
                                5  - Return to main menu
                                """);
                        int statisticsAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (statisticsAction) {
                            case 0 -> schools.studentsPerSchool().forEach(System.out::println);
                            case 1 -> countries.studentsPerCountry().forEach(System.out::println);
                            case 2 -> courses.studentsPerCourse().forEach(System.out::println);
                            case 3 -> educators.coursesPerEducator().forEach(System.out::println);
                            case 4 -> countries.schoolsPerCountry().forEach(System.out::println);
                            //Return to main menu
                            case 5 -> {
                                statisticsQuit = true;
                                mainMenu();
                            }
                        }
                    }
                }
                case 7 -> mainMenu();
            }
        }
    }

    private static void mainMenu() {
        System.out.println("Choose:");
        System.out.println("""
                0  - Close
                1  - Country
                2  - School
                3  - Student
                4  - Educator
                5  - Course
                6  - Statistics
                """);
    }
}
