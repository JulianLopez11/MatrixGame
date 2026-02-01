# 🕶️ Matrix Game

## 📖 Description
**Matrix Game** is a console-based simulation inspired by *The Matrix*. The environment is represented by a fixed two-dimensional grid, where each cell may contain a game element.

The main character, **Neo**, navigates through the board attempting to reach the **Phone**, which represents the escape point. The board is populated with multiple **Smith agents**, whose goal is to capture Neo, as well as **walls**, which act as impassable obstacles.

At each turn, **Neo and the Smith agents move independently and randomly**, respecting board boundaries and avoiding walls. After every turn, the **current state of the board is printed to standard output**, allowing users to follow the simulation step by step.

The simulation ends when:
- **Neo reaches the Phone** (win condition)
- **Neo is captured by an agent** (lose condition)

---

## 🚀 Getting Started
Follow these instructions to run the project locally for development or testing purposes.

### ✅ Prerequisites
Make sure you have the following installed:

- **Java Development Kit (JDK) 8 or higher**
- *(Optional)* An IDE such as **VS Code**, **IntelliJ IDEA**, or **Eclipse**

---

### ⚙️ Installation
Step-by-step guide to set up the project:

1) Clone the repository

```
git clone <REPOSITORY_URL>
cd MatrixGame
```



2) Compile the Java classes.

```
javac src/domain/*.java
```

3) Run the simulation.

```
java -cp src/domain MatrixGame
```

Example output (board):

```
| N |   |   |   |   |   |   |   |
|   |   |   |   |   |   |   | A |
| W |   |   |   |   |   |   |   |
|   |   |   | A |   |   |   |   |
|   |   |   |   |   |   | W |   |
|   |   |   |   |   | A |   | W |
|   |   |   |   |   |   |   |   |
|   |   |   |   |   |   |   | T |
```

## Built With
- Java (JDK 8+)

## Contributing
Suggestions and improvements are welcome. Open an issue or submit a pull request with a clear description of your change.

## Authors
- Julian Camilo Lopez Barrero
