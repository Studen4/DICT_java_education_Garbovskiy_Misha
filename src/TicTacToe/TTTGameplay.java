package TicTacToe;

class TTTGameplay {
    private final TTTBoard board;
    private final TTTPlayers players;

    public TTTGameplay() {
        this.board = new TTTBoard();
        this.players = new TTTPlayers();
    }

    public void startGame() {
        board.printBoard();

        while (true) {
            int[] move = TTTVisual.getPlayerMove();
            if (isValidMove(move)) {
                makeMove(move);
                board.printBoard();
                if (checkWin()) {
                    TTTVisual.printMessage(players.getCurrentPlayer() + " wins");
                    break;
                } else if (isBoardFull()) {
                    TTTVisual.printMessage("It's a draw!");
                    break;
                }
                players.switchPlayer();
            }
        }
    }

    private boolean isValidMove(int[] move) {
        int row = move[0];
        int col = move[1];

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            TTTVisual.printMessage("Coordinates should be from 1 to 3!");
            return false;
        }

        if (board.getCell(row, col) != ' ') {
            TTTVisual.printMessage("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }

    private void makeMove(int[] move) {
        int row = move[0];
        int col = move[1];
        char currentPlayer = players.getCurrentPlayer();
        board.setCell(row, col, currentPlayer);
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }

        return checkDiagonals();
    }

    private boolean checkRow(int row) {
        return (board.getCell(row, 0) != ' ' && board.getCell(row, 0) == board.getCell(row, 1) &&
                board.getCell(row, 1) == board.getCell(row, 2));
    }

    private boolean checkColumn(int col) {
        return (board.getCell(0, col) != ' ' && board.getCell(0, col) == board.getCell(1, col) &&
                board.getCell(1, col) == board.getCell(2, col));
    }

    private boolean checkDiagonals() {
        return (board.getCell(0, 0) != ' ' && board.getCell(0, 0) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 2)) ||
                (board.getCell(0, 2) != ' ' && board.getCell(0, 2) == board.getCell(1, 1) &&
                        board.getCell(1, 1) == board.getCell(2, 0));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i, j) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
