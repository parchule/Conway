# Conway
My fully functional rendition of Conway's Game of Life in Java. Developed in Fall 2018 as a personal side project.

Conway's Game of Life Rules/Explanation:

Conway’s game of life is a game which is played with no human players. 
It is a game of simulation, revolving around a set of basic rules with a tick/turned based system. 
Cells are displayed in a user-set configuration, with the cells acting on their own once the simulation begins. 
If a cell has fewer than two neighbors, the cell will die. 
If a cell has two or three neighbors, it will live onto the next turn. 
If a cell has more than three neighbors, it will die as a cause of overpopulation. 
Any space containing a dead cell, that is surrounded by exactly three neighbors, will come alive, through repopulation. 

The program will take four command line arguments:
The width of the world.
The length of the world.
A filename where the starting location of the cells is located.
The number of ticks/turns to take in the world before stopping.

Input File Format:
The file will be a plain text file with UNIX \n line endings.
Each line of the file will contain 1 for a living cell and the x and y position in the world 
An example line for a living cell located at x position 4 and y position 5 would be: 1,4,5.

The program will display the following on each tick:
The number of ticks that has passed
The population of the world
A print out of the world 

At the completion of the number of steps provided at the beginning an output file called output.txt will be created
which contains the location of all the cells in the world in the same format as the input file.

All internal functions in each respective class file is documented to explain what it does, and what it returns.
The JAVA file titled player will be ran as a main file equivilant, launching the game with the respective instructions provided
by the user to the console.
