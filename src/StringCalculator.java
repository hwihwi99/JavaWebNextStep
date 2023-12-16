import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 모든 요구사항은 이 함수에서 구현되어야 한다.
    public int add(String inputStr) {

        // input이 null이거나 0이면 0을 리턴한다. (문자열은 항상 처음에 null 먼저 체크)
        if(isInputNullOrZero(inputStr)) {
            return  0;
        }
        return stringCalculator(inputStr);
    }


    // input이 null이거나 0이면 true, 아니면 false
    private boolean isInputNullOrZero(String str) {
        if(str == null || str == "" || str.equals("0")){ //문자열 ㅎisBlank 함수
            return true;
        } else {
            return false;
        }
    }

    private int stringCalculator (String str) {
        Matcher matcher =  Pattern.compile("//(.)\n(.*)").matcher(str); // '//'와 '\n' 사이의 문자를 찾는다.
        if (matcher.find()) {
            String customerDelimiter = matcher.group(1); // 매칭되는 문자열 중 첫번째 문자열 반환, group(0)은 그룹의 전체 패턴을 의미함.
            return play(matcher.group(2), customerDelimiter);
        }
        return play(str, ",|:");
    }


    private int play(String targetStr, String delimiter) {

        if(delimiter.equals("-") && targetStr.contains("--")) { // speacial case 1
            myNumberForamtException();
        }
        int resultCalculator = 0;

        StringTokenizer st = new StringTokenizer(targetStr,delimiter);

        while (st.hasMoreElements()) {
            String temp = st.nextToken();
            try{
                if(temp == "") { // speacial case3
                    temp = "0";
                }
                int tempNum = Integer.parseInt(temp); // 문자열에 숫자가 아닌 다른 값이 존재하면 numberformatException
                if(tempNum < 0) { // 음수면 runtimeException (요구사항조건)
                    myRuntimeException();
                }
                resultCalculator += tempNum;
            }catch (NumberFormatException e) {
                throw e;
            } catch (RuntimeException e) {
                throw e;
            }
        }

        return resultCalculator;
    }


    static public void myNumberForamtException() throws NumberFormatException{
        throw new NumberFormatException();
    }

    static public void myRuntimeException() throws RuntimeException{
        throw new RuntimeException();
    }


    /**
     * 생각해야하는 예외 speacial case
     *
     * 1) //-\n321--123 이러면 계산되는게 아니구 numberException 해야함
     *
     * 2) split문자열이 \\문자 여야하는 경우 (온점같은 경우) -> 그래서 StringTokenizer 사용
     *
     * 3) 321:"":423 이런경우 계산되어야하는가? -> 그렇다면 구현 다시
     * */
    public static void main(String[] args) {

        StringCalculator s = new StringCalculator();

        System.out.println(s.add(null));
        System.out.println(s.add(""));
        System.out.println(s.add("543"));
        System.out.println(s.add("//=\n123=456"));
        // System.out.println(s.add("//-\n123--456"));
        System.out.println(s.add("//.\n123.456"));
        //  split(".")을 했더니 안됐음. \\.로 split 해야한다고 함
        System.out.println(s.add("12312:54,543,,23,13423"));
    }
}
