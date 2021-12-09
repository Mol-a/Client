import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DataDepositController {

    @FXML
    private Button id_back;

    @FXML
    void Pressed_btn_back(ActionEvent event) throws IOException {
        Stage stage = (Stage) id_back.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/System.fxml"));
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
    }

}
