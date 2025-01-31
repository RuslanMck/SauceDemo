package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ElementsCollectionHelpers {

    /**
     * <p>Method allows to verify if the list of elements from the page are actually displayed on UI in the
     * alphabetical order</p>
     * <p>The method receives the collection of the ElementsCollection type, then created a new collection with
     * alphabetically sorted elements from the received collection, and then compares two collections using
     * .equals() method</p>
     *
     * @param actualProductNames list of elements in ElementsCollection type
     * @return returns the <b>boolean</b> results of the .equals() method after comparing actual collection and alphabetically
     * sorted collection
     */
    public static boolean isSortedAlphabetically(ElementsCollection actualProductNames) {
        List<String> actualNamesList = actualProductNames.texts();
        List<String> sortedProductNames = actualNamesList
                .stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
        return actualNamesList.equals(sortedProductNames);
    }

    /**
     * <p>Method allows to verify if the list of elements from the page are actually displayed on UI in the
     * reverse alphabetical order</p>
     * <p>The method receives the collection of the ElementsCollection type, then creates a new collection with
     * elements sorted in the alphabetically reversed order from the received collection, and then compares two
     * collections using .equals() method</p>
     *
     * @param actualProductNames list of elements in ElementsCollection type
     * @return returns the <b>boolean</b> results of the .equals() method after comparing actual collection and
     * alphabetically reversed sorted collection
     */
    public static boolean isSortedReverseAlphabetically(ElementsCollection actualProductNames) {
        List<String> actualNamesList = actualProductNames.texts();
        List<String> sortedProductNames = actualNamesList
                .stream()
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .collect(Collectors.toList());
        return actualNamesList.equals(sortedProductNames);
    }

    /**
     * <p>Method allows to verify if the list of elements from the page are actually displayed on UI in the
     * numerical ascending order</p>
     * <p>The method receives the collection of the ElementsCollection type. As a next step method removes the possible
     * currency symbols from the provided collection. Then creates a new collection with
     * elements sorted in the numerical ascending order from the received collection, and then compares two
     * collections using .equals() method</p>
     *
     * @param actualProductPrices list of elements in ElementsCollection type
     * @return returns the <b>boolean</b> results of the .equals() method after comparing actual collection and
     * sorted collection.
     */
    public static boolean isSortedInNumericalAscendingOrder(ElementsCollection actualProductPrices) {
        /**
         */
        List<String> actualPricesList = removeCurrencySymbolsAsString(actualProductPrices);

        /**
         * The list of strings is converted to double to be correctly sorted, then back to String to be able to use
         * this list for comparison with original price list
         */
        List<String> sortedPricesList = actualPricesList
                .stream()
                .map(Double::parseDouble)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());

        return actualPricesList.equals(sortedPricesList);
    }

    /**
     * <p>Method allows to verify if the list of elements from the page are actually displayed on UI in the
     * numerical descending order</p>
     * <p>The method receives the collection of the ElementsCollection type. As a next step method removes the possible
     * currency symbols from the provided collection. Then creates a new collection with
     * elements sorted in the numerical descending order from the received collection, and then compares two
     * collections using .equals() method</p>
     *
     * @param actualProductPrices list of elements in ElementsCollection type
     * @return returns the <b>boolean</b> results of the .equals() method after comparing actual collection and
     * sorted collection.
     */
    public static boolean isSortedInNumericalDescendingOrder(ElementsCollection actualProductPrices) {
        List<String> actualPricesList = removeCurrencySymbolsAsString(actualProductPrices);

        List<String> sortedPricesList = actualPricesList
                .stream()
                .map(Double::parseDouble)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.toList());

        return actualPricesList.equals(sortedPricesList);

    }

    /**
     * <p>A lambda expression is used inside .map() to process each product name in the list. The .map() method
     * is part of the Stream API in Java that transforms each element in the stream without modifying the
     * original list. It takes a lambda function and applies it to each element in the list.
     * This lambda expression can be replaced with<p/>
     * <code>List<String> cleanedNames = new ArrayList<>();
     * for (String name : actualPricesList) {
     * cleanedNames.add(name.replaceAll("[^0-9.]", "").trim());
     * }</code>
     *
     * @param actualProductPrices list of elements in ElementsCollection type
     * @return list of prices in the integer type without currency symbols
     */
    public static List<Double> removeCurrencySymbolsAsDouble(ElementsCollection actualProductPrices) {
        List<Double> listWithRemovedSymbols;
        return listWithRemovedSymbols = actualProductPrices
                .texts()
                .stream()
                .map(name -> name.replaceAll("[^0-9.]", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public static List<String> removeCurrencySymbolsAsString(ElementsCollection actualProductPrices) {
        List<String> listWithRemovedSymbols;
        return listWithRemovedSymbols = actualProductPrices
                .texts()
                .stream()
                .map(name -> name.replaceAll("[^0-9.]", "").trim())
                .collect(Collectors.toList());
    }

    public static double removeCurrencySymbolAsDouble(SelenideElement priceWithSymbol) {
        return Double.parseDouble(
                priceWithSymbol.text().replaceAll("[^0-9.]", "").trim()
        );
    }




}
