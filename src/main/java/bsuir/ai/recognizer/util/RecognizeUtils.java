package bsuir.ai.recognizer.util;

import bsuir.ai.recognizer.model.Document;
import bsuir.ai.recognizer.model.RecognizeResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecognizeUtils {
    private static final int N_GRAM_SIZE = 3;
    private static final int MAX_N_GRAM_NUMBER = 300;

    public static Map<String, Integer> makeImage(String text) {
        List<String> words = extractImportantWords(text);
        Map<String, Integer> wordsWeights = new HashMap<>();
        for (String word : words) {
            if (word.length() > N_GRAM_SIZE) {
                int firstSymbol = 0;
                int lastSymbol = N_GRAM_SIZE;
                while (lastSymbol <= word.length()) {
                    String gram = word.substring(firstSymbol, lastSymbol);
                    int gramWeight = gramWeight(words, word);
                    wordsWeights.put(gram, gramWeight);
                    firstSymbol++;
                    lastSymbol++;
                }
            } else {
                int gramWeight = gramWeight(words, word);
                wordsWeights.put(word, gramWeight);
            }
        }
        return createImage(wordsWeights);
    }


    public static List<RecognizeResult> recognize(String text, List<Document> docs) {
        Map<String, Integer> image = makeImage(text);
        List<RecognizeResult> results = new ArrayList<>();
        for (Document doc : docs) {
            Map<String, Integer> gramWeights = doc.getGramWeight();
            for (Map.Entry<String, Integer> entry : image.entrySet()) {
                String gram = entry.getKey();
                Integer gramWeight = entry.getValue();
                Optional<Integer> docGramRank = Optional.ofNullable(gramWeights.get(gram));
                Integer rank = Math.abs(docGramRank.orElse(MAX_N_GRAM_NUMBER) - gramWeight);
                results.add(createRecognizeResult(rank, text, doc));
            }
        }
        return results.stream()
                .sorted(Comparator.comparingInt(RecognizeResult::getRank))
                .collect(Collectors.toList());
    }

    private static RecognizeResult createRecognizeResult(Integer rank, String testedDoc, Document foundedDoc) {
        return RecognizeResult.builder()
                .rank(rank)
                .testedDocument(testedDoc)
                .foundedDocument(foundedDoc)
                .language(foundedDoc.getLanguage())
                .build();
    }

    private static List<String> extractImportantWords(String text) {
        String clearText = text.replaceAll("[,.!?:()—\\[\\]]", "");
        return Arrays.stream(clearText.split("[\\s\n]"))
                .filter(word -> word.length() >= N_GRAM_SIZE)
                .collect(Collectors.toList());
    }

    private static int gramWeight(List<String> words, String gram) {
        return (int) words.stream()
                .filter(checkWord -> checkWord.contains(gram))
                .count();
    }

    private static Map<String, Integer> createImage(Map<String, Integer> wordsWeights) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordsWeights.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list = list.subList(0, MAX_N_GRAM_NUMBER);
        Map<String, Integer> result = new LinkedHashMap<>();
        int index = 0;
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), index);
            index++;
        }
        return result;
    }
}
