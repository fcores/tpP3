
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
		List<Facturacion> resumen = new ArrayList<>(); //1
		for (Cliente cliente : clientes) { //1 + 2(n+1) + n = 3n + 3 
	    double total = 0;
	    	for (Factura factura : facturas) { //1 + 2(n+1) + n = 3n + 3 
	    		if (factura.idCliente == cliente.idCliente) { //1
	    			total += factura.importe; //2n
	    		}
	    	}
	    	resumen.add(new Facturacion(cliente.idCliente, cliente.nombre, total)); //1
	    }
		return resumen;//1

        //f(n) = 1 + 3 + 3n + n ( 3 + 3n + 1 + 2n ) + 1 + 1 = 5 + 3n + n (4 + 5n )
        //f(n) = 5 + 3n + 4n + 5n^2 = 5 + 7n + 5 n^2
        //demostracion
        // 5 + 7n + 5 n^2 <= c x n^2
        // 5/n^2 + 7/n + 5 <= c
        // si n =1
        // 5 + 7 + 5 <= c
        // c = 17
        // f(n) = 5 + 7n + 5 n^2 pertenece a O(n´2) para c= 17 y n0=1
	}

	public static List<Facturacion> generarResumen_ConMap(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, Double> sumaImportes = new HashMap<>(); //1
        for (Factura factura : facturas) {//1 + 2(n+1) + n = 3n + 3 
            sumaImportes.put(factura.idCliente, sumaImportes.getOrDefault(factura.idCliente, 0.0) + factura.importe); //1
        }

        Map<Integer, Cliente> clientesMap = new HashMap<>(); //1
        for (Cliente cliente : clientes) {//1 + 2(n+1) + n = 3n + 3 
            clientesMap.put(cliente.idCliente, cliente);//1
        }

        List<Facturacion> resumen = new ArrayList<>();
        for (Map.Entry<Integer, Cliente> entry : clientesMap.entrySet()) {//1 + 2(n+1) + n = 3n + 3 
            Cliente cliente = entry.getValue(); //1
            double total = sumaImportes.getOrDefault(cliente.idCliente, 0.0); //1
            resumen.add(new Facturacion(cliente.idCliente, cliente.nombre, total)); //1
        }

        return resumen; //1
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

	    List<Factura> facturas_2 = new ArrayList<>();
        facturas_2.add(new Factura(1, 104, 250.0));
        facturas_2.add(new Factura(2, 105, 100.0));
        facturas_2.add(new Factura(3, 104, 300.0));
        facturas_2.add(new Factura(4, 106, 200.0));
        facturas_2.add(new Factura(5, 105, 100.0));

        List<Cliente> clientes_2 = new ArrayList<>();
        clientes_2.add(new Cliente(104, "Romina"));
        clientes_2.add(new Cliente(105, "Maria"));
        clientes_2.add(new Cliente(106, "Graciela"));

        List<Facturacion> resumenConMap = generarResumen_ConMap(facturas_2, clientes_2);
        Imprimir(resumenConMap);
	}
	
}