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
					Metodos.mostrarTodo(conexion);
					break;
				case 4:
					System.out.print("Nombre: ");
					String nombreO = entrada.nextLine();
					
					System.out.print("Numero: ");
					String numeroO = entrada.nextLine();
					
					System.out.print("Descripcion: ");
					String desOferta = entrada.nextLine();
					
					System.out.print("Precio: ");
					float precio = entrada.nextFloat();
					entrada.nextLine();
					
					System.out.print("ID_Local: ");
					int id_local = entrada.nextInt();
					entrada.nextLine();
					Metodos.introducirOfertas(conexion, entrada, nombreO, numeroO, desOferta, precio, id_local);
					break;
				case 5:
					System.out.print("Nombre: ");
					String nombreC = entrada.nextLine();
					
					System.out.print("Numero: ");
					String numeroC = entrada.nextLine();
					
					System.out.print("Descripcion: ");
					String direccion = entrada.nextLine();
					
					System.out.print("Precio: ");
					String telefonoCliente = entrada.nextLine();
					Metodos.introducirClientes(conexion, entrada, numeroC, nombreC, direccion, telefonoCliente);
					break;
				case 6:
					//empleados
					int opcion6;
					do {
						System.out.println("Datos a modificar:");
						System.out.println("\t1. DNI\r\n"
								+ "\t2. Direccion\r\n"
								+ "\t3. Telefono\r\n"
								+ "\t4. (Volver)");
						System.out.print("Opcion:");
						opcion6 = entrada.nextInt();
						entrada.nextLine();
						
						switch(opcion6) {
						case 1:
							String dato_dni = "dni";
							int num1;
							
							System.out.print("¿A quien quieres modificarle el DNI?: ");
							String nombreDNI = entrada.nextLine();
							
							do {
								System.out.print("Introduce un numero de 9 digitos: ");
								num1 = entrada.nextInt();
								entrada.nextLine();
								
								if(String.valueOf(num1).length() != 9) {
									System.err.println("El numero tiene que tener 9 digitos");
								} else {
									continue;
								}
							} while(String.valueOf(num1).length() != 9);
							
							System.out.print("Introduce la ultima letra: ");
							char letra = entrada.next().charAt(0);
							
							String dni = String.valueOf(num1)+letra;
							
							Metodos.modificarEmpleados(conexion, entrada, dato_dni, dni, nombreDNI);
						case 2:
							String dato_dir = "direccion";
							
							System.out.print("¿A quien quieres modificarle la direccion?: ");
							String nombreDIR = entrada.nextLine();
							
							System.out.print("Introduce la calle donde vive:");
							String calle = entrada.nextLine();
							
							Metodos.modificarEmpleados(conexion, entrada, dato_dir, calle, nombreDIR);
						case 3:
							String dato_tel = "telefono";
							String telefonoEmpleado;
							
							System.out.print("¿A quien quieres modificarle el numero de telefono?: ");
							String nombreTEL = entrada.nextLine();
							
							do {
								System.out.print("Introduce el numero de telefono de 9 digitos(XXX-XXX-XXX o XXX-XX-XX-XX): ");
								telefonoEmpleado = entrada.nextLine();
								
								if(telefonoEmpleado.length() != 9) {
									System.err.println("El numero tiene que tener 9 digitos");
								} else {
									continue;
								}
							} while (String.valueOf(telefonoEmpleado).length() != 9);
														
							Metodos.modificarEmpleados(conexion, entrada, dato_tel, telefonoEmpleado, nombreTEL);
						case 4:
							break;
						default:
							System.err.println("ERROR: OPCION INCORRECTA");
							System.out.println();
						}
					} while(opcion6 != 4);
					
					break;
				case 7:
					//locales
					int opcion7;
					do {
						System.out.println("Datos a modificar:");
						System.out.println("\t1. Codigo\r\n"
								+ "\t2. Direccion\r\n"
								+ "\t3. Telefono\r\n"
								+ "\t4. (Volver)");
						System.out.print("Opcion:");
						opcion7 = entrada.nextInt();
						entrada.nextLine();
						
						switch(opcion7) {
						case 1:
							String dato_cod = "codigo";
							String codigo;
							
							System.out.print("¿A quien quieres modificarle el DNI?: ");
							String nombreCodigo = entrada.nextLine();
							
							do {
								System.out.print("Introduce un numero de 5 digitos: ");
								codigo = entrada.nextLine();
								entrada.nextLine();
								
								if(codigo.length() != 5) {
									System.err.println("El numero tiene que tener 5 digitos");
								} else {
									continue;
								}
							} while(codigo.length() != 5);
							
							Metodos.modificarLocales(conexion, entrada, dato_cod, codigo, nombreCodigo);
						case 2:
							String dato_dir = "direccion";
							
							System.out.print("¿A quien quieres modificarle la direccion?: ");
							String nombreDIR = entrada.nextLine();
							
							System.out.print("Introduce la calle donde vive:");
							String calle = entrada.nextLine();
							
							Metodos.modificarLocales(conexion, entrada, dato_dir, calle, nombreDIR);
						case 3:
							String dato_tel = "telefono";
							String telefonoEmpleado;
							
							System.out.print("¿A quien quieres modificarle el numero de telefono?: ");
							String nombreTEL = entrada.nextLine();
							
							do {
								System.out.print("Introduce el numero de telefono de 9 digitos(XXX-XXX-XXX o XXX-XX-XX-XX): ");
								telefonoEmpleado = entrada.nextLine();
								
								if(telefonoEmpleado.length() != 9) {
									System.err.println("El numero tiene que tener 9 digitos");
								} else {
									continue;
								}
							} while (String.valueOf(telefonoEmpleado).length() != 9);
														
							Metodos.modificarEmpleados(conexion, entrada, dato_tel, telefonoEmpleado, nombreTEL);
						case 4:
							break;
						default:
							System.err.println("ERROR: OPCION INCORRECTA");
							System.out.println();
						}
					} while(opcion7 != 4);
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
