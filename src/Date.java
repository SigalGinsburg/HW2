public class Date {
    int year;
    int month;
    int day;
public Date(int year, int month, int day) {
    if (year >= -3999 && year <= 3999){
        this.year = year;
    }
    else {
        this.year = 0;
    }
    if (month >= 1 && month <= 12){
        this.month = month;
    }
    else {
        this.month = 1;
    }

    if (day >= 1 && day <= 31){
        this.day = day;;
    }
    else {
        this.day = 1;
    }

}


}
