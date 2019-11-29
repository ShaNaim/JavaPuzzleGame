import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Button extends JButton
{
    JButton btnPuzzle;
    Random rnd= new Random();
    final int Hight=100;
    final int Length=100;

    Button(String cap)
    {
        super(cap);
        int Xaxis = rnd.nextInt(700)+100;
        int Yaxis = rnd.nextInt(600);
        setBounds(Xaxis,Yaxis,Hight,Length);
    }//constructor
}//class
