/**
 * Базовый класс для репозитория
 * Помогает безопасно обращаться к апи обрабатывая все выбрасываемые исключения
 */
open class BaseRepository {

    /**
     * Безопасный вызов api методов
     * @param dispatcher Диспетчер потока
     * @param apiCall асинхронный метод который должен вернуть дженерик
     */
    suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> Response<BaseResponseModel<T>>): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                val response = apiCall.invoke()

                /**
                 * Провряем запрос на ошибки и выкидываем исключения
                 */
                if (!response.isSuccessful) throw HttpException(response)
                if (response.body() == null) throw VkException(ErrorTypeVk.UNKNOWN_ERROR.code)
                if (response.body()!!.error != null) throw VkException(response.body()!!.error!!.error_code)

                /**
                 * В случае если исключений не возникло возвращаем успешный результат.
                 */
                ResultWrapper.Success(apiCall.invoke().body()!!.response)
            }catch (throwable: Throwable){

                /**
                 * Проверяем тип исключения
                 */
                when (throwable){

                    //серверная ошибка
                    is HttpException -> {
                        ResultWrapper.Error(
                            ErrorType.HTTPError(throwable.code())
                        )
                    }

                    //ошибка со стороны апи
                    is VkException -> ResultWrapper.Error(
                        ErrorType.VkError(throwable.code)
                    )

                    //неизвестная ошибка
                    else -> ResultWrapper.Error(
                        ErrorType.VkError(ErrorTypeVk.UNKNOWN_ERROR.code)
                    )
                }
            }
        }
    }

    class VkException(val code:Int):Exception()
}
