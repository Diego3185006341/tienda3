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

import modelo.ProductosDAO;
import modelo.ProductosDTO;






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
		
		ProductosDTO pdto;
		ProductosDTO recdatos;
		ProductosDAO pdao = new ProductosDAO();
		String res;
		int procesados = 0;
		int insertados = 0;
		int actualizados = 0;
		
		Part filePart = request.getPart("file"); 
        InputStream fileContent = filePart.getInputStream();

        Reader in = new InputStreamReader(fileContent);

        CSVReader reader;
        Iterator<String[]> iterator;

        try {

            reader = new CSVReader(new InputStreamReader(fileContent));
            iterator = reader.iterator();
            
            while ( iterator.hasNext() ) {
            	String[] row = iterator.next();
            	
            	String line = row[0];
            	
            	line.replace("\"", "");
            	
            	String[] lprod = line.split(";", -1);
            	
            	if(isNumeric(lprod[0])) {
            		pdto=new ProductosDTO(Integer.parseInt(lprod[0]), Double.parseDouble(lprod[1]), Integer.parseInt(lprod[2]), lprod[3], Double.parseDouble(lprod[4]),Double.parseDouble(lprod[5]));
                	
            		recdatos=pdao.consultarProductos(pdto);
            		
            		if(recdatos==null) {
            			res=pdao.insertarProductos(pdto);
            			if(res.equals("r")) {
            				insertados = insertados+1;
            			}
            		}else {
            			if(recdatos!=pdto) {
            				if(pdao.actualizar(pdto)) {
                				actualizados = actualizados+1;
                			}
            			}
            			
            		}
            	}
            	
            	procesados = procesados+1;
            	
            }

            

        }catch(Exception ex) {
        	JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        in.close();
        
        System.out.println("procesados: " + procesados);
    	System.out.println("insertados: " + insertados);
    	System.out.println("actualizado: " + actualizados);
        
        response.sendRedirect("productos.jsp");
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

}
