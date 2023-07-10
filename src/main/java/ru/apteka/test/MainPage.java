package ru.apteka.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement inputFind = $("#title-search-input_fixed");
    SelenideElement countProduct = $(".wrap_icon .basket-link.delay.with_price .count");
    SelenideElement countProductInCart = $(".js-basket-block .wrap .count");


}

