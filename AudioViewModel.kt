@HiltViewModel
class AudioViewModel @Inject constructor(
    private val repository : AudioRepository
):ViewModel() {

    private var _audios: MutableLiveData<List<AudioModel>> = MutableLiveData()
    val audios: LiveData<List<AudioModel>> = _audios

    fun getAudios() {
        viewModelScope.launch {
            when (val result = repository.getUserAudios()) {
                is ResultWrapper.Error -> Log.e("TEST", "error")
                is ResultWrapper.Success -> _audios.value = result.value.items
            }
        }
    }
}
