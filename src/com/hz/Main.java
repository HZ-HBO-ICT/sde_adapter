package com.hz;

import java.awt.geom.NoninvertibleTransformException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // start survey
        HealthModel model = new HealthModel();

        LineReader lowlevelReader = LineReaderFactory.GetFileReader();
        BooleanAdapter reader = new BooleanAdapter(lowlevelReader);

        // ask questions
        String q1 = "Do you often go (out) with friends?";


        try{
            System.out.println(q1);
            Boolean ans1 = reader.readLine();
            model.setSocialActive(ans1);
        } catch (NoninvertibleTransformException ex){
            model.setSocialActive(false);
            // set model invalid
        }
        catch (IOException ioex) {
            model.setSocialActive(false);
            // set model invalid
        }



        int score = model.calculateHealthScore();

        System.out.println("Your health score is " + score + " out of 10.");
    }
}
