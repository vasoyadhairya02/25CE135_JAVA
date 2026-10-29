class Drivr 
{
    public static void main(String[] args) 
    {

        Card[] cards = new Card[6];

        Card[] input = 
        {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("10", "Clubs"),
            new Card("King", "Hearts")
        };

        int count = 0;
        boolean duplicatePrinted = false;

        for (int i = 0; i < input.length; i++) 
        {

            for (int j = 0; j < count; j++) 
            {

                if (input[i].equals(cards[j])) 
                {
                System.out.println("Duplicate found: " + input[i]);
                break;
                }
            }

        cards[count] = input[i];
        count++;

        }
    }
}