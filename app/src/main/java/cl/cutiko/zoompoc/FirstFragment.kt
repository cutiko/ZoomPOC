package cl.cutiko.zoompoc

import android.os.Bundle
import android.view.LayoutInflater
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(URL).into(pocImageView)
        pocImageView.setOnClickListener {
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val URL = "https://unsplash.com/photos/qO-PIF84Vxg/download?force=true&w=640"
    }
}