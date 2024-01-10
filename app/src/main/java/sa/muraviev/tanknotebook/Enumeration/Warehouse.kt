package sa.muraviev.tanknotebook.Enumeration

class Warehouse(
    var type:naturalResources,
    var count:Int
) {


}

fun startWarehouse():MutableList<Warehouse>{
    var array= mutableListOf<Warehouse>()
    array.add(Warehouse(naturalResources.coffee,100))
    array.add(Warehouse(naturalResources.dye,100))
    return array
}