/**
 * Типы ошибок с апи
 */

enum class ErrorTypeVk(val code:Int, @StringRes val title:Int, @StringRes val desc:Int? = null) {
    UNKNOWN_ERROR(code = 1, title = R.string.error_unknown_title, desc = R.string.error_unknown_desc),
    AUTH(code = 5, title = R.string.error_auth_title, desc = R.string.error_auth_desc),
    MANY_REQUEST(code = 6, title = R.string.error_many_requests_title, desc = R.string.error_many_requests_desc),
    NO_PERMISSION(code = 7, title = R.string.error_no_permission_title, desc = R.string.error_no_permission_desc),
    INVALID_REQUEST(code = 8, title = R.string.error_invalid_request_title, desc = R.string.error_invalid_request_desc),
    TOO_MANY_REQUEST(code = 9, title = R.string.error_too_many_action_title, R.string.error_too_many_action_desc),
    SERVER(code = 10, title = R.string.error_server_title, desc = R.string.error_server_desc),
    CAPTCHA(code = 14, title = R.string.error_captcha_title),
    ACCESS_DENIED(code = 15, title = R.string.error_access_denied_title),
    METHOD_REMOVE(code = 21, title = R.string.error_method_remove_title, desc = R.string.error_method_remove_description),
    RESPONSE_LIMIT(code = 29, title = R.string.error_response_limit_title, desc = R.string.error_response_limit_desc),
    PRIVATE_ALBUM(code = 200, title = R.string.error_album_private_title),
    ALBUM_FULL(code = 300, title = R.string.error_album_full_title)
}
