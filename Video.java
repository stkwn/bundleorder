package com.bundleorder;

public class Video {
    String submission_format = "Video";
    String format_code = "VID";
    int[] bundle_number = {3, 5, 9}; // 3 types of bundle
    double[] bundle_price = {570, 900, 1530}; //3 types of bundle price
    int[] breakdown_number = {0, 0, 0};  //3 breakdown

    //funciton for print the price list
    public void printBundlePrice() {

        for (var i = 0; i < bundle_number.length; i++) {
            System.out.println(submission_format + "\t\t\t\t" + format_code + "\t\t\t" + bundle_number[i] + "\t\t\t\t" + bundle_price[i]);
        }
    }

    //function for breakdown the ruquestnumber
    public void breakBundleOrder(int requestnumber) {
        breakdown_number[0] = 0;
        breakdown_number[1] = 0;
        breakdown_number[2] = 0;
        int remainder = requestnumber % 9;
        if (requestnumber <= 11) {
            if (requestnumber <= 3) {
                breakdown_number[0]++;
            } else if (requestnumber <= 5) {
                breakdown_number[1]++;
            } else if (requestnumber <= 9) {
                breakdown_number[2]++;
            } else if (requestnumber == 10) {
                breakdown_number[1] = 2;
            } else if (requestnumber == 11) {
                breakdown_number[0] = 1;
                breakdown_number[2] = 1;
            }
        } else {
//                System.out.println(requestnumber);
                breakdown_number[2] = (int) (requestnumber / 9);
//                System.out.println(breakdown_number[2]);
//                System.out.println(remainder);
                switch (remainder) {
                    case 1:
                        breakdown_number[2] -= 1;
                        breakdown_number[1] = 2;
                        break;
                    case 2:
                        breakdown_number[2] -= 2;
                        breakdown_number[1] = 4;
                        break;
                    case 3:
                        breakdown_number[0] = 1;
                        break;
                    case 4:
                        breakdown_number[2] -= 1;
                        breakdown_number[1] = 2;
                        breakdown_number[0] = 1;
                        break;
                    case 5:
                        breakdown_number[1] = 1;
                        break;
                    case 6:
                        breakdown_number[0] = 2;
                        break;
                    case 7:
                        breakdown_number[2] -= 1;
                        breakdown_number[1] = 2;
                        breakdown_number[0] = 2;
                        break;
                    case 8:
                        breakdown_number[1] = 1;
                        breakdown_number[0] = 1;
                        break;
                }
            }
//        return breakdown_number;
    }

    //function for print the result
    public void printRequestPrice(int requestnumber) {
        breakBundleOrder(requestnumber);
//        System.out.println(breakdown_number[0]);
//        System.out.println(breakdown_number[1]);
        double sum0 = breakdown_number[0] * bundle_price[0];
        double sum1 = breakdown_number[1] * bundle_price[1];
        double sum2 = breakdown_number[2] * bundle_price[2];
        double total = sum0 + sum1 + sum2;
        System.out.println(requestnumber + " " + format_code + " $" + total);
        if (breakdown_number[0] != 0) {
            System.out.println("    " + breakdown_number[0] + " x " + bundle_number[0] + " $" + sum0);
        }
        if (breakdown_number[1] != 0) {
            System.out.println("    " + breakdown_number[1] + " x " + bundle_number[1] + " $" + sum1);
        }
        if (breakdown_number[2] != 0) {
            System.out.println("    " + breakdown_number[2] + " x " + bundle_number[2] + " $" + sum2);
        }
    }



}