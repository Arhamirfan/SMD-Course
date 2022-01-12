package com.example.smd_aftermid.RecyclerViewExample;

public class Mobiles {
    String name,company,price;

    public Mobiles()
    {

    }
    public Mobiles(String name, String company, String price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
