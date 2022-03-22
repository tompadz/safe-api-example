/**
 * Типы серверных ошибок
 */
enum class ErrorTypeHTTP(val code:Int, @StringRes val title:Int, @StringRes val desc:Int? = null) {
    INTERNAL_ERROR(code = 500, title = "error title"),
    NOT_IMPL_ERROR(code = 501, title = "error title"),
    BAD_GATEWAY_ERROR(code = 502, title = "error title"),
    UNAVAILABLE_ERROR(code = 503, title = "error title"),
    TIMEOUT_ERROR(code = 504, title = "error title"),
    UNKNOWN_ERROR(code = 1, title = "error title", desc = "error descr"),
}
