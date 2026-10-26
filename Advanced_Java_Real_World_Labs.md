# Advanced Java Practical Labs: Real-World Programming

**Topics:** Enums, Interfaces, Records, Annotations, Classes, and the Four Pillars of OOP  
**Level:** Intermediate to Advanced  
**Language:** Java 17+  
**Suggested workflow:** Complete the labs in order. Write the code yourself, compile and run it, test edge cases, and commit each finished lab to Git.

---

## Learning outcomes

By the end of these labs, you should be able to:

- Model real-world business rules with classes and objects.
- Use encapsulation, inheritance, polymorphism, and abstraction appropriately.
- Represent fixed sets of choices with `enum`.
- Define contracts with interfaces and provide multiple implementations.
- Use records for compact, immutable data carriers.
- Create and inspect custom annotations with reflection.
- Validate input, handle errors, and write maintainable Java code.
- Combine the concepts into a small application with realistic workflows.

## General rules

1. Use meaningful names and keep each public class in its own `.java` file.
2. Use private fields and validate data at object boundaries.
3. Do not use `null` to represent an ordinary business state when an enum or `Optional` is clearer.
4. Prefer composition over inheritance unless there is a genuine “is-a” relationship.
5. Use `BigDecimal` for money rather than `double`.
6. Add tests for normal, boundary, and invalid cases.
7. Do not use external libraries unless a lab explicitly asks you to extend the project.

## Suggested project structure

```text
java-advanced-labs/
└── src/
    ├── main/java/za/co/learning/
    │   ├── enums/
    │   ├── interfaces/
    │   ├── records/
    │   ├── annotations/
    │   ├── model/
    │   ├── service/
    │   └── Main.java
    └── test/java/za/co/learning/
```

You can also create a separate folder for each lab if you are still learning how packages work.

---

# Lab 1 — Enum-powered Food Delivery Order

## Real-life scenario

A local restaurant receives orders through a delivery app. Each order has a payment status, order status, and delivery option. The app must prevent invalid transitions—for example, a delivered order should not return to “preparing.”

## Requirements

Create these enums:

- `OrderStatus`: `PLACED`, `CONFIRMED`, `PREPARING`, `READY_FOR_COLLECTION`, `OUT_FOR_DELIVERY`, `DELIVERED`, `CANCELLED`
- `PaymentStatus`: `PENDING`, `PAID`, `FAILED`, `REFUNDED`
- `DeliveryMethod`: `COLLECTION`, `STANDARD_DELIVERY`, `EXPRESS_DELIVERY`

Create an `Order` class containing an order number, customer name, total amount, status, payment status, and delivery method.

Implement methods to:

- Confirm an order only if payment has succeeded.
- Move an order through valid statuses.
- Cancel an order only before it is out for delivery.
- Calculate a delivery fee: collection is free, standard delivery costs R35, and express delivery costs R65.
- Display a readable order summary.

## Starter code

```java
public enum OrderStatus {
    PLACED,
    CONFIRMED,
    PREPARING,
    READY_FOR_COLLECTION,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED
}
```

```java
public enum DeliveryMethod {
    COLLECTION,
    STANDARD_DELIVERY,
    EXPRESS_DELIVERY
}
```

## Tasks

1. Implement the `Order` class with private fields.
2. Use a `switch` expression to calculate the delivery fee.
3. Reject a negative order total.
4. Ensure a delivered or cancelled order cannot be changed.
5. Create at least three orders and demonstrate different outcomes.

## Example usage

```java
Order order = new Order(
    "ORD-1001",
    "Lerato",
    new BigDecimal("249.99"),
    DeliveryMethod.STANDARD_DELIVERY
);
```

## Expected behaviour

- A pending payment must not allow the order to be confirmed.
- A paid order can be confirmed.
- An order cannot be cancelled after dispatch.
- The summary should show the order total, delivery fee, and grand total.

## Challenge

