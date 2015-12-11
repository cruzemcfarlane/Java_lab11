package Lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SurveyPanel extends JPanel
{
    private JLabel name, msg1, msg2, area, count1, count2, location;
    private JPanel buttonPanel;
    private JTextField fullName;
    private JRadioButton kingston, portmore, spain;
    private JButton lime, digi, reset;
    private int limeNum = 0, digiNum = 0;
        
    public SurveyPanel()
    {
        name = new JLabel("Name: ");
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setPreferredSize(new Dimension(300, 250));
        
        area = new JLabel("Survey Area: ");
        
        msg1 = new JLabel("Click the button below indicating the service");
        msg2 = new JLabel("provider of EACH person questioned            ");
        
        count1 = new JLabel("No. of LIME customers              :               ");
        count2 = new JLabel("No. of DIGICEL customers         :                          ");
                      
        fullName = new JTextField(20);
        
        kingston = new JRadioButton("Kingston", false);
        portmore = new JRadioButton("Portmore", false);
        spain = new JRadioButton("Spanish Town", false);
        
        ButtonGroup group = new ButtonGroup();
        group.add(kingston);
        group.add(portmore);
        group.add(spain);
        
        location = new JLabel();
        
        AreaListener listen = new AreaListener();
        kingston.addActionListener(listen);
        portmore.addActionListener(listen);
        spain.addActionListener(listen);
        
        lime = new JButton("LIME");
        digi = new JButton("DIGICEL");
        reset = new JButton("RESET");
        
        ProviderListener listener = new ProviderListener();
        lime.addActionListener(listener);
        digi.addActionListener(listener);
        reset.addActionListener(listener);
        
        buttonPanel = new JPanel();
        buttonPanel.add(kingston);
        buttonPanel.add(portmore);
        buttonPanel.add(spain);   
        
        add(name);
        add(fullName);
        add(area);
        add(buttonPanel);        
        add(msg1);
        add(msg2);
        add(lime);
        add(digi);
        add(reset);
        add(count1);
        add(count2);
        add(location);
                
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));        
    }
    
    private class AreaListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            
            if(source == kingston)
            {
                location.setText("Kingston");
            }
            
            else if(source == portmore)
            {
                location.setText("Portmore");
            }
            
            else if(source == spain)
            {
                location.setText("Spanish Town");
            }
        }
    }
    
    private class ProviderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            
            if(source == lime)
            {
                limeNum++;
                count1.setText("No. of LIME customers               : <<" + limeNum + ">>         ");
            }
            
            else if(source == digi)
            {
                digiNum++;
                count2.setText("No. of DIGICEL customers         : <<" + digiNum + ">>              ");
            }
            
            else if(source == reset)
            {
                limeNum = 0;
                digiNum = 0;
                
                count1.setText("No. of LIME customers               : <<" + limeNum + ">>                ");
                count2.setText("No. of DIGICEL customers         : <<" + digiNum + ">>               ");
            }
        }
    }
}