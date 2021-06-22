package objects;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class MessageSign {
    private String sign,dateInput, message;
    private LocalDate dateStart, dateFinish;

    public MessageSign(String sign) {
        this.sign = sign;
//        this.date = date;
//        this.message = message;
    }

    public void setDateInput(String date) {
        this.dateInput = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(LocalDate dateStart, LocalDate dateFinish) {
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public String getSign() {
        return sign;
    }

    public LocalDate getStartDate(int i) {
        return dateStart.withYear(i);
    }

    public LocalDate getDateFinish(int i) {
        return dateFinish.withYear(i);
    }

    public String getMessage() {
        return message;
    }
    public List<LocalDate> getPeriod(int year){
        this.dateStart = this.dateStart.withYear(year);
        this.dateFinish = this.dateFinish.withYear(year);
        if (this.dateStart.equals(LocalDate.of(dateStart.getYear(),12,23))){
            return this.dateStart.withYear(dateStart.getYear()-1).datesUntil(this.dateFinish).toList();
        }else {
            return this.dateStart.datesUntil(this.dateFinish).toList();
        }
    }
}

