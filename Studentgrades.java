import java.util.ArrayList;
import java.util.Scanner;
public class Studentgrades 
{
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.println("Enter student grades (type 'done' to finish):");

        // Read grades from the user
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int grade = Integer.parseInt(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Please enter a grade between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade or 'done' to finish.");
            }
        }

        // Calculate average, highest, and lowest grades
        if (!grades.isEmpty()) {
            int sum = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int grade : grades) {
                sum += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = (double) sum / grades.size();

            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        } else {
            System.out.println("No grades entered.");
        }

        scanner.close();
    }
}


