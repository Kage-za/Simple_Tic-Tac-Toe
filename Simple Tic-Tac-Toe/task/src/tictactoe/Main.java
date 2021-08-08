package tictactoe;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Cells:");
        String line = sc.next();
        String[][] inputArray = new String[3][3];
        int countChar = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                inputArray[i][j] = String.valueOf(line.charAt(countChar));
                countChar += 1;
            }

        }
        printGrid(inputArray);

        int Coord[] = UserInput(inputArray);

        inputArray[Coord[0]-1][Coord[1]-1] = "X";

        //printGrid(inputArray);

        printGrid(inputArray);

        analyseGrid(inputArray);
    }

    public static int[] UserInput (String[][] inputArray) {
        Scanner sc = new Scanner(System.in);


            System.out.print("Enter the coordinates:");
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a < 1 || a > 3 || b < 1 || b > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                UserInput(inputArray);
            } else if (inputArray[a - 1][b - 1] == "X" || inputArray[a - 1][b - 1] == "O") {
                System.out.println("This cell is occupied! Choose another one!");
                UserInput(inputArray);
            }
            System.out.println("test line print");
            return new int[]{a, b};
        }

        private static void analyseGrid (String[][]inputArray){
            boolean gameNotFinished = false;
            boolean gameDraw = false;
            boolean gameImpossible = false;
            boolean Xwins = false;
            boolean Owins = false;
            int countX = 0;
            int countO = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (inputArray[i][j]) {
                        case "_":
                            gameNotFinished = true;
                            break;
                        case "X":
                            countX += 1;
                            break;
                        case "O":
                            countO += 1;
                            break;
                    }
                }
            }
            int sum = countO - countX;
            if (sum < -1 || sum > 1) {
                gameImpossible = true;
            }
            //System.out.println(sum);
            if ((inputArray[0][0].equals("X") && inputArray[0][1].equals("X") && inputArray[0][2].equals("X")) || (inputArray[1][0].equals("X") && inputArray[1][1].equals("X") && inputArray[1][2].equals("X")) || (inputArray[2][0].equals("X") && inputArray[2][1].equals("X") && inputArray[2][2].equals("X"))) {
                Xwins = true;
            }
            if ((inputArray[0][0].equals("X") && inputArray[1][0].equals("X") && inputArray[2][0].equals("X")) || (inputArray[0][1].equals("X") && inputArray[1][1].equals("X") && inputArray[2][1].equals("X")) || (inputArray[0][2].equals("X") && inputArray[1][2].equals("X") && inputArray[2][2].equals("X"))) {
                Xwins = true;
            }
            if ((inputArray[0][0].equals("X") && inputArray[1][1].equals("X") && inputArray[2][2].equals("X")) || (inputArray[0][2].equals("X") && inputArray[1][1].equals("X") && inputArray[2][0].equals("X"))) {
                Xwins = true;
            }
            if ((inputArray[0][0].equals("O") && inputArray[0][1].equals("O") && inputArray[0][2].equals("O")) || (inputArray[1][0].equals("O") && inputArray[1][1].equals("O") && inputArray[1][2].equals("O")) || (inputArray[2][0].equals("O") && inputArray[2][1].equals("O") && inputArray[2][2].equals("O"))) {
                Owins = true;
            }
            if ((inputArray[0][0].equals("O") && inputArray[1][0].equals("O") && inputArray[2][0].equals("O")) || (inputArray[0][1].equals("O") && inputArray[1][1].equals("O") && inputArray[2][1].equals("O")) || (inputArray[0][2].equals("O") && inputArray[1][2].equals("O") && inputArray[2][2].equals("O"))) {
                Owins = true;
            }
            if ((inputArray[0][0].equals("O") && inputArray[1][1].equals("O") && inputArray[2][2].equals("O")) || (inputArray[0][2].equals("O") && inputArray[1][1].equals("O") && inputArray[2][0].equals("O"))) {
                Owins = true;
            }
            if (countX + countO == 9 && gameNotFinished) {
                gameDraw = true;
            }

            if (Xwins && Owins) {
                System.out.println("Impossible");
            } else if (gameImpossible) {
                System.out.println("Impossible");
            } else if (Xwins) {
                System.out.println("X wins");
            } else if (Owins) {
                System.out.println("O wins");
            } else if (gameNotFinished) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
            }

        }

        public static void printGrid (String[][]inputArray){
            int countPrint = 0;
            System.out.println(Arrays.toString(inputArray));
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (countPrint == 0 || countPrint == 3 || countPrint == 6) {
                        System.out.print("| " + inputArray[i][j]);
                    } else if (countPrint == 2 || countPrint == 5 || countPrint == 8) {
                        System.out.print(inputArray[i][j] + " |\n");
                    } else {
                        System.out.print(" " + inputArray[i][j] + " ");
                    }
                    countPrint += 1;
                }

            }
            System.out.println("---------");

        }
    }
