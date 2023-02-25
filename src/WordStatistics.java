public class WordStatistics implements Comparable<WordStatistics> {
    public WordStatistics(final String word) {
        Word = word;
    }
    @Override
    public int compareTo(WordStatistics o) {
        if (Count != o.Count)
            return Count - o.Count;
        else
            return Word.compareTo(o.Word);
    }
    public void incrementCount() {
        ++Count;
    }
    public int getCount() {
        return Count;
    }
    public final String Word;

    private int Count;
}
