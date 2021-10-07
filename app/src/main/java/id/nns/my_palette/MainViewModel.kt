package id.nns.my_palette

//import android.graphics.Bitmap
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.palette.graphics.Palette
//
//class MainViewModel : ViewModel() {
//
//    private val _vibrant = MutableLiveData<Int>()
//    val vibrant: LiveData<Int> get() = _vibrant
//
//    private val _vibrantDark = MutableLiveData<Int>()
//    val vibrantDark: LiveData<Int> get() = _vibrantDark
//
//    private val _vibrantLight = MutableLiveData<Int>()
//    val vibrantLight: LiveData<Int> get() = _vibrantLight
//
//    private val _muted = MutableLiveData<Int>()
//    val muted: LiveData<Int> get() = _muted
//
//    private val _mutedDark = MutableLiveData<Int>()
//    val mutedDark: LiveData<Int> get() = _mutedDark
//
//    private val _mutedLight = MutableLiveData<Int>()
//    val mutedLight: LiveData<Int> get() = _mutedLight
//
//    private val _dominant = MutableLiveData<Int>()
//    val dominant: LiveData<Int> get() = _dominant
//
//    fun getPalette(
//        bitmap: Bitmap,
//    ) {
//        Palette.from(bitmap).generate { palette ->
//            val defValue = 0x000000
//
//            _vibrant.value = palette?.getVibrantColor(defValue)
//            _vibrantDark.value = palette?.getDarkVibrantColor(defValue)
//            _vibrantLight.value = palette?.getLightVibrantColor(defValue)
//            _muted.value = palette?.getMutedColor(defValue)
//            _mutedDark.value = palette?.getDarkMutedColor(defValue)
//            _mutedLight.value = palette?.getLightMutedColor(defValue)
//            _dominant.value = palette?.getDominantColor(defValue)
//        }
//    }
//
//}