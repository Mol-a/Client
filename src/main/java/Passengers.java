import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Models.Entities.Flight;
import main.Models.Entities.Passenger;
import main.Models.Entities.User;
import main.Models.Entities.UserMark;
import main.Models.FlightModel;
import main.Models.PassengerModel;
import main.Utility.GetService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Passengers implements Initializable {
    public Button btnBack;
    public TableView<PassengerModel> tablePassengers;
    public TableColumn<PassengerModel, String> columnLogin;
    public TableColumn<PassengerModel, String> columnPlace;
    public TableColumn<PassengerModel, String> columnRoute;
    public TableColumn<PassengerModel, String> columnMark;

    public void OnBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Flights.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnLogin.setCellValueFactory(new PropertyValueFactory<>("User"));
        columnPlace.setCellValueFactory(new PropertyValueFactory<>("Place"));
        columnRoute.setCellValueFactory(new PropertyValueFactory<>("Route"));
        columnMark.setCellValueFactory(new PropertyValueFactory<>("Mark"));
        GetService<User> userGetService = new GetService<User>(User.class);
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        List<User> users = new Gson().fromJson(userGetService.GetEntities(RequestType.GETALL_USER), listType);
        ObservableList<PassengerModel> list = FXCollections.observableArrayList();
        if (users.size() != 0 && users != null)
            for (User user :
                    users) {
                if (user.getPersonData() != null)
                    for (Passenger passenger :
                            user.getPersonData().getPassengers()) {
                        PassengerModel passengerModel = new PassengerModel(passenger.getFlight().getRoute().getDeparturePoint() + "-" + passenger.getFlight().getRoute().getArrivalPoint(), user.getLogin(), passenger.getPlaceNumber(), user.getUserMarks().stream().filter(x->x.getFlight().getId() == passenger.getFlight().getId()).findFirst() == null?0: user.getUserMarks().stream().filter(x->x.getFlight().getId() == passenger.getFlight().getId()).findFirst().get().getMark());

                        list.add(passengerModel);
                    }
            }
        tablePassengers.setItems(list);
    }
}