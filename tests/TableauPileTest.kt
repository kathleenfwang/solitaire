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
    }
}