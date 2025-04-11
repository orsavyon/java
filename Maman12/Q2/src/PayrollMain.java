import java.util.Calendar;

/**
 * Main program to demonstrate polymorphic processing of employees,
 * birthday bonus, and the use of PieceWorker employee type.
 */
public class PayrollMain {
    public static void main(String[] args) {
        // Create array of 5 employees (including a PieceWorker)
        Employee[] employees = new Employee[5];

        // Get current month (1–12)
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;

        // Add various types of employees
        employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111",
                new Date(15, currentMonth, 1980), 800.00);

        employees[1] = new HourlyEmployee("Karen", "Price", "222-22-2222",
                new Date(12, 3, 1990), 16.75, 40);

        employees[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333",
                new Date(9, 6, 1975), 10000, 0.06);

        employees[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444",
                new Date(25, currentMonth, 1985), 5000, 0.04, 300);

        employees[4] = new PieceWorker("Lina", "Cohen", "555-55-5555",
                new Date(10, currentMonth, 1993), 20.0, 45); // wage * pieces

        System.out.println("Employee details and earnings:\n");

        // Process each employee polymorphically
        for (Employee emp : employees) {
            System.out.println(emp); // uses toString of dynamic type

            double salary = emp.earnings();

            // Add birthday bonus
            if (emp.getBirthDate().getMonth() == currentMonth) {
                System.out.println(">>> Happy Birthday! You get a 200 NIS bonus!");
                salary += 200;
            }

            System.out.printf("Earnings: %.2f NIS\n", salary);
            System.out.println("----------------------------------");
        }
    }
}
