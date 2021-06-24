package kotlinoid

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Feature
import io.qameta.allure.Owner
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

@Owner("leo")
class MainPageTest {

    private val mainPage: MainPage = MainPage()

    companion object {
        private val LOGGER = LoggerFactory.getLogger(MainPageTest::class.java)

        @BeforeAll
        @JvmStatic
        internal fun beforeAll() {
            LOGGER.info("Init main page tests setup")
            SelenideLogger.addListener(
                "AllureSelenide",
                AllureSelenide()
                    .screenshots(true)
                    .savePageSource(false)
            )
        }

        @AfterAll
        @JvmStatic
        internal fun afterAll() {
            LOGGER.info("Down main page tests")
        }
    }

    @BeforeEach
    internal fun setUp() {
        Configuration.startMaximized
        open("http://leoyas.com")
    }

    @Feature("open-page")
    @Test
    fun search() {
        mainPage.homeContent.shouldBe(Condition.visible)

        assertEquals("Olá! =]", Selenide.title());
    }
}
