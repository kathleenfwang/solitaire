// these variables are now package leveled scope (accessible anywhere within package)
const val club = "Club"
const val diamond = "Diamond"
const val spade = "Spade"
const val heart = "Heart"

val reds = arrayOf(diamond,heart)
val blacks = arrayOf(club,spade)
val cardsMap = mapOf(0 to "Ace", 1 to "2", 2 to "3", 3 to "4", 4 to "5", 5 to "6", 6 to "7", 7 to "8", 8 to "9", 9 to "10", 10 to "Jack", 11 to "Queen", 12 to "King")
data class Card(val value:Int, val suit: String, var faceUp:Boolean = false) {
    override fun toString(): String {
        return "${cardsMap.getValue(value)} $suit $faceUp"
    }
}

//  can also be: 
//  /* class Card( value:Int, suit:String,faceUp:Boolean) {
//     val value:Int 
//     val suit:String 
//     var faceUp:Boolean 
//     init {
//         this.value = value 
//         this.suit = suit 
//         this.faceUp = faceUp
//     }
// }
//  */ 