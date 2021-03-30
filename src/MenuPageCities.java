import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPageCities extends JPanel{
    public MenuPageCities(MainFrame mainFrame) {
        setSize(500, 500);
        setLayout(null);

        JButton addcities = new JButton("ADD CITIES");
        addcities.setBounds(100, 100, 180, 40);
        add(addcities);

        JButton listcities = new JButton("LIST CITIES");
        listcities.setBounds(100, 150, 180, 40);
        add(listcities);

        JButton deletecities = new JButton("DELETE CITIES");
        deletecities.setBounds(100, 200, 180, 40);
        add(deletecities);

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
        addcities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.cities.setVisible(true);
            }
        });
        listcities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.listCities.setVisible(true);
                try {
                    mainFrame.listCities.generateTable(Admin.readToCities());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        deletecities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.deleteCities.setVisible(true);
            }
        });

    }
}
