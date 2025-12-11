# **Phase 1: Design and Pseudocode Analysis**

Reviewing Pseudocode, identifying key variables, loop structures, and algorithm logic for:

## **Gnome Sort:**
### Variables:
"pos" used for position/index
"a" used for name of list to be sorted

### Loop structures:
While loop used to do something while a condition is true. This loop will run as long as the position is less than the length of list a.
If/else conditional statement is used inside the while loop to move the position number and sort the list

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
"gap" used to control the size of the gap between each pass
"a" used for the name of the list to be sorted
"i" used for the position/index
"j" used to find the correct insertion position for each element
"n" used to set the length of the list

### Loop Structures:
For loops are nested inside each other to iterate through the gap sequence, list, and to shift the elements around.
If conditional statements are used to stay in bounds when comparing and shifting elements

### Algorithm logic:
First, you create the array to be sorted and the gap sequence you want to use; the pseudocode uses the Ciura gap sequence. There are 3 for loops that are nested inside each 
other. The most outer for loop is used to iterate through the gap sequence, one by one. The middle for loop iterates through subsets of the list that are "gap" positions apart.
(if our list is a = [5, 3, 7, 1, 6, 9, 0] and the gap is 4, we will have 3 subsets, [5,6], [3,9], and [7,0]). It stores the element in position i which is the gap value in the 
variable temp (in the example list temp will first = 6). The last for loop is where the swapping actually happens. This algorithm did not use the swap function like the other two algorithms, 
instead it used the temp variable and the j variable to swap the elements. The j is used for the insertion point search. j is set to equal the current gap value. There are two 
conditions that must be true for a swap to happen; if j is equal to or greater than the gap value and the element at position j - the gap value is greater than the temp variable, 
the program will "swap" the elements by setting the element in position j - gap into position a[j]. Then the position a[j] is set to the temp variable. The way this algorithm 
works is comparing numbers that are far apart then reducing the gap size until the list is sorted.

# **Phase 3: AI-Assisted Test Development**

I included the test requirements in the prompt that were given under the "Test Requirements" section of the project description. I asked the AI to include test that would cover 
other edge cases and typical cases that were not covered in the requirements. I was sure to include tests that would cover method-specific edge cases and tests that checked for 
algorithm correctness using generic Comparable types and objects. The first round of test was very comprehensive and included everything in the requirements, but I did notice that 
the variable names were not preserved from the pseudocode, so I asked the AI to change them to match exactly. After I ran the first set of tests, everything passed, but I thought 
of a couple more tests that could be added, like checking for null values and cases where there were negative numbers in the list. I asked the AI to add those tests. I verified 
that the tests were included and ran them again. I was able to get all the tests to pass. I went back and asked the AI to give more descriptive error messages just in case a test 
did fail and I had to debug it. I got the updated test class and ran it again and was able to still get a 100% pass rate.

# **AI-Assisted Development Analysis**
For the most part the AI was able to correctly implement the pseudocode on the first attempt except for the cocktail shaker one. I had to tell the AI that the sorting had to be 
bidirectional. It was able to fix it and I found no other issues after. It did preserve the variable names for each method, as I asked it explicitly. I think that using AI to 
learn about these algorithms was very beneficial and helped me understand the algorithms better than just reading about them. The line-by-line comments were a big help. I really 
liked that it was able to give me examples and show me the output for each pass of the algorithm. I hadn't heard of these algorithms before, but I think that I would be able to 
explain the logic without referring to the code. I think the quality of the code was great, I felt that it was concise, and I believe it followed the pseudocode very well. I do 
think that the prompts had a lot to do with the quality of the code. I was very clear on what I needed the AI to do. It recognized what I needed based on keywords like when I asked 
it to handle generic types, it seemed to know that I needed the method to handle both str and int. 

I think that the AI was able to do a good job at creating the test suite. I gave it the list of the mentioned test in the rubric, and it covered those cases plus more edge cases 
it thought of. I think for class projects no test is "unnecessary" because it is nice to see the different test that it thinks of. Out in the real world we would have a list of 
requirements and we would make sure that we have a way to test them. I think that the AI covered most edge-case and typical cases. I wanted to add error handling so I asked it to 
test a list with null values and I think it handled that well. I also added tests that handled negative numbers and it was also able to handle creating those tests. I think AI saves 
a lot of time and effort by creating the test suite for us. I think in real-world applications we could still use the AI to create the test suite, but it would be critical that we 
look over it and make sure that it covers all the cases we need. 

Overall, I think AI is a great tool. It was very helpful in learning these new algorithms. I think it did a great job at explaining how they work. I liked the examples it walked 
me through because they weren't very complex. It allowed me to follow along and really understand how the alogroithm worked. For example, even though the analysis was more on the first two 
algorithms, I was really interested in learning how the shell sort really worked. I asked it to explain it to me and it gave me an example with small gap values and I was able to follow along. 
I will continue to use AI in the future to help me learn new algorithms. I hope that in future classes we continue to implement the help of AI. 