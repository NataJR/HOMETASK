

import java.util.Random;
import java.util.Scanner;


    public class Tick_Tack_Toe {
        public static final String USER_PLACE = "X";
        public static final String AI_PLACE = "O";
        public static final String EMPTY_FIELD = " ";
        public static int aiLevel = 0;
        public static final int DIMENSION = 5;
        public static String[][] field = new String[DIMENSION][DIMENSION];

        public static void main(String[] args) {
            System.out.println("YOU WILL PLAY WITH ARTIFICIAL INTELLIGENCE.");
            int i = 0;
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
                    aiLevel();
        }



        private static boolean valid(int y, int x) {
            if (x < 0 || y < 0 || x > DIMENSION - 1 || y > DIMENSION - 1) {
                return false;
            }
            return field[y][x] == EMPTY_FIELD;
        }



        public static void initField() {
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    field[i][j] = EMPTY_FIELD;
                }
            }
        }

        public static void printField() {
            for (int i = 0; i <= DIMENSION; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < DIMENSION; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < DIMENSION; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void modeAgainstAI() {
            int count = 0;
            initField();
            while (true) {
                printField();
                userShot(USER_PLACE, 0);
                count++;
                if (checkWin(USER_PLACE)) {
                    System.out.println("USER WIN!!!");
                    printField();
                    break;
                }
                aiShot();
                count++;
                if (checkWin(AI_PLACE)) {
                    System.out.println("AI WIN!!!");
                    printField();
                    break;
                }
                if (count == Math.pow(DIMENSION, 2)) {
                    printField();
                    break;
                }
            }
        }




        public static void aiLevel() {

            int i = 0;
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            aiLevel = 1;
            modeAgainstAI();

        }

        public static void userShot(String sign, int i) {
            int x = -1;
            int y = -1;
            do {
                if (i == 0) {
                    System.out.println("Enter  x y coordinates (1 - " + DIMENSION + "): ");
                } else {
                    System.out.println();
                }
                Scanner sc = new Scanner(System.in);
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            }
            while (isFieldBusy(x, y));
            field[x][y] = sign;
        }

        public static void aiShot() {
            int x = -1;
            int y = -1;
            boolean ai_win = false;
            boolean user_win = false;
            // Находим выигрышный ход
            if (aiLevel == 2) {
                for (int i = 0; i < DIMENSION; i++) {
                    for (int j = 0; j < DIMENSION; j++) {
                        if (!isFieldBusy(i, j)) {
                            field[i][j] = AI_PLACE;
                            if (checkWin(AI_PLACE)) {
                                x = i;
                                y = j;
                                ai_win = true;
                            }
                            field[i][j] = EMPTY_FIELD;
                        }
                    }
                }
            }

            if (aiLevel > 0) {
                if (!ai_win) {
                    for (int i = 0; i < DIMENSION; i++) {
                        for (int j = 0; j < DIMENSION; j++) {
                            if (!isFieldBusy(i, j)) {
                                field[i][j] = USER_PLACE;
                                if (checkWin(USER_PLACE)) {
                                    x = i;
                                    y = j;
                                    user_win = true;
                                }
                                field[i][j] = USER_PLACE;
                            }
                        }
                    }
                }
            }
            if (!ai_win && !user_win) {
                do {
                    Random rnd = new Random();
                    x = rnd.nextInt(DIMENSION);
                    y = rnd.nextInt(DIMENSION);
                }
                while (isFieldBusy(x, y));
            }
            field[x][y] = AI_PLACE;
            System.out.println("x = " + x + "| y = " + y + "| ai_win = " + ai_win + "| user_win = " + user_win);
        }



        public static boolean isFieldBusy(int x, int y) {
            if (x < 0 || y < 0 || x > DIMENSION - 1 || y > DIMENSION - 1) {
                return false;
            }
            return field[x][y] != EMPTY_FIELD;
        }





        public static boolean checkWin(String sign) {

            {
                for (int i = 0; i < DIMENSION; i++) {
                    if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign && field[i][3] == sign && field[i][4]== sign) {
                        return true;
                    }
                }
            }

            {
                for (int j = 0; j < DIMENSION; j++) {
                    if (field[0][j] == sign && field[1][j] == sign && field[2][j] == sign && field[3][j] == sign && field[4][j] == sign) {
                        return true;
                    }
                }
            }

            {
                if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign && field[3][3] == sign && field[4][4] == sign) {
                    return true;
                }
                if (field[0][1] == sign && field[1][2] == sign && field[2][2] == sign && field[2][1] == sign && field[2][0] == sign) {
                    return true;
                }
            }
            return false;
        }


//есть решение по проверке с вводом коэффициента, суть его ясна на бумаге, в коде в принципе тоже, но мозгом мне не дойти,
//поэтому я его прилагаю, и если будет время на уроке, если того стоит, то было интересно Вас послушать по этому поводу.
// Я с этим заданием пролазила на пузе все пособия и все материалы в инете, без хвальбы, но Ваш код самый лаконичный
// и понятный. Взяла на себя смелость представить еще один код, некий симбиоз Вашего и еше одного, что захватил внимание
//своим смыслом здравым и "простотой" изложения, только я, видимо, криво "пересказываю" заученный материал, он у меня так
//криво работает - стыдоба. время 05:40 утра. вставать через 3 часа. я сдаюсь. простите, но это все, на что я способна.

        public static boolean checkLine(int start_x, int start_y, int dx, int dy, String sign) {
            for (int i = 0; i < DIMENSION; i++) {
                if (field[start_x + i * dx][start_y + i * dy] != sign)
                    return false;
            }
            return true;
        }


        public static boolean checkWin2(String sign) {
            for (int i = 0; i < DIMENSION; i++) {

                if (checkLine(i, 0, 0, 1, sign)) return true;

                if (checkLine(0, i, 1, 0, sign)) return true;
            }

            if (checkLine(0, 0, 1, 1, sign)) return true;
            if (checkLine(0, DIMENSION - 1, 1, -1, sign)) return true;
            return false;
        }
    }