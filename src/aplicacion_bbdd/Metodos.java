package aplicacion_bbdd;

import java.sql.*;
import java.util.Scanner;

public class Metodos {

	public static void mostrar(String base, Connection conexion) 
		throws SQLException {
		String consulta = "SELECT * FROM " + base;
		PreparedStatement ps = conexion.prepareStatement(consulta);
		ResultSet res = ps.executeQuery();
		ResultSetMetaData rmd = res.getMetaData();
		
		switch (base) {
		case "producto":
			System.out.printf("%10s%10s%10s%10s%10s%10s%n",
					rmd.getColumnName(1), rmd.getColumnName(2), rmd.getColumnName(3),
					rmd.getColumnName(4), rmd.getColumnName(5), rmd.getColumnName(6));
			
			for (int i = 0; i < 10+10+10+10+10+10; i++) System.out.print("=");
			System.out.println(); 
			
			while (res.next()) {
				System.out.printf("%10d%10s%10s%10s%10f%10s%n",
						res.getInt(1), res.getString(2), res.getString(3),
						res.getString(4), res.getFloat(5), res.getString(6));
			}
			break;
		case "pedido":
			System.out.printf("%10s%10s%10s%10s%10s%10s%10s%n",
					rmd.getColumnName(1), rmd.getColumnName(2), rmd.getColumnName(3),
					rmd.getColumnName(4), rmd.getColumnName(5), rmd.getColumnName(6),
					rmd.getColumnName(7));
			
			for (int i = 0; i < 10+10+10+10+10+10+10; i++) System.out.print("=");
			System.out.println(); 
			
			while (res.next()) {
				System.out.printf("%10d%10s%10s%10s%10d%10d%10d%n",
						res.getInt(1), res.getString(2), res.getString(3),
						res.getString(4), res.getDouble(5), res.getInt(6),
						res.getInt(7));
			}
			break;
		}
	}
	
	public static void introducirOfertas() {
		
	}
	
	public static void introducirClientes() {
		
	}

	public static void modificarEmpleados() {
		
	}
	
	public static void modificarLocales() {
		
	}

	public static void eliminarEmpleados() {
		
	}
	
	public static void eliminarLocales() {
		
	}
	
	public static boolean continuar(Scanner entrada) {
		System.out.print("¿Quieres modificar mas datos?[s/n]: ");
		return entrada.nextLine().toLowerCase().startsWith("s");
	}
}
