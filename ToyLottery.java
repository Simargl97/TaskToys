import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyLottery {
    private List<Toy> toys = new ArrayList<>();
    private Random random = new Random();

    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void changeWeight(int id, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с указанным ID не найдена.");
    }

    public void drawToys(int numberOfToysToDraw) {
        List<Toy> lotteryPool = new ArrayList<>();
        for (Toy toy : toys) {
            int numTickets = (int) (toy.getWeight() * numberOfToysToDraw / 100);
            for (int i = 0; i < numTickets; i++) {
                lotteryPool.add(toy);
            }
        }

        if (lotteryPool.isEmpty()) {
            System.out.println("Не удалось провести розыгрыш, так как нет игрушек в лотерее.");
            return;
        }

        System.out.println("Розыгрыш " + numberOfToysToDraw + " игрушек:");
        for (int i = 0; i < numberOfToysToDraw; i++) {
            int randomIndex = random.nextInt(lotteryPool.size());
            Toy winningToy = lotteryPool.get(randomIndex);
            System.out.println("Победитель: " + winningToy.getName());
            lotteryPool.remove(randomIndex);
        }
    }

    public void listToys() {
        if (toys.isEmpty()) {
            System.out.println("Список игрушек пуст.");
        } else {
            System.out.println("Список доступных игрушек:");
            for (Toy toy : toys) {
                System.out.println("ID: " + toy.getId());
                System.out.println("Название: " + toy.getName());
                System.out.println("Количество: " + toy.getQuantity());
                System.out.println("Частота выпадения (%): " + toy.getWeight());
                System.out.println("-".repeat(20));
            }
        }
    }
        private List<Toy> createLotteryPool ( int numberOfToysToDraw){
            List<Toy> lotteryPool = new ArrayList<>();
            double totalWeight = 0;

            for (Toy toy : toys) {
                totalWeight += toy.getWeight();
            }

            if (totalWeight == 0) {
                return lotteryPool;
            }

            for (Toy toy : toys) {
                int numTickets = (int) (toy.getWeight() * numberOfToysToDraw / totalWeight);
                for (int i = 0; i < numTickets; i++) {
                    lotteryPool.add(toy);
                }
            }

            return lotteryPool;
        }
    }

