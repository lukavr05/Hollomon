import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class HollomonClient{
    private Socket s;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String server;
    private int port;

    public HollomonClient(String server, int port) {
        this.server = server;
        this.port = port;
    }

    public List<Card> login(String username, String password) {
        List<Card> list = new ArrayList<Card>();
        try {
            s = new Socket(server, port);
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            // write username and password and make sure it goes through using flush
            writer.write(username);
            writer.newLine();
            writer.write(password);
            writer.newLine();
            writer.flush();

            // compare expected response to actual
            String expected = "User " + username + " logged in successfully.";
            String response = reader.readLine();

            if (!(response.equals(expected))) {
                return null;
            } else {
                return list;
            }

        } catch (IOException e) {
            return null;
        }
    }

    public void close() throws IOException {
        s.close();
        reader.close();
        writer.close();
    }
}
