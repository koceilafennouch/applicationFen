package views;

import controllor.Controllor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.exceptions.NonSupporteeException;

import java.awt.*;

public class Calculator implements Views {
    Stage stage=new Stage();
    Controllor controllor;
    private String TEXT="Le nombre d'utilisation de cette calculatrice depuis ca creance est :" ;
    private long vCompteur=0;

    public Calculator(Controllor controllor){
        this.controllor=controllor;
        buildFrame();
    }


    public void buildFrame(){
        stage.setTitle("Calculator");


        BorderPane borderRoot=new BorderPane();

        GridPane grid =new GridPane();
         grid.setAlignment(Pos.CENTER);
         grid.setHgap(10);
         grid.setVgap(10);

       Label labelOp =new Label("Operation");
       Label labelOp1 =new Label("Operand1");
       Label labelOp2 =new Label("Operand2");
        
     
        
       grid.setConstraints(labelOp, 0, 0);
       grid.setConstraints(labelOp1, 0, 1);
       grid.setConstraints(labelOp2, 0, 2);
 


        ComboBox<String> listeDeroulante =new ComboBox<>();
        listeDeroulante.getItems().addAll(controllor.getOperation());
        listeDeroulante.getSelectionModel().select(1);

        TextField inputOp1 =new TextField();
        TextField inputOp2 =new TextField();
        TextField resultField =new TextField();

        grid.setConstraints(listeDeroulante, 1, 0);
        grid.setConstraints(inputOp1, 1, 1);
        grid.setConstraints(inputOp2, 1, 2);
        grid.setConstraints(resultField, 1, 3);

        VBox vroot=new VBox(10);
        vroot.setPadding(new Insets(50));
        Label labelCompteur =new Label();
        labelCompteur.setText(TEXT+vCompteur);
        vroot.getChildren().addAll(labelCompteur);


        Button buttoncalc =new Button("Calc");
        grid.setConstraints(buttoncalc, 0, 3);
        buttoncalc.setOnAction(e->
            {if(e.getSource()==buttoncalc)
                {
                    String vInputeOp1 = inputOp1.getText();       
                    String vInputeOp2 = inputOp2.getText();
                    String vOperation = listeDeroulante.getSelectionModel().getSelectedItem();
                        if(!vInputeOp1.isEmpty() && !vInputeOp2.isEmpty())
                        {
                            try {
                                Double result = controllor.calc(vOperation, Double.parseDouble(vInputeOp1), Double.parseDouble(vInputeOp2));
                                resultField.setText(result.toString());
                                labelCompteur.setText(TEXT+controllor.getValeurCompteur());
                            } catch (NonSupporteeException ex) {
                                ex.printStackTrace();
                            }
                        }

                }
        

            ;});
        grid.getChildren().addAll(labelOp,labelOp1,labelOp2,buttoncalc,listeDeroulante,inputOp1,inputOp2,resultField);
        borderRoot.setCenter(grid);



        borderRoot.setBottom(vroot);

        Scene scene=new Scene(borderRoot,600,400);
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
