package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Chat;
import javafx.event.ActionEvent;
import model.Main;

import java.net.*;
import java.io.*;

public class CMain {

    private Main main = new Main();
    private Chat chat = new Chat();

    public Button buttonConnect;
    public Button buttonCreate;

    public TextField textFieldNickname;

    public void setSocketInfo(ActionEvent actionEvent) {

    }

    public void buttonCreateClick(ActionEvent actionEvent) throws Exception {
        int port = 7755;
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Ждём собеседника");
            //Засунуть в поток
            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Собеседник найден");
            System.out.println();

            chat.start(main.getStage(), textFieldNickname.getText());

//            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
//            InputStream sin = socket.getInputStream();
//            OutputStream sout = socket.getOutputStream();
//
//            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
//            DataInputStream in = new DataInputStream(sin);
//            DataOutputStream out = new DataOutputStream(sout);
//
//            String line;
//            while (true) {
//                line = in.readUTF();  // ожидаем пока клиент пришлет строку текста.
//                System.out.println("The dumb client just sent me this line : \" + line");
//                System.out.println("I'm sending it back...");
//                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
//                out.flush(); // заставляем поток закончить передачу данных.
//                System.out.println("Waiting for the next line...");
//                System.out.println();
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void buttonConnectClick (ActionEvent actionEvent) {
        int serverPort = 7755;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            System.out.println("Будем подключаться по IP: " + address + " и PORT: " + serverPort);
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("Создали сокет");
            System.out.println();

            chat.start(main.getStage(), textFieldNickname.getText());

//            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
//            InputStream sin = socket.getInputStream();
//            OutputStream sout = socket.getOutputStream();
//
//            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
//            DataInputStream in = new DataInputStream(sin);
//            DataOutputStream out = new DataOutputStream(sout);
//
//            // Создаем поток для чтения с клавиатуры.
//            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//            String line;
//            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
//            System.out.println();
//
//            while (true) {
//                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
//                System.out.println("Sending this line to the server...");
//                out.writeUTF(line); // отсылаем введенную строку текста серверу.
//                out.flush(); // заставляем поток закончить передачу данных.
//                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
//                System.out.println("The server was very polite. It sent me this : " + line);
//                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
//                System.out.println();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
