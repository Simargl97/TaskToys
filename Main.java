import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyLottery toyLottery = new ToyLottery();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nКоманды:");
            System.out.println("1. Добавить новую игрушку");
            System.out.println("2. Изменить вес игрушки");
            System.out.println("3. Провести розыгрыш");
            System.out.println("4. Вывести список игрушек");
            System.out.println("5. Выйти из программы");

            int choice = getValidInput(scanner, 1, 5);

            switch (choice) {
                case 1:
                    System.out.print("ID игрушки: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Название игрушки: ");
                    String name = scanner.nextLine();
                    System.out.print("Количество: ");
                    int quantity = getValidInput(scanner, 0, Integer.MAX_VALUE);
                    System.out.print("Частота выпадения (%): ");
                    double weight = getValidDoubleInput(scanner, 0, 100);
                    toyLottery.addToy(id, name, quantity, weight);
                    break;
                case 2:
                    System.out.print("Введите ID игрушки, чей вес нужно изменить: ");
                    int toyId = scanner.nextInt();
                    System.out.print("Новый вес игрушки (%): ");
                    double newWeight = getValidDoubleInput(scanner, 0, 100);
                    toyLottery.changeWeight(toyId, newWeight);
                    break;
                case 3:
                    System.out.print("Сколько игрушек нужно розыграть: ");
                    int numberOfToysToDraw = getValidInput(scanner, 1, Integer.MAX_VALUE);
                    toyLottery.drawToys(numberOfToysToDraw);
                    break;
                case 4:
                    toyLottery.listToys();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
    private static int getValidInput(Scanner scanner, int min, int max) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Введите число от " + min + " до " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число.");
            }
        }
    }
    private static double getValidDoubleInput(Scanner scanner, double min, double max) {
        double input;
        while (true) {
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Введите число от " + min + " до " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число.");
            }
        }
    }
}