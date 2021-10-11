package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.opencsv.CSVReader;






/**
 * Servlet implementation class servletproductosload
 */
@WebServlet("/servletproductosload")
@MultipartConfig
public class servletproductosload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletproductosload() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file"); 
        InputStream fileContent = filePart.getInputStream();

        Reader in = new InputStreamReader(fileContent);

        CSVReader reader;
        Iterator<String[]> iterator;

        try {

            reader = new CSVReader(new InputStreamReader(fileContent));
            iterator = reader.iterator();

            String[] row = iterator.next();

            Map<Object, String> map = new HashMap<>();
            for(int i = 0; i < row.length; i++){
                map.put(i, row[i]);

                JOptionPane.showMessageDialog(null, row[i]);

            }

        }catch(Exception ex) {
        	JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        in.close();
	}

}
