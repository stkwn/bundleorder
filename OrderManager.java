package com.bundleorder;

import java.util.Scanner;

public class OrderManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.println("---------Bundle Order Manager System---------");
            System.out.println("1. Print the bundle price menu");
            System.out.println("2. Make an order");
            System.out.println("3. Exit");
            System.out.println("Please choose the option:");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    printbundleprice();
                    break;
                case "2":
                    makeAnOrder();
                    break;
                case "3":
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice, please choose the option again.");
                    System.out.println("---------------------------------------------");
                    break;
            }
        }
    }

    public static void printbundleprice() {
        Image img = new Image();
        Audio audio = new Audio();
        Video video = new Video();
        System.out.println("Submission_format\tFormat_code\tBundles_Number\tBundles_price");
        System.out.println("-------------------------------------------------------------");
        img.printBundlePrice();
        System.out.println("-------------------------------------------------------------");
        audio.printBundlePrice();
        System.out.println("-------------------------------------------------------------");
        video.printBundlePrice();
        System.out.println("-------------------------------------------------------------");
    }

    //funciton for request customer to get the right number prevent from input non-integer number.
    public static int requestNum(String type) {
        Scanner sc = new Scanner(System.in);
        String numstring;
        int num;
        while (true) {
            System.out.println("Please input the number for" + type + ":");
            if (sc.hasNextInt()) {
                numstring = sc.next();
                num = Integer.parseInt(numstring);
                if (num < 0) {
                    System.out.println("Please input a number >= 0");
                } else {
                    break;
                }
            } else {
                numstring = sc.next();
                System.out.println(numstring + " is not a number");
            }
        }
        return num;
    }

    //function for print the result.
    public static void makeAnOrder() {
        Image img = new Image();
        Audio audio = new Audio();
        Video video = new Video();
//            Scanner sc = new Scanner(System.in);
        int[] requestnumber = {0, 0, 0};
        requestnumber[0] = requestNum(" Image");
        requestnumber[1] = requestNum(" Audio");
        requestnumber[2] = requestNum(" Video");
        if (requestnumber[0] >0){
        img.printRequestPrice(requestnumber[0]);}
        if (requestnumber[1] >0) {
        audio.printRequestPrice(requestnumber[1]);}
        if (requestnumber[2] >0) {
        video.printRequestPrice(requestnumber[2]);}
    }


}

