import javax.swing.*;

public class TicketsFrame extends JFrame {
    MenuPageTickets menuPageTickets;
    AddTickets addTickets;
    ListTickets listTickets;
    DeleteTickets deleteTickets;
    public  TicketsFrame(){
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tickets_Kassir");

        menuPageTickets =new MenuPageTickets(this);
        menuPageTickets.setVisible(true);
        add(menuPageTickets);

        addTickets = new AddTickets(this);
        addTickets.setVisible(false);
        add(addTickets);

        listTickets = new ListTickets(this);
        listTickets.setVisible(false);
        add(listTickets);

        deleteTickets = new DeleteTickets(this);
        deleteTickets.setVisible(false);
        add(deleteTickets);



    }
}
