import com.opencsv.CSVWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        makeFile("data.csv");
        makeXML("data.xml");
    }

    // подготовим исходный CSV-файл
    private static void makeFile(String file) {
        List<String> body = new ArrayList<>();
        body.add("1,John,Smith,USA,25");
        body.add("2,Ivan,Petrov,RU,23");

        try (FileWriter writer = new FileWriter(file)) {
            for (String s : body) {
                writer.write(s);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeCSV(String file) {
        List<String[]> body = new ArrayList<>();
        body.add("1,John,Smith,USA,25".split(","));
        body.add("2,Ivan,Petrov,RU,23".split(","));

        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeAll(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // подготовим исходный XML-файл
    private static void makeXML(String file) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "Smith", "USA", 25));
        employees.add(new Employee(2, "Ivan", "Petrov", "RU", 23));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document document = builder.newDocument();

        Element staff = document.createElement("staff");
        document.appendChild(staff);
        for (Employee _employee : employees) {
            Element employee = document.createElement("employee");
            staff.appendChild(employee);
            addTextNode(document, "id", employee, String.valueOf(_employee.id));
            addTextNode(document, "firstName", employee, _employee.firstName);
            addTextNode(document, "lastName", employee, _employee.lastName);
            addTextNode(document, "country", employee, _employee.country);
            addTextNode(document, "age", employee, String.valueOf(_employee.age));
        }

        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(file));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addTextNode(Document document, String tag, Element parent, String value) {
        Element id = document.createElement(tag);
        parent.appendChild(id);
        id.appendChild(document.createTextNode(value));
    }

}
