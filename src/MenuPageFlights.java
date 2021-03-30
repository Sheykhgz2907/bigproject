import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPageFlights extends JPanel{
    public MenuPageFlights(MainFrame mainFrame) {
        setSize(500, 500);
        setLayout(null);

        JButton addflights = new JButton("ADD FLIGHTS");
        addflights.setBounds(100, 100, 180, 40);
        add(addflights);

        JButton listflights = new JButton("LIST FLIGHTS");
        listflights.setBounds(100, 150, 180, 40);
        add(listflights);

        JButton deleteflights = new JButton("DELETE FLIGHTS");
        deleteflights.setBounds(100, 200, 180, 40);
        add(deleteflights);

        JButton backbutton = new JButton("BACK TO MAIN MENU");
        backbutton.setBounds(100, 250, 180, 40);
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
                setVisible(false);
                mainFrame.flights.setVisible(true);
            }
        });
        listflights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.listFlights.setVisible(true);
                try {
                    mainFrame.listFlights.generateTable(Admin.readToFlights());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        deleteflights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.deleteFlights.setVisible(true);


            }
        });
    }
}
