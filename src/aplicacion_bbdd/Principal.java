package aplicacion_bbdd;

import java.sql.*;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String bbdd = "burgerking_completa";
		String user = "root";
		String pwd = "";
		String server = "jdbc:mysql://localhost:3306/";
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(server + bbdd, user, pwd);
			int opcion;
			
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
				entrada.nextLine();
				
				switch (opcion) {
				case 1:
					String tabla_productos = "productos";
					Metodos.mostrar(tabla_productos, conexion);
					break;
				case 2:
					String base_pedidos = "pedidos";
					Metodos.mostrar(base_pedidos, conexion);
					break;
				case 3:
					
					break;
				case 4:
					System.out.print("Nombre: ");
					String nombreO = entrada.nextLine();
					
					System.out.print("Numero: ");
					String numeroO = entrada.nextLine();
					
					System.out.print("Descripcion: ");
					String descripcion = entrada.nextLine();
					
					System.out.print("Precio: ");
					float precio = entrada.nextFloat();
					entrada.nextLine();
					
					System.out.print("ID_Local: ");
					int id_local = entrada.nextInt();
					entrada.nextLine();
					Metodos.introducirOfertas(conexion, entrada, nombreO, numeroO, descripcion, precio, id_local);
					break;
				case 5:
					System.out.print("Nombre: ");
					String nombreC = entrada.nextLine();
					
					System.out.print("Numero: ");
					String numeroC = entrada.nextLine();
					
					System.out.print("Descripcion: ");
					String direccion = entrada.nextLine();
					
					System.out.print("Precio: ");
					String telefono = entrada.nextLine();
					Metodos.introducirClientes(conexion, entrada, numeroC, nombreC, direccion, telefono);
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
					System.err.println("ERROR: OPCION INCORRECTA");
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
