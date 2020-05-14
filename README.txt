=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: ebergamo
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

=========================
=:        About        :=
=========================

This is the final project for the University of Pennsylvania's CIS120 course. This is a Java version of the game 2048; it is controlled using the keyboard arrows.

=========================
=:    Implementation   :=
=========================
  
  1. Block: class that represents a single tile/block in the game; it stores the tile's value, as
     well as methods for drawing, merging and an @Override equals method.
     
  2. Board: class that represents the board as a whole. Includes a 2D array of Blocks. Includes
     methods for shifting in all directions, draw, an @Override method for equals, as well as 
     methods to check for victory and testing.
     
  3. GameLogic: class that includes all playing aspects of the game and how different elements interact.
  
  4. Game: class that includes UX elements of the game – use this file in order to run the game.
  
  5. ImageLoader: helper class to obtain all necessary images that are displayed to the user.
