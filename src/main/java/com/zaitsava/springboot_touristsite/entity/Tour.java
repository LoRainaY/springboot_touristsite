package com.zaitsava.springboot_touristsite.entity;

import javax.persistence.*;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private int id;
    @Column(name = "image", nullable = true)
    private String image;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @Column(name = "price")
    private double price;
    @Column(name = "first_day")
    private String firstDayDescription;
    @Column(name = "second_day")
    private String secondDayDescription;
    @Column(name = "third_day")
    private String thirdDayDescription;
    @Column(name = "fourth_day")
    private String fourthDayDescription;
    @Column(name="fifth_day")
    private  String fifthDayDescription;
    @Column(name = "included_in_price")
    private String includeInPrice;
    @Column(name = "additionally")
    private String additionally;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFirstDayDescription() {
        return firstDayDescription;
    }

    public void setFirstDayDescription(String firstDayDescription) {
        this.firstDayDescription = firstDayDescription;
    }

    public String getSecondDayDescription() {
        return secondDayDescription;
    }

    public void setSecondDayDescription(String secondDayDescription) {
        this.secondDayDescription = secondDayDescription;
    }

    public String getThirdDayDescription() {
        return thirdDayDescription;
    }

    public void setThirdDayDescription(String thirdDayDescription) {
        this.thirdDayDescription = thirdDayDescription;
    }

    public String getFourthDayDescription() {
        return fourthDayDescription;
    }

    public void setFourthDayDescription(String fourthDayDescription) {
        this.fourthDayDescription = fourthDayDescription;
    }

    public String getFifthDayDescription() {
        return fifthDayDescription;
    }

    public void setFifthDayDescription(String fifthDayDescription) {
        this.fifthDayDescription = fifthDayDescription;
    }

    public String getIncludeInPrice() {
        return includeInPrice;
    }

    public void setIncludeInPrice(String includeInPrice) {
        this.includeInPrice = includeInPrice;
    }

    public String getAdditionally() {
        return additionally;
    }

    public void setAdditionally(String additionally) {
        this.additionally = additionally;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", price=" + price +
                ", firstDayDescription='" + firstDayDescription + '\'' +
                ", secondDayDescription='" + secondDayDescription + '\'' +
                ", thirdDayDescription='" + thirdDayDescription + '\'' +
                ", fourthDayDescription='" + fourthDayDescription + '\'' +
                ", fifthDayDescription='" + fifthDayDescription + '\'' +
                ", includeInPrice='" + includeInPrice + '\'' +
                ", additionally='" + additionally + '\'' +
                '}';
    }

    @Transient
    public String getImagePath() {
        if (image == null || id == 0) {
            return null;
        }
        return "/tour-image/" + id + "/" + image;
    }
}
