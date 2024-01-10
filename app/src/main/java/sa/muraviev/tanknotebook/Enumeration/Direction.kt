package sa.muraviev.tanknotebook.Enumeration

enum class Direction(
    var rotation:Float
) {
    up(0f),
    right(90f),
    down(180f),
    left(270f)
}