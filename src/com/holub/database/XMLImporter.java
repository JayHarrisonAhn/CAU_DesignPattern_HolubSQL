package com.holub.database;

import com.holub.tools.ArrayIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

public class XMLImporter implements Table.Importer {
    private Reader in;
    private Element root;
    private int currentRow;

    public XMLImporter(Reader in) {
        this.in = in;
        this.currentRow = -1;
    }

    @Override
    public void startTable() throws IOException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(in));
            this.root = doc.getDocumentElement();
        } catch(Exception e) {

        }
    }

    @Override
    public String loadTableName() throws IOException {
        return root.getTagName();
    }

    @Override
    public int loadWidth() throws IOException {
        int i = 0;
        Iterator columnNames = loadColumnNames();
        while(columnNames.hasNext()) {
            i++;
            columnNames.next();
        }
        return i;
    }

    @Override
    public Iterator loadColumnNames() throws IOException {
        ArrayList columns = new ArrayList<String>();
        for (int i = 0; i < root.getChildNodes().item(1).getChildNodes().getLength(); i++) {
            Node node = root.getChildNodes().item(1).getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;
                String tagName = childElement.getTagName();
                if(!tagName.trim().equals(""))
                    columns.add(tagName);
            }
        }
        return new ArrayIterator(columns.toArray());
    }

    @Override
    public Iterator loadRow() throws IOException {
        currentRow += 1;
        if (currentRow >= root.getChildNodes().getLength()-1) {
            return null;
        }

        Node rowNode = root.getChildNodes().item(currentRow);
        while (rowNode.getNodeType() == Node.TEXT_NODE) {
            currentRow += 1;
            rowNode = rowNode.getNextSibling();
            if (rowNode == null)
                return null;
        }

        ArrayList row = new ArrayList<String>();
        for(int i=0; i < rowNode.getChildNodes().getLength(); i++) {
            Node node = rowNode.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;
                String value = childElement.getTextContent();
                row.add(value);
            }
        }
        return new ArrayIterator(row.toArray());
    }

    @Override
    public void endTable() throws IOException { }
}
