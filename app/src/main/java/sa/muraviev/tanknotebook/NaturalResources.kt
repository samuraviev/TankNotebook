package sa.muraviev.tanknotebook

import sa.muraviev.tanknotebook.Enumeration.Coordinate
import sa.muraviev.tanknotebook.Enumeration.naturalResources

class NaturalResources(
    var type: naturalResources,
    var coordinate: Coordinate,
    var idView:Int?=null,
):ImageView()  {
    fun create(){
        var imageView = addNaturalResources(
            type,
            coordinate
        )
        idView=imageView?.id
        arrayNaturalResources.add(this)
        setOnTouchListenerImageView(imageView)
    }

    private fun setOnTouchListenerImageView(imageView: android.widget.ImageView?){
        //слушатель нажатия на картинки
        imageView?.setOnTouchListener { view, motionEvent ->
            if (selectedTank==null){
                //танк не выбран

            }else{
                //танк выбран, пошлем его на заправку

            }

            true
        }
    }

}

