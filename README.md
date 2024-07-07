
# Order Management System

## Overview

The **Order Management System** is a Java-based application designed to manage and process orders using container-like data structures, namely **Queue** and **Stack**. Orders are read from files, processed, and stored in these containers based on their total amounts. Orders with a total amount above or equal to 1500 are stored in a queue (FIFO), while orders with a total amount below 1500 are stored in a stack (FILO).

## Features

- **Container Class**: A generic container class that provides methods for adding, removing objects, and querying the size of the container.
- **Queue Class**: Simulates a queue data structure and stores orders with a total amount above or equal to 1500.
- **Stack Class**: Simulates a stack data structure and stores orders with a total amount below 1500.
- **IOHandler Class**: Provides static methods for reading and writing files.
- **Order Class**: Represents an order with details such as order ID, customer name, product name, quantity, and unit price.

## Project Structure

```
ordermanagementsystem
├── src
│   └── ordermanagementsystem
│       ├── Container.java
│       ├── Queue.java
│       ├── Stack.java
│       ├── IOHandler.java
│       └── Order.java
├── test
│   └── ordermanagementsystem
│       └── JunitTest_Container.java
└── doc
    ├── orders.txt
    ├── output.txt
    ├── test1.txt
    ├── test2.txt
    ├── test3.txt
    └── test4.txt
```

## Classes

### Container

The `Container` class is a generic container that can hold objects. It provides methods for adding and removing objects, as well as querying the size of the container.

### Queue

The `Queue` class simulates a queue data structure (FIFO). It stores orders with a total amount above or equal to 1500.

### Stack

The `Stack` class simulates a stack data structure (FILO). It stores orders with a total amount below 1500.

### IOHandler

The `IOHandler` class provides static methods for handling input and output operations with files. It allows reading content from a file and writing content to a file.

### Order

The `Order` class represents an order in the order processing system. It encapsulates information about the order such as order ID, customer name, product name, quantity, and unit price.

## Testing

Although the project does not include a graphical user interface (GUI) for direct interaction, the functionality has been thoroughly tested using JUnit test cases. The test cases cover all critical functionalities, including reading from files, writing to files, and the behavior of the queue and stack data structures.

JUnit tests are located in the `test` package and can be executed to verify the correctness of the application. The tests ensure that orders are processed and stored correctly based on their total amounts, and the methods for adding, removing, and querying the size of the containers work as expected.

### Example Test Case


@Test
public void test_01_01_() throws FileNotFoundException {
    List<String> expectedContent = Arrays.asList("1001, John Doe, Smartphone, 2, 100",
            "1023, Ethan Lewis, Gaming Chair, 1, 150", "1024, Mia Perez, Fitness Tracker, 2, 60",
            "1028, Sofia Martinez, Backpack, 1, 40", "1029, Jackson Green, Smart Thermostat, 1, 120",
            "1030, Emma Clark, Air Purifier, 1, 90");

    // Test reading the file
    List<String> actualContent = IOHandler.readFile("test1.txt");
    assertEquals(expectedContent, actualContent);
}


## How to Run

1. **Clone the repository**:
   ```sh
   git clone https://github.com/MohammedAshrafulIslam/Order-management-system.git
   ```

2. **Navigate to the project directory**:
   ```sh
   cd Order-management-system
   ```

3. **Compile and run the Java files using your preferred IDE or command line**.

4. **Execute JUnit tests** to verify functionality:
   - If using an IDE, right-click on the `JunitTest_Container` class and select `Run As` > `JUnit Test`.
   - If using the command line, run the tests using a build tool like Maven or Gradle.

## Conclusion

The Order Management System is a well-tested Java application that processes and manages orders using container-like data structures. 
Even though it lacks a GUI for direct interaction, its functionality is verified through comprehensive test cases.

