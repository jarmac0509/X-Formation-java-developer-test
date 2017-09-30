package mineSweeper;

public class Main {

    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeperImpl();
        String mineField =
                "*...**.\n"+
                "..*..*.\n"+
                "....*..\n"+
                ".*.*..*"
                ;
        mineSweeper.setMineField(mineField);

        System.out.println("Actual map:\n\n" + mineField);

        System.out.println("\nHint map:\n\n" + mineSweeper.getHintField());
    }
}
