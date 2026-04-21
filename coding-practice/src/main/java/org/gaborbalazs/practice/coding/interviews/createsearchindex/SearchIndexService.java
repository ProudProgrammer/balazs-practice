package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchIndexService {

    private static final String EMPTY_SPACE = " ";
    private static final String WORD_BOUNDARY = "\\b";

    private final ProductDao productDao;

    public SearchIndexService() {
        productDao = new ProductDao();
    }

    public List<Result> searchProductsByKeywordsInName(String keywords) {
        String[] keywordsAsArray = keywords.split(EMPTY_SPACE);
        List<Result> result = new ArrayList<>();
        for (Product product : productDao.getAllProducts()) {
            boolean isMatch = true;
            for (String currentKeyword : keywordsAsArray) {
                if (!isContainKeyword(product.name(), currentKeyword)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                result.add(new Result(product.id(), product.name(), getScore(product.name(), keywords)));
            }
        }
        result.sort((a, b) -> Integer.compare(b.score(), a.score()));
        return result;
    }

    private boolean isContainKeyword(String text, String keyword) {
        Pattern pattern = Pattern.compile(WORD_BOUNDARY + Pattern.quote(keyword) + WORD_BOUNDARY, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    private int getScore(String text, String keywords) {
        int lengthOfText = text.length();
        int lengthOfKeyword = keywords.length();
        return (int) (((double) lengthOfKeyword / lengthOfText) * 100);
    }
}
