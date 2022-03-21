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
public class ReturnBook extends javax.swing.JFrame {

    ArrayList<IssuedBook> IssuedBooks = new ArrayList();
    ArrayList<Book> Books = new ArrayList();

    public boolean isPenalty(String returnDate, String currentDate) {
        String toks[] = returnDate.split("-");
        String tok[] = currentDate.split("-");  //splitting the components of the date
        int returnDay = Integer.parseInt(toks[0]);
        int returnMonth = Integer.parseInt(toks[1]);
        int returnYear = Integer.parseInt(toks[2]);
        int currentDay = Integer.parseInt(tok[0]);   //convert date string to integer
        int currentMonth = Integer.parseInt(tok[1]);
        int currentYear = Integer.parseInt(tok[2]);
        if (returnYear < currentYear) //checks if the student returned the book late
        {
            return true;
        } else if (returnMonth < currentMonth) {
            return true;
        } else if (returnDay < currentDay) {
            return true;
        } else {
            return false;
        }
    }

    public void readFileIssuedBooks() throws FileNotFoundException {
        File bookFile = new File("IssuedBooks.txt");
        Scanner s = new Scanner(bookFile); //read from file
        while (s.hasNextLine()) { //checks file did not reach end
            String x = s.nextLine();
            String toks[] = x.split(","); //file is csv
            IssuedBook newIssuedBook = new IssuedBook(toks[0], toks[1], toks[2], toks[3], toks[4]); //create new librarian 
            IssuedBooks.add(newIssuedBook);
        }
    }

    public void readFileBooks() throws FileNotFoundException {
        File fBook = new File("Books.txt");
        Scanner s = new Scanner(fBook); //read from file
        while (s.hasNextLine()) { //checks file did not exist
            String x = s.nextLine();
            String toks[] = x.split(","); //file is csv
            int quan = parseInt(toks[5]);
            int ID = parseInt(toks[0]);
            int IssueCount = parseInt(toks[6]);
            Book newB = new Book(ID, toks[1], toks[2], toks[3], toks[4], quan, IssueCount, toks[7]); //create new librarian with scanned fields using split
            Books.add(newB);
        }
    }

    public void writeFileBooks() throws FileNotFoundException {
        File flibrarian = new File("Books.txt");     //update in books file
        PrintWriter x = new PrintWriter(flibrarian);
        for (int i = 0; i < Books.size(); i++) {
            x.println(Books.get(i).getID() + "," + Books.get(i).getCallNo() + "," + Books.get(i).getName() + "," + Books.get(i).getAuthor() + "," + Books.get(i).getPublisher() + "," + Books.get(i).getquantity() + "," + Books.get(i).getCounterIssued() + "," + Books.get(i).getAddedDate());
        }
        x.close();
    }

    public void writeFileIssuedBooks() throws FileNotFoundException {
        File nlibrarian = new File("IssuedBooks.txt");     //update in issued books file
        PrintWriter x = new PrintWriter(nlibrarian);
        for (int i = 0; i < IssuedBooks.size(); i++) {
            x.println(IssuedBooks.get(i).getBookCallNo() + "," + IssuedBooks.get(i).getStudentName() + "," + IssuedBooks.get(i).getStudentID() + "," + IssuedBooks.get(i).getStudentContactNo() + "," + IssuedBooks.get(i).getIssueDate() + "," + IssuedBooks.get(i).getReturnDate());
        }
        x.close();
    }

    public ReturnBook() throws FileNotFoundException {
        initComponents();
        readFileBooks();       //read data from library books and issued books file
        readFileIssuedBooks();
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
        bookCalllnoReturn = new javax.swing.JTextField();
        studentIdReturn = new javax.swing.JPasswordField();
        returnReturn = new javax.swing.JButton();
        backReturn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Return Book");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Book Callno.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Student id:");

        returnReturn.setText("Return Book");
        returnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnReturnActionPerformed(evt);
            }
        });

        backReturn.setText("Back");
        backReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backReturnActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Note: Check the book properly!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(returnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookCalllnoReturn)
                                    .addComponent(studentIdReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookCalllnoReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(studentIdReturn))
                .addGap(30, 30, 30)
                .addComponent(returnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backReturn)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backReturnActionPerformed
        LibrarianSection x = new LibrarianSection();
        x.setVisible(true); //return to library section frame
        this.hide();
    }//GEN-LAST:event_backReturnActionPerformed

    private void returnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnReturnActionPerformed
        String bookCallno = bookCalllnoReturn.getText();
        String studentId = studentIdReturn.getText(); //to get input from user
        int empty = 0; //checks if there are empty fields
        int error = 0; // checks if there is an error in the input
        boolean found = false;
        int indexr = 0;
        DateFormat xr = new SimpleDateFormat("dd-MM-YYYY");
        Date date = new Date();
        String currentDate = xr.format(date);
        if (studentId.isEmpty() || bookCallno.isEmpty()) { //checks there is no empty fields
            empty = 1;
            JOptionPane.showMessageDialog(this, "You did not fill in all the fields, please try again");
        }
        if (empty == 0) { //if they are not empty
            if (studentId.charAt(0) == ' ' || bookCallno.charAt(0) == ' ') { //checks that they don't start with space
                JOptionPane.showMessageDialog(this, "the input must not start with space, please try again");
                empty = 1;
            }
            if (empty == 0) { //if they are not empty
                for (int i = 0; i < studentId.length(); i++) {
                    char d = studentId.charAt(i);
                    if (!Character.isDigit(d)) { //check id is all digits
                        JOptionPane.showMessageDialog(this, "Invalid ID, please try again");
                        error = 1;
                        break;
                    }
                }
            }
            if (error == 0 && empty == 0) { //if not empty and no errors detected
                int x = Integer.parseInt(studentId);
                if (x < 0) { //ID must be positive
                    JOptionPane.showMessageDialog(this, "Invalid ID, please try again");
                } else {
                    for (int i = 0; i < IssuedBooks.size(); i++) {
                        if (IssuedBooks.get(i).getBookCallNo().equals(bookCallno) && IssuedBooks.get(i).getStudentID().equals(studentId)) {   //check if the student issued this particular book

                            found = true;
                            indexr = i;
                            break;
                        }
                    }

                    if (found) {
                        for (int i = 0; i < Books.size(); i++) {
                            if (Books.get(i).getCallNo().equals(bookCallno)) {
                                Books.get(i).setQuantity(Books.get(i).getQuantity() + 1);
                                Books.get(i).setCounterIssued(Books.get(i).getCounterIssued() - 1);
                                break;
                            }
                        }

                        if (isPenalty(IssuedBooks.get(indexr).getReturnDate(), currentDate)) {
                            JOptionPane.showMessageDialog(this, "Book returned successfully,a penalty will be applied because of late return ");
                        } else {
                            JOptionPane.showMessageDialog(this, "Book returned successfully!");
                        }
                        IssuedBooks.remove(indexr);
                        try {
                            writeFileIssuedBooks();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            writeFileBooks();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);

                        }
                        LibrarianSection z = new LibrarianSection();
                        z.setVisible(true);
                        this.hide();
                    } else {
                        JOptionPane.showMessageDialog(this, "Student did not issue this book");
                    }
                }
            }
        }


    }//GEN-LAST:event_returnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReturnBook().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backReturn;
    private javax.swing.JTextField bookCalllnoReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton returnReturn;
    private javax.swing.JPasswordField studentIdReturn;
    // End of variables declaration//GEN-END:variables
}