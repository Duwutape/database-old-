package meth;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XStreamMeth {

    public static void objToXML(Object obj, String path) {

        //create file
        new File(path);

        //write data to file
        XStream xstream = new XStream();

        //create writer
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(xstream.toXML(obj));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object XMLToObj(File file) {
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);

        return xstream.fromXML(file);
    }
}
