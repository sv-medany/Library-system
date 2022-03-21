/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static project2.AddLibrarianFrame.validateEmail;

/**
 *
 * @author nayro
 */
public class AddStudent extends javax.swing.JFrame {
    ArrayList<Student> Students = new ArrayList();
    public void  ReadFileStudentsAdd() throws FileNotFoundException {
        File studentFile = new File("Students.txt");
        Scanner s = null;
        try {
            s = new Scanner(studentFile); //read from the file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (s.hasNextLine()) { //testes if the file has reached its end
            String x = s.nextLine();
            String toks[] = x.split(","); //the file is csv
            Student newS = new Student(toks[0], toks[1], toks[2], toks[3], toks[4], toks[5],toks[6]); //create new librarian using the user's input omma delimitted
            Students.add(newS);
        }
    }
    public void WriteFileStudentsAdd() throws FileNotFoundException {
    File fstudent = new File("Students.txt");
    PrintWriter x = new PrintWriter(fstudent);
    for(int i =0 ; i<Students.size();i++){
        x.println(Students.get(i).getName()+","+Students.get(i).getID()+","+Students.get(i).getcontactNumber()+","+Students.get(i).getEmail()+","+Students.get(i).getPassword()+","+Students.get(i).getCity()+","+Students.get(i).getAddress());
    }
    x.close();
 }
    /**
     * Creates new form AddStudent
     */
    public AddStudent() throws FileNotFoundException {
        initComponents();
        ReadFileStudentsAdd();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idAddStudent = new javax.swing.JTextField();
        addressAddStudent = new javax.swing.JTextField();
        emailAddStudent = new javax.swing.JTextField();
        nameAddStudent = new javax.swing.JTextField();
        cityAddStudentt = new javax.swing.JTextField();
        cityAddStudent = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contactnoAddStudent = new javax.swing.JTextField();
        addAddStudent = new javax.swing.JButton();
        backAddStudent = new javax.swing.JButton();
        passwordAddStudent = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Student");

        jLabel2.setText("Password:");

        jLabel3.setText("Name:");

        jLabel4.setText("ID:");

        jLabel6.setText("Address:");

        jLabel7.setText("Email:");

        cityAddStudent.setText("City:");

        jLabel8.setText("ContactNo:");

        addAddStudent.setText("Add Student");
        addAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddStudentActionPerformed(evt);
            }
        });

        backAddStudent.setText("Back");
        backAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backAddStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordAddStudent))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityAddStudentt, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactnoAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 51, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(addAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityAddStudentt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactnoAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(backAddStudent))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddStudentActionPerformed
        String studentName = nameAddStudent.getText();
        String studentPassword = passwordAddStudent.getText();
        String studentEmail = emailAddStudent.getText();
        String studentAddress = addressAddStudent.getText();
        String studentCity = cityAddStudentt.getText();
        String studentNumber = contactnoAddStudent.getText();
        String studentID=idAddStudent.getText();
        //takes inputs from text fields
        int error = 0;
        int empty = 0;
        boolean repeated = false;
        if (studentName.isEmpty() || studentPassword.isEmpty() || studentEmail.isEmpty() || studentAddress.isEmpty() || studentCity.isEmpty() || studentNumber.isEmpty()||studentID.isEmpty()) { //ensures that user filled in all fields
            empty = 1;
            JOptionPane.showMessageDialog(this, "One of the fields is empty, please try again");
        }
        if (studentName.charAt(0) == ' ' || studentPassword.charAt(0) == ' ' || studentCity.charAt(0) == ' ' || studentAddress.charAt(0) == ' ' || studentCity.charAt(0) == ' ' || studentNumber.charAt(0) == ' ' ||studentID.charAt(0)==' ' || studentEmail.charAt(0)==' ') {
            JOptionPane.showMessageDialog(this, "the field must not start with space, please try again"); //field doesn't start with space
            error = 1;
        }
        for (int i = 0; i < studentName.length(); i++) {
            char c = studentName.charAt(i);
            if (!Character.isLetter(c)&&studentName.charAt(i)!=' ') { //the name contains letters only
                JOptionPane.showMessageDialog(this, "The name you entered is invalid, please try again");
                error = 1;
                break;
            }
        }
        for (int i = 0; i < studentCity.length(); i++) {
            char x = studentCity.charAt(i);
            if (!Character.isLetter(x)&&studentCity.charAt(i)!=' ') { //the city contains letters only
                JOptionPane.showMessageDialog(this, "The city is invalid, please try again");
                error = 1;
                break;
            }
        }
        for (int i = 0; i < studentNumber.length(); i++) {
            char d = studentNumber.charAt(i);
            if (!Character.isDigit(d)) { //the contact number contains digits only
                JOptionPane.showMessageDialog(this, "The contact number is invalid, please try again");
                error = 1;
                break;
            }

        }
        if (validateEmail(studentEmail) == 0) { //the email is invalid
            JOptionPane.showMessageDialog(this, "The email is invalid , please try again");
            error = 1;
        }
        for (int i = 0; i < studentID.length(); i++) {
                    char d = studentID.charAt(i);
                    if (!Character.isDigit(d)) {//check Librarian id is all digits 
                        JOptionPane.showMessageDialog(this, "The ID is invalid, please try again");
                        error = 1;
                        break;
                    }
             }
        
        if (error == 0){
           for(int j=0;j<Students.size();j++){
                    if(Students.get(j).getID().equals(studentID)){
                        repeated=true;
                        break;
                    }
                }
                if(!repeated){  //if the id is unique
                Student newStudent=new Student(studentName,studentID,studentNumber,studentEmail,studentPassword,studentCity,studentAddress);
                Students.add(newStudent);
                JOptionPane.showMessageDialog(this, "student added succesfully");
                    try {
                        WriteFileStudentsAdd();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                AdminSection x = new AdminSection();
                x.setVisible(true);
                this.hide();
            }
                else{
                     JOptionPane.showMessageDialog(this, "ID already exists , please try again");
                }}
    }//GEN-LAST:event_addAddStudentActionPerformed

    private void backAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backAddStudentActionPerformed
        AdminSection x = new AdminSection();
        x.setVisible(true); //return to the admin section frame
        this.hide();
    }//GEN-LAST:event_backAddStudentActionPerformed

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
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddStudent().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAddStudent;
    private javax.swing.JTextField addressAddStudent;
    private javax.swing.JButton backAddStudent;
    private javax.swing.JLabel cityAddStudent;
    private javax.swing.JTextField cityAddStudentt;
    private javax.swing.JTextField contactnoAddStudent;
    private javax.swing.JTextField emailAddStudent;
    private javax.swing.JTextField idAddStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameAddStudent;
    private javax.swing.JPasswordField passwordAddStudent;
    // End of variables declaration//GEN-END:variables
}
