public class DateTime extends Date {
    private int hour;
    private int minute;

    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        if ((hour>=0)&&(hour<=23)) {
            this.hour = hour;
        }
        else
            this.hour=0;

        if ((minute>=0)&&(minute<=59)) {
            this.minute = minute;
        }
        else
            this.minute=0;
    }

    public int getHour() {
        return this.hour;
    }
    public void setHour(int hour) {
        if ((hour>=0)&&(hour<=23)) {
            this.hour = hour;
        }
        else
            this.hour =0;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        if ((minute>=0)&&(minute<=59)) {
            this.minute = minute;
        }
        else
            this.minute =0;
    }
    /** This method is used to check whether an object is equal to DateTime by comparing all its args*/

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DateTime)) {
            return false;
        }
        DateTime otherDateTime = (DateTime) other;
        boolean isSameYear = (this.year==otherDateTime.year);
        boolean isSameMonth = (this.month==otherDateTime.month);
        boolean isSameDay = (this.day==otherDateTime.day);
        boolean isSameHour = (this.hour == otherDateTime.hour);
        boolean isSameMinute = (this.minute == otherDateTime.minute);
        return  isSameYear&&isSameMonth&&isSameDay&&isSameHour&&isSameMinute;
    }
    /**
     * A helper method for "equals". similar Implementation can be found in Date.
     * @return true for date, false for dateTime
     */
    @Override
    public boolean isDate() {
            return false;
    }

    /** A method that assigns a different hash value to each object of type 'DateTime'
     * We ensured that the method is executed injectivly by:
     * multiplying each hour by 60(max number of minutes per hour)
     * multiplying each day by 24(max number of hours per day) *60
     * multiplying each month by 31(max number of days per month) *60 *24
     * and multiplying each year by 12(max number of months per year) *60 *24 *31
     * This method was executed similarly to the one we saw in the tutorial.
     */

    @Override
    public int hashCode (){
        int dateHashCode =super.hashCode();
        return 60*24*dateHashCode;
    }

    @Override
    public String toString(){
        String firstPartString= super.toString();
        String secondPartString=String.format("%02d:%02d", this.hour, this.minute);
        return firstPartString+" "+secondPartString;
    }

}