/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author TESASET
 */
import Model.*;
import View.LoginForm;
import View.HomePage;
import View.SignUpPegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sun.security.pkcs11.Secmod;

public class ControllerLoginForm implements ActionListener{

    private LoginForm loginFrame;
    private Aplikasi apps;

    public ControllerLoginForm() {
        new Aplikasi();
        loginFrame = new LoginForm();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        loginFrame.setActionListener(this); //add action listener utk semua button
    }
    
    private void btnDaftarActionPerformed (ActionEvent ae) {
        loginFrame.dispose();
//        new ControllerSignUp();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginFrame.getBtnDaftar())) {
            btnDaftarActionPerformed(e);
        }
        if (e.getSource().equals(loginFrame.getBtnLogin())) {
            String email = loginFrame.getTfEmail().getText();
            String password = loginFrame.getTfPassword().getText();
            
            try {
                Petugas p = apps.getPetugasByEmail(email);
                if (p==null) {
                    loginFrame.showMessage("Email salah");
                } else {
                     if (p.getPass().equals(password)) {
                         loginFrame.showMessage("Password salah");
                     } else {
                            new ControllerSignUp();
                            loginFrame.dispose();
                            loginFrame.showMessage("Udah masuk");
                     }
                }
                
            } catch (Exception ae) {
                throw new IllegalArgumentException("Terjadi kesalahan saat login");
            }
        }
            
//            Petugas p = apps.getPetugasByEmail(email);
//            if (p==null) {
//               throw new IllegalArgumentException("Email tidak ditemukan");
//            } else {
//                if (p.getPass() != password) {
//                    throw new IllegalArgumentException("Password salah");
//                } else {
//                    HomePage home = new HomePage();
//                    home.setVisible(true);
//                    loginFrame.dispose();
//                }
//            }
        
    }
       /**
        * kalo pencet daftar bakal langsung pindah ke sign up
        * , udah di atur d viewnya
        */
    
    
}
