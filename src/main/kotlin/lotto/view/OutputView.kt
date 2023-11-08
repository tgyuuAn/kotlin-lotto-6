package lotto.view

import lotto.domain.LottoBundle
import lotto.domain.LottoRank
import lotto.domain.LottoRank.INIT
import lotto.domain.LottoRank.NOTHING

object OutputView {
    fun printLottoBundleNumbers(lottobundle: LottoBundle) {
        println("${lottobundle.amount()}개를 구매했습니다.")
        lottobundle.forEach { lotto ->
            println(lotto.toString())
        }
        println()
    }

    fun printLottoResult(lottoBundle: LottoBundle) {
        LottoRank.entries.forEach { lottoRank ->
            if (lottoRank != NOTHING && lottoRank != INIT) {
                val rankCount = lottoBundle.winningRanksCount.getValue(lottoRank)

                println("${lottoRank.message} (${lottoRank.prize}) - ${rankCount}개")
            }
        }
        printRateOfReturn(lottoBundle = lottoBundle)
    }

    fun printRateOfReturn(lottoBundle: LottoBundle) {
        println("총 수익률은 ${lottoBundle.getRateOfReturn()}%입니다.")
    }
}