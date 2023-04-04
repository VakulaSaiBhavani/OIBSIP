import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class NumberGuess extends JFrame
{
    JTextField a, b, c1, d;
    JLabel j4; 
    ButtonListener bl1;
    ButtonListener2 bl2;
    ButtonListener3 bl3;    
    int rand=(int) (Math.random()*100); 
    int count=0;
    public NumberGuess()
    {
        Container c = getContentPane();       
        c.setLayout(null);   
        c.setBackground(Color.LIGHT_GRAY);  
        JLabel j=new JLabel("Guess the number");
        j.setForeground(Color.BLUE);
        j.setFont(new Font("TimesRoman",Font.ITALIC,40));
        j.setSize(400,40);
        j.setLocation(250,70); 
        JLabel j1=new JLabel("Enter a number between 1-100");
        j1.setFont(new Font("Verdana",Font.PLAIN,20));
        j1.setSize(400,40);
        j1.setLocation(250,110);
        a=new JTextField(20);
        a.setSize(150,50);
        a.setLocation(260,150);       
        j4=new JLabel("Enter your guess here");
        j4.setFont(new Font("Verdana",Font.BOLD,15));
        j4.setSize(270,20);
        j4.setLocation(250,210);
        b=new JTextField(20);
        b.setSize(60,40);
        b.setLocation(20,10);        
        JLabel j5=new JLabel("Best Score");
        j5.setFont(new Font("Verdana",Font.PLAIN,20));
        j5.setSize(270,40);
        j5.setLocation(100,10);
        c1=new JTextField(20);
        c1.setSize(60,40);
        c1.setLocation(220,10);
        JLabel j6=new JLabel("No. of attempts");
        j6.setFont(new Font("Verdana",Font.PLAIN,20));
        j6.setSize(270,40);
        j6.setLocation(300,10);
        JButton b1=new JButton("Guess");
        b1.setSize(150,40);
        b1.setLocation(260,300);
        bl1=new ButtonListener();        
        b1.addActionListener(bl1);
        JButton b2=new JButton("Give up!");
        b2.setSize(100,50);
        b2.setLocation(180,400);
        bl2=new ButtonListener2();
        b2.addActionListener(bl2);        
        JButton b3=new JButton("Play Again");    
        b3.setSize(100,50);
        b3.setLocation(330,400);    
        bl3=new ButtonListener3();        
        b3.addActionListener(bl3);
        c.add(j5);    
        c.add(j4);    
        c.add(j);    
        c.add(j1);
        c.add(a);
        c.add(b);
        c.add(c1);
        c.add(b1);    
        c.add(b2);
        c.add(b3);        
        c.add(j6);     
        b.setEditable(false);
        c1.setEditable(false);    
        setTitle("GUESS THE NUMBER");        
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener
    {
        int bestScore=100;
        public void actionPerformed(ActionEvent e)
        {
            int x= Integer.parseInt(a.getText());
            count=count+1;
            if(x<rand)
            {
                j4.setText(x+" is too low, try again!!");
            }    
            else if(x>rand)
            {
                j4.setText(x+" is too high, try again!!");
            }
            else
            {
                j4.setText("CORRECT, YOU WIN!!!!");    
                if(count<bestScore)
                {    
                    bestScore=count;
                    b.setText(bestScore+"");
                }
                else
                    b.setText(""+bestScore);
                a.setEditable(false);
            }
            a.requestFocus();
            a.selectAll();
            c1.setText(count+"");
        }
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            c1.setText("");
            j4.setText(rand+" is the answer!");
            a.setText("");
            a.setEditable(false);
        }
    }        

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=(int) (Math.random()*100);
            a.setText("");
            c1.setText("");
            j4.setText("Try and guess my number");
            c1.setText("");
            count=0;
            a.setEditable(true);    
            a.requestFocus();
        }
    }

    public static void main(String[] args)
    {
        new NumberGuess();
    }
}