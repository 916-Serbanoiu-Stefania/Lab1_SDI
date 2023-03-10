package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
/*
{
    "firstName" : "Corina",
    "lastName" : "Andreescu",
    "age": 50,
    "email" : "no",
    "gender" : "female"
    "salary" : 4000
}
 */
public class Worker {
    private final UUID id;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private String gender;

    private int salary;

    // constructor
    public Worker(@JsonProperty("id") UUID id,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("age") int age,
                  @JsonProperty("email") String email,
                  @JsonProperty("gender") String gender,
                  @JsonProperty("salary") int salary)
    {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }


    //    getters

    public UUID getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() { return salary; }

    //    setters

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Worker\n" + " -id = " + id + ", first name = '" + firstName + ", last name = '" + lastName +
                ", age = " + age +  ", email = '" + email + ", gender = " + gender + ", salary = " + salary + "\n\n";
    }

    enum Gender {
        MALE, FEMALE
    }
}
