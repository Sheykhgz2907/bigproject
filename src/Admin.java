import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static ObjectInputStream inputStream;
    static ObjectOutputStream outputStream;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    MainFrame mainFrame = new MainFrame();
    mainFrame.setVisible(true);
        Socket socket = new Socket("127.0.0.1",4200);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
    }
    public  static void savetoAircrafts(Aircrafts aircrafts) throws IOException {
        outputStream.writeObject("ADDAIRCRAFTS");
        outputStream.writeObject(aircrafts);
    }
    public static ArrayList<Aircrafts> readToAircrafts() throws IOException, ClassNotFoundException {
        outputStream.writeObject("LISTAIRCRAFTS");
        ArrayList<Aircrafts> aircrafts = (ArrayList<Aircrafts>) inputStream.readObject();
        return aircrafts;
    }

    public static void deleteAircrafts (int id) throws IOException {
        outputStream.writeObject("DELETEAIRCRAFTS");
        outputStream.writeObject(id);
    }
    public  static void  savetoCities(Cities cities) throws IOException {
        outputStream.writeObject("ADDCITIES");
        outputStream.writeObject(cities);
    }
    public  static  ArrayList<Cities> readToCities() throws IOException, ClassNotFoundException {
        outputStream.writeObject("LISTCITIES");
        ArrayList<Cities> cities = (ArrayList<Cities>) inputStream.readObject();
        return cities;
    }

    public  static void deleteCities (int id) throws IOException {
        outputStream.writeObject("DELETECITIES");
        outputStream.writeObject(id);
    }

    public static  void  savetoFlights(Flights flights) throws IOException {
        outputStream.writeObject("ADDFLIGHTS");
        outputStream.writeObject(flights);
    }
    public static  ArrayList<Flights> readToFlights() throws IOException, ClassNotFoundException {
        outputStream.writeObject("LISTFLIGHTS");
        ArrayList<Flights> flights = (ArrayList<Flights>) inputStream.readObject();
        return flights;
    }
    public static void deleteFlights(int id) throws IOException {
        outputStream.writeObject("DELETEFLIGHTS");
        outputStream.writeObject(id);
    }





}
