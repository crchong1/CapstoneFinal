public class Player
{
    // 0 if nothing, 1 if player, 2 if computer
    private int gameState;

    public Player(int state)
    {
        this.gameState = state;
    }
    public int getPlayer()
    {
        return gameState;
    }
    public void changePlayer()
    {
        if(this.gameState == 1)
        {
            this.gameState = 2;
        }
        else  if(this.gameState == 2)
        {
            this.gameState = 1;
        }
        else
        {
            
        }
    }
}