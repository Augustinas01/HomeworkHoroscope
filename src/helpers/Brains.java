package helpers;

import objects.MessageSign;
import view.WindowMain;
import view.WindowMain.FrameListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


import static enums.Signs.ARIES;

public class Brains implements FrameListener {
    WindowMain view;
    ArrayList<MessageSign> zodiacSignList;

    public Brains(WindowMain view, ArrayList<MessageSign> modelList){
        this.view = view;
        this.zodiacSignList = modelList;
        view.setButtonListener(e -> searchButton());
        view.setYearListener(e -> yearField(e));

        view.showIt();


    }


    @Override
    public void searchButton() {
        try {
            LocalDate input = LocalDate.of(view.getYear(), view.getMonth(), view.getDay());
            for(MessageSign zodiac:zodiacSignList) {
                if(zodiac.getSign().equals("Ožiaragis") && !zodiac.getPeriod(input.getYear()).contains(input)){
                    view.setSignText(zodiac.getSign());
                }else if(!zodiac.getSign().equals("Ožiaragis") && zodiac.getPeriod(input.getYear()).contains(input)){
                    view.setSignText(zodiac.getSign());
                }
            }
            System.out.println(input);
        }catch (NumberFormatException e){
            //TODO make cage for mankeys
        }

    }

    @Override
    public void yearField(ActionEvent e) {
        System.out.println(e.paramString());

    }


}
