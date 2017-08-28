# Diffie Heldman Algorithm

**Diffie–Hellman key exchange (D–H)** is a method of securely exchanging cryptographic keys over a public channel and was one of the first public-key protocols as originally conceptualized by Ralph Merkle and named after Whitfield Diffie and Martin Hellman. D–H is one of the earliest practical examples of public key exchange implemented within the field of cryptography. <br />
See more info [here](https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange)

### Features
Multithread algorithm implementation
*	Implementation of Diffie Heldman algorithm
*   3 Threads (Alice, Bob and Eva)
*   CLI interface

### How to run
1. Download & unzip files from this repository
2. Open terminal and type in next command:
```sh
java -jar <PATH TO JAR FILE>
```
JAR file is located in `executable_files` folder
3. After press  `Enter` next lines will appear:
```sh
C:\Users\User> java -jar C:\Users\User\IdeaProjects\Diffie_Heldman\executable_files\Diffie_Heldman.jar
Alice send 5.0
Bob send 7.0
Bob receive 5.0
Alice receive 7.0
Bob private key is 14.0
Alice private key is 14.0
```
where ` C:\Users\User\IdeaProjects\Diffie_Heldman\executable_files\Diffie_Heldman.jar` example of `<PATH TO JAR FILE>`

### Describing parameters of this example
Parameter| Alice| Bob
------------ | -------------| -------------
`p` | 3| 3
`g` | 17| 17
`random`| 54|42
`password`| 14|14
<br />

`random`  is a private key<br />
`g` is a public generator<br />
`p` is a public primitive root modulo<br />
`password` is a private password.<br />
