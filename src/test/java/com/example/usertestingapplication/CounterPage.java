package com.example.usertestingapplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CounterPage {

    @FindBy(id = "count-display") // counter.html line 13
    private WebElement countDisplay;

    @FindBy(id = "increment-button") // counter.html line 17
    private WebElement incrementButton;

    @FindBy(id = "reset-value-field") // counter.html line 22
    private WebElement resetValueField;

    @FindBy(id = "reset-button") // counter.html line 23
    private WebElement resetButton;

}
