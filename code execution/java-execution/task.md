So far you know:
1. Java Compiler `javac` - compiles `.java` -> `.class`
2. Java Virtual M `java` - converts `.class` -> `machine code` -> `execution on CPU` 

---

<h1> Program Lifecycle </h1>
This basically results in two phases of program lifecycle

<h2>Compile Time</h2>
The phase starts when `.java` file is fed to `javac` and produces `.class`

1. If there are syntax or static errors: `.class` won't be compiled, the compiler will tell you where you fucked up
2. If not -> successful compilation

<h2>Runtime</h2>
The phase starts when JVM started executing the `.class` bytecode. <br>
On this phase only runtime errors can occur.


---
<h1> Task </h1>

1. open a terminal
2. change to the `src` directory, where `Task.java` is located
3. run `javac ToBeCompiled.java` - to compile the .java source code
4. run `java ToBeCompiled` this will try to find `ToBeCompiled.class` in your directory and execute it.

What better error in terms of development on compile time or runtime?