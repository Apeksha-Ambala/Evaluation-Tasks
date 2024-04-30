# Evaluation Tasks #
<br>

### TASK 1: Efficient Integer Conversion ### 

Create a function called, that accepts a positive integer and converts it into 1 in the most
effective way possible. The function should return the number of steps executed. You can use
only these three possible operations to convert the integer into 1:

1. Add One
2. Remove One
3. Divide by 2 (only if the current amount is even)

For example:

Input  ``` 4 ```  Should return ``` 2 ``` (using 2 steps to convert 4 into 1): 4 -> 2 -> 1

Input ``` 15 ```  Should return ``` 5 ``` (using 5 steps to convert 15 into 1): 15 -> 16 -> 8 -> 4 -> 2 -> 1

------------------------

<br>

### TASK 2: Advertising Bid Auction ### 

<br>
In advertising bid auctions, there is a mechanism that allows the best offer to win with the prize
of the second-best bid. Please provide a small program with a command-line interface that
allows us to pass a CSV file in the format "ad_id", "bid" (the ID of the ad, the bid for this ad) and
receive an output in the format "ad_id", "bid". The output should point us to the best ad to show
and the second-best bid.

For example, calling your program with an input file `File.csv`:

```
1, 0.5
2, 33
3, 12
4, 33.5
```

Should output:

```
4, 33
```

Explanation: Ad with ID 4 offers the best bid, but the second-best bid is 33.

------------------

<br>

### TASK 3: Escape a labyrinth ###

<br>
You have a labyrinth. The map is represented as a matrix of 0s and 1s, where 0s are passable
space and 1s are impassable walls. The door out of the labyrinth is at the top left (0,0) and the door
into the labyrinth is at the bottom right (w-1,h-1).
Write a function solution(map) that generates the length of the shortest path from the entry point to
the exit, where you are allowed to remove one wall as part of your strategy. The path length is the
total number of nodes you pass through, counting both the entrance and exit. The starting and
ending positions are always passable (0). The map will always be solvable, though you may or may
not need to remove a wall to solve it. The height and width of the map can be from 2 to 20. Moves
can only be made in cardinal directions; no diagonal moves are allowed.

For example:

Your code should pass the following test cases. Note that it may also be run against other test cases
not shown here.

Input with matrix

```
[[0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 1], [0, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 0]]
 ```

Should Output:

```
11
```

Input with matrix

```
[[0, 1, 1, 0], [0, 0, 0, 1], [1, 1, 0, 0], [1, 1, 1, 0]] 
```

Should Output:

```
7
```

------------------

<br>

### NOTE: ###
- This project is built using Java-8.
- For Task1, Enter a number when prompted, result will be printed.
- For Task2, Keep your file under /src/main/resources and give the filename as input when prompted. Result will be printed as expected.
- For Task3, Enter the input array as [[a,b,c], [d, e, f], [g, h, i]] , shortest route length will be printed on the screen.

