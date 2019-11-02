package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import sun.jvm.hotspot.runtime.Thread;
import org.openqa.selenium.By;

public class DressPage {
    @FindBy(id = "quantity_wanted")
    private WebElement buyEdit;

    public void editBuy (int quantityNumber) {

        //изменить кол-во
        buyEdit.clear();
        buyEdit.sendKeys(String.valueOf(quantityNumber));

        //изменить размер
        buyEdit.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")).click();

        //выбрать цвет
        buyEdit.findElement(By.xpath("//*[@id=\"color_14\"]")).click();

        //добавить в корзину
        buyEdit.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();

        //нажать перейти в корзину
        buyEdit.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order']")).click();
    }
}
