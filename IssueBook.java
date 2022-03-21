/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nayro
 */
public class IssueBook extends javax.swing.JFrame {

    ArrayList<Book> Books = new ArrayList();
    ArrayList<IssuedBook> IssuedBooks = new ArrayList();
    ArrayList<Student> Students = new ArrayList();

    public void readFileStudents() throws FileNotFoundException {
        File fStudent = new File("Students.txt");
        Scanner s = null;
        try {
            s = new Scanner(fStudent); //read from the file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (s.hasNextLine()) { //checks file did not reach its end
            String x = s.nextLine();
            String toks[] = x.split(","); //file is csv
            Student newS = new Student(toks[0], toks[1], toks[2], toks[3], toks[4], toks[5], toks[6]); //create new librarian 
            Students.add(newS);
        }
    }

    public void readFileIssuedBooks() throws FileNotFoundException {
        File bookFile = new File("IssuedBooks.txt");
        Scanner s = new Scanner(bookFile); //read from file
        while (s.hasNextLine()) { //checks file did not reach its end
            String x = s.nextLine();
            String toks[] = x.split(","); //file is csv
            IssuedBook newIssuedBook = new IssuedBook(toks[0], toks[1], toks[2], toks[3], toks[4]); //create new librarian with scanned fields using split
            IssuedBooks.add(newIssuedBook);
        }
    }

    public void readFileBooks() throws FileNotFoundException {
        File bookFile = new File("Books.txt");
        Scanner s = new Scanner(bookFile); //read from the file
        while (s.hasNextLine()) { ///checks file did not reach its end
            String x = s.nextLine();
            String toks[] = x.split(","); //file is csv
            int quantity = parseInt(toks[5]);
            int ID = parseInt(toks[0]);
            int issueCounter = parseInt(toks[6]);
            Book newBook = new Book(ID, toks[1], toks[2], toks[3], toks[4], quantity, issueCounter, toks[7]); //create new librarian with scanned fields using split
            Books.add(newBook);
        }
    }

    public void WriteBookFileAdd() throws FileNotFoundException {
        File flibrarian = new File("Books.txt");
        PrintWriter x = new PrintWriter(flibrarian);
        for (int i = 0; i < Books.size(); i++) {
            x.println(Books.get(i).getID() + "," + Books.get(i).getCallNo() + "," + Books.get(i).getName() + "," + Books.get(i).getAuthor() + "," + Books.get(i).getPublisher() + "," + Books.get(i).getQuantity() + "," + Books.get(i).getCounterIssued() + "," + Books.get(i).getAddedDate());
        }
        x.close();
    }

    public void WriteBookFileIssue() throws FileNotFoundException {
        File nlibrarian = new File("IssuedBooks.txt");
        PrintWriter x = new PrintWriter(nlibrarian);
        for (int i = 0; i < IssuedBooks.size(); i++) {
            x.println(IssuedBooks.get(i).getBookCallNo() + "," + IssuedBooks.get(i).getStudentName() + "," + IssuedBooks.get(i).getStudentID() + "," + IssuedBooks.get(i).getStudentContactNo() + "," + IssuedBooks.get(i).getIssuedate() + "," + IssuedBooks.get(i).getReturnDate());
        }
        x.close();
    }

    /**
     * Creates new form IssueBook
     */
    public IssueBook() throws FileNotFoundException {
        initComponents();
        readFileBooks();
        readFileIssuedBooks();
        readFileStudents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        issueIssueBook = new javax.swing.JButton();
        backIssueBook = new javax.swing.JButton();
        studentContactnoIssue = new javax.swing.JTextField();
        studentNameIssue = new javax.swing.JTextField();
        bookCallnoIssue = new javax.swing.JTextField();
        studentIdIssue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Issue Book");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Book Callno.:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Student Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Student ID:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Student contact Number:");

        issueIssueBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        issueIssueBook.setText("Issue Book");
        issueIssueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueIssueBookActionPerformed(evt);
            }
        });

        backIssueBook.setText("Back");
        backIssueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backIssueBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backIssueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(studentIdIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookCallnoIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(studentNameIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(issueIssueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentContactnoIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 110, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookCallnoIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentIdIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentNameIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentContactnoIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(issueIssueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(backIssueBook)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void issueIssueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueIssueBookActionPerformed
        String id = studentIdIssue.getText();
        String callNo = bookCallnoIssue.getText();
        String studentName = studentNameIssue.getText();
        String studentNumber = studentContactnoIssue.getText(); //to get inputs from user
        int counterIssued = 0;
        DateFormat zx = new SimpleDateFormat("dd-MM-YYYY");
        Date date = new Date();
        String issueDate = zx.format(date);
        boolean found = false;
        boolean studentFound = false;
        int empty = 0; //checks that no empty fields
        int error = 0; // checks for errors
        if (id.isEmpty() || issueDate.isEmpty() || callNo.isEmpty() || studentName.isEmpty() || studentNumber.isEmpty()) { //checks that there is no empty fields
            empty = 1;
            JOptionPane.showMessageDialog(this, "You did not fill in all the fields, please try again");
        }
        if (id.charAt(0) == ' ' || issueDate.charAt(0) == ' ' || callNo.charAt(0) == ' ' || studentName.charAt(0) == ' ' || studentNumber.charAt(0) == ' ') { //checks no field begins with a space
            JOptionPane.showMessageDialog(this, "the field must not start with space, please try again");
            empty = 0;
        }
        if (empty == 0) { //there are no empty fields
            for (int i = 0; i < studentName.length(); i++) {
                char c = studentName.charAt(i);
                if (!Character.isLetter(c)) { //check the name contains only letters
                    JOptionPane.showMessageDialog(this, "The book name is invalid, please try again");
                    error = 1;
                    break;
                }
            }
            for (int i = 0; i < id.length(); i++) {
                char d = id.charAt(i);
                if (!Character.isDigit(d)) { //check the id contains only digits
                    JOptionPane.showMessageDialog(this, "The ID is invalid, please try again");
                    error = 1;
                    break;
                }

            }
            if (studentNumber.length() >= 10) { //The contact number is made of at least 10 digits
                for (int i = 0; i < studentNumber.length(); i++) {
                    char t = studentNumber.charAt(i);

                    if (!Character.isDigit(t)) {//check the student number is a made of digits only
                        JOptionPane.showMessageDialog(this, "The student number is invalid, please try again");
                        error = 1;
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "the Contact number is invalid, please try again");
                error = 1;

            }
            if (error == 0 && empty == 0) {
                double y = Double.parseDouble(studentNumber);
                int x = Integer.parseInt(id);
                //converting them to integers and doubles to test for incorrect input
                if (x < 0) { //id can not be neagtive
                    JOptionPane.showMessageDialog(this, "Invalid ID, please try again");
                } else if (y < 0) { //number must be positivs
                    JOptionPane.showMessageDialog(this, "Invalid Student number , please try again");
                } else {
                    for (int i = 0; i < Students.size(); i++) {
                        if (Students.get(i).getID().equals(id) && Students.get(i).getName().equals(studentName)) {
                            studentFound = true;
                            break;
                        }
                    }
                    if (studentFound) {
                        for (int j = 0; j < IssuedBooks.size(); j++) {
                            if (IssuedBooks.get(j).getStudentID().equals(id)) {
                                counterIssued++;
                            }
                        }
                        if (counterIssued < 3) {
                            for (int i = 0; i < Books.size(); i++) {
                                if (Books.get(i).getCallNo().equals(callNo)) {
                                    found = true;
                                    if (Books.get(i).getQuantity() > 0) {
                                        IssuedBook NewIB = new IssuedBook(callNo, studentName, id, studentNumber, issueDate);
                                        IssuedBooks.add(NewIB);
                                        Books.get(i).decrementQuantity(Books.get(i).getQuantity());
                                        Books.get(i).setCounterIssued(Books.get(i).getCounterIssued() + 1);
                                        JOptionPane.showMessageDialog(this, "Book issued successfully");
                                        try {
                                            WriteBookFileAdd();
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        try {
                                            WriteBookFileIssue();
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                        LibrarianSection xy = new LibrarianSection();
                                        xy.setVisible(true);
                                        this.hide();
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(this, "All the copies of this book are issued");
                                        break;
                                    }
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(this, "you reached maximum amount of issued books");
                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_issueIssueBookActionPerformed

    private void backIssueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backIssueBookActionPerformed
        LibrarianSection x = new LibrarianSection();
        x.setVisible(true); //return to the librarian section
        this.hide();
    }//GEN-LAST:event_backIssueBookActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IssueBook().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backIssueBook;
    private javax.swing.JTextField bookCallnoIssue;
    private javax.swing.JButton issueIssueBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField studentContactnoIssue;
    private javax.swing.JTextField studentIdIssue;
    private javax.swing.JTextField studentNameIssue;
    // End of variables declaration//GEN-END:variables
}