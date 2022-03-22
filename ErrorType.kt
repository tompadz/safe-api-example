sealed class ErrorType {
    data class VkError(val code:Int): ErrorType()
    data class HTTPError(val code:Int): ErrorType()
}
