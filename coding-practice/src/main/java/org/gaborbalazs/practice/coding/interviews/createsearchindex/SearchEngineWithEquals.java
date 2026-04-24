package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchEngineWithEquals {

    private static final String WHITE_SPACE = "\\s+";

    private final ProductDao productDao;

    public SearchEngineWithEquals() {
        productDao = new ProductDao();
    }

    public List<Result> search(String keywords) {
        String[] keywordsAsArray = keywords.split(WHITE_SPACE);
        List<Result> result = new ArrayList<>();
        for (Product product : productDao.getAllProducts()) {
            int matchCounter = 0;
            for (String productNameToken : product.name().split(WHITE_SPACE)) {
                for (String keywordToken : keywordsAsArray) {
                    if (Objects.equals(productNameToken.toLowerCase(), keywordToken.toLowerCase())) {
                        matchCounter++;
                    }
                }
            }
            if (matchCounter == keywordsAsArray.length) {
                result.add(new Result(product.id(), product.name(), getScore(product.name(), keywords)));
            }
        }
        result.sort((a, b) -> Integer.compare(b.score(), a.score()));
        return result;
    }

    private int getScore(String text, String keywords) {
        int lengthOfText = text.length();
        int lengthOfKeyword = keywords.length();
        return (int) (((double) lengthOfKeyword / lengthOfText) * 100);
    }
}
