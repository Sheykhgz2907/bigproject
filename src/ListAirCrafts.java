import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListAirCrafts extends JPanel {
    JTable table;
    public ListAirCrafts(MainFrame mainFrame){
        setSize(600,600);
        setLayout(null);
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100,100,600,250);
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
    public void generateTable(ArrayList<Aircrafts> aircrafts){
        String[]header ={"ID","NAME","MODEL","BUSINESSCAPACITY","ECONOMCAPACITY"};
        Object [][] objects = new Object[aircrafts.size()][5];
        for (int i=0;i<aircrafts.size();i++){
            objects[i][0]=aircrafts.get(i).id;
            objects[i][1]=aircrafts.get(i).name;
            objects[i][2]=aircrafts.get(i).model;
            objects[i][3]=aircrafts.get(i).business_class_capacity;
            objects[i][4]=aircrafts.get(i).econom_class_capacity;
        }
        DefaultTableModel tableModel = new DefaultTableModel(objects,header);
        table.setModel(tableModel);
    }


}
