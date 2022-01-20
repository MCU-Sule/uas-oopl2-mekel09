package com.example.uasoopl_1872005.Controller;

import com.example.uasoopl_1872005.Dao.FeMemberDaoImpl;
import com.example.uasoopl_1872005.Dao.FePointDaoImpl;
import com.example.uasoopl_1872005.Dao.FeTransactionDaoImpl;
import com.example.uasoopl_1872005.Model.FeMemberEntity;
import com.example.uasoopl_1872005.Model.FePointEntity;
import com.example.uasoopl_1872005.Model.FeTransactionEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TableView<FeTransactionEntity> tblTransaksi;
    public TableView<FePointEntity> tblPoint;
    public TextField txtId;
    public TextField txtName;
    public TextArea txtAlamat;
    public TextField txtPhone;
    public TextField txtEmail;
    public TextField txtUsername;
    public DatePicker txtDate;
    public TableColumn<FeMemberEntity,String> colId;
    public TableColumn<FeMemberEntity,String> colName;
    public TableColumn<FeMemberEntity,String> colPhone;
    public TableColumn<FeMemberEntity,DatePicker> colBirth;
    public TextField txtNominal;
    public DatePicker txtMasuk;
    public TableColumn<FeTransactionEntity,DatePicker> colMasuk;
    public TableColumn<FeTransactionEntity,String> colNominal;
    public TableColumn<FePointEntity,String> colIdPoint;
    public TableColumn<FePointEntity,String> colPoint;
    public TableView<FeMemberEntity> tblUser;
    private LoginController loginController;
    private FeMemberDaoImpl memberDao;
    private FePointDaoImpl pointDao;
    private FeTransactionDaoImpl transactionDao;
    private ObservableList<FeMemberEntity> mlist;
    private ObservableList<FePointEntity> plist;
    private ObservableList<FeTransactionEntity> tlist;
    public FeMemberEntity updateUser;

    /**Michael Sebastian Gunadi-1872005*/


    public FeMemberEntity getSelectedRow(){
        return this.updateUser = (FeMemberEntity) tblUser.getSelectionModel().getSelectedItem();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        memberDao = new FeMemberDaoImpl();
        pointDao = new FePointDaoImpl();
        transactionDao = new FeTransactionDaoImpl();
        mlist = FXCollections.observableArrayList();
        plist = FXCollections.observableArrayList();
        tlist = FXCollections.observableArrayList();
        mlist.addAll(memberDao.fetchall());
        plist.addAll(pointDao.fetchall());
        tlist.addAll(transactionDao.fetchall());

        tblUser.setItems(mlist);
        colId.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getCitizenId())));
        colName.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getName())));
        colPhone.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getPhone())));

        tblTransaksi.setItems(tlist);
        colNominal.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getNominal())));

        tblPoint.setItems(plist);
        colIdPoint.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getId())));
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void saveMemberAction(ActionEvent actionEvent) {
        if(txtId.getText().isEmpty()||txtName.getText().isEmpty()||txtPhone.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Tolong isi yang benar");
            alert.showAndWait();
        }else{
            FeMemberEntity anggotaEntity = new FeMemberEntity();
            anggotaEntity.setCitizenId(Integer.parseInt(txtId.getText()));
            anggotaEntity.setName(txtName.getText().trim());
            anggotaEntity.setAddress(txtAlamat.getText().trim());
            anggotaEntity.setEmail(txtEmail.getText().trim());
            anggotaEntity.setUsername(txtUsername.getText().trim());
            anggotaEntity.setPhone(txtPhone.getText().trim());
            anggotaEntity.setBirthdate(Date.valueOf(txtDate.getValue()));
            mlist.add(anggotaEntity);
            if(memberDao.addData(anggotaEntity)==1){
                mlist.clear();
                mlist.addAll(memberDao.fetchall());
            }
        }
    }

    public void resetAction(ActionEvent actionEvent) {
        txtName.clear();
        txtPhone.clear();
        txtAlamat.clear();
        txtUsername.clear();
        txtEmail.clear();
    }

    public void updateAction(ActionEvent actionEvent) {
        if(txtId.getText().isEmpty()||txtName.getText().isEmpty()||txtPhone.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Tolong isi yang benar");
            alert.showAndWait();
    }

    public void saveTransAction(ActionEvent actionEvent) {
        if(txtNominal.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Tolong isi yang benar");
            alert.showAndWait();
        }else{
            FeTransactionEntity transactionEntity = new FeTransactionEntity();
            transactionEntity.setNominal(txtNominal.getText().trim());
            transactionEntity.setTransDate(Date.valueOf(txtMasuk.getValue()));
            tlist.add(transactionEntity);
            if(transactionDao.addData(transactionEntity)==1){
                tlist.clear();
                tlist.addAll(transactionDao.fetchall());
            }
        }
    }
}
