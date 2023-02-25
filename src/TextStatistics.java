import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class TextStatistics {
    public TextStatistics(Reader reader) throws IOException {
        Map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        int c = reader.read();
        while (c != -1) {
            if (Character.isLetterOrDigit(c))
                builder.append((char) c);
            else if (builder.length() != 0) {
                String word = builder.toString();
                if (Map.get(word) == null)
                    Map.put(word, new WordStatistics(word));
                Map.get(word).incrementCount();
                ++Count;
                builder.setLength(0);
            }
            c = reader.read();
        }
        if (builder.length() != 0) {
            String word = builder.toString();
            if (Map.get(word) == null)
                Map.put(word, new WordStatistics(word));
            Map.get(word).incrementCount();
            ++Count;
            builder.setLength(0);
        }
    }

    public void writeStats(Writer writer) throws IOException {
        Collection<WordStatistics> collection = Map.values();
        TreeSet<WordStatistics> set = new TreeSet<>(collection);
        Iterator<WordStatistics> iterator = set.descendingIterator();
        while (iterator.hasNext()) {
            var wordStat = iterator.next();
            double freq = (double) wordStat.getCount() / Count;
            writer.write(wordStat.Word + ',' + freq + ',' + freq*100 + "%\n");
        }
    }

    public int getCount() {
        return Count;
    }
    private int Count = 0;
    private final HashMap<String, WordStatistics> Map;
}
