import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import com.thoughtworks.xstream.XStream;

public class XMLWriter {

	private XStream xstream = new XStream();
	private FileWriter writer;
	
	public XMLWriter(File xml){
		try {
			writer = new FileWriter(xml);
		} catch (IOException e) {
			System.err.println("Goddamn it, give me the right filename.");
			e.printStackTrace();
		}
	}
	
	public void writeStudentToXML(Student s) throws IOException{
		String studentXML = xstream.toXML(s);
		System.out.println(studentXML);
		writer.append(studentXML);
		writer.append('\n');
	}
	
	public void writeClassToXML(Class c) throws IOException{
		String classXML = xstream.toXML(c);
		writer.append(classXML);
		writer.append('\n');
	}
	
	public static void main(String[] args) throws IOException{
		XMLWriter xmlwriter = new XMLWriter(new File("idkrandomshit.xml"));
		Student james = new Student(69696969, (float)50.0, new LinkedList<Lecture>());
		xmlwriter.writeStudentToXML(james);
	}
}
