<h2>Brief introduction to how programs are executed</h2>
I'll be using the following definitions: <br>

_**Concrete**_ = more details <br> 
_**Abstract**_ = less details <br>

_**Concrete**_ or _**Abstract**_ are relative definitions depending on the level.
C is **_concrete_** relative to python but _**abstract**_ relative to the machine code. 

**_Machine_** = **_CPU_**<br>
**_Machine code_** = **_code for CPU_**

---

Running a program (in increasing level of abstraction) :

<h2> 1. CPU </h2>
Everything is done by CPU. To execute anything, you need a CPU. CPU is the lowest level of abstraction. <br>

| CPU Input      | Instruction in binary (machine code) (e.g. `0x40`)         |
|----------------|------------------------------------------------------------|
| **CPU Output** | **Executing the instruction (e.g. `Increment by 1`)** <br> |


We kinda just agreed upon, that 0x40 corresponds to "Increment by 1" instruction for some particular CPU. 
The instructions vary from CPU to CPU. Some instructions run on one CPU will not run on the other CPU (E.g. x86-CPUs(Intel/AMD) code will not run on ARM-CPUs) <br>
- We understand human description: `Increment by 1` <br>
- CPU understands only binary (machine code): `0x40` <br> 

> **_HUMAN_** > machine code (`0x40`) > _**CPU**_ > executing `Increment by 1`

<h2> 1. Assembler/Disassembler </h2>

**_Assembly code_** = **_Machine code_** in a human-readable form. <br>
The abstraction level is **_the same_** as CPU, because it's 1-to-1 mapping between assembly instruction and binary instruction. It's as concrete as machine code, except it's readable <br>



|              | Input                      | Output                     |
|--------------|----------------------------|----------------------------|
| Assembler    | Assembly code (e.g. `INC`) | Machine Code (e.g. `0x40`) |
| Disassembler | Machine code (e.g. `0x40`) | Assembly Code (e.g. `INC`) |


> **_HUMAN_** > assembly code (`INC`) > **_ASSEMBLER_** > machine code (`0x40`) > _**CPU**_ > executing `Increment by 1` <br> <br>
> Machine code (`0x40`) > _**DISASSEMBLER**_ > Assembly code (`INC`) > _**HUMAN**_ <br>

<h2> 3. Compiler </h2>
Compiler - is an abstraction above assembly code. Compiler compiles source code of a language to assembly code

E.g. (C lang)

|            | Input                         | Output                                |
|------------|-------------------------------|---------------------------------------|
| Compiler   | source code (e.g. in C `i++`) | assembly code (`INC`)                 |
| Decompiler | assembly code (`INC`)         | source code (e.g. in C `i++` )        |


<div class="hint">
  Some compilers contain often assembler within, and from the outside it would appear, that the compiler compiles source code directly to machine code.
</div>


> **_HUMAN_** > source code (`i++`) > _**COMPILER**_ > [assembly code (`INC`) > **_ASSEMBLER_**] > machine code (`0x40`) > _**CPU**_ > executing `Increment by 1` <br> <br>

> Machine code (`0x40`) > [_**DISASSEMBLER**_ > assembly code (`INC`)] > _**DECOMPILER**_ > source code (`i++`) > _**HUMAN**_ <br>
 
---

Problem:
- You have x86 CPU <br>
- Your friend has ARM CPU <br>
- You write a program in C and compile it for your CPU. (Compilers can compile code for different CPUs(x86, ARM etc))
- It produces assembly (= machine code) specific for x86 CPU.
- You want the friend to be able to run the same program on his ARM CPU
- Since the your machine code is only for x86, it cannot run on ARM CPU

Solutions:
1. Compile the source code for each CPU separately

![img.png](../code%20execution/img.png)

