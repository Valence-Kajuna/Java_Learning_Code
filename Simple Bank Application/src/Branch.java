import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public boolean addNewCustomer(String name, double initialAmount){
        if (findCustomer(name) == null){
            this.customers.add(new Customer(name,initialAmount));
            return true;
        }
        return  false;
    }

    public boolean addCustomerTransaction(String name,double amount){
        Customer existingCustomer = findCustomer(name);
        if (existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name){
        for (int i=0; i<this.customers.size(); i++){
            if (this.customers.get(i).getName().equals(name)){
                return this.customers.get(i);
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
