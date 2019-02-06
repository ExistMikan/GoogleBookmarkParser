package com.existmikan.google.bookmark.parser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

  @ParameterizedTest
  @ValueSource(strings = {"1", "2"})
  void sample(final String value) {
    assertEquals(1, value.length());
    System.out.println("value:" + value);
  }

  @BeforeAll
  static void setUpAll() {
      System.out.println("before all tests");
  }

  @BeforeEach
  void setUp() {
      System.out.println("before each test");
  }

  @Test
  void test1() {
      System.out.println("test 1");
  }

  @Test
  void test2() {
      System.out.println("test 2");
  }

  @AfterEach
  void tearDown() {
      System.out.println("after each test");
  }

  @AfterAll
  static void tearDownAll() {
      System.out.println("after all tests");
  }

}
