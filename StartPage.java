import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StartPage extends JFrame implements MouseListener, ActionListener
{
    private JPanel panelMain;
    private JButton btnStart,btnExit,btnHelp;
    private JRadioButton l1,l2,l3;
    private JLabel labelMain,labelSlevel,labelHS,lavelEasy,labelMid,labelHard;

    private Font font1 = new Font("Consolas", Font.BOLD | Font.ITALIC, 35);
    private Font font2 = new Font("Consolas", Font.BOLD | Font.ITALIC, 20);
    private Color colorBG = new Color(36, 64, 109);
    private Color bg = new Color(155, 242, 157);

    MainPage MP;

    int GameLavel;
    int HSEasy,HSMid,HSHard;
    int level,score;
    String[] Value;

    StartPage()
    {
        super("Puzzle Game");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMain = new JPanel();
        panelMain.setBackground(colorBG);
        panelMain.setLayout(null);

////////////////////////////////////// MAIN ////////////////////////////////////

        labelMain = new JLabel();
        labelMain.setFont(font1);
        labelMain.setForeground(Color.WHITE);
        labelMain.setBounds(350,50,500,80);
        labelMain.setText("MATCH THE NUMBERS");
        panelMain.setLayout(null);
        panelMain.add(labelMain);

        btnStart = new JButton("START");
        btnStart.setBounds(450,160,100,40);
        btnStart.setBackground(bg);
        btnStart.addMouseListener(this);
        btnStart.addActionListener(this);
        panelMain.add(btnStart);

////////////////////////////////////// LEVEL SELECT ////////////////////////////

        labelSlevel = new JLabel();
        labelSlevel.setText("SELECT LEVEL");
        labelSlevel.setBounds(450,230,160,40);
        labelSlevel.setFont(font2);
        labelSlevel.setForeground(Color.WHITE);
        panelMain.add(labelSlevel);

        l1 = new JRadioButton("EASY");
        l1.setBounds(450,290,90,30);
        l1.setForeground(Color.WHITE);
        l1.setOpaque(false);
        panelMain.add(l1);

        l2 = new JRadioButton("MEDIUM");
        l2.setBounds(450,330,90,30);
        l2.setForeground(Color.WHITE);
        l2.setOpaque(false);
        panelMain.add(l2);

        l3 = new JRadioButton("HARD");
        l3.setBounds(450,370,90,30);
        l3.setForeground(Color.WHITE);
        l3.setOpaque(false);
        panelMain.add(l3);

//////////////////////////////////// HIGHSCORES ////////////////////////////////

        labelHS = new JLabel();
        labelHS.setBounds(450,420,150,30);
        labelHS.setText("HIGHSCORES");
        labelHS.setFont(font2);
        labelHS.setForeground(Color.WHITE);
        panelMain.add(labelHS);

        lavelEasy = new JLabel();
        lavelEasy.setBounds(450,450,150,30);
        lavelEasy.setText("EASY: "+HSEasy);
        lavelEasy.setForeground(Color.WHITE);
        panelMain.add(lavelEasy);

        labelMid = new JLabel();
        labelMid.setBounds(450,480,150,30);
        labelMid.setText("MEDIUM: "+HSMid);
        labelMid.setForeground(Color.WHITE);
        panelMain.add(labelMid);

        labelHard = new JLabel();
        labelHard.setBounds(450,510,150,30);
        labelHard.setText("HARD: "+HSHard);
        labelHard.setForeground(Color.WHITE);
        panelMain.add(labelHard);

////////////////////////////////////// END ////////////////////////////////////

        btnExit = new JButton("EXIT");
        btnExit.setBounds(450,560,80,20);
        btnExit.setBackground(bg);
        btnExit.addMouseListener(this);
        btnExit.addActionListener(this);
        panelMain.add(btnExit);

        btnHelp = new JButton("HELP");
        btnHelp.setBounds(570,560,80,20);
        btnHelp.setBackground(bg);
        btnHelp.addMouseListener(this);
        btnHelp.addActionListener(this);
        panelMain.add(btnHelp);

        this.add(panelMain);
        this.setVisible(true);

    }//Constructor
//////////////////////////////////Mouse Event///////////////////////////////////

    public void mousePressed(MouseEvent me)
    {

    }//mousePressed
    public void mouseEntered(MouseEvent spme)
    {
      JButton button = (JButton)spme.getSource();
      button.setBackground(Color.GREEN);
    }//mouseEntered
    public void mouseClicked(MouseEvent me)
    {

    }//mouseClicked
    public void mouseExited(MouseEvent spme)
    {
      JButton button = (JButton)spme.getSource();
      button.setBackground(bg);
    }//mouseExited
    public void mouseReleased(MouseEvent me)
    {

    }//mouseReleased

/////////////////////////////////// Action Performed///////////////////////////

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource().equals(btnStart))
        {
            if(l1.isSelected())
            {
                level=5;
                score = 20;
                MP = new MainPage(level,score);
                this.setVisible(false);

            }//Easy Selected
            else if(l2.isSelected())
            {
                level=10;
                score = 25;
                MP = new MainPage(level,score);
                this.setVisible(false);

            }//Meidum Selected
            else if(l3.isSelected())
            {
                level=15;
                score = 30;
                MP = new MainPage(level,score);
                this.setVisible(false);

            }//Hard Selected
            else
            {
                 JOptionPane.showMessageDialog(this,"PLEASE SELECT A LEVEL");
            }//Nothing Selected

        }//Start Pressed
        else if(ae.getSource().equals(btnHelp))
        {
            JOptionPane.showMessageDialog(this,"Every pair of box holds The same Value.Click a box to Reveal it's Value, find the other one with the same Value.");
        }//Start Pressed

        else if(ae.getSource().equals(btnExit))
        {
            System.exit(0);
        }//Start Pressed
    }//actionPerformed
}//Class
