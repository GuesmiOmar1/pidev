/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevomar;

import edu.testPIJava.gui.*;
import edu.testPIJava.entities.Publication;
import edu.testPIJava.services.PublicationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AjouterPublicationController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextArea descri;
    String erreur;
    @FXML
    private ImageView nomCheckMark;
    @FXML
    private ImageView descriCheckMark;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterpublication(ActionEvent event) throws IOException {
        if (testSaisie())
        {
        Publication p;
        p = new Publication(titre.getText(), descri.getText());
        PublicationCRUD pcr = new PublicationCRUD();
        pcr.AjoutPublication(p);
       
       /* Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/AfficherPublication.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); */
       
       
       
        }
     
          
        
        
        
         /* System.out.println("ajouté avec succes");
            n = Notifications.create()
                    .title("Succes")
                    .text("Reclamation envoyé avec succes")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(3));
            n.showInformation();
*/
        }
    
   private void ajout(ActionEvent event) throws IOException {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/pidevomar/AfficherPublication.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AjouterPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
    
     private Boolean testSaisie() {
        erreur = "";
       
        if (!testNom()) {
            erreur = erreur + ("Veuillez verifier votre Titre: seulement des caractères et de nombre >= 3 \n");
        }
       
        if ( !testNom() || !testDescri()) {
         /*   n = Notifications.create()
                    .title("Erreur de format")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
            n.showInformation();*/
        }

        return testNom() && testDescri();
    }
    private Boolean testNom() {
        int nbNonChar = 0;
        for (int i = 1; i < titre.getText().trim().length(); i++) {
            char ch = titre.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && titre.getText().trim().length() >= 3) {
            nomCheckMark.setImage(new Image("Image/checkMark.png"));
            return true;
        } else {
            nomCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }
    private Boolean testDescri() {
        int nbNonChar = 0;
        for (int i = 1; i < descri.getText().trim().length(); i++) {
            char ch = descri.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && descri.getText().trim().length() >= 3) {
            descriCheckMark.setImage(new Image("Image/checkMark.png"));
            return true;
        } else {
            descriCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }
}
