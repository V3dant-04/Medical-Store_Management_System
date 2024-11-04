# Medical Store Management System

Welcome to the **Medical Store Management System** project, a Java-based application designed to streamline and manage pharmacy operations. This system leverages various data structures for efficient data handling, including inventory management, order processing, supplier tracking, and reporting.

## Table of Contents
- [Features](#features)
- [Data Structures Used](#data-structures-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Medicine Inventory Management**: Add, view, edit, and delete medicines in the inventory.
- **Billing and Sales Management**: Process customer orders and generate bills.
- **Supplier Management**: Manage a list of suppliers and view the most recent supplier data.
- **Reports**: Generate reports on low-stock medicines and expired items.

## Data Structures Used
This project demonstrates the use of essential data structures:
- **HashMap**: Used for inventory management, allowing quick retrieval of medicine data by ID.
- **LinkedList**: Manages a dynamic list of medicines for easy addition and deletion.
- **Queue**: Handles customer orders in a first-in, first-out manner for fair processing.
- **Stack**: Maintains supplier information, prioritizing the most recent addition.

## Project Structure
```plaintext
medical-store-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── medicalmanagement/
│   │   │       ├── Main.java               # Main application entry point
│   │   │       ├── InventoryManager.java    # Manages inventory with HashMap
│   │   │       ├── BillingManager.java      # Handles customer billing and orders
│   │   │       ├── SupplierManager.java     # Manages suppliers using Stack
│   │   │       ├── ReportManager.java       # Generates reports on inventory
│   │   │       └── Medicine.java            # Medicine entity
│       
└── README.md
└── .gitignore
```
## Setup Instructions
1. Clone this repository:
    ```bash
    git clone https://github.com/V3dant-04/medical-store-management.git
    ```
2. Navigate into the project directory:
    ```bash
    cd medical-store-management
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    java -jar target/medical-store-management-1.0.jar
    ```

## Usage
- **Add Medicine**: Launch the application and use the 'Add Medicine' button to input new medicine details.
- **Generate Bill**: Use the 'Generate Bill' button to process orders by entering medicine ID and quantity.
- **Generate Report**: Check for low-stock and expired items using the 'Generate Report' button.
- **Manage Suppliers**: Track and manage suppliers within the application.

## Contributing
Feel free to fork this repository and submit pull requests. Any contributions are welcome, from adding new features to improving code structure.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

---

Thank you for checking out the Medical Store Management System!
