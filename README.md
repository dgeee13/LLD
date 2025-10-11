# LLD Preparation Repository

This repository contains notes, examples, and resources to prepare for **Low-Level Design (LLD)**.

---

## 📘 OOP Concepts

Understanding **Object-Oriented Programming (OOP)** is the foundation of strong LLD skills. Make sure you’re confident with the four pillars:

### OOP Principles

- **Abstraction** – Hiding complex implementation details and showing only essential features.  
- **Encapsulation** – Bundling data and methods together while restricting direct access to internal data.  
- **Inheritance** – Reusing properties and behaviors of one class in another to avoid duplication.  
- **Polymorphism** – Using a single interface to represent different underlying forms or behaviors.

📄 **Resource:** [OOP Concepts Document](https://docs.google.com/document/d/1uv9EdLaG9TK7iNcMneLeEaChzvmXU9Xu_Uv5iZwswFk/edit?tab=t.0)  
📄 **Resource:** [OOP in Java - YouTube](https://www.youtube.com/watch?v=bSrm9RXwBaI)

---

## 📘 UML Class & Sequence Diagrams

UML (**Unified Modeling Language**) is a visual way to represent how your classes interact and relate in an object-oriented system. It’s crucial in LLD because it shows how well you can design before writing code.


### Base UML Concepts

Before drawing UML diagrams, understand these relationships:

| Concept | Meaning | Example |
|--------|--------|--------|
| **Generalization** | "Is-A" relationship (Inheritance) | `Dog` → `Animal` |
| **Association** | "Has-A" relationship | `Library` → `Book` |
| **Aggregation** | Whole-part (independent) | `Department` → `Professor` (professor can exist without department) |
| **Composition** | Whole-part (dependent) | `House` → `Room` (room cannot exist without house) |
| **Dependency** | One class uses another temporarily | `PaymentService` → `Logger` |
| **Multiplicity** | How many instances relate | `1..*`, `0..1` |

📄 **Resource:** [UML Concepts - YouTube](https://youtu.be/6XrL5jXmTwM?si=q4_60kmcLltyQh5G)

---


## 📘 Design Principles

Design principles are the fundamental rules that help you write **clean, scalable, and maintainable** object-oriented code. They guide how classes should interact and how responsibilities should be divided.

### SOLID Principles

SOLID is a set of 5 principles that make your code easy to **extend, maintain, and test** — all critical in LLD.


### SOLID Principles Summary

| Principle | Full Form | Meaning |
|----------|-----------|---------|
| **S** | Single Responsibility Principle | A class should have only one reason to change — one responsibility. |
| **O** | Open/Closed Principle | Software entities should be open for extension but closed for modification. |
| **L** | Liskov Substitution Principle | Subclasses should be substitutable for their base classes without altering program behavior. |
| **I** | Interface Segregation Principle | Clients should not be forced to depend on interfaces they do not use. |
| **D** | Dependency Inversion Principle | Depend on abstractions, not on concrete implementations. |


### Other Core Design Principles

| Principle | Meaning |
|----------|---------|
| **DRY (Don't Repeat Yourself)** | Avoid duplicating logic — keep code reusable and centralized. |
| **KISS (Keep It Simple, Stupid)** | Prefer simple, readable solutions over clever but complex ones. |
| **YAGNI (You Aren’t Gonna Need It)** | Don’t add functionality until it’s actually needed. |


📄 **Resource:** [SOLID](https://medium.com/@cibofdevs/understanding-solid-principles-in-java-with-real-life-examples-d6fe93b0acc2)  
📄 **Resource:** [DRY](https://blog.algomaster.io/p/082450d8-0e7b-4447-a8dc-b7308e45f048)  
📄 **Resource:** [KISS](https://blog.algomaster.io/p/21b57678-b351-4ed4-b390-3b6308af2f7d)  
📄 **Resource:** [YAGNI](https://blog.algomaster.io/p/8c3c7da7-885b-4a9c-a6e4-70ee02de4772)  

---
### **Design Patterns**

📄 **Resource:** [Patterns with Code Examples](https://github.com/Anchals24/Low-Level-Design)

### Popular Design Patterns in Java

| # | Pattern | Description | Type | Reference |
|---|----------|--------------|--------|------------|
| 1️⃣ | **Singleton** | Ensures only one instance of a class exists and provides a global access point. | Creational | [DigitalOcean - Singleton](https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples) |
| 2️⃣ | **Factory** | Creates objects without exposing the instantiation logic to the client. | Creational | [DigitalOcean - Factory](https://www.digitalocean.com/community/tutorials/factory-design-pattern-in-java) |
| 3️⃣ | **Builder** | Simplifies object creation with complex constructors by using a step-by-step approach. | Creational | [DigitalOcean - Builder](https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java) |
| 4️⃣ | **Decorator** | Adds new functionality to an object dynamically without altering its structure. | Structural | [DigitalOcean - Decorator](https://www.digitalocean.com/community/tutorials/decorator-design-pattern-in-java-example) |
| 5️⃣ | **Observer** | Defines a one-to-many dependency so that when one object changes state, all dependents are notified. | Behavioral | [GeeksforGeeks - Observer](https://www.geeksforgeeks.org/system-design/observer-pattern-set-1-introduction/) |
| 6️⃣ | **Strategy** | Enables selecting an algorithm’s behavior at runtime through interchangeable strategies. | Behavioral | [DigitalOcean - Strategy](https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial) |
| 7️⃣ | **Command** | Encapsulates a request as an object, thereby allowing for parameterization and queuing of requests. | Behavioral | [DigitalOcean - Command](https://www.digitalocean.com/community/tutorials/command-design-pattern) |

---

## 📘 How to Answer a LLD Interview Problem

📄 **Resource:** [Steps](https://blog.algomaster.io/p/how-to-answer-a-lld-interview-problem)  

---


This repository will grow with examples, exercises, and implementations of real-world LLD problems.
