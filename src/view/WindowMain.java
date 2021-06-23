package view;


import helpers.Brains;

import javax.naming.Context;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket;
import java.time.LocalDate;
import java.util.ArrayList;

public class WindowMain extends JFrame {

    public interface FrameListener {
        void searchButton();
        void yearField(ActionEvent e);
    }


    public static final String[] months = {"April", "May"};

    private static JPanel header,body,footer;
    private static JLabel signText,ageText,birthdayText,birthdayWeekText;
    private JTextField year,month,day;
    ActionListener yearListener,buttonListener;

    public WindowMain(int width, int height, String title){

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //this.setResizable(true);
        this.setSize(width,height);
//        ImageIcon icon = new ImageIcon("./src/main/java/coat_h60.png");
//        this.setIconImage(icon.getImage());
//        this.getContentPane().setLayout(new GridLayout());
        this.getContentPane().setBackground(Color.decode("#f4f4f4"));
    }

    //region Header
    private JPanel paneHeader(){
        header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, getWidth()/8,getHeight()/12));
        header.setBackground(Color.green);
        header.setOpaque(false);

        //region Content
        this.year = new JTextField("Year", 10);
        this.month = new JTextField("Month", 10);
        this.day = new JTextField("Day", 10);

//        year.setFocusable(false);
        this.year.setBorder(null);
        this.year.setHorizontalAlignment(JTextField.CENTER);
        this.year.addActionListener(this.yearListener);

//        month.setFocusable(false);
        this.month.setBorder(null);
        this.month.setHorizontalAlignment(JTextField.CENTER);

//        day.setFocusable(false);
        this.day.setBorder(null);
        this.day.setHorizontalAlignment(JTextField.CENTER);
        //endregion

        //Adding content
        header.add(this.year);
        header.add(this.month);
        header.add(this.day);

        //Size
        header.setPreferredSize(new Dimension(0,getHeight()/5));

        return header;
    }
    //endregion

    //region Body
    private JPanel paneBody(){
        body = new JPanel();
        body.setLayout(new FlowLayout(FlowLayout.CENTER,1000,20));
        body.setBorder(BorderFactory.createDashedBorder(Color.blue));
        //Content
        //Sign
        JLabel signLabel = new JLabel("Sign:");

        signLabel.setHorizontalAlignment(JLabel.TRAILING);
        signText = new JLabel("Your sign");

        //Age
        JLabel ageLabel = new JLabel("Age: ");

        ageLabel.setHorizontalAlignment(JLabel.RIGHT);
        ageText = new JLabel("Your age");

        //Birthday in label
        JLabel birthdayLabel = new JLabel("Birthday in: ");

        birthdayLabel.setHorizontalAlignment(JLabel.RIGHT);
        birthdayText = new JLabel("Days till your birthday");

        //B-day week
        JLabel birthdayWeekLabel = new JLabel("Week that you born: ");

        birthdayWeekLabel.setHorizontalAlignment(JLabel.RIGHT);
        birthdayWeekText = new JLabel("Week that you were born");



        //Adding content
        body.add(signLabel);
        body.add(signText);
        body.add(ageLabel);
        body.add(ageText);
        body.add(birthdayLabel);
        body.add(birthdayText);
        body.add(birthdayWeekLabel);
        body.add(birthdayWeekText);

        return body;
    }
    //endregion

    //region Footer
    private JPanel paneFooter(){
        footer = new JPanel(new FlowLayout(FlowLayout.CENTER,100,5));

        //Content
        JButton button = new JButton("Button");
        button.setFocusable(false);
        button.addActionListener(this.buttonListener);

        JButton button2 = new JButton("Next");
        button2.setFocusable(false);


        //Add content
        footer.add(button);
        footer.add(button2);


        return footer;
    }
    //endregion

    public void showIt(){
        this.add(BorderLayout.NORTH,paneHeader());
        this.add(BorderLayout.CENTER,paneBody());
        this.add(BorderLayout.SOUTH,paneFooter());
        //this.pack();
        this.setVisible(true);
    }

    public void setButtonListener(ActionListener listener){
        this.buttonListener = listener;
    }

    public void setYearListener(ActionListener listener){
        this.yearListener = listener;
    }

    public int getYear(){
        return Integer.parseInt(this.year.getText());
    }
    public String getYearText(){
        return this.year.getText();
    }

    public int getMonth(){
        return Integer.parseInt(this.month.getText());
    }

    public int getDay(){
        return Integer.parseInt(this.day.getText());
    }

    public void setYear(JTextField year) {
        this.year = year;
    }

    public void setMonth(JTextField month) {
        this.month = month;
    }

    public void setDay(JTextField day) {
        this.day = day;
    }

    public void setSignText(String s) {
        signText.setText(s);
    }

    public void setAgeText(String s) {
        ageText.setText(s);
    }

    public void setBirthdayText(String s) {
        birthdayText.setText(s);
    }

    public void setBirthdayWeekText(String s) {
        birthdayWeekText.setText(s);
    }
}
