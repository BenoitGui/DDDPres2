package xavier.blanc.ddd.presentation.DDDPRES;

public class Match {
    private Player player1, player2;
	private int idMatch; 
    private boolean isStarted, isClosed;
    private int score1, score2;

    public Match(Player player1, Player player2, int idMatch) {
        setPlayer(1, player1);
        setPlayer(2, player2);
		this.idMatch = idMatch; 
        this.score1 = 0;
        this.score2 = 0;
        this.isStarted = false;
        this.isClosed = false;
		
    }

    public void updateScorePlayer1(int score) {
        setScore(1, score);
    }

    public void updateScorePlayer2(int score) {
        setScore(2, score);
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void start() {
        if (isStarted || isClosed) {
            throw new ChampionshipException("already started or closed");
        }
        isStarted = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void close() {
        if (!isStarted) {
            throw new ChampionshipException("Match is not started");
        }
        isClosed = true;
    }

    public Player[] TwoPlayers() {
        return new Player[]{player1, player2};
    }

    public boolean isDraw() {
        if (!isClosed) {
            throw new ChampionshipException("Match still open");
        }
        return score1 == score2;
    }
	public int Id () {
		return this.idMatch; 
	}
    public Player Winner() {
        if (!isClosed) {
            throw new ChampionshipException("Match still open");
        }
        if (isDraw()) {
            throw new ChampionshipException("No winner");
        }
        if (score1 >= score2) {
            return player1;
        } else {
            return player2;
        }
    }

    private void setScore(int number, int score) {
        if (!isStarted) {
            throw new ChampionshipException("match not started");
        }
        if (isClosed) {
            throw new ChampionshipException("match is closed");
        }
        if (score < 0) {
            throw new IllegalArgumentException("Score must be greater than 0");
        }
        switch (number) {
            case 1 : score1 = score;
                    break;
            case 2 : score2 = score;
                    break;
            default:
        }
    }

    private void setPlayer(int number, Player player) {
        if (player == null) {
            String msg = "player" + number + " cannot be null";
            throw new IllegalArgumentException(msg);
        }
        switch (number) {
            case 1 : player1 = player;
                    break;
            case 2 : player2 = player;
                    break;
            default:
        }
    }
}