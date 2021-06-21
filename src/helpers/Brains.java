package helpers;

import objects.MessageSign;
import view.WindowMain;

import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Brains implements WindowMain.ButtonListener {
    WindowMain view;

    public Brains(WindowMain view, ArrayList<MessageSign> modelList){
        this.view = view;
        view.setListener(e -> searchButton());
        view.showIt();


    }


    @Override
    public void searchButton() {
        System.out.println(view.getYear());
    }
}
