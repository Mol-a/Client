import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Enums.ResponseStatus;
import main.Models.Entities.Flight;
import main.Models.Entities.Passenger;
import main.Models.Entities.UserMark;
import main.Models.TCP.Request;
import main.Models.TCP.Response;
import main.Utility.ClientSocket;
import main.Utility.GetService;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class FlightDetails implements Initializable {
    public Label lblStatus;
    public Label lblRoute;
    public Label lblDepartureTime;
    public Label lblDistance;
    public Label lblAircraft;
    public Label lblSeats;
    public Label lblBusinessSeats;
    public Label lblType;
    public Label labelMessage;
    public Button btnBack;
    public Spinner spinMark;
    public Button btnBuy;
    public TextField txtfldFIO;
    public Spinner spinPlace;
    public Label lblFlightTime;
    private Flight flight;
    private SpinnerValueFactory<Integer> valueMarkFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
    private SpinnerValueFactory<Integer> valuePlaceFactory;
    private int PassengerID;
    private int MarkID;
    private UserMark foundUserMark;
    private Passenger foundPassenger;
    public void OnBuy(ActionEvent actionEvent) {
        try {
            Passenger passenger = new Passenger();
            passenger.setFullName(txtfldFIO.getText());
            passenger.setPersonData(ClientSocket.getInstance().getUser().getPersonData());
            passenger.setPlaceNumber((Integer) spinPlace.getValue());
            passenger.setFlight(flight);
            passenger.setId(PassengerID);
            UserMark userMark = new UserMark();
            userMark.setFlight(flight);
            userMark.setUser(ClientSocket.getInstance().getUser());
            userMark.setMark((Integer) spinMark.getValue());
            userMark.setId(MarkID);
            SendRequest(RequestType.UPDATE_MARK, userMark);
            ResponseStatus passengerStatus = SendRequest(RequestType.UPDATE_PASSENGER, passenger);
            if(passengerStatus == ResponseStatus.OK){
                ClientSocket.getInstance().setFlightId(-1);
                if (foundUserMark != null)
                    foundUserMark.setMark((Integer) spinMark.getValue());
                else{
                    ClientSocket.getInstance().getUser().getUserMarks().add(userMark);}
                if(foundPassenger!=null){
                    foundPassenger.setFullName(txtfldFIO.getText());
                    foundPassenger.setPlaceNumber((Integer) spinPlace.getValue());
                }
                else{
                    ClientSocket.getInstance().getUser().getPersonData().getPassengers().add(passenger);
                }
                OnBack(new ActionEvent());
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    private ResponseStatus SendRequest(RequestType requestType, Object body) throws IOException {
        Request request = new Request(requestType, new Gson().toJson(body));
        ClientSocket.getInstance().getOut().println(new Gson().toJson(request));
        ClientSocket.getInstance().getOut().flush();
        Response response = new Gson().fromJson(ClientSocket.getInstance().getInStream().readLine(), Response.class);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(response.getResponseMessage());
        alert.showAndWait();
        return response.getResponseStatus();
    }

    public void OnBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) txtfldFIO.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Flights.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            if (ClientSocket.getInstance().getFlightId() != -1) {
                GetService<Flight> flightGetService = new GetService<>(Flight.class);
                flight = flightGetService.GetEntity(RequestType.REQUEST_TYPE, new Flight(ClientSocket.getInstance().getFlightId()));
                valuePlaceFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, flight.getAircraft().getSeatsAmount() + flight.getAircraft().getBusinessSeatsAmount());
                lblStatus.setText(lblStatus.getText() + flight.getStatus());
                lblRoute.setText(lblRoute.getText() + flight.getRoute().getDeparturePoint() + "-" + flight.getRoute().getArrivalPoint());
                lblDepartureTime.setText(lblDepartureTime.getText() + flight.getDepartureTime());
                lblDistance.setText(lblDistance.getText() + flight.getRoute().getDistance());
                lblAircraft.setText(lblAircraft.getText() + flight.getAircraft().getName());
                lblSeats.setText(lblSeats.getText() + flight.getAircraft().getSeatsAmount());
                lblBusinessSeats.setText(lblBusinessSeats.getText() + flight.getAircraft().getBusinessSeatsAmount());
                lblType.setText(lblType.getText() + flight.getAircraft().getType());
                int mark = 0;
                if (ClientSocket.getInstance().getUser().getUserMarks().size() != 0) {
                    Optional<UserMark> optionalUserMark = ClientSocket.getInstance().getUser().getUserMarks().stream().filter(x -> x.getFlight().getId() == flight.getId()).findFirst();
                    if (optionalUserMark.isPresent()) {
                        foundUserMark = optionalUserMark.get();
                        mark = foundUserMark.getMark();
                        MarkID = foundUserMark.getId();
                    }
                }
                valueMarkFactory.setValue(mark);

                spinMark.setValueFactory(valueMarkFactory);
                int places = 0;
                if (ClientSocket.getInstance().getUser().getPersonData() != null) {
                    Optional<Passenger> passenger = ClientSocket.getInstance().getUser().getPersonData().getPassengers().stream().filter(x -> x.getFlight().getId() == flight.getId()).findFirst();
                    if (passenger.isPresent()) {
                        foundPassenger = passenger.get();
                        PassengerID = foundPassenger.getId();
                        places = foundPassenger.getPlaceNumber();
                        txtfldFIO.setText(foundPassenger.getFullName());
                    }
                }
                valuePlaceFactory.setValue(places);
                spinPlace.setValueFactory(valuePlaceFactory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
