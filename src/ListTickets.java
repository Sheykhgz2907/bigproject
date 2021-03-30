import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListTickets extends JPanel {
    JTable table;
    public ListTickets(TicketsFrame ticketsFrame) {
        setSize(500, 500);
        setLayout(null);
        table= new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100,100,300,100);
        add(scrollPane);


        JButton backbutton = new JButton("BACK TO MAIN MENU");
        backbutton.setBounds(100, 250, 100, 40);
        add(backbutton);

        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ticketsFrame.menuPageTickets.setVisible(true);
            }
        });
    }
    public void generateTable(ArrayList<Tickets>tickets){
        String []header ={"ID","FLIGHTID","NAME","SURNAME","PASSPORTNUMBER","TICKETTYPE"};
        Object [][] objects = new Object[tickets.size()][6];
        for(int i=0;i<tickets.size();i++){
            objects[i][0]=tickets.get(i).id;
            objects[i][1]=tickets.get(i).flight_id;
            objects[i][2]=tickets.get(i).name;
            objects[i][3]=tickets.get(i).surname;
            objects[i][4]=tickets.get(i).passport_number;
            objects[i][5]=tickets.get(i).ticket_type;
        }
        DefaultTableModel tableModel=new DefaultTableModel(objects,header);
        table.setModel(tableModel);
    }
}
