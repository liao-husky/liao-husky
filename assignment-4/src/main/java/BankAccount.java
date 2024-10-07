class BankAccount {
    private OwnerProfile ownerProfile;
    private String currency;
    private String accountType;
    private double balance;

    public BankAccount(OwnerProfile ownerProfile, String currency, String accountType, double balance) {
        this.ownerProfile = ownerProfile;
        this.currency = currency;
        this.accountType = accountType;
        this.balance = balance;
    }
    public OwnerProfile getOwnerProfile(){
        return ownerProfile;
    }

    public String geyCurrency(){
        return currency;
    }

    public String getAccountType(){
        return accountType;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return "Account Type: " + accountType + "\nCurrency: " + currency + "\nBalance: " + balance + "\nOwner Info:\n" + ownerProfile;
    }
}
