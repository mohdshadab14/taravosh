package learning._023_enums_in_depth.assignment;

import java.util.*;

/**
 * Assignment.java: Enums Practice
 *
 * INSTRUCTIONS
 * ------------
 * 1. Find every "TODO" in this file and complete it.
 * 2. Do NOT change the names of enums, methods, or the main() test harness.
 * 3. Compile and run:  javac Assignment.java  &&  java Assignment
 * 4. When every test prints PASS, you are done. Final score is printed at the end.
 *
 * Requires Java 17+.
 *
 * Tip: Read README.md and EnumDemo.java if you get stuck.
 */
public class Assignment {

    // =====================================================================
    // PART 1: Basic enum with a method (10 points)
    // ---------------------------------------------------------------------
    // Declare the days of the week from MONDAY to SUNDAY (in that order).
    // Then implement isWeekend(): true for SATURDAY and SUNDAY only.
    // =====================================================================
    enum Day {
        // TODO: declare the 7 constants here, ending with a semicolon
        PLACEHOLDER;   // TODO: delete this line after adding the real constants

        boolean isWeekend() {
            // TODO: return true for SATURDAY and SUNDAY, false otherwise
            return false;
        }
    }

    // =====================================================================
    // PART 2: Enum with fields and a constructor (15 points)
    // ---------------------------------------------------------------------
    // CoffeeSize has three constants:
    //   SMALL  -> 250 ml, price 2.50
    //   MEDIUM -> 350 ml, price 3.25
    //   LARGE  -> 450 ml, price 4.00
    // Add fields (final), a private constructor, and getters getMl()
    // and getPrice().
    // =====================================================================
    enum CoffeeSize {
        // TODO: declare SMALL, MEDIUM, LARGE with their values
        PLACEHOLDER;   // TODO: delete this line

        // TODO: add final fields: int ml; double price

        // TODO: add the constructor

        int getMl() {
            // TODO
            return 0;
        }

        double getPrice() {
            // TODO
            return 0;
        }
    }

    // =====================================================================
    // PART 3: Constant-specific behavior (20 points)
    // ---------------------------------------------------------------------
    // Operation has four constants: ADD, SUBTRACT, MULTIPLY, DIVIDE.
    // Each must provide its own implementation of apply(double a, double b).
    // DIVIDE must throw ArithmeticException when b == 0.
    // Each constant also stores a symbol: "+", "-", "*", "/".
    // =====================================================================
    enum Operation {
        // TODO: declare the four constants. Each needs a symbol AND its own
        //       body overriding apply(). Example shape:
        //
        //       ADD("+") {
        //           @Override double apply(double a, double b) { ... }
        //       },
        //
        PLACEHOLDER("?") {
            @Override double apply(double a, double b) { return 0; }
        };   // TODO: replace PLACEHOLDER with the real constants

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        abstract double apply(double a, double b);

        String getSymbol() {
            return symbol;
        }
    }

    // =====================================================================
    // PART 4: State machine with switch expression (15 points)
    // ---------------------------------------------------------------------
    // TrafficLight cycles: RED -> GREEN -> YELLOW -> RED
    // Implement next() using a switch expression WITHOUT a default branch.
    // =====================================================================
    enum TrafficLight {
        RED, GREEN, YELLOW;

        TrafficLight next() {
            // TODO: use a switch expression on "this"
            return null;
        }
    }

    // =====================================================================
    // PART 5: Safe parsing (15 points)
    // ---------------------------------------------------------------------
    // Role has ADMIN, EDITOR, VIEWER, and UNKNOWN.
    // Implement the static method fromString(String text):
    //   - Ignore leading/trailing whitespace and letter case
    //       "  admin " -> ADMIN
    //   - If text is null, empty, or does not match any role, return UNKNOWN
    //   - It must NEVER throw an exception
    // Hint: use try/catch around valueOf, or loop over values().
    // =====================================================================
    enum Role {
        ADMIN, EDITOR, VIEWER, UNKNOWN;

        static Role fromString(String text) {
            // TODO
            return null;
        }
    }

