package main.Utility.jaxb;

import main.JaxbExample;
import main.Models.CreditList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class JaxbParser {

    public static List load(String resourcePath) throws JAXBException, URISyntaxException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(CreditList.class);
        Unmarshaller um = context.createUnmarshaller();

        URL resource = JaxbExample.class.getClassLoader().getResource(resourcePath);
        CreditList creditList = (CreditList) um.unmarshal(new FileReader(new File(resource.toURI())));
        return creditList.getCredits();
    }
}