Add a `nextStatus()` method that permits only explicitly allowed transitions. Do not rely on enum declaration order to decide what comes next.

---

# Lab 2 — Interface-based Payment System

## Real-life scenario

An online store accepts card payments, instant EFT, and store vouchers. The checkout process should not need to know the internal details of each payment method.

## Requirements

Create a `PaymentMethod` interface with:

```java
public interface PaymentMethod {
    PaymentResult pay(BigDecimal amount);
    String getDisplayName();
}
```

Create a `PaymentResult` record with fields such as `boolean successful`, `String reference`, and `String message`.

Implement three payment methods:

- `CardPayment`
- `InstantEftPayment`
- `VoucherPayment`

Each implementation must apply its own rules. For example, a voucher payment should reject an amount greater than the voucher balance. The card and EFT implementations can simulate success or failure; do not connect to real payment services.

Create a `CheckoutService` that accepts any `PaymentMethod`.

## Tasks

1. Define the interface and result record.
2. Implement the three payment classes.
3. Use constructor injection to provide a payment method to the checkout service, or pass it into a checkout method.
4. Reject zero or negative payment amounts.
5. Print the payment method, result, and reference.
6. Demonstrate that `CheckoutService` works without being rewritten for every payment type.

## Example design

```java
public class CheckoutService {
    public PaymentResult checkout(
            PaymentMethod paymentMethod,
            BigDecimal amount) {
        // Validate amount, then delegate to the payment method.
        // Return the payment result.
        throw new UnsupportedOperationException("Implement this");
    }
}
```

## Questions

- Why is `PaymentMethod` an interface?
- What would happen if a new `MobileWalletPayment` class were added?
- Which class should be responsible for checking that the amount is positive?
- Why should the checkout service depend on the interface instead of `CardPayment`?

## Challenge

Add a `PaymentMethodFactory` that selects a payment implementation from a `PaymentType` enum. Keep the factory small and testable.

---

# Lab 3 — Records for Booking and Reporting

## Real-life scenario

A community sports centre lets people book courts. A booking request contains information submitted by a customer, while a booking entity has identity and behaviour over time.

This lab helps you decide when a Java record is suitable and when a normal class is better.

## Requirements

Create these records:

```java
public record CustomerDetails(
    String fullName,
    String email,
    String phoneNumber
) {}
```

```java
public record CourtBookingRequest(
    String customerId,
    int courtNumber,
    LocalDate bookingDate,
    LocalTime startTime,
    int durationMinutes
) {}
```

Create a normal `Booking` class with a booking ID, a `CourtBookingRequest`, and a `BookingStatus` enum. The booking can be confirmed or cancelled, so its state changes over time.

## Tasks

1. Add compact constructors to the records to validate their fields.
2. Reject blank names and invalid email strings using a simple validation rule.
3. Reject court numbers below 1 and booking durations that are not positive.
4. Create a `BookingStatus` enum: `REQUESTED`, `CONFIRMED`, `CANCELLED`.
5. Add behaviour to the `Booking` class for confirming and cancelling.
6. Create a report record such as `BookingSummary` that contains only the data needed for a daily report.
7. Explain why the request and summary are records but the changing booking is a class.

## Record validation example

```java
public record MoneyAmount(BigDecimal value) {
    public MoneyAmount {
        if (value == null || value.signum() < 0) {
            throw new IllegalArgumentException(
                "Amount must be zero or greater"
            );
        }
    }
}
```

## Questions

- Are records automatically deeply immutable?
- Can a record extend an ordinary class?
- Why are records useful for data transfer objects?
- Why might a record be a poor fit for a booking whose status changes?

## Challenge

Create a `BookingSummary` record and sort a list of summaries by booking date and then start time.

---

# Lab 4 — Custom Annotations for Business Rules

## Real-life scenario

A small company wants to identify service methods that require an audit log. Rather than relying on comments, developers will mark those methods with a custom annotation. A simple reflection-based tool will scan a class and report the marked methods.

