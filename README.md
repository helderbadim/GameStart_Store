# GameStart 🎮

**GameStart** is a console-based Java application designed to simulate a system for managing a game retail store. It includes functionalities for administrators and customers, offering a menu-driven interface to explore, manage, and query store-related information.

## 🚀 Features

### General
- **Welcome Screen**: Displays a styled welcome message with ASCII art.
- **User Menus**: Menu-based navigation for both administrators and customers.
- **File Integration**: Reads and writes data to CSV and text files.

### Administrator Features
1. View the complete list of game stock.
2. Check the total number of sales and the total revenue.
3. Calculate the store's profit from sales.
4. Search for a customer's details by their ID.
5. Identify the most expensive game sold and the customers who purchased it.
6. Find the customer who spent the most at the store.

### Customer Features
1. Register a new customer.
2. View available parking spaces (triangular numbers, multiples of 5, below 121).
3. Display all available game titles.
4. Display all games from a specific publisher, grouped by category.

### Exit Program
- Displays a styled goodbye message with ASCII art upon exiting.

## 🛠️ Technologies Used

- **Java**: Main programming language.
- **File I/O**: Reading and writing CSV and text files for data storage.
- **Console Styling**: ANSI escape codes for enhanced text formatting in the console.

## 📂 Project Structure
```plaintext
📂 GameStart
├── 📂 src
│   ├── 📜 Project_GameStart.java   # Main Java file containing all functionalities
│   └── 📂 Files
│       ├── 📜 GameStart_V2.csv     # CSV file with game sales and customer data
│       ├── 📜 Logo.txt             # ASCII art for the welcome message
│       ├── 📜 Adeus.txt            # ASCII art for the goodbye message
│       ├── 📜 registoClientes.txt  # Text file for storing new customer registrations
├── 📜 README.md                    # Project documentation
└── 📜 LICENSE                      # License for the project (if included)
```



## 🎯 Purpose

This project was created as part of a learning journey in Java programming. It demonstrates:
- File handling in Java (reading and writing to files).
- Menu-driven interfaces using `do-while` and `switch` statements.
- The use of formatted output for better console aesthetics.
- Managing user roles (administrator and customer).

## 📋 How to Run

1. Clone the repository or download the project files.
2. Ensure the file structure is maintained, especially the `Files/` folder containing the required `.csv` and `.txt` files.
3. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).
4. Run the `Project_GameStart` class.

## 🛠️ Functional Overview

### Administrator Menu
- Requires a password (`bacalhau`) to access.
- Provides access to multiple queries and reports about sales, customers, and inventory.

### Customer Menu
- Allows registration of new customers.
- Displays parking availability and game details.

### Data Integration
- Reads data from `GameStart_V2.csv` to display stock, sales, and customer information.
- Writes new customer registrations to `registoClientes.txt`.

## 👤 Author

Hélder Badim  
- GitHub: [@helderbadim](https://github.com/helderbadim)  
- LinkedIn: [Hélder Badim](https://linkedin.com/in/helderbadim)

## 📬 Contact

Feel free to reach out if you have any questions, feedback, or collaboration opportunities!
