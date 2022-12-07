package org.ballad.javacommon.algorithms.msc.code2021;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        boolean end = false;

        while (scr.hasNext()) {
            String s = scr.nextLine();

            String[] floats = s.split(" ");
            double amount = 0;
            end = false;

            for (int i = 0; i < floats.length; i++) {
                Integer amt = Integer.valueOf(scr.nextLine());

                if (i == floats.length - 1) {
                    end = true;
                }
                // 今日利率
                double flt = Double.valueOf(floats[i]);
                if (amt >= 0) {
                    // 今日利息
                    double lixi = amount / 10000 * flt;

                    if (!end) {
                        // System.out.println((i+1)+" "+amount);
                        amount += lixi;
                        // System.out.println((i+1)+" "+lixi);
                        // 今日总金额
                        amount += amt;
                    }

                } else {
                    // 今日总金额
                    amount += amt;
                    // 今日利息
                    double lixi = amount / 10000 * flt;
                    // System.out.println((i+1)+" "+amount);
                    if (!end) {
                        amount += lixi;
                    }
                    // System.out.println((i+1)+" "+lixi);
                }
            }

            NumberFormat percentFormat = NumberFormat.getNumberInstance();
            String formatStr = "0.00";
            DecimalFormat format = new DecimalFormat(formatStr);
            String showValue = format.format((Double) amount);

            System.out.println(showValue);
        }
        scr.close();
    }
}