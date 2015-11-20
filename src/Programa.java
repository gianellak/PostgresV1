import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class Programa {

	public static void main(String[] args) throws Exception {

		
		
		
		Connection conn = getDBConnection();
	

	//select id_cliente, sum(case tipo when 'c' then Amount
      //      when 'd' then Amount * -1 end) as balance 
	//group by id_cliente.
	
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Yo\\Desktop\\movimientos_10000000.txt"), "UTF-8");
		
		BufferedReader br = new BufferedReader(isr);
		
		
		
			
		long inicio =  System.currentTimeMillis();
		
		createDbUserTable();

	    ProcesoFile.cargarTabla(br,conn);
	     
	    long finProc =  System.currentTimeMillis();
			
		System.out.println("Tardo: " + (finProc - inicio) );
			
		
		
		
	}
	
	
	private static Connection getDBConnection() {

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			

		}


		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"giane");
			
			return connection;
			

		} catch (SQLException e) {

			e.printStackTrace();
			

		}

	

		return connection;

	}

	
	private static void createDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String createTableSQL = "create table Reg1 (id_cliente VARCHAR(255), monto REAL, tipo_operacion VARCHAR(1))";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);
                        // execute the SQL stetement
			statement.execute(createTableSQL);

			System.out.println("Table is created!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}


}
