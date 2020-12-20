import org.junit.Test

import org.junit.Assert.*

class TableauPileTest {

    @Test
    fun addCards() {
        // arrange
        val tableauPile = TableauPile(mutableListOf(Card(12,spade)))
        val newCards = mutableListOf(Card(11,heart))
        // action
        tableauPile.addCards(newCards)
        //assert
        assertEquals(2, tableauPile.cards.size)
    }

    @Test
    fun removeCards() {
        // arrange
        val tableauPile = TableauPile(mutableListOf(Card(4,spade), Card(3,heart), Card(2,club)))
        // action
        // want to remove at tapped index 1
        tableauPile.removeCards(1)
        //assert
        assertEquals(mutableListOf(Card(4,spade,true)), tableauPile.cards)
    }
}