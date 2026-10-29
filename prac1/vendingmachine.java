import java.util.*;

class vendingmachine
{
    enum coin {one , two , five , ten}

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        
        int s;
        int total = 0;
        int snack = 15;
        String coin;

        
        while(total < snack)
        {
            System.out.print("\nenter coin : ");
            coin = input.next();
            
            switch(coin)
            {
                case "one" :
                    s = 1;
                    break;
                case "two" :
                    s = 2;
                    break;
                case "five" :
                    s = 5;
                    break;
                case "ten" :
                    s = 10;
                    break;
                default :
                    System.out.println("invalid coin");
                    continue;
            }

            total += s;
            System.out.println("coin enter so far : " + total);
        }

        if(total >= snack)
        {
            int change = total - snack;
            System.out.println("change : " + change);
        }
    }
}