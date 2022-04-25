/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevomar;

import edu.testPIJava.entities.Publication;
import edu.testPIJava.services.PublicationCRUD;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AfficherPublicationController implements Initializable {

    @FXML
    private TableView<Publication> tableviewpub;
    @FXML
    private Button SupprimerBtn;
    @FXML
    private Button ModifierBtn;
        static Publication selectionedPublication;

    @FXML
    private TableColumn<Publication, String> titre;
    @FXML
    private TableColumn<Publication,String> descri;
    @FXML
    private Button consulterBtn1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AfficherPublication();
    }   
      public void AfficherPublication(){
          
         ArrayList arrayList = (ArrayList) PublicationCRUD.ReadPersonne();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tableviewpub.setItems(observableList);
      
       titre.setCellValueFactory(new PropertyValueFactory<Publication, String>("titre") );
       descri.setCellValueFactory(new PropertyValueFactory<Publication, String>("description") );
        
         
     
      }

    @FXML
    private void Supprimer(ActionEvent event) {
                selectionedPublication = tableviewpub.getSelectionModel().getSelectedItem();
                  List<Publication> listPublication = tableviewpub.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment supprimer cette publication");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                new PublicationCRUD().supprimerPublication(listPublication.get(0).getId());

            }
    }

    /*  @FXML
   private void consulter(ActionEvent event) {
                selectionedPublication = tableviewpub.getSelectionModel().getSelectedItem();
                  List<Publication> listPublication = tableviewpub.getSelectionModel().getSelectedItems();
        if (action.get() == ButtonType.OK) {
                new PublicationCRUD().supprimerPublication(listPublication.get(0).getId());

            }
      
       titre.setCellValueFactory(new PropertyValueFactory<Publication, String>("titre") );
       descri.setCellValueFactory(new PropertyValueFactory<Publication, String>("description") );
            }*/
    
    @FXML
    private void Modifier(ActionEvent event) {
                 AfficherPublication();

    }
    
}
