class GameModel {
    val deck = Deck() 
    val wastePile: MutableList<Card> = mutableListOf()
    val foundationPiles =  arrayOf(FoundationPile(club), FoundationPile(heart), FoundationPile(spade), FoundationPile(diamond))
    val  tableauPiles = Array(7) {TableauPile()}

    fun resetGame() {
        wastePile.clear()
        foundationPiles.forEach{it.reset()}
        deck.reset()
        tableauPiles.forEachIndexed{ i, _ ->
            val cardsInPile:MutableList<Card> = Array(i+1) {deck.drawCard()}.toMutableList()
            tableauPiles[i] = TableauPile(cardsInPile)
        }
    }
    fun onDeckTap() {
        if (deck.cards.size > 0)
       { val card = deck.drawCard()
        card.faceUp = true
        wastePile.add(card)}
        else {
            // add the waste pile back to the deck
            // we don't have to flip the faceup card back to facedown because we'll be drawing it again anyway
//            cards.forEach {it.faceUp = false}
            deck.cardsInDeck = wastePile.toMutableList()
            wastePile.clear()
        }
    }
    fun onWasteTap() {
        if (wastePile.size > 0) {
            // check if we can use the last added card
            val card = wastePile.last()
            if (playCard(card)) wastePile.remove(card)
        }
    }
    fun onFoundationPileTap(ind:Int) {
        val foundationPile = foundationPiles[ind]
        if (foundationPile.cards.size > 0) {
            // check if we can use the last added card
            val card = foundationPile.cards.last()
            if (playCard(card)) foundationPile.removeCard(card)
        }
    }
    fun onTableauPileTap(tableauIndex: Int, cardIndex: Int) {
        var tableauPile = tableauPiles[tableauIndex]
        val cards = tableauPile.cards.subList(cardIndex,tableauPile.cards.lastIndex + 1)
        // check if we can add our cards to a different tableau pile
        // if we can, remove those cards from tableau pile
        if (playCards(cards)) tableauPile.removeCards(cardIndex)
    }

    private fun playCards(cards: MutableList<Card>): Boolean {
        // if cards is just one card, can call play card
        if (cards.size == 1) return playCard(cards.first())
        else {
            tableauPiles.forEach { if (it.addCards(cards)) return true }
        }
        return false
    }

    private fun playCard(card: Card): Boolean {
        // 1. check if its playable in foundation piles
        // 2. check if its playable in tableau piles
            foundationPiles.forEach { if (it.addCard(card)) return true }
            tableauPiles.forEach { if (it.addCards(mutableListOf(card))) return true }
        return false
    }
}