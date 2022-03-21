/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author nayro
 */
public class Student {

    private String name;
    private String ID;
    private String contactNumber;
    private String email;
    private String password;
    private String city;
    private String address;
    public Student(String name, String ID, String contactNumber, String email,String password,String city, String address ) {
        this.name = name;
        this.ID = ID;
        this.contactNumber = contactNumber;
        this.city=city;
        this.email=email;
        this.password=password;
        this.address=address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getcontactNumber() {
        return contactNumber;
    }

    public void setContactNo(String ContactNo) {
        this.contactNumber = contactNumber;
    }
}
