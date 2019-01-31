### Problem 1.
## Exercises: Sets and Maps

This document defines the exercises for [&quot;Java Advanced&quot; course @ Software University](https://softuni.bg/trainings/1975/java-advanced-may-2018). Please submit your solutions (source code) of all below described problems in [Judge](https://judge.softuni.bg/Contests/1463/Sets-And-Maps-Exercises).

1. Problem 1.Unique Usernames

Write a simple program that reads from the console a sequence of usernames and keeps a collection with only the unique ones. Print the collection on the console in order of insertion:

### Examples

| **Input** | **Output** |
| --- | --- |
| 6IvanIvanIvanSemoMastikataIvanHubaviq1234 | IvanSemoMastikataHubaviq1234 |
| 10PeshoMaraPeshoGoshoStamatMaraSashkaPeshoStamatGosho | PeshoMaraGoshoStamatSashka |

1. Problem 2.Sets of Elements

On the first line you are given the length of two sets n and m. On the next n + m lines there are n numbers that are in the first set and m numbers that are in the second one. Find all non-repeating element that appears in both of them, and print them in same order at the console:

Set with length n = 4: {1, **3** , **5** , 7}

Set with length m = 3: { **3** , 4, **5** }

Set that contains all repeating elements -\&gt; { **3** , **5** }

### Examples

| **Input** | **Output** |
| --- | --- |
| 4 31357345 | 3 5 |
| 2 21315 | 1 |

1. Problem 3.Periodic Table

You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the compounds and at the end print all unique ones in ascending order:

### Examples

| **Input** | **Output** |
| --- | --- |
| 4Ce OMo O CeEeMo | Ce Ee Mo O |
| 3Ge Ch O NeNb Mo TcO Ne | Ch Ge Mo Nb Ne O Tc |

1. Problem 1.Count Symbols

Write a program that reads some text from the console and counts the occurrences of each character in it. Print the results in **alphabetical** (lexicographical) order.

### Examples

| **Input** | **Output** |   | **Input** | **Output** |
| --- | --- | --- | --- | --- |
| SoftUni rocks |  : 1 time/sS: 1 time/sU: 1 time/sc: 1 time/sf: 1 time/si: 1 time/sk: 1 time/sn: 1 time/so: 2 time/sr: 1 time/ss: 1 time/st: 1 time/s |   | Did you know Math.Round rounds to the nearest even integer? |  : 9 time/s.: 1 time/s?: 1 time/sD: 1 time/sM: 1 time/sR: 1 time/sa: 2 time/sd: 3 time/se: 7 time/sg: 1 time/sh: 2 time/si: 2 time/sk: 1 time/sn: 6 time/so: 5 time/sr: 3 time/ss: 2 time/st: 5 time/su: 3 time/sv: 1 time/sw: 1 time/sy: 1 time/s |

1. Problem 2.Phonebook

Write a program that receives some info from the console about **people** and their **phone numbers**.

You are free to choose the manner in which the data is entered; each **entry** should have just **one name** and **one number** (both of them strings). If you receive a name that **already exists** in the phonebook, simply update its number.

After filling this simple phonebook, upon receiving the **command**&quot; **search**&quot;, your program should be able to perform a search of a contact by name and print her details in format &quot; **{name} -\&gt; {number}**&quot;. In case the contact isn&#39;t found, print &quot; **Contact {name} does not exist.**&quot; Examples:

### Examples

| **Input** | **Output** |
| --- | --- |
| Nakov-0888080808 **search** MariikaNakovstop | Contact Mariika does not exist.Nakov -\&gt; 0888080808 |
| Nakov-+359888001122RoYaL(Ivan)-666Gero-5559393Simo-02/987665544 **search** SimosimoRoYaLRoYaL(Ivan)stop | Simo -\&gt; 02/987665544Contact simo does not exist.Contact RoYaL does not exist.RoYaL(Ivan) -\&gt; 666 |

1. Problem 3.A Miner Task

You are given a sequence of strings, each on a new line. Every odd line on the console is representing a resource (e.g. Gold, Silver, Copper, and so on) , and every even – quantity. Your task is to collect the resources and print them each on a new line.

**Print the resources and their quantities in format:**

**{resource} –\&gt; {quantity}**

The quantities inputs will be in the range [1 … 2 000 000 000]

### Examples

| **Input** | **Output** |
| --- | --- |
| Gold155Silver10Copper17stop | Gold -\&gt; 155Silver -\&gt; 10Copper -\&gt; 17 |

1. Problem 4.Fix Emails

You are given a sequence of strings, each on a new line, **unitll you receive &quot;stop&quot; command**. First string is a name of a person. On the second line you receive his email. Your task is to collect their names and emails, and remove emails whose domain ends with &quot;us&quot;, &quot;uk&quot; or &quot;com&quot; (case insensitive). Print:

**{name} – \&gt; {email}**

### Examples

| **Input** | **Output** |
| --- | --- |
| Ivan[ivanivan@abv.bg](mailto:ivanivan@abv.bg)Petar Ivanovpetartudjarov@abv.bgMike Tyson[myke@gmail.us](mailto:myke@gmail.us)stop | Ivan -\&gt; [ivanivan@abv.bg](mailto:ivanivan@abv.bg)Petar Ivanov -\&gt; petartudjarov@abv.bg |
| Ivan[ivanivan@gmail.com](mailto:ivanivan@gmail.com)Petar Ivanov[petartudjarov@yahoo.com](mailto:petartudjarov@yahoo.com)Mike Tyson[myke@abv.bg](mailto:myke@abv.bg)stop | Mike Tyson -\&gt; [myke@abv.bg](mailto:myke@abv.bg) |

1. Problem 5.Hands Of Cards

You are given a sequence of people and for every person what cards he draws from the deck. The input will be separate lines in the format:

**{personName}: {PT, PT, PT,… PT}**

Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type. The input ends when a **&quot;JOKER&quot;** is drawn. The name can contain any ASCII symbol except **&#39;:&#39;**. The input will always be valid and in the format described, there is no need to check it.

A single person cannot have more than one card with the same power and type, if he draws such a card he discards it. The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the type. Powers **2 to 10** have the same value and **J to A** are **11 to 14**. Types are mapped to multipliers the following way ( **S -\&gt; 4, H-\&gt; 3, D -\&gt; 2, C -\&gt; 1** ).

Finally print out the total value each player has in his hand in the format:

**{personName}: {value}**

### Examples

| **Input** | **Output** |
| --- | --- |
| Pesho: 2C, 4H, 9H, AS, QSSlav: 3H, 10S, JC, KD, 5S, 10SPeshoslav: QH, QC, QS, QDSlav: 6H, 7S, KC, KD, 5S, 10CPeshoslav: QH, QC, JS, JD, JCPesho: JD, JD, JD, JD, JD, JDJOKER | Pesho: 167Slav: 175Peshoslav: 197 |

1. Problem 6.\* User Logs

Marian is a famous system administrator. The person to overcome the security of his servers has not yet been born. However, there is a new type of threat where users flood the server with messages and are hard to be detected since they change their IP address all the time. Well, Marian is a system administrator and is not so into programming. Therefore, he needs a skillful programmer to track the user logs of his servers. You are the chosen one to help him!

You are given an input in the format:

**IP=(IP.Address) message=(A&amp;sample&amp;message) user=(username)**

Your task is to parse the ip and the username from the input and for **every user** , you have to display **every ip** from which the corresponding user has sent a message and the **count of the messages** sent with the corresponding ip. In the output, the usernames must be **sorted alphabetically** while their IP addresses should be displayed in the **order of their first appearance.** The output should be in the following format:

**username:**

**IP =\&gt; count, IP =\&gt; count.**

For example, given the following input - **IP=192.23.30.40 message=&#39;Hello&amp;derps.&#39; user=destroyer** , you have to get theusername **destroyer** and the IP **192.23.30.40** and display it in the following format:

**destroyer:**

**192.23.30.40 =\&gt; 1.**

The username destroyer has sent a message from ip 192.23.30.40 once.

Check the examples below. They will further clarify the assignment.

### Input

The input comes from the console as **varying number** of lines. You have to parse every command until the command that follows is **end.** The input will be in the format displayed above, there is no need to check it explicitly.

### Output

For every user found, you have to display each log in the format:

**username:**

**IP =\&gt; count, IP =\&gt; count…**

The IP addresses must be split with a comma, and each line of IP addresses must end with a dot.

### Constraints

- The number of commands will be in the range [1..50]
- The IP addresses will be in the format of either **IPv4** or **IPv6.**
- The messages will be in the format: **This&amp;is&amp;a&amp;message**
- The username will be a string with length in the range [3..50]
- Time limit: 0.3 sec. Memory limit: 16 MB.

### Examples

| **Input** | **Output** |
| --- | --- |
| IP=192.23.30.40 message=&#39;Hello&amp;derps.&#39; user=destroyerIP=192.23.30.41 message=&#39;Hello&amp;yall.&#39; user=destroyerIP=192.23.30.40 message=&#39;Hello&amp;hi.&#39; user=destroyerIP=192.23.30.42 message=&#39;Hello&amp;Dudes.&#39; user=destroyerend | destroyer: 192.23.30.40 =\&gt; 2, 192.23.30.41 =\&gt; 1, 192.23.30.42 =\&gt; 1. |
| IP=FE80:0000:0000:0000:0202:B3FF:FE1E:8329 message=&#39;Hey&amp;son&#39; user=motherIP=192.23.33.40 message=&#39;Hi&amp;mom!&#39; user=child0IP=192.23.30.40 message=&#39;Hi&amp;from&amp;me&amp;too&#39; user=child1IP=192.23.30.42 message=&#39;spam&#39; user=destroyerIP=192.23.30.42 message=&#39;spam&#39; user=destroyerIP=192.23.50.40 message=&#39;&#39; user=yetAnotherUsernameIP=192.23.50.40 message=&#39;comment&#39; user=yetAnotherUsernameIP=192.23.155.40 message=&#39;Hello.&#39; user=unknownend | child0: 192.23.33.40 =\&gt; 1.child1: 192.23.30.40 =\&gt; 1.destroyer: 192.23.30.42 =\&gt; 2.mother: FE80:0000:0000:0000:0202:B3FF:FE1E:8329 =\&gt; 1.unknown: 192.23.155.40 =\&gt; 1.yetAnotherUsername: 192.23.50.40 =\&gt; 2. |

1. Problem 7.\* Population Counter

So many people! It&#39;s hard to count them all. But that&#39;s your job as a statistician. You get raw data for a given city and you need to aggregate it.

On each input line you&#39;ll be given data in format: **&quot;city|country|population&quot;**. There will be **no redundant whitespaces anywhere** in the input. Aggregate the data **by country and by city** and print it on the console. For each country, print its **total population** and on separate lines the data for each of its cities. **Countries should be ordered by their total population in descending order** and within each country, the **cities should be ordered by the same criterion**. If two countries/cities have the same population, keep them **in the order in which they were entered.** Check out the examples; follow the output format strictly!

### Input

- The input data should be read from the console.
- It consists of a variable number of lines and ends when the command &quot; **report**&quot; is received.
- The input data will always be valid and in the format described. There is no need to check it explicitly.

### Output

- The output should be printed on the console.
- Print the aggregated data for each country and city in the format shown below.

### Constraints

- The name of the city, country and the population count will be separated from each other by **a pipe (&#39;|&#39;)**.
- The **number of input lines** will be in the range [2 … 50].
- A city-country pair will not be repeated.
- The **population count** of each city will be an integer in the range [0 … 2 000 000 000].
- Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.

### Examples

| **Input** | **Output** |
| --- | --- |
| Sofia|Bulgaria|1000000report | Bulgaria (total population: 1000000)=\&gt;Sofia: 1000000 |

| **Input** | **Output** |
| --- | --- |
| Sofia|Bulgaria|1Veliko Tarnovo|Bulgaria|2London|UK|4Rome|Italy|3report | UK (total population: 4)=\&gt;London: 4Bulgaria (total population: 3)=\&gt;Veliko Tarnovo: 2=\&gt;Sofia: 1Italy (total population: 3)=\&gt;Rome: 3 |

1. Problem 8.\* Logs Aggregator

You are given a sequence of access logs in format **\&lt;IP\&gt; \&lt;user\&gt; \&lt;duration\&gt;**. For example:

- 192.168.0.11 peter 33
- 10.10.17.33 alex 12
- 10.10.17.35 peter 30
- 10.10.17.34 peter 120
- 10.10.17.34 peter 120
- 212.50.118.81 alex 46
- 212.50.118.81 alex 4

Write a program to aggregate the logs data and print **for each user** the **total duration** of his sessions and a **list of unique IP addresses** in format &quot;**\&lt;user\&gt;: \&lt;duration\&gt; [\&lt;IP**

# 1
**\&gt;, \&lt;IP**
# 2
**\&gt;, …]**&quot;. Order the **users alphabetically**. Order the **IPs alphabetically**. In our example, the output should be the following:
- alex: 62 [10.10.17.33, 212.50.118.81]
- peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]

### Input

The input comes from the console. At the first line a number **n** stays which says how many log lines will follow. Each of the next n lines holds a log information in format **\&lt;IP\&gt; \&lt;user\&gt; \&lt;duration\&gt;**. The input data will always be valid and in the format described. There is no need to check it explicitly.

### Output

Print **one line for each user** (order users alphabetically). For each user print its sum of durations and all of his sessions&#39; IPs, ordered alphabetically in format **\&lt;user\&gt;: \&lt;duration\&gt; [\&lt;IP**

# 1
**\&gt;, \&lt;IP**
# 2
**\&gt;, …]**. Remove any duplicated values in the IP addresses and order them alphabetically (like we order strings).
### Constraints

