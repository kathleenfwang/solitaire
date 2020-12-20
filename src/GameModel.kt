class GameModel {
    val deck = Deck() 
    val wastePile: MutableList<Card> = mutableListOf()
    val foundationPiles =  arrayOf(FoundationPile(club), FoundationPile(heart), FoundationPile(spade), FoundationPile(diamond))
    val  tableauPiles = Array(7) {TableauPile()}
}