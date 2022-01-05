package com.bundleorder;

import java.util.ArrayList;

public class Image {
    String submission_format = "Image";
    String format_code = "IMG";
    int[] bundle_number = {5, 10};
    double[] bundle_price = {450, 800};
    int[] breakdown_number = {0, 0};

    public void printBundlePrice() {
        for (var i = 0; i < bundle_number.length; i++) {
            System.out.println(submission_format + "\t\t\t\t" + format_code + "\t\t\t" + bundle_number[i] + "\t\t\t\t" + bundle_price[i]);
        }
    }

    public void breakBundleOrder(int requestnumber) {
        breakdown_number[0] = 0;
        breakdown_number[1] = 0;
        if (requestnumber % 10 == 0) {
            breakdown_number[1] = (int) (requestnumber / 10);
        } else if (requestnumber % 10 <= 5) {
            breakdown_number[1] = (int) (requestnumber / 10);
            breakdown_number[0]++;
        } else {
            breakdown_number[1] = (int) (requestnumber / 10);
            breakdown_number[1]++;
        }
//        return breakdown_number;
    }

    public void printRequestPrice(int requestnumber) {
        breakBundleOrder(requestnumber);
        double sum0 = breakdown_number[0] * bundle_price[0];
        double sum1 = breakdown_number[1] * bundle_price[1];
        double total = sum0 +sum1;
        System.out.println(requestnumber + " " + format_code + " $" + total);
        if (breakdown_number[0] != 0) {
            System.out.println("    " + breakdown_number[0] + " x " + bundle_number[0] + " $" + sum0);
        }
        if (breakdown_number[1] != 0) {
            System.out.println("    " + breakdown_number[1] + " x " + bundle_number[1] + " $" + sum1);
        }
    }



}



