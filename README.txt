=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: ebergamo
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the three core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Collections: I have included a "Undo" feature. Its implementation makes use of LinkedLists. 
     After each step, a copy of the 2D array that represents the whole board is included as the 
     head of the LinkedList. When the Undo button is pressed, I use remove() to substitute the 
     current board for the one on the LinkedList.

  2. 2D arrays: Used to represent the board of the game. I have created a 2D array of tiles; 
     the 2D array keeps track of their position and helps with the moving process.

  3. Testing: testing of each individual function, especially the 
     merging methods (due to the large amount of edge cases).

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
  
  4. Game: includes UX elements of the game.
  
  5. ImageLoader: helper class to obtain all necessary images that are displayed to the user.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  
  The most difficult element for me was the operations in the 2D array related to shifting.
  Additionally, designing the methods so that they would interact with the GUI was also hard.


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  I believe so. Block and Board only contain methods regarding their specific aspects. 
  Encapsulation was considered when designing the methods: when necessary, they return deep
  copies of the return object.

========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
    Images:
  1.  Stephanie Weirich: https://www.seas.upenn.edu/directory/profile.php?ID=103
  2.  Rajiv Gandhi: https://www.seas.upenn.edu/directory/profile.php?ID=324
  3.  Thomas Farmer: https://www.seas.upenn.edu/directory/profile.php?ID=284
  4.  Vijay Kumar: https://www.seas.upenn.edu/directory/profile.php?ID=51
  5.  Eric Eaton: https://www.seas.upenn.edu/~eeaton/
  6.  Adam Mally: https://www.seas.upenn.edu/directory/profile.php?ID=243
  7.  Max Mintz: https://www.seas.upenn.edu/directory/profile.php?ID=65
  8.  Robert Ghrist: https://www.math.unl.edu/math-club/pme/lecture/2018
  9.  Nakia Rimmer: https://www.youtube.com/user/RimmerMath/playlists?shelf_id=3&sort=dd&view=1
  10. Wendell Pritchett: https://penntoday.upenn.edu/news/wendell-pritchett-
  named-provost-university-pennsylvania
  11. Amy Gutmann: https://president.upenn.edu/meet-president
  
  
