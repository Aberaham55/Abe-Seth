package Data;

import java.util.Scanner;

public class utils {


        private Scanner scanner;
        public int getString;

        public void Input() {
            this.scanner = new Scanner(System.in);
        }

        public String getString() {
            return scanner.nextLine();
        }

        public boolean yesNo() {
            String input = scanner.next();
            return input.equalsIgnoreCase("yes") || input.equals("y");
        }

        public int getInt(int min, int max) {
            int input = 0;
            do {
                String inputStr = getString();
                try {
                    input= Integer.valueOf(inputStr);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input Enter a Integer.");
                }

            } while (input < min || input > max);
            return input;
        }

        public int getInt() {
            return scanner.nextInt();
        }

        public double getDouble(double min, double max) {
            double input = Double.NaN;
            do {
                String inputStr = getString();
                try {
                    input = Double.valueOf(inputStr);
                }  catch (NumberFormatException e) {
                    System.out.println("Invalid Input. Enter a double.");
                    continue;
                }
//            scanner.nextLine();
            } while (input < min || input > max);
            return input;
        }

        public double getDouble() {
            return getString;
        }
    }



