module com.mycompany.usuariotab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    opens com.mycompany.usuariotab to javafx.fxml;
    exports com.mycompany.usuariotab;
    opens Modelo;
}
