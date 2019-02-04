## Problem 1.
# Exercises: Functional Programming

This document defines the exercises for [&quot;Java Advanced&quot; course @ Software University](https://softuni.bg/courses/java-advanced).

Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1514).

1. 1.Consumer Print

Write a program that **reads** a collection of **strings** , separated by one or more whitespaces, from the console and then prints them onto the console. Each string should be printed on a new line. Use a **Consumer\&lt;T\&gt;**.

### Examples

| **Input** | **Output** |
| --- | --- |
| Pesho Gosho Adasha | PeshoGoshoAdasha |

1. 2.Knights of Honor

Write a program that **reads a collection of names** as strings from the console and then **appends****&quot;Sir&quot; **in front of every name and prints it back onto the console. Use a** Consumer\&lt;T\&gt;**.

### Examples

| **Input** | **Output** |
| --- | --- |
| Pesho Gosho Adasha StanleyRoyce | Sir Pesho Sir GoshoSir AdashaSir StanleyRoyce |

1. 3.Custom Min Function

Write a simple program that **reads** a **set of numbers** from the console and finds the **smallest** of the **numbers** using a simple **Function\&lt;Integer[], Integer\&gt;**.

### Examples

| **Input** | **Output** |
| --- | --- |
| 1 4 3 2 1 7 13 | 1 |

1. 4.Applied Arithmetic

On the first line you are given a **list of numbers**. On the next lines you are passed different **commands** that you need to apply to all numbers in the list: **&quot;add&quot;** -\&gt; adds 1; **&quot;multiply&quot;** -\&gt; multiplies by 2; **&quot;subtract&quot;** -\&gt; subtracts 1; **&quot;print&quot;** -\&gt; prints all numbers on **a new line**. The input will end with an &quot; **end**&quot; command, after which you need to print the result.

### Examples

| **Input** | **Output** |   | **Input** | **Output** |
| --- | --- | --- | --- | --- |
| 1 2 3 4 5addaddprintend | 3 4 5 6 7 | 5 10multiplysubtractprintend |
1. 919
 |

1. 5.Reverse and Exclude

Write a program that **reverses** a collection and **removes** elements that are **divisible** by a given integer **n**.

### Examples

| **Input** | **Output** |
| --- | --- |
| 1 2 3 4 5 62 | 5 3 1 |
| 20 10 40 30 60 503 | 50 40 10 20 |

1. 6.Predicate for names

Write a **predicate**. Its goal is to **check** a name for its length and to return **true** if the names length is **less or equal** the passed **integer**. You will be given a **string** array with some names. Print the names, passing the **condition** in the predicate.

### Examples

| **Input** | **Output** |
| --- | --- |
| 4Kurnelia Qnaki Geo Muk Ivan | GeoMukIvan |
| 4Karaman Asen Kiril Yordan | Asen |

1. 7.Find the smallest element

Write a program which is using  a custom **function** (written by you :)) to find the **smallest** integer in a **sequence** of integers. The input could have more than one space. Your task is to **collect** the integers from the console, find the **smallest**** one **and print its** index** (if more than one such elements exist, print the index of the rightmost one).

### Hints

- Use a **Function\&lt;List\&lt;Integer\&gt;, Integer\&gt;** or something similar.

### Examples

| **Input** | **Output** |
| --- | --- |
| 1 2 3 0 4 5 6 | 3 |
| 123 10 11 3 | 3 |

1. 8.Custom Comparator

Write a custom **comparator** that **sorts** all even numbers before all **odd** ones in **ascending order**. Pass it to an **Arrays.sort()** function and print the result.

### Examples

| **Input** | **Output** |
| --- | --- |
| 1 2 3 4 5 6 | 2 4 6 1 3 5 |
| -3 2 |
1. 2-3
 |

1. 9.List of Predicates

Find all **numbers** in the range **1..N** that are **divisible** by the numbers of a given sequence. Use **predicates**.

### Examples

| **Input** | **Output** |
| --- | --- |
| 101 1 1 2 | 2 4 6 8 10 |
| 1002 5 10 20 | 20 40 60 80 100 |

1. 10.Predicate Party!

The Wire&#39;s parents are on a vacation for the holidays and he is planning an epic party at home. Unfortunately, his organizational skills are next to non-existent so you are given the task to help him with the reservations.

