# Sticker Album Trade

A Java console program written in 2022 as a university object-oriented programming exercise. It reads
one text file holding my World Cup sticker album and five friends' albums, works out which stickers can
be swapped one for one, carries out the swaps and prints them, followed by the stickers I am still
missing.

## Input format

Each data file (`data/input1.txt`, `input2.txt`, `input3.txt`, with 40, 320 and 640 stickers) has:

1. the number of stickers N, then N lines of `CODE COUNT` for my album, for example `QAT2 3`;
2. the number of friends (5 in all three files);
3. for each friend, N again and N lines of `CODE COUNT`.

A code is a 3-letter country plus a number. COUNT is how many copies the album holds: 0 means missing,
more than 1 means there are spares to give away. Albums are compared by position, not by code, so every
album must list the same stickers in the same order.

## How the swaps are decided

1. For each friend, `Compare` counts the stickers the friend has spares of and I am missing, and the
   stickers I have spares of and the friend is missing. The possible swaps are the smaller of the two.
2. `Trade` sorts the friends once by that number, highest first.
3. In that order, `Trade` recounts against my album as it is at that point and makes up to that many
   1-for-1 swaps. The order is not recomputed between friends.
4. `App` prints each friend's swaps and then the stickers I still lack.

Classes: `App` (reads the file and runs the steps), `Album` and `Sticker` (the data), `Compare` and
`Trade` (the steps above).

## Running it

Needs a JDK with `javac` and `java` on the PATH (checked with JDK 25). Start from the repository root; the
first command moves into `src/` and every later command runs there.

`App` always reads `data/input1.txt`; the tests use all three inputs.

```bash
cd src
javac -cp .:../lib/junit-platform-console-standalone-1.9.2.jar *.java
java App
```

Output for `input1.txt`, which matches `data/output1.txt`:

```
amigo 1
obtive: QAT1 QAT4 QAT13 QAT16 ECU13
dei: QAT6 QAT7 QAT11 ECU2 ECU19
amigo 2
obtive: QAT10
dei: QAT2
amigo 3
obtive: ECU14
dei: QAT12
cartas em falta:
```

The output is in Portuguese: `amigo N` is friend N (numbered from 0 in file order), `obtive` lists the
stickers I got, `dei` the ones I gave, and `cartas em falta` the stickers still missing (none here).
Friends with no possible swaps are left out.

On Windows, use `;` instead of `:` in the class path.

## Tests

`src/AppTest.java` has 9 JUnit 5 tests, three per data file: the file loads with 5 friends whose albums
are the same size as mine, each friend's swap count in trading order, and the full printed output compared
with `data/output1.txt` to `output3.txt`. The JUnit console runner is in `lib/`.

From `src/`, after the compile step above:

```bash
java -jar ../lib/junit-platform-console-standalone-1.9.2.jar --class-path . --scan-classpath
```

All 9 pass. If the data files cannot be found, the run stops with `There was an error loading the file`
instead of a test report, because `App.readInput` calls `System.exit(1)` on any error.
