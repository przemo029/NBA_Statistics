package nba_statistics.controllers.viewer;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nba_statistics.controllers.AccountController;
import nba_statistics.controllers.HelpController;
import nba_statistics.services.MatchesService;
import nba_statistics.services.PlayersService;
import nba_statistics.services.SeasonsService;
import nba_statistics.services.TeamsService;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class DataViewer implements Initializable {

    @FXML
    private Button LogOutBtn;


    @FXML private Text dataViewer;
    @FXML private Text question;
    @FXML private Button viewDatabaseBtn;
    @FXML private Button timetableButton;
    @FXML private ImageView helpBtn;



    public void changeScreen(Event event) throws IOException {
        //Parent preseasonParent = FXMLLoader.load(getClass().getResource("/AccountView.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AccountView.fxml"));
        Parent accountParent = (Parent)loader.load();
        AccountController accountController = loader.getController();
        accountController.init(AccountController.getUser());
        Scene preseasonScene = new Scene(accountParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(preseasonScene);
        window.show();
    }

    public void changeScreenToSelectData(Event event) throws IOException {
        Parent selectDataParent = FXMLLoader.load(getClass().getResource("/SelectData.fxml"));
        Scene selectDataScene = new Scene(selectDataParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(selectDataScene);
        window.show();
    }

    public void changeScreentoListOfTop10Players(Event event) throws IOException {
        Parent selectDataParent = FXMLLoader.load(getClass().getResource("/ListOfTop10ShootersViewer.fxml"));
        Scene selectDataScene = new Scene(selectDataParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(selectDataScene);
        window.show();
    }
    public void changeScreenToListOfTeamPlayers(Event event) throws IOException {
        Parent selectDataParent = FXMLLoader.load(getClass().getResource("/ListOfTeamPlayersView.fxml"));
        Scene selectDataScene = new Scene(selectDataParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(selectDataScene);
        window.show();
    }
    public void changeScreenToTimetable(Event event) throws IOException {
        Parent selectDataParent = FXMLLoader.load(getClass().getResource("/Timetable.fxml"));
        Scene selectDataScene = new Scene(selectDataParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(selectDataScene);
        window.show();
    }

    @SuppressWarnings("Duplicates")
    @FXML
    void helpClicked(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Help.fxml"));
        Parent accountParent = (Parent)loader.load();
        HelpController helpController = loader.getController();
        helpController.setView("/DataViewer.fxml");
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
    }

    @FXML
    void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                changeScreenToSelectData(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            try{
                changeScreen(event);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }




}
