import java.util.*;

class Card implements Comparable<Card> {
    private long id, price;
    private String name;
    private Rank rank;
    private int compareCalls;

    public Card(long id, String name, Rank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.price = 0;
        compareCalls = 0;
    }

    public long getID() {return id;}
    public String getName() {return name;}
    public Rank getRank() {return rank;}
    public long getPrice() {return price;}

    public void setPrice(long price) {this.price = price;}

    public String toString() {
        String s = id + "\n" + name + "\n" + rank + "\n" + price;
        return s;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rank);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }
        Card otherCard = (Card) other;
        return (this.id == otherCard.id && Objects.equals(this.name, otherCard.name) && Objects.equals(this.rank, otherCard.rank));
    }

    @Override
    public int compareTo(Card other) {
        compareCalls++;
        if (this.rank != other.rank) {
            return this.rank.compareTo(other.rank);
        } else if (!this.name.equals(other.name)) {
            return this.name.compareTo(other.name);
        } else {
            return Long.compare(this.id, other.id);
        }
    }

}
