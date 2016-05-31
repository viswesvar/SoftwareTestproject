package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class testforsriniprofile {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver();
    baseUrl = "http://develop-viswesvarsekar.rhcloud.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testForsriniprofile() throws Exception {
    driver.get(baseUrl + "/index.html");
    driver.findElement(By.xpath("//center[4]/a/p")).click();
    assertEquals("Srinivas K Singadi", driver.findElement(By.id("logoLink")).getText());
    assertEquals("Name : Srinivas K Singadi", driver.findElement(By.cssSelector("p")).getText());
    assertEquals("Education : Bachelor's in Information Science Engineering", driver.findElement(By.xpath("//div[@id='content']/p[6]")).getText());
    try {
      assertEquals("Project Development : Project on \" Email Security \"", driver.findElement(By.xpath("//div[@id='content']/p[10]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("Next Generation firewall", driver.findElement(By.xpath("//div[@id='content']/p[11]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
