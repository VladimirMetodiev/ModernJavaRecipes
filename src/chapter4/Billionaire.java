package chapter4;

import java.util.Objects;

public class Billionaire {
    private String name;
    private String surname;
    private double netWorth;
    private int age;
    private String country;
    private String source;
    private String industry;

    public Billionaire() {
    }

    public Billionaire(String name, String surname, double netWorth) {
        this.name = name;
        this.surname = surname;
        this.netWorth = netWorth;
    }

    public Billionaire(String name, String surname, double netWorth, int age) {
        this.name = name;
        this.surname = surname;
        this.netWorth = netWorth;
        this.age = age;
    }

    public Billionaire(String name, String surname, double netWorth, int age, String country) {
        this.name = name;
        this.surname = surname;
        this.netWorth = netWorth;
        this.age = age;
        this.country = country;
    }

    public Billionaire(String name, String surname, double netWorth, int age, String country, String source, String industry) {
        this.name = name;
        this.surname = surname;
        this.netWorth = netWorth;
        this.age = age;
        this.country = country;
        this.source = source;
        this.industry = industry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Billionaire that = (Billionaire) obj;
        return Double.compare(that.netWorth, netWorth) == 0 &&
                age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(country, that.country) &&
                Objects.equals(source, that.source) &&
                Objects.equals(industry, that.industry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, netWorth, age, country, source, industry);
    }
}