On the first line you get a **list** with all the **people** that are coming. On the next lines, until you get the &quot; **Party**!&quot; command, you may be asked to **double** or **remove** all the people that apply to **given**** criteria**. There are three different options:

- Everyone that has a name **starting** with a given string;
- Everyone that has a name **ending** with a given string;
- Everyone that has a name with a given **length**.

If nobody is going, print **&quot;Nobody is going to the party!&quot;** See the examples below:

### Examples

| **Input** | **Output** |
| --- | --- |
| Pesho Misho StefanRemove StartsWith PDouble Length 5Party! | Misho, Misho, Stefan are going to the party! |
| PeshoDouble StartsWith PeshDouble EndsWith eshoParty! | Pesho, Pesho, Pesho, Pesho are going to the party! |
| PeshoRemove StartsWith PParty! | Nobody is going to the party! |

1. 11.\* The Party Reservation Filter Module

You are a young and talented **developer**. The first task you need to do is to implement a **filtering module** to a party reservation software. First, The Party Reservation Filter Module ( **TPRF** Module for short) is passed a **list** with invitations. Next the **TPRF** receives a sequence of **commands** that specify if you need to add or remove a given filter.

**TPRF** Commands are in the given format **{command;filter type;filter parameter}**

You can receive the following **TPRF** commands: **&quot;Add filter&quot;** , **&quot;Remove filter&quot;** or **&quot;Print&quot;**. The possible **TPRF** filter types are: **&quot;Starts with&quot;, &quot;Ends with&quot;, &quot;Length&quot;** and **&quot;Contains&quot;.** All **TPRF** filter parameters will be a string (or an integer for the length filter).

The input will end with a **&quot;Print&quot;** command. See the examples below:

### Examples

| **Input** | **Output** |
| --- | --- |
| Pesho Misho SlavAdd filter;Starts with;PAdd filter;Starts with;MPrint | Slav |
| Pesho Misho JicaAdd filter;Starts with;PAdd filter;Starts with;MRemove filter;Starts with;MPrint | Misho Jica |

1. 12.\*Inferno III

Your game studio&#39;s next triple A big-budget-killer-app is the Hack and Slash Action RPG Inferno III. The main purpose of the game is well, to hack and slash things. But the secondary purpose is to craft items and recently the main fan base has started complaining that once you craft an item you can&#39;t change it. So your next job is to implement a feature for one time reforging an item.

On the first line you are given the gems already inserted in the form of numbers, representing their power. On the next lines, until you receive the &quot;Forge&quot; command, you can receive commands in the following format **{command;filter type;filter parameter}** :

Commands can be: &quot;Exclude&quot;, &quot;Reverse&quot; or &quot;Forge&quot;. The possible filter types are: &quot;Sum Left&quot;, &quot;Sum Right&quot; and &quot;Sum Left Right&quot;. All filter parameters will be an integer.

&quot;Exclude&quot; marks a gem for exclusion from the set if it meets a given condition. &quot;Reverse&quot; deletes a previous exclusion.

&quot;Sum Left&quot; tests if a gems power summed with the gem standing to its left gives a certain value. &quot;Sum Right&quot; is the same but looks to a gems right peer. &quot;Sum Left Right&quot; sums the gems power with both its left and right neighbours.

Note that changes on to the item are made only after forging. This means that the gems are fixed at their positions and every function occurs on the original set, so every gems power is considered, no matter if it is marked or not.

To better understand the problem, see the examples below:

### Examples

| **Input** | **Output** | **Comments** |
| --- | --- | --- |
| 1 2 3 4 5Exclude;Sum Left;1Exclude;Sum Left Right;9Forge | 2 4 | 1. Marks for exclusion all gems for which the sum with neighbors to their left equals 1, e.g. 0 + **1** = 1 2. Marks for exclusion all gems for which the sum with neighbors to their left and their right equals 9, e.g. 2 + **3** + 4 = 94 + **5** + 0 = 9 |
| 1 2 3 4 5Exclude;Sum Left;1Reverse;Sum Left;1Forge | 1 2 3 4 5 | 1. Marks for exclusion all gems for which the sum with their gem peers to the left equals 1, e.g. 0 + 1 = 1 2. Reverses the previous exclusion. |