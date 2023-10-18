package ad221.Ivanova;

public class ShoppingCartApp {

    public static void main(String[] args) {
        // Создаем объект корзины с максимальным количеством элементов
        ShoppingCart cartUsingQueue = new ShoppingCart(10);

        // Добавляем товары в корзину
        cartUsingQueue.addItem(new Product("Product1", 10.0f));
        cartUsingQueue.addItem(new Product("Product2", 15.0f));
        cartUsingQueue.addItem(new Product("Product3", 20.0f));
        cartUsingQueue.addItem(new Product("Product4", 25.0f));
        cartUsingQueue.addItem(new Product("Product5", 30.0f));

        // Выводим сумму цен товаров в корзине
        float totalPriceUsingQueue = cartUsingQueue.calculateTotalPrice();
        System.out.println("Сумма цен товаров в корзине: " + totalPriceUsingQueue);

        // Увеличиваем цены в корзине на 15%
        cartUsingQueue.increasePrices(15);

        // Выводим измененную сумму цен
        float newTotalPriceUsingQueue = cartUsingQueue.calculateTotalPrice();
        System.out.println("Измененная сумма цен после увеличения цен на 15%: " + newTotalPriceUsingQueue);

        // Уменьшаем цены в корзине на 30%
        cartUsingQueue.decreasePrices(30);

        // Выводим измененную сумму цен
        float finalTotalPriceUsingQueue = cartUsingQueue.calculateTotalPrice();
        System.out.println("Измененная сумма цен после уменьшения цен на 30%: " + finalTotalPriceUsingQueue);
    }
}

class Product {
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public void increasePrice(float percent) {
        if (percent > 0) {
            price += price * (percent / 100);
        }
    }

    public void decreasePrice(float percent) {
        if (percent > 0) {
            price -= price * (percent / 100);
            if (price < 0) {
                price = 0;
            }
        }
    }

    public float getPrice() {
        return price;
    }
}

class ShoppingCart {
    private Queue<Product> products;
    private int maxSize;

    public ShoppingCart(int maxSize) {
        this.maxSize = maxSize;
        products = new ArrayDeque<>();
    }

    public void addItem(Product product) {
        if (products.size() < maxSize) {
            products.offer(product);
        } else {
            System.out.println("Корзина заполнена. Невозможно добавить больше товаров.");
        }
    }

    public void removeItem() {
        if (!products.isEmpty()) {
            products.poll();
        } else {
            System.out.println("Корзина пуста. Невозможно удалить товар.");
        }
    }

    public float calculateTotalPrice() {
        float total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void increasePrices(float percent) {
        for (Product product : products) {
            product.increasePrice(percent);
        }
    }

    public void decreasePrices(float percent) {
        for (Product product : products) {
            product.decreasePrice(percent);
        }
    }
}
