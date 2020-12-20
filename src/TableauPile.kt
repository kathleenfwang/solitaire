class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    //add a card 
    // card has to be one less than most recent 
    // suit has to be opposite 
    init {
        if (cards.size > 0)
        {cards.last().faceUp = true }
    }
    fun addCards(newCards:MutableList<Card>):Boolean {
        if (cards.size > 0) {
        val prev = cards.last()
        if (newCards.first().value < prev.value && checkSuit(newCards.first())) {
            // add newCards to cards 
            cards.addAll(newCards)
        }
        return true 
        } 
        // else if the pile is empty, and if the new card's first item is king, we can all cards
        else if (newCards.first().value == 12) {
            cards.addAll(newCards)
            return true
        }
        return false
    }
    fun removeCards(tappedIndex:Int)  {
        // remove all the cards from current tableau that are faceup from tappedIndex 
        // start from tapped index -> 0 
        // only cards with faceUp can be tapped
            for (i in tappedIndex..cards.lastIndex ){
            cards.removeAt(tappedIndex)
        } 
         // now have to set the last card in cards to be true if it has a card left 
         if (cards.size > 0) {
             cards.last().faceUp = true 
    
        }
    }
    private fun checkSuit(newCard: Card) : Boolean {
        val newCardSuit = newCard.suit
         val prevCard = cards.last().suit
         if (reds.contains(newCardSuit) && blacks.contains(prevCard) || blacks.contains(newCardSuit) && reds.contains(prevCard)) return true
         return false 
    }
}