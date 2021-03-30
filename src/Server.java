import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Connection connection;
        Scanner scan = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tickets?useUnicode=true&serverTimezone=UTC","root", "");
        System.out.println("CONNECTED TO DATABASE");

        ServerSocket server = new ServerSocket(4200);
        while (true) {
            Socket socket = server.accept();
            new ClientHandler(connection, socket);
        }

    }

}
