package view

import error.CoordinateResult
import error.ErrorHandler
import error.OmokError
import error.PlaceStoneResult
import error.StoneReadResult

class ConsoleViewErrorHandler(private val gameView: GameView) : ErrorHandler {
    override fun log(exception: OmokError) {
        gameView.renderError(
            "[ERROR] : ${
            when (exception) {
                is CoordinateResult.OutOfBoard ->
                    MESSAGE_OUT_OF_BOARD

                is PlaceStoneResult.LongPlaceStone ->
                    MESSAGE_LONG_STONE

                is PlaceStoneResult.FourToFour ->
                    MESSAGE_FOUR_FOUR

                is PlaceStoneResult.ThreeToThree ->
                    MESSAGE_THREE_THREE

                is PlaceStoneResult.DuplicatedCoordinate ->
                    MESSAGE_CORRUPTED_COORDINATE

                is StoneReadResult.ColumnNotAlpha ->
                    MESSAGE_COLUMN_MUST_BE_ALPHA

                is StoneReadResult.RowNotNumeric ->
                    MESSAGE_ROW_MUST_BE_NUM

                else ->
                    "처리되지 않은 에러입니다."
            }
            }"
        )
    }

    companion object {
        private const val MESSAGE_OUT_OF_BOARD = "보드의 범위에 벗어나는 좌표입니다."
        private const val MESSAGE_LONG_STONE = "육목입니다."
        private const val MESSAGE_THREE_THREE = "3-3입니다."
        private const val MESSAGE_FOUR_FOUR = "4-4입니다."
        private const val MESSAGE_CORRUPTED_COORDINATE = "중복된 위치에 이미 돌이 있습니다."
        private const val MESSAGE_COLUMN_MUST_BE_ALPHA = "행은 반드시 영문자여야 합니다."
        private const val MESSAGE_ROW_MUST_BE_NUM = "열은 반드시 숫자여야 합니다."
    }
}
