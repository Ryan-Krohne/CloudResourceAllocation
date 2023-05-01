## CloudResourceAllocation

Project Name: AWS Cloud Resource Allocation

AWS Cloud Resource Allocation is a Java program designed to help users allocate cloud resources on AWS. Users can create an account, view discounts, add resources, remove resources, view their cart, and checkout. The program is designed with modularity in mind, making it easy to maintain and extend.


## Java Concepts Used

Object-Oriented Programming: The project is designed with an object-oriented approach, where each class represents a real-world entity and encapsulates data and behaviors associated with that entity.

Inheritance: The Resource class is a parent class to Cloud, Virtual Servers, and Machine Learning subclasses. The subclasses inherit attributes and behaviors from the parent class.
Polymorphism: The parent class has a toString's which is overridden differently by each subclass. The subclass calls the parent's toString, and then provides additional information not found in the parent class. This allows the subclass's toString to provide all the default information, aswell as anything additional depending on it's specifics.
Encapsulation: Each class encapsulates its data and behaviors, and provides public methods for accessing and modifying that data.
Aggregation: The Customer class aggregates instances of the Resource class to create a collection of Resources that can be managed collectively.
Exception Handling: The program uses try-catch blocks to handle exceptions that may occur during user input or other operations.
Constants: The main class defines constants for the maximum number of Resources a customer can have



## Getting Started

To get started with AWS Cloud Resource Allocation, you will need to have Java installed on your computer. You can download Java from the official website at https://www.java.com/en/download/. Once you have Java installed, you can download the source code for AWS Cloud Resource Allocation from the GitHub repository at https://github.com/your-username/aws-cloud-resource-allocation.


Features

AWS Cloud Resource Allocation has the following features:

Account creation
View discounts
Add resources
Remove resources
View cart
Checkout
Modularity

AWS Cloud Resource Allocation is designed with modularity in mind. The program is divided into several methods, each of which performs a specific task. This makes it easy to maintain and extend the program. For example, if you wanted to add a new feature to the program, you could simply create a new method and call it from the main menu.



Contributions
Contributions to AWS Cloud Resource Allocation are welcome. If you would like to contribute, please fork the repository and create a new branch for your changes. Then, submit a pull request with a detailed description of your changes.

License
AWS Cloud Resource Allocation is licensed under the MIT License. See LICENSE.txt for more information.



