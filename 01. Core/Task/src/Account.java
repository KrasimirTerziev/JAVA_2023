public class Account {
   private String owner;
   private double balance;

   public Account(String owner){
       this.owner = owner;
   }
   public Account(String name, double balance){
       this.owner = name;
       this.balance = balance;
    }

    public double deposit(double price){
       price += this.balance;
       return price;
    }
    

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

   private void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
