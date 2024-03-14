package com.liceo.di.exameord.gui;

import com.liceo.di.exameord.facade.InvalidIdReviewException;
import com.liceo.di.exameord.review.Review;
import com.liceo.di.exameord.facade.FacadeApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.LocalDateStringConverter;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InterfazExamenController  {

    @FXML
    public TextField contenido;
    @FXML
    public TextField NombreAutor;
    @FXML
    public TextField fecha;
    @FXML
    public Label confirmacionCreacion;
    private String[] valoraciones={"like","dislike"};
    // You should place this line of code in the Class
    // where you like to use the FacadeApp
    FacadeApp fApp = FacadeApp.getAppInstance();
    // The instance of FacadeApp will be the same object.
    // It doesn't matter where you place this code.
    // Controller, App or wherever you'll use it, always will be the same
    // with the same list of reviews
    @FXML
    public ListView listaComentarios;
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
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("yyyy-MM-DD");
        LocalDate fechaActual= LocalDate.now();

        Review reviewCreada=new Review(NombreAutor.getText(),contenido.getText(),fechaActual);
        confirmacionCreacion.setText("CREADO EL COMENTARIO E INSERTADO!!!");
        fApp.addReview(reviewCreada);
        
    }

    public void OnListarButtonClick(ActionEvent actionEvent) {
        comentarios=fApp.getReviewList();
        for(Review re:comentarios){
                listaComentarios.getItems().add(re);
        }
        listaComentarios.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Review reviewSeleccionada= (Review) listaComentarios.getSelectionModel().getSelectedItem();
                int codigoValoracion=reviewSeleccionada.getId();
            }
        });

    }


    public void onLikeButtonClick(ActionEvent actionEvent) throws InvalidIdReviewException {
        Review reviewSeleccionada=(Review) listaComentarios.getSelectionModel().getSelectedItem();
        int codigoValoracion=reviewSeleccionada.getId();
        fApp.likeReview(codigoValoracion);
        System.out.println("like hecho");

    }

    public void onDislikeButtonClick(ActionEvent actionEvent) throws InvalidIdReviewException {
        Review reviewSeleccionada=(Review) listaComentarios.getSelectionModel().getSelectedItem();
        int codigoValoracion=reviewSeleccionada.getId();
        fApp.dislikeReview(codigoValoracion);
        System.out.println("dislike hecho");
    }
}