package sa.muraviev.tanknotebook

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_UP
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Layout(

):sa.muraviev.tanknotebook.ImageView() {
    fun create():ConstraintLayout?{
        //создадим игровой лэйаут
        var c= context
        return if (c!=null){
            val layout2 = ConstraintLayout(c)
            layout2.id = ConstraintLayout.generateViewId()
            var color=coordinatorLayout?.resources?.getColor(R.color.white)
            if (color!=null){
                layout2.setBackgroundColor(color)//resources.getColor(R.color.white)
            }
            val layoutParams = ConstraintLayout.LayoutParams(100* cellSize,
                100* cellSize)//растянуть по либо ширина и высота //ConstraintLayout.LayoutParams.MATCH_PARENT
            layout2.tag = "tag"
            layout2.layoutParams = layoutParams
            coordinatorLayout?.addView(layout2)
            constraintLayout= layout2

            setOnTouchListenerLayout(layout2)
            coffee(layout2)
            return layout2
        }else{
            null
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setOnTouchListenerLayout(layout2: ConstraintLayout){
        //слушатель нажатия на лэйаут, чисто для движения по экрану
        layout2.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_MOVE){
                //движение
                if (motionEvent.historySize > 0){
                    if (motionEvent.pointerCount == 1){
                    //один палец
                        layout2.y=layout2.y-motionEvent.getHistoricalY(0).toInt() + motionEvent.y.toInt()
                        layout2.x=layout2.x-motionEvent.getHistoricalX(0).toInt() + motionEvent.x.toInt()
                    }
                    if(motionEvent.pointerCount==2){
                    //два пальца

                    }
                }
            }else{
                //не движение
                if (motionEvent.action==ACTION_UP){
                    //подняли палец с лэйаута
                    if (tank!=null){
                        //танк выбран, установим ему цель в эти координаты
                        tank?.target=Coordinate(
                            (motionEvent.x/ cellSize).toInt(),
                            (motionEvent.y/ cellSize).toInt()
                        )
                    }else{

                    }
                }else{

                }
            }

            true
        }
    }

    private fun coffee(layout2: ConstraintLayout){
        //создадим шлепки кофе на экране
        var coffee= mutableListOf<Coordinate>()
        coffee.add(Coordinate(0,0))
        coffee.add(Coordinate(0,1))
        coffee.add(Coordinate(1,0))
        coffee.add(Coordinate(2,0))
        coffee.add(Coordinate(3,0))

        coffee.forEach { coffee->
            setOnTouchListenerImageView(addImageView(layout2,R.drawable.coffee, coffee,"coffee"))
        }
    }



    @SuppressLint("ClickableViewAccessibility")
    private fun setOnTouchListenerImageView(imageView: ImageView){
        //слушатель нажатия на картинки кофе
        imageView.setOnTouchListener { view, motionEvent ->


            true
        }
    }

}

