public class Options {

    private final int REGULAR_RULES = 1;
    private final int VEGAS_RULES = 2;
    private int gameType;

    public Options(int gameType) {
        this.gameType = gameType;
    }
}
