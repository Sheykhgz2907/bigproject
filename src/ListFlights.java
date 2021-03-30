import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListFlights extends JPanel {
    JTable table;
    public ListFlights(MainFrame mainFrame){
        setSize(500,500);
        setLayout(null);
        table= new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100,100,300,40);
        add(scrollPane);
        JButton back = new JButton("BACK");
        back.setBounds(100,360,300,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.menuPage.setVisible(true);
            }
        });
    }
    public void generateTable(ArrayList<Flights> flighjts){
        String [] header = {"ID","AIRCRAFTID","DEPARTURECITYID","ARRIVALCITYID","DEPARTURETIME","ECONOMPLACEPRICE","BUSINESSPLACEPRICE"};
        Object [][] objects = new Object[flighjts.size()][7];
        for(int i=0;i<flighjts.size();i++){
            objects[i][0]=flighjts.get(i).id;
            objects[i][1]=flighjts.get(i).aircraft_id;
            objects[i][2]=flighjts.get(i).departure_city_id;
            objects[i][3]=flighjts.get(i).arrival_city_id;
            objects[i][4]=flighjts.get(i).departure_time;
            objects[i][5]=flighjts.get(i).economy_place_price;
            objects[i][6]=flighjts.get(i).business_place_price;
        }
        DefaultTableModel tableModel= new DefaultTableModel(objects,header);
        table.setModel(tableModel);
    }
}
