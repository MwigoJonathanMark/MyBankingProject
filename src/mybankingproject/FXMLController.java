/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankingproject;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author MWIGO-JON-MARK
 */
public class FXMLController implements Initializable
{

    @FXML
    private Button dialogOkBtn;
    @FXML
    private Button dialogCancelBtn;
    @FXML
    private TextArea projectContribNames;
    @FXML
    private AnchorPane progressScreen;
    @FXML
    private AnchorPane loginForm;
    @FXML
    private AnchorPane devsScreen;
    @FXML
    private ScrollPane editorPage;
    @FXML
    private TextField userNameTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private Button loginBtn;
    @FXML
    private Label errorTxt;
    @FXML
    private ImageView loginImage;
    @FXML
    private AnchorPane welcomeScreen;
    @FXML
    private Button okWelcomeBtn;
    @FXML
    private Button cancelWelcomeBtn;
    @FXML
    private ScrollPane commentPage;
    @FXML
    private Button commentBackBtn;
    @FXML
    private Button submitBtn;
    @FXML
    private TextArea clientCommentTxtArea;
    @FXML
    private ScrollPane viewClientPage;
    @FXML
    private ImageView clientProfileView;
    @FXML
    private Image clientProfileViewPhoto;
    @FXML
    private Button backBtn;
    @FXML
    private Button nextPreviewBtn;
    @FXML
    private Button previousPreviewBtn;
    @FXML
    private Label surNameTxt;
    @FXML
    private Label firstNameTxt;
    @FXML
    private Label dOBTxt;
    @FXML
    private Label nationalityTxt;
    @FXML
    private Label addressTxt;
    @FXML
    private Label phoneNoTxt;
    @FXML
    private Label residenceTxt;
    @FXML
    private Label maritalStatusTxt;
    @FXML
    private Label genderTxt;
    @FXML
    private ImageView iDView;
    @FXML
    private Image iDImage;
    @FXML
    private Button uploadClientProfilePhotoBtn;
    @FXML
    private TextField txtSurName;
    @FXML
    private TextField txtFirstName;
    @FXML
    private DatePicker txtDOB;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtResidence;
    @FXML
    private TextField txtNationality;
    @FXML
    private Button showClientProfileBtn;
    @FXML
    private Button saveRecordBtn;
    @FXML
    private Button newRecordBtn;
    @FXML
    private Button nextBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Button uploadIDBtn;
    @FXML
    private RadioButton rdMarriedBtn;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton rdSingleBtn;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    private int tries = 3;
    private FileChooser imageChooser = new FileChooser();
    @FXML
    private ImageView clientProfilePhoto;
    @FXML
    private Image clientProfileImage;
    private String married;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        DatabaseManager.dbTableCreate();
        
        loginForm.toFront();
        loginForm.setOpacity(1.0);
//        progressScreen.toBack();
//        welcomeScreen.toBack();
//        editorPage.toBack();
//        commentPage.toBack();
//        viewClientPage.toBack();
//        devsScreen.toBack();
        userNameTxt.setText(null);
        passwordTxt.setText(null);
        
//        genderChoiceBox.setId("Gender");
        
        rdMarriedBtn.setUserData("Married");
        rdSingleBtn.setUserData("Single");
        rdSingleBtn.setSelected(true);
        group  = new ToggleGroup();
        rdMarriedBtn.setToggleGroup(group);
        rdSingleBtn.setToggleGroup(group);
        
        txtPhone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                if(!newValue.matches("\\d*")){
                    txtPhone.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }    

