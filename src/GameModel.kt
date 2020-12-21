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
            if (playWasteCard(card)) wastePile.remove(card)
        }
    }
    fun onFoundationPileTap(ind:Int) {
        val foundationPile = foundationPiles[ind]
        if (foundationPile.cards.size > 0) {
            // check if we can use the last added card
            val card = foundationPile.cards.last()
            if (playWasteCard(card,"foundation")) foundationPile.removeCard(card)
        }
    }
    private fun playWasteCard(card: Card, origin: String = "waste"): Boolean {
        // 1. check if its playable in foundation piles
        // 2. check if its playable in tableau piles
        if (origin == "foundation") {
            tableauPiles.forEach {
                if (it.addCards(mutableListOf(card))) return true
            }
        }
        else {
            foundationPiles.forEach {
                if (it.addCard(card)) return true
            }
            tableauPiles.forEach {
                if (it.addCards(mutableListOf(card))) return true
            }
        }
        return false
    }
}