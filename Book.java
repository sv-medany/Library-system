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
public class Book {
    private int ID;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private String addedDate;
    private int quantity;
    private int counterIssued;

    public Book() {
    }

    public Book(int ID,String callNo, String name, String author, String publisher, int quantity, int counterIssued, String addedDate) {
        this.ID=ID;
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.counterIssued =counterIssued;
        this.addedDate=addedDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public int getID() {
        return ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCounterIssued() {
        return counterIssued;
    }

    public void setCounterIssued(int counterIssued) {
        this.counterIssued = counterIssued;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }
    public void decrementQuantity(int quantity) {
        this.quantity--;
    }
}
