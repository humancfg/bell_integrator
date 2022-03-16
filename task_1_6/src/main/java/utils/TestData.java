package utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestData {
    static Stream<Arguments> dataProviderFactory() {
        return Stream.of(
                Arguments.of("Маркет", "Электроника", "Смартфоны", "Apple", "iPhone")
        );
    }

}
