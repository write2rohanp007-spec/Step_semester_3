package polymorphism.class_problems;

import java.util.*;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
    public abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02;
    }

    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01;
    }

    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystemFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            if (type.equals("CARD")) payments.add(new CardPayment(amount));
            else if (type.equals("WALLET")) payments.add(new WalletPayment(amount));
            else payments.add(new BankTransferPayment(amount));
        }

        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.calculateAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
