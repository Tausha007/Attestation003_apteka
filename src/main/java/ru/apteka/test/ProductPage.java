package ru.apteka.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    SelenideElement wishlist = $(".like_icons.iblock");
    SelenideElement product = $(".catalog_block.items.block_list .item-title");
}
