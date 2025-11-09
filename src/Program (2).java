
import java.io.*;
import java.util.ArrayList;

public class Program
{
    public static void main(String[] args) throws Exception
    {
        Adresse adresse = new Adresse();
        adresse.setStrasse("Ringstr. 1");
        adresse.setOrt("Musterstadt");
        Person hugo = new Person();
        hugo.setName("Hugo Schmidt");
        hugo.setAdresse(adresse);
        Person erika = new Person();
        erika.setName("Erika Schmidt");
        erika.setAdresse(adresse);
// Hier fehlt Ihr Code

        ArrayList<Person> list = new ArrayList<Person>();

        list.add(erika);

        list.add(hugo);

        byte[] data;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(list);
            data = bos.toByteArray();
        }

        ArrayList<Person> list2;

        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bis)) {
            list2 = (ArrayList<Person>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Person erika2 = list2.get(0);
        Person hugo2  = list2.get(1);

        System.out.println(erika2);
        System.out.println(hugo2);
        System.out.println(hugo2.getAdresse() == erika2.getAdresse());
        }


}