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
import javafx.stage.Stage;
import main.Enums.RequestType;
import main.Models.Credit;
import main.Models.TCP.Request;
import main.Models.TCP.Response;
import main.Utility.ClientSocket;
import main.Utility.jaxb.JaxbParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreditController implements Initializable {
    @FXML
    public TextField creditValue;
    @FXML
    private Button idConfirm;

    public Label labelMessage;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void pressedBtnBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) idConfirm.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/System.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

    public void pressedBtnConfirm(ActionEvent actionEvent) throws IOException {
        try {
            int interLoans = Integer.parseInt(creditValue.getText());
            if (interLoans > 2000) {
                List<Credit> xmlList = JaxbParser.load("data/credit.xml");
                Request requestModel = new Request();
                requestModel.setRequestType(RequestType.GET_CREDITS);
                ClientSocket.getInstance().getOut().println(new Gson().toJson(requestModel));
                ClientSocket.getInstance().getOut().flush();
                String answer = ClientSocket.getInstance().getInStream().readLine();
                Response responseModel = new Gson().fromJson(answer, Response.class);
                String responseData = responseModel.getResponseData();
                List<main.Models.Entities.Credit> dbList = new Gson().fromJson(responseData, new TypeToken<List<main.Models.Entities.Credit>>() {
                }.getType());

                //todo filter for specific accaunt
                main.Models.Entities.Credit dbCredit = dbList.stream().findFirst().get();
                Credit xmlCredit = xmlList.stream().findFirst().get();

                boolean isCreditApproved = ((dbCredit.getCreditLoans() + interLoans + xmlCredit.getAmount()) / dbCredit.getAverageAccount() * 100) > 40;
                labelMessage.setText(isCreditApproved ? "Credit can be taken" : "Credit can't be taken");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
