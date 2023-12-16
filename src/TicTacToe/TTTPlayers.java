package TicTacToe;


class TTTPlayers {
    private char currentPlayer;

    public TTTPlayers() {
        this.currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
