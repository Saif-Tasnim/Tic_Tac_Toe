package TicTacToe;

import java.util.*;

public class Main {
    static ArrayList<Integer> playerPos = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPos = new ArrayList<Integer>();

    static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = 'X';

        if (user.equals("Player")) {
            symbol = 'X';
            //playerPos.add(pos);
        } else if (user.equals("CPU")) {
            symbol = 'O';
            //cpuPos.add(pos);
        }

        switch (pos) {
            case 1: {
                gameBoard[0][0] = symbol;
                break;
            }
            case 2: {
                gameBoard[0][2] = symbol;
                break;
            }
            case 3: {
                gameBoard[0][4] = symbol;
                break;
            }
            case 4: {
                gameBoard[2][0] = symbol;
                break;
            }
            case 5: {
                gameBoard[2][2] = symbol;
                break;
            }
            case 6: {
                gameBoard[2][4] = symbol;
                break;
            }
            case 7: {
                gameBoard[4][0] = symbol;
                break;
            }
            case 8: {
                gameBoard[4][2] = symbol;
                break;
            }
            case 9: {
                gameBoard[4][4] = symbol;
                break;
            }
            default:
                break;
        }
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List lastRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List dig1 = Arrays.asList(1, 5, 9);
        List dig2 = Arrays.asList(3, 5, 7);

        List<List> winnigCon = new ArrayList<List>();
        winnigCon.add(topRow);
        winnigCon.add(midRow);
        winnigCon.add(lastRow);
        winnigCon.add(leftCol);
        winnigCon.add(midCol);
        winnigCon.add(rightCol);
        winnigCon.add(dig1);
        winnigCon.add(dig2);

        for (List l : winnigCon) {

            if (playerPos.containsAll(l)) {
                return "Congratulations!!! You Won..!!";

            } else if (cpuPos.containsAll(l)) return "CPU Wins!!! You lost the match.Better luck next time";

            else if (playerPos.size() + cpuPos.size() == 9)
                return "Match is tied.. Draw !!!!";


        }
        return " ";
    }


    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '},};
        String result;

        printGameBoard(gameBoard);

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Your Position from (1-9)");
            int userPosition = input.nextInt();
            /*while (playerPos.contains(userPosition) || cpuPos.contains(playerPos)) {
                System.out.println("Position is taken.Enter a correct position");
                userPosition = input.nextInt();
            }


             */

            placePiece(gameBoard, userPosition, "Player");

            Random rand = new Random();
            int cpuPosition = rand.nextInt(9) + 1;
            while (playerPos.contains(cpuPosition) || cpuPos.contains(cpuPosition)) {
                cpuPosition = rand.nextInt(9) + 1;
            }

            placePiece(gameBoard, cpuPosition, "CPU");

            printGameBoard(gameBoard);

            result = checkWinner();
            System.out.println(result);

        }
    }


}