- The **count** of the order lines **n** is in the range [1…1000].
- The **\&lt;IP\&gt;** is a standard IP address in format **a.b.c.d** where **a** , **b** , **c** and **d** are integers in the range [0…255].
- The **\&lt;user\&gt;** consists of only of **Latin characters** , with length of [1…20].
- The **\&lt;duration\&gt;** is an integer number in the range [1…1000].
- Time limit: 0.3 sec. Memory limit: 16 MB.

### Examples

| **Input** | **Output** |
| --- | --- |
| 7192.168.0.11 peter 3310.10.17.33 alex 1210.10.17.35 peter 3010.10.17.34 peter 12010.10.17.34 peter 120212.50.118.81 alex 46212.50.118.81 alex 4 | alex: 62 [10.10.17.33, 212.50.118.81]peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11] |
| 284.238.140.178 nakov 2584.238.140.178 nakov 35 | nakov: 60 [84.238.140.178] |

1. Problem 9.\* Legendary Farming

You&#39;ve beaten all the content and the last thing left to accomplish is own a legendary item. However, it&#39;s a tedious process and requires quite a bit of farming. Anyway, you are not too pretentious – any legendary will do. The possible items are:

- **Shadowmourne** – requires **250 Shards** ;
- **Valanyr** – requires **250 Fragments** ;
- **Dragonwrath** – requires **250 Motes** ;

