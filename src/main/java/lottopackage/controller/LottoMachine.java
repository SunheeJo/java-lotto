package lottopackage.controller;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoBall;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    public static void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
        OutputView.printLottoGroup(lottoGroup.getLottoGroup());

        List<Prize> lottoResult = lottoGroup.isWinning(InputView.winningNumber());
        OutputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }

    private static int numOfLotto() {
        int purchaseAmount = InputView.purchaseAmount();
        int numOfLotto = Lotto.purchaseLotto(purchaseAmount);
        OutputView.printNumOfLotto(numOfLotto);
        return numOfLotto;
    }

}
