package lottopackage.view;

import java.util.*;

public class InputView {
    /* Member variable */
    private final static Scanner SCANNER = new Scanner(System.in).useDelimiter("\\s*\\n\\s*");

    /* Method */
    public static int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return SCANNER.nextInt();
    }

    public static Set<Integer> winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요. (ex) 3, 41, 29, 38, 11, 6");

        String winningNumberString = SCANNER.next();
        String[] winningNumberStringArray = winningNumberString.replaceAll(" ", "").split(",");

        Set<Integer> winningNumber = new HashSet<>();
        try {
            winningNumberStringArrayToWinningNumber(winningNumberStringArray, winningNumber);
        } catch (Exception exception) {
            throw new IllegalArgumentException("당첨 번호를 잘못 입력했습니다.");
        }

        return winningNumber;
    }

    public static void winningNumberStringArrayToWinningNumber(String[] winningNumberStringArray, Set<Integer> winningNumber) {
        for (String number : winningNumberStringArray) {
            winningNumber.add(Integer.valueOf(number));
        }
    }
}
