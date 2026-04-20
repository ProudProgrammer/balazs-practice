package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchProcessor {

    private static final String EMPTY_SPACE = " ";
    private static final String WORD_BOUNDARY = "\\b";

    private final ProductDao productDao;

    public SearchProcessor() {
        productDao = new ProductDao();
    }

    public List<Product> searchProducts(String keyword) {
        String[] keywords = keyword.split(EMPTY_SPACE);
        List<Product> result = new ArrayList<>();
        boolean isMatch = false;
        for (Product product : productDao.getAllProducts()) {
            for (String currentKeyword : keywords) {
                if (isContainKeyword(product.getName(), currentKeyword)) {
                    isMatch = true;
                } else {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                product.setScore(getScore(product.getName(), keyword));
                result.add(product);
            }
        }
        return result;
    }

    private boolean isContainKeyword(String text, String keyword) {
        Pattern pattern = Pattern.compile(WORD_BOUNDARY + keyword + WORD_BOUNDARY, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    private int getScore(String text, String keyword) {
        int lengthOfText = text.length();
        int lengthOfKeyword = keyword.length();
        return (int) (((double) lengthOfKeyword / lengthOfText) * 100);
    }
}
