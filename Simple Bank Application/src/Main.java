public class Main {
    public static void main(String[] args) {
        Bank tanzania = new Bank("National Tanzania Bank");
        tanzania.addBranch("Muleba");
        tanzania.addCustomer("Muleba","Anitha",50.05);
        tanzania.addCustomer("Muleba","Valence",60.05);
        tanzania.addCustomer("Muleba","Domina",20);

        tanzania.addBranch("Bukoba");
        tanzania.addCustomerTransaction("Bukoba","Bob",150.54);

        tanzania.addCustomerTransaction("Muleba","Anitha",30.06);
        tanzania.addCustomerTransaction("Bukoba","Bob",100);

        tanzania.listCustomers("Muleba",true);

    }
}
