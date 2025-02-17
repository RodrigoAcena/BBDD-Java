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
			String consulta = "INSERT INTO ofertas (id, nombre, numero, descripcion, precio, id_local)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(consulta);
            res = ps.executeQuery();
            
            do {
            	ps.setString(2, nombre);
                ps.setString(3, numero);
                ps.setString(4, des);
                ps.setFloat(5, precio);
                ps.setInt(6, local);
                
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
			String consulta = "INSERT INTO clientes (id, numero, nombre, direccion, telefono)"
					+ " VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(consulta);
            res = ps.executeQuery();
            
            do {
            	ps.setString(2, numero);
                ps.setString(3, nombre);
                ps.setString(4, dir);
                ps.setString(5, telefono);
                
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

	public static void modificarEmpleados() {
		
	}
	
	public static void modificarLocales() {
		
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