    // =====================================================================
    // PART 6: Lifecycle rules (15 points)
    // ---------------------------------------------------------------------
    // OrderStatus allowed transitions:
    //   PENDING    -> PROCESSING, CANCELLED
    //   PROCESSING -> SHIPPED, CANCELLED
    //   SHIPPED    -> DELIVERED
    //   DELIVERED  -> (none)
    //   CANCELLED  -> (none)
    // Implement canMoveTo(target).
    // =====================================================================
    enum OrderStatus {
        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED;

        boolean canMoveTo(OrderStatus target) {
            // TODO
            return false;
        }
    }

    // =====================================================================
    // PART 7: EnumMap and EnumSet (10 points)
    // ---------------------------------------------------------------------
    // (a) countByDay: given a list of Day values, return an EnumMap<Day,Integer>
    //     with how many times each day appears. Days that never appear should
    //     NOT be in the map.
    // (b) weekdaysOnly: return an EnumSet<Day> containing every day for which
    //     isWeekend() is false. (Do not hard-code the days.)
    // =====================================================================
    static EnumMap<Day, Integer> countByDay(List<Day> days) {
        // TODO
        return null;
    }

    static EnumSet<Day> weekdaysOnly() {
        // TODO
        return null;
    }

    // =====================================================================
    // BONUS (optional, 5 points)
    // ---------------------------------------------------------------------
    // Write a method that, given a Day, returns the NEXT day, wrapping from
    // SUNDAY back to MONDAY. Hint: use ordinal() and values(), or modulo.
    // =====================================================================
    static Day nextDay(Day d) {
        // TODO (bonus)
        return null;
    }

    // =====================================================================
    // TEST HARNESS: do not modify below this line
    // =====================================================================
    static int score = 0;
    static int total = 0;

    static void check(String name, int points, boolean condition) {
        total += points;
        if (condition) {
            score += points;
            System.out.printf("PASS  (+%2d)  %s%n", points, name);
        } else {
            System.out.printf("FAIL  ( 0)   %s%n", name);
        }
    }

