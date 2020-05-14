=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: ebergamo
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  
  1. Block: class that represents a single tile/block in the game; it stores the tile's value, as
     well as methods for drawing, merging and an @Override equals method.
     
  2. Board: class that represents the board as a whole. Includes a 2D array of Blocks. Includes
     methods for shifting in all directions, draw, an @Override method for equals, as well as 
     methods to check for victory and testing.
     
  3. GameLogic: includes all playing aspects of the game and how different elements interact.
  
  4. Game: includes UX elements of the game – use this file in order to run the game.
  
  5. ImageLoader: helper class to obtain all necessary images that are displayed to the user.
