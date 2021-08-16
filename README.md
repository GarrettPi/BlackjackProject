# BlackJack Project

### Overview

This Blackjack application is a faithful, albeit slightly simplified, recreation of the popular card game of the same name.  Players compete against a dealer to get the best hand and win the round.

### How to Use

The goal of the game is to get a hand with a value as close to 21 as possible, without going over.  Any hand with a value of 22+ is a bust and will cause the holder, player or dealer, to lose the round.

Upon launching the program, the dealer will deal you and himself two cards each.  One of the dealer's cards will be hidden initially and only revealed at the end of the player's turn.  

The program will display the cards you've been dealt along with the total hand value.  You will then be asked to either **Hit** or **Stay**.

**Hit** will ask the dealer to give you an additional card, whose value will be added to the value of the rest of your hand.  If that value goes above 21, you will bust, and the dealer will win the round.

**Stay** will inform the dealer that you do not want any additional cards and the game will progress to the dealer's turn.

*Note: you may hit as many times as you like (as long as your hand value does not exceed 21) before opting to stay.  Once you have chosen to stay, you will not be allowed to get any additional cards until the next hand is dealt.*

After you have stayed, the dealer will begin his turn.

The dealer has the same options as the player: **Hit** or **Stay**.
If the dealer has a hand value of 16 or lower, he is required to hit.  Otherwise, he must stay.  

Once the dealer has completed his turn, the hand values are compared and the winner is displayed.  In the event of a draw, both the player and the dealer have the same hand value at the end of the game.  This results in a push, and no winner is declared.


### Technologies
* Object Oriented Programming


### Lessons Learned
