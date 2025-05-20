# 🧮 Subnet Calculator (Java CLI)
This project is a simple Java-based command-line subnet calculator, which allows users to input an IPv4 address and a subnet mask length, then calculates and displays subnet addresses for a given number of subnets.
## 📌 Features
- User input validation for IPv4 address and subnet mask.
- Binary conversion of IP and subnet mask.
- Bitwise AND operation to determine the network address.
- Calculates and displays:
  - Subnet mask in binary.
  - Network address.
  - Subnet ranges for a specified number of subnets.
- Handles binary arithmetic and subnetting logic internally.
## 🧾 How It Works
1. The user is prompted to input the 4 octets of an IP address (0–255).
2. The user enters the length of the subnet mask (1–32).
3. The program asks for the number of desired subnets.
4. Based on the subnet mask and subnet count, it:
- Calculates how many bits are needed.
- Generates subnet addresses by binary manipulation.
- Displays the binary and decimal representation of each calculated subnet.
## 🚀 Running the Project
1. Compile the program:
```bash
javac Main.java
```
2. Run the program:
```bash
java Main
```
3. Follow the prompts in the console.
## 📝 Example Output
```yaml
Podaj 1 oktet: 192
Podaj 2 oktet: 168
Podaj 3 oktet: 1
Podaj 4 oktet: 0
Podaj dlugosc maski: 24
Podaj liczbę podsieci: 4
...
```
