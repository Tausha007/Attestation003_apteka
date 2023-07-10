package ru.apteka.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FindPage {
    SelenideElement header = $(".page-top-wrapper");
    ElementsCollection cartProductonPage = $$(".catalog_block.items.block_list");
}