**Shards, Fragments** and **Motes** are the **key materials** , all else is **junk.** You will be given lines of input, such as
**2 motes 3 ores 15 stones.** Keep track of the **key materials -** the **first** that reaches the **250 mark**** wins **the** race **. At that point, print the corresponding legendary obtained. Then, print the** remaining **shards, fragments, motes, ordered by** quantity **in** descending **order, each on a new line. Finally, print the collected** junk **items, in** alphabetical** order.

### Input

- Each line of input is in format **{quantity} {material} {quantity} {material} … {quantity} {material}**

### Output

- On the first line, print the obtained item in format **{Legendary item} obtained!**
- On the next three lines, print the remaining key materials in descending order by quantity
  - If two key materials have the same quantity, print them in alphabetical order
- On the final several lines, print the junk items in alphabetical order
  - All materials are printed in format **{material}: {quantity}**
  - All output should be **lowercase** , except the first letter of the legendary

### Constraints

- The quantity-material pairs are between 1 and 25 per line.
- The number of lines is in range [1..10]
- All materials are case-insensitive.
- Allowed working time: 0.25s
- Allowed memory: 16 MB

### Examples

| **Input** | **Output** |
| --- | --- |
| 3 Motes 5 stones 5 Shards6 leathers 255 fragments 7 Shards | Valanyr obtained!fragments: 5shards: 5motes: 3leathers: 6stones: 5 |





