/**
 * 문자열 계산기 요구사항
 * 1. 전달되는 문자를 구분자(, 호은 ;)로 분리한 후, 각 숫자의 합을 구해 반환
 * 2. 커스텀 구분자도 가능 : //, \n 사이에 존재하는 문자를 커스텀 구분자로 사용
 * 3. 문자열 계산기에 음수가 전달되면 RuntimeException으로 예외처리
 *
 * 만약 //로 시작되면 문자열의 3번째 문자가 구분자
 * 숫자로 시작하면
 * */
public class Calculator {

    public int add(int a, int b) {
        return a+b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

}
