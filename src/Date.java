public class Date {
    int year;
    int month;
    int day;

    public Date(int year, int month, int day) {
        if (year >= -3999 && year <= 3999) {
            this.year = year;
        } else {
            this.year = 0;
        }
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }

        if (day >= 1 && day <= 31) {
            this.day = day;
            ;
        } else {
            this.day = 1;
        }

    }

    protected boolean isDate() {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Date)) {
            return false;
        }
        Date otherDate = (Date) other;
        if (otherDate.isDate()) {
            return this.year == otherDate.year && this.month == otherDate.month &&
                    this.day == otherDate.day;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 31 * 12 * this.year + 31 * this.month + this.day;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);

    }
}
