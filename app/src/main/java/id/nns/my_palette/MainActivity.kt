package id.nns.my_palette

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
//import androidx.activity.viewModels
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.nns.my_palette.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private val viewModel: MainViewModel by viewModels()

    private val images = listOf(
        "https://firebasestorage.googleapis.com/v0/b/kotlin-chat-app-a650f.appspot.com/o/images%2Fnaruto.png?alt=media&token=eaf45217-9b73-4169-acae-17ac73a42691",
        "https://firebasestorage.googleapis.com/v0/b/kotlin-chat-app-a650f.appspot.com/o/images%2Fsasuke.png?alt=media&token=75d4c7cf-1be5-4ab8-9de3-d3bec5e72713"
    )

    private val spinnerItems = Array(images.size) {
        "Gambar ${it + 1}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSpinner()
//        observe()
    }

    private fun setSpinner() {
        val adapter =
            ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                spinnerItems
            )

        binding.spinnerSelectImage.adapter = adapter
        binding.spinnerSelectImage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) = Unit

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Glide.with(this@MainActivity)
                    .asBitmap()
                    .load(images[p2])
                    .into(object: CustomTarget<Bitmap>() {
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            binding.imagePreview.setImageBitmap(resource)

//                            viewModel.getPalette(
//                                bitmap = resource
//                            )

                            getPalette(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) = Unit
                    })
            }
        }
    }

//    private fun observe() {
//        viewModel.vibrant.observe(this) {
//            binding.prevVibrant.setBackgroundColor(it)
//        }
//        viewModel.vibrantDark.observe(this) {
//            binding.prevVibrantDark.setBackgroundColor(it)
//        }
//        viewModel.vibrantLight.observe(this) {
//            binding.prevVibrantLight.setBackgroundColor(it)
//        }
//        viewModel.muted.observe(this) {
//            binding.prevMuted.setBackgroundColor(it)
//        }
//        viewModel.mutedDark.observe(this) {
//            binding.prevMutedDark.setBackgroundColor(it)
//        }
//        viewModel.mutedLight.observe(this) {
//            binding.prevMutedLight.setBackgroundColor(it)
//        }
//        viewModel.dominant.observe(this) {
//            binding.prevDominant.setBackgroundColor(it)
//        }
//    }

    private fun getPalette(
        bitmap: Bitmap,
    ) {
        Palette.from(bitmap).generate { palette ->
            val defValue = 0x000000

            binding.prevVibrant.setBackgroundColor(palette?.getVibrantColor(defValue) ?: defValue)
            binding.prevVibrantDark.setBackgroundColor(palette?.getDarkVibrantColor(defValue) ?: defValue)
            binding.prevVibrantLight.setBackgroundColor(palette?.getLightVibrantColor(defValue) ?: defValue)
            binding.prevMuted.setBackgroundColor(palette?.getMutedColor(defValue) ?: defValue)
            binding.prevMutedDark.setBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
            binding.prevMutedLight.setBackgroundColor(palette?.getLightMutedColor(defValue) ?: defValue)
            binding.prevDominant.setBackgroundColor(palette?.getDominantColor(defValue) ?: defValue)
        }
    }

}