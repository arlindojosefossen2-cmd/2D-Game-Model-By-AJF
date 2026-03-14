package br.com.ajf.game.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class XMLUtility.
 */
public final class XMLUtility {

    /**
     * Instantiates a new XML utility.
     */
    public  XMLUtility()
    {

    }

    /**
     * Parses the document.
     *
     * @param inputstream the inputstream
     * @return the document
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SAXException the SAX exception
     */
    public Document parseDocument(InputStream inputstream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document parse = db.parse(new InputSource(inputstream));
        parse.normalize();
        return parse;
    }

    /**
     * Parses the document.
     *
     * @param reader the reader
     * @return the document
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SAXException the SAX exception
     */
    public Document parseDocument(Reader reader) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document parse = db.parse(new InputSource(reader));
        parse.normalize();
        return parse;
    }
    
    /**
     * Gets the node list.
     *
     * @param inputStream the input stream
     * @param tagName the tag name
     * @return the node list
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SAXException the SAX exception
     */
    public NodeList getNodeList(InputStream inputStream,String tagName) throws ParserConfigurationException, IOException, SAXException
    {
    	return parseDocument(inputStream).getDocumentElement().getElementsByTagName(tagName);
    }
    
    /**
     * Gets the node list.
     *
     * @param reader the reader
     * @param tagName the tag name
     * @return the node list
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SAXException the SAX exception
     */
    public NodeList getNodeList(Reader reader,String tagName) throws ParserConfigurationException, IOException, SAXException
    {
    	return parseDocument(reader).getDocumentElement().getElementsByTagName(tagName);
    }

    /**
     * Gets the all elements by tag name.
     *
     * @param element the element
     * @param tagName the tag name
     * @return the all elements by tag name
     */
    public List<Element> getAllElementsByTagName(Element element, String tagName) {
        List<Element> elements = new ArrayList<>();

        NodeList children = element.getElementsByTagName(tagName);

        for (int i = 0; i < children.getLength(); ++i) {
            elements.add((Element) children.item(i));
        }

        return elements;
    }

    /**
     * Gets the elements by tag name.
     *
     * @param element the element
     * @param tagName the tag name
     * @return the elements by tag name
     */
    public List<Element> getElementsByTagName(Element element, String tagName) {
        List<Element> elements = new ArrayList<>();

        NodeList children = element.getElementsByTagName(tagName);

        for (int i = 0; i < children.getLength(); ++i) {
            Node node = children.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                String nodeName = node.getNodeName();

                if (nodeName != null && nodeName.equals(tagName)) {
                    elements.add((Element) node);
                }
            }
        }

        return elements;
    }
    
}