import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Enums.ResponseStatus;
import main.Models.Entities.Client;
import main.Models.TCP.Request;
import main.Models.TCP.Response;
import main.Utility.ClientSocket;
import main.Utility.GetService;

public class ClientPage implements Initializable {

    @FXML
    private TextField id_surname;
    @FXML
    private TextField id_first_name;
    @FXML
    private TextField id_middle_name;
    @FXML
    private TextField id_pass_series;
    @FXML
    private DatePicker id_date_of_birth;
    @FXML
    private TextField id_pass_number;
    @FXML
    private TextField id_authority;
    @FXML
    private TextField id_inden_number;
    @FXML
    private DatePicker id_date_of_issue;
    @FXML
    private TextField id_place_of_birth;
    @FXML
    private TextField id_adress;
    @FXML
    private TextField id_home_phone;
    @FXML
    private TextField id_mobile_phone;
    @FXML
    private TextField id_email;
    @FXML
    private TextField id_place_of_work;
    @FXML
    private TextField id_position;
    @FXML
    private TextField id_address_of_registration;
    @FXML
    private TextField id_marital_status;
    @FXML
    private CheckBox id_retiree;
    @FXML
    private TextField id_month_income;
    @FXML
    private CheckBox id_liable;
    @FXML
    private CheckBox id_disability;
    @FXML
    private Button id_add_client;
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
    private Button id_open_account;

    private int client_id;
    private SpinnerValueFactory<Integer> valueMarkFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60);
    public Spinner spinnerAge;
    Client client;
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
    void Pressed_Add_Client(ActionEvent event) throws IOException {
        if(client == null){
            client = new Client();
        }
        main.Models.Entities.Client client = new main.Models.Entities.Client();
        client.setSurname(id_surname.getText());
        client.setFirst_name(id_first_name.getText());
        client.setMiddle_name(id_middle_name.getText());
        client.setDate_of_birth(id_date_of_birth.getAccessibleText());
        client.setPass_series(id_pass_series.getText());
        client.setPass_number(id_pass_number.getText());
        client.setAuthority(id_authority.getText());
        client.setDate_of_issue(id_date_of_issue.getAccessibleText());
        client.setInden_number(id_inden_number.getText());
        client.setPlace_of_birth(id_place_of_birth.getText());
        client.setAddress(id_adress.getText());
        client.setHome_phone(id_home_phone.getText());
        client.setMobile_phone(id_mobile_phone.getText());
        client.setEmail(id_email.getText());
        client.setPlace_of_work(id_place_of_work.getText());
        client.setPosition(id_position.getText());
        client.setAddress_of_registration(id_address_of_registration.getText());
        client.setMarital_status(id_marital_status.getText());
        //client.setMarital_status(id_marital_status.isSelected());
        if (id_disability.isSelected()){
            client.setDisability("YES");
        }else{
            client.setDisability("NO");
        }
        //client.setDisability(id_disability.isSelected());
        if (id_retiree.isSelected()){
            client.setRetiree("YES");
        }else{
            client.setRetiree("NO");
        }
       // client.setRetiree(id_retiree.isSelected());
        client.setMonth_income(id_month_income.getPrefColumnCount());

        Request request = new Request();
        request.setRequestMessage(new Gson().toJson(client));
        request.setRequestType(RequestType.ADD_CLIENT);
        ClientSocket.getInstance().getOut().println(new Gson().toJson(request));
        ClientSocket.getInstance().getOut().flush();
        String answer = ClientSocket.getInstance().getInStream().readLine();
        Response response = new Gson().fromJson(answer, Response.class);
        if (response.getResponseStatus() == ResponseStatus.OK) {
            Stage stage = (Stage) id_add_client.getScene().getWindow();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("System.fxml"));
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
        }
        else{
            System.out.println("Все плохо!");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (ClientSocket.getInstance().getClientId() != -1) {
                GetService<main.Models.Entities.Client> clientGetService = new GetService<>(main.Models.Entities.Client.class);
                client = clientGetService.GetEntity(RequestType.GET_CLIENT, new Client(ClientSocket.getInstance().getClientId()));
                client_id = client.getId();
                id_surname.setText(client.getSurname());
                id_first_name.setText(client.getFirst_name());
                id_middle_name.setText(client.getMiddle_name());
                id_pass_series.setText(client.getPass_series());
                id_date_of_birth.setAccessibleText(client.getDate_of_birth());
                id_pass_number.setText(client.getPass_number());
                id_authority.setText(client.getAuthority());
                id_inden_number.setText(client.getInden_number());
                id_date_of_issue.setAccessibleText(client.getDate_of_issue());
                id_inden_number.setText(client.getInden_number());
                id_place_of_birth.setText(client.getPlace_of_birth());
                id_adress.setText(client.getAddress());
                id_home_phone.setText(client.getHome_phone());
                id_mobile_phone.setText(client.getMobile_phone());
                id_email.setText(client.getEmail());
                id_place_of_work.setText(client.getPlace_of_work());
                id_position.setText(client.getPosition());
                id_address_of_registration.setText(client.getAddress_of_registration());
                id_marital_status.setText(client.getMarital_status());
                id_disability.setAllowIndeterminate(false);
                // id_disability.setAllowIndeterminate(client.isDisability());
                id_retiree.setAllowIndeterminate(false);
                id_month_income.setText(String.valueOf(client.getMonth_income()));
                id_liable.setAllowIndeterminate(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

