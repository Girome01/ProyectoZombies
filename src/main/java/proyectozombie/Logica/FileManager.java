package proyectozombie.Logica;

import java.io.*;

public class FileManager {

    public static String readFile(File path) throws FileNotFoundException, IOException {
        String everything;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }

        return everything;
    }

    //Por favor que el nombre lleve la extension seleccionada
    public static void writeFile(String texto, File file) throws UnsupportedEncodingException, IOException {


        FileWriter escribir;

        try {

            escribir = new FileWriter(file, false);
            escribir.write(texto);
            escribir.close();

        } catch (Exception e) {
        }


    }

    // escribe un objeto
    public static void writeObject(Object obj, String filePath) {
        try {
            //use buffering
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            try (ObjectOutput output = new ObjectOutputStream(buffer)) {
                // escribe el objeto
                output.writeObject(obj);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // lee un objeto
    public static Object readObject(String filePath) {
        try {
            //use buffering
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            try (ObjectInput input = new ObjectInputStream(buffer)) {
                //deserialize the List
                return input.readObject();
            }
        } catch (ClassNotFoundException ex) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return null;
    }

}
