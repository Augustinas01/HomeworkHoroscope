import helpers.Brains;
import objects.MessageSign;
import view.WindowMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class App  {
    public static void main(String[] args) {
        WindowMain view = new WindowMain(800,600,"Horoscope app");
        Brains Controller = new Brains(view,getHoroscopeData("mainData.txt") );

        }


    public static ArrayList<MessageSign> getHoroscopeData(String fileName) {
        ArrayList<MessageSign> list = new ArrayList<>();
        File file = new File(fileName);


        try (BufferedReader br = new BufferedReader(new FileReader("src/data/" + file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(new MessageSign(line));
                String d = br.readLine();
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                list.get(list.size()-1).setDate(startDate(d,f),finishDate(d,f));
                list.get(list.size()-1).setMessage(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
    private static LocalDate startDate(String input, DateTimeFormatter f){
        return LocalDate.parse("2020."+input.substring(0,5), f);
    }
    private static LocalDate finishDate(String input, DateTimeFormatter f){
        return LocalDate.parse("2020."+input.substring(8,13), f);
    }










}
