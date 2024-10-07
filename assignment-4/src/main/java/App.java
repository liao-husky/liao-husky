public class App {

    public static void main(String[] args) {

        Address address1 = new Address("15th Rose St", "San Jose", "CA", "USA", "95113");
        Address address2 = new Address("5th Manhattan St", "New York", "NY", "USA", "65324");
        Address address3 = new Address("360 Huntington Ave", "Boston", "MA", "USA", "02115");


        ContactInformation contact1 = new ContactInformation("159-234-567", "tom@meta.com");
        ContactInformation contact2 = new ContactInformation("198-765-432", "jerry@amazon.com");
        ContactInformation contact3 = new ContactInformation("332-567-457", "mike@google.com");


        OwnerProfile owner1 = new OwnerProfile("Tom Smith", "Individual", address1, contact1);
        OwnerProfile owner2 = new OwnerProfile("Jerry Brown", "Individual", address2, contact2);
        OwnerProfile owner3 = new OwnerProfile("Mike Chen", "Company", address3, contact3);


        BankAccount account1 = new BankAccount(owner1, "USD", "Checking", 3000.00);
        BankAccount account2 = new BankAccount(owner2, "USD", "Saving", 2200.50);
        BankAccount account3 = new BankAccount(owner3, "USD", "Business", 300000.00);

        // Print account details
        System.out.println("Bank Account 1:\n" + account1 + "\n");
        System.out.println("Bank Account 2:\n" + account2 + "\n");
        System.out.println("Bank Account 3:\n" + account3 + "\n");
    }
}