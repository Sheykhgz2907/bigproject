import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    Connection connection;
    Socket socket;
    ArrayList<Aircrafts> aircrafts;
    ArrayList<Cities> cities;
    ArrayList<Flights> flights;
    ArrayList<Tickets> tickets;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;

    public ClientHandler(Connection connection, Socket socket) throws ClassNotFoundException, IOException, SQLException {
        this.connection = connection;
        this.socket = socket;
        start();
       inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                String request = (String) inputStream.readObject();
                if (request.equals("ADDAIRCRAFTS")) {
                    Aircrafts aircrafts = (Aircrafts) inputStream.readObject();
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO aircrafts(id,name,model,business_class_capacity,econom_class_capacity) VALUES (null,?,?,?,?) ");
                    ps.setString(1, aircrafts.name);
                    ps.setString(2, aircrafts.model);
                    ps.setInt(3, aircrafts.business_class_capacity);
                    ps.setInt(4, aircrafts.econom_class_capacity);
                    ps.executeUpdate();
                }
                if (request.equals("LISTAIRCRAFTS")) {
                    PreparedStatement ps = connection.prepareStatement("SELECT * FROM aircrafts");
                    ResultSet rs = ps.executeQuery();
                    ArrayList<Aircrafts> aircraftsArrayList = new ArrayList<>();
                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        String name = rs.getString(2);
                        String model = rs.getString(3);
                        int business_class_capacity = rs.getInt(4);
                        int econom_class_capacity = rs.getInt(5);
                        Aircrafts aircrafts = new Aircrafts(id, name, model, business_class_capacity, econom_class_capacity);
                        aircraftsArrayList.add(aircrafts);
                    }
                        outputStream.writeObject(aircraftsArrayList);
                        System.out.println("LIST SEND TO ADMIN");

                }
                if(request.equals("DELETEAIRCRFTS")){
                    int id= (int) inputStream.readObject();
                    PreparedStatement ps =connection.prepareStatement("DELETE FROM tickets WHERE id=?");
                    ps.setInt(1,id);
                    ps.executeUpdate();
                }
                if (request.equals("ADDCITIES")) {

                    Cities cities = (Cities) inputStream.readObject();
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name) VALUES (null,?,?,?)");
                    ps.setString(1, cities.name);
                    ps.setString(2, cities.country);
                    ps.setString(3, cities.short_name);
                    ps.executeUpdate();
                }
                if (request.equals("LISTCITIES")) {
                    PreparedStatement ps = connection.prepareStatement("SELECT * FROM cities");
                    ResultSet rs = ps.executeQuery();
                    ArrayList<Cities> citiesArrayList = new ArrayList<>();
                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        String name = rs.getString(2);
                        String country = rs.getString(3);
                        String short_name = rs.getString(4);
                        Cities cities = new Cities(id, name, country, short_name);
                        citiesArrayList.add(cities);
                    }
                        outputStream.writeObject(citiesArrayList);
                        System.out.println("LIST SEND TO ADMIN");

                }
                if(request.equals("DELETECITIES")){
                    int id = (int) inputStream.readObject();
                    PreparedStatement ps = connection.prepareStatement("DELETE FROM tickets WHERE id=?");
                    ps.setInt(1,id);
                    ps.executeUpdate();
                }
                if (request.equals("ADDFLIGHTS")) {
                    Flights flights = (Flights) inputStream.readObject();
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) VALUES (null,?,?,?,?,?,?)");
                    ps.setInt(1, flights.aircraft_id);
                    ps.setInt(2, flights.departure_city_id);
                    ps.setInt(3, flights.arrival_city_id);
                    ps.setString(4, flights.departure_time);
                    ps.setInt(5, flights.economy_place_price);
                    ps.setInt(6, flights.business_place_price);
                    ps.executeUpdate();
                }
                if (request.equals("LISTFLIGHTS")) {
                    PreparedStatement ps = connection.prepareStatement("SELECT * FROM flights");
                    ResultSet rs = ps.executeQuery();
                    ArrayList<Flights> flightsArrayList = new ArrayList<>();
                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        int aircraft_id = rs.getInt(2);
                        int departure_city_id = rs.getInt(3);
                        int arrival_city_id = rs.getInt(4);
                        String departure_time = rs.getString(5);
                        int econom_place_price = rs.getInt(6);
                        int business_place_price = rs.getInt(7);
                        Flights flights = new Flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price);
                        flightsArrayList.add(flights);

                        outputStream.writeObject(flightsArrayList);
                        System.out.println("LIST SEND TO ADMIN");}

                }
                if(request.equals("DELETEFLIGHTS")){
                    int id = (int) inputStream.readObject();
                    PreparedStatement ps =connection.prepareStatement("DELETE FROM tickets WHERE id=?");
                    ps.setInt(1,id);
                    ps.executeUpdate();
                }
                if (request.equals("ADDTICKETS")) {
                    Tickets tickets = (Tickets) inputStream.readObject();
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO tickets(id,flight_id,name,surname,passport_number,ticket_type) VALUES(null,?,?,?,?,?)");
                    ps.setLong(1, tickets.flight_id);
                    ps.setString(2, tickets.name);
                    ps.setString(3, tickets.surname);
                    ps.setString(4, (tickets.passport_number));
                    ps.setString(5, tickets.ticket_type);
                    ps.executeUpdate();
                }
                if (request.equals("LISTTICKETS")) {
                    PreparedStatement ps = connection.prepareStatement("SELECT * FROM tickets");
                    ResultSet rs = ps.executeQuery();
                    ArrayList<Tickets> ticketsArrayList = new ArrayList<>();
                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        int flightid = rs.getInt(2);
                        String name = rs.getString(3);
                        String surname = rs.getString(4);
                        String passnumber = rs.getString(5);
                        String tickettype = rs.getString(6);
                        Tickets tickets = new Tickets(id, flightid, name, surname, passnumber, tickettype);
                        ticketsArrayList.add(tickets);

                        outputStream.writeObject(ticketsArrayList);
                        System.out.println("LIST SEND TO ADMIN");}

                }
                if(request.equals("DELETETICKETS")){
                    int id = (int) inputStream.readObject();
                    PreparedStatement ps = connection.prepareStatement("DELETE FROM tickets WHERE id=?");
                    ps.setInt(1,id);
                    ps.executeUpdate();
                }
            } catch (IOException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}