# Adventurer – Map Navigation Simulator

This is a small Java exercise for simulating the movements of an adventurer on a text-based map.

The goal is to load a forest map and a movement scenario from input files, and compute the final position of the character, following basic movement rules.

---

## Problem Summary

- The map is made of impassable trees (`#`) and walkable spaces (` `).
- The adventurer starts at a given coordinate (x, y).
- He follows a sequence of directions (`N`, `S`, `E`, `O`).
- Movements outside the map or into trees are blocked.
- The simulation returns the final position.

---

## Example Input

`scenario1.txt`:

3,0

SSSSEEEEEENN

`carte.txt`:  

a 2D map using `#` and spaces (see file in `resources/`)

Expected output:
Final position: (9,2)

---
## Features

- Map loading from file

- Scenario validation (invalid coordinates/directions are rejected or ignored)

- Full movement simulation

- Logging using SLF4J (with Logback)

- Unit tests (JUnit 5)

---
## How to Run

### Requirements
- Java 17+
- Maven

### Run the simulation:

```bash 
mvn clean compile exec:java -Dexec.mainClass="com.cleva.adventurer.app.Main"
