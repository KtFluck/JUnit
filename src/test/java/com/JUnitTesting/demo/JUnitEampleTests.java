package com.JUnitTesting.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JUnitEampleTests {

  @Test
  public void demoTestMethod() {
    assertTrue(true);
  }

}
