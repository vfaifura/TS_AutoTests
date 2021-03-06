package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class LoginPage extends BasePage {

    private static LoginPage instance;
    public static LoginPage Instance = (instance != null) ? instance : new LoginPage();

    public LoginPage(){
        pageURL = "/customer/account/login/";
    }

    /** UI Mappings */

    By usernameLocator = By.id("email");
    By passwordLocator = By.id("pass");
    By loginButtonLocator = By.id("send2");
    //   By loginErrorLocator = By.id("");
    By createAccountLinkLocator = By.xpath("//SPAN[text()='CREATE AN ACCOUNT']");

    /** Page Methods */

//    public HomePage doLogin(String password)
//    {
//        reporter.info("Logging in using the pass: " + password);
//
//        this.open();
//        this.enterPassword(password);
//        return this.submitForm();
//    }

    public LoginPage enterUsername(String username)
    {
        reporter.info("Entering username: " + username);

        findElement(usernameLocator).clear();
        findElement(usernameLocator).sendKeys(username);

        return this;
    }

    public void enterPassword(String password)
    {
        reporter.info("Entering password: " + password);

        findElement(passwordLocator).clear();
        findElement(passwordLocator).sendKeys(password);
    }

    public AccountPage submitForm()
    {
        reporter.info("Submitting Login form");

        clickOnElement(loginButtonLocator);

        /*try
        {
            if (findElementsIgnoreException(loginErrorLocator, 2).size() > 0)
            {
                throw new Exception("Username/Password combination was NOT valid... ");
            }

        } catch (Exception e)
        {
            reporter.fail(e.getMessage(), e);
        }
        */

        return AccountPage.Instance;
    }

    public CreateAccountPage clickCreateAnAccount(){
        reporter.info("Click on Create Account button");
        findElement(createAccountLinkLocator).click();
        return CreateAccountPage.Instance;
    }


}
