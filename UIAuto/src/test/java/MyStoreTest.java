import com.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import com.pages.AccountPage;

public class MyStoreTest {

    @Test
    public void buyInShop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mkotova/IdeaProjects/DipProject//UIAuto/lib/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        WebElement login = driver.findElement(By.className("login"));
        login.click();

        // Регистрация
//        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
//        signIn.createAccount("mytestproject"+"@yahoo.com");
//        signIn.register("Mila", "Yovovic", "12345", "4608 Aspen Court", "Boston", "Massachusetts",
//                "02199", "United States", "6178232381");

        //Вход в созданный аккаунт
        AccountPage accountPage = PageFactory.initElements(driver, AccountPage.class);
        accountPage.login("testing@yahoo.com", "123456");

        //Поиск
        SearchFeature search = PageFactory.initElements(driver, SearchFeature.class);
        search.searchFor("dress");

        //Выбор платья
        WebElement dressElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
        dressElement.click();

        //Покупка платья
        DressPage buyDress = PageFactory.initElements(driver, DressPage.class);
        buyDress.editBuy(3);

        WebElement proceedButton = driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1']"));
        proceedButton.click();

        CheckOutPage checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);
        checkOutPage.AdressTab("Call back to specify delivery details");
        checkOutPage.ShippingTab();
//        checkOutPage.checkTermsOfServices();
        checkOutPage.PaymentOrder();



    }

//    @AfterClass
//    public void EndTest() throws InterruptedException{
//        driver.close();
//    }


}
