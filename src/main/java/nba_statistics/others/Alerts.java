package nba_statistics.others;

import javafx.scene.control.Alert;

public class Alerts {

    public static void getAlertTeams(String ...team){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        if (team.length == 1){

            errorAlert.setHeaderText("Select team");
            errorAlert.setContentText("You must select team");

        } else if (team.length == 2){
            errorAlert.setHeaderText("Host team '" + team[0] + "' and away team '" + team[1] + "' are the same");
            errorAlert.setContentText("You must enter various team name");
        }
        errorAlert.showAndWait();
    }


    public static void getAlertPlayer(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Player not found");
        errorAlert.setContentText("You must enter correct data");
        errorAlert.showAndWait();
    }

    public static void getAlertImage(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Image already exists");
        errorAlert.setContentText("Player with this image is already in database!");
        errorAlert.showAndWait();
    }
    public static void getAlertNoImage(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Empty image");
        errorAlert.setContentText("Image can't be empty!");
        errorAlert.showAndWait();
    }

    public static void getAlertNoPlayer(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Player not found!");
        errorAlert.setContentText("Player not exist");
        errorAlert.showAndWait();
    }

    public static void getAlertSeason(String s){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Season '" + s + "' doesnt exist");
        errorAlert.setContentText("You must enter season name which exists in database");
        errorAlert.showAndWait();
    }

    public static void getAlertChoicePlayer(String s){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("You don't choice a player or position");
        errorAlert.setContentText("You must choice a player and position before click '" + s +"'");
        errorAlert.showAndWait();
    }

    public static void getAlertChoiceSquad(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("You don't choice a first squad");
        errorAlert.setContentText("You must choice a first squad of five players before click 'Confirm'");
        errorAlert.showAndWait();
    }

    public static void getAlertTooManyPlayersInSquad(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("You can't add this player");
        errorAlert.setContentText("You can add only five players to the first squad");
        errorAlert.showAndWait();
    }

    public static void getAlertChoiceMatch(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("You don't choice a match");
        errorAlert.setContentText("You must choose a match before clicking 'OK'");
        errorAlert.showAndWait();
    }

    public static void getAlertSeasonRepeat(String s){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Season '" + s + "' exist in database");
        errorAlert.setContentText("You must enter a unique season name or click 'SKIP' to choose this season");
        errorAlert.showAndWait();
    }
    public static void getAlertTeam(String t){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Team '" + t + "' exist in database");
        errorAlert.setContentText("You must enter unique team name");
        errorAlert.showAndWait();
    }

    public static void getAlertDate(String ...d){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        if (d.length == 0){
            errorAlert.setTitle("ERROR");
            errorAlert.setHeaderText("Start date is later than end date!");
            errorAlert.setContentText("Start date must be earlier than end date");
            errorAlert.showAndWait();
        } else if (d.length == 1){
            errorAlert.setTitle("ERROR");
            errorAlert.setHeaderText("Date '" + d[0] + "' is incorrect format");
            errorAlert.setContentText("Correct date format: YYYY-MM-DD");
            errorAlert.showAndWait();
        }
    }
    public static void getAlertWrongDate() {

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Date is incorrect format");
        errorAlert.setContentText("Correct date format: YYYY-MM-DD");
        errorAlert.showAndWait();
    }

    public static void getAlertFloat() {

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Height or/and weight are incorrect number format");
        errorAlert.setContentText("Height and weight must be float number");
        errorAlert.showAndWait();
    }
    public static void getAlertDivision(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Choose division");
        errorAlert.setContentText("");
        errorAlert.showAndWait();
    }
    public static void getAlertConference(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Choose conference");
        errorAlert.setContentText("");
        errorAlert.showAndWait();
    }

    public static void getAlertDateBetween(String d){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Date '" + d + "' is incorrect");
        errorAlert.setContentText("Date must be date between start and end season");
        errorAlert.showAndWait();
    }

    public static void information(int flag){

        Alert information = new Alert(Alert.AlertType.INFORMATION);
        information.setTitle("CONFIRMATION");
        switch (flag)
        {
            case 0:
                information.setHeaderText("Added season");
                break;
            case 1:
                information.setHeaderText("Added team");
                break;
            case 2:
                information.setHeaderText("Added match");
                break;
            case 3:
                information.setHeaderText("Added new player");
                break;
            case 4:
                information.setHeaderText("Updated player");
                break;
            case 5:
                information.setHeaderText("Changed player role");
                break;
            case 6:
                information.setHeaderText("Registration successful");
                break;

        }
        information.showAndWait();
    }


    public static void getAlertComboBoxTeam(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Select team");
        errorAlert.setContentText("You must select team");
        errorAlert.showAndWait();
    }

    public static void getAlertComboBoxSeason(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Select season");
        errorAlert.setContentText("You must select season");
        errorAlert.showAndWait();
    }

    public static void getAlertEmptyListOfMatches(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("There is not any match in chosen team and season");
        errorAlert.setContentText("Please select existing match in given team and season");
        errorAlert.showAndWait();
    }

/*    public static void getAlertTransferToTheSameTeam(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Current and next player's team is the same");
        errorAlert.setContentText("Please transfer player to other team");
        errorAlert.showAndWait();
    }

    public static void getAlertWrongFormat(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Wrong data format");
        errorAlert.setContentText("Correct format: 'name surname <date>'");
        errorAlert.showAndWait();
    }
    public static void getAlertNoDate(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("Select player from fields or write correct date");
        errorAlert.setContentText("If two player has the same name and surname date is necessary");
        errorAlert.showAndWait();
    }*/

    public static void getAlertSecondTransfer(){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");
        errorAlert.setHeaderText("The player was transferred to other team in preseason season");
        errorAlert.setContentText("Player can transfer only one in preseason");
        errorAlert.showAndWait();
    }

    public static void getAlertLessThanTopTenPlayers(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Ten players not found");
        alert.setContentText("History of games has less than 10 players");
        alert.showAndWait();
    }

    public static void getAlertNoTopTenPlayers(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Players not found");
        alert.setContentText("In this season are no players!");
        alert.showAndWait();
    }

    public static void getAlertNoPlayersInTeam(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Players not found");
        alert.setContentText("In this team are no players!");
        alert.showAndWait();
    }

    public static void getAlertNegativeValue(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Height or/and weight are negative numbers");
        alert.setContentText("Height and weight must be positive numbers");
        alert.showAndWait();
    }

    public static void getAlertClickOkButton(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Click 'OK' button");
        alert.setContentText("You must click 'OK' button to load data");
        alert.showAndWait();
    }

    public static void getAlertSelectSeason(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Select Season");
        alert.setContentText("You must select season to load data");
        alert.showAndWait();
    }

    public static void getAlertSeasonIsStarted(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Season is started");
        alert.setContentText("Cannot add match, player and team if season was started");
        alert.showAndWait();
    }
/*    public static void getAlertNoChanged(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Nothing was changed!");
        alert.setContentText("Should change at least one parameter");
        alert.showAndWait();
    }
*/
    public static void getAlertChangedTeamButNotChangedImage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Changed team but not changed image!");
        alert.setContentText("If player changed team, image must changed too");
        alert.showAndWait();
    }

    public static void getAlertNoSeasonsForPlayer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("No seasons");
        alert.setContentText("No seasons for this player");
        alert.showAndWait();
    }

    public static void getAlertNoSeasonsOrNoPlayer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Wrong arguments");
        alert.setContentText("You must select a player and season");
        alert.showAndWait();
    }

}
