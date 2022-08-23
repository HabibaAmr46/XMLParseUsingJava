
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLParser {

    public static class CD {

        public String title;
        public String artist;
        public String country;
        public String company;
        public float price;
        public int year;

        public CD(String title, String artist, String country, String company, float price, int year) {
            this.title = title;
            this.artist = artist;
            this.country = country;
            this.company = company;
            this.price = price;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getCountry() {
            return country;
        }

        public String getCompany() {
            return company;
        }

        public float getPrice() {
            return price;
        }

        public int getYear() {
            return year;
        }

    }

    public static void WriteXML(ArrayList<CD> Cds) throws IOException,
            ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element root = (Element) doc.createElement("CATALOGUE");
        doc.appendChild((Node) root);

        for (CD i : Cds) {
            Element CD = doc.createElement("CD");
            root.appendChild(CD);

            Element TITLE = doc.createElement("TITLE");
            TITLE.appendChild(doc.createTextNode(i.getTitle()));
            CD.appendChild(TITLE);

            Element ARTIST = doc.createElement("ARTIST");
            ARTIST.appendChild(doc.createTextNode(i.getArtist()));
            CD.appendChild(ARTIST);

            Element COUNTRY = doc.createElement("COUNTRY");
            COUNTRY.appendChild(doc.createTextNode(i.getCountry()));
            CD.appendChild(COUNTRY);

            Element COMPANY = doc.createElement("COMPANY");
            COMPANY.appendChild(doc.createTextNode(i.getCompany()));
            CD.appendChild(COMPANY);

            Element PRICE = doc.createElement("PRICE");
            PRICE.appendChild(doc.createTextNode(Float.toString(i.getPrice())));
            CD.appendChild(PRICE);

            Element YEAR = doc.createElement("YEAR");
            YEAR.appendChild(doc.createTextNode(Integer.toString(i.getYear())));
            CD.appendChild(YEAR);

        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\AssignmentSOA\\src\\java/CDs.xml"));
        transformer.transform(source, result);
    }

    public static void PrintAll(Document doc) {
        System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
        System.out.println("------");

        // get <student>
        NodeList list = doc.getElementsByTagName("CD");

        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                
                System.out.println("Current Element :" + node.getNodeName());

                // get text
                String title = element.getElementsByTagName("TITLE").item(0).getTextContent();
                String artist = element.getElementsByTagName("ARTIST").item(0).getTextContent();
                String country = element.getElementsByTagName("COUNTRY").item(0).getTextContent();
                String company = element.getElementsByTagName("COMPANY").item(0).getTextContent();
                String price = element.getElementsByTagName("PRICE").item(0).getTextContent();
                String year = element.getElementsByTagName("YEAR").item(0).getTextContent();

                System.out.println("Title : " + title);
                System.out.println("Artist : " + artist);
                System.out.println("Country : " + country);
                System.out.println("Company : " + company);
                System.out.println("Price : " + price);
                System.out.println("Year :" + year);

                System.out.println("");

            }
        }
    }

    public static void SearchTitle(String title, Document doc) {
        int found = 0;
        NodeList list = doc.getElementsByTagName("CD");

        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                String xmltitle = element.getElementsByTagName("TITLE").item(0).getTextContent();
                if (xmltitle.equalsIgnoreCase(title)) {
                    String artist = element.getElementsByTagName("ARTIST").item(0).getTextContent();
                    String country = element.getElementsByTagName("COUNTRY").item(0).getTextContent();
                    String company = element.getElementsByTagName("COMPANY").item(0).getTextContent();
                    String price = element.getElementsByTagName("PRICE").item(0).getTextContent();
                    String year = element.getElementsByTagName("YEAR").item(0).getTextContent();

                    System.out.println();

                    System.out.println("Title : " + title);
                    System.out.println("Artist : " + artist);
                    System.out.println("Country : " + country);
                    System.out.println("Company : " + company);
                    System.out.println("Price : " + price);
                    System.out.println("Year :" + year);

                    found = 1;

                }

            }

        }
        if (found == 0) {
            System.out.println("This title is not found");
        }

    }

    public static void SearchArtist(String artist, Document doc) {
        int found = 0;
        NodeList list = doc.getElementsByTagName("CD");

        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                String xmlartist = element.getElementsByTagName("ARTIST").item(0).getTextContent();
                if (xmlartist.equalsIgnoreCase(artist)) {
                    String title = element.getElementsByTagName("TITLE").item(0).getTextContent();

                    String country = element.getElementsByTagName("COUNTRY").item(0).getTextContent();
                    String company = element.getElementsByTagName("COMPANY").item(0).getTextContent();
                    String price = element.getElementsByTagName("PRICE").item(0).getTextContent();
                    String year = element.getElementsByTagName("YEAR").item(0).getTextContent();

                    System.out.println();
                    System.out.println("Current Element :" + node.getNodeName());

                    System.out.println("Title : " + title);
                    System.out.println("Artist : " + artist);
                    System.out.println("Country : " + country);
                    System.out.println("Company : " + company);
                    System.out.println("Price : " + price);
                    System.out.println("Year :" + year);

                    found = 1;

                }

            }

        }
        if (found == 0) {
            System.out.println("This title is not found");
        }

    }

    public static void main(String[] args) throws TransformerConfigurationException, TransformerException {

        String FILENAME = "C:\\Users\\hp\\Documents\\NetBeansProjects\\AssignmentSOA\\src\\java/CDs.xml";

        //an instance of factory that gives a document builder  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        String intitle, inartist, company, country;
        float price;
        int year;

        try {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of CDs");
            int num = input.nextInt();
            ArrayList<CD> Cds = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                System.out.println("Title:");
                input.nextLine();
                intitle = input.nextLine();
                System.out.println("Artist:");
                inartist = input.nextLine();
                 System.out.println("Country:");
                country = input.nextLine();
                System.out.println("Company:");
                company = input.nextLine();
               
                System.out.println("Price:");
                price = input.nextFloat();
                System.out.println("Year:");
                year = input.nextInt();
                System.out.println();
                Cds.add(new CD(intitle, inartist, country, company, price, year));

            }

            // parse XML file
            WriteXML(Cds);
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            while (true) {
                System.out.println("");
                System.out.println("1) Search by Title,2)Search By Artist 3)Print All");

                int option = input.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter The Title ");
                        input.nextLine();
                        String title = input.nextLine();
                        SearchTitle(title, doc);
                        break;
                    case 2:
                        System.out.println("Enter The Artist ");
                        input.nextLine();
                        String artist = input.nextLine();
                        SearchArtist(artist, doc);
                        break;
                    case 3:
                        PrintAll(doc);
                        break;
                    default:
                        break;
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
        }

    }

}
