import java.sql.*;
import java.util.Scanner;

public class PatientService {

    Scanner sc = new Scanner(System.in);

    // Add Patient
    public void addPatient() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO patients(name, age, gender, contact, disease, doctor, medical_history) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("Name: ");
            ps.setString(1, sc.nextLine());

            System.out.print("Age: ");
            ps.setInt(2, sc.nextInt());
            sc.nextLine();

            System.out.print("Gender: ");
            ps.setString(3, sc.nextLine());

            System.out.print("Contact: ");
            ps.setString(4, sc.nextLine());

            System.out.print("Disease: ");
            ps.setString(5, sc.nextLine());

            System.out.print("Doctor: ");
            ps.setString(6, sc.nextLine());

            System.out.print("Medical History: ");
            ps.setString(7, sc.nextLine());

            ps.executeUpdate();
            System.out.println("✅ Patient added successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Medical History
    public void updateHistory() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE patients SET medical_history=? WHERE patient_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("New Medical History: ");
            String history = sc.nextLine();

            ps.setString(1, history);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("✅ Medical history updated");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Patient
    public void viewPatient() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM patients WHERE patient_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Patient Details ---");
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Contact: " + rs.getString("contact"));
                System.out.println("Disease: " + rs.getString("disease"));
                System.out.println("Doctor: " + rs.getString("doctor"));
                System.out.println("Medical History: " + rs.getString("medical_history"));
            } else {
                System.out.println("❌ Patient not found");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
