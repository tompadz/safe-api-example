interface AudioApi {
  
    @GET("audio.getById")
    suspend fun getAudioById(
        @Query("access_token")token:String,
        @Query("audios")audios:String = "239859595_45624038",
        @Query("v")version:Float = 5.95f
    ) : Response<BaseResponseModel<AudioModel>>
  
}
