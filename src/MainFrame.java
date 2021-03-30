import javax.swing.*;

public class MainFrame extends JFrame {
    MenuPage menuPage;
    AddAirCrafts airCrafts;
    AddCities cities;
    AddFlights flights;
    AddTickets tickets;

    MenuPageAircrafts menuPageAircrafts;
    MenuPageCities menuPageCities;
    MenuPageFlights menuPageFlights;
    MenuPageTickets menuPageTickets;
    ListAirCrafts listAirCrafts;
    ListCities listCities;
    ListFlights listFlights;
    ListTickets listTickets;
    DeleteAirCrafts airCraftsDelete;
    DeleteCities deleteCities;
    DeleteFlights deleteFlights;
    DeleteTickets deleteTickets;
    public MainFrame(){
        setSize(550,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tickets.kz");
        setLayout(null);

        menuPage = new MenuPage(this);
        menuPage.setVisible(true);
        add(menuPage);
        airCrafts = new AddAirCrafts(this);
        airCrafts.setVisible(false);
        add(airCrafts);
        cities = new AddCities(this);
        cities.setVisible(false);
        add(cities);
        flights = new AddFlights(this);
        flights.setVisible(false);
        add(flights);


        menuPageAircrafts = new MenuPageAircrafts(this);
        menuPageAircrafts.setVisible(false);
        add(menuPageAircrafts);

        menuPageCities = new MenuPageCities(this);
        menuPageCities.setVisible(false);
        add(menuPageCities);

        menuPageFlights = new MenuPageFlights(this);
        menuPageFlights.setVisible(false);
        add(menuPageFlights);





        listAirCrafts = new ListAirCrafts(this);
        listAirCrafts.setVisible(false);
        add(listAirCrafts);

        listCities = new ListCities(this);
        listCities.setVisible(false);
        add(listCities);

        listFlights = new ListFlights(this);
        listFlights.setVisible(false);
        add(listFlights);



        airCraftsDelete = new DeleteAirCrafts(this);
        airCraftsDelete.setVisible(false);
        add(airCraftsDelete);

        deleteCities = new DeleteCities(this);
        deleteCities.setVisible(false);
        add(deleteCities);

        deleteFlights = new DeleteFlights(this);
        deleteFlights.setVisible(false);
        add(deleteFlights);





    }
}
