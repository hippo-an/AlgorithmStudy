package ch02;

import java.util.Scanner;

public class DayOfYear {

    static int [][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int year, int month, int day) {
        while(--month != 0) {
            day += mdays[isLeap(year)][month - 1];
        }
        return day;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String retry;

        System.out.println("그 해의 경과 일수를 구합니다.");

        do {
            System.out.print("년 : ");
            int year = sc.nextInt();
            System.out.print("월 : ");
            int month = sc.nextInt();
            System.out.print("일 : ");
            int days = sc.nextInt();

            System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, days));

            System.out.print("baby one more time??? [Y/N] : ");
            retry = sc.next();
        } while("y".equalsIgnoreCase(retry));
    }

}
