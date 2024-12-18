package se.iths;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Countries countries = new Countries();
        Educators educators = new Educators();



        boolean mainQuit = false;
        mainMenu();
        while (!mainQuit) {
            System.out.println("\nChoose 6 to show alternatives aging");
            int mainMenuAction = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuAction) {
                case 0:
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
                                        educators.findByName(findCountry);
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
                            case 3:

                                break;
                            //Return to main menu
                            case 4:
                                countryQuit = true;
                                mainMenu();
                                break;
                        }
                    }
                }
                case 2 -> {
                    boolean shcoolQuit = false;
                    while (!shcoolQuit) {
                        System.out.println("\n Choose alternative for School" +
                                "\n0  - Create" +
                                "\n1  - Read" +
                                "\n2  - Update" +
                                "\n3  - Delete" +
                                "\n4  - Return to main menu");
                        int schoolAction = scanner.nextInt();
                        scanner.nextLine();
                        switch (schoolAction) {
                            //Create
                            case 0:

                                break;
                            //Read
                            case 1:

                                break;
                            //Update
                            case 2:

                                break;
                            //Delete
                            case 3:

                                break;
                            //Return to main menu
                            case 4:
                                shcoolQuit = true;
                                mainMenu();
                                break;
                        }
                    }
                    break;
                case 3:
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
                            case 0:

                                break;
                            //Read
                            case 1:

                                break;
                            //Update
                            case 2:

                                break;
                            //Delete
                            case 3:

                                break;
                            //Return to main menu
                            case 4:
                                studentQuit = true;
                                mainMenu();
                                break;
                        }
                    }
                    break;
                case 4:
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
                            case 0:
                                System.out.print("Enter name of educator:");
                                String saveEducator = scanner.nextLine();
                                System.out.print("Enter school the educator works at: ");
                                String saveSchool = scanner.nextLine();
                                educators.save(saveEducator,saveSchool);
                                break;
                            //Read
                            case 1:
                                System.out.println("Choose read alternative" +
                                        "\n0 show all educators" +
                                        "\n1 Search for an educator");
                                int educatorReadAction = scanner.nextInt();
                                scanner.nextLine();
                                switch (educatorReadAction){
                                    case 0:
                                        educators.findAll();
                                        break;
                                    case 1:
                                        System.out.print("Enter name of educator:");
                                        String findEducator = scanner.nextLine();
                                        educators.findByName(findEducator);
                                        break;
                                }
                                break;
                            //Update
                            case 2:
                                System.out.print("Enter old name of educator:");
                                String updateEducatorOldName = scanner.nextLine();
                                System.out.print("Enter new name of educator: ");
                                String updateEducatorNewName = scanner.nextLine();
                                System.out.print("Enter school the educator works at: ");
                                String updateEducatorSchool = scanner.nextLine();
                                educators.update(updateEducatorOldName, updateEducatorNewName, updateEducatorSchool);
                                break;
                            //Delete
                            case 3:
                                System.out.print("Enter name of educator you want to delete:");
                                String deleteEducator = scanner.nextLine();
                                educators.delete(deleteEducator);
                                break;
                            //Return to main menu
                            case 4:
                                educatorQuit = true;
                                mainMenu();
                                break;
                        }
                    }
                    break;
                case 5:
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
                            case 0:

                                break;
                            //Read
                            case 1:

                                break;
                            //Update
                            case 2:

                                break;
                            //Delete
                            case 3:

                                break;
                            //Return to main menu
                            case 4:
                                courseQuit = true;
                                mainMenu();
                                break;
                        }
                    }
                case 6:
                    mainMenu();
                    break;
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
