import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListCities extends JPanel {
    JTable table;
    public ListCities(MainFrame mainFrame){
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
    public  void generateTable(ArrayList<Cities>cities){
        String[] header ={"ID","NAME","COUNTRY","SHORT NAME"};
        Object [][] objects= new Object[cities.size()][4];
        for(int i = 0;i<cities.size();i++){
            objects[i][0]= cities.get(i).id;
            objects[i][1]= cities.get(i).name;
            objects[i][2]=cities.get(i).country;
            objects[i][3]=cities.get(i).short_name;
        }
        DefaultTableModel tableModel = new DefaultTableModel(objects,header);
        table.setModel(tableModel);
    }
}
