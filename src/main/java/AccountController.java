import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Enums.ResponseStatus;
import main.Models.AccountModel;
import main.Models.Entities.Deposit;
import main.Models.Entities.Flight;
import main.Models.TCP.Request;
import main.Models.TCP.Response;
import main.Utility.ClientSocket;
import main.Utility.GetService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

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
    private TableColumn<AccountModel, String> id_deposit_name;
    @FXML
    private TableColumn<AccountModel, Integer> id_storage_time;
    @FXML
    private TableColumn<AccountModel, Double> id_interest_rate;
    @FXML
    private TableColumn<AccountModel, String> id_rate_type;
    @FXML
    private TableColumn<AccountModel, String> id_amount_operation;
    @FXML
    private TableColumn<AccountModel, String> id_responce_name;
    @FXML
    public TableView<AccountModel> tableAccount;
    @FXML
    private Button id_choose;
    @FXML
    private Pane id_account_data;
    @FXML
    private TextField id_deposit_number_pane;
    @FXML
    private TextField id_deposit_name_pane;
    @FXML
    private TextField id_storage_time_pane;
    @FXML
    private TextField id_interest_rate_pane;
    @FXML
    private TextField id_rate_type_pane;
    @FXML
    private TextField id_amount_operation_pane;
    @FXML
    private TextField id_responce_name_pane;
    @FXML
    private Button id_confirm;

    @FXML
    public void Pressed_btn_Account_Statement(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_account_statement.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("DataDeposit.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    public void Pressed_btn_Add_Account(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    public void Pressed_btn_Add_Client(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/Client.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    public void Pressed_btn_Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/System.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    public void Pressed_btn_Cards(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Card.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    public void Pressed_btn_Exit(ActionEvent event) {

    }

    @FXML
    public void Pressed_btn_Remmitance(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Transfer.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    public void Pressed_btn_statistics(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_add_client.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Diagrams.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_deposit_name.setCellValueFactory(new PropertyValueFactory<>("Deposit_name"));
        id_storage_time.setCellValueFactory(new PropertyValueFactory<>("Storage_time"));
        id_interest_rate.setCellValueFactory(new PropertyValueFactory<>("Interest_rate"));
        id_rate_type.setCellValueFactory(new PropertyValueFactory<>("Rate_type"));
        id_amount_operation.setCellValueFactory(new PropertyValueFactory<>("amount_operation"));
        id_responce_name.setCellValueFactory(new PropertyValueFactory<>("Responce_name"));
        GetService <Deposit> batchGetService = new GetService<>(Deposit.class);
        Type listType = new TypeToken<ArrayList<Deposit>>() {
        }.getType();
        List<Deposit> deposits = new Gson().fromJson(batchGetService.GetEntities(RequestType.GETALL_DEPOSITS), listType);
        ObservableList<AccountModel> list = FXCollections.observableArrayList();
        if (deposits.size() != 0 && deposits != null) {
            for (Deposit deposit : deposits) {
                AccountModel table = new AccountModel(deposit.getDeposit_name(), deposit.getStorage_time(), deposit.getInterest_rate(), deposit.getRate_type(), deposit.getAmount_operation(), deposit.getResponce_name());
                list.add(table);
            }
        }
        tableAccount.setItems(list);

    }

    public void Pressed_btn_Choose(ActionEvent actionEvent) {
        AccountModel accountModel = tableAccount.getSelectionModel().getSelectedItem();
        id_account_data.setVisible(true);
        id_deposit_name_pane.setText(accountModel.getDeposit_name());
        id_storage_time_pane.setText(Integer.toString(accountModel.getStorage_time()));
        id_interest_rate_pane.setText(Double.toString(accountModel.getInterest_rate()));
        id_rate_type_pane.setText(accountModel.getRate_type());
        id_amount_operation_pane.setText(accountModel.getAmount_operation());
        id_responce_name_pane.setText(accountModel.getResponce_name());
        final int min = 1000000;
        final int max = 9999999;
        final int dep_num = rnd(min,max);
        id_deposit_number_pane.setText(Integer.toString(dep_num));
    }
    public void Pressed_btn_Confirm(ActionEvent actionEvent) throws IOException {
        Deposit deposit = new Deposit();
        deposit.setDeposit_number(Integer.parseInt(id_deposit_number_pane.getText()));
        deposit.setDeposit_name(id_deposit_name_pane.getText());
        deposit.setStorage_time(Integer.parseInt(id_storage_time_pane.getText()));
        deposit.setInterest_rate(Double.parseDouble(id_interest_rate_pane.getText()));
        deposit.setRate_type(id_rate_type_pane.getText());
        deposit.setAmount_operation(id_amount_operation_pane.getText());
        deposit.setResponce_name(id_responce_name_pane.getText());
        Request requestModel = new Request();
        requestModel.setRequestMessage(new Gson().toJson(deposit));
        requestModel.setRequestType(RequestType.ADD_DEPOSIT);
        ClientSocket.getInstance().getOut().println(new Gson().toJson(requestModel));
        ClientSocket.getInstance().getOut().flush();
        String answer = ClientSocket.getInstance().getInStream().readLine();
        Response responseModel = new Gson().fromJson(answer, Response.class);
        if (responseModel.getResponseStatus() == ResponseStatus.OK){

            id_account_data.setVisible(false);
        }
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
