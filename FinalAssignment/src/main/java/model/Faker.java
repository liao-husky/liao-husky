package model;
import java.util.Random;

public class Faker {
    private static final String[] FIRST_NAMES = {
            "John", "Jane", "Michael", "Sarah", "Chris", "Jessica", "Matthew", "Emily", "Daniel", "Sophia"
    };
    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Lopez"
    };

    private Random random;

    public Faker() {
        this.random = new Random();
    }

    // Generate a random full name
    public Name name() {
        return new Name();
    }

    public class Name {
        public String fullName() {
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            return firstName + " " + lastName;
        }
    }

    // Generate a random company name
    public Company company() {
        return new Company();
    }

    public class Company {
        private final String[] COMPANY_NAMES = {
                "TechCorp", "Innovate Ltd.", "Global Solutions", "FutureWorks", "Bright Ideas", "Pioneer Labs"
        };

        public String name() {
            return COMPANY_NAMES[random.nextInt(COMPANY_NAMES.length)];
        }
    }
}