/* Scanner sc = new Scanner(System.in);
        System.out.print("Enter Cells:");
        String line = sc.next();
        int n = line.length();
        String[] inputArray = new String[n];

        for (int i = 0 ; i < n ; i++) {
            inputArray[i] = Character.toString(line.charAt(i));

       }
        System.out.println(n);
        printGrid(inputArray);
        analyseGrid(inputArray);

    }

    private static void analyseGrid(String[] inputArray) {
        boolean gameNotFinished = false;
        boolean gameDraw = false;
        boolean gameImpossible = false;
        boolean Xwins = false;
        boolean Owins = false;
        int countX = 0;
        int countO = 0;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            switch (inputArray[i]) {
                case "_":
                    gameNotFinished = true;
                    break;
                case "X":
                    countX += 1;
                    break;
                case "O":
                    countO += 1;
                    break;
            }
        }
        sum = countO - countX;
        if (sum < -1 || sum > 1){
            gameImpossible = true;
        }
        System.out.println(sum);
        if ((inputArray[0].equals("X") && inputArray[1].equals("X") && inputArray[2].equals("X")) || (inputArray[3].equals("X") && inputArray[4].equals("X") && inputArray[5].equals("X")) || (inputArray[6].equals("X") && inputArray[7].equals("X") && inputArray[8].equals("X"))) {
            Xwins = true;
        } if ((inputArray[0].equals("X") && inputArray[3].equals("X") && inputArray[6].equals("X")) || (inputArray[1].equals("X") && inputArray[4].equals("X") && inputArray[7].equals("X")) || (inputArray[2].equals("X") && inputArray[5].equals("X") && inputArray[8].equals("X"))) {
            Xwins = true;
        } if ((inputArray[0].equals("X") && inputArray[4].equals("X") && inputArray[8].equals("X")) || (inputArray[2].equals("X") && inputArray[4].equals("X") && inputArray[6].equals("X"))) {
            Xwins = true;
        } if ((inputArray[0].equals("O") && inputArray[1].equals("O") && inputArray[2].equals("O")) || (inputArray[3].equals("O") && inputArray[4].equals("O") && inputArray[5].equals("O")) || (inputArray[6].equals("O") && inputArray[7].equals("O") && inputArray[8].equals("O"))) {
            Owins = true;
        } if ((inputArray[0].equals("O") && inputArray[3].equals("O") && inputArray[6].equals("O")) || (inputArray[1].equals("O") && inputArray[4].equals("O") && inputArray[7].equals("O")) || (inputArray[2].equals("O") && inputArray[5].equals("O") && inputArray[8].equals("O"))) {
            Owins = true;
        } if ((inputArray[0].equals("O") && inputArray[4].equals("O") && inputArray[8].equals("O")) || (inputArray[2].equals("O") && inputArray[4].equals("O") && inputArray[6].equals("O"))) {
            Owins = true;
        } if (countX + countO == 9 && gameNotFinished) {
            gameDraw = true;
        }

        System.out.println(gameNotFinished);
        System.out.println(gameImpossible);
        System.out.println(Xwins);
        System.out.println(Owins);


        if (Xwins && Owins) {
                System.out.println("Impossible");
                } else if ( gameImpossible) {
                System.out.println("Impossible");
                } else if (Xwins){
                System.out.println("X wins");
                } else if (Owins) {
                System.out.println("O wins");
                } else if (gameNotFinished) {
                System.out.println("Game not finished");
                } else {
                System.out.println("Draw");
                }

                }

public static void printGrid(String[] inputArray) {

        System.out.println(Arrays.toString(inputArray));
        System.out.println("---------");
        for (int i = 0; i < 9; i++ ) {
        if ( i == 0 || i == 3 || i == 6) {
        System.out.print("| " + inputArray[i]);
        } else if ( i == 2 || i == 5 || i == 8) {
        System.out.print(inputArray[i] + " |\n");
        } else {
        System.out.print(" " + inputArray[i] + " ");
        }


        }
        System.out.println("---------");

        }
        */