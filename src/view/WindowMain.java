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

    public interface ButtonListener {
        void searchButton ();
    }


    public static final String[] months = {"April", "May"};

    private static JPanel header,body,footer;
    private JTextField year,month,day;
    ActionListener listener;

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
        JLabel signLabel = new JLabel("Sign:");
        signLabel.setHorizontalAlignment(JLabel.TRAILING);

        JLabel signText = new JLabel("Avinas");

        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setHorizontalAlignment(JLabel.RIGHT);

        JLabel ageText = new JLabel("18");

        JLabel birthdayLabel = new JLabel("Birthday in: ");
        birthdayLabel.setHorizontalAlignment(JLabel.RIGHT);

        JLabel birthdayText = new JLabel("18 days");

        JLabel birthdayInfoLabel = new JLabel("Week that you born: ");
        birthdayInfoLabel.setHorizontalAlignment(JLabel.RIGHT);

        JLabel birthdayInfoText = new JLabel("20-th week");



        //Adding content
        body.add(signLabel);
        body.add(signText);
        body.add(ageLabel);
        body.add(ageText);
        body.add(birthdayLabel);
        body.add(birthdayText);
        body.add(birthdayInfoLabel);
        body.add(birthdayInfoText);

        return body;
    }
    //endregion

    //region Footer
    private JPanel paneFooter(){
        footer = new JPanel(new FlowLayout(FlowLayout.CENTER,100,5));

        //Content
        JButton button = new JButton("Button");
        button.setFocusable(false);
        button.addActionListener(this.listener);

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

    public void setListener(ActionListener listener){
        this.listener = listener;
    }

    public int getYear(){
        return Integer.parseInt(this.year.getText());
    }


}
