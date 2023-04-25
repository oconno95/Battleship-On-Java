package battleship;

public abstract class Player {
    public static final int PLACING_DESTROYER = 0;
    public static final int PLACING_CRUISOR = 1;
    public static final int PLACING_SUBMARINE = 2;
    public static final int PLACING_BATTLESHIP = 3;
    public static final int PLACING_CARRIER = 4;
    public static final int PLAYING_GAME = 5;

    private Grid grid;
    protected String name = "Default Player";
    protected int state = PLACING_DESTROYER;
    protected String currentMessage = "";

    public Player() {
        grid = new Grid();
    }

    public int getState() {return state;}
    public String getCurrentMessage() {return this.currentMessage;}

    public void reset() {
        this.grid.reset();
    }

    public Grid getGrid() {
        return grid;
    }

    public int fireAt(Player p) {
        int[] fireLocation = this.getLocationToFireAt(p.getGrid());
        return p.getGrid().guessPositon(fireLocation[0], fireLocation[1]);
    }

    public boolean lostAllShips() {
        return this.grid.isAllShipsDestroyed();
    }

    public void useMissMessage() {
        this.currentMessage = this.name + " has missed.";
    }

    public void useHitMessage() {
        this.currentMessage = this.name + " has hit a ship.";
    }

    public void useSunkMessage() {
        this.currentMessage = this.name + " has sunk a ship.";
    }

    public void useWinMessage() {
        this.currentMessage = this.name + " has won the game.";
    }

    public void useInvalidShotMessage() {
        this.currentMessage = this.name + " has made an invalid move, try again!";
    }


    public abstract int[] getLocationToFireAt(Grid enemyGrid);
    public abstract boolean placeDestroyer();
    public abstract boolean placeCruiser();
    public abstract boolean placeSubmarine();
    public abstract boolean placeBattleship();
    public abstract boolean placeCarrier();

}