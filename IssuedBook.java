/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import static java.lang.Integer.parseInt;

/**
 *
 * @author nayro
 */
public class IssuedBook {

    private String bookCallNo;
    private String studentName;
    private String StudentID;
    private String studentContactNo;
    private String issuedate;
    private String returnDate;

    public String getBookCallNo() {
        return bookCallNo;
    }

    public void setBookCallNo(String bookCallNo) {
        this.bookCallNo = bookCallNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentContactNo() {
        return studentContactNo;
    }

    public void setStudentContactNo(String studentContactNo) {
        this.studentContactNo = studentContactNo;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    

    public IssuedBook(String bookCallNo, String studentName, String ID, String studentContactNo, String issuedate) {
        this.bookCallNo = bookCallNo;
        this.studentName = studentName;
        this.StudentID = ID;
        this.studentContactNo = studentContactNo;
        this.issuedate = issuedate;
        SetreturnDate(issuedate);
    }

    public String getIssueDate() {
        return issuedate;
    }

    public void setIssueDate(String issuedate) {
        this.issuedate = issuedate;
    }

    public void SetreturnDate(String IssuedDate) {
        String toks[] = IssuedDate.split("-");
        int day = parseInt(toks[0]);
        int month = parseInt(toks[1]);
        int year = parseInt(toks[2]);
        if (month == 12) {
            month = 2;
            year++;
            this.returnDate = "" + day + "-" + month + "-" + year;
        } else if (month == 1 && day >= 29) {
            month += 3;
            day -= 28;
            this.returnDate = "" + day + "-" + month + "-" + year;
        } else if (month % 2 == 1 && day == 31) {
            month += 3;
            day = 1;
            this.returnDate = "" + day + "-" + month + "-" + year;

        } else {
            month+=2;
            this.returnDate = "" + day + "-" + month + "-" + year;
        }
    }

    public String getissuedate() {
        return issuedate;
    }

    public String getreturnDate() {
        return returnDate;
    }

}
