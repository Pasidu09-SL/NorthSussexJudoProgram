import athlete.Athlete; //imports the Athlete class from the athlete package
import java.util.Scanner;

public class NorthSussexJudoProgram {

    // Additional Informatiion Method
    // This method displays additional information about training plans, prices, and
    // weight categories.
    public static void AdditionalInoformatin() {
        System.out.println("\n                                      - Additional Information -              ");
        System.out.println("                                       ========================\n");
        System.out.println(
                "====================================================\t===========================================================");
        System.out.println(
                "|              Training Plan - Prices              |\t| Weight Categories             | Upper Weight Limit (kg) |");
        System.out.println(
                "====================================================\t===========================================================");
        System.out.println(
                "| Beginner (2 sessions/week)              | £25.00 |\t| Heavyweight                   | Unlimited (Over 100)    |");
        System.out.println(
                "| Intermediate (3 sessions/week)          | £30.00 |\t| Light-Heavyweight             | 100                     |");
        System.out.println(
                "| Elite (5 sessions/week)                 | £35.00 |\t| Middleweight                  | 90                      |");
        System.out.println(
                "| Private tuition (per hour)              | £9.50  |\t| Light-Middleweight            | 81                      |");
        System.out.println(
                "| Competition entry fee (per competition) | £22.00 |\t| Lightweight                   | 73                      |");
        System.out.println(
                "====================================================\t| Flyweight                     | 66                      |");
        System.out.println(
                "                                                    \t===========================================================");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n                          ====================================================");
        System.out.println("                          |  North Sussex Judo Training Cost Calculator      |");
        System.out.println("                          ====================================================");

        System.out.println("\n                          Welcome to North Sussex Judo Training Cost Calculator");

        // For Call the Athlete
        int athleteNumber = 1;

        // Athlete Input and Processing
        while (true) {
            // Calling Method Additional informations Details
            AdditionalInoformatin();

            System.out.print("\nEnter the athlete's Name: ");
            String athleteName = input.next();

            System.out.print("Enter the training plan {Beginner(1)/Intermediate(2)/Elite(3)}: ");// Getting user input Easily
            String trainingPlan = "";

            // Validate the Training Plan
            while (true) {
                String userInput = input.next();
                if (userInput.equalsIgnoreCase("Beginner") || userInput.equalsIgnoreCase("1")
                        || userInput.equalsIgnoreCase("Intermediate") || userInput.equalsIgnoreCase("2")
                        || userInput.equalsIgnoreCase("Elite") || userInput.equalsIgnoreCase("3")) {
                    trainingPlan = userInput;
                    break; // Exit the loop when valid input is provided
                } else {
                    System.out.print("Invalid training plan. Please enter (Beginner(1)/Intermediate(2)/Elite(3)): ");
                }
            }
            // Converts input numbers to words
            switch (trainingPlan) {
                case "1":
                    trainingPlan = "Beginner";
                    break;
                case "2":
                    trainingPlan = "Intermediate";
                    break;
                case "3":
                    trainingPlan = "Elite";
                    break;
                default:
                    break;
            }

            double currentWeight = 0.0; // Initialize currentWeight variable

            // Validate the weight
            while (true) {
                System.out.print("Enter The current weight (kg): ");
                if (input.hasNextDouble()) {
                    currentWeight = input.nextDouble();
                    break; // Break the loop if a valid double is entered
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.next(); // Consume invalid input
                }
            }

            double competitionWeightCategory = 0.0; // Initialize competitionWeightCategory variable
            int numCompetitions = 0; // Initialize numCompetitions variable

            if ("Beginner".equals(trainingPlan)) {
                System.out.println("You don't have competitions until you are Intermediate or Elite.");
            } else {
                // Validate the competition weight category
                while (true) {
                    System.out.print("Enter competition weight category: ");
                    if (input.hasNextDouble()) {
                        numCompetitions = input.nextInt();
                        if (numCompetitions == 66 || numCompetitions == 73 || numCompetitions == 81
                                || numCompetitions == 90 || numCompetitions == 100 || numCompetitions > 100) {
                            break; // Break the loop if a valid number is entered within the range.
                        } else {
                            System.out.println("Invalid input. Please Enter a valid competition weight category.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        input.next(); // Consume invalid input
                    }
                }

                // Validate the number of compititions
                while (true) {
                    System.out.print("Enter number of competitions entered this month: ");
                    if (input.hasNextDouble()) {
                        numCompetitions = input.nextInt();
                        break; // Break the loop if a valid double is entered
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        input.next(); // Consume invalid input
                    }
                }
            }

            int numPrivateCoachingHours = 0;// Initialize numPrivateCoachingHours variable

            // Validate the Private Coaching Hrs
            while (true) {
                System.out.print("Enter number of hours of private coaching (0 to 5): ");
                if (input.hasNextInt()) {
                    numPrivateCoachingHours = input.nextInt();
                    if (numPrivateCoachingHours >= 0 && numPrivateCoachingHours <= 5) {
                        break; // Break the loop if a valid number is entered within the range.
                    } else {
                        System.out.println("Invalid input. Please enter a number between 0 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.next(); // Consume invalid input
                }
            }

            // Creating the Athlete Objects
            // Each athlete, an Athlete object is created with the entered data.
            Athlete athlete = new Athlete(athleteName, trainingPlan, currentWeight, competitionWeightCategory,
                    numCompetitions, numPrivateCoachingHours);

            // Displaying Athlete Information
            // Athlete object is called to display the athlete's information and calculated
            // costs.
            athlete.displayAthleteInformation(athleteNumber);

            // If you want to Chek Previos athletes information
            System.out.print("\nDo you need to Chek Previos Athlete's Iformations (y/n): ");
            String check = input.next();
            int checkNumber;
            if (check.equalsIgnoreCase("y")) {
                while (true) {
                    System.out.print("Input the Athlete's Number: ");
                    if (input.hasNextInt()) {
                        checkNumber = input.nextInt();
                        if (checkNumber <= athleteNumber) {
                            athlete.displayCheckAthleteInformation(checkNumber);
                            break; // Break the loop if a valid number is entered within the range.
                        } else {
                            System.out.println(
                                    "Invalid input. Please enter an athlete's ID number have been entered before.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid athlete's ID number have been entered before.");
                        input.next(); 
                    }
                }
            }

            // If you want to include more athletes
            System.out.print("\nDo you need to Add more Athletes (y/n): ");
            String addMore = input.next();

            if (!addMore.equalsIgnoreCase("y")) {
                System.out.println("\nThank you for using the North Sussex Judo Training Cost Calculator.\n");
                break;
            }
            // Increase the athlete's number
            athleteNumber++;
        }

        input.close();
    }
}
