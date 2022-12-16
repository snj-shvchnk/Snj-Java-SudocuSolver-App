# Development Snj-Sudocu-Solver

## The objective:
Define, implement and test a sudoku solver.
Use the Java programming language, test using the attached matrices.
Write a document about architecture, explain the choice and ways to solve the problem.

![Snj-CSV-File-Reader](https://github.com/snj-shvchnk/Snj-Java-Sudocu-Solver/blob/master/docs/screen_java_debug.jpg?raw=true)

## Preparation:

### Information search
	
A superficial R&D was carried out on the available solutions for solving sudoku using software computing methods. In particular, options for solving the problem using linear algorithms, Backtracking, Dancing Links, Algorithm X and others were reviewed.
It was determined that humanity already has considerable experience in solving similar problems, and can do it in many ways.

### Algorithm selection
Since this was my first encounter with Sudoku, it was decided to implement an intuitive algorithm that I used when solving Sudoku without software.
Also, this was my first experience working with Java, and this form of implementation allowed me to get to know and work with the basic, and so familiar from other programming languages, tools of OOP and linear programming in a new programming environment.

## Architecture:

Looking at the structure of the problem, it occurred to me that the search for a solution is a recursive type problem, when we dive into the probable version of the matrix, looking for the next solutions, and exit the branch if we see that the matrix cannot be solved with the available data.

###  Algorithm
Also, the solution is to recursively call a function that tries to find the correct values ​​of all empty cells, and reports to the calling scope whether it was possible to find a satisfactory solution for all input conditions.
Structurally, the processing stages of each iteration can be defined as follows:

- Pass through the matrix from left to right from top to bottom
- Checking the current coordinate at the end of the matrix
- Checking the current coordinate at the end of the line
- Finding a satisfactory answer
    -Looping through values ​​1-10
        - Check for compliance with matrix conditions
            - Check for uniqueness in a string
            - Column uniqueness check
            - Verification of uniqueness within the local cluster
- Checking for a satisfactory value
- Determination of the impossibility of a decision under the existing conditions

### Graphic representation of the algorithm

![Snj-CSV-File-Reader](https://github.com/snj-shvchnk/Snj-Java-Sudocu-Solver/blob/master/docs/sudocu_algoritm.jpg?raw=true)


## Program structure

With a small volume, it was decided to limit ourselves to one directory and several classes containing the logic and settings of the program.

- App.java main class
    - The 'main' function is the main entry point for starting the program, the initial data and the call to the solution function are placed there.
    - The _solveGrid function - Processes one array of input data, actually a Sudoku condition, and reports to the console about the progress of the solution, because the console is a low-level but Developer-friendly interface.

- Logical class Sudocu.java
    - Public entry point ProcessGrid - is called from the control code of the program, starts the recursion and is an override of the internal method for processing the cell, fixed at the coordinate [0,0] - the beginning of the matrix.
    - Private recursive method _processGrid
    Handles cell traversal, selects values ​​for empty cells, runs validation, and reports whether or not a satisfactory value was found.

- Const.java configuration
    Stores values ​​necessary for general use - matrix and cluster sizes. Is an application configuration implementation.

- Functional class Utils.java
    A set of functionality for array manipulation, console output, and (potentially) other reusable methods.

## Realization

### Development environment
The necessary steps were taken to set up a JAVA Development-Enviropment for my machine, the choice was made in favor of the Visual Studio Code IDE and the Coding Pack for Java extension, with their integrated compiler and parser.
It turned out that with the launch of JAVA, everything is much better than I heard, after installing the necessary components, the development took place without significant obstacles.
Link to the Development-Environment setup manual:
https://code.visualstudio.com/docs/languages/java

### Problems and tasks
		
#### Familiarity with JAVA
I had to familiarize myself with the peculiarities of the syntax and construction of the virtual structure, in the end it was determined that JAVA is very similar to C#, and my level of understanding of OOP allowed me to quickly arrange all the necessary classes and methods.

#### Array cloning
In the process, I encountered a problem typical for high-level programming languages ​​- transmitting the values ​​of the input two-dimensional array by amplification, I was not able to display both the condition and the solution on the console at the end of the solution.
The task was to implement a method for cloning a two-dimensional array by values, avoiding references to the object, because it was the two-dimensionality that hindered the use of the built-in function Array.Clone - the host array was copied correctly, but the internal arrays-members_sets were transferred by reference and changed during the decision process.
After implementing the method of copying a two-level array, everything worked fine, the problems disappeared.

## Instructions for launching the project:

### Development:
- Arrange the environment according to the instructions: https://code.visualstudio.com/docs/languages/java
- Clone the repository using the link: https://github.com/snj-shvchnk/Snj-Java-Sudocu-Solver.git
- Run Visual Studio Code in the root directory
- Run the project and go to the console to observe the result.
- DONE!

### Distribution
- Open a terminal in the root directory of the project
- Run the compiled version of the program using the command:
            
        java -jar .\SnjSudocuSolver.jar

### Testing

The project was tested with two examples from the test task, easy and normal.
The program coped with both, in 24ms and 40ms, respectively.

A Sudoku condition was also written, which ultimately does not have a final solution. The program gave the correct result, spending 8ms on it.

Also, while I was working on the test task, my son became interested in the question and started solving Sudoku from the Internet next to me. As a demonstration of the power of intellectual abilities and advantages of the Object Oriented thinking paradigm, one of its examples was also entered into the program and finally solved in 16ms.

I consider the testing to be successful, and the speed result satisfactory for the given task.