import java.util.Scanner;

/**
 * Creates a "cashier" that will prompt for a customer and price, puts it into the Store object
 * 
 * @author Matt Wright
 * @version December 5, 2014
 */
public class Cashier
{
    public static void main(String[] args)
    {
        Scanner cashier = new Scanner(System.in);
        Store grocery = new Store();
        
        boolean sentinel = false;
        while (!sentinel){
            System.out.print("Please enter a customer: ");
            String name = cashier.next();
            if(name.equals("none")){break;}
            else{
                System.out.print("Enter the price: ");
                double price = cashier.nextDouble();
                grocery.addSale(name, price);
            }
        }
        
        System.out.println(grocery.nameOfBestCustomer());
    }
    
}
