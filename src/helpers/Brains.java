package helpers;

import objects.MessageSign;
import view.WindowMain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static enums.Signs.ARIES;

public class Brains implements WindowMain.ButtonListener {
    WindowMain view;
    ArrayList<MessageSign> zodiacSignList;

    public Brains(WindowMain view, ArrayList<MessageSign> modelList){
        this.view = view;
        this.zodiacSignList = modelList;
        view.setListener(e -> searchButton());
        view.showIt();


    }


    @Override
    public void searchButton() {
        try {
            LocalDate input = LocalDate.of(view.getYear(), view.getMonth(), view.getDay());
            for(MessageSign zodiac:zodiacSignList) {
                if(zodiac.getPeriod(input.getYear()).contains(input)){
                    view.setSignText(zodiac.getSign());
                }
            }
            System.out.println(input);
        }catch (NumberFormatException e){
            //TODO make cage for mankeys
        }

    }




}
