//Definitions for Java project
package definitions;

import cucumber.api.java.en.Given;

import java.util.Locale;

public class JavaStepDefs {
    @Given("I print Hello World")
    public void iPrintHelloWorld() {
        System.out.println("Hello World");
    }

    @Given("I print {string}")
    public void iPrint(String sWord) {
        System.out.println(sWord);
    }

    @Given("I print {string} and {string}")
    public void iPrintAnd(String sText1, String sText2) {
        String sChar ="!";
        System.out.println(sText1 + " " + sText2 + sChar);
        System.out.println(sText2.toLowerCase()+ sChar);
        System.out.println(sText2.toUpperCase()+ sChar);

    }

    @Given("I work with number {int} and number {int}")
    public void iWorkWithNumberAndNumber(int iNum1, int iNum2) {
        int iSum = iNum1 + iNum2;
        int iDif = iNum1 - iNum2;
        int iPro = iNum1 * iNum2;
        int iDiv = iNum1 / iNum2;
        System.out.println(iNum1 + "+" + iNum2 + "=" + iSum);
        System.out.println("The difference btw "+ iNum1 + " and "+ iNum2 + " is "+ iDif);
        System.out.println(iPro);
        System.out.println("Division " + iDiv);




    }
}
