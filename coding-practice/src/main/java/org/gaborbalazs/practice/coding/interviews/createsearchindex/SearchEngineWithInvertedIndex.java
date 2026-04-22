package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngineWithInvertedIndex {

    // inverted index: word -> productIds
    private final Map<String, Set<Integer>> index = new HashMap<>();
    private final Map<Integer, Product> productMap = new HashMap<>();

    public SearchEngineWithInvertedIndex() {
        List<Product> products = new ProductDao().getAllProducts();
        for (Product p : products) {
            productMap.put(p.id(), p);

            for (String token : tokenize(p.name())) {
                index.computeIfAbsent(token, k -> new HashSet<>()).add(p.id());
            }
        }
    }

    public List<Result> search(String query) {
        List<String> tokens = tokenize(query);

        if (tokens.isEmpty()) return List.of();

        // 1. Find intersection
        Set<Integer> resultIds = new HashSet<>(index.getOrDefault(tokens.get(0), Set.of()));

        for (int i = 1; i < tokens.size(); i++) {
            resultIds.retainAll(index.getOrDefault(tokens.get(i), Set.of()));
        }

        // 2. Rank results
        List<Result> results = new ArrayList<>();

        for (Integer id : resultIds) {
            Product p = productMap.get(id);
            int score = calculateScore(tokens, p.name());
            results.add(new Result(p.id(), p.name(), score));
        }

        // 3. Sort by score desc
        return results.stream()
                .sorted((a, b) -> Integer.compare(b.score(), a.score()))
                .collect(Collectors.toList());
    }

    private List<String> tokenize(String text) {
        return Arrays.stream(text.toLowerCase().split("\\s+"))
                .filter(s -> !s.isBlank())
                .toList();
    }

    private int calculateScore(List<String> queryTokens, String productName) {
        String nameLower = productName.toLowerCase();

        int matchedChars = 0;
        for (String token : queryTokens) {
            if (nameLower.contains(token)) {
                matchedChars += token.length();
            }
        }

        return (int) ((matchedChars * 100.0) / productName.length());
    }
}
