
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;
import org.w3c.dom.*;
import java.io.*;

/**
 * Class that parse the xml file into a tree
 * 
 * @author mac
 *
 */
public class MovieFileReader {
	private BinaryTree<String> movieTree;

	/**
	 * Constructor
	 */
	public MovieFileReader() {
		movieTree = new DefaultBinaryTree<>();

	}

	/**
	 * Method that get the tree
	 * 
	 * @return movieTree BinaryTre
	 */
	public BinaryTree<String> getTree() {
		return movieTree;

	}

	/**
	 * Method that read the file
	 * 
	 * @param input
	 *            String
	 * @return file BinaryTree
	 */

	public BinaryTree<String> fileReader(String input) {

		// Setup XML Document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			File xmlFile = new File(input);
			Document document = builder.parse(xmlFile);

			return parseMovieFile(document);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.out.print("ParserConfigurationException");
		} catch (SAXException e) {
			e.printStackTrace();
			System.out.println("SAXException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException");
		}
		return null;

	}

	/**
	 * Method that parse in the File as a tree
	 * 
	 * @param document
	 *            Document
	 * @return movieTRee BinaryTree<String>
	 */

	private BinaryTree<String> parseMovieFile(Document document) {
		// get the root that's the document element
		Node docRoot = document.getDocumentElement();

		// a list that contains all the children of the root
		NodeList nodes = docRoot.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				// set the question to be the first root of tree
				movieTree.setRoot(parseQuestionNode((Element) nodes.item(i)));
			}

		}
		return movieTree;
	}

	/**
	 * Method that parse in the nodes
	 * 
	 * @param e
	 *            Element
	 * @return answerNode BinaryTreeNode<String>
	 */
	private BinaryTreeNode<String> parseAnswerNode(Element e) {
		// get all the child nodes from element e
		NodeList childNodes = e.getChildNodes();
		// System.out.print("Child nodes" + childNodes);
		for (int i = 0; i < childNodes.getLength(); i++) {
			if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				// if the node at index i is equals to the node with attribute title
				if (childNodes.item(i).getNodeName().equals("title")) {
					// then we create a new tree node
					BinaryTreeNode<String> node = new DefaultBinaryTreeNode<>();
					// this node set the data inside the attribute title
					node.setData(((Element) childNodes.item(i)).getAttribute("title"));

					return node;
					// if the node is a question node
				} else if (childNodes.item(i).getNodeName().equals("question")) {
					return parseQuestionNode((Element) childNodes.item(i));
				}
			}
		}
		return null;

	}

	/**
	 * Method that parse question nodes
	 * 
	 * @param e
	 *            Element
	 * @return question node BinaryTreeNode<String>
	 */
	private BinaryTreeNode<String> parseQuestionNode(Element e) {
		BinaryTreeNode<String> newNode = new DefaultBinaryTreeNode<>();
		// set the data of new node to be the question
		newNode.setData(e.getAttribute("q"));

		// get childNodes of element
		NodeList childNodes = e.getChildNodes();

		// loop through the child nodes
		for (int i = 0; i < childNodes.getLength(); i++) {
			// if the childNodes are answer
			if (childNodes.item(i).getNodeName().equals(("answer"))) {
				Element childNode = (Element) childNodes.item(i);
				// if the element in the question is a Yes answer
				if ((childNode.getAttribute("a").equals("Yes"))) {
					// set the the next question to be on the left
					newNode.setLeftChild(parseAnswerNode(childNode));
					// if the answer is No
				} else if (childNode.getAttribute("a").equals("No")) {
					// set the next question to be on the right child
					newNode.setRightChild(parseAnswerNode(childNode));
				}
			}
		}
		return newNode;

	}

}
