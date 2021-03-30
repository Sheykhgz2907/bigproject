import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddAirCrafts extends JPanel {
    public AddAirCrafts(MainFrame mainFrame){
        setSize(550,600);
        setLayout(null);

        JLabel aircraftsname = new JLabel("Name:");
        aircraftsname.setBounds(100,100,100,40);
        add(aircraftsname);

        JTextField nametext = new JTextField("");
        nametext.setBounds(200,100,150,40);
        add(nametext);

        JLabel aircraftsmodel = new JLabel("Model:");
        aircraftsmodel.setBounds(100,150,100,40);
        add(aircraftsmodel);

        JTextField modeltext = new JTextField("");
       modeltext.setBounds(200,150,150,40);
        add(modeltext);

        JLabel bclasscapacity = new JLabel("B-class capacity");
        bclasscapacity.setBounds(100,200,100,40);
        add(bclasscapacity);

        JTextField bclasscapacitytext = new JTextField("");
        bclasscapacitytext.setBounds(200,200,150,40);
        add(bclasscapacitytext);

        JLabel eclasscapacity = new JLabel("E-class capacity");
        eclasscapacity.setBounds(100,250,100,40);
        add(eclasscapacity);

        JTextField eclasscapacitytext  = new JTextField("");
        eclasscapacitytext.setBounds(200,250,150,40);
        add(eclasscapacitytext);

        JButton addaircraft = new JButton("ADD AIRCRAFT");
        addaircraft.setBounds(100,300,200,40);
        add(addaircraft);

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
        addaircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String  name = nametext.getText();
            nametext.setText("");
            String  model = modeltext.getText();
            modeltext.setText("");
            int bclasscapacity = Integer.parseInt(bclasscapacitytext.getText());
            bclasscapacitytext.setText("");
            int eclasscapacity = Integer.parseInt(eclasscapacitytext.getText());
            eclasscapacitytext.setText("");
            Aircrafts aircrafts = new Aircrafts(null,name,model,bclasscapacity,eclasscapacity);
                try {
                    Admin.savetoAircrafts(aircrafts);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }
}