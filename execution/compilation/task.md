<h1> So far you know </h1>

- Java Compiler `javac` - compiles `.java` -> `.class` (bytecode) <br>
- Java Virtual M `java` - converts `.class` -> `machine code` -> `execution on CPU` 

---

<h1> Theory </h1>

<h3> Program lifecycle </h3>
The whole programming basically results in two phases of program lifecycle

<h3>Compile Time</h3>
The "compile-time" phase starts when `.java` file is fed to `javac` and produces `.class`

1. If there are syntax or static errors: `.class` won't be compiled, the compiler will tell you where you fucked up
2. If its correct -> successful compilation -> `.class` produced

<h3>Runtime</h3>
The phase starts when JVM started executing the `.class` bytecode. <br>
On this phase only runtime errors can occur. Which is kinda really hard to debug in comparison to compile time.


---
<h1> Task </h1>

1. Compile 'ToBeCompiled.java' 
2. Run the compiled bytecode (get .class)
3. Observer the output
4. Examine ToBeCompiled.java source code.
5. Disassemble the compiled bytecode and look inside (get readable 'bytecode')
6. Decompile the compiled bytecode using IntelliJ IDEA (just open `.class` file) (get decompiled java code)
7. Compare source code with the decompiled code and disassembled code.


<div class="hint">
Steps: <br>
1. open a terminal <br>
2. change to the `src` directory, where `Task.java` is located <br>
3. run `javac ToBeCompiled.java` - to compile the .java source code <br>
4. run `java ToBeCompiled` this will try to find `ToBeCompiled.class` in your directory and execute it. <br>
5. run `javap -c ToBeCompiled.class` to view the disassembled bytecode
</div>

---

<h1>Questions</h1>


- You will be given multiple questions that you have to answer in order to pass this task
- Open [Answers](file://execution/compilation/src/Answers.java)
- Put your answers in the values of the variables. 
- Run 'Check,' verify in the test results, what questions you have answered incorrectly.



<h2> A. What is the output, when 'ToBeCompiled' is run? </h2>
<h2> B. What instruction (from bytecode) corresponds to adding two numbers?</h2>
Inspect the source code along with the disassembled bytecode.
<h2> C. What is the name of the variable in the decompiled that corresponds to variable 'b' in .java</h2>
Examine. ToBeCompiled.java and decompiled by Jetbrains ToBeCompiled.class. 
<h2> D. What do you think is better? Catch error on compile time or runtime? </h2>
