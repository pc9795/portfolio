package com.prashantchaubey.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Created By: Prashant Chaubey
 * Created On: 26-05-2019 16:48
 * Purpose: TODO:
 **/
class TestBlogUtils {

    static Stream<Arguments> testGetDescriptionFromContent() {
        return Stream.of(
                Arguments.of(null, 10, "..."),
                Arguments.of("", 10, "..."),
                Arguments.of("abc def gh", 10, "abc def..."),
                Arguments.of("abc def g ", 10, "abc def g..."),
                Arguments.of("abc def", 10, "abc..."),
                Arguments.of("abc ", 10, "abc..."),
                Arguments.of("abc def ghi kjl", 10, "abc def..."),
                Arguments.of("abc", 10, "..."),
                Arguments.of(" ", 10, "...")
        );
    }

    @ParameterizedTest
    @MethodSource
    void testGetDescriptionFromContent(String content, int descriptionSize, String expected) {
        assert BlogUtils.getDescriptionFromContent(content, descriptionSize).equals(expected);
    }
}
