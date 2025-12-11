# **Phase 4: Performance Analysis**

## Random and Unsorted Lists:
Results for sorting 10 elements:
StopWatch '': 0.0002584 seconds
----------------------------------------
Seconds       %       Task name
0.0002459     95%     Gnome Sort
0.0000061     02%     Cocktail Shaker Sort
0.0000064     02%     Shell Sort

Results for soring a list of 100 elements:
StopWatch '': 0.0007748 seconds
----------------------------------------
Seconds       %       Task name
0.0005259     68%     Gnome Sort
0.0002199     28%     Cocktail Shaker Sort
0.000029      04%     Shell Sort

Results for soring a list of 1000 elements:
StopWatch '': 0.0119785 seconds
----------------------------------------
Seconds       %       Task name
0.0067894     57%     Gnome Sort
0.0047682     40%     Cocktail Shaker Sort
0.0004209     04%     Shell Sort

Results for sorting 5000 elements:
StopWatch '': 0.075026 seconds
----------------------------------------
Seconds       %       Task name
0.0320184     43%     Gnome Sort
0.040635      54%     Cocktail Shaker Sort
0.0023726     03%     Shell Sort

Results for sorting 10000 elements:
StopWatch '': 0.2791976 seconds
----------------------------------------
Seconds       %       Task name

0.1010266     36%     Gnome Sort
0.1748431     63%     Cocktail Shaker Sort
0.0033279     01%     Shell Sort

## Sorted Lists:
Results for sorted list of 10 elements:
StopWatch '': 0.000265 seconds
----------------------------------------
Seconds       %       Task name
0.0002563     97%     Gnome Sort
0.0000022     01%     Cocktail Shaker Sort
0.0000065     02%     Shell Sort

Results for sorted list of 100 elements:
StopWatch '': 0.0002869 seconds
----------------------------------------
Seconds       %       Task name
0.0002651     92%     Gnome Sort
0.0000047     02%     Cocktail Shaker Sort
0.0000171     06%     Shell Sort

Results for sorted list of 1000 elements:
StopWatch '': 0.0005417 seconds
----------------------------------------
Seconds       %       Task name
0.0002979     55%     Gnome Sort
0.000029      05%     Cocktail Shaker Sort
0.0002148     40%     Shell Sort

Results for sorted list of 5000 elements:
StopWatch '': 0.0017412 seconds
----------------------------------------
Seconds       %       Task name
0.0004204     24%     Gnome Sort
0.0001288     07%     Cocktail Shaker Sort
0.001192      68%     Shell Sort

Results for sorted list of 10000 elements:
StopWatch '': 0.0032173 seconds
----------------------------------------
Seconds       %       Task name
0.0006606     21%     Gnome Sort
0.0002842     09%     Cocktail Shaker Sort
0.0022725     71%     Shell Sort

## Reversed Sorted Lists:
Results for sorted list of 10 elements:
StopWatch '': 0.0003699 seconds
----------------------------------------
Seconds       %       Task name
0.0003559     96%     Gnome Sort
0.0000101     03%     Cocktail Shaker Sort
0.0000039     01%     Shell Sort

Results for sorted list of 100 elements:
StopWatch '': 0.0011606 seconds
----------------------------------------
Seconds       %       Task name
0.0006717     58%     Gnome Sort
0.000468      40%     Cocktail Shaker Sort
0.0000209     02%     Shell Sort

Results for sorted list of 1000 elements:
StopWatch '': 0.0152291 seconds
----------------------------------------
Seconds       %       Task name
0.0079869     52%     Gnome Sort
0.0069526     46%     Cocktail Shaker Sort
0.0002896     02%     Shell Sort

Results for sorted list of 5000 elements:
StopWatch '': 0.113397 seconds
----------------------------------------
Seconds       %       Task name
0.0549923     48%     Gnome Sort
0.0563913     50%     Cocktail Shaker Sort
0.0020134     02%     Shell Sort

Results for sorted list of 10000 elements:
StopWatch '': 0.4145373 seconds
----------------------------------------
Seconds       %       Task name
0.1929337     47%     Gnome Sort
0.2195032     53%     Cocktail Shaker Sort
0.0021004     01%     Shell Sort

## Complexity and Validation Analysis: Between Gnome and Cocktail Shaker Sort
For a random / unsorted data list the cocktail shaker sort is faster than the gnome sort for the smaller list, but for the larger list the gnome sort is faster. 
For a sorted list the cocktail shaker is always faster than the gnome sort, this is because if the list is already sorted, the cocktail shaker sort will almost immediately catch 
that it is sorted and stop. In the do while loop if a swap is not made in the first for loop, it exits the loop and stops the algorithm. Lastly, for the revered sorted list, 
the gnome sort was slightly faster than the cocktail shaker sort for the larger list. 

The cocktail shaker sort is often more efficient than the bubble sort because of its bidirectional sweeping. In the bubble sort process, you only go one way, so if you have a small 
number at the end of the list, it won't move it as fast as the cocktail shaker sort. This is the biggest advantage of the cocktailer sort. 

Both of the algorithms perform better than bubble sort because in bubble sort it sweeps through the entire list, which is not efficient for large lists. Gnome sort fixes the 
order as it goes and the cocktail shaker sort has the advantage of doing the bidirectional sweeping.

I don't think the gnome sort shows consistent O(n^2) because when looking at the times with the sorted list; the time sorting 5000 elements is almost the same as sorting 10000 elements.
If it was showing O(n^2), then it would take roughly 4 times longer to sort 10000 elements compared to sorting 5000 elements. 