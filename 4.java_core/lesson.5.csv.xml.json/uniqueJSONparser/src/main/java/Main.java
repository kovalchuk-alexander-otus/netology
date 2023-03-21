import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // создание исходных файлов data.csv, data.xml
        Test.init();

        // дз #1
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};

        List<Employee> list = parseCSV(columnMapping, "data.csv");
        list.forEach(System.out::println);

        String json = listToJson(list);
        System.out.println(json);

        writeString(json, "data.json");

        // дз #2
        list = parseXML("data.xml");

        json = listToJson(list);
        System.out.println(json);

        writeString(json, "data2.json");

        // дз #3
        json = readString("new_data.json");
        System.out.println(json);
        list = jsonToList(json);
        System.out.println(list);
    }

    // загрузка файла CSV & парсинг в объекты Employee
    private static List<Employee> parseCSV(String[] columnMapping, String fileName) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).build()) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);

            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();

            return csv.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // формирование строки в формате JSON из списка объектов Employee
    private static String listToJson(List<Employee> list) {
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(list, listType);
    }

    // запись (создание) файла
    public static void writeString(String text, String file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // аналог метода writeString ... но чуть более специфический - тело файла перед записью
    // распарсивается в JSON
    public static void writeJSON(String text, String file) {

        JSONParser parser = new JSONParser();

        try (FileWriter writer = new FileWriter(file)) {
            JSONArray object = (JSONArray) parser.parse(text);
            // writer.write(object.toJSONString());
            object.writeJSONString(writer);
            writer.flush();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // SERVICE : получение XML документа
    public static Document getXMLDocument(String file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        try {
            return builder.parse(new File(file));
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    // загрузка файла XML & парсинг в объекты Employee
    private static List<Employee> parseXML(String file) {
        Document document = getXMLDocument(file);
        List<Employee> employees = new ArrayList<>();

        Node root = document.getDocumentElement();
        System.out.printf("Корневой элемент: %s%n", root.getNodeName());
        NodeList nodeList = root.getChildNodes();
        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeName()
                    .equals("employee")) {
                Employee employee = loadEmployee(node);
                System.out.println(employee);
                employees.add(employee);
            }
        }

        return employees;
    }

    // SERVICE : варим экземпляр Employee из очередной ноды XML
    public static Employee loadEmployee(Node node) {
        int id = 0, age = 0;
        String firstName = null;
        String lastName = null;
        String country = null;

        for (int i = 0; i < node.getChildNodes()
                .getLength(); i++) {
            Node nodeChild = node.getChildNodes()
                    .item(i);
            if (nodeChild.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(nodeChild.getNodeName());
                switch (nodeChild.getNodeName()) {
                    case "id":
                        id = Integer.parseInt(nodeChild.getTextContent());
                        break;
                    case "firstName":
                        firstName = nodeChild.getTextContent();
                        break;
                    case "lastName":
                        lastName = nodeChild.getTextContent();
                        break;
                    case "country":
                        country = nodeChild.getTextContent();
                        break;
                    case "age":
                        age = Integer.parseInt(nodeChild.getTextContent());
                        break;
                }
            }
        }

        return new Employee(id, firstName, lastName, country, age);
    }

    // чтение файла
    private static String readString(String fileName) {
        StringBuilder text = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line)
                        .append("\n");
            }
            // JSONParser parser = new JSONParser();
            // Object obj = parser.parse(new FileReader(fileName));
            // JSONArray jsonArray = (JSONArray) obj;
            // return jsonArray.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    // генерация списка объектов Employee из ранее прочитанного JSON
    private static List<Employee> jsonToList(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<Employee> employees = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(json);

            for (Object jsonObject : jsonArray) {
                employees.add(gson.fromJson(String.valueOf(jsonObject), Employee.class));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

}