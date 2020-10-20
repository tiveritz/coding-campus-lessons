# Java
Java is a object-orientated, class-based cross-platform general-purpose high-level programming language.

```
object-orientated.... programming paradigm based on the concept of objects. Data in the form of properties, code in the form of methods.
class-based.......... inheritance over classes of objects
cross-platform....... works on multiple operating systems
general-purpose...... used by different applications (desktop, mobile, games, web server, web applications)
high-level........... independent of a particular type of computer, easier to understand and write because closer to human language
```


#### A Statement
```
System.out.println("Hello World");
System ............................... class
out .................................. stream
println .............................. method
"Hello World" ........................ method parameter
System.out.println("Hello World"); ... statement
int myNumber = 8; ................... statement
```

#### Operators
Primitive Operators
```
+ ... addition
- ... subtraction
* ... multiplication
/ ... division
% ... modulo
```

Assignment Operators
```
= ........ assignment
a += b ... a = a + b
a -= b ... a = a - b
a /= b ... a = a / b
a %= b ... a = a % b
```

Unary Operators
```
++i ... prefix increase
--i ... prefix decrease
i++ ... postfix increase
i-- ... postfix decrease
```

Comparison Operator
```
== ... equals to
!= ... not equals to
<= ... smaller than or equal to
>= ... bigger than or equal to
< .... smaller than
> .... bigger than
```

Logical Operators
```
&& ... logical AND
|| ... logical OR
! .... logical NOT
```

#### Primitive Data Types
int group:
```
byte ........... 1 byte, whole numbers -128 to 127
short .......... 2 bytes, whole numbers -32768 to 32767
int ............ 4 bytes, whole numbers -2147483648 to 2147483647
long ........... 8 bytes, very big whole numbers
```

float group:
```
float .......... 4 bytes, fractional numbers, 6 to 7 decimal digits
double ......... 8 bytes, fractional numbers, 15 decimal digts
```

other:
```
boolean ........ 1 bit, true or false
char ........... 2 bytes, single character 'A' or 'c' (ASCII values)
```

not a data type
```
String ......... "Hello World" (String is a class)
```

#### Wrapper Classes
```
Byte........ for byte
Short....... for short
Integer..... for int
Long........ for long
Float....... for float
Double...... for double
Boolean..... for boolean
Character... for char
```

#### Reference Data Types
```
String myString = "Hello World";

String[] myStringArray = new String[length];... String array
int[] myStringArray = new int[length];......... int array

Vector<String> words = new Vector<String>();..... String vector
Vector<Integer> words = new Vector<Integer>();... int vector
```

#### Main Program Declaration
```
public class Main {
    public static void main(String[] args) {

    }
}

public class Main{} ... class declaration
public ................ class access keyword
class ................. class keyword
Main .................. class name

public static void main(String[] args)...Required method of every Java program
public ..... access modifier
static ..... memory management keyword
void ....... return type
main ....... method name
String[] ... method parameter data type
args ....... method parameter data name
```

#### Method Declaration
```
public static void helloWorld() {

}

public ....... access modifier
static ....... memory management keyword (static -> doesn't belong to a specific object)
void ......... return type (void -> returns no value)
helloWorld ... method name
() ........... method parameters (can be empty -> "method takes no parameters")

access modifier
private ..... access only within the class
default ..... access only within the package
protected ... access within the package and outside the package through child class
public ...... access from everywhere

package ..... folder in filesystem with classes inside

return type
primitive types (int, boolean, double)
Arrays, Strings...
void -> nothing gets returned
```

#### Conditional Statement
```
if (condition) {
    // executes if condition is true
}

if (condition) {
    // executes if condition is true
} else {
    // executes if condition is false
}

if (condition) {
    // executes if condition is true
} else if (other condition) {
    // executes if other condition is true
} else {
    // executes if no previous conditions are true
}

{}... scope of if statement
```

#### Naming Conventions
```
variables ... camelCase (helloWorld, isActive, distanceToMars)
constants ... UPPERCASE_WITH_UNDERLINE (HOURS_PER_DAY, PI, DISTANCE_TO_DSCHIBUTI)
class ....... PascalCase (Main, MyClass, )
method ...... camelCase (primes, helloWorld, numberList)
package ..... lowercase (eng, dist, src)
```

#### Loops
```
while (condition) {
    // executes as long as condition is true
}

for (variable_type variable_name = variable_value; end condition; increment) {
    // executes as long as end condition is met
}

for (variable_type variable_name : iterable) {
    // executes for every element in iterable
}
```

#### Scope
Scope is a range of code where special rules apply. Variables declared inside the
scope are only accessible by the code within the same scope.

Examples
```
public static void helloWorld() {
    // Scope is the code between { and }
}

if (condition) {
    // Scope is the code between { and }
}

while (condition) {
    // Scope is the code between { and }
}
```

#### Javadoc (Doc Comments)
```
/** This is Javadoc
  * You should comment your methods (what they do, author, version...). This
  * Information will be displayed as quick tip when the method is used.
  *
  * @author Tiveritz
  * @version 1.0
  * @whatever else you like
  */
public static void helloWorld() {
    // Scope is the code between { and }
}
```

#### Method Overloading
Method overlowding allows to use methods with the same name but different parameters. Depending on the passed arguments when calling the methods, Java uses the matching method.
```
    public static int powerOf(int a) {
        return powerOf(a, 2);
    }

    public static int powerOf(int a, int b) {
    return a^b;
    }
```

#### ToDo
    * Pattern + Matcher + match Vector
    * final
    * constructor (system.in???)
