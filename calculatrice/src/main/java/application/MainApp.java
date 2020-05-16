package application;

import controllor.Controllor;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.CalculatriceDynamiqueDuFutur;
import modele.CalculatriceDynamiqueDuFuturImpl;

public class MainApp extends Application {
    Controllor controllor;
    CalculatriceDynamiqueDuFutur calculatriceDynamiqueDuFutur=new CalculatriceDynamiqueDuFuturImpl();

    @Override
    public void start(Stage primaryStage) throws Exception {

        controllor=new Controllor(calculatriceDynamiqueDuFutur);
        controllor.showViews();


    }
}
