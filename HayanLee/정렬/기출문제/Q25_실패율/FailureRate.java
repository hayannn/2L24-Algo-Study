package HayanLee.정렬.기출문제.Q25_실패율;

//첫 풀이 : 13:12 ~ 13:35
/*
0. Comparable로 Game 클래스 - stage, fail 변수 작성하기
1. 배열 선언 및 스테이지 변수 선언하기
2. 실패율 계산하기
   - 스테이지 도달했으나 클리어 못한 플레이어 수 / 스테이지 도달한 플레이어 수
3. 스테이지 return : 실패율이 높은 사용자부터 내림차순 정렬
*/

import java.util.*;

class Game implements Comparable<Game> {

    private int stage;
    private int fail;

    public Game(int stage, int fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return this.stage;
    }

    @Override
    public int compareTo(Game other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Integer.compare(other.fail, this.fail);
    }
}


class Solution {
    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        ArrayList<Game> Game = new ArrayList<>();

        int player = 0;

        for(int i=0; i<N; i++){
            int fail = player / stages.length;
            Game.add(new Game(i, fail));
        }

        Collections.sort(Game);

        for(int i=0; i<N; i++){
            answer[i] = Game.get(i).getStage();
        }
        return answer;
    }
}