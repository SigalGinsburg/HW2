public class Date {
    int year;
    int month;
    int day;

    public Date(int year, int month, int day) {
        if (year >= -3999 && year <= 3999) { // Allowed values in the task
            this.year = year;
        } else {
            this.year = 0;
        }
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1; //In case of invalid input
        }

        if (day >= 1 && day <= 31) {
            this.day = day;

        } else {
            this.day = 1; //In case of invalid input
        }

    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
            ;
        } else {
            this.day = 1; //In case of invalid input
        }
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1; //In case of invalid input
        }
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        if (year >= -3999 && year <= 3999) { // Allowed values in the task
            this.year = year;
        } else {
            this.year = 0;
        }
    }

    public int getYear() {
        return year;
    }

    /**
     * A helper method for "equals". similar Implementation can be found in DateTime.
     * @return true for date, false for dateTime
     */

    protected boolean isDate() {
        return true;
    }
    /** This method is used to check whether an object is equal to date */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Date)) {
            return false;
        }
        Date otherDate = (Date) other;
        if (otherDate.isDate()) { // when true we know "other" is not of class DateTime
            return this.year == otherDate.year && this.month == otherDate.month &&
                    this.day == otherDate.day;
        } else {
            return false;
        }
    }
    /** A method that assigns a different hash value to each object of type 'date'
     * We ensured that the method is executed injectivly by multiplying each
     * month value by the max value of possible days,
     * and each year value by the max number of days and months,
     * This method was executed similarly to the one we saw in the tutorial.
     */
    @Override
    public int hashCode() {
        return 31 * 12 * this.year + 31 * this.month + this.day;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);

    }
}
