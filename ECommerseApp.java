import java.util.Scanner;

class Order {
    int productId;
    String productName;
    int quantity;
    double price;

   
    Order() {
        productId = 0;
        productName = "Not Defined";
        quantity = 0;
        price = 0;
    }

   
    Order(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }

    double calculateTotal() {
        return quantity * price;
    }

    double calculateDiscount(double total) {
        if (total >= 5000)
            return total * 0.10;   
        else if (total >= 3000)
            return total * 0.05;   
        else
            return 0;
    }

    void generateInvoice() {
        double total = calculateTotal();
        double discount = calculateDiscount(total);
        double finalAmount = total - discount;

        System.out.println("\n----- INVOICE -----");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : " + price);
        System.out.println("Total Amount : " + total);
        System.out.println("Discount     : " + discount);
        System.out.println("Payable Amt  : " + finalAmount);
    }
}

public class ECommerceApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        sc.nextLine(); 
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Order order = new Order(id, name, qty, price);
        order.generateInvoice();

        sc.close();
    }
}
