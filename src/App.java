import helpers.Brains;
import objects.MessageSign;
import view.WindowMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App  {
    public static void main(String[] args) {
        WindowMain View = new WindowMain(800,600,"Horoscope app");
        Brains Controller = new Brains(View,getHoroscopeData("mainData.txt") );


        for (MessageSign msg: getHoroscopeData("mainData.txt"))
            System.out.println(msg.getSign());
        }


    public static ArrayList<MessageSign> getHoroscopeData(String fileName) {
        ArrayList<MessageSign> list = new ArrayList<>();
        File file = new File(fileName);


        try (BufferedReader br = new BufferedReader(new FileReader("src/data/" + file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(new MessageSign(line));
                list.get(list.size()-1).setDate(br.readLine());
                list.get(list.size()-1).setMessage(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }









}
