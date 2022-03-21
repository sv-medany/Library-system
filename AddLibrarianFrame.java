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

/**
 *
 * @author nayro
 */
public class AddLibrarianFrame extends javax.swing.JFrame {

    ArrayList<Librarian> Librarians = new ArrayList();

    public static int validate_prefix(String pre) { //function that validates the prefix of the email
        if (pre.length() < 1) {
            return 0;
        }
        if (pre.charAt(0) == '-' || pre.charAt(0) == '#' || pre.charAt(0) == '_' || pre.charAt(0) == '$' || pre.charAt(0) == '@' || pre.charAt(0) == '&' || pre.charAt(0) == ')') //the email must not start with a symbol
        {
            return 0;
        }
        for (int i = 0; i < pre.length(); i++) {
            char n = pre.charAt(i);
            if (n == ' ' || n == '$' || n == '%' || n == '+' || n == '#' || n == '!' || n == '=' || n == '*' || n == '&') {
                if (i == pre.length() - 1) {
                    return 0;
                }
                if (pre.charAt(i) == pre.charAt(i + 1)) { //the prefix must not contain 2 onsecutives symbols
                    return 0;
                }
            }

        }
        return 1;
    }

    public static int validate_domain(String dom) {
        int dcount = 0; //counter ffor the dots
        if (dom.length() < 1) {
            return 0;
        }
        if (dom.charAt(0) == '.' || dom.charAt(0) == '-' || dom.charAt(0) == '#' || dom.charAt(0) == '_' || dom.charAt(0) == '$' || dom.charAt(0) == '^' || dom.charAt(0) == '*' || dom.charAt(0) == '@' || dom.charAt(0) == '!' || dom.charAt(0) == '&' || dom.charAt(0) == '%' || dom.charAt(0) == '(' || dom.charAt(0) == ')') {
            return 0; //the domain must not start with a symbol
        }
        for (int i = 0; i < dom.length(); i++) {
            if (dom.charAt(i) == '@') {
                return 0; // the '@' is not allowed
            }
            if (dom.charAt(i) == ' ') { // the ' ' is not allowed
                return 0;
            }
            if (dom.charAt(i) == '#') { // the '#' is not allowed
                return 0;
            }
            if (dom.charAt(i) == '.') { //increments the counter of dots
                dcount++;
            }
            if (dom.charAt(0) == '.' || dom.charAt(0) == '-' || dom.charAt(0) == '#' || dom.charAt(0) == '_' || dom.charAt(0) == '$' || dom.charAt(0) == '^' || dom.charAt(0) == '*' || dom.charAt(0) == '@' || dom.charAt(0) == '!' || dom.charAt(0) == '&' || dom.charAt(0) == '%' || dom.charAt(0) == '(' || dom.charAt(0) == ')') {
                if (i == dom.length() - 1) { //must not end with signs
                    return 0;
                }
                if (dom.charAt(i) == dom.charAt(i + 1)) { // no consecutive symbols allowed
                    return 0;
                }
            }
        }
        if (dcount < 1) { //if there is no dots
            return 0;
        }
        String toks[] = dom.split("."); //to split the domain by the .
        for (int j = 0; j < toks.length; j++) {
            if (toks[j].length() < 2) {
                return 0;
            }
        }
        return 1;
    }

    public static int validateEmail(String em) {
        String prefix, domain;
        String em2 = new String(em); //clone string
        String toks[] = em2.split("@");
        if (toks[0].equals(em)) {
            return 0;
        }
        prefix = new String(toks[0]);
        if (validate_prefix(prefix) == 0) {
            return 0;
        }
        if (toks.length != 2) {
            return 0;
        }
        domain = new String(toks[1]);
        if (validate_domain(domain) == 0) {
            return 0;
        }
        return 1;
    }

    public void readLibrarianFileAdd() throws FileNotFoundException {
        File librarianFile = new File("Librarians.txt");
        Scanner s = new Scanner(librarianFile); //read from file
        while (s.hasNextLine()) { //check for end of file
            String x = s.nextLine();
            String toks[] = x.split(","); //The file is csv
            Librarian newLibrarian = new Librarian(toks[0], toks[1], toks[2], toks[3], toks[4], toks[5], toks[6]); //create new librarian with scanned fields using split
            Librarians.add(newLibrarian);
        }
    }

    public void WriteLibrarianFileAdd() throws FileNotFoundException {
        File librarianFile = new File("Librarians.txt");
        PrintWriter x = new PrintWriter(librarianFile);
        for (int i = 0; i < Librarians.size(); i++) {
            x.println(Librarians.get(i).getName() + "," + Librarians.get(i).getPassword() + "," + Librarians.get(i).getEmail() + "," + Librarians.get(i).getAddress() + "," + Librarians.get(i).getCity() + "," + Librarians.get(i).getContactNumber() + "," + Librarians.get(i).getID());
        }
        x.close();
    }

