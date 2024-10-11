package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Word {
    private String value;

    public Word(String value) {
        this.value = value.toLowerCase();
    }

    public boolean equals(Object obj) {
        return obj.equals(this.value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }

    public String concat(Word other) {
        return this.value + other.value;
    }
}

public class WordChecker {
    private List<Word> wordList;

    public WordChecker() throws IOException {
        wordList = new ArrayList<>();
        loadWordsFromFile("google-10000-english.txt");
    }

    private void loadWordsFromFile(String filename) throws IOException {
        File file = new File(filename);
        List<String> lines = java.nio.file.Files.readAllLines(file.toPath());
        for (String line : lines) {
            wordList.add(new Word(line.trim()));
        }
    }

    public void checkWordCombinations() {
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (wordList.get(i).getValue().length()<5
                    || wordList.get(j).getValue().length()<5) continue;

                String combined = wordList.get(i).concat(wordList.get(j));
                boolean found = false;
                for (int k = 0; k < wordList.size(); k++) {
                    if (wordList.get(k).equals(combined)) {
                        System.out.println("Found match: " + wordList.get(i) + " + " +
                                wordList.get(j) + " = " + wordList.get(k));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    //System.out.println("No match found for " + wordList.get(i) + " + " +
                    //       wordList.get(j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        WordChecker checker = new WordChecker();
        checker.checkWordCombinations();
    }
}
