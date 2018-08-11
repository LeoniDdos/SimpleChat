package model;

import controller.CChat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chat {

    private CChat cChat = new CChat();

    public void start(Stage primaryStage, String nickname) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/chat.fxml"));
        primaryStage.setTitle("Chat Room");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

        cChat.startChat(nickname);
    }
}
