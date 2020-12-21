class Deck {
    // takes an int as argument, returns a card
    var cards = Array(52) { Card(it % 13, getSuit(it)) }
    // create a list from the array of cards, which can be changed  (remove cards)
    // the original card array will be used when we need to repopulate the deck 
    var cardsInDeck: MutableList<Card> = cards.toMutableList()
    // draw the card 
    fun drawCard() : Card {
        // remove the first card from deck
        return cardsInDeck.removeAt(0)
    }
    fun reset() {
        cardsInDeck = cards.toMutableList()
        cardsInDeck.shuffle()
    }
    private fun getSuit(ind:Int): String {
        return when (ind / 13) {
            0 -> club
            1 -> diamond
            2 -> heart
            else -> spade
        }
    }
}
