package se.iths;

import se.iths.entity.Country;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

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
                        System.out.println("\n Choose alternative for Country" +
                                "\n0  - Create" +
                                "\n1  - Read" +
                                "\n2  - Update" +
                                "\n3  - Delete" +
                                "\n4  - Return to main menu");
                        int countryAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (countryAction) {
                            //Create
                            case 0 -> {
                                System.out.print("Enter name of educator:");
                                String saveCountry = scanner.nextLine();
                                countries.save(saveCountry);
                                }
                            //Read
                            case 1 -> {
                                System.out.println("Choose read alternative" +
                                        "\n0 show all countries" +
                                        "\n1 Search for an country");
                                int countryReadAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (countryReadAction) {
                                    case 0 -> countries.findAll();
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
                                    case 0 -> schools.findAll();
                                    case 1 -> {
                                        System.out.print("Enter school name: ");
                                        String schoolName = scanner.nextLine();
                                        schools.findByName(schoolName);
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
                        System.out.println("\n Choose alternative for Student" +
                                "\n0  - Create" +
                                "\n1  - Read" +
                                "\n2  - Update" +
                                "\n3  - Delete" +
                                "\n4  - Return to main menu");
                        int studentAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (studentAction) {
                            //Create
                            case 0 -> {}
                            //Read
                            case 1 -> {}
                            //Update
                            case 2 -> {}
                            //Delete
                            case 3 -> {}
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
                        System.out.println("\n Choose alternative for Educator" +
                                "\n0  - Create" +
                                "\n1  - Read" +
                                "\n2  - Update" +
                                "\n3  - Delete" +
                                "\n4  - Return to main menu");
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
                                System.out.println("Choose read alternative" +
                                        "\n0 show all educators" +
                                        "\n1 Search for an educator");
                                int educatorReadAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (educatorReadAction) {
                                    case 0 -> educators.findAll();
                                    case 1 -> {
                                        System.out.print("Enter name of educator:");
                                        String findEducator = scanner.nextLine();
                                        educators.findByName(findEducator);
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
                        System.out.println("\n Choose alternative for Course" +
                                "\n0  - Create" +
                                "\n1  - Read" +
                                "\n2  - Update" +
                                "\n3  - Delete" +
                                "\n4  - Return to main menu");

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
                case 6 -> mainMenu();
            }
        }
    }

    private static void mainMenu() {
        System.out.println("\nChoose:\n");
        System.out.println("0  - Close\n" +
                "1  - Country\n" +
                "2  - School \n" +
                "3  - Student\n" +
                "4  - Educator \n" +
                "5  - Course\n" +
                "6  - Show alternatives againg.");
    }
}
