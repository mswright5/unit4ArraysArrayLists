import java.util.Scanner;

/**
 * Write a description of class RandomDistribution here.
 * 
 * @author Matt Wright
 * @version November 25, 2014
 */
public class RandomDistribution
{
    /** description of instance variable x (add comment for each instance variable) */
    private int[] count;

    /**
     * Default constructor for objects of class RandomDistribution
     */
    public RandomDistribution(int numValues)
    {
        count = new int[numValues];
    }
    
    public void increaseCount(int num)
    {
        count[num]++;
    }
    
    public void genRandom(int amount)
    {
        for (int i = 0; i < amount; i++){
            int random = (int) Math.random() * count.length;
            this.increaseCount(random);
        }
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("How many random numbers do you want to generate? ");
        int rolls = in.nextInt();
        System.out.println("What is the number of values for each random draw? ");
        int highest = in.nextInt();
        
        RandomDistribution array = new RandomDistribution(highest);
        
        array.genRandom(rolls);
        
        System.out.println(array.toString());
    }
    
    public String toString()
    {
        String values = "";
        for (int i = 0; i < count.length; i++)
        {
            values += i + "\t" + count[i];
            values += "\n";
        }
        return values;
    }
}