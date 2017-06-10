import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class EX02_M1 {

    public void Main(String[] args) {

    }

    public void download_power_traces(String filename, String serverUrl, int number_of_power_Traces) throws IOException {
        String[] traces = new String[number_of_power_Traces];
        for (int i = 0; i < number_of_power_Traces; i++) {
            traces[i] = sendTraceRequest(serverUrl);
        }

    }

    private String sendTraceRequest(String serverUrl) throws IOException {
        URL urlObject = new URL(serverUrl);
        // Establish the connection
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        // Set request method to GET
        connection.setRequestMethod("GET");
        // Create a buffered reader to read from the response
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String trace = bufferedReader.readLine();
        bufferedReader.close();
        return trace;
    }

    public void getMeansVariances(String filename) {

    }
}