    @FXML
    private void loginBtnClicked(MouseEvent event)
    {
        try{
//        Duration timer = Duration.seconds(11000);
//        Duration stopper = new Duration(5000);
//        Duration stopper = Duration.seconds(5000);
//        int tries = 3;
        String user = "Admin";
        String pass = "12345";
//        char[] userName = userNameTxt.getText().toCharArray();
//        char[] password = passwordTxt.getText().toCharArray();
        String userName = userNameTxt.getText();
        String password = passwordTxt.getText();
        boolean loop = true;
//        while(loop)
//        {

//  ___  ___  _   _   _ _____ ___ ___  _  _   _  _ _   _ __  __ ___ ___ ___    ___  _  _ ___ 
// / __|/ _ \| | | | | |_   _|_ _/ _ \| \| | | \| | | | |  \/  | _ ) __| _ \  / _ \| \| | __|
// \__ \ (_) | |_| |_| | | |  | | (_) | .` | | .` | |_| | |\/| | _ \ _||   / | (_) | .` | _| 
// |___/\___/|____\___/  |_| |___\___/|_|\_| |_|\_|\___/|_|  |_|___/___|_|_\  \___/|_|\_|___|
//                                                                                           

//            if(userName == null && password == null)
//            {
//                if(userName == user && password == pass)
//                {
//                    loop = false;
//                    progressScreen.toFront();
//                    loginForm.setOpacity(0);
//                    loginForm.toBack();
//                    progressScreen.setOpacity(1.0);
//                    if(timer.greaterThan(timer))
//                    {
//                        progressScreen.toBack();
//                        progressScreen.setOpacity(0);
//                        welcomeScreen.toFront();
//                        welcomeScreen.setOpacity(1.0);
//                    }
//                    break;
//                }
//                else /*if(userName != user && password != pass)*/
//                {
//                    if(tries > 0)
//                    {
//                        tries -= 1;
//                        errorTxt.setText("Access denied, try again" + tries);
////                        loginBtnClicked(event); causes a sack overflow error
//                    }
//                    else
//                    {
//                        errorTxt.setText("Access denied, contact system "
//                                + "admin for help");
//                        userNameTxt.setDisable(true);
//                        passwordTxt.setDisable(true);
//                        loginBtn.setStyle("-fx-backgroundColor:red");
//                    }
//                }
//            }
//            else
//            {
//                errorTxt.setText("Please fill in the fields below to"
//                        + " continue");
//            }
//        }
//          ====================================================================
            
            

//    ___  ___  _   _   _ _____ ___ ___  _  _   _  _ _   _ __  __ ___ ___ ___   _______      _____  
//   / __|/ _ \| | | | | |_   _|_ _/ _ \| \| | | \| | | | |  \/  | _ ) __| _ \ |_   _\ \    / / _ \ 
//   \__ \ (_) | |_| |_| | | |  | | (_) | .` | | .` | |_| | |\/| | _ \ _||   /   | |  \ \/\/ / (_) |
//   |___/\___/|____\___/  |_| |___\___/|_|\_| |_|\_|\___/|_|  |_|___/___|_|_\   |_|   \_/\_/ \___/ 
//                                                                                                  

//            System.out.println("User Name Entered: " + userNameTxt.getText() + 
//                    "\nPassword Entered: " + passwordTxt.getText());
//            if(userName == user && password == pass)
            if(userName.contentEquals(user) && password.contentEquals(pass))
            {
                progressScreen.toFront();
                loginForm.setOpacity(0);
                loginForm.toBack();
//                Thread.currentThread().sleep(5000);
//                TimeUnit.SECONDS.sleep(6);
//                Instant timer = Instant.now();
//                System.currentTimeMillis() > 700l
                progressScreen.setOpacity(1.0);
                progressScreen.toBack();
                progressScreen.setOpacity(0);
                welcomeScreen.toFront();
                welcomeScreen.setOpacity(1.0);
//                TimeUnit.SECONDS.sleep(6);
            }
            else if(userName != user && password != pass)
            {
                if(tries > 1)
                {
                    tries -= 1;
                    errorTxt.setText("Access denied, try again.\n\t" + tries + " tries left");
//                        loginBtnClicked(event); causes a sack overflow error
                    userNameTxt.setText(null);
                    passwordTxt.setText(null);
                }
                else
                {
                    errorTxt.setText("Access denied,\n\tContact your System "
                            + "Administrator for help");
                    userNameTxt.setDisable(true);
                    passwordTxt.setDisable(true);
                    loginBtn.setDisable(true);
//                    loginForm.setDisable(true);
                    loginBtn.setStyle("-fx-backgroundColor: red;");
                }
            }
        } catch(Exception ex){
            errorTxt.setText("Please fill in the fields below to"
                        + " continue");
        }
//          ====================================================================
    }
    
