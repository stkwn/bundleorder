package com.bundleorder;

public class Audio {
    private String submission_format = "Audio";
    private String format_code = "Flac";
    int[] bundle_number = {3,6,9};
    double[] bundle_price ={427.5,810,1147.5};
    int[] breakdown_number = {0,0,0};

    public void printBundlePrice() {

        for(var i=0; i< bundle_number.length; i++) {
            System.out.println(submission_format+"\t\t\t\t"+format_code+"\t\t"+bundle_number[i]+"\t\t\t\t"+bundle_price[i]);
        }
    }

    public void breakBundleOrder(int requestnumber) {
        breakdown_number[0] = 0;
        breakdown_number[1] = 0;
        breakdown_number[2] = 0;
        if (requestnumber % 9 ==0) {
            breakdown_number[2] = (int)(requestnumber /9);
        } else if (requestnumber % 9 <= 3) {
            breakdown_number[2] = (int) (requestnumber / 9);
            breakdown_number[0]++;
        } else if (requestnumber % 9 <= 6) {
            breakdown_number[2] = (int) (requestnumber / 9);
            breakdown_number[1]++;
        } else {
            breakdown_number[2] = (int) (requestnumber / 9);
            breakdown_number[2]++;
        }
//        return breakdown_number;
    }

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
