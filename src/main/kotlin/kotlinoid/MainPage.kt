package kotlinoid

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement

class MainPage {
    val homeContent: SelenideElement = Selenide.element("#home")
}
