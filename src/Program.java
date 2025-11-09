public class Program {
    public static void main(String[] args) {


        Familie f1 = new Familie("Max", "Anna");
        f1.addKind("Tomas");
        f1.addKind("Jessica");
        f1.addKind("Albert");
        f1.addKind("Jacob");

        System.out.println("Vater:  " + f1.getMitglied(Familie.Familienmitglied.Vater));
        System.out.println("Mutter: " + f1.getMitglied(Familie.Familienmitglied.Mutter));
        System.out.println("Kinder: " + f1.getMitglied(Familie.Familienmitglied.Kinder));


        Familie f2 = new Familie("Alex", "Eva");

        System.out.println("Vater:  " + f2.getMitglied(Familie.Familienmitglied.Vater));
        System.out.println("Mutter: " + f2.getMitglied(Familie.Familienmitglied.Mutter));
        System.out.println("Kinder: " + f2.getMitglied(Familie.Familienmitglied.Kinder));
        System.out.println();

        System.out.println("\n");

        try {
            Familie f_t = new Familie("", "Mia");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n");

        Familie f3 = new Familie(Familie.Familienmitglied.Mutter, "Sofia");
        f3.addKind("Nico");
        System.out.println("Vater:  " + f3.getMitglied(Familie.Familienmitglied.Vater));
        System.out.println("Mutter: " + f3.getMitglied(Familie.Familienmitglied.Mutter));
        System.out.println("Kinder: " + f3.getMitglied(Familie.Familienmitglied.Kinder));

        for (String name : f3) {
            System.out.println(name);
        }
        System.out.println("\n");
        for (String name : f1) {
            System.out.println(name);
        }
    }


}
