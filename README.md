# LLD

This repository contains notes, examples, and resources for learning about **Low-Level Design (LLD)**.

---

## 📘 OOPs Concepts

Understanding **Object-Oriented Programming (OOP)** is the foundation of strong LLD skills. Make sure you’re confident with the four pillars:

- **Abstraction** – Hiding complex implementation details and showing only essential features.  
- **Encapsulation** – Bundling data and methods together while restricting direct access to internal data.  
- **Inheritance** – Reusing properties and behaviors of one class in another to avoid duplication.  
- **Polymorphism** – Using a single interface to represent different underlying forms or behaviors.

📄 **Detailed Notes:** [OOPs Concepts Document](https://docs.google.com/document/d/1uv9EdLaG9TK7iNcMneLeEaChzvmXU9Xu_Uv5iZwswFk/edit?tab=t.0)  
🎥 **Video Explanation:** [OOPs in Java - YouTube](https://www.youtube.com/watch?v=bSrm9RXwBaI)

---

## 📘 Design Principles

Design principles are the fundamental rules that help you write **clean, scalable, and maintainable** object-oriented code. They guide how classes should interact and how responsibilities should be divided.

- **SOLID** – Single Responsibility, Open to Extension & Closed to Modification, Liskov Substitution, Interface Segregation, Dependency Inversion  
- **DRY** – Don’t Repeat Yourself  
- **KISS** – Keep It Simple, Stupid  
- **YAGNI** – You Aren’t Gonna Need It  
- **GRASP** – General Responsibility Assignment Software Patterns  

🔗 Recommended reads:  
- [DRY](https://blog.algomaster.io/p/082450d8-0e7b-4447-a8dc-b7308e45f048)  
- [KISS](https://blog.algomaster.io/p/21b57678-b351-4ed4-b390-3b6308af2f7d)  
- [YAGNI](https://blog.algomaster.io/p/8c3c7da7-885b-4a9c-a6e4-70ee02de4772)  

---

## 📘 UML Class & Sequence Diagrams

UML (**Unified Modeling Language**) is a visual way to represent how your classes interact and relate in an object-oriented system. It’s crucial in LLD interviews because it shows how well you can design before writing code.

---

### 🔑 Base UML Concepts

Before drawing UML diagrams, understand these relationships:

| Concept | Meaning | Example |
|--------|--------|--------|
| **Generalization** | "Is-A" relationship (Inheritance) | `Dog` → `Animal` |
| **Association** | "Has-A" relationship | `Library` → `Book` |
| **Aggregation** | Whole-part (independent) | `Department` → `Professor` (professor can exist without department) |
| **Composition** | Whole-part (dependent) | `House` → `Room` (room cannot exist without house) |
| **Dependency** | One class uses another temporarily | `PaymentService` → `Logger` |
| **Multiplicity** | How many instances relate | `1..*`, `0..1` |


🎥 **Video Explanation:** [UML Class Diagrams](https://www.youtube.com/watch?v=bSrm9RXwBaI)

---

This repository will grow with examples, exercises, and implementations of real-world LLD problems.
