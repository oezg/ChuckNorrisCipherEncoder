# Chuck Norris Cipher Encoder

## Chuck Norris encrypts only with zeros

### Description

Binary with `0` and `1` is good, but binary with only `0` is even better! This encoding has a name — the Chuck Norris Unary Code.

Let's convert our text into a sequence of zeros and spaces!

### Objectives

The encoding principle is simple. The input message consists of ASCII characters (7-bit). You need to transform the text into the sequence of `0` and `1` and use the Chuck Norris technique. The encoded output message consists of blocks of `0`. A block is separated from another block by a space.

Two consecutive blocks are used to produce a series of the same value bits (only `1` or `0` values):

* First block: it is always `0` or `00`. If it is `0`, then the series contains `1`, if not, it contains `0`.
* Second block: the number of `0` in this block is the number of bits in the series

Let's take a simple example with a message which consists of only one character `C`. The `C` symbol in binary is represented as `1000011`, so with Chuck Norris technique this gives:

* `0 0` (the first series consists of only a single `1`);
* `00 0000` (the second series consists of four `0`);
* `0 00` (the third consists of two `1`)
* So `C` is coded as: `0 0 00 0000 0 00`

## Try to understand it

### Description

Write a decoder for a cipher. Transform the encrypted message into its original format.

### Objectives

Program receives a string of zeros and spaces and converts it to readable text. It must parse the string to the blocks of zeroes and decode the message the same way as in previous stages but in reversed order.

For example, your program receives `0 0 00 0000 0 000 00 0000 0 00`. You can split blocks of zeros and group those blocks by two. Then you need to decode these blocks like in the previous stage:

* `0 0` is `1`
* `00 0000` is `0000`
* `0 000` is `111`
* `00 0000` is `0000`
* `0 00` is `11`

Concatenation of the lines above gives us `10000111000011`.

After that, you need to split the result into blocks of seven symbols (binary form) and convert these blocks to characters. In this case, splitting `10000111000011` by seven symbols gives us two characters — `1000011` `1000011` , convert them into characters and the result will be `CC` (`C` is `1000011`).

## Cooler than Chuck Norris

### Description

Add a simple user interface. The program asks the user for the desired option (encode/decode/exit), performs it, and all that in a loop until the user wants to finish.

### Example

~~~~
Please input operation (encode/decode/exit):
encode
Input string:
Hey!
Encoded string:
0 0 00 00 0 0 00 000 0 00 00 00 0 0 00 0 0 00000 00 00 0 0 00 0 0 0 00 0000 0 0

Please input operation (encode/decode/exit):
decode
Input encoded string:
0 0 00 00 0 0 00 000 0 00 00 00 0 0 00 0 0 00000 00 00 0 0 00 0 0 0 00 0000 0 0
Decoded string:
Hey!
~~~~
