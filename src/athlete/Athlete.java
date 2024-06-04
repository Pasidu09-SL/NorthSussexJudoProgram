package athlete;


public class Athlete {
    // Variables
    private String athleteName;
    private String trainingPlan;
    private double currentWeight;
    private double competitionWeightCategory;
    private int numCompetitions;
    private int numPrivateCoachingHours;

    // Constructor Method
    // When an athlete object is created, this constructor method initializes the
    // object with the supplied data.
    public Athlete(String athleteName, String trainingPlan, double currentWeight, double competitionWeightCategory,
            int numCompetitions, int numPrivateCoachingHours) {
        this.athleteName = athleteName;
        this.trainingPlan = trainingPlan;
        this.currentWeight = currentWeight;
        this.competitionWeightCategory = competitionWeightCategory;
        this.numCompetitions = numCompetitions;
        this.numPrivateCoachingHours = numPrivateCoachingHours;
    }

    // Calculates the training fee
    public double calculateTrainingFee() {
        double weeklyFee;
        switch (trainingPlan) {
            case "Beginner":
                weeklyFee = 25.00;
                break;
            case "Intermediate":
                weeklyFee = 30.00;
                break;
            case "Elite":
                weeklyFee = 35.00;
                break;
            default:
                throw new IllegalArgumentException("Invalid training plan");
        }
        // return the Training Fee as a double
        return weeklyFee * 4; // 4 weeks in a month
    }

    // Calculates the competition fee
    public double calculateCompetitionFee() {
        if ("Intermediate".equals(trainingPlan) || "Elite".equals(trainingPlan)) {
            return numCompetitions * 22.00; // Competition entry fee
        }
        // return the Competition Fee as a double
        return 0.0;
    }

    // Calculates the private coaching fee
    public double calculatePrivateCoachingFee() {

        return numPrivateCoachingHours * 9.50 * 4; // Hourly rate per month,return the PrivateCoaching Fee as a double
    }

    // Calculates the private coaching fee
    public double calculateTotalCost() {
        return calculateTrainingFee() + calculateCompetitionFee() + calculatePrivateCoachingFee();// return the Total
                                                                                                  // Cost as a double
    }

    // Compares the athlete's current weight to the competition weight category and
    // it return as a String
    public String compareWeightToCategory() {
        if (currentWeight <= competitionWeightCategory) {
            return "Meets Category";
        } else {
            return "Above Category";
        }
    }

    // Displays athlete information and calculated costs
    public void displayAthleteInformation(int athleteNumber) {
        System.out.println("\n========================================");
        System.out.println("Athlete ID No: " + athleteNumber);
        System.out.println("Athlete                         : " + athleteName);
        System.out.println("Training Plan                   : " + trainingPlan);
        System.out.println("Training Fee For Month          : £" + String.format("%.2f", calculateTrainingFee()));
        System.out.println("Private Coaching Fee For Month  : £" + String.format("%.2f", calculatePrivateCoachingFee()));
        System.out.println("Total Competition Fee           : £" + String.format("%.2f", calculateCompetitionFee()));
        System.out.println("Total Cost for the Month        : £" + String.format("%.2f", calculateTotalCost()));
        System.out.println("Weight Comparison               : " + compareWeightToCategory());
        System.out.println("========================================");
    }

    // Displays athlete information and calculated costs
    public void displayCheckAthleteInformation(int athleteNumber) {
        System.out.println("\n========================================");
        System.out.println("Athlete ID No: " + athleteNumber);
        System.out.println("Athlete                         : " + athleteName);
        System.out.println("Training Plan                   : " + trainingPlan);
        System.out.println("CurrentWeight                   :"  +currentWeight);
        System.out.println("Competition Weight Category     : " + competitionWeightCategory);
        System.out.println("Number of Competitions Entered  : " + numCompetitions);
        System.out.println("Private Coaching Hourse         : " + numCompetitions);
        System.out.println("Training Fee For Month          : £"+ String.format("%.2f", calculateTrainingFee()));
        System.out.println("Private Coaching Fee For Month  : £"+ String.format("%.2f", calculatePrivateCoachingFee()));
        System.out.println("Total Competition Fee           : £"+ String.format("%.2f", calculateCompetitionFee()));
        System.out.println("Total Cost for the Month        : £"+ String.format("%.2f", calculateTotalCost()));
        System.out.println("Weight Comparison               : " + compareWeightToCategory());
        System.out.println("========================================");
    }
}