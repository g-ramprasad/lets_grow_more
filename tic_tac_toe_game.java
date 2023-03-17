import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToeGame extends JFrame implements ActionListener {

  
    JFrame f = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel l1 = new JLabel();
    JButton[] btn = new JButton[9];
    int flag = 0;
    Random random = new Random();
    boolean boo;
    

    TicTacToeGame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Tic Tac Toe");
        setLayout(new BorderLayout());
        setVisible(true);

        
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setText("Tic Tac Toe");
       l1.setFont(new Font("Tahoma",Font.BOLD,50));
     
        p1.setLayout(new BorderLayout());

        p2.setLayout(new GridLayout(3, 3));
 
        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton();
            p2.add(btn[i]);
            btn[i].addActionListener(this);
        }
        
        p1.add(l1);
        add(p1, BorderLayout.NORTH);
        add(p2);

        startGame();
    }

    public void startGame() {

        try {
            l1.setText("Please Wait while Loading....");
            Thread.sleep(3000);
        }
 catch (InterruptedException e)
 {
    System.out.println(e);
        
}
        int r=random.nextInt(100);

        if (r%2 == 0) {
            boo = true;
            l1.setText("X turn");
        } else {
            boo = false;
            l1.setText("O turn");
        }
    }
    public void gameOver(String s){
        flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(f, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            f.dispose();
            new TicTacToeGame();
        }
        else{
            f.dispose();
        }
    
    }

    public void matchCheck() {
        if ((btn[0].getText() == "X") && (btn[1].getText() == "X") && (btn[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        else if ((btn[0].getText() == "X") && (btn[4].getText() == "X") && (btn[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        else if ((btn[0].getText() == "X") && (btn[3].getText() == "X") && (btn[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        else if ((btn[1].getText() == "X") && (btn[4].getText() == "X") && (btn[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        else if ((btn[2].getText() == "X") && (btn[4].getText() == "X") && (btn[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        else if ((btn[2].getText() == "X") && (btn[5].getText() == "X") && (btn[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
       else if ((btn[3].getText() == "X") && (btn[4].getText() == "X") && (btn[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
       else if ((btn[6].getText() == "X") && (btn[7].getText() == "X") && (btn[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
      
        else if ((btn[0].getText() == "O") && (btn[1].getText() == "O") && (btn[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        else if ((btn[0].getText() == "O") && (btn[3].getText() == "O") && (btn[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        else if ((btn[0].getText() == "O") && (btn[4].getText() == "O") && (btn[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        else if ((btn[1].getText() == "O") && (btn[4].getText() == "O") && (btn[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        else if ((btn[2].getText() == "O") && (btn[4].getText() == "O") && (btn[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        else if ((btn[2].getText() == "O") && (btn[5].getText() == "O") && (btn[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((btn[3].getText() == "O") && (btn[4].getText() == "O") && (btn[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((btn[6].getText() == "O") && (btn[7].getText() == "O") && (btn[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        else if(flag==9) {
            l1.setText("Match Tie");
             gameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        btn[x1].setBackground(Color.RED);
        btn[x2].setBackground(Color.RED);
        btn[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            btn[i].setEnabled(false);
        }
        l1.setText("X wins");
        gameOver("X Wins");
    }
public static void main(String args[]){
new  TicTacToeGame(); 

}

    public void oWins(int x1, int x2, int x3) {
        btn[x1].setBackground(Color.RED);
        btn[x2].setBackground(Color.RED);
        btn[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            btn[i].setEnabled(false);
        }
        l1.setText("O Wins");
        gameOver("O Wins");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btn[i]) {
                if (boo) {
                    if (btn[i].getText() == "") {
                        btn[i].setForeground(new Color(255, 0, 0));
                        btn[i].setText("X");
                        btn[i].setFont(new Font("Tahoma",Font.BOLD,80));
              
                        boo = false;

                        l1.setText("O turn");
                        flag++;
                        matchCheck();
                    }
                } else {
                    if (btn[i].getText() == "") {
                        btn[i].setForeground(new Color(0, 0, 255));
                        btn[i].setText("O");
                        btn[i].setFont(new Font("Tahoma",Font.BOLD,80));
                        boo = true;
                        l1.setText("X turn");
                        flag++;
                        matchCheck();
                    }
                }
            }
        }
    }

}