2. Create a program, that acts as a different CPU ("fake"/**_"virtual" CPU_**)
   1. It takes some binary machine code (like a normal CPU) and executes it.
   2. The binary machine code (=instructions) for **_virtual CPU_** is the same for everyone. 
      1. -> So everyone has the same "virtual" CPU and same instructions 
      2. -> (unlike "real" CPUs, whose instructions can be different for different CPU (ARM, x86 etc.))
   3. It takes the given binary machine code (which is the same for everyone) and converts it to the binary machine code for a target CPU(which is different for someone)
   4. So instead of creating compiling a source code to a machine code for each CPU we:
      1. Create different virtual CPUs (different programs) for different real CPUs
      2. Different virtual CPUs accept however the same machine code
      3. We compile our source code to the machine code for virtual CPU.
      4. Virtual CPU accept the same machine code and translate it to the machine code of the real CPU, on which they are running.

![img_2.png](../code%20execution/img_2.png)

<h2> 4. Virtual Machines </h2>

Virtual Machine is a program, that executes 
machine code not designed for the target CPU <br>
**_Virtual Machine (VM)_** = **_virtual CPU_** <br>


Virtual machine is a fake CPU on top of the target CPU. Takes its own custom machine code and translates it to the target CPU machine code and runs it. <br>
VMs does not directly produce visible machine code for the CPU, that can be run later. They translate it internally and run it immediately after translation  <br>
!! They do not produce a machine code that can be run later, they are not a compilers. They are simulating the underlying CPU. They take a command -> they translate it in target machine code and run it) 

Definitions for disambiguation, that I'll use: <br>
**_Normal CPU_** accepts **_machine code_** <br>
_**Virtual Machine(CPU)**_ accepts **_bytecode_** (=just different name for machine code for VMs) <br>



|                        |                                                                                                                   |
|------------------------|-------------------------------------------------------------------------------------------------------------------|
| Virtual Machine Input  | **_Bytecode_** (VM's machine code) (some generic machine code (same for all VMs) (you can come up with your own)) |
| Virtual Machine Output | **_Machine code_** for the target CPU <br> **AND** <br> _**Execution**_ of this produced code on the target CPU.  |



> **_HUMAN_** > VM bytecode (`0x10`) > **_Virtual Machine_** > machine code (`0x40`) > _**CPU**_ > executing `Increment by 1`

<h2> 5. Assemblers\Compilers (for VM) </h2>
There is no such definition as Compilers for VM, but it's useful to differentiate between Compilers\Assemblers for real CPUs and for VMs. <br>

For all compilers **_always_** applies: they **produce machine code** **from the source code**. But they can produce machine code for:
1. Real CPU (described earlier) 
2. VM (bytecode)

They act the same, but instead of compilation for real CPU its compiled to VM
The table is the same as with the other compilers and assemblers:

|                     | Input                                                      | Output                                                     |
|---------------------|------------------------------------------------------------|------------------------------------------------------------|
| Assembler for VM    | Human readable bytecode  (e.g. `iinc`)                     | Bytecode for VM (e.g. for JVM : `0x10` )                   |                                                          |
| Disassembler for VM | Bytecode for VM (e.g. for JVM : `0x10` )                   | Human readable bytecode  (e.g. `iinc`)                     |
| Compiler for VM     | Source code (e.g. .java `i++`)                             | Intermediate assembly code for VM (e.g. for JVM : `iinc` ) |                                                           |
| Decompiler for VM   | Intermediate assembly code for VM (e.g. for JVM : `iinc` ) | Source code (e.g. .java `i++`)                             |

> **_HUMAN_** > source code (`i++`) > **_Compiler_** > [assembly code(`iinc`) >  Assembler] > bytecode (`0x10`) > **_Virtual Machine_** > machine code (`0x40`) > _**CPU**_ > executing `Increment by 1` <br>
> <br>
> bytecode (`0x10`) > [ Disassembler > assembly code (`iinc`) ] > **_Decompiler_** > java source code (`i++`) > **_HUMAN_** <br>


<h2> Big Picture </h2>
Here for example is two possible compilation paths from source code to execution for x86 CPU

![img_1.png](../code%20execution/img_1.png)

Assembly usually considered as intermediate step, which is done within compilers (both for real CPU and VMs)
So it's mostly produces the executable code/byte code

![img_3.png](../code%20execution/img_3.png)


To sum it up: <br>

<h2> JVM </h2>
We are dealing here with a particular VM, namely Java Virtual Machine <br>
Java

|                                       | Input                                                                    | Output                                                                     |
|---------------------------------------|--------------------------------------------------------------------------|----------------------------------------------------------------------------|
| Java VM (`java`)                      | Bytecode (`.class` files) - `0x1`                                        | **_CPU Machine code_** - `0x40`  <br> AND <br> _**Execution**_ of the code |
| Java Compiler (`javac`)               | Source code (`.java` files) - `i++`                                      | Bytecode (`.class` files) - `0x1`                                          |
|                                       |                                                                          |                                                                            |
| Java Assembler (not usually used)     | ???                                                                      | Bytecode (`.class` files) - `0x1`                                          |
| Java Disassembler (`javap`)           | JVM Bytecode (`.class  ` files)                                          | Human readable bytecode  (e.g. `iinc`)                                     |
| Java Decompiler   (FernFlower, etc..) | JVM Bytecode (`.class  ` files) / Human readable bytecode  (e.g. `iinc`) | Source code (e.g. .java `i++`)                                             |


<h2> Sum Up: </h2>

Forward Engineering:

|                         | Input                               | Output                                                                     |
|-------------------------|-------------------------------------|----------------------------------------------------------------------------|
| CPU                     | Machine code  - `0x40`              | Execution of instructions - `Increment by 1`                               |
| Assembler               | Assembly code - `INC`               | Machine code - `0x40`                                                      |
| Compiler                | Source code - `i++`                 | Assembly code - `INC`                                                      |
|                         |                                     |                                                                            |
| VM                      | Bytecode  - `0x1`                   | **_CPU Machine code_** - `0x40`  <br> AND <br> _**Execution**_ of the code |
| Assembler (VM)          | Human readable bytecode - `iinc`    | Bytecode - `0x1`                                                           |                                                          |
| Compiler (VM)           | Source code - `i++`                 | Human readable bytecode  - `iinc`                                          |                                                           |
|                         |                                     |                                                                            |
| Java VM (`java`)        | Bytecode (`.class` files) - `0x1`   | **_CPU Machine code_** - `0x40`  <br> AND <br> _**Execution**_ of the code |
| Java Compiler (`javac`) | Source code (`.java` files) - `i++` | Bytecode (`.class` files) - `0x1`                                          |

Reverse Engineering

|                                       | Input                                                                    | Output                                 |
|---------------------------------------|--------------------------------------------------------------------------|----------------------------------------|
| Disassembler                          | Machine code - `0x40`                                                    | Assembly code - `INC`                  |
| Decompiler                            | Machine code - `0x40` / Assembly code - `INC`                            | Source code - `i++`                    |
|                                       |                                                                          |                                        |
| Disassembler (VM)                     | Bytecode for VM - `0x10`                                                 | Human readable bytecode  (e.g. `iinc`) |
| Decompiler (VM)                       | Bytecode for VM - `0x10`  / Human readable bytecode  (e.g. `iinc`)       | Source code (e.g. .java `i++`)         |
|                                       |                                                                          |                                        |
| Java Disassembler (`javap`)           | JVM Bytecode (`.class  ` files)                                          | Human readable bytecode  (e.g. `iinc`) |
| Java Decompiler   (FernFlower, etc..) | JVM Bytecode (`.class  ` files) / Human readable bytecode  (e.g. `iinc`) | Source code (e.g. .java `i++`)         |



Python code how?