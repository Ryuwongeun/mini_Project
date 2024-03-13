package com.i.minishopping;

import com.i.minishopping.product.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.i.minishopping.user.service.UserService;

import java.util.Scanner;



@Configuration
@ComponentScan(basePackages = "com.i.minishopping")
public class Main {

    public void menu(ApplicationContext applicationContext){
        Scanner scan = new Scanner(System.in);

        int num;
        UserService userService = null;
        ProductService productService = null;

        while(true){
            System.out.println();
            System.out.println("1. user");
            System.out.println("2. product");
            System.out.print("번호 입력 : ");
            num = scan.nextInt();
            if(num == 1) {

                System.out.println();
                System.out.println("1. 입력");
                System.out.println("2. 출력");
                System.out.println("3. 수정");
                System.out.println("4. 삭제");
                System.out.println("5. 끝");
                System.out.println("번호 입력 : ");
                num = scan.nextInt();

                if(num==1) {
                    userService = (UserService) applicationContext.getBean("userInsertService");
                }else if(num==2) {
                    userService = (UserService) applicationContext.getBean("userSelectService");
                }
                else if(num==3) {
                    userService = (UserService) applicationContext.getBean("userUpdateService");
                }else if(num==4) {
                    userService = (UserService) applicationContext.getBean("userDeleteService");
                } // if-else if

                if(num==5) break;

                userService.execute();

            } else if(num == 2) {
                System.out.println();
                System.out.println("1. 입력");
                System.out.println("2. 출력");
                System.out.println("3. 수정");
                System.out.println("4. 삭제");
                System.out.println("5. 종료");
                System.out.print("번호 입력 : ");
                num = scan.nextInt();

                if(num==1) {
                    productService = applicationContext.getBean("productInsertService", ProductService.class);
                }else if(num==2) {
                    productService = applicationContext.getBean("productSelectService", ProductService.class);
                }
                else if(num==3) {
                    productService = applicationContext.getBean("productUpdateService", ProductService.class);
                }else if(num==4) {
                    productService = applicationContext.getBean("productDeleteService", ProductService.class);
                } // if-else if

                if(num==5) break;

                productService.execute();

            } else {
                System.out.println("1~2번 선택");
                continue;
            }

        } // while

    } // menu

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        Main main = (Main)applicationContext.getBean("main");
        main.menu(applicationContext);

        System.out.println("\n프로그램 종료합니다");
    } // main

} // end class
