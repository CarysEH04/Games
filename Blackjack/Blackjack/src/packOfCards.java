public class packOfCards {
    Card[] pack = new Card[52];
    String[] SUITES = { "hearts", "clubs", "spades", "diamonds" };
    char[] VALUES = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K' };

    private packOfCards() throws InvalidSuiteExcepetion {
        int pointer = 0;
        for (String suite : SUITES) {
            for (char value : VALUES) {
                Card temp = new Card(suite, value);
                pack[pointer] = temp;
                pointer++;
            }
            System.out.println("added " + suite);
        }
    }

    public String toString() {
        String str = "[";
        for (Card card : pack) {
            str += card.toString();
            str += "  ";
        }
        str += "]";
        return str;
    }

    public static void main(String[] args) throws InvalidSuiteExcepetion {
        packOfCards pack = new packOfCards();
        System.out.println(pack.toString());
    }
}
