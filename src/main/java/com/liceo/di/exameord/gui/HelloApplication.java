package com.liceo.di.exameord.gui;

import com.liceo.di.exameord.facade.InvalidIdReviewException;
import com.liceo.di.exameord.review.Review;
import com.liceo.di.exameord.facade.FacadeApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // You shoud place this line of code in the Class
    // where you like to use the FacadeApp
    FacadeApp fApp = FacadeApp.getAppInstance();
    // The instance of FacadeApp will be the same object.
    // It doesn't matter where you place this code.
    // Controller, App or wherever you'll use it, always will be the same
    // with the same list of reviews

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InterfazExamen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // An example of how to use the FacadeApp
        // In this case, you can see how to get the Review List
        System.out.println("--- Review List from App ---");
        System.out.println(fApp.getReviewList());
        System.out.println("--------------------------");

        // Now, you can see how to add a dummy review
        fApp.addReview(new Review("Author Dummy App", "Review Dummy App"));
        // if you see the terminal, you can see the List is the same both in App and in Controller

        try {
            // This is the way to add a like to the review with id 0
            fApp.likeReview(0);

            // This is the way to add a dislike to the review with id 0
            fApp.dislikeReview(0);
        } catch (InvalidIdReviewException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}