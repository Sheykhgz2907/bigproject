import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Kassir extends JFrame {
    static ObjectOutputStream outputStream;
    static ObjectInputStream inputStream;

    public static void main(String[] args) throws IOException {
        TicketsFrame ticketsFrame =new TicketsFrame();
        ticketsFrame.setVisible(true);
        Socket socket = new Socket("127.0.0.1",4200);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());

    }
    public static void savetoTickets(Tickets tickets) throws IOException {
        outputStream.writeObject("ADDTICKETS");
        outputStream.writeObject(tickets);
    }
    public static ArrayList<Tickets> readToTickets() throws IOException, ClassNotFoundException {
        outputStream.writeObject("LISTTICKETS");
        ArrayList<Tickets> tickets = (ArrayList<Tickets>) inputStream.readObject();
        return tickets;
    }
    public static void deletetoTickets(int id) throws IOException {
        outputStream.writeObject("DELETETICKETS");
        outputStream.writeObject(id);

    }
}
