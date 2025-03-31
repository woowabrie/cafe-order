package techcourse;

public class CafeOrder {
    public static int calculateTotalPrice(String[] items, int[] quantities) {
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            int price = 0;
            if (items[i].equals("아메리카노")) {
                price = 1200;
            } else if (items[i].equals("라떼")) {
                price = 2000;
            } else if (items[i].equals("모카")) {
                price = 2500;
            } else if (items[i].equals("크로와상")) {
                price = 3000;
            }
            total += price * quantities[i];
        }

        int drinkCount = 0;
        for (int i = 0; i < items.length; i++) {
            if (!items[i].equals("크로와상")) {
                drinkCount += quantities[i];
            }
        }

        if (drinkCount >= 5) {
            int drinkTotal = 0;
            for (int i = 0; i < items.length; i++) {
                if (!items[i].equals("크로와상")) {
                    int drinkPrice = 0;
                    if (items[i].equals("아메리카노")) {
                        drinkPrice = 1200;
                    } else if (items[i].equals("라떼")) {
                        drinkPrice = 2000;
                    } else if (items[i].equals("모카")) {
                        drinkPrice = 2500;
                    }
                    drinkTotal += drinkPrice * quantities[i];
                }
            }
            total -= drinkTotal / 10;
        }

        return total;
    }
}
