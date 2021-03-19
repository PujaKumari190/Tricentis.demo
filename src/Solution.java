import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args)
    {
        // Setting up Chrome driver path.
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        // Launching Chrome browser.
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        //Launch tricentis site
        driver.get("http://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Click on Log in button
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        //validating "Welcome, Please Sign In" Message
        WebElement WelcomePage=driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        String welcome=WelcomePage.getText();
        System.out.println(welcome);
        String expwelcome="Welcome, Please Sign In!";
        if(welcome.equals(expwelcome))
        {
            System.out.println("validate");
        }
        else {
            System.out.println("not validate");
        }
        //Pass login id and password
        driver.findElement(By.id("Email")).sendKeys("testdemowebshop@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test123");
        //click on login button
        WebElement login=driver.findElement(By.xpath("//input[@value='Log in']"));
        Actions act1=new Actions(driver);
        act1.moveToElement(login).click().perform();
        //validating Account id
        WebElement validationAcc=driver.findElement(By.xpath("//a[text()='testdemowebshop@gmail.com']"));
        String act2=validationAcc.getText();
        System.out.println(act2);
        String expvalidationAcc="testdemowebshop@gmail.com";
        if(act2.equals(expvalidationAcc))
        {
            System.out.println("validate");
        }
        else {
            System.out.println("not validate");
        }
        //click on shopping cart and delete all element
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        WebElement checkbox=driver.findElement(By.xpath("//input[@name='removefromcart']"));
        checkbox.click();
        driver.findElement(By.name("updatecart")).click();
        //select Books from categories
        driver.findElement(By.xpath("//a[@href='/books']")).click();
        driver.findElement(By.xpath("//img[@src='http://demowebshop.tricentis.com/content/images/thumbs/0000130_computing-and-internet_125.jpeg']")).click();
        //get the price of book
        WebElement price=driver.findElement(By.xpath("//span[@class='price-value-13']"));
        System.out.println(price.getText().replaceAll(",", "").replaceAll("[^A-Za-z0-9.,]", "").replaceAll("AskForPrice", ""));
        //enter the quantity of books
        driver.findElement(By.id("addtocart_13_EnteredQuantity")).sendKeys("2");
        //click on add to cart
        driver.findElement(By.id("add-to-cart-button-13")).click();
        //WebElement adeddEle=driver.findElement(By.xpath("//span[@class='cart-qty']")).getAttribute()
        //click on cart
        driver.findElement(By.xpath("//span[@class='cart-qty']")).click();
        //click on agree button
        WebElement agreebutton=driver.findElement(By.name("termsofservice"));
        agreebutton.click();
        //click on checkout button
        driver.findElement(By.id("checkout")).click();
        //select Billing address as new address
        WebElement selectadd = driver.findElement(By.id("billing-address-select"));
        Select select = new Select(selectadd);
        select.selectByVisibleText("New Address");
        //give first name
        WebElement firstname = driver.findElement(By.id("BillingNewAddress_FirstName"));
        firstname.click();
        firstname.sendKeys("Puja");
        //give last name
        WebElement lastname=driver.findElement(By.id("BillingNewAddress_LastName"));
        lastname.clear();
        lastname.sendKeys("Kumari");
        //give Email address
        WebElement emailid=driver.findElement(By.id("BillingNewAddress_Email"));
        emailid.clear();
        emailid.sendKeys("Puja.shahani19@gmail.com");
        //billing country
        WebElement selectcountry = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select1 = new Select(selectcountry);
        select1.selectByVisibleText("India");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Dhanbad");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("jealgora");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("828110");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("7000150532");
        //click on continue button
        driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']")).click();
        WebElement shippingadd = driver.findElement(By.id("shipping-address-select"));
        Select select2 = new Select(shippingadd);
        select2.selectByIndex(3);
        driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
        //select shipping method as "Next Day Air"
        WebElement shippingmethod = driver.findElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedRate']"));
        shippingmethod.click();
        //Click on continue
        driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
        //select on COD and click on continue
        driver.findElement(By.id("paymentmethod_0")).click();
        driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
        //validating "You will pay by COD" message
        WebElement valcod =driver.findElement(By.xpath("//p[text()='You will pay by COD']"));
        String confirm = valcod.getText();
        System.out.println(confirm);
        String exp1="You will pay by COD";
        if(confirm.equals(exp1))
        {
            System.out.println("validate");
        }
        else {
           System.out.println("not validate");
        }
        //Click on continue
        driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
        //click on confirm order
        driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
        //print order number
        WebElement oderno = driver.findElement(By.xpath("//*[contains(text(),'Order number')]"));
        System.out.println(oderno.getText());
        //Click on continue button
        driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']")).click();
        //Click on Logout
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

    }
}
