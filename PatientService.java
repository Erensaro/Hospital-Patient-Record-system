import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {

        PatientService service = new PatientService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Hospital Patient Record System =====");
            System.out.println("1. Add New Patient");
            System.out.println("2. Update Medical History");
            System.out.println("3. View Patient Details");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addPatient();
                    break;
                case 2:
                    service.updateHistory();
                    break;
                case 3:
                    service.viewPatient();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }
}
