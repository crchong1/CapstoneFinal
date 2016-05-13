// 
public class Minimax
{
    private final Board board;
    private int column;
    private int boardsAnalyzed;
    private int maxDepth;
    private boolean redWinFound;
    private boolean blackWinFound;
    
    
    public Minimax(Board board, int maxDepth) 
    {
        this.board = board; 
        this.boardsAnalyzed = 0;
        this.maxDepth = maxDepth; //caps the board so that the computer does not take like a year to play
    }

    public int getBoardsAnalyzed() 
    {
        return boardsAnalyzed;
    }
    
    public int evaluateBest(Player player)
    {
        redWinFound = false;
        blackWinFound = false;
        
        if(player.getPlayer()== 1) // computer
        {
            
        }
    }
    public int blackEvaluate(int depth, int maxDepth, int col, int min, int max)
    {
        this.boardsAnalyzed ++;
        
    }
}
