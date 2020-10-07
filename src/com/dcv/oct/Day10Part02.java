package src.com.dcv.oct;

public class Day10Part02 {
    // Schreibe ein Programm, das für eine beliebige Nichtkommazahl anführt, ob die Zahl im
    // Werteberich von byte, short, int oder long

    public static void intTypeRange() {

        // String myNumber = "2";
        String myNumber = "32000";
        // String myNumber = "2000000000";
        // String myNumber = "9000000000000000000";

        Long number = Long.parseLong(myNumber);

        if (number <= Byte.MAX_VALUE && number >= Byte.MIN_VALUE) {
            System.out.print("Number in range of byte");
        } else if (number <= Short.MAX_VALUE && number >= Short.MIN_VALUE) {
            System.out.println("Number in range of short");
        } else if (number <= Integer.MAX_VALUE && number >= Integer.MIN_VALUE) {
            System.out.println("Number in range of int");
        } else if (number <= Long.MAX_VALUE && number >= Long.MIN_VALUE) {
            System.out.println("Number in range of long");
        }
    }

    // Erstelle eine Variable, welche eine numerische Schulnote beinhaltet
    // und mit hilfe eines switch(/case diese dann textuell ausgibt.
    // Versuche auf zwei Varianten die Note < 1 und Noten großer 5 zu
    // behandeln.
    public static void numberToGrade() {

        byte grade = 2;

        switch (grade) {
            case 1:
                System.out.println("Sehr Gut");
                break;
            case 2:
                System.out.println("Gut");
                break;
            case 3:
                System.out.println("Befriedigend");
                break;
            case 4:
                System.out.println("Genügend");
                break;
            case 5:
                System.out.println("Nicht Genügend");
                break;
            default:
                System.out.println("Diese Note gibt es nicht");
                break;
        }
    }

    // Drehe das vorher geschriebene Programm um, sodass die Eingabe der
    // Text ist und die ausgabe die Ziffernnote.

    // Hinweis: Die textuelle Eingabe kann in der Praxis "irgendwie" daher
    // kommen (z.B.: seHR gut, sehr gut, SEHR GUT). Überlege nach einer
    // Möglichkeit, auf diese zu reagieren
    public static void stringToNumber() {

        String grade = "sEhr GuT";
        // String grade = "UnGenügend";

        switch (grade.toLowerCase()) {
            case "sehr gut":
                System.out.println("1");
                break;
            case "gut":
                System.out.println("2");
                break;
            case "befriedigend":
                System.out.println("3");
                break;
            case "genügend":
                System.out.println("4");
                break;
            case "nicht genügend":
            case "ungenügend":
                System.out.println("5");
                break;
            default:
                System.out.println("Die Note wurde nicht erkannt");
                break;
        }
    }

    // Beim Bowling gibt es 10 Kegel (nicht 9!), versuche die Würfe zu
    // kategorisieren:
    // 1 - 3 ok
    // 4 - 6 guter Wurf
    // 7 - 9 sehr guter Wurf
    // 10 Strike
    public static void bowling() {

        byte bowlThrow = 10;

        switch (bowlThrow) {
            case 1:
            case 2:
            case 3:
                System.out.println("ok");
                break;

            case 4:
            case 5:
            case 6:
                System.out.println("good");
                break;

            case 7:
            case 8:
            case 9:
                System.out.println("very good");
                break;

            case 10:
                System.out.println("strike");
                break;

            default:
                System.out.println("nicht getroffen");
                break;
        }
    }
}