**Important:** This is a learning simulation, not a security or compliance system. A production audit system needs robust logging, access control, and reliable persistence.

## Requirements

Create an annotation named `@Audited` that:

- Can be placed on methods.
- Is available at runtime.
- Has an optional `reason` value.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Audited {
    String reason() default "Business operation";
}
```

Create a `CustomerAccountService` with methods such as:

- `updateContactDetails()`
- `closeAccount()`
- `viewAccount()`

Mark the first two methods with `@Audited`.

Create an `AnnotationScanner` that uses Java reflection to list the methods marked with `@Audited` and print their reason.

## Tasks

1. Import the required annotation and reflection classes.
2. Annotate the relevant methods.
3. Use `Class.getDeclaredMethods()` to inspect methods.
4. Use `Method.isAnnotationPresent(Audited.class)`.
5. Read the annotation using `Method.getAnnotation(Audited.class)`.
6. Print the method name and reason.
7. Test what happens if the annotation's retention policy is changed to `SOURCE` or `CLASS`.

## Challenge

Create a `@RequiresRole` annotation with a `String value()`. Scan methods and report the required role. Do not claim that merely adding an annotation enforces authorization; you would need code that checks the current user's permissions.

## Questions

- What does `@Retention(RetentionPolicy.RUNTIME)` do?
- Why is `@Target(ElementType.METHOD)` useful?
- What is reflection?
- Why is an annotation alone not the same as validation or security enforcement?

---

# Lab 5 — Encapsulation and Inheritance in a Vehicle Rental Company

## Real-life scenario

A vehicle rental company rents out cars and motorcycles. Every vehicle has a registration number, brand, and daily rental rate, but different vehicle types have different rental rules.

## Requirements

Create an abstract class `Vehicle` with:

- Private registration number, brand, and daily rate.
- A constructor that validates all fields.
- Getters for appropriate fields.
- An abstract method `calculateRentalCost(int days)`.
- A concrete method `displayDetails()`.

Create subclasses:

- `RentalCar`
- `RentalMotorcycle`

Possible business rules:

- Cars have an additional daily insurance charge of R120.
- Motorcycles have an additional daily safety-equipment charge of R45.
- Rentals of seven or more days receive a 10% discount on the base rental amount. Decide and document whether the discount applies to extras.

Use `BigDecimal` for all monetary calculations.

## Tasks

1. Keep fields private.
2. Use `super(...)` to initialize shared vehicle details.
3. Override `calculateRentalCost`.
4. Reject rental periods below one day.
5. Demonstrate runtime polymorphism using a `List<Vehicle>`.
6. Print the cost for a two-day and a seven-day rental.

## Questions

- Why is `Vehicle` abstract?
- Why should fields generally not be `public`?
- What does `@Override` help the compiler check?
- How does polymorphism let the rental service work with different vehicle types?

## Challenge

Add `ElectricCar` with a charging fee. Decide whether it should extend `RentalCar` or whether a composition-based design would be clearer, and explain your decision.

---

# Lab 6 — Abstraction and Polymorphism in Employee Payroll

## Real-life scenario

A small business employs permanent employees, hourly workers, and contractors. Each group has a different way of calculating pay, but payroll needs one consistent operation.

## Requirements

Create an abstract class or interface that represents a payable worker. Implement:

- `PermanentEmployee`
- `HourlyEmployee`
- `Contractor`

Use realistic but fictional sample values. This lab is for programming practice, not tax, UIF, pension, or South African payroll advice.

Possible rules:

- Permanent employees receive a fixed monthly gross salary.
- Hourly workers are paid for approved hours.
- Contractors receive an agreed monthly contract amount.

Create a `PayrollService` that calculates and prints each worker's gross pay through the shared abstraction.

## Tasks

1. Identify common fields and behaviour.
2. Avoid duplicating the payroll loop for each worker type.
3. Validate salary, rate, and hours.
4. Use polymorphism to call the correct calculation at runtime.
5. Add a new worker type without changing the payroll service's loop.

## Challenge

Create a `Payable` interface and make both employees and suppliers implement it. Explain why an interface can be useful when unrelated classes share a capability.

---

# Lab 7 — Interfaces, Enums, and Strategy Pattern in a Delivery App

## Real-life scenario

A grocery delivery service offers bicycle, car, and van delivery. The cost and estimated delivery time differ by method. The customer chooses the service at checkout.

## Requirements

Create:

- `DeliveryType` enum: `BICYCLE`, `CAR`, `VAN`
- `DeliveryStrategy` interface
- `BicycleDelivery`, `CarDelivery`, and `VanDelivery` implementations
- `DeliveryQuote` record with distance, fee, and estimated minutes
- `DeliveryService` that uses a strategy to calculate a quote

Possible example rules:

- Bicycle: R8 per kilometre; estimate 6 minutes per kilometre.
- Car: R12 per kilometre; estimate 4 minutes per kilometre.
- Van: R18 per kilometre; estimate 5 minutes per kilometre.

For this lab, use fictional fixed rates and round fees to two decimal places. Explain that real rates would need to account for minimum fees, traffic, distance calculation, and operational costs.

## Tasks

1. Implement the shared interface.
2. Use `BigDecimal` for fees.
3. Reject negative distances.
4. Select the correct strategy using a factory or a `Map<DeliveryType, DeliveryStrategy>`.
5. Return a `DeliveryQuote` record.
6. Demonstrate all delivery options for a 7.5 km delivery.

## Challenge

Add a `WeekendDelivery` decorator or strategy without adding `if/else` branches throughout the application.

---

# Lab 8 — Composition and the Four Pillars of OOP in a Clinic Booking System

## Real-life scenario

A small clinic manages patients, practitioners, appointments, and notifications. An appointment has a status and can send reminders through email or SMS.

## Requirements

Create:

- `Patient` class
- `Practitioner` class
- `Appointment` class
- `AppointmentStatus` enum: `BOOKED`, `CONFIRMED`, `COMPLETED`, `CANCELLED`
- `NotificationChannel` interface
- `EmailNotification` and `SmsNotification` implementations
- `AppointmentService` class

Use fictional data only. Do not collect or store real medical information.

## Apply the four pillars

### Encapsulation
Keep appointment fields private. Expose controlled methods such as `confirm()` and `cancel()` instead of allowing arbitrary status changes.

### Abstraction
Define a `NotificationChannel` interface that hides the details of sending a notification.

### Inheritance
If you use inheritance, make sure the relationship is genuinely “is-a.” Do not create subclasses just to share a few fields.

### Polymorphism
Allow `AppointmentService` to work with any `NotificationChannel` implementation.

## Tasks

1. Prevent an appointment from being confirmed after cancellation.
2. Prevent completion of a cancelled appointment.
3. Send a confirmation notification when an appointment is confirmed.
4. Keep notification logic out of the `Appointment` entity.
5. Demonstrate the service using both notification implementations.
6. Add unit tests for invalid state transitions.

## Challenge

Add a reminder schedule. Keep time-based scheduling separate from appointment state so each class has one clear responsibility.

---

# Lab 9 — Integrated Capstone: Community Event Booking Platform

## Real-life scenario

A community centre runs workshops, sports events, and career fairs. People register, pay, receive a ticket, and get notifications. Different event types have different capacities and prices.

This capstone combines all the topics from the earlier labs.

## Required design

### Enums
- `EventType`: `WORKSHOP`, `SPORTS`, `CAREER_FAIR`
- `RegistrationStatus`: `PENDING`, `CONFIRMED`, `CANCELLED`
- `PaymentStatus`: `PENDING`, `PAID`, `FAILED`, `REFUNDED`

### Records
- `AttendeeDetails`
- `RegistrationRequest`
- `Ticket`
- `RegistrationSummary`

Each record must validate its data in a compact constructor where appropriate.

### Interfaces
- `PaymentMethod`
- `NotificationChannel`
- `TicketPricingPolicy`

### Classes
- `Event`
- `Registration`
- `RegistrationService`
- `PaymentService`
- `TicketService`

### Annotation
Create `@Audited` and apply it to important operations such as confirming and cancelling a registration. Create a scanner that lists those methods.

## Business rules

1. An event must have a positive capacity and a non-negative ticket price.
2. An event cannot accept more confirmed registrations than its capacity.
3. A registration cannot be confirmed until payment succeeds.
4. A cancelled registration cannot be confirmed again.
5. Each confirmed registration receives a unique ticket ID.
6. A registration can use any implementation of `PaymentMethod`.
7. A registration can notify the attendee through any `NotificationChannel`.
8. A report can return a list of `RegistrationSummary` records.
9. Important operations must carry the `@Audited` annotation.
10. Do not store card numbers or other payment credentials in this educational application.

## Required demonstration

In `Main`, demonstrate the following flow:

1. Create a career fair with a capacity of 100.
2. Create attendee details for at least three fictional attendees.
3. Submit registration requests.
4. Process one successful payment and one failed payment.
5. Confirm only the registration with successful payment.
6. Issue a ticket to the confirmed attendee.
7. Cancel a pending registration and prove that it cannot be confirmed afterward.
8. Print a registration report.
9. Scan the service class for `@Audited` methods.

## Acceptance checklist

- [ ] Code compiles on Java 17 or newer.
- [ ] Enums represent fixed states and options.
- [ ] Interfaces are used for interchangeable behaviours.
- [ ] Records validate incoming data.
- [ ] Classes protect their internal state.
- [ ] All four OOP pillars are demonstrated intentionally.
- [ ] Custom annotations use appropriate `@Target` and `@Retention`.
- [ ] Invalid transitions and invalid inputs are tested.
- [ ] Money is represented using `BigDecimal`.
- [ ] No real payment processing or real personal data is used.
- [ ] README explains how to compile and run the project.

---

# Testing ideas for every lab

For each feature, test at least these cases:

| Case | Example |
|---|---|
| Normal input | A paid order is confirmed |
| Boundary input | A booking starts at the earliest allowed time |
| Invalid input | A rental duration is zero |
| Invalid state transition | A cancelled appointment is completed |
| Alternative implementation | Checkout uses EFT instead of card |
| Data validation | A record receives a blank name |
| Annotation discovery | A marked method is found by reflection |
| Extension | A new strategy works without rewriting its consumer |

## Self-review questions

1. What responsibility belongs in a class, and what belongs in a service?
2. When is a record better than a normal class?
3. What problem does an interface solve that an enum alone does not?
4. Why should business states be controlled instead of allowing arbitrary setters?
5. How does polymorphism reduce repeated conditional logic?
6. What do annotations provide, and what additional code is needed to act on them?
7. Which inheritance relationship in your project is most justified? Which one would you replace with composition?
8. How would you unit-test a service without connecting to a real payment provider?

## Suggested marking rubric (100 marks)

| Category | Marks |
|---|---:|
| Correctness and business rules | 25 |
| Classes and encapsulation | 15 |
| Enums, interfaces, and polymorphism | 15 |
| Records and validation | 10 |
| Annotation and reflection | 10 |
| Error handling and edge cases | 10 |
| Tests and code quality | 10 |
| README and explanation | 5 |
| **Total** | **100** |

## How to run

If using plain Java, compile from the source root. For example, for a simple single-package lab:

```bash
javac -d out src/main/java/za/co/learning/*.java
java -cp out za.co.learning.Main
```

For projects with multiple packages, compile all Java source files together or use Maven/Gradle. If you use Maven, create a standard Maven project and run:

```bash
mvn test
mvn package
```

**Recommended order:** Labs 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9. The capstone is intended to reuse and combine your earlier work rather than start from scratch.
