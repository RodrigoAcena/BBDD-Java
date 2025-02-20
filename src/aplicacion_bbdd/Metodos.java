package aplicacion_bbdd;

import java.sql.*;
import java.util.Scanner;

public class Metodos {

	public static void mostrar(String tabla, Connection conexion) {
        PreparedStatement ps = null;
        ResultSet res = null;

        
            // Validar la tabla para evitar inyecciones SQL
        if (!tabla.equals("productos") && !tabla.equals("pedidos")) {
            System.err.println("ERROR: Tabla no válida. Debe ser 'productos' o 'pedidos'.");
            return;
        }
           

            String consulta = "SELECT * FROM " + tabla;
            
            try {
            	ps = conexion.prepareStatement(consulta);
                res = ps.executeQuery();    
            	ResultSetMetaData rmd = res.getMetaData();

                    // Comprobar si hay resultados
                    if (!res.isBeforeFirst()) {
                        System.out.println("No hay datos en la tabla " + tabla + ".");
                        return;
                    }

                    // Imprimir encabezados dinámicos
                    int columnCount = rmd.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-15s", rmd.getColumnName(i));
                    }
                    System.out.println();

                    // Línea divisoria
                    for (int i = 0; i < columnCount * 15; i++) {
                        System.out.print("=");
                    }
                    System.out.println();

                    // Imprimir datos dinámicos
                    while (res.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-15s", res.getObject(i));
                        }
                        System.out.println();
                    }

                } catch (SQLException e) {
                    System.err.println("Error al mostrar datos de la tabla '" + tabla + "': " + e.getMessage());
                }
            }
        
	public static void introducirOfertas(Connection conexion, Scanner entrada, String nombre, String numero, String des, float precio, int local) {
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			boolean continuar = false;
			String consulta = "INSERT INTO ofertas (nombre, numero, descripcion, precio, id_local)"
					+ " VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(consulta);
            res = ps.executeQuery();
            
            do {
            	ps.setString(1, nombre);
                ps.setString(2, numero);
                ps.setString(3, des);
                ps.setFloat(4, precio);
                ps.setInt(5, local);
                
                continuar = sN(entrada);
    			ps.clearParameters();
            } while(continuar);
            
        } catch (SQLException e) {
            System.err.println("Error al mostrar datos: " + e.getMessage());
        } finally {
            try {
                if (res != null) res.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
	}
	
	public static void introducirClientes(Connection conexion, Scanner entrada, String numero, String nombre, String dir, String telefono) {
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			boolean continuar = false;
			String consulta = "INSERT INTO clientes (numero, nombre, direccion, telefono)"
					+ " VALUES (?, ?, ?, ?)";
            ps = conexion.prepareStatement(consulta);
            res = ps.executeQuery();
            
            do {
            	ps.setString(1, numero);
                ps.setString(2, nombre);
                ps.setString(3, dir);
                ps.setString(4, telefono);
                
                continuar = sN(entrada);
    			ps.clearParameters();
            } while(continuar);
            
        } catch (SQLException e) {
            System.err.println("Error al mostrar datos: " + e.getMessage());
        } finally {
            try {
                if (res != null) res.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
	}

	public static void modificarEmpleados(Connection conexion, Scanner entrada, String dato, String cambio, String nombre) {
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			boolean continuar = false;
			
			switch(dato) {
			case "dni":
				String consultaDNI_Empleado = "UPDATE empleados SET"
						+ " dni=\'cambio\'"
						+ "WHERE nombre=\'nombre\'";
	            ps = conexion.prepareStatement(consultaDNI_Empleado);
	            res = ps.executeQuery();
	            
	            do {
	            	continuar = sN(entrada);
	            } while(continuar);
				break;
			case "direccion":
				String consultaDIR_Empleado = "UPDATE empleados SET"
						+ " direccion=\'cambio\'"
						+ "WHERE nombre=\'nombre\'";
	            ps = conexion.prepareStatement(consultaDIR_Empleado);
	            res = ps.executeQuery();
	            
	            do {
	            	continuar = sN(entrada);
	            } while(continuar);
				break;
			case "telefono":
				String consultaTEL_Empleado = "UPDATE empleados SET"
						+ " telefono=\'cambio\'"
						+ "WHERE nombre=\'nombre\'";
	            ps = conexion.prepareStatement(consultaTEL_Empleado);
	            res = ps.executeQuery();
	            
	            do {
	            	continuar = sN(entrada);
	            } while(continuar);
				break;
			}
            
            
        } catch (SQLException e) {
            System.err.println("Error al mostrar datos: " + e.getMessage());
        } finally {
            try {
                if (res != null) res.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
	}
	
	public static void modificarLocales(Connection conexion, Scanner entrada, String dato, String cambio, String nombre) {
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			boolean continuar = false;
			
			switch(dato) {
			case "codigo":
				String consultaCOD_Local = "UPDATE locales SET"
						+ " codigo=\'cambio\'"
						+ "WHERE nombre=\'nombre\'";
	            ps = conexion.prepareStatement(consultaCOD_Local);
	            res = ps.executeQuery();
	            
	            do {
	            	continuar = sN(entrada);
	            } while(continuar);
				break;
			case "direccion":
				String consultaDIR_Local = "UPDATE locales SET"
						+ " direccion=\'cambio\'"
						+ "WHERE nombre=\'nombre\'";
	            ps = conexion.prepareStatement(consultaDIR_Local);
	            res = ps.executeQuery();
	            
	            do {
	            	continuar = sN(entrada);
	            } while(continuar);
				break;
			case "telefono":
				String consultaTEL_Local = "UPDATE locales SET"
						+ " telefono=\'cambio\'"
						+ "WHERE nombre=\'nombre\'";
	            ps = conexion.prepareStatement(consultaTEL_Local);
	            res = ps.executeQuery();
	            
	            do {
	            	continuar = sN(entrada);
	            } while(continuar);
				break;
			}
            
            
        } catch (SQLException e) {
            System.err.println("Error al mostrar datos: " + e.getMessage());
        } finally {
            try {
                if (res != null) res.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
	}

	public static void eliminarEmpleados() {
		
	}
	
	public static void eliminarLocales() {
		
	}
	
	static boolean sN(Scanner entrada) {
		System.out.print("¿Quieres modificar mas datos?[s/n]: ");
		return entrada.nextLine().toLowerCase().startsWith("s");
	}
}
