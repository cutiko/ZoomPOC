package cl.cutiko.zoompoc

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val scalings = mutableListOf<Float>()
    private var lastScalingTime = 0L
    //private var calculatedScaleFactor = SCALE_FACTOR

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    //TODO support clicking?
    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(URL).centerCrop().fit().into(pocImageView)
        val scaleDetector = ScaleGestureDetector(requireContext(), object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector?): Boolean {
                val eventHandled = super.onScale(detector)
                detector?.scaleFactor?.let { scaleFactor ->
                    Log.d("CUTIKO_TAG", "$scaleFactor" );
                    val timeStamp = System.currentTimeMillis()
                    if (timeStamp - lastScalingTime > COOL_DOWN) {
                        lastScalingTime = timeStamp
                        val lastScale = scalings.lastOrNull()
                        scalings.add(scaleFactor)
                        if (lastScale != null && lastScale < scaleFactor) {
                            scaleImage(scaleFactor)
                        }
                    }
                }
                return eventHandled
            }
        })


        pocImageView.setOnTouchListener { imageView, event ->
            scaleDetector.onTouchEvent(event)
            //imageView.performClick()
            true
        }
        pocImageView.setOnClickListener {
            Toast.makeText(requireContext(), "clicked", Toast.LENGTH_LONG).show()
        }
    }

    private fun scaleImage(scaleFactor: Float) {
        pocImageView.scaleX = scaleFactor
        pocImageView.scaleY = scaleFactor
    }



    companion object {
        private const val URL = "https://unsplash.com/photos/qO-PIF84Vxg/download?force=true&w=640"
        private const val COOL_DOWN = 120
        /*private const val SCALE_FACTOR = 1.0F
        private const val MIN_SCALE_FACTOR = 0.1F
        private const val MAX_SCALE_FACTOR = 10.0F*/
    }
}