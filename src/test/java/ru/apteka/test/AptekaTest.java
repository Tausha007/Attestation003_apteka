package ru.apteka.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AptekaTest extends WebTest{
    MainPage mainPage = new MainPage();
    CityPopup cityPopup = new CityPopup();
    FindPage findPage = new FindPage();
    ProductPage productPage = new ProductPage();
    String titleProduct = "Âèòàìèí";



    @BeforeEach
    public void setSelenide(){
        baseUrl="https:/aptekaeconom.com";
        open("/");
        Selenide.webdriver().driver().getWebDriver()
                .manage().addCookie(new Cookie("current_region","103006"));
        refresh();
        cityPopup.modal.shouldNotBe(visible);
    }

    @Test
    @DisplayName("Ïîèñê òîâàðîâ")
    @Feature("Ïîèñê")
    @Story("Ïðîâåðêà êîëè÷åñòâà òîâàðîâ â ïîèñêîâîé âûäà÷å")
    public void shouldfindTest(){
        step("Â ïîèñêîâîé ñòðîêå ââåäèòå íàçâàíèå òîâàðà", () -> {
            mainPage.inputFind.setValue(titleProduct).pressEnter();
        });

        step("Ïðîâåðèòü, ÷òî ïðîèçîøåë ïåðåõîä íà ñòðàíèöó ïîèñêà", () -> {
            findPage.header.shouldHave(text("Ïîèñê"));
        });

        step("Íàéäåííûé òîâàð ñîäåðæèò èñêîìûé òåêñò", () -> {
            productPage.product.shouldHave(text(titleProduct));
        });

        step("Ïðîâåðèòü, ÷òî êîëè÷åñòâî îòîáðàæàåìûõ òîâàðîâ ðàâíî 5", () -> {
            findPage.cartProductonPage.shouldHave(CollectionCondition.size(5));
        });

    }

    @Test
    @DisplayName("Äîáàâëåíèå òîâàðà â îòëîæåííûé ñïèñîê")
    @Feature("Îòëîæèòü òîâàð")
    @Story("Ïðîâåðêà, ÷òî âûáðàííûé òîâàð äîáàâëÿåòñÿ â ñïèñîê îòëîæåííûõ òîâàðîâ ")
    public void shouldAddWishListTest(){
        step("Ïåðåõîä ïî ññûëêå âûáðàííîãî òîâàðà", () -> {
            open(baseUrl+"/catalog/mama-i-malysh/igrushki-prorezyvateli-dlya-zubov-pustyshki/104433/");
        });

        step("Ïîìåòèòü òîâàð êàê îòëîæåííûé", () -> {
            productPage.wishlist.click();
        });

        step("Ïðîâåðèòü, ÷òî êîëè÷åñòâî îòëîæåííûõ òîâàðîâ ðàâíî 1", () -> {
            mainPage.countProduct.shouldHave(text("1"));
        });

        step("Ïðîâåðèòü, ÷òî êîëè÷åñòâî òîâàðà â êîðçèíå íå èçìåíèëîñü", () -> {
            mainPage.countProductInCart.shouldHave(text("0"));
        });


    }

    @Test
    @DisplayName("Ïåðåõîä ïî ïîäêàòåãîðèÿì â êàòàëîãå òîâàðîâ")
    @Feature("Êàòàëîã òîâàðîâ")
    @Story("Ïîäêàòåãîðèè")
    public void shouldOpenCatalogTab() {
        step("Íàâåñòè êóðñîð íà âêëàäêó", () -> {
            $(byText("Êîñìåòèêà")).shouldBe(visible).hover();
        });

        step("Êëèêíóòü íà ïîÿâèâøóþñÿ ïîäêàòåãîðèþ", () -> {
            $(byText("Äåçîäîðàíòû")).shouldBe(visible).click();
        });

        step("Ïðîâåðèòü, ÷òî ïðîèçîøåë ïåðåõîä â íóæíóþ êàòåãîðèþ òîâàðîâ", () -> {
            findPage.header.shouldHave(text("Äåçîäîðàíòû"));
        });


    }

}
