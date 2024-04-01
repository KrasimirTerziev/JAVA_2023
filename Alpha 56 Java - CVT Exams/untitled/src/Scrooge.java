 import java.util.Scanner;

    public class Scrooge {

        private static int[][] labyrinth;
        private static int rows;
        private static int columns;
        private static int coinsCollected;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            rows = scanner.nextInt();
            columns = scanner.nextInt();

            labyrinth = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    labyrinth[i][j] = scanner.nextInt();
                }
            }

            findExit();

            System.out.println(coinsCollected);
        }

        private static void findExit() {
            int currentRow = 0;
            int currentColumn = 0;

            while (true) {
                int nextRow = -1;
                int nextColumn = -1;
                int maxCoins = 0;

                // Check for possible moves.
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nextRowCandidate = currentRow + i;
                        int nextColumnCandidate = currentColumn + j;

                        if (isValidMove(nextRowCandidate, nextColumnCandidate)) {
                            int coinsInCell = labyrinth[nextRowCandidate][nextColumnCandidate];

                            if (coinsInCell > maxCoins) {
                                maxCoins = coinsInCell;
                                nextRow = nextRowCandidate;
                                nextColumn = nextColumnCandidate;
                            } else if (coinsInCell == maxCoins) {
                                // Prefer left, right, up, down order.
                                if (nextRowCandidate == currentRow && j == 1) {
                                    nextRow = nextRowCandidate;
                                    nextColumn = nextColumnCandidate;
                                } else if (nextColumnCandidate == currentColumn && i == 1) {
                                    nextRow = nextRowCandidate;
                                    nextColumn = nextColumnCandidate;
                                } else if (nextRowCandidate == currentRow && j == -1) {
                                    nextRow = nextRowCandidate;
                                    nextColumn = nextColumnCandidate;
                                } else if (nextColumnCandidate == currentColumn && i == -1) {
                                    nextRow = nextRowCandidate;
                                    nextColumn = nextColumnCandidate;
                                }
                            }
                        }
                    }
                }

                // Collect coins and move to the next cell.
                coinsCollected += labyrinth[nextRow][nextColumn];
                labyrinth[nextRow][nextColumn] = 0;
                currentRow = nextRow;
                currentColumn = nextColumn;

                // Check if we are surrounded by empty cells.
                if (isSurroundedByEmptyCells(currentRow, currentColumn)) {
                    break;
                }
            }
        }

        private static boolean isValidMove(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }

        private static boolean isSurroundedByEmptyCells(int row, int column) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nextRow = row + i;
                    int nextColumn = column + j;

                    if (isValidMove(nextRow, nextColumn) && labyrinth[nextRow][nextColumn] > 0) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

