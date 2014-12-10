import java.util.ArrayList;
public class Store
{
    private ArrayList<String> names;
    private ArrayList<Double> price;

    /**
     * Default constructor for objects of class Store
     */
    public Store()
    {
        names = new ArrayList<>();
        price = new ArrayList<>();
    }
    
    public void addSale(String customerName, double amount)
    {
        names.add(customerName);
        price.add(amount);
    }
    
    public String nameOfBestCustomer()
    {
        String best;
        
        int bestIndex = 0;
        for(int i = 0; i < this.price.size();i++){
            if (this.price.get(i) > this.price.get(bestIndex)){bestIndex = i;}
        }
        best = this.names.get(bestIndex);
        return best;
    }
    
    public ArrayList<String> nameOfTopCustomers(int topN)
    {
        ArrayList<String> topCustomers = new ArrayList<>(topN);
        for(int i = 0; i < this.price.size(); i++){
            for (int j = 0; j < topN; j++){
                if (this.price.get(i) > this.names.indexOf(topCustomers.get(j))){
                    topCustomers.set(j,this.names.get(j));
                }
            }
        }
        return topCustomers;
    }
}