    @FXML
    private void okWelcomeBtnAction(ActionEvent event)
    {
//        welcomeSreen.toBack();
        editorPage.toFront();
        editorPage.setOpacity(1.0);
        welcomeScreen.toBack();
        welcomeScreen.setOpacity(0.0);
    }

    @FXML
    private void cancelWelcomeBtnClicked(MouseEvent event)
    {
        System.exit(0);
    }

    @FXML
    private void commentBackBtnClicked(MouseEvent event)
    {
        commentPage.toFront();
    }

    @FXML
    private void submitBtnClicked(MouseEvent event)
    {
    }

    @FXML
    private void backBtnClicked(MouseEvent event)
    {
        editorPage.toFront();
        editorPage.setOpacity(1.0);
        viewClientPage.toBack();
        viewClientPage.setOpacity(0.0);
    }

    @FXML
    private void nextPreviewBtnClicked(MouseEvent event)
    {
    }

    @FXML
    private void previousPreviewBtnClicked(MouseEvent event)
    {
    }

    @FXML
    private void showClientProfileBtnClicked(MouseEvent event)
    {
        viewClientPage.toFront();
        viewClientPage.setOpacity(1.0);
        editorPage.toBack();
        editorPage.setOpacity(0.0);
    }

    @FXML
    private void saveRecordBtnClicked(MouseEvent event)
    {
        String fName = txtFirstName.getText().toString();
        String lName = txtSurName.getText().toString();
        String address = txtAddress.getText().toString();
        String nationality = txtNationality.getText().toString();
        String residence = txtResidence.getText().toString();
        String dateOfBirth = txtDOB.getValue().toString();
        String sex = genderChoiceBox.getValue();
        
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
            {
                if(group.getSelectedToggle() != null){
                    married = (String) group.getSelectedToggle().getUserData();
                }
            }
        });
        
        
        int telephone = Integer.parseInt(txtPhone.getText().toString());
        DatabaseManager.dbInsertData("clients", fName, lName,  nationality, married, sex, address, residence, dateOfBirth, telephone);
    }

    @FXML
    private void newRecordBtnClicked(MouseEvent event)
    {
        txtFirstName.setText(null);
        txtSurName.setText(null);
        txtAddress.setText(null);
        txtNationality.setText(null);
        txtResidence.setText(null);
        txtDOB.setValue(null);
        genderChoiceBox.setValue(null);
        rdSingleBtn.setSelected(true);
    }

    @FXML
    private void nextBtnClicked(MouseEvent event)
    {
    }

    @FXML
    private void exitBtnClicked(MouseEvent event)
    {
        System.exit(0);
    }

    @FXML
    private void uploadIDBtnClicked(MouseEvent event)
    {
        imageChooser.setSelectedExtensionFilter(new ExtensionFilter("*.jpeg", 
                "*.jpg", "*.png", "*.img", "*.bitmap",
                "*.webg"));
        File idImage = imageChooser.showOpenDialog(null);
        if(idImage != null){
            iDImage = new Image(idImage.toURI().toString());
            iDView.setImage(iDImage);
            iDView.setSmooth(true);
        }
    }

    @FXML
    private void uploadClientProfilePhotoBtnClicked(MouseEvent event)
    {
        imageChooser.setSelectedExtensionFilter(new ExtensionFilter("*.jpeg", 
                "*.jpg", "*.png", "*.img", "*.bitmap",
                "*.webg"));
        File profileImage = imageChooser.showOpenDialog(null);
        if(profileImage != null){
            clientProfileImage = new Image(profileImage.toURI().toString());
            clientProfilePhoto.setImage(clientProfileImage);
            clientProfilePhoto.setSmooth(true);
            clientProfileViewPhoto = clientProfileImage;
            clientProfileView.setImage(clientProfileViewPhoto);
            clientProfileView.setSmooth(true);
        }
    }
    
}
