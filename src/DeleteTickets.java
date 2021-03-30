import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteTickets extends JPanel {
    public DeleteTickets(TicketsFrame ticketsFrame){
        setSize(500,500);
        setLayout(null);

        JLabel enteridLabel=new JLabel("DELETE ON ID");
        enteridLabel.setBounds(100,100,100,40);
        add(enteridLabel);

        JTextField enteridTextField=new JTextField();
        enteridTextField.setBounds(200,100,100,40);
        add(enteridTextField);

        JButton deleteButton=new JButton("DELETE");
        deleteButton.setBounds(100,200,200,40);
        add(deleteButton);

        JButton backbutton=new JButton("BACK TO MAIN MENU");
        backbutton.setBounds(100,250,200,40);
        add(backbutton);
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ticketsFrame.menuPageTickets.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(enteridTextField.getText());
                try {
                    Kassir.deletetoTickets(id);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
