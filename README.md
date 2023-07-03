### Groovy language 3 points.
1.1 Implement Calculator Using Groovy programming language. Input Parameter: String to be calculated. It contains numbers, operators and parentheses.

1.1.1 Support operations +,- with unlimited arguments (1+2).

1.1.2 Support *,/ (don’t forget about operations priority).

1.1.3 Support bracket operation (“(2+2)*3”).

1.1.4 Use GString, Groovy Operator Overloading, Groovy closures.

1.1.5 Use at least two Groovy specific operators (**|?.|&. etc..).

Input data can be integer and without spaces (For example: “2+2*(5-7)”).

---

To build the project, type in the terminal:
```shell
./gradlew runCalculator --args='5+3'
```
or 
```shell
./gradlew runCalculator --args='2+2*(5-7)'
```

To test the project, type in the terminal:
```shell
./gradlew test
```
or 
```shell
./gradlew check
```

---

### Git Advanced task

To view the commit history of task1-feature branch type:

```shell
git log task1-feature
```

There will be two last commits:
 - Added Intermediate logging of math operation results.
 - Implemented support large numbers in math operations.

If you type the command:
```shell
git log main
```
you'll see the same commit "Implemented support large numbers in math operations."

Change 2