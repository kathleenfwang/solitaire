// these variables are now package leveled scope (accessible anywhere within package)
const val club = "Club"
const val diamond = "Diamond"
const val spade = "Spade"
const val heart = "Heart"

val reds = arrayOf(diamond,heart)
val blacks = arrayOf(club,spade)
data class Card(val value:Int, val suit: String, var faceUp:Boolean = false) {
    override fun toString(): String {
        return "$value $suit $faceUp"
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