import java.io.*;

public class Program {
    public static void main(String[] argv) {
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new BufferedReader( new FileReader(argv[1]) );
            writer = new BufferedWriter( new FileWriter(argv[0]) );
            TextStatistics text = new TextStatistics(reader);
            text.writeStats(writer);
        }
        catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }
        finally {
            try {
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            }
            catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }

    }
}
