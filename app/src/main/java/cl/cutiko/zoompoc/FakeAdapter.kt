package cl.cutiko.zoompoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FakeAdapter : RecyclerView.Adapter<ZoomViewHolder>() {

    private val urls = listOf(
        "https://unsplash.com/photos/qO-PIF84Vxg/download?force=true&w=640",
        "https://unsplash.com/photos/7GX5aICb5i4/download?force=true&w=640",
        "https://unsplash.com/photos/lylCw4zcA7I/download?force=true&w=640",
        "https://unsplash.com/photos/uGP_6CAD-14/download?force=true&w=640",
        "https://unsplash.com/photos/xP_AGmeEa6s/download?force=true&w=640"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZoomViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_zoomable_image, parent, false)
        return ZoomViewHolder(layout)
    }

    override fun getItemCount() = urls.size

    override fun onBindViewHolder(holder: ZoomViewHolder, position: Int) {
        val url = urls[position]
        holder.setRowUi(url)
    }

}

class ZoomViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

    fun setRowUi(url: String) {
        val imageView = root.findViewById<ImageView>(R.id.pocImageView)
        Picasso.get().load(url).into(imageView)
    }

}