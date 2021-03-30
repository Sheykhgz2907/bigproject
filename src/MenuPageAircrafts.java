import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPageAircrafts extends JPanel {
    public MenuPageAircrafts(MainFrame mainFrame){
        setSize(500,500);
        setLayout(null);

        JButton addaircrafts = new JButton("ADD AIRCRAFTS");
        addaircrafts.setBounds(100,100,180,40);
        add(addaircrafts);

        JButton listaircrafts = new JButton("LIST AIRCRAFTS");
        listaircrafts.setBounds(100,150,180,40);
        add(listaircrafts);

        JButton deleteaircrafts = new JButton("DELETE AIRCRAFTS");
        deleteaircrafts.setBounds(100,200,180,40);
        add(deleteaircrafts);

        JButton backbutton = new JButton("BACK TO MENU");
        backbutton.setBounds(100,250,180,40);
        add(backbutton);

        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.menuPage.setVisible(true);
            }
        });

      addaircrafts.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              setVisible(false);
              mainFrame.airCrafts.setVisible(true);
          }
      });

        listaircrafts.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              setVisible(false);
              mainFrame.listAirCrafts.setVisible(true);
              try {
                  mainFrame.listAirCrafts.generateTable(Admin.readToAircrafts());
              } catch (IOException ioException) {
                  ioException.printStackTrace();
              } catch (ClassNotFoundException classNotFoundException) {
                  classNotFoundException.printStackTrace();
              }
          }
      });

        deleteaircrafts.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              setVisible(false);
              mainFrame.airCraftsDelete.setVisible(true);
          }
      });
    }
}
