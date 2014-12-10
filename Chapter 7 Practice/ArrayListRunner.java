import java.util.ArrayList;

public class ArrayListRunner
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList();
        System.out.print(names.toString());
        
        String[] people = {"Alice", "Bob", "Connie", "David", "Edward", "Fran", "Gomez", "Harry"};
        for( int i = 0; i < people.length; i++)
        {
            names.add(people[i]);
        }
        System.out.print(names.toString());
        
        System.out.println(names.get(0));
        System.out.println(names.get(7));
        System.out.println(names.size());
        System.out.println(names.get(names.size() - 1));
        names.set(0, "Matt Wright");
        System.out.println(names.get(0));
        names.add(4, "Doug");
        for (String derp : names)
        {
            System.out.println(derp);
        }
        ArrayList<String> names2 = new ArrayList(names);
        names.remove(0);
        System.out.println(names.toString());
        System.out.println(names2.toString());
    }
 } 