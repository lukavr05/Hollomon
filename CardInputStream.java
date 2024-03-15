import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

abstract class CardInputStream extends InputStream {
    private BufferedReader reader;

    public CardInputStream(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
    }

    
    public Card readCard() throws IOException {
        try {
        if (reader.readLine() == "CARD") {
            long id = Long.parseLong(reader.readLine());
            String name = reader.readLine();
            Rank rank = (Rank.valueOf(reader.readLine()));
            long price = Long.parseLong(reader.readLine());

            Card card = new Card(id, name, rank);
            card.setPrice(price);

            return card;
        } else {
            return null;
        }
    } catch (IOException e) {
        return null;
    }
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
