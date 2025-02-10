import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 리턴하기 위한 변수 선언
        int answer = 0;

        // stack 을 이용하여 동일한 인형을 뽑는경우, pop을 하기 위한 변수 선언
        Stack<Integer> stack = new Stack<>();
        // 크레인이 2차원 배열에서의 몇번쨰 열로 이동할지 반복문 순회
        for (int i = 0; i < moves.length; i++) {
            // 크레인이 2차원 0번째 인덱스부터 뽑는 값이 0인지 아닌지 확인하기 위한
            // 2차원 배열길이만큼 반복문을 순회하면서 0값이 아닌 값 찾기
            for (int j = 0; j < board.length; j++) {
                // 크레인이 움직여서 찾은 열의 값 꺼내기
                int data = board[j][moves[i] - 1];
                // 만약 이 값이 0이 아니라면, 크레인이 꺼낸 인형의 값이라 볼 수 있음
                // 다만 값이 0인 경우는 계속해서 해당 반복문을 실행
                if (data != 0) {
                    // 0이 아닌 값을 찾은 경우는 이제 동일한 인형이 stack 에 담긴건지 확인을 해야함
                    // 또한 해당 인덱스에 위치하는 값은 꺼내서 stack으로 일단 이동하거나, pop 되기에 0으로 할당해야함
                    board[j][moves[i] - 1] = 0;
                    // 만약 stack이 빈값이라면, 그냥 push 진행
                    if (stack.isEmpty()) {
                        stack.push(data);
                    } else {
                        // 빈값이 아니라면 이전의 stack에 담긴값이랑 비교함
                        // stack에 담겨있는 값이 인형인데, 해당 인형값과 현재 data값이 일치한다면 pop 처리해야함
                        Integer peek = stack.peek();
                        if (peek.equals(data)) {
                            // +2 하는 이유는, 인형이 2개가 일치해서 사라지는 것이기에 +2 처리
                            answer += 2;
                            stack.pop();
                        } else {
                            // 값이 같지 않다면, stack 에 push
                            stack.push(data);
                        }
                    }
                    // data 가 0이 아니라는건 더이상 크레인이 아래로 내려갈 필요가 없음, 0이 아닌시점에서 크레인은 이미 인형을 뽑았다고 판단
                    // 해당 반복문을 종료함
                    break;
                }
            }
        }
        // 결과값 리턴
        return answer;
    }
}