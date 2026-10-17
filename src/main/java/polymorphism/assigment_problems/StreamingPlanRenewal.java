package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<SubscriptionPlan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            if (type.equals("BASIC")) plans.add(new BasicPlan(name, startDate));
            else if (type.equals("STANDARD")) plans.add(new StandardPlan(name, startDate));
            else plans.add(new PremiumPlan(name, startDate));
        }

        for (SubscriptionPlan p : plans) {
            System.out.printf("%s: %s%n", p.getName(), p.getRenewalDate());
        }
        scanner.close();
    }
}
