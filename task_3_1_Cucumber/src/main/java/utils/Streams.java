package utils;

import com.codeborne.selenide.ElementsCollection;

public class Streams {

    public static boolean anyMatchElement(ElementsCollection collection, String equalsText) {
        return collection.stream().anyMatch(x -> x.getText().equals(equalsText));
    }

    public static boolean allMatchElements(ElementsCollection collection, String containsText) {
        return collection.stream().allMatch(x -> x.getText().contains(containsText));
    }
}
