package com.example.uasoopl_1872005.Controller;

import com.example.uasoopl_1872005.Dao.FeMemberDaoImpl;
import com.example.uasoopl_1872005.HelloApplication;
import com.example.uasoopl_1872005.Model.FeMemberEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**Michael Sebastian Gunadi-1872005*/


public class LoginController implements Initializable {
    public TextField tfUsername;
    public PasswordField tfPassword;
    public Label LPassword;

    private FeMemberEntity memberEntity;
    private FeMemberDaoImpl memberDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        memberDao = new FeMemberDaoImpl();
        memberEntity = new FeMemberEntity();
    }

    public void loginAction(ActionEvent actionEvent) {
        String username = tfUsername.getText();
        String password = tfPassword.getText();

        memberEntity.setUsername(username);
        try{
            memberEntity = (FeMemberEntity) memberDao.fetchall();
            if (memberEntity.getUsername()!= null){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(HelloApplication.class.getResource("main-view.fxml"));
                loader.setResources(ResourceBundle.getBundle("bundle"));
                Parent root = loader.load();
                MainController hc = loader.getController();
                hc.setLoginController(this);
                Stage homeStage = new Stage();
                homeStage.setTitle("my Finance");
                homeStage.setScene(new Scene(root));
                homeStage.initModality(Modality.APPLICATION_MODAL);
                homeStage.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username dan password tidak sesuai");
                alert.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
