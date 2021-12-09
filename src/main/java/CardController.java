import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Enums.ResponseStatus;
import main.Models.Entities.Card;
import main.Models.Entities.Deposit;
import main.Models.TCP.Request;
import main.Models.TCP.Response;
import main.Utility.ClientSocket;
import main.Utility.GetService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class CardController implements Initializable {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button id_back;

    @FXML
    private Button id_account_statement;

    @FXML
    private Button id_remmitance;

    @FXML
    private Button id_cards;

    @FXML
    private Button id_exit;

    @FXML
    private Button id_statistics;

    @FXML
    private Button id_add_client;

    @FXML
    private Button id_open_account;

    @FXML
    private Pane id_first_card;

    @FXML
    private TextField id_first_card_number;

    @FXML
    private TextField id_first_card_name;

    @FXML
    private TextField id_first_card_surname;

    @FXML
    private Pane id_fourth_card;

    @FXML
    private TextField id_fourth_card_number;

    @FXML
    private TextField id_fourth_card_name;

    @FXML
    private TextField id_fourth_card_surname;

    @FXML
    private Pane id_fifth_card;

    @FXML
    private TextField id_fifth_card_number;

    @FXML
    private TextField id_fifth_card_name;

    @FXML
    private TextField id_fifth_card_surname;

    @FXML
    private Pane id_second_card;

    @FXML
    private TextField id_second_card_number;

    @FXML
    private TextField id_second_card_name;

    @FXML
    private TextField id_second_card_surname;

    @FXML
    private Pane id_third_card;

    @FXML
    private TextField id_third_card_number;

    @FXML
    private TextField id_third_card_name;

    @FXML
    private TextField id_third_card_surname;


    @FXML
    void Pressed_btn_Account_Statement(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_account_statement.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("DataDeposit.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    void Pressed_btn_Add_Account(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    void Pressed_btn_Add_Client(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/Client.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    void Pressed_btn_Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/System.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    void Pressed_btn_Cards(ActionEvent event) {

    }

    @FXML
    void Pressed_btn_Exit(ActionEvent event) {

    }

    @FXML
    void Pressed_btn_Remmitance(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Transfer.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    void Pressed_btn_statistics(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Diagrams.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GetService<Card> batchGetService = new GetService<>(Card.class);
        Type listType = new TypeToken<ArrayList<Card>>() {
        }.getType();
        List<Card> cards = new Gson().fromJson(batchGetService.GetEntities(RequestType.GETALL_CARDS), listType);
        switch (cards.size()) {
            case 1:
                card_first(cards);
                break;
            case 2:
                card_first(cards);
                card_second(cards);
                break;
            case 3:
                card_first(cards);
                card_second(cards);
                card_third(cards);
                break;
            case 4:
                card_first(cards);
                card_second(cards);
                card_third(cards);
                card_four(cards);
                break;
            case 5:
                card_first(cards);
                card_second(cards);
                card_third(cards);
                card_four(cards);
                card_five(cards);
                break;
        }

    }

    public void card_first(List<Card> cards) {
        id_first_card_number.setText(Integer.toString(cards.get(0).getCard_number()));
        id_first_card_name.setText(cards.get(0).getClient_name());
        id_first_card_surname.setText(cards.get(0).getClient_surname());
    }
    public void card_second(List<Card> cards){
        id_second_card_number.setText(Integer.toString(cards.get(1).getCard_number()));
        id_second_card_name.setText(cards.get(1).getClient_name());
        id_second_card_surname.setText(cards.get(1).getClient_surname());
    }
    public void card_third(List<Card> cards){
        id_third_card_number.setText(Integer.toString(cards.get(2).getCard_number()));
        id_third_card_name.setText(cards.get(2).getClient_name());
        id_third_card_surname.setText(cards.get(2).getClient_surname());
    }
    public void card_four(List<Card> cards){
        id_fourth_card_number.setText(Integer.toString(cards.get(3).getCard_number()));
        id_fourth_card_name.setText(cards.get(3).getClient_name());
        id_fourth_card_surname.setText(cards.get(3).getClient_surname());
    }
    public void card_five(List<Card> cards){
        id_fifth_card_number.setText(Integer.toString(cards.get(4).getCard_number()));
        id_fifth_card_name.setText(cards.get(4).getClient_name());
        id_fifth_card_surname.setText(cards.get(4).getClient_surname());
    }
}
