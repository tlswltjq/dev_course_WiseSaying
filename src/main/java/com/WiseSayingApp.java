package com;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class WiseSayingApp {
    static ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();

    public static void start(){
        Scanner sc = new Scanner(System.in);

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
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-----------------------------");
                    IntStream.range(0, wiseSayingList.size())
                            .forEach(i -> {
                                WiseSaying ws = wiseSayingList.get(i);
                                System.out.printf("%d / %s / %s\n", i + 1, ws.author, ws.content);
                            });
                    break;
            }
        }
        sc.close();
    }
}
