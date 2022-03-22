@Singleton
class AudioRepository @Inject constructor(
    private val api: AudioApi
) : BaseRepository() {

    private val token = "hgkdsfhgksd"
    private val ownerId = 000

    /**
     * Делаем безопасный вызов из родительского репозитория
     */
  
    suspend fun getUserAudios(): ResultWrapper<ResponseListItems<AudioModel>>
    {
        return safeApiCall(Dispatchers.IO) {
            api.getAudio(
                token = token
            )
        }
    }
}
