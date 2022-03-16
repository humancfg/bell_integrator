package utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CustomArguments {
    static Stream<Arguments> dataProviderFactory() {
        return Stream.of(
                Arguments.of("Электроника", "Смартфоны", "Apple", "iPhone"),
                Arguments.of("Электроника", "Смартфоны", "Google", "Google")
        );
    }
}