| **Input** | **Output** |
| --- | --- |
| 123 silver 6 shards 8 shards 5 motes9 fangs 75 motes 103 MOTES 8 Shards86 Motes 7 stones 19 silver | Dragonwrath obtained!shards: 22motes: 19fragments: 0fangs: 9silver: 123 |

1. Problem 10.\*\* Сръбско Unleashed

Admit it – the СРЪБСКО is your favorite sort of music. You never miss a concert and you have become quite the geek concerning everything involved with СРЪБСКО. You can&#39;t decide between all the singers you know who your favorite one is. One way to find out is to keep a statistics of how much money their concerts make. Write a program that does all the boring calculations for you.

On each input line you&#39;ll be given data in format: **&quot;singer @venue ticketsPrice ticketsCount&quot;**. There will be **no redundant whitespaces anywhere** in the input. Aggregate the data **by venue and by singer**. For each venue, print the singer and the total amount of money his/her concerts have made on a separate line. **Venues** should be kept in the **same order** they were entered, the **singers** should be **sorted by how much money** they have made in **descending order**. If two singers have made the same amount of money, keep them **in the order** in which **they were entered.**

Keep in mind that if a line is in incorrect format, it should be skipped and its data should not be added to the output. Each of the four tokens must be separated by **a space** , everything else is invalid. The venue should be denoted with **@** in front of it, such as @Sunny Beach

