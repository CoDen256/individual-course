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
On this phase only runtime errors can occur.


---
<h1> Task </h1>

1. Compile 'ToBeCompiled.java' 
2. Run the compiled bytecode (get .class)
3. Observer the output
4. Disassemble the compiled bytecode and look inside (get 'assembly')
5. Decompile the compiled bytecode using IntelliJ IDEA (just open `.class` file) (get decompiled java code)


<div class="hint">
Steps: <br>
1. open a terminal <br>
2. change to the `src` directory, where `Task.java` is located <br>
3. run `javac ToBeCompiled.java` - to compile the .java source code <br>
4. run `java ToBeCompiled` this will try to find `ToBeCompiled.class` in your directory and execute it. <br>
5. 
</div>

<h1>Questions</h1>


- You will be given multiple questions that you have to answer in order to pass this task
- Open [Answers](psi_element://Answers)
- Put your answers in the values of the variables. 
- Run 'Check,' verify in the test results, what questions you have answered incorrectly.



<h2> A. </h2>
<h2> B. </h2>
<h2> C. </h2>
<h2> D. </h2>
What better error in terms of development on compile time or runtime?