package packageInOut;

import java.io.Serializable;

public class Contact implements Serializable {
    String name;
    String secondName;
    String number;
    int year;

    public Contact(String name, String secondName, String number, int year) {
        this.name = name;
        this.secondName = secondName;
        this.number = number;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
