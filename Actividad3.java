
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

class Facturacion {
    int idCliente;
    String nombre;
    double totalImportes;

    public Facturacion(int idCliente, String nombre, double totalImportes) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.totalImportes = totalImportes;
    }
    
    public String toString() {
        return "Cliente: " + nombre + " (ID: " + idCliente + "), Suma de Importes: " + totalImportes;
    }
}



public class Actividad3 {
	
	public static List<Facturacion> generarResumen_SinMap(List<Factura> facturas, List<Cliente> clientes) {
		List<Facturacion> resumen = new ArrayList<>();
		for (Cliente cliente : clientes) {
	    double total = 0;
	    	for (Factura factura : facturas) {
	    		if (factura.idCliente == cliente.idCliente) {
	    			total += factura.importe;
	    		}
	    	}
	    	resumen.add(new Facturacion(cliente.idCliente, cliente.nombre, total));
	    }
		return resumen;
	}

	public static List<Facturacion> generarResumen_ConMap(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, Double> sumaImportes = new HashMap<>();
        for (Factura factura : facturas) {
            sumaImportes.put(factura.idCliente, sumaImportes.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        List<Facturacion> resumen = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double total = sumaImportes.getOrDefault(cliente.idCliente, 0.0);
            resumen.add(new Facturacion(cliente.idCliente, cliente.nombre, total));
        }

        return resumen;
    }

	public static void Imprimir(List<Facturacion> resumen) {
			for (Facturacion r : resumen) {
				System.out.println(r.idCliente + " - " + r.nombre + " - Total: " + r.totalImportes);
			}
		}
	
		public static void main(String[] args) {
			List<Factura> facturas_1 = new ArrayList<>();
			facturas_1.add(new Factura(1, 101, 500.0));
			facturas_1.add(new Factura(2, 102, 300.0));
			facturas_1.add(new Factura(3, 101, 200.0));
			facturas_1.add(new Factura(4, 103, 400.0));
			facturas_1.add(new Factura(5, 102, 100.0));
	
			List<Cliente> clientes_1 = new ArrayList<>();
			clientes_1.add(new Cliente(101, "Facundo"));
			clientes_1.add(new Cliente(102, "Gabriel"));
			clientes_1.add(new Cliente(103, "Octavio"));
			
			List<Facturacion> resumenSinMap = generarResumen_SinMap(facturas_1, clientes_1);
			Imprimir(resumenSinMap);

		List<Factura> facturas_2 = List.of(
            new Factura(1, 104, 250.0),
            new Factura(2, 105, 100.0),
            new Factura(3, 104, 300.0),
            new Factura(4, 106, 200.0),
            new Factura(5, 105, 100.0)
        );

        List<Cliente> clientes = List.of(
            new Cliente(104, "Romina"),
            new Cliente(105, "Maria"),
            new Cliente(106, "Graciela")
        );

        List<Facturacion> resumenConMap = generarResumen_ConMap(facturas_2, clientes);
        Imprimir(resumenConMap);
	}
	
}