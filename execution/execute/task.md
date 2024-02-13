<h2>Brief introduction to how programs are executed</h2>
I'll be using the following definitions: <br>

_**Concrete**_ = more details <br> 
_**Abstract**_ = less details <br>

_**Concrete**_ or _**Abstract**_ are relative definitions depending on the level.
C is **_concrete_** relative to python but _**abstract**_ relative to the machine code. 


Running a program (in increasing level of abstraction) :

<h2> 1. CPU </h2>
Everything is done by CPU. To execute anything, you need a CPU. CPU is the lowest level of abstraction. <br>

| CPU Input      | Instruction in binary (machine code) (e.g. 0x40)         |
|----------------|----------------------------------------------------------|
| **CPU Output** | **Executing the instruction (e.g. Increment by 1)** <br> |


We kinda just agreed upon, that 0x40 corresponds to "Increment by 1" instruction for some particular CPU. The instructions vary from CPU to CPU <br>
We understand human description: "Increment by 1" <br>
CPU understands only binary (machine code): "0x40" <br> 


("0x2C" is funny enough also a human (hex) representation of binary number like "1000000")  <br>

> **_HUMAN_** > machine code (0x40) > _**CPU**_ > executing "Increment by 1"

<h2> 2 Assembler/Disassembler </h2>

**_Assembly code_** = Machine code in a human-readable form. <br>
The abstraction level is basically the same, because it's 1-to-1 mapping between assembly instruction and binary instruction. It's as concrete as machine code, except it's readable <br>


|              | Input                      | Output                     |
|--------------|----------------------------|----------------------------|
| Assembler    | Assembly code (e.g. "INC") | Machine Code (e.g. "0x40") |
| Disassembler | Machine code (e.g. "0x40") | Assembly Code (e.g. "INC") |


> **_HUMAN_** > assembly code ("INC") > **_ASSEMBLER_** > machine code (0x40) > _**CPU**_ > executing "Increment by 1" <br> <br>
> Machine code (0x40) > _**DISASSEMBLER**_ > Assembly code ("INC") > _**HUMAN**_ <br>

<h2> 3. Compiler </h2>
Compiler - is an abstraction above assembly code. Compiler compiles source code of a language to assembly code

E.g. (C lang)

|            | Input                         | Output                         |
|------------|-------------------------------|--------------------------------|
| Compiler   | source code (e.g. in C "i++") | assembly code ("INC")          |
| Decompiler | assembly code ("INC")         | source code (e.g. in C "i++" ) |


<div class="hint">
  Some compilers contain often assembler within, and from the outside it would appear, that the compiler compiles source code directly to machine code.
</div>


> **_HUMAN_** > source code ("i++") > _**COMPILER**_ > [assembly code > **_ASSEMBLER_**] > machine code (0x40) > _**CPU**_ > executing "Increment by 1" <br> <br>

> Machine code (0x40) > [_**DISASSEMBLER**_ > Assembly code ("INC")] > _**DECOMPILER**_ > source code ("i++") > _**HUMAN**_ <br>
 
---

Problem:
- You have x86 CPU <br>
- Your friend has ARM CPU <br>
- You write a program in C and compile it for your CPU. (Compilers can compile code for different CPUs(x86, ARM etc))
- It produces assembly (= machine code) specific for x86 CPU.
- You want the friend to be able to run the same program on his ARM CPU
- Since the your machine code is only for x86, it cannot run on ARM CPU


<h2> 4. Virtual Machines </h2>
Virtual Machine (in context of languages) is a program, that execute 
machine code not designed for the target CPU <br>

Virtual machine is a fake CPU on top of CPU 

|   |   |
|---|---|
|   |   |
|   |   |







Human
`javap -c Main.class`