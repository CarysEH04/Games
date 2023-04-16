class Card {

    String suite;
    char value;
    int worth;

    public Card(String suite, char value) throws InvalidSuiteExcepetion {
        if (suite == "hearts" | suite == "clubs" | suite == "diamonds" | suite == "spades") {
            this.suite = suite;
            this.value = value;
        } else {
            throw new InvalidSuiteExcepetion("invalid suite");
        }
        switch (value) {
            case 'A':
                worth = 0;
                break;
            case '2':
                worth = 2;
                break;
            case '3':
                worth = 3;
                break;
            case '4':
                worth = 4;
                break;
            case '5':
                worth = 5;
                break;
            case '6':
                worth = 6;
                break;
            case '7':
                worth = 7;
                break;
            case '8':
                worth = 8;
                break;
            case '9':
                worth = 9;
                break;
            case 'J':
                worth = 10;
                break;
            case 'Q':
                worth = 10;
                break;
            case 'K':
                worth = 10;
                break;
        }

    }

    public String toString() {
        String str = "";
        str += value;
        str += " of ";
        str += suite;
        return str;
    }

    public int returnWorth() {
        return worth;
    }
}