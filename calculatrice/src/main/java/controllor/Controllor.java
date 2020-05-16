package controllor;

import modele.CalculatriceDynamiqueDuFutur;


import modele.exceptions.NonSupporteeException;
import views.Calculator;
import views.Menu;
import views.Views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Controllor {

    CalculatriceDynamiqueDuFutur facade;
    List<Views> viewsList = new ArrayList<>();
    public Controllor(CalculatriceDynamiqueDuFutur calculatriceDynamiqueDuFutur){
        this.facade=calculatriceDynamiqueDuFutur;

     viewsList.add(new Menu(this));

    }

    public Collection<String> getOperation(){
        return facade.getOperations();


    }



    public void showCalculator(){
        viewsList.add(new Calculator(this));

        showViews();
    }


    public void showViews(){
        for (Views view :viewsList){
            view.open();
        }
    }

    public double calc(String operation,double operand1,double opernade2) throws NonSupporteeException {

        return facade.doCalcul(operation, operand1, opernade2);

    }

    public long getValeurCompteur()
    {
        return facade.getValeurCompteur();
    }



}
