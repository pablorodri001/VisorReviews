package com.liceo.di.exameord.gui;

import com.liceo.di.exameord.review.Review;
import com.liceo.di.exameord.facade.FacadeApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InterfazExamenController {

    @FXML
    public TextField contenido;
    @FXML
    public TextField NombreAutor;
    @FXML
    public TextField fecha;
    // You should place this line of code in the Class
    // where you like to use the FacadeApp
    FacadeApp fApp = FacadeApp.getAppInstance();
    // The instance of FacadeApp will be the same object.
    // It doesn't matter where you place this code.
    // Controller, App or wherever you'll use it, always will be the same
    // with the same list of reviews
    @FXML
    public ListView ListaComentarios;
    public List<Review> comentarios=new ArrayList<>();


   /* @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        // An example of how to use the FacadeApp
        fApp.addReview(new Review("Author Dummy Controller", "Review Dummy Controller"));

        // if you see the terminal, you can see the List is the same both in App and in Controller
        // but, now with the other Dummy Review added
        System.out.println("--- Review List from Controller ---");
        System.out.println(fApp.getReviewList());
        System.out.println("---------------------------------");
    }*/

    public void onCrearButtonClick(ActionEvent actionEvent) {
        Review reviewCreada=new Review(NombreAutor.getText(),contenido.getText());
        fApp.addReview(reviewCreada);
        
    }

    public void OnListarButtonClick(ActionEvent actionEvent) {
        comentarios=fApp.getReviewList();
        for(Review re:comentarios){
                ListaComentarios.getItems().add(re);

        }

    }
}