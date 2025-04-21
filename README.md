# Hotel Management System – Specification Document  
**Authors**: ESSETTI Yasmine, MASMOUDI Nour  
**Date**: 2024/2025  

---

## 1. Introduction  

### 1.1 Project Overview  
The Hotel Management System (HMS) is a Java-based application designed to streamline hotel operations, including:  
- **Two user roles**:  
  - Administrators (manage rooms/users/bookings)  
  - Guests (book rooms, view reservations)  
- **Design phase**: Preliminary UML diagrams (class/sequence) for Sprint 1.
  
### 1.2 Motivations  
- Address inefficiencies in manual hotel management  
- Provide a scalable solution for small to mid-sized hotels  
- Academic exercise in object-oriented design  

---

## 2. System Design  

### 2.1 Static Aspects (Class Diagram)  
**Key classes**:  
```
User (Abstract)
├── Guest
└── Administrator
```

```
Room
- roomNumber: int
- price: double
- isAvailable: boolean
```

```
Booking
- bookingId: int
- startDate: LocalDate
- endDate: LocalDate
- status: PaymentStatus (enum)
```

---
Associations:
```
Booking → User (1:1)
Booking → Room (1:1)
Hotel → Room (1:*)
Diagram: See classDiagram.svg (PlantUML source in Diagrammes/).
```
---
### 2.2 Dynamic Aspects (Sequence Diagrams)

Selected use cases for Sprint 1:

<p>Room Booking (DSUC1)<br>
**Precondition:** User logged in, room available.<br>
**Diagram:** /Diagrammes/DSUC1_BookRoom.pu.<br>
User Management (DSUC2)<br>
**Covers:** Add/Edit/Delete users (Admin only).<br>
**Diagram:** /Diagrammes/DSUC2_UserManagement.pu<br></p>

---
## 3. Specification  

### 3.1 Key Concepts & Constraints  

#### Actors:  
- **Admin**: Manages rooms, bookings, and user accounts  
- **Guest**: Books rooms, cancels reservations, updates profile  

#### Communication Model (Client-Server):  
1. **Client**: User interacts via GUI (booking/login requests)  
2. **Server**: Processes requests via Business Logic Layer  
3. **Response**: Displays results in UI  

#### Constraints:  
- ❌ Simplified payment simulation (no real gateway)  
- ❌ No advanced reporting features  

#### Excluded Features:  
- 🚫 Mobile application  
- 🚫 Multi-language support  
- 🚫 Cloud integration  

---

### 3.2 Functionalities  

#### User Perspective:  
| Functionality    | Description                          | Precondition                     |  
|------------------|--------------------------------------|----------------------------------|  
| Register         | Create account (email/name/password) | -                                |  
| Book Room        | Select room & dates                  | User logged in, room available   |  
| Cancel Booking   | Cancel via booking ID                | User logged in, valid booking ID |  
| Browse Rooms     | View available rooms                 | User logged in                   |  

#### Non-Functional Features:  
1. **Usability**: Intuitive interface for bookings  
2. **Performance**: Fast response to queries  
3. **Scalability**: Handles growing guest/reservation data  

---

## 4. Use Case Priorities  

| Use Case       | Priority | Reason                          |  
|----------------|----------|---------------------------------|  
| Book Room      | High     | Core revenue functionality      |  
| Register       | High     | Essential for transactions      |  
| Cancel Booking | Medium   | Secondary to booking            |  


---

## Table of Contents

- Project Features
- Use Case 1: Book a Room
- Use Case 2: Manage Customers
- UML Diagrams
- Validation Tables
- Directory Structure

---

## Project Features

- User authentication and role management
- Room reservation and availability tracking
- Customer registration and information management
- Staff scheduling and task assignments
- Reporting and analytics for managers
- Invoice generation and payment tracking

---

## Use Case 1: Book a Room

**Goal:** Allow a customer or receptionist to reserve an available room.

**Actors:** Customer, Receptionist

**Preconditions:**
- User must be authenticated (Receptionist or Customer).
- The room must be available for the selected dates.

**Postconditions:**
- A booking is created and stored in the system.
- Room availability is updated accordingly.

**Normal Flow:**
1. User selects room type and dates.
2. System displays available rooms.
3. User selects a room and enters booking details.
4. System validates data and confirms reservation.
5. Confirmation and booking reference are shown.

**Alternative Flows:**
- If no room is available, the system shows a message and suggests alternatives.
- If payment fails, the reservation is not confirmed.

---

## Use Case 2: Manage Customers

**Goal:** Enable hotel staff to create, edit, or delete customer profiles.

**Actors:** Receptionist, Manager

**Preconditions:**
- User must be authenticated with staff privileges.

**Postconditions:**
- Customer data is stored or updated in the database.

**Normal Flow:**
1. Staff accesses the customer management module.
2. User chooses to create, edit, or delete a customer.
3. System performs the action and confirms success.

**Alternative Flows:**
- If validation fails (e.g., missing name), the system prompts for corrections.

---

## UML Diagrams

The following diagrams are available in the `Diagrammes` folder:

- `use_case_diagram.pu` / `use_case_diagram.svg` – General use case diagram
- `book_room_sequence.pu` / `book_room_sequence.svg` – Sequence diagram for booking
- `manage_customer_activity.pu` / `manage_customer_activity.svg` – Activity diagram for managing customers
- `ClassDiagram.pu` / `classDiagram.svg` - Version one (simplified) class diagram
- `DSUC1_BookRoom.pu` / `bookRoom.svg` - Sequence diagram for booking a room
- `DSUC2_UserManagement.pu` / `manageUsers.svg` - Sequence diagram for managing users
- `Room State Machine Diagram.pu` / `Room State Machine Diagram.svg` - Machine state diagram for rooms
- `User State Machine Diagram.pu` / `User State Machine Diagram.svg` - Machine state diagram for users
- `Booking State Machine Diagram.pu` / `Booking State Machine Diagram.svg` - Machine state diagram for booking a room
- `ClassDiagram-v2.pu` / `ClassDiagram-v2.svg` - Version 2 (more detailed) class diagram

---

## Validation Tables

### ✅ Book a Room – Decision Table

| Condition                        | Valid Dates | Room Available | Payment Successful | Booking Confirmed |
|----------------------------------|-------------|----------------|--------------------|-------------------|
| Reservation attempt 1           | Yes         | Yes            | Yes                | ✅ Yes             |
| Reservation attempt 2           | Yes         | No             | -                  | ❌ No              |
| Reservation attempt 3           | No          | -              | -                  | ❌ No              |
| Reservation attempt 4           | Yes         | Yes            | No                 | ❌ No              |

---

### ✅ Manage Customers – Decision Table

| Action    | Valid Data | System Response      |
|-----------|------------|----------------------|
| Create    | Yes        | Customer Added ✅     |
| Create    | No         | Error Message ❌      |
| Edit      | Yes        | Changes Saved ✅      |
| Delete    | Confirmed  | Customer Deleted ✅   |
| Delete    | Cancelled  | No Action Taken ❌     |

---

## Directory Structure
```
Coo-HMS/
├── README.md 
├── Spec/ 
│   ├── HMS_conceptionPreliminaire.pdf
│   └── HMS_Spec.pdf                 # Full specification document
└── Diagrammes/
│   ├── use_case_diagram.pu 
│   ├── book_room_sequence.pu 
│   ├── manage_customer_activity.pu 
│   ├── use_case_diagram.svg  
│   ├── book_room_sequence.svg     
│   ├── manage_customer_activity.svg     
│   ├── ClassDiagram.pu     
│   ├── classDiagram.svg    
│   ├── DSUC1_BookRoom.pu   
│   ├── bookRoom.svg       
│   ├── DSUC2_UserManagement.pu      
│   ├── manageUsers.svg      
│   ├── Room State Machine Diagram.pu    
│   ├── Room State Machine Diagram.svg    
│   ├── User State Machine Diagram.pu     
│   ├── User State Machine Diagram.svg     
│   ├── Booking State Machine Diagram.pu      
│   ├── Booking State Machine Diagram.svg      
│   ├── ClassDiagram-v2.pu   
│   └── ClassDiagram-v2.svg      
└── src/
    └── code/
        ├── booking.java              
        ├── gestionnaire.java             
        ├── hotel.java
        ├── room.java
        └── user.java 
```
