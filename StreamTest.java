import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public  static void main(String[] args)
    {

        //https://www.java67.com/2016/01/how-to-use-foreach-method-in-java-8-examples.html
        List<String> strList = Arrays.asList("abc", "abc", "bcd", "", "defg", "jk");
        long count = strList.stream()
                .filter(x -> x.isEmpty())
                .count();
        long num = strList.stream()
                .filter(x -> x.length()> 3)
                .count();
        Set<String> duplicateSet = new HashSet<>();
        //Set<String> duplicateSet = new HashSet<>();
        List<String> strDuplicateList = null;
        strDuplicateList =strList.stream()
                .filter(x -> !duplicateSet.add(x)).collect(Collectors.toList());

       // duplicate= Optional.of(strList.stream().findFirst());


        https://www.baeldung.com/java-list-find-duplicates
        System.out.println("strDuplicateList  *******result num:"+strDuplicateList.toString());


        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");
        String G7Countries = G7.stream()
                .filter(x -> x.contains("USA"))
                .collect(Collectors.joining(", "));

        System.out.println("result G7:"+G7Countries);


        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream()
                .mapToInt((x) -> x*x)
                .summaryStatistics();

        System.out.println("result stats:"+stats.getMax());


        List<String> listnumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        System.out.println("original list: " + listnumbers);

        List<Integer> even = listnumbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("processed list, only even numbers: " + even);


        //https://javarevisited.blogspot.com/2016/03/difference-between-map-and-flatmap-in-java8.html


        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 1st argument, init value = 0
        int sum = Arrays.stream(numbers).filter(n->n%2==0).reduce(0, (a, b  ) -> (a + b) );
        System.out.println("sum : " + sum); // 55


        List<Integer> ages = Arrays.asList(10, 10, 10, 10, 10);
        int computedAges = ages.parallelStream().peek(System.out::println).reduce(10, (a, b) -> a + b);   //parallelstream
        System.out.println("computedAges : " + computedAges); // 55


       /* Working with Custom Objects

        reduce() can also work with custom objects. For instance, if you have a User class with a getAge() method, you can use reduce() to compute the sum of ages of a list of User objects:
*/
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        int totalAge = users.stream().reduce(103, (start, user) -> start + user.getAge(), Integer::sum);
        //In this example, the identity is 0, the accumulator adds the age of each user to the age sum, and the combiner is Integer::sum.
        System.out.println("totalAge : " + totalAge);

    }

    //https://www.javabrahman.com/java-8/java-8-reducing-with-streams-reduce-method-tutorial-with-examples/
    //https://www.javabrahman.com/java-8/java-8-filtering-and-slicing-streams-tutorial-with-examples/

}

class User{
   private int age;
    private String name;
   User(String name1,int age1){ name=name1;age=age1; }
   int getAge()
   { return age;}
   String getName()
   {
       return name;
   }

}