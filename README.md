# Chuck Norris Cipher Encoder

## Chuck Norris encrypts only with zeros

### Description

Binary with ```0``` and ```1``` is good, but binary with only ```0``` is even better! This encoding has a name — the Chuck Norris Unary Code.

Let's convert our text into a sequence of zeros and spaces!

### Objectives

The encoding principle is simple. The input message consists of ASCII characters (7-bit). You need to transform the text into the sequence of ```0``` and ```1``` and use the Chuck Norris technique. The encoded output message consists of blocks of ```0```. A block is separated from another block by a space.

Two consecutive blocks are used to produce a series of the same value bits (only ```1``` or ```0``` values):

* First block: it is always ```0``` or ```00```. If it is ```0```, then the series contains ```1```, if not, it contains ```0```.
* Second block: the number of ```0``` in this block is the number of bits in the series

Let's take a simple example with a message which consists of only one character ```C```. The ```C``` symbol in binary is represented as ```1000011```, so with Chuck Norris technique this gives:

* 0 0 (the first series consists of only a single 1);
* 00 0000 (the second series consists of four 0);
* 0 00 (the third consists of two 1)
* So C is coded as: 0 0 00 0000 0 00





