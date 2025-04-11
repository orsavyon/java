/**
 * Represents a date consisting of day, month, and year.
 */
public class Date {
    private int day;
    private int month;
    private int year;

    /**
     * Constructs a Date with the given day, month, and year.
     * @param day the day of the month
     * @param month the month (1–12)
     * @param year the year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /** @return the day */
    public int getDay() { return day; }

    /** @return the month */
    public int getMonth() { return month; }

    /** @return the year */
    public int getYear() { return year; }

    /**
     * Returns a string representation of the date in the format DD/MM/YYYY.
     * @return the string representation
     */
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}