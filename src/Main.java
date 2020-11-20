import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    static public void main(String[] args){
        System.out.println(computeFrequency("baz bar foo foo zblah zblah zblah baz toto bar", 3));
    }

    public static List<Word> computeFrequency(String sentence, int size){
        List<String> wordList = Arrays.asList(sentence.split(" "));
        List<Word> listWordWithFrequency = new ArrayList<>();
        for (String word: wordList){
            //if word is already in listWordWithFrequency
            if (listWordWithFrequency.stream().map(w -> w.getWord()).collect(Collectors.toList()).contains(word)){
                //increment frequency of the word
                for (Word w: listWordWithFrequency){
                    if (w.getWord().equals(word)){
                        w.setFrequency(w.getFrequency() + 1);
                    }
                }
            } else {
                listWordWithFrequency.add(new Word(word, 1));
            }
        }
        // sort list
        listWordWithFrequency = listWordWithFrequency.stream().sorted(Comparator.comparingInt(Word::getFrequency).reversed()
                .thenComparing(Word::getWord))
                .collect(Collectors.toList());
        return listWordWithFrequency.subList(0, size);
    }
}
