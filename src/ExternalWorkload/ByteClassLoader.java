package ExternalWorkload;

/**
 * Erstellt einen Klasse um Klassen zu laden
 *@author 4328112, 1319658, 1060449
 *@version 1.1
 */

public class ByteClassLoader extends ClassLoader {

    /**
     * Läd die Klasse
     * @param name, Name der Klasse
     * @param classBytes, Größe in Bytes
     * @return Geladene Klasse
     */
    public Class<?> defineClass(String name, byte[] classBytes) {
        return defineClass(name, classBytes, 0, classBytes.length);
    }

}
