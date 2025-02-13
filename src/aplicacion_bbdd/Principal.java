package aplicacion_bbdd;

import java.sql.*;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		final String bbdd = "burgerking_completa";
		final String user = "root";
		final String pwd = "";
		final String server = "jdbc:mysql://localhost:3306/";
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(server + bbdd, user, pwd);
			int opcion;
			boolean continuar = false;
			
			do {
				for(int i = 0; i < 33; i++) {
					System.out.print("-");
				}
				System.out.println();
				System.out.println("\tMenu de opciones");
				for(int i = 0; i < 33; i++) {
					System.out.print("-");
				}
				System.out.println();
				System.out.println("1- Mostrar datos de productos\r\n"
						+ "2- Mostrar datos de pedidos\r\n"
						+ "3- Mostrar datos de productos y pedidos\r\n"
						+ "4- Alta de datos en ofertas\r\n"
						+ "5- Alta de datos en cientes\r\n"
						+ "6- Modificar datos de empleados\r\n"
						+ "7- Modificar datos de locales\r\n"
						+ "8- Eliminar datos de empleados\r\n"
						+ "9- Eliminar datos de locales\r\n"
						+ "10- Salir");
				System.out.print("Opcion: ");
				opcion = entrada.nextInt();
				
				switch (opcion) {
				case 1:
					String base_productos = "productos";
					Metodos.mostrar(base_productos, conexion);
					break;
				case 2:
					String base_pedidos = "pedidos";
					Metodos.mostrar(base_pedidos, conexion);
					break;
				case 3:
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				default:
					System.out.println("ERROR: OPCION INCORRECTA");
					System.out.println();
				}
			} while(opcion != 10);
			
			conexion.close();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			entrada.close();
		}
		
	}

}
