import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainPage extends JFrame implements ActionListener
{
    private JPanel panelMain;
    private JLabel labelTscore,labelEnd;

    private Color clrBackG = new Color(36, 64, 109);
    private Color clrButton1 = new Color(23, 210, 239);
    private Color clrButton2 = new Color(54, 249, 132);
    private Color clrTemp,clrTemp1;

    Button[] buttons = new Button[50];
    Button button1,button2;

    int btnCounter = 0;

    Random rnd = new Random();

    int counter=0;
    int level,score;
    int Tscore=1000;

    String ValueKeeperSt1,ValueKeeperSt2;

    Boolean checked=false;

    MainPage(int level,int score)
    {
        super("Puzzle Game");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//////////////////////////////////// MAIN //////////////////////////////////////

        panelMain = new JPanel();
        panelMain.setBackground(clrBackG);
        panelMain.setLayout(null);

//////////////////////////////////// Score Board ///////////////////////////////

        labelTscore = new JLabel();
        labelTscore.setBounds(60,30,100,20);
        labelTscore.setText("Score: "+Tscore);
        labelTscore.setForeground(Color.WHITE);
        panelMain.add(labelTscore);

        this.level=level;
        this.score=score;
///////////////////////////////// Create Buttons////////////////////////////////
        for(int i=0;i<level;i++)
        {
            int Values = rnd.nextInt(49)+10;
            String values;
            values = Integer.toString(Values);

            buttons[counter] =new Button(values);
            buttons[counter].setBackground(clrButton1);
            buttons[counter].setForeground(clrButton1);
            buttons[counter].addActionListener(this);
            panelMain.add(buttons[counter]);


            buttons[counter+1]=new Button(values);
            buttons[counter+1].setBackground(clrButton2);
            buttons[counter+1].setForeground(clrButton2);
            buttons[counter+1].addActionListener(this);
            panelMain.add(buttons[counter+1]);

            counter = counter + 2;
            btnCounter = btnCounter + 2;

        }//Create Button

////////////////////////////////////// END /////////////////////////////////////

        this.add(panelMain);
        this.setVisible(true);
    }//Constroctor

/////////////////////////////////// Action Performed////////////////////////////

    public void actionPerformed(ActionEvent mpae)
    {
        if(checked == false)
        {
            button1 = (Button)mpae.getSource();
            button1.setForeground(Color.BLACK);
            ValueKeeperSt1 = button1.getLabel();
            clrTemp = button1.getBackground();
            checked = true;
        }//Checked Flase

        else if(checked == true)
        {
            button2 = (Button)mpae.getSource();
            button2.setForeground(Color.BLACK);
            ValueKeeperSt2 = button2.getLabel();
            clrTemp1 = button2.getBackground();

              if(ValueKeeperSt1.equals(ValueKeeperSt2))
              {
                  button1.setVisible(false);
                  button2.setVisible(false);
                  btnCounter = btnCounter -2;
                  checked = false;
                  if(btnCounter <= 0)
                  {
                      WinPage wp = new WinPage(Tscore);
                      this.setVisible(false);
                  }//Empty

              }//Right

              else
              {
                  button1.setForeground(clrTemp);
                  button2.setForeground(clrTemp1);
                  Tscore= Tscore-score;
                  labelTscore.setText("Score: "+Tscore);
                  checked = false;
              }//Wrong

        }//Checked True

    }//Action Performed

}//class
