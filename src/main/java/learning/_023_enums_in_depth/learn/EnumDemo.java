package learning._023_enums_in_depth.learn;

import java.util.*;

/**
 * EnumDemo.java
 * A guided tour of Java enums. Run it and read the output alongside the code.
 *
 * Compile: javac EnumDemo.java
 * Run:     java EnumDemo
 * Requires Java 17+
 */
public class EnumDemo {

    // ------------------------------------------------------------------
    // 1. BASIC ENUM
    // ------------------------------------------------------------------
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // ------------------------------------------------------------------
    // 2. ENUM WITH FIELDS, CONSTRUCTOR AND METHODS
    // ------------------------------------------------------------------
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        EARTH(5.976e+24, 6.37814e6),
        JUPITER(1.9e+27, 7.1492e7);

        private final double mass;    // kg
        private final double radius;  // meters

        Planet(double mass, double radius) {   // implicitly private
            this.mass = mass;
            this.radius = radius;
        }

        double surfaceGravity() {
            final double G = 6.67300E-11;
            return G * mass / (radius * radius);
        }
    }

    // ------------------------------------------------------------------
    // 3. CONSTANT-SPECIFIC BEHAVIOR (abstract method)
    // ------------------------------------------------------------------
    enum Operation {
        ADD("+") {
            @Override double apply(double a, double b) { return a + b; }
        },
        SUBTRACT("-") {
            @Override double apply(double a, double b) { return a - b; }
        },
        MULTIPLY("*") {
            @Override double apply(double a, double b) { return a * b; }
        },
        DIVIDE("/") {
            @Override double apply(double a, double b) {
                if (b == 0) throw new ArithmeticException("Divide by zero");
                return a / b;
            }
        };

        private final String symbol;

        Operation(String symbol) { this.symbol = symbol; }

        abstract double apply(double a, double b);

        String getSymbol() { return symbol; }
    }

    // ------------------------------------------------------------------
    // 4. ENUM IMPLEMENTING AN INTERFACE
    // ------------------------------------------------------------------
    interface Payable {
        double calculatePay(double hours);
    }

    enum EmployeeType implements Payable {
        INTERN {
            @Override public double calculatePay(double hours) { return hours * 10; }
        },
        FULL_TIME {
            @Override public double calculatePay(double hours) { return hours * 40; }
        },
        CONTRACTOR {
            @Override public double calculatePay(double hours) { return hours * 65; }
        }
    }

    // ------------------------------------------------------------------
    // 5. SAFE LOOKUP BY CODE
    // ------------------------------------------------------------------
    enum HttpStatus {
        OK(200, "OK"),
        NOT_FOUND(404, "Not Found"),
        SERVER_ERROR(500, "Internal Server Error");

        private final int code;
        private final String message;

        HttpStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        int getCode() { return code; }
        String getMessage() { return message; }

        private static final Map<Integer, HttpStatus> BY_CODE = new HashMap<>();
        static {
            for (HttpStatus s : values()) {
                BY_CODE.put(s.code, s);
            }
        }

        static Optional<HttpStatus> fromCode(int code) {
            return Optional.ofNullable(BY_CODE.get(code));
        }
    }

    // ------------------------------------------------------------------
    // 6. STATE MACHINE
    // ------------------------------------------------------------------
    enum TrafficLight {
        RED(30), GREEN(25), YELLOW(5);

        private final int seconds;

        TrafficLight(int seconds) { this.seconds = seconds; }

        int getSeconds() { return seconds; }

        // No default needed: compiler verifies all constants are covered
        TrafficLight next() {
            return switch (this) {
                case RED    -> GREEN;
                case GREEN  -> YELLOW;
                case YELLOW -> RED;
            };
        }
    }

    // ------------------------------------------------------------------
    // 7. ORDER LIFECYCLE WITH ALLOWED TRANSITIONS
    // ------------------------------------------------------------------
    enum OrderStatus {
        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED;

        boolean canMoveTo(OrderStatus target) {
            return switch (this) {
                case PENDING    -> target == PROCESSING || target == CANCELLED;
                case PROCESSING -> target == SHIPPED || target == CANCELLED;
                case SHIPPED    -> target == DELIVERED;
                case DELIVERED, CANCELLED -> false;   // terminal states
            };
        }
    }

    // ------------------------------------------------------------------
    // 8. SINGLETON USING ENUM
    // ------------------------------------------------------------------
    enum AppConfig {
        INSTANCE;

        private final String appName = "EnumDemoApp";
        private int visits = 0;

        String getAppName() { return appName; }
        int recordVisit() { return ++visits; }
    }

    // ------------------------------------------------------------------
    // 9. DISPLAY LABELS (separate UI text from constant name)
    // ------------------------------------------------------------------
    enum Role {
        ADMIN("Administrator"),
        EDITOR("Content Editor"),
        VIEWER("Read-only Viewer");

        private final String label;

        Role(String label) { this.label = label; }

        String getLabel() { return label; }

        @Override
        public String toString() { return label; }
    }

    // ==================================================================
    // MAIN
    // ==================================================================
    public static void main(String[] args) {
        demoBasics();
        demoBuiltInMethods();
        demoFields();
        demoAbstractMethods();
        demoInterface();
        demoSwitch();
        demoEnumSetAndMap();
        demoSafeLookup();
        demoStateMachine();
        demoOrderLifecycle();
        demoSingleton();
        demoDisplayLabels();
        demoPitfalls();
    }

    static void header(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    static void demoBasics() {
        header("1. Basics");
        Day today = Day.FRIDAY;
        System.out.println("Today is " + today);
        System.out.println("today == Day.FRIDAY ? " + (today == Day.FRIDAY));
        // Day bad = Day.FRIDYA;   // compile error: typo caught
        // Day bad = 5;            // compile error: not a Day
    }

    static void demoBuiltInMethods() {
        header("2. Built-in methods");
        for (Day d : Day.values()) {
            System.out.println(d.ordinal() + " -> " + d.name());
        }
        Day parsed = Day.valueOf("MONDAY");
        System.out.println("valueOf(\"MONDAY\") = " + parsed);

        try {
            Day.valueOf("Funday");
        } catch (IllegalArgumentException e) {
            System.out.println("valueOf(\"Funday\") threw: " + e.getMessage());
        }

        System.out.println("MONDAY.compareTo(FRIDAY) = " + Day.MONDAY.compareTo(Day.FRIDAY));
    }

    static void demoFields() {
        header("3. Enum with fields and methods");
        for (Planet p : Planet.values()) {
            System.out.printf("%-8s gravity = %.2f m/s^2%n", p, p.surfaceGravity());
        }
    }

    static void demoAbstractMethods() {
        header("4. Constant-specific behavior");
        double a = 12, b = 4;
        for (Operation op : Operation.values()) {
            System.out.printf("%.0f %s %.0f = %.2f%n", a, op.getSymbol(), b, op.apply(a, b));
        }
    }

    static void demoInterface() {
        header("5. Enum implementing an interface");
        for (EmployeeType t : EmployeeType.values()) {
            System.out.printf("%-10s earns %.2f for 40 hours%n", t, t.calculatePay(40));
        }
    }

    static void demoSwitch() {
        header("6. Enums in switch");
        for (Day d : Day.values()) {
            String type = switch (d) {
                case SATURDAY, SUNDAY -> "Weekend";
                default               -> "Weekday";
            };
            System.out.println(d + " is a " + type);
        }
    }

    static void demoEnumSetAndMap() {
        header("7. EnumSet and EnumMap");
        EnumSet<Day> weekend  = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        EnumSet<Day> weekdays = EnumSet.complementOf(weekend);
        EnumSet<Day> firstHalf = EnumSet.range(Day.MONDAY, Day.WEDNESDAY);

        System.out.println("Weekend:    " + weekend);
        System.out.println("Weekdays:   " + weekdays);
        System.out.println("Mon-Wed:    " + firstHalf);

        EnumMap<Day, String> plans = new EnumMap<>(Day.class);
        plans.put(Day.WEDNESDAY, "Team meeting");
        plans.put(Day.MONDAY, "Gym");
        plans.put(Day.SATURDAY, "Hiking");
        // Iterates in enum declaration order, not insertion order
        plans.forEach((day, plan) -> System.out.println(day + ": " + plan));
    }

    static void demoSafeLookup() {
        header("8. Safe lookup by code");
        int[] codes = {200, 404, 418};
        for (int code : codes) {
            String result = HttpStatus.fromCode(code)
                    .map(s -> s.getCode() + " " + s.getMessage())
                    .orElse(code + " Unknown status");
            System.out.println(result);
        }
    }

    static void demoStateMachine() {
        header("9. Traffic light state machine");
        TrafficLight light = TrafficLight.RED;
        for (int i = 0; i < 6; i++) {
            System.out.println(light + " for " + light.getSeconds() + "s");
            light = light.next();
        }
    }

    static void demoOrderLifecycle() {
        header("10. Order lifecycle transitions");
        OrderStatus[][] tests = {
                {OrderStatus.PENDING, OrderStatus.PROCESSING},
                {OrderStatus.PENDING, OrderStatus.DELIVERED},
                {OrderStatus.SHIPPED, OrderStatus.DELIVERED},
                {OrderStatus.DELIVERED, OrderStatus.PENDING},
        };
        for (OrderStatus[] t : tests) {
            System.out.printf("%s -> %s : %s%n", t[0], t[1], t[0].canMoveTo(t[1]) ? "allowed" : "NOT allowed");
        }
    }

    static void demoSingleton() {
        header("11. Enum singleton");
        AppConfig a = AppConfig.INSTANCE;
        AppConfig b = AppConfig.INSTANCE;
        a.recordVisit();
        b.recordVisit();
        System.out.println("Same instance? " + (a == b));
        System.out.println(a.getAppName() + " visits = " + a.recordVisit());
    }

    static void demoDisplayLabels() {
        header("12. Display labels");
        for (Role r : Role.values()) {
            System.out.println(r.name() + " displays as \"" + r + "\"");
        }
    }

    static void demoPitfalls() {
        header("13. Pitfalls to remember");

        // Pitfall 1: ordinal changes if constants are reordered.
        System.out.println("TUESDAY ordinal = " + Day.TUESDAY.ordinal()
                + " (never store this in a database)");

        // Pitfall 2: valueOf is case-sensitive and throws on unknown input.
        String userInput = "monday";
        try {
            Day.valueOf(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("valueOf(\"monday\") fails: use toUpperCase() or a safe parser");
        }
        System.out.println("valueOf(userInput.toUpperCase()) = " + Day.valueOf(userInput.toUpperCase()));

        // Pitfall 3: enums are fixed at compile time. You cannot add constants at runtime.
        System.out.println("Number of Day constants is always " + Day.values().length);
    }
}