    static boolean safe(java.util.function.BooleanSupplier test) {
        try {
            return test.getAsBoolean();
        } catch (Throwable t) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Running enum assignment tests...\n");

        // Part 1
        check("Part 1: Day has 7 constants", 4, safe(() -> Day.values().length == 7));
        check("Part 1: Day order starts MONDAY, ends SUNDAY", 3, safe(() ->
                Day.values()[0].name().equals("MONDAY") && Day.values()[6].name().equals("SUNDAY")));
        check("Part 1: isWeekend works", 3, safe(() ->
                Day.valueOf("SATURDAY").isWeekend() && Day.valueOf("SUNDAY").isWeekend()
                        && !Day.valueOf("MONDAY").isWeekend() && !Day.valueOf("FRIDAY").isWeekend()));

        // Part 2
        check("Part 2: CoffeeSize has 3 constants", 3, safe(() -> CoffeeSize.values().length == 3));
        check("Part 2: SMALL values", 4, safe(() ->
                CoffeeSize.valueOf("SMALL").getMl() == 250 && CoffeeSize.valueOf("SMALL").getPrice() == 2.50));
        check("Part 2: MEDIUM values", 4, safe(() ->
                CoffeeSize.valueOf("MEDIUM").getMl() == 350 && CoffeeSize.valueOf("MEDIUM").getPrice() == 3.25));
        check("Part 2: LARGE values", 4, safe(() ->
                CoffeeSize.valueOf("LARGE").getMl() == 450 && CoffeeSize.valueOf("LARGE").getPrice() == 4.00));

        // Part 3
        check("Part 3: four operations exist", 4, safe(() -> Operation.values().length == 4));
        check("Part 3: ADD and SUBTRACT", 4, safe(() ->
                Operation.valueOf("ADD").apply(6, 3) == 9 && Operation.valueOf("SUBTRACT").apply(6, 3) == 3));
        check("Part 3: MULTIPLY and DIVIDE", 4, safe(() ->
                Operation.valueOf("MULTIPLY").apply(6, 3) == 18 && Operation.valueOf("DIVIDE").apply(6, 3) == 2));
        check("Part 3: symbols", 4, safe(() ->
                Operation.valueOf("ADD").getSymbol().equals("+")
                        && Operation.valueOf("SUBTRACT").getSymbol().equals("-")
                        && Operation.valueOf("MULTIPLY").getSymbol().equals("*")
                        && Operation.valueOf("DIVIDE").getSymbol().equals("/")));
        check("Part 3: DIVIDE by zero throws ArithmeticException", 4, safe(() -> {
            try {
                Operation.valueOf("DIVIDE").apply(1, 0);
                return false;
            } catch (ArithmeticException e) {
                return true;
            }
        }));

        // Part 4
        check("Part 4: RED -> GREEN", 5, safe(() -> TrafficLight.RED.next() == TrafficLight.GREEN));
        check("Part 4: GREEN -> YELLOW", 5, safe(() -> TrafficLight.GREEN.next() == TrafficLight.YELLOW));
        check("Part 4: YELLOW -> RED", 5, safe(() -> TrafficLight.YELLOW.next() == TrafficLight.RED));

        // Part 5
        check("Part 5: exact match", 3, safe(() -> Role.fromString("ADMIN") == Role.ADMIN));
        check("Part 5: case and whitespace ignored", 4, safe(() ->
                Role.fromString("  editor ") == Role.EDITOR && Role.fromString("viewer") == Role.VIEWER));
        check("Part 5: invalid input gives UNKNOWN", 4, safe(() ->
                Role.fromString("boss") == Role.UNKNOWN && Role.fromString("") == Role.UNKNOWN));
        check("Part 5: null gives UNKNOWN", 4, safe(() -> Role.fromString(null) == Role.UNKNOWN));

        // Part 6
        check("Part 6: PENDING transitions", 4, safe(() ->
                OrderStatus.PENDING.canMoveTo(OrderStatus.PROCESSING)
                        && OrderStatus.PENDING.canMoveTo(OrderStatus.CANCELLED)
                        && !OrderStatus.PENDING.canMoveTo(OrderStatus.SHIPPED)
                        && !OrderStatus.PENDING.canMoveTo(OrderStatus.DELIVERED)));
        check("Part 6: PROCESSING transitions", 4, safe(() ->
                OrderStatus.PROCESSING.canMoveTo(OrderStatus.SHIPPED)
                        && OrderStatus.PROCESSING.canMoveTo(OrderStatus.CANCELLED)
                        && !OrderStatus.PROCESSING.canMoveTo(OrderStatus.PENDING)));
        check("Part 6: SHIPPED transitions", 3, safe(() ->
                OrderStatus.SHIPPED.canMoveTo(OrderStatus.DELIVERED)
                        && !OrderStatus.SHIPPED.canMoveTo(OrderStatus.CANCELLED)));
        check("Part 6: terminal states", 4, safe(() -> {
            if (!OrderStatus.PENDING.canMoveTo(OrderStatus.PROCESSING)) return false; // rules must be implemented
            for (OrderStatus t : OrderStatus.values()) {
                if (OrderStatus.DELIVERED.canMoveTo(t) || OrderStatus.CANCELLED.canMoveTo(t)) return false;
            }
            return true;
        }));

        // Part 7
        check("Part 7a: countByDay counts correctly", 5, safe(() -> {
            List<Day> input = List.of(Day.valueOf("MONDAY"), Day.valueOf("FRIDAY"),
                    Day.valueOf("MONDAY"), Day.valueOf("SUNDAY"), Day.valueOf("MONDAY"));
            EnumMap<Day, Integer> m = countByDay(input);
            return m.size() == 3
                    && m.get(Day.valueOf("MONDAY")) == 3
                    && m.get(Day.valueOf("FRIDAY")) == 1
                    && m.get(Day.valueOf("SUNDAY")) == 1;
        }));
        check("Part 7b: weekdaysOnly", 5, safe(() -> {
            EnumSet<Day> s = weekdaysOnly();
            return s.size() == 5 && !s.contains(Day.valueOf("SATURDAY")) && !s.contains(Day.valueOf("SUNDAY"));
        }));

        // Bonus
        check("BONUS: nextDay wraps around", 5, safe(() ->
                nextDay(Day.valueOf("MONDAY")) == Day.valueOf("TUESDAY")
                        && nextDay(Day.valueOf("SUNDAY")) == Day.valueOf("MONDAY")));

        System.out.println("\n----------------------------------------");
        System.out.printf("SCORE: %d / %d%n", score, total);
        System.out.println("(100 points for Parts 1-7, plus 5 bonus)");
        System.out.println("----------------------------------------");
    }
}
