public class CardTest {
    public static void main(String[] args) {
        Card c0 = new Card(3223, "Pokeman", Rank.COMMON);
        Card c1 = new Card(3223, "Pokeman", Rank.RARE);
        Card c2 = new Card(1234, "Lemon", Rank.UNIQUE);
        Card c3 = new Card(5836, "Grape", Rank.UNCOMMON);
        Card c4 = new Card(5836, "Grape", Rank.UNCOMMON);

        // checking getters
        assert c0.getID() == 3223;
        assert c1.getName() == "Pokeman";
        assert c2.getRank() == Rank.UNIQUE;
        assert c3.getPrice() == 0;

        // checking compare and equals
        assert c0.equals(c1) == false;
        assert c0.compareTo(c1) >= 1;
        assert c3.compareTo(c4) == 0;

        // checking the HashSet and TreeSet functionalities

    }
}
