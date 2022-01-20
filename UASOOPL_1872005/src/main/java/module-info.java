module com.example.uasoopl_1872005 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;


    opens com.example.uasoopl_1872005 to javafx.fxml;
    exports com.example.uasoopl_1872005;
}