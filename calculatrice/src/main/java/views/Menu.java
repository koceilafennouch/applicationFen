package views;


import controllor.Controllor;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Menu implements Views {

    private Stage stage=new Stage();
    Controllor controllor;


    public Menu(Controllor controllor){
        this.controllor=controllor;
        buildFrame();

    }



    public void buildFrame(){

        stage.setTitle("MonApp");
        VBox root=new VBox(10);
        root.setAlignment(Pos.CENTER);



        Label labelMenu=new Label("Menu");
        Button buttonCal=new Button("Calculator");
        buttonCal.setOnAction(e->{controllor.showCalculator();});

        Button buttonQuit=new Button("Quit");
        buttonQuit.setOnAction(e->{this.close();});

        root.getChildren().addAll(labelMenu,buttonCal,buttonQuit);

        Scene scene=new Scene(root,400,400);

        stage.setScene(scene);


    }

    @Override
    public void open() {

        stage.show();
    }

    @Override
    public void close() {
      stage.close();
    }
}
