package sa.muraviev.tanknotebook

import sa.muraviev.tanknotebook.Enumeration.Coordinate
import sa.muraviev.tanknotebook.Enumeration.Warehouse
import sa.muraviev.tanknotebook.Enumeration.naturalResources.coffee
import sa.muraviev.tanknotebook.Enumeration.naturalResources.dye

class MilitaryBase(
    var coordinate: Coordinate,
    var idView: Int? = null,
    var naturalResources:MutableList<Warehouse>?=null,
    var army:MutableList<Tank>?=null,
) : ImageView() {
    fun create():MilitaryBase{
        var imageView = addMilitaryBase(coordinate)
        idView=imageView?.id
        army= mutableListOf<Tank>()
        naturalResources= mutableListOf<Warehouse>()
        setOnTouchListenerImageView(imageView)
        return this
    }

    private fun setOnTouchListenerImageView(imageView: android.widget.ImageView?){
        //слушатель нажатия на картинки
        imageView?.setOnTouchListener { view, motionEvent ->
            if (selectedTank==null){
                //танк не выбран

            }else{
                //танк выбран

            }

            true
        }
    }

    fun step(){
        buyTank()
        //сходим каждым танком
        this.army?.forEach { tank->
            tank.step()
        }
    }

    private fun buyTank(){
        //если хватит ресурсов закажем танк
        var count1=this.naturalResources?.firstOrNull {
            it.type== dye }?.count
        var count2=this.naturalResources?.firstOrNull {
            it.type== coffee }?.count
        if (count1==null)count1=0
        if (count2==null)count2=0

        if (count1>= costTank && count2>= fuelTank){
            //ресурсов хватит, создадим танк для этой военной базы и добавим танк в армию этой базы
            var tank=Tank().create(this)
            if (tank!=null){
                //уберем ресурсов базы стоимость танка
                naturalResources?.firstOrNull {
                    it.type== dye }?.count=count1- costTank
                naturalResources?.firstOrNull {
                    it.type== coffee }?.count=count2- fuelTank
                //добавим в танк топливо
                tank.coffee= fuelTank
                army?.add(tank)
            }
        }else{

        }
    }



}

