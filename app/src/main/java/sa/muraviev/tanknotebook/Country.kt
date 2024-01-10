package sa.muraviev.tanknotebook

import sa.muraviev.tanknotebook.Enumeration.Coordinate
import sa.muraviev.tanknotebook.Enumeration.Warehouse
import sa.muraviev.tanknotebook.Enumeration.naturalResources

class Country(
    //тут цвет в переменную
    var militaryBase: MutableList<MilitaryBase>?=null
) {
    fun create(){
        //создадим одну базу
        var mb=MilitaryBase(Coordinate(15,1)).create()
        //наполним первоначально склад
        mb.naturalResources?.add(Warehouse(naturalResources.coffee,100))
        mb.naturalResources?.add(Warehouse(naturalResources.dye,100))
        militaryBase= mutableListOf<MilitaryBase>()
        militaryBase?.add(mb)
        //
        arrayCountry.add(this)
    }

    fun step(){
        this.militaryBase?.forEach { mb->
            mb.step()
        }
    }


}