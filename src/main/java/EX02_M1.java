import com.fasterxml.jackson.databind.ObjectMapper;
import model.Trace;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EX02_M1 {

    private static char newLineChar = '\n';

    public static void main(String[] args) throws IOException {
        String userId = args[0];
        int number_of_power_traces = Integer.parseInt(args[1]);
        String serverURL = args[2];
        String fileName = args[3];
        String serverCommand = serverURL.concat("encrypt?user=".concat(userId.concat("/")));
        download_power_traces(fileName, serverCommand, number_of_power_traces);
        getMeansVariances(fileName);
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
        int responseCOde = connection.getResponseCode();
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
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

    public static void getMeansVariances(String filename) throws IOException {
        List<Trace> traces = readTracesFromFile(filename);
        System.out.printf(traces.toString());
    }

    private static List<Trace> readTracesFromFile(String filename) throws IOException {
        List<Trace> traces = new ArrayList<>();
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String traceJson;
        while ((traceJson = bufferedReader.readLine()) != null) {
            ObjectMapper mapper = new ObjectMapper();
            traces.add(mapper.readValue(traceJson, Trace.class));
        }
        return traces;
    }
}