    public AddLibrarianFrame() throws FileNotFoundException {
        initComponents();
        readLibrarianFileAdd();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        emAddLib = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordAddLib = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addAddLib = new javax.swing.JButton();
        backAddLib = new javax.swing.JButton();
        contactnoAddLib = new javax.swing.JTextField();
        addressAddLib = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nameAddLib = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cityAddLib = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        idAddLib = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Name:");
        jLabel3.setName(""); // NOI18N

        emAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emAddLibActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Em.:");
        jLabel4.setName(""); // NOI18N

        passwordAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordAddLibActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Address:");
        jLabel5.setName(""); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("City:");
        jLabel6.setName(""); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Contact No:");
        jLabel7.setName(""); // NOI18N

        addAddLib.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addAddLib.setText("Add Librarian");
        addAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddLibActionPerformed(evt);
            }
        });

        backAddLib.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backAddLib.setText("Back");
        backAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backAddLibActionPerformed(evt);
            }
        });

        contactnoAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactnoAddLibActionPerformed(evt);
            }
        });

        addressAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressAddLibActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Librarian");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nameAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameAddLibActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Password:");
        jLabel2.setName(""); // NOI18N

        cityAddLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityAddLibActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("ID:");
        jLabel8.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(passwordAddLib))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(contactnoAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cityAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(addressAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(emAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(idAddLib)))
                            .addGap(66, 66, 66))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addComponent(addAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(122, 122, 122)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactnoAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addAddLib, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(backAddLib))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordAddLibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordAddLibActionPerformed

    private void addAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddLibActionPerformed
        String nameLib = nameAddLib.getText();
        String passwordLib = passwordAddLib.getText();
        String emailLib = emAddLib.getText();
        String addressLib = addressAddLib.getText();
        String cityLib = cityAddLib.getText();
        String contactNumber = contactnoAddLib.getText();//get input from user
        String idLib = idAddLib.getText();
        boolean repeated = false;
        int error = 0;
        if (nameLib.isEmpty() || passwordLib.isEmpty() || emailLib.isEmpty() || cityLib.isEmpty() || addressLib.isEmpty() || contactNumber.isEmpty() || idLib.isEmpty()) {
            error = 1;
            JOptionPane.showMessageDialog(this, "One of the fields is empty, please try again"); //empty fields
        }
        if (nameLib.charAt(0) == ' ' || passwordLib.charAt(0) == ' ' || cityLib.charAt(0) == ' ' || addressLib.charAt(0) == ' ' || cityLib.charAt(0) == ' ' || contactNumber.charAt(0) == ' ' || idLib.charAt(0) == ' ') {
            JOptionPane.showMessageDialog(this, "the field must not start with space, please try again"); //field doesn't start with space
            error = 1;
        }
        for (int i = 0; i < nameLib.length(); i++) {
            char c = nameLib.charAt(i);
            if (!Character.isLetter(c) && nameLib.charAt(i) != ' ') { //the name contains letters only
                JOptionPane.showMessageDialog(this, "The name you entered is invalid, please try again");
                error = 1;
                break;
            }
        }
        for (int i = 0; i < cityLib.length(); i++) {
            char x = cityLib.charAt(i);
            if (!Character.isLetter(x) && cityLib.charAt(i) != ' ') { //the city contains letters only
                JOptionPane.showMessageDialog(this, "The city is invalid, please try again");
                error = 1;
                break;
            }
        }
        for (int i = 0; i < contactNumber.length(); i++) {
            char d = contactNumber.charAt(i);
            if (!Character.isDigit(d)) { //the contact number contains digits only
                JOptionPane.showMessageDialog(this, "The contact number is invalid, please try again");
                error = 1;
                break;
            }

        }
        if (validateEmail(emailLib) == 0) { //the email is invalid
            JOptionPane.showMessageDialog(this, "The email is invalid , please try again");
            error = 1;
        }
        for (int i = 0; i < idLib.length(); i++) {
            char d = idLib.charAt(i);
            if (!Character.isDigit(d)) {//check Librarian id is all digits 
                JOptionPane.showMessageDialog(this, "The ID is invalid , please try again");
                error = 1;
                break;
            }
        }

        if (error == 0) {
            for (int j = 0; j < Librarians.size(); j++) {
                if (Librarians.get(j).getID().equals(idLib)) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) {
                Librarian LibNew = new Librarian(nameLib, passwordLib, emailLib, addressLib, cityLib, contactNumber, idLib);
                Librarians.add(LibNew);
                JOptionPane.showMessageDialog(this, "Librarian added succesfully");
                try {
                    WriteLibrarianFileAdd();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddLibrarianFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                AdminSection x = new AdminSection();
                x.setVisible(true);
                this.hide();
            } else {
                JOptionPane.showMessageDialog(this, "ID already exists , please try again");
            }
        }


    }//GEN-LAST:event_addAddLibActionPerformed

    private void backAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backAddLibActionPerformed
        AdminSection x = new AdminSection();
        x.setVisible(true); //return to the admin section frame
        this.hide();
    }//GEN-LAST:event_backAddLibActionPerformed

    private void contactnoAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactnoAddLibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactnoAddLibActionPerformed

    private void nameAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameAddLibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameAddLibActionPerformed

    private void addressAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressAddLibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressAddLibActionPerformed

    private void emAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emAddLibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emAddLibActionPerformed

    private void cityAddLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityAddLibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityAddLibActionPerformed

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
            java.util.logging.Logger.getLogger(AddLibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddLibrarianFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddLibrarianFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAddLib;
    private javax.swing.JTextField addressAddLib;
    private javax.swing.JButton backAddLib;
    private javax.swing.JTextField cityAddLib;
    private javax.swing.JTextField contactnoAddLib;
    private javax.swing.JTextField emAddLib;
    private javax.swing.JTextField idAddLib;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nameAddLib;
    private javax.swing.JPasswordField passwordAddLib;
    // End of variables declaration//GEN-END:variables
}
