/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.wp.containers;

import java.awt.BorderLayout;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.WindowConstants;

/**
 *
 * @author lendle
 */
public class SplashScreenSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        JFrame frame=new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //init the JWindow, add component to its content pane
        JWindow window=new JWindow();
        File file = new File("snoopy.gif");
        ImageIcon icon=new ImageIcon(file.toURI().toURL());
        window.setLayout(new BorderLayout());
        window.getContentPane().add(new JLabel(icon));
        window.setSize(500, 500);
        window.setLocationRelativeTo(null);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        window.getContentPane().add(progressBar, "South");
        //////////////////////////////////////////////////////
        
        Thread t=new Thread(){
            public void run(){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SplashScreenSample.class.getName()).log(Level.SEVERE, null, ex);
                }
                window.setVisible(false);
                frame.setVisible(true);
            }
        };
        t.start();
        window.setVisible(true);
    }
    
}
