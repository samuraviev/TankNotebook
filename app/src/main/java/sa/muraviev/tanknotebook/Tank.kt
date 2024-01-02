package sa.muraviev.tanknotebook

import android.annotation.SuppressLint
import android.view.MotionEvent

class Tank(
    var coordinate: Coordinate,
    var idView:Int?=null,
    var target:Coordinate?=null,
    var nextCell: nextCell?=null,
):ImageView() {
    fun create(){
        //создадим танк
        var layout2= constraintLayout
        if (layout2!=null){
            var imageView=addImageView(
                layout2,
                R.drawable.tank,
                coordinate,
                "tank"
            )

            idView=imageView.id
            arrayTank.add(this)
            setOnTouchListenerImageView(imageView)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setOnTouchListenerImageView(imageView: android.widget.ImageView){
        //слушатель нажатия танка
        imageView.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP){
                //отпустили палец
                if (tank==null){
                    //танк по умолчанию не выбран, выберем
                    tank=arrayTank.firstOrNull { it.idView==view.id }
                }else{
                    if (tank==arrayTank.firstOrNull { it.idView==view.id }){
                        //кликнули по тому же танку, скинем выбор
                        tank=null
                    }else{
                        //кликнули по другому
                        tank=arrayTank.firstOrNull { it.idView==view.id }
                    }
                }
            }else{
                //

            }
            true
        }
    }

    fun move(){
        if (tank?.target!=null){
            if (tank?.nextCell!=null){
                //ячейки по 150, а шаг танка по 10, если танк выбрал идти в соседнюю ячейку он должен дойти до нее,
                //и только потом находить новую ячейку

                //нужно доходить в старую ячейку
            }else{
                //нужно найти новую соседнюю ячейку куда идет

            }
        }else{

        }
    }


}

data class nextCell(
    var coordinate: Coordinate,
    var countStep:Int,
){

}