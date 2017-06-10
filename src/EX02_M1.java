import model.Trace;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EX02_M1 {

    private static char newLineChar = '\n';

    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);


    }

    public static void download_power_traces(String filename, String serverUrl, int number_of_power_Traces) throws IOException {
        String[] traces = new String[number_of_power_Traces];
        for (int i = 0; i < number_of_power_Traces; i++) {
            traces[i] = sendTraceRequest(serverUrl);
        }
        writeTracesToFile(filename, traces);
    }

    private static String sendTraceRequest(String serverUrl) throws IOException {
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

    private static void writeTracesToFile(String filename, String[] traces) throws IOException {
        File file = new File(filename);
        FileWriter writer = new FileWriter(file);
        for (String trace : traces) {
            writer.write(trace + newLineChar);
        }
        writer.close();
    }

    public static void getMeansVariances(String filename) {

    }

    private static List<Trace> readTracesFromFile(String filename) throws IOException {
        List<Trace> traces = new ArrayList<>();
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String traceJson;
        while ((traceJson = bufferedReader.readLine()) != null) {

        }
        return traces;
    }
}
