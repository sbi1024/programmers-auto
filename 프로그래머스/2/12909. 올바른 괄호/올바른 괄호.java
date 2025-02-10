import java.io.IOException;
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        // 입력값을 char 배열로 생성한다.
        char[] charArray = s.toCharArray();
        // Charcter 타입의 stack 변수를 생성한다.
        Stack<Character> stack = new Stack<>();

        // 반복문을 통해 입력값의 배열을 순회한다.
        for (char ch : charArray) {
            // 만약 '(' 여는 문자가 나온경우, stack 에 넣는다.
            if (ch == '(') stack.push(ch);

            // 만약 ')' 닫는 문자가 나온경우, stack 의 pop 을 실행한다.
            // 이전의 문자가 '(' 여는 문자인지 확인이 필요하지 않는 이유는, 이미 stack 에 push 되는 문자는 여는 문자 '(' 만 push 된다.
            else {
                // 혹시 pop을 하기전에, 이미 빈 스택인 경우, ')'가 들어온 경우는 절대 올바른 괄호가 될 수 없다.
                // 예시로 빈 stack 인데, ')' 문자가 들어온 뒤, 다음 어떤 문자가 들어와도 첫번째 닫는 괄호 ')'는 올바른 괄호가 될 수 없다.
                // 그렇기에, 스택의 사이즈가 빈 값이면 return false 처리한다.
                if (stack.isEmpty()) return false;

                // 위 if 조건문을 만족하지 않는다면, 정상적으로 stack에서 '(' 문자를 제거한다.
                else stack.pop();
            }
        }

        // 반복문이 다 실행되고 난 뒤, 최종적으로 stack 변수가 빈값이어야 정상적인 괄호이다. 아닌 경우는 false를 return 한다.
        return stack.isEmpty();
    }
}