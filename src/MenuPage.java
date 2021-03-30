import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JPanel {
    public MenuPage(MainFrame mainFrame){
        setSize(600,600);
        setLayout(null);

        JButton addaircrafts = new JButton("AIRCRAFTS");
        addaircrafts.setBounds(100,100,200,40);
        add(addaircrafts);

        JButton addcities = new JButton("CITIES");
        addcities.setBounds(100,150,200,40);
        add(addcities);

        JButton addflights = new JButton("FLIGHTS");
        addflights.setBounds(100,200,200,40);
        add(addflights);


        JButton exit = new JButton("EXIT");
        exit.setBounds(100,250,200,40);
        add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addaircrafts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.menuPageAircrafts.setVisible(true);
            }
        });
        addcities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.menuPageCities.setVisible(true);
            }
        });
        addflights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.menuPageFlights.setVisible(true);
            }
        });


    }
}
