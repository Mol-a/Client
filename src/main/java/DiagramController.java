import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Models.Entities.Card;
import main.Models.ResultMark;
import main.Utility.GetService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DiagramController implements Initializable {

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
    public BarChart Chart;
    public CategoryAxis categoryAxis;
    public NumberAxis numberAxis;


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
        root = FXMLLoader.load(getClass().getResource("System.fxml"));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GetService<Card> result = new GetService<>(Card.class);
        Type listType = new TypeToken<ArrayList<Card>>() {
        }.getType();
        List<Card> resultList;
        resultList = new Gson().fromJson(result.GetEntities(RequestType.GETALL_CARDS), listType);
        for (Card card : resultList){
            categoryAxis.setLabel("карта");
            numberAxis.setLabel("сумма");
            XYChart.Series series = new XYChart.Series();
            series.setName(card.getClient_name() + "-" + card.getClient_surname());
            series.getData().add(new XYChart.Data<>("", card.getCard_amount()));
            Chart.getData().add(series);
        }



    }
}
