class FoundationPile(val suit:String) {
    val cards:MutableList<Card> = mutableListOf()

    fun reset() {
        cards.clear()
    }
    fun removeCard(card:Card) {
        cards.remove(card)
    }
    fun addCard(card:Card) : Boolean {
        // card has to be the same suit as suit 
        // card has to be one less than prev card value 
        var prev = 0
        if (cards.size > 1) {
            prev = cards.last().value + 1 
        }
        if (card.value == prev && card.suit == suit) {
            cards.add(card)
            return true
        }
        return false
    }
}