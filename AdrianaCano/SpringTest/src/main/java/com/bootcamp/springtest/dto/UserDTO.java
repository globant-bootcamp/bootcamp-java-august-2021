package com.bootcamp.springtest.dto;

public class UserDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double bootcampEvaluation;
    private String attitude;
    private Boolean isApproved;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getBootcampEvaluation() {
        return bootcampEvaluation;
    }

    public void setBootcampEvaluation(Double bootcampEvaluation) {
        this.bootcampEvaluation = bootcampEvaluation;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}
