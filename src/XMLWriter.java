import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		//FIXME need to test this shit
		String studentXML = xstream.toXML(s);
		writer.append(studentXML);
		writer.append('\n');
	}
	
	public void writeClassToXML(Course c) throws IOException{
		// FIXME test this shit. Not sure if TreeMap works with XStream.
		String classXML = xstream.toXML(c);
		writer.append(classXML);
		writer.append('\n');
	}
}
