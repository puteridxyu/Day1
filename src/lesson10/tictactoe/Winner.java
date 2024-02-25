package lesson10.tictactoe;

public class Winner {

    private int id;
    private String token;
    private int playerMode;
    private int dimension;

    public Winner(int id, String token, int playerMode, int dimension) {

        this.id = id;
        this.token = token;
        this.playerMode = playerMode;
        this.dimension = dimension;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setPlayerMode(int playerMode) {
        this.playerMode = playerMode;
    }

    public int getPlayerMode() {
        return playerMode;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
