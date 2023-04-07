package com.example.asc;

public class ASCprocess {
    PImage img;
    String ascii = "@$B%8WM#*oahkbdpwmZO0QCJYXzcvnxrjft/\\|()1{}[]-_+~<>i!lI;:,\"^`'."; // 아스키 문자 셋 확장 (특수 문자 이스케이프 및 따옴표 처리)
    int scaleFactor = 2; // 문자 크기 조정 인자 변경

    void settings() {
        size(616 * scaleFactor, 584 * scaleFactor);
    }

    void setup() {
        img = loadImage("monalisa.jpg"); // 이미지 파일 불러오기
        img.resize(616, 584); // 이미지 크기 조절
        noLoop(); // draw 함수를 한 번만 호출
    }

    void draw() {
        background(255);
        textSize(scaleFactor); // 문자 크기 설정
        textAlign(CENTER, CENTER); // 문자 정렬

        for (int y = 0; y < img.height; y++) {
            for (int x = 0; x < img.width; x++) {
                color pixelColor = img.get(x, y); // 각 픽셀의 색상 정보
                float brightnessValue = brightness(pixelColor); // 픽셀의 밝기 정보

                int characterIndex = int(map(brightnessValue, 0, 255, 0, ascii.length() - 1)); // 밝기 값을 아스키 문자 셋 인덱스로 변환
                char asciiChar = ascii.charAt(characterIndex); // 아스키 문자 선택

                float xPos = x * scaleFactor; // 문자 x 위치
                float yPos = y * scaleFactor; // 문자 y 위치

                fill(pixelColor); // 문자 색상 설정
                text(asciiChar, xPos, yPos); // 아스키 문자 그리기
            }
        }
    }
}
