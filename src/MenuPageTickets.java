import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPageTickets extends JPanel{
    public MenuPageTickets(TicketsFrame ticketsFrame){
        setSize(500, 500);
        setLayout(null);

        JButton addtickets = new JButton("ADD TICKETS");
        addtickets.setBounds(100, 100, 180, 40);
        add(addtickets);

        JButton listtickets = new JButton("LIST TICKETS");
        listtickets.setBounds(100, 150, 180, 40);
        add(listtickets);

        JButton deletetickets = new JButton("DELETE TICKETS");
        deletetickets.setBounds(100, 200, 180, 40);
        add(deletetickets);

        JButton exit = new JButton("EXIT");
        exit.setBounds(100, 250, 180, 40);
        add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         System.exit(0);
            }
        });
        addtickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ticketsFrame.addTickets.setVisible(true);
            }
        });
        listtickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ticketsFrame.listTickets.setVisible(true);
                try {
                    ticketsFrame.listTickets.generateTable(Kassir.readToTickets());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        deletetickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ticketsFrame.deleteTickets.setVisible(true);
            }
        });
    }
}
