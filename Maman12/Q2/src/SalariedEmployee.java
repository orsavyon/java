/**
 * Represents an employee with a fixed weekly salary.
 */
class SalariedEmployee extends Employee {
    private double weeklySalary;

    /**
     * Constructs a SalariedEmployee.
     */
    public SalariedEmployee(String firstName, String lastName, String ssn, Date birthDate, double salary) {
        super(firstName, lastName, ssn, birthDate);
        this.weeklySalary = salary;
    }

    /** @return weekly earnings */
    public double earnings() {
        return weeklySalary;
    }

    /** @return string representation */
    public String toString() {
        return "Salaried employee: " + super.toString();
    }
}

/**
 * Represents an employee paid by the hour.
 */
class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    /**
     * Constructs an HourlyEmployee.
     */
    public HourlyEmployee(String firstName, String lastName, String ssn, Date birthDate, double wage, double hours) {
        super(firstName, lastName, ssn, birthDate);
        this.wage = wage;
        this.hours = hours;
    }

    /** @return earnings including overtime if applicable */
    public double earnings() {
        if (hours <= 40)
            return wage * hours;
        else
            return 40 * wage + (hours - 40) * wage * 1.5;
    }

    /** @return string representation */
    public String toString() {
        return "Hourly employee: " + super.toString();
    }
}

/**
 * Represents an employee paid by commission.
 */
class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    /**
     * Constructs a CommissionEmployee.
     */
    public CommissionEmployee(String firstName, String lastName, String ssn, Date birthDate,
                              double sales, double rate) {
        super(firstName, lastName, ssn, birthDate);
        this.grossSales = sales;
        this.commissionRate = rate;
    }

    /** @return commission-based earnings */
    public double earnings() {
        return grossSales * commissionRate;
    }

    /** @return string representation */
    public String toString() {
        return "Commission employee: " + super.toString();
    }
}

/**
 * Represents a commission employee with base salary.
 */
class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    /**
     * Constructs a BasePlusCommissionEmployee.
     */
    public BasePlusCommissionEmployee(String firstName, String lastName, String ssn, Date birthDate,
                                      double sales, double rate, double baseSalary) {
        super(firstName, lastName, ssn, birthDate, sales, rate);
        this.baseSalary = baseSalary;
    }

    /** @return total earnings */
    public double earnings() {
        return baseSalary + super.earnings();
    }

    /** @return string representation */
    public String toString() {
        return "Base-salaried commission employee: " + super.toString();
    }
}
