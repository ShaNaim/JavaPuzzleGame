import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WinPage extends JFrame implements ActionListener,MouseListener
{
    private JPanel panelMain;
    private JLabel label1,labelScore;
    private JButton btnAgain,btnExit;

    private Color colorBG = new Color(36, 64, 109);
    private Color bg = new Color(155, 242, 157);

    private Font font1 = new Font("Consolas", Font.BOLD | Font.ITALIC, 40);

    int Tscore;

    WinPage(int Tscore)
    {
        super("Puzzle Game");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMain = new JPanel();
        panelMain.setBackground(colorBG);//Main Panel
        panelMain.setLayout(null);

        label1 = new JLabel();
        label1.setBounds(200,50,350,60);
        label1.setForeground(Color.WHITE); // WIN LABEL
        label1.setText("YOU WIN");
        label1.setFont(font1);
        panelMain.add(label1);

        this.Tscore = Tscore;

        labelScore = new JLabel();
        labelScore.setBounds(200,120,350,20);
        labelScore.setForeground(Color.WHITE); // SCORE LABEL
        labelScore.setText("Your Score: "+Tscore);
        panelMain.add(labelScore);

        btnAgain = new JButton("AGAIN");
        btnAgain.setBounds(200,150,70,30);
        btnAgain.setBackground(bg); // AGAIN BUTTON
        btnAgain.addActionListener(this);
        btnAgain.addMouseListener(this);
        panelMain.add(btnAgain);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(280,150,70,30);
        btnExit.setBackground(bg); // EXIT BUTTON
        btnExit.addActionListener(this);
        btnExit.addMouseListener(this);
        panelMain.add(btnExit);

        this.add(panelMain);
        this.setVisible(true);
    }//Constructor

///////////////////////////////////// MOUSE EVENT /////////////////////////////

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

///////////////////////////// ACTION EVENT /////////////////////////////////////

    public void actionPerformed(ActionEvent wpae)
    {
        if(wpae.getSource().equals(btnAgain))
        {
            this.setVisible(false);
            StartPage sp = new StartPage();
        }// Again Button
        else if(wpae.getSource().equals(btnExit))
        {
            System.exit(0);
        }// Exit Button
    }// ActionPerformed
}//Class
