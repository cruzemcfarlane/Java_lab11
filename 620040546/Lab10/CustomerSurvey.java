package Lab10;

import java.awt.*;
import javax.swing.*;

public class CustomerSurvey
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Mobile Customer Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        frame.getContentPane().add(new SurveyPanel());
        
        frame.setSize(300, 250);        
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}