import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;


public class TicTacToe
{
    /** description of instance variable x (add comment for each instance variable) */
    private int width = 3;
    private int height = 3;
    static final char EMPTY = ' ';
    static final char PLAYER_X = 'x';
    static final char PLAYER_O = 'o';
    private int[][] game;
    private int turn = 0;
    private Player player;
    private int bestScore = -10000;
    private int score = -10000;
    private GUI panel;
    /**
     * Default constructor for objects of class TicTacToe
     */
    public TicTacToe()
    {
        this.game = new int[width][height];                // sets width and height of array
        for(int i = 0; i< this.game.length;i++)
        {
            for(int j = 0; j < this.game[0].length; j++)
            {
                // initializes game to 0
                this.game[i][j] = 0;
            }
        }
        System.out.println("game start" );
        this.player = new Player(1);
        GUI panel = new GUI();
        this.panel = panel;
        boolean infinite = false;
        while(infinite==false) // while game is not won or no available moves (getMoves(this.game).size()==0) isWon() || (getMoves(this.game).size()==0)
        {
            if(player.getPlayer() == 1)
            {
                Scanner scan = new Scanner(System.in);
                System.out.println("enter x coordinate from 0 to 2");
                int x = scan.nextInt();
                System.out.println("enter y coordinate from 0 to 2");
                int y = scan.nextInt();
                this.game[x][y] = 1;
                panel.updateGUI(this.game);
                //displayBoard();
                player.changePlayer();
            }
            if(player.getPlayer() == 2) // if computers turn
            {
                ArrayList<Moves> weightedMoves = new ArrayList<Moves>();
                int [][] gameCopy = new int[this.game.length][this.game[0].length];
                for(int i = 0; i< this.game.length;i++)
                {
                    for(int j = 0; j < this.game[0].length; j++)
                    {
                        gameCopy[i][j]=this.game[i][j];
                    }
                } // copies this.game into a copy
                for (int i = 0; i< getMoves(gameCopy).size(); i++)
                {
                    Moves newMove = new Moves(getMoves(gameCopy).get(i).getX(), getMoves(gameCopy).get(i).getY(), minimax(1, player, gameCopy));
                    weightedMoves.add(newMove);
                } //returns minimax score for each possible move
                for(int i = 0; i< weightedMoves.size(); i++)
                {
                    for (int j = 1; j < weightedMoves.size() - i; j++)
                    {
                        if(weightedMoves.get(j-1).getScore() < weightedMoves.get(j).getScore())
                        {
                            weightedMoves.add(j-1, weightedMoves.remove(j));
                        } //sorts weightedMoves from highest score to lowest score
                    }
                }
                this.game[weightedMoves.get(0).getX()][weightedMoves.get(0).getY()] = 2; //AI will make the weighted move with highest score
                panel.updateGUI(this.game);
                //displayBoard();
                player.changePlayer();
            }
        }
    
   }
    
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
    }
    
    public int whoWon()
    {
        for(int i = 1; i <game.length; i++)
        {
            if(this.game[i][0] == this.game[i][1] && this.game[i][0] == this.game[i][2])
            {
                return this.player.getPlayer();
            }
            if(this.game[0][i] == this.game[1][i] && this.game[0][i] == this.game[2][i])
            {
                return this.player.getPlayer();
            }
            if(this.game[0][0] == this.game[1][1] && this.game[0][0] == this.game[2][2])
            {
                return this.player.getPlayer();
            }
            if(this.game[2][0] == this.game[1][1] && this.game[2][0] == this.game[0][2])
            {
                return this.player.getPlayer();
            }
            else
            {
                return -1; // no one won
            }
        }
        return -1;
    }
    public boolean isWon()
    {
        if(whoWon() > 0)
        {
            return true;
        }
        else
        {
            return false; // no one won
        }
    }
    public boolean isBoardFull() 
    {
        boolean isFull = true;
        for (int i = 0; i < game.length; i++) 
        {
            for (int j = 0; j < game[0].length; j++) 
            {
                if (game[i][j] == 0) 
                {
                    isFull = false;
                }
            }
        }       
        return isFull;
    }
    
    
    public int[][] makeMove(Moves move, Player player, int[][] game)
    {
        game[move.getX()][move.getY()] = player.getPlayer();
        return game;
    }
    
    public void setPlayerMove(int x, int y)
    {
        this.game[x][y] = 1;
    }
    
    public ArrayList<Moves> getMoves( int[][] game)
    {
        int xpos = 0;
        int ypos = 0;
        ArrayList<Moves> moves = new ArrayList<Moves>();
        for(int i = 0; i < game.length; i++)
        {
            for (int j = 0; j < game[i].length; j++)
            {
                if (game[i][j] == 0)
                {
                    Moves openMove = new Moves(i,j);
                    moves.add(openMove);
                }
            }
        }
        return moves;
    }
    
    public Player returnChangePlayer(Player player)
    {
        player.changePlayer();
        return player;
    }
    public int minimax(int level, Player player, int[][] game) // we are trying to maximize the score for the AI
    {
        if (isWon() || isBoardFull() || level == 100)
        {
            if (whoWon() == 1) // if player
            {
                return -1000; // if player wins, then score is reduced by 1000
            }
            else if(whoWon() == 2) // if AI
            {
                return 1000; // if computer wins, then score is increased by 1000
            }
            else
            {
                return 0;
            }
        }
        for(int i = 0; i < getMoves(game).size(); i++)
        {
              int score=0;
              score += minimax(level + 1, returnChangePlayer(player), makeMove(getMoves(game).get(i), player, game));
        }     
        return score;
    }

    
    
    
     public void displayBoard() 
    {
        System.out.println("  0  " + toChar(0,0) + "|" + toChar(0,1) + "|" + toChar(0,2));
        System.out.println("    --+-+--");
        System.out.println("  1  " + toChar(1,0) + "|" + toChar(1,1) + "|" + toChar(1,2));
        System.out.println("    --+-+--");
        System.out.println("  2  " + toChar(2,0) + "|" + toChar(2,1) + "|" + toChar(2,2));
        System.out.println("     0 1 2 ");
    }
    public char toChar(int xPos, int yPos)
    {
        if(this.game[xPos][yPos] == 0)
        {
            return ' ';
        }
        if(this.game[xPos][yPos] == 1)
        {
            return 'x';
        }
        if(this.game[xPos][yPos] == 2)
        {
            return 'o';
        }
        
        return 'c';
    }
    
}