import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.UUID;


public class ProcesoFile {
	
	

	public static void cargarTabla(BufferedReader br, Connection conn) throws Exception {
		
		 String sql = "INSERT INTO REG1(id_cliente, monto, tipo_operacion) VALUES (?, ?, ?)";

		 String line = br.readLine();
		 int i = 0;
		 PreparedStatement ps = conn.prepareStatement(sql);
		 
		 while (line != null) {
			    
		
		        
		     String[] partes = line.split(",");

		     String id = partes[0];
		     
		     Double monto = Double.parseDouble(partes[1]);
		     
		     String c = partes[2];
		     
		     Registro r = new Registro(id, monto, c);
		     
		     ps.setString(1, id);
		 	 ps.setDouble(2, monto);
		 	 ps.setString(3, c);
		     
		 	 ps.executeUpdate();
		 	 
		     line = br.readLine();
		     
		 }
		           

	}

}
