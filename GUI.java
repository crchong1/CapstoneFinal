import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 * class ButtonPanel which creates a window
 * 
 * @Connor Chong 
 * @2/23/16
 */
public class GUI extends JFrame
{
    private int gameSize = 3;
    private JPanel buttonColor;
    private int gameWidth = 300;
    private int gameHeight = 300;
    private JButton buttonArray[][] = new JButton[3][3];
    private int[][] gameArray;
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    
    public GUI()
    {
        super();
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        this.buttonArray = new JButton[gameSize][gameSize];
        
        /*
        JButton button1 = new JButton(" ");
        button1.setPreferredSize(new Dimension(100, 100));
        JButton button2 = new JButton(" ");
        button2.setPreferredSize(new Dimension(100, 100));
        JButton button3 = new JButton(" ");
        button3.setPreferredSize(new Dimension(100, 100));
        JButton button4 = new JButton(" ");
        button4.setPreferredSize(new Dimension(100, 100));
        JButton button5 = new JButton(" ");
        button5.setPreferredSize(new Dimension(100, 100));
        JButton button6 = new JButton(" ");
        button6.setPreferredSize(new Dimension(100, 100));
        JButton button7 = new JButton(" ");
        button7.setPreferredSize(new Dimension(100, 100));
        JButton button8 = new JButton(" ");
        button8.setPreferredSize(new Dimension(100, 100));
        JButton button9 = new JButton(" ");
        button9.setPreferredSize(new Dimension(100, 100));
        
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.setVisible(true);
        
        */
        frame.add(panel);
        
        for (int row = 0; row < 3; row++) 
        {
            for (int col = 0; col < 3; col++) 
            {
                JButton button = new JButton();
                buttonArray[row][col] = button;
                Border border = new LineBorder(Color.black, 1);
                button.setOpaque(true);
                button.setPreferredSize(new Dimension(100, 100));
                button.setText(" ");
                button.setBackground(Color.white);
                panel.add(button);
                panel.setVisible(true);
            }
        }
        
        /*
        for(int i = 0; i < buttonArray.length; i++)
        {
            for(int j = 0; j < buttonArray[i].length; j++)
            {
                this.buttonArray[i][j] = new JButton("X: " + i + " Y: " + j);
                this.buttonArray[i][j].setPreferredSize(new Dimension(100, 100));
                panel.add(this.buttonArray[i][j]);
            }
        }
        */
       
       
        frame.setVisible(true);
        frame.setSize(300, 300);
        
        /*
        ClickListener listener = new ClickListener();
        for(int i = 0; i < buttonArray.length; i++)
        {
            for(int j = 0; j < buttonArray[i].length; j++)
            {
                buttonArray[i][j].addActionListener(listener);
                buttonArray[i][j].setText("");
            }
        }
        */
    }
    /*
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            for(int i = 0; i < buttonArray.length; i++)
            {
                for(int j = 0; j < buttonArray[i].length; j++)
                {
                    if(event.getActionCommand().equals(buttonArray[i][j])
                    {
                        if(TicTacToe.getCurrentPlayergetPlayer() == 1)
                        {
                            TicTacToe.makeMove(i, j, 1);
                        }
                        else
                        {
                            
                        }
                    }
                }
            }
        }
    }
    */
    public void updateGUI(int[][] gameArray)
    {
        for(int i = 0; i < this.buttonArray.length; i++)
        {
            for(int j = 0; j < this.buttonArray[i].length; j++)
            {
                if (gameArray[i][j] == 1)
                {
                    this.buttonArray[i][j].setText("X");
                }
                else if (gameArray[i][j] == 2)
                {
                    this.buttonArray[i][j].setText("0");
                }
                else
                {
                    this.buttonArray[i][j].setText("");
                }
            }
        }
    }
}