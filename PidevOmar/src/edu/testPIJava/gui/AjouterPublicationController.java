/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testPIJava.gui;

import edu.testPIJava.entities.Publication;
import edu.testPIJava.services.PublicationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private AnchorPane zz;
    @FXML
    private ImageView bg;
   
   

    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                    bg.setImage(new Image("Image/bg-top.png"));

    }    

    @FXML
    private void ajouterpublication(ActionEvent event) {
        if (testSaisie())
        {
        Publication p;
        p = new Publication(titre.getText(), descri.getText());
        PublicationCRUD pcr = new PublicationCRUD();
        pcr.AjoutPublication(p);
        
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
            nomCheckMark.setImage(new Image("Image/erreurCheckMark.png"));
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
            descriCheckMark.setImage(new Image("Image/erreurCheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }


    @FXML
    private void descriCheckMark(KeyEvent event) {
    }

    @FXML
    private void nomCheckMark(KeyEvent event) {
    }

}
