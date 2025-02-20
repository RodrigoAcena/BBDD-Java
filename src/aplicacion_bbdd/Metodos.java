package aplicacion_bbdd;

import java.sql.*;
import java.util.Scanner;

public class Metodos {

	public static void mostrar(String tabla, Connection conexion) {
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            // Validar la tabla para evitar inyecciones SQL
            if (!tabla.equals("productos") && !tabla.equals("pedidos")) {
                System.err.println("ERROR: Tabla no válida.");
                return;
            }

            String consulta = "SELECT * FROM " + tabla;
            ps = conexion.prepareStatement(consulta);
            res = ps.executeQuery();
            ResultSetMetaData rmd = res.getMetaData();

            // Comprobar si hay resultados
            if (!res.isBeforeFirst()) {
                System.out.println("No hay datos en la tabla " + tabla + ".");
                return;
            }

            switch (tabla) {
                case "productos":
                    System.out.printf("%10s%10s%10s%10s%10s%10s%n",
                            rmd.getColumnName(1), rmd.getColumnName(2), rmd.getColumnName(3),
                            rmd.getColumnName(4), rmd.getColumnName(5), rmd.getColumnName(6));
                    
                    for (int i = 0; i < 60; i++) System.out.print("=");
                    System.out.println();
                    
                    while (res.next()) {
                        System.out.printf("%10d%10s%10s%10s%10.2f%10s%n",
                                res.getInt(1), res.getString(2), res.getString(3),
                                res.getString(4), res.getFloat(5), res.getString(6));
                    }
                    break;
                    
                case "pedidos":
                    System.out.printf("%10s%10s%10s%10s%10s%10s%10s%n",
                            rmd.getColumnName(1), rmd.getColumnName(2), rmd.getColumnName(3),
                            rmd.getColumnName(4), rmd.getColumnName(5), rmd.getColumnName(6),
                            rmd.getColumnName(7));
                    
                    for (int i = 0; i < 70; i++) System.out.print("=");
                    System.out.println();
                    
                    while (res.next()) {
                        System.out.printf("%10d%10s%10s%10s%10.2f%10d%10d%n",
                                res.getInt(1), res.getString(2), res.getString(3),
                                res.getString(4), res.getDouble(5), res.getInt(6),
                                res.getInt(7));
                    }
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
