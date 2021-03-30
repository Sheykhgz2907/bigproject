import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddTickets extends JPanel {
    public AddTickets(TicketsFrame ticketsFrame){
        setSize(550,600);
        setLayout(null);

       JLabel flightid = new JLabel("Flight ID");
       flightid.setBounds(100,100,100,40);
       add(flightid);

       JTextField flightidtext = new JTextField();
       flightidtext.setBounds(200,100,100,40);
       add(flightidtext);

       JLabel name = new JLabel("Name:");
       name.setBounds(100,150,100,40);
       add(name);

       JTextField nametext = new JTextField();
       nametext.setBounds(200,150,100,40);
       add(nametext);

       JLabel surname = new JLabel("Surname:");
       surname.setBounds(100,200,100,40);
       add(surname);

       JTextField surnametext = new JTextField();
       surnametext.setBounds(200,200,100,40);
       add(surnametext);

       JLabel passnumber =new JLabel("Passport number:");
       passnumber.setBounds(100,250,100,40);
       add(passnumber);

       JTextField passnumbertext = new JTextField();
       passnumbertext.setBounds(200,250,100,40);
       add(passnumbertext);

       String tickettype[]={"BusinessClass","EconomClass"};
       JComboBox classcapacity=new JComboBox(tickettype);
       classcapacity.setBounds(100,300,150,40);
       add(classcapacity);

       JButton addtickets = new JButton("ADD TICKETS");
       addtickets.setBounds(100,350,100,40);
       add(addtickets);

       JButton backbutton = new JButton("Back to Menu");
       backbutton.setBounds(100,400,100,40);
       add(backbutton);

      backbutton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
            ticketsFrame.menuPageTickets.setVisible(true);
         }
      });
      addtickets.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int flightid = Integer.parseInt(flightidtext.getText());
            flightidtext.setText("");

            String name = nametext.getText();
            nametext.setText("");

            String surname = surnametext.getText();
            surnametext.setText("");

            String passnumber = passnumbertext.getText();
            passnumbertext.setText("");

            String tickettype= (String)classcapacity.getSelectedItem();
            Tickets tickets=new Tickets(null,flightid,name,surname,passnumber,tickettype);
            try {
               Kassir.savetoTickets(tickets);
            } catch (IOException ioException) {
               ioException.printStackTrace();
            }
         }
      });

    }
}
