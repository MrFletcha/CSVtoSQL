package com.spartaglobal.jf.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO {

    //Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary

    String empID;

    public EmployeeDTO(String empID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String eMail, String dob, String dateJoining, String salary) {
        this.empID = empID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.eMail = eMail;
        setDob(dob);
        setDateJoining(dateJoining);
        setSalary(salary);
    }

    String namePrefix;
    String firstName;
    String middleInitial;
    String lastName;
    String gender;
    String eMail;
    LocalDate dob;
    LocalDate dateJoining;
    Integer salary;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public LocalDate getDateJoining() {
        return dateJoining;
    }

    public void setDateJoining(String dateJoining) {
        this.dateJoining = LocalDate.parse(dateJoining, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = Integer.valueOf(salary);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empID='" + empID + '\'' +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", eMail='" + eMail + '\'' +
                ", dob=" + dob +
                ", dateJoining=" + dateJoining +
                ", salary=" + salary +
                '}';
    }
}
