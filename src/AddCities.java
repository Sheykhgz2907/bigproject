import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddCities extends JPanel {
    public AddCities(MainFrame mainFrame){
        setSize(550,600);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100,100,100,40);
        add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(200,100,100,40);
        add(nameTextField);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(100,150,100,40);
        add(countryLabel);

        JTextField countryTextField = new JTextField();
        countryTextField.setBounds(200,150,100,40);
        add(countryTextField);

        JLabel shortnameLabel = new JLabel("Short name:");
        shortnameLabel.setBounds(100,200,100,40);
        add(shortnameLabel);

        JTextField shortnameTextField = new JTextField();
        shortnameTextField.setBounds(200,200,100,40);
        add(shortnameTextField);

        JButton addCities = new JButton("ADD CITIES");
        addCities.setBounds(100,300,200,40);
        add(addCities);

        JButton backbutton = new JButton("BACK TO MENU");
        backbutton.setBounds(100,350,200,40);
        add(backbutton);

        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.menuPage.setVisible(true);
            }
        });
        addCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String name = nameTextField.getText();
            nameTextField.setText("");

            String country = countryTextField.getText();
            countryTextField.setText("");

            String shortname= shortnameTextField.getText();
            shortnameTextField.setText("");

            Cities cities = new Cities(null,name,country,shortname);
                try {
                    Admin.savetoCities(cities);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
