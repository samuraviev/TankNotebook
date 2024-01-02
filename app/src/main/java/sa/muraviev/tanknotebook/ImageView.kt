package sa.muraviev.tanknotebook

import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

open class ImageView(

) {
    fun addImageView(layout2: ConstraintLayout, image: Int, coordinate: Coordinate, tag:String): ImageView {
        //добавим сами картинки на лэйаут
        val view = ImageView(context)
        view.setImageResource(image)
        val layoutParams = ConstraintLayout.LayoutParams(cellSize, cellSize)

        layoutParams.setMargins(coordinate.x* cellSize, coordinate.y*cellSize, -1, -1)//отступы

        layoutParams.leftToLeft =
            ConstraintLayout.LayoutParams.PARENT_ID//прижать слева к//ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID//прижать сверху к

        val viewId = View.generateViewId()
        view.id = viewId
        view.layoutParams = layoutParams
        view.visibility = View.GONE
        view.visibility = View.VISIBLE
        view.tag = tag

    //    runBlocking {
            layout2.addView(view)
     //   }

        layout2.postInvalidate()
        return view
    }

}