import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddFlights extends JPanel {
    public AddFlights(MainFrame mainFrame){
        setSize(550,600);
        setLayout(null);

        JLabel airid = new JLabel("AirCraft ID");
        airid.setBounds(100,100,100,40);
        add(airid);

        JTextField airidtext = new JTextField();
        airidtext.setBounds(200,100,100,40);
        add(airidtext);

        JLabel dcityid = new JLabel("Departure city ID");
        dcityid.setBounds(100,150,100,40);
        add(dcityid);

        JTextField dcitytext = new JTextField();
        dcitytext.setBounds(200,150,100,40);
        add(dcitytext);

        JLabel acityid = new JLabel("Arrival city ID");
        acityid.setBounds(100,200,100,40);
        add(acityid);

        JTextField acitytext = new JTextField();
        acitytext.setBounds(200,200,100,40);
        add(acitytext);

        JLabel departuretime = new JLabel("Departure time");
        departuretime.setBounds(100,250,100,40);
        add(departuretime);

        JTextField dtimetext = new JTextField();
        dtimetext.setBounds(200,250,100,40);
        add(dtimetext);

        JLabel economprice = new JLabel("Econom place");
        economprice.setBounds(100,300,100,40);
        add(economprice);

        JTextField epricetext = new JTextField();
        epricetext.setBounds(200,300,100,40);
        add(epricetext);

        JLabel businessplace = new JLabel("Business place");
        businessplace.setBounds(100,350,100,40);
        add(businessplace);

        JTextField bplacetext = new JTextField();
        bplacetext.setBounds(200,350,100,40);
        add(bplacetext);

        JButton addflights = new JButton("ADD FLIGHTS");
        addflights.setBounds(100,400,100,40);
        add(addflights);

        JButton backbutton = new JButton("Back to Menu");
        backbutton.setBounds(100,450,100,40);
        add(backbutton);


        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.menuPage.setVisible(true);
            }
        });

        addflights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int airid = Integer.parseInt(airidtext.getText());
            airidtext.setText("");

            int dcity = Integer.parseInt(dcitytext.getText());
            dcitytext.setText("");

            int acity= Integer.parseInt(acitytext.getText());
            acitytext.setText("");

            String dtimetext1 = dtimetext.getText();
                dtimetext.setText("");

            int economtext = Integer.parseInt(epricetext.getText());
            epricetext.setText("");

            int businesstext = Integer.parseInt(bplacetext.getText());
            bplacetext.setText("");

            Flights flights = new Flights(null,airid,dcity,acity,dtimetext1,economtext,businesstext);
                try {
                    Admin.savetoFlights(flights);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
