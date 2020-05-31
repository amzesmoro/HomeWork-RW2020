data class Card(val pip: String, val suit: Char)

fun createDeck(): MutableSet<Card> {
    val pips = mutableListOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val suits = mutableListOf('\u2663', '\u2660', '\u2666', '\u2665')

    val deck = mutableSetOf<Card>()
    for (itemPip in pips.indices) {
        for (itemSuit in suits.indices) {
            deck.add(Card(pips[itemPip], suits[itemSuit]))
        }
    }
    return deck
}

fun dealHand(deck: MutableSet<Card>, numberOfCards: Int) : MutableSet<Card> {
    val hand = mutableSetOf<Card>()
    for (i in 1..numberOfCards) {
        val card = deck.random()
        hand.add(card)
        deck.remove(card)
    }
    return hand
}

fun evaluateHand(hand: MutableSet<Card>) : Int {
    var totalValue = 0
    for (item in hand) {
        val pipValue = when (val numberOfPip = item.pip) {
            "J", "Q", "K" -> 10
            "A" -> 11
            else -> numberOfPip.toInt()
        }
        totalValue += pipValue
    }
    return totalValue
}

fun printResults(totalValue: Int, hand: MutableSet<Card>) {
    println("Card on your hand:")
    for (item in hand) {
        println("""
            .-------.
            |${item.pip}      |
            |       |
            |   ${item.suit}   |
            |       |
            `-------'
        """.trimIndent())
    }
    println("Total value: $totalValue")
    val message = when(totalValue) {
        21 -> "You Win!"
        else -> "You Lose!"
    }
    println(message)
}

fun main() {
    val dealWithHand = dealHand(createDeck(), 2)
    val evaluateValueOfCard = evaluateHand(dealWithHand)
    printResults(evaluateValueOfCard, dealWithHand)
}