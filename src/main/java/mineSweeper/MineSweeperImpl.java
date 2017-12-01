package mineSweeper;

public class MineSweeperImpl implements MineSweeper {
    private static final String END_OF_ROW = "\n";
    private static final int MINE_VALUE = -1;
    private static final char MINE = '*';
    private int[][] board;
    private int xSize;
    private int ySize;

    public void setMineField(String mineField) throws IllegalArgumentException {
        if(!mineField.matches("([*.]+)(\n[*.]+)*")){
            throw new IllegalArgumentException("Invalid mine-field format.");
        }

        parseMineField(mineField);

        createHintField();
    }

    private void parseMineField(String mineField) {
        String[] rows = mineField.split(END_OF_ROW);
        ySize = rows.length;
        xSize = rows[0].length();

        for(String row : rows){
            if(row.length() != xSize){
                throw new IllegalArgumentException("Invalid mine-field format. Mine-field is not rectangular.");
            }
        }

        board = new int[xSize][ySize];

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (rows[y].charAt(x) == MINE) {
                    board[x][y] = MINE_VALUE;
                }
            }
        }
    }

    private void createHintField() {
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if(isMine(board[x][y])){
                    increaseAdjecentFieldsHintCounterForMineAt(x,y);
                }
            }
        }
    }

    private void increaseAdjecentFieldsHintCounterForMineAt(int mineX, int mineY) {
        for (int k = -1; k <= 1; k++) {
            int y = mineY + k;
            for (int l = -1; l <= 1; l++) {
                int x = mineX + l;
                try {
                    if (!isMine(board[x][y])){
                        board[x][y]++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                    //Tried to get not existing board position.
                    //Alternatively, we can check x,y before accessing board[][]
                }
            }
        }
    }

    private boolean isMine(int i) {
        return i == MINE_VALUE;
    }



    public String getHintField() throws IllegalStateException {

        if(board == null){
            throw new IllegalStateException("Mine-field has not been initialised. Call setMineField() first.");
        }

        StringBuilder hintBoardBuilder = new StringBuilder();

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (isMine(board[x][y])) {
                    hintBoardBuilder.append(MINE);
                } else {
                    hintBoardBuilder.append(board[x][y]);
                }
            }
            if (y < ySize - 1) {
                hintBoardBuilder.append(END_OF_ROW);
            }
        }

        return hintBoardBuilder.toString();
    }
}
