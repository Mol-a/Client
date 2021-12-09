package main;

import main.Utility.jaxb.JaxbParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

public class JaxbExample 
{
    public static void main(String[] args) throws JAXBException, FileNotFoundException, URISyntaxException {
        List load = JaxbParser.load("data/credit.xml");
        System.out.println(load);
    }

}