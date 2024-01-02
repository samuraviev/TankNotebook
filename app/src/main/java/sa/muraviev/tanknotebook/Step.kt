package sa.muraviev.tanknotebook

class Step(
    var count:Int,

) {
    fun start() {
        Thread({
            while(count>=0){
                Thread.sleep(stepTime.toLong())
                count++
                oneStep()
            }
        }).start()
    }

    private fun oneStep(){
        arrayTank.forEach { tank ->
            tank.move()
        }
    }



}