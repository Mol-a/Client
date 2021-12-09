import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Models.Entities.Card;
import main.Utility.GetService;

public class SystemController implements Initializable {

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
    private LineChart<?, ?> id_diagram_costs;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private Button id_classic_card;

    @FXML
    private Button id_gold_card;

    @FXML
    private Button id_platinum_card;

    @FXML
    private Button id_black_card;

    @FXML
    void Pressed_btn_Account_Statement(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_account_statement.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("DataDeposit.fxml"));
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
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    void Pressed_btn_Cards(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Card.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
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
    void pressedBtnAddAccount(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    void pressedBtnAddCredit(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Credit.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void Pressed_btn_Black_card(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_black_card.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("black_card.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }
    @FXML
    void Pressed_btn_Classic_card(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_classic_card.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("classic_card.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }
    @FXML
    void Pressed_btn_Gold_card(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_gold_card.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("gold_card.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }
    @FXML
    void Pressed_btn_Platinum_card(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_platinum_card.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("platinum_card.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }
}
