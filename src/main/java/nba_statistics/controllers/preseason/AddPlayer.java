package nba_statistics.controllers.preseason;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nba_statistics.controllers.HelpController;
import nba_statistics.services.PlayerTeamsHistoryService;
import nba_statistics.services.PlayersService;
import nba_statistics.services.TeamsService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static nba_statistics.others.Alerts.*;
import static nba_statistics.others.Alerts.getAlertFloat;

public class AddPlayer implements Initializable {

    @FXML private Text p40; @FXML private Text p41; @FXML private Text p42; @FXML private Text p43; @FXML private Text p44; @FXML private Text p45; @FXML private Text p46;
    @FXML private TextField t40; @FXML private TextField t41; @FXML private ComboBox<String> t42;@FXML private TextField t43; @FXML private TextField t44;@FXML private TextField t45;
    @FXML private Button sendBtn; @FXML private ImageView image; @FXML private Text enterDataTxt; @FXML private Button BackBtn; @FXML private ImageView helpBtn;

    private String currImageURL="";
    private String currSeason;

    public void setCurrSeason(String currSeason) {this.currSeason = currSeason;}

    @SuppressWarnings("Duplicates")
    public void changeScreen(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Preseason/SelectionView.fxml"));
        Parent accountParent = loader.load();
        Selection controller = loader.getController();
        controller.setCurrSeasonTmp(currSeason);
        Scene preseasonScene = new Scene(accountParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(preseasonScene);
        window.show();
    }

    private void initComboBoxTeams(){
        TeamsService teamsService = new TeamsService();
        ArrayList<String> allTeams = teamsService.getAllTeams();
        t42.setItems(FXCollections.observableArrayList(allTeams));
    }

    private void clearFields(){
        image.setImage(null);
        currImageURL="";
        t42.getSelectionModel().clearSelection();
        information(3);
        t40.clear(); t41.clear(); t43.clear();t44.clear();t45.clear();
        t42.getSelectionModel().clearSelection();
    }

    @SuppressWarnings("Duplicates")
    public void sendToDatabase(){
        PlayersService playersService = new PlayersService();
        try {
            switch (playersService.getData(t40.getText(), t41.getText(), t43.getText(), Float.parseFloat(t44.getText()), Float.parseFloat(t45.getText()), t42.getValue(),currImageURL)) {
                case 0:
                    PlayerTeamsHistoryService playerTeamsHistoryService = new PlayerTeamsHistoryService();
                    playerTeamsHistoryService.saveNewPlayerTeamsHistory(t40.getText() + " " + t41.getText() +" " + t43.getText(),t42.getValue(),currSeason);
                    clearFields();
                    break;
                case 1:
                    getAlertTeams(t42.getValue());
                    break;
                case 2:
                    getAlertDate(t43.getText());
                    break;
                case 3:
                    getAlertImage();
                    break;
                case 4:
                    getAlertNoImage();
                    break;
                case 5:
                    getAlertNegativeValue();
                    break;

            }
        } catch (NumberFormatException exc) {
            getAlertFloat();
        }
    }
    @SuppressWarnings("Duplicates")
    public void setImage(Event event) throws IOException{
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
        fileChooser.setTitle("Open Resource File");
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(window);
        if (file!=null) {
            currImageURL = file.toURI().toString();
            image.setImage(new Image(currImageURL));
        }
    }
    @SuppressWarnings("Duplicates")
    @FXML
    void helpClicked(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Help.fxml"));
        Parent accountParent = (Parent)loader.load();
        HelpController helpController = loader.getController();
        helpController.setView("/Preseason/AddPlayerView.fxml");
        helpController.init();
        Stage parent = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(parent);
        window.setHeight(350);
        window.setWidth(500);
        window.setTitle("Help window");
        Scene reviewerScene = new Scene(accountParent);
        window.setScene(reviewerScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        helpBtn.setImage(new Image("/help.png"));
        initComboBoxTeams();
    }
}
