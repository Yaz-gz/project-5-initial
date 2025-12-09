# **Phase 1: Design and Pseudocode Analysis**

Reviewing Pseudocode, identifying key variables, loop structures, and algorithm logic for:

## **Gnome Sort:**
### Variables:
"pos" used for position/index
"a" used for name of list to be sorted

### Loop structures:
While loop used to do something while a condition is true. This loop will run as long as the position is less that the length of list a.
If/else conditional statement is used inside the while loop to move position number and sort the list

### Algorithm logic:
First you give it a list. Set the initial position to 0 to initiate the while loop. Once the while loop is initiated, the if else conditional statement inside is used 
to sort the list. It first checks to make sure that the position is not zero or that the number in the current position is greater than or equal to the number in the 
position before it. If either condition is true, it will move to the next position by adding 1 to the position variable. If both of those conditions are false then it 
moves to the else part of the conditional statement where it will swap the numbers in the current position and the number in the position before it. After the swap it 
will decrease the position by 1 and loop again. This is done to make sure that the number that was swapped is now in the correct place. As long as the position is less 
than the length of the list it will continue to run. 

## **Cocktail Shaker Sort:**
### Variables:
"swapped" used as a boolean
"a" used for the name of the list to be sorted 
"i" used for the position/index

### Loop Structures:
Do-while loop used to do something while a condition is true; in this example it checks to make sure the boolean swapped is true AFTER the initial pass.
For loops are used to iterate through the list
If conditional statements are used to swap and exit the do-while loop

### Algorithm logic:
First you create a list of sortable items. The do while loop will initiate. The boolean "swapped" is first set to false check if there are any swaps made after the first 
for loop. The first for loop compares all the numbers in the list starting at index 0 all the way to the end of the list, from left to right. If the number in the current 
index is greater than the next number to the right, it will swap them. The swapped boolean is then set to true to avoid triggering the next conditional statement to break 
the do-while loop. After the swapped boolean is set to true, it will not be false until the beginning of the next for loop. After the first for loop iterates through the 
whole list from left to right, it moves on to check the if conditional statement; if swapped is true, then the do while loop will continue but if it is false it will break 
the loop and end the program. After the conditional statement the program then sorts the list from right to left. It looks at the number before the end of the list and 
compares it to the number after it. For example if the length of the list is 6, the index will start at 5 and compare it to index 6, then index 4 to index 5 and so on. If 
the current position holds a number that is bigger than the position to the right, it will swap them. After it swaps the boolean swapped if again set tp true. The do-while 
loop will continue to run as long as the boolean swapped stays true when it is checked after the pass.

## **Shell Sort:**
### Variables:

# **Phase 3: AI-Assisted Test Development**

