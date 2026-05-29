package de.tu_dortmund.ub.data.metafacture_java_examples;

import java.nio.file.Files;
import java.nio.file.Path;

import org.metafacture.io.ObjectWriter;
import org.metafacture.json.JsonDecoder;
import org.metafacture.metafix.Metafix;
import org.metafacture.xml.SimpleXmlEncoder;

public class JsonToXmlViaFix {
    
    public void process() throws Exception {

        String sourceString = Files.readString(Path.of("data/source.json"));

        JsonDecoder jsonDecoder = new JsonDecoder();

        Metafix metafix = new Metafix("data/sru4neo.fix");

        SimpleXmlEncoder xmlEncoder = new SimpleXmlEncoder();
        xmlEncoder.setWriteRootTag(false);
        xmlEncoder.setAttributeMarker("@");
        xmlEncoder.setValueTag("value");
        xmlEncoder.setNamespaceFile("data/sru4neo.namespaces.properties");
        ObjectWriter<String> writer = new ObjectWriter<>("data/result.xml");

        jsonDecoder.setReceiver(metafix).setReceiver(xmlEncoder).setReceiver(writer);
        jsonDecoder.process(sourceString);
    }

    public static void main(String[] args) throws Exception {

        JsonToXmlViaFix jsonToXmlViaFix = new JsonToXmlViaFix();
        jsonToXmlViaFix.process();
    }
}

