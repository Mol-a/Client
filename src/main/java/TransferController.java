
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Enums.ResponseStatus;
import main.Models.Entities.Account;
import main.Models.Entities.Card;
import main.Models.TCP.Request;
import main.Models.TCP.Response;
import main.Models.TransferModel;
import main.Utility.ClientSocket;
import main.Utility.GetService;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TransferController  {

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
    private Button card_to_card_btn;
    @FXML
    private Button card_to_account_btn;
    @FXML
    private Button account_to_card_btn;
    @FXML
    private Button account_to_account_btn;

    @FXML
    private Pane from_card_to_card;
    @FXML
    private TextField card_number_from_1;
    @FXML
    private TextField validity_1;
    @FXML
    private TextField cvv_1;
    @FXML
    private TextField client_name_1;
    @FXML
    private TextField card_number_to_1;
    @FXML
    private Button continue_1;

    @FXML
    private Pane from_card_to_account;
    @FXML
    private TextField card_number_2;
    @FXML
    private TextField validity_2;
    @FXML
    private TextField cvv_2;
    @FXML
    private TextField client_name_2;
    @FXML
    private TextField account_number_2;
    @FXML
    private Button continue_2;

    @FXML
    private Pane from_account_to_card;
    @FXML
    private TextField card_number_3;
    @FXML
    private TextField account_number_3;
    @FXML
    private Button continue_3;

    @FXML
    private Pane from_account_to_account;
    @FXML
    private TextField account_number_to_4;
    @FXML
    private TextField account_number_from_4;
    @FXML
    private Button continue_4;

    @FXML
    private Pane transfer_amount_pane;
    @FXML
    private TextField id_transfer_amount;
    @FXML
    private Button id_transfer_btn;

    @FXML
    private Pane transfer_amount_second_pane;
    @FXML
    private TextField id_transfer_amount_second;
    @FXML
    private Button id_transfer_btn_second;

    @FXML
    private Pane transfer_amount_third_pane;
    @FXML
    private TextField id_transfer_amount_third;
    @FXML
    private Button id_transfer_btn_third;


    @FXML
    private Pane transfer_amount_four_pane;
    @FXML
    private TextField id_transfer_amount_four;
    @FXML
    private Button id_transfer_btn_four;

    @FXML
    private Label label_error;

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

    @FXML
    void Pressed_btn_account_to_account(ActionEvent event) {
        if (from_account_to_card.isVisible() || from_card_to_account.isVisible() || from_card_to_card.isVisible()) {
            from_account_to_card.setVisible(false);
            from_card_to_account.setVisible(false);
            from_card_to_card.setVisible(false);
        }
        from_account_to_account.setVisible(true);
        label_error.setVisible(false);

    }

    @FXML
    void Pressed_btn_card_to_card(ActionEvent event) {
        if (from_account_to_account.isVisible() || from_account_to_card.isVisible() || from_card_to_account.isVisible()) {
            from_account_to_account.setVisible(false);
            from_account_to_card.setVisible(false);
            from_card_to_account.setVisible(false);
        }
        from_card_to_card.setVisible(true);
        label_error.setVisible(false);
    }

    public void Pressed_continue_card_to_card(ActionEvent actionEvent) throws IOException {
        GetService<Card> batchGetService = new GetService<>(Card.class);
        Type listType = new TypeToken<ArrayList<Card>>() {
        }.getType();
        List<Card> cards = new Gson().fromJson(batchGetService.GetEntities(RequestType.GETALL_CARDS), listType);
        for (Card card : cards) {
            if (Integer.parseInt(card_number_from_1.getText()) == card.getCard_number() || client_name_1.getText() == card.getClient_name() & Integer.parseInt(validity_1.getText()) == card.getPeriod() || Integer.parseInt(cvv_1.getText()) == card.getCVV()) {
                /*from_card_to_card.setVisible(false);*/
                transfer_amount_pane.setVisible(true);
            } else {
                label_error.setVisible(true);
                from_card_to_card.setVisible(false);
            }
        }
    }

    @FXML
    void Pressed_Transfer(ActionEvent event) throws IOException {
        label_error.setVisible(false);
        TransferModel model = new TransferModel();
        model.setFrom_number(Integer.parseInt(card_number_from_1.getText()));
        model.setTo_number(Integer.parseInt(card_number_to_1.getText()));
        model.setAmount(Integer.parseInt(id_transfer_amount.getText()));
        Request requestModel = new Request();
        requestModel.setRequestMessage(new Gson().toJson(model));
        requestModel.setRequestType(RequestType.AMOUNT_TRANSFER);
        ClientSocket.getInstance().getOut().println(new Gson().toJson(requestModel));
        ClientSocket.getInstance().getOut().flush();
        String answer = ClientSocket.getInstance().getInStream().readLine();
        Response responseModel = new Gson().fromJson(answer, Response.class);
        if (responseModel.getResponseStatus() == ResponseStatus.OK){
            transfer_amount_pane.setVisible(false);
        }
        else{
            label_error.setVisible(true);
        }
    }

    @FXML
    void Pressed_btn_card_to_account(ActionEvent event) {
        if (from_account_to_account.isVisible() || from_account_to_card.isVisible() || from_card_to_card.isVisible()) {
            from_account_to_account.setVisible(false);
            from_account_to_card.setVisible(false);
            from_card_to_card.setVisible(false);
        }
        from_card_to_account.setVisible(true);
        label_error.setVisible(false);
    }
    @FXML
    void Pressed_Transfer_card_to_account(ActionEvent event) throws IOException {
        label_error.setVisible(false);
        TransferModel model = new TransferModel();
        model.setFrom_number(Integer.parseInt(card_number_2.getText()));
        model.setTo_number(Integer.parseInt(account_number_2.getText()));
        model.setAmount(Integer.parseInt(id_transfer_amount_second.getText()));
        Request requestModel = new Request();
        requestModel.setRequestMessage(new Gson().toJson(model));
        requestModel.setRequestType(RequestType.AMOUNT_TRANSFER_CARD_ACCOUNT);
        ClientSocket.getInstance().getOut().println(new Gson().toJson(requestModel));
        ClientSocket.getInstance().getOut().flush();
        String answer = ClientSocket.getInstance().getInStream().readLine();
        Response responseModel = new Gson().fromJson(answer, Response.class);
        if (responseModel.getResponseStatus() == ResponseStatus.OK){
            transfer_amount_second_pane.setVisible(false);
        }
        else{
            label_error.setVisible(true);
        }
    }

    @FXML
    void Pressed_btn_account_to_card(ActionEvent event) {
        if (from_account_to_account.isVisible() || from_card_to_account.isVisible() || from_card_to_card.isVisible()) {
            from_account_to_account.setVisible(false);
            from_card_to_account.setVisible(false);
            from_card_to_card.setVisible(false);
        }
        from_account_to_card.setVisible(true);
        label_error.setVisible(false);
    }

    @FXML
    void Pressed_continue_account_to_card(ActionEvent event) {
        label_error.setVisible(false);
        GetService<Account> batchGetService = new GetService<>(Account.class);
        Type listType = new TypeToken<ArrayList<Account>>() {
        }.getType();
        List<Account> accounts = new Gson().fromJson(batchGetService.GetEntities(RequestType.GETALL_ACCOUNTS), listType);
        for (Account account : accounts){
            if (Integer.parseInt(account_number_3.getText()) == account.getAccount_number()){
                from_account_to_card.setVisible(false);
                transfer_amount_third_pane.setVisible(true);
            }else{
                label_error.setVisible(true);
                from_account_to_card.setVisible(false);
            }
        }
    }

    @FXML
    void Pressed_Transfer_account_to_card(ActionEvent event) throws IOException {
        label_error.setVisible(false);
        TransferModel model = new TransferModel();
        model.setFrom_number(Integer.parseInt(account_number_3.getText()));
        model.setTo_number(Integer.parseInt(card_number_3.getText()));
        model.setAmount(Integer.parseInt(id_transfer_amount_third.getText()));
        Request requestModel = new Request();
        requestModel.setRequestMessage(new Gson().toJson(model));
        requestModel.setRequestType(RequestType.AMOUNT_TRANSFER_ACCOUNT_CARD);
        ClientSocket.getInstance().getOut().println(new Gson().toJson(requestModel));
        ClientSocket.getInstance().getOut().flush();
        String answer = ClientSocket.getInstance().getInStream().readLine();
        Response responseModel = new Gson().fromJson(answer, Response.class);
        if (responseModel.getResponseStatus() == ResponseStatus.OK){
            transfer_amount_third_pane.setVisible(false);
        }
        else{
            label_error.setVisible(true);
        }
    }


    @FXML
    void Pressed_continue_card_to_account(ActionEvent event) {
        label_error.setVisible(false);
        GetService<Card> batchGetService = new GetService<>(Card.class);
        Type listType = new TypeToken<ArrayList<Card>>() {
        }.getType();
        List<Card> cards = new Gson().fromJson(batchGetService.GetEntities(RequestType.GETALL_CARDS), listType);
        for (Card card : cards) {
            if (Integer.parseInt(card_number_2.getText()) == card.getCard_number() || client_name_2.getText() == card.getClient_name() & Integer.parseInt(validity_2.getText()) == card.getPeriod() || Integer.parseInt(cvv_1.getText()) == card.getCVV()) {
                from_card_to_card.setVisible(false);
                transfer_amount_second_pane.setVisible(true);
            } else {
                label_error.setVisible(true);
                from_card_to_account.setVisible(false);
            }
        }

    }

    public void Pressed_continue_account_to_account(ActionEvent actionEvent) {
        label_error.setVisible(false);
        GetService<Account> batchGetService = new GetService<>(Account.class);
        Type listType = new TypeToken<ArrayList<Account>>() {
        }.getType();
        List<Account> accounts = new Gson().fromJson(batchGetService.GetEntities(RequestType.GETALL_ACCOUNTS), listType);
        for (Account account : accounts){
            if (Integer.parseInt(account_number_from_4.getText()) == account.getAccount_number()){
                from_account_to_account.setVisible(false);
                transfer_amount_four_pane.setVisible(true);
            }else{
                label_error.setVisible(true);
                from_account_to_account.setVisible(false);
            }
        }
    }

    public void Pressed_Transfer_account_to_account(ActionEvent actionEvent) throws IOException {
        label_error.setVisible(false);
        TransferModel model = new TransferModel();
        model.setFrom_number(Integer.parseInt(account_number_from_4.getText()));
        model.setTo_number(Integer.parseInt(account_number_to_4.getText()));
        model.setAmount(Integer.parseInt(id_transfer_amount_four.getText()));
        Request requestModel = new Request();
        requestModel.setRequestMessage(new Gson().toJson(model));
        requestModel.setRequestType(RequestType.AMOUNT_TRANSFER_ACCOUNT_ACCOUNT);
        ClientSocket.getInstance().getOut().println(new Gson().toJson(requestModel));
        ClientSocket.getInstance().getOut().flush();
        String answer = ClientSocket.getInstance().getInStream().readLine();
        Response responseModel = new Gson().fromJson(answer, Response.class);
        if (responseModel.getResponseStatus() == ResponseStatus.OK){
            transfer_amount_four_pane.setVisible(false);
        }
        else{
            label_error.setVisible(true);
        }
    }
}
