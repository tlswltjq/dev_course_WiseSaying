package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd;
            cmd = sc.nextLine().trim();
            if (cmd.equals("종료")) {
                break;
            }

            switch (cmd) {
                case "종료":
                    return;
                case "등록":
                    System.out.print("명언 : ");
                    String wiseSayingContent = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String wiseSayingAuthor = sc.nextLine().trim();
                    wiseSayingList.add(new WiseSaying(wiseSayingContent, wiseSayingAuthor));
                    System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSayingList.size());
                    break;
            }
        }
        sc.close();
    }
}