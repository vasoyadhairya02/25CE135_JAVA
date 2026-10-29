import java.util.Scanner;

public class Drivr
{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);

    String[] logs =
    {
        "10:05 alice Hello there",
        "10:10 bob How are you?",
        "10:15 charlie Hello everyone",
        "10:20 david hello",
        "10:25 alice I said hello again"
    };

    System.out.print("Enter keyword: ");
    String keyword = sc.nextLine();

    String result = ChatFilter.filter(logs, keyword);

    System.out.println(result);

    sc.close();
}


}