**SKIP THOSE** : Ceca@Belgrade125 12378, Ceca @Belgrade12312 123

The singer and town name may consist of one to three words.

### Input

- The input data should be read from the console.
- It consists of a variable number of lines and ends when the command &quot; **End**&quot; is received.
- The input data will always be valid and in the format described. There is no need to check it explicitly.

### Output

- The output should be printed on the console.
- Print the aggregated data for each venue and singer in the format shown below.
- Format for singer lines is **#{2\*space}{singer}{space}-\&gt;{space}{total money}**

### Constraints

- The **number of input lines** will be in the range [2 … 50].
- The **ticket price** will be an integer in the range [0 … 200].
- The **ticket count** will be an integer in the range [0 … 100 000]
- **Singers** and **venues** are case sensitive
- Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.

### Examples

| **Input** | **Output** |
| --- | --- |
| Lepa Brena @Sunny Beach 25 3500Dragana @Sunny Beach 23 3500Ceca @Sunny Beach 28 3500Mile Kitic @Sunny Beach 21 3500Ceca @Sunny Beach 35 3500Ceca @Sunny Beach 70 15000Saban Saolic @Sunny Beach 120 35000End | Sunny Beach#  Saban Saolic -\&gt; 4200000#  Ceca -\&gt; 1270500#  Lepa Brena -\&gt; 87500#  Dragana -\&gt; 80500#  Mile Kitic -\&gt; 73500 |





