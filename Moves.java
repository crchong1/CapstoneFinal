
public class Moves
{
    private int x;
    private int y;
    private int score;
    
    public Moves(int xPos, int yPos)
    {
        this.x = xPos;
        this.y = yPos;
    }
    public Moves(int xPos, int yPos, int score)
    {
        this.x = xPos;
        this.y = yPos;
        this.score = score;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public int getScore()
    {
        return this.score;
    }
}