| **Input** | **Output** |
| --- | --- |
| Lepa Brena @Sunny Beach 25 3500Dragana@Belgrade23 3500Ceca @Sunny Beach 28 3500Mile Kitic @Sunny Beach 21 3500Ceca @Belgrade 35 3500Ceca @Sunny Beach 70 15000Saban Saolic @Sunny Beach 120 35000End | Sunny Beach#  Saban Saolic -\&gt; 4200000#  Ceca -\&gt; 1148000#  Lepa Brena -\&gt; 87500#  Mile Kitic -\&gt; 73500Belgrade#  Ceca -\&gt; 122500 |

1. Problem 11.\*\*\* Dragon Army

Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. Stamat is no exclusion to this rule. His favorite units in the game are all **types** of dragons – black, red, gold, azure etc… He likes them so much that he gives them **names** and keeps logs of their **stats** : **damage, health** and **armor**. The process of aggregating all the data is quite tedious, so he would like to have a program doing it. Since he is no programmer, it&#39;s your task to help him

You need to categorize dragons by their **type**. For each dragon, identified by **name,** keep information about his **stats.** Type is **preserved** as in the order of input, but dragons are **sorted** alphabetically by name. For each type, you should also print the average **damage** , **health** and **armor** of the dragons. For each dragon, print his own stats.

There **may** be **missing** stats in the input, though. If a stat is missing you should assign it default values. Default values are as follows: health **250** , damage **45** , and armor **10**. Missing stat will be marked by **null**.

The input is in the following format **{type} {name} {damage} {health} {armor}.** Any of the integers may be assigned null value. See the examples below for better understanding of your task.

If the same dragon is added a second time, the new stats should **overwrite** the previous ones. Two dragons are considered **equal** if they match by **both** name and type.

### Input

- On the first line, you are given number N -\&gt; the number of dragons to follow
- On the next N lines you are given input in the above described format. There will be single space separating each element.

### Output

- Print the aggregated data on the console
- For each type, print average stats of its dragons in format **{Type}::({damage}/{health}/{armor})**
- Damage, health and armor should be rounded to two digits after the decimal separator
- For each dragon, print its stats in format **-{Name} -\&gt; damage: {damage}, health: {health}, armor: {armor}**

### Constraints

- N is in range [1…100]
- The dragon type and name are one word only, starting with capital letter.
- Damage health and armor are integers in range [0 … 100000] or **null**

### Examples

| **Input** | **Output** |
| --- | --- |
| 5Red Bazgargal 100 2500 25Black Dargonax 200 3500 18Red Obsidion 220 2200 35Blue Kerizsa 60 2100 20Blue Algordox 65 1800 50 | Red::(160.00/2350.00/30.00)-Bazgargal -\&gt; damage: 100, health: 2500, armor: 25-Obsidion -\&gt; damage: 220, health: 2200, armor: 35Black::(200.00/3500.00/18.00)-Dargonax -\&gt; damage: 200, health: 3500, armor: 18Blue::(62.50/1950.00/35.00)-Algordox -\&gt; damage: 65, health: 1800, armor: 50-Kerizsa -\&gt; damage: 60, health: 2100, armor: 20 |
| **Input** | **Output** |
| 4Gold Zzazx null 1000 10Gold Traxx 500 null 0Gold Xaarxx 250 1000 nullGold Ardrax 100 1055 50 | Gold::(223.75/826.25/17.50)-Ardrax -\&gt; damage: 100, health: 1055, armor: 50-Traxx -\&gt; damage: 500, health: 250, armor: 0-Xaarxx -\&gt; damage: 250, health: 1000, armor: 10-Zzazx -\&gt; damage: 45, health: 1000, armor: 10 |