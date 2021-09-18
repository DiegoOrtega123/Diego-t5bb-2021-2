package Usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Categoria;
import models.Productos;
import models.Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import models.Productos;
import javax.swing.JTable;
import java.awt.Color;

public class FrmManteProd1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd1 frame = new FrmManteProd1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd1() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(324, 29, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnListado = new JButton("Listado");
		btnListado.setBounds(177, 322, 89, 23);
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(122, 42, 144, 20);
		txtDescripcion.setColumns(10);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setBounds(122, 103, 77, 20);
		txtStock.setColumns(10);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(122, 131, 77, 20);
		txtPrecio.setColumns(10);
		contentPane.add(txtPrecio);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 174, 414, 132);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 414, 132);
		contentPane.add(scrollPane);
		//determinar columnas					
		llenaCombo();
	}

	void llenaCombo() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		 // listado de todos los usuarios
List<Categoria> lstCategoria = em.createQuery("Select u from Categoria u", Categoria.class).getResultList();
			for (Categoria u : lstCategoria) 
				cboCategorias.addItem(u.getDescripcion());
			}

	
	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		List<Productos> lstUsuarios2 = em.createQuery("Select p from Productos p", Productos.class).getResultList();
		System.out.println("Cantidad de Productos : " + lstUsuarios2.size());
		if (lstUsuarios2.size() == 0) {
			System.out.println("Listado vacío");
		} else {
			System.out.println("-- Listado de Productos --");
			for (Productos p : lstUsuarios2) {
				System.out.println(">>> " + p);
				
				

			}

		}
	}
	
	void registrar() {
		// Especificar BD CONECTION
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				// Obtener el DAO
				EntityManager em = fabrica.createEntityManager();
				// Procesos: register new Producto
				Productos p = new Productos ();
				p.setIdprod("P0032");
				p.setDescripcion("Almuerzo");
				p.setStock(4);
				p.setPrecio(12);
				p.setIdcategoria(2);
				p.setEstado(1);
				
				// reg, act, elim -> Transacciones
				em.getTransaction().begin();
				em.persist(p); //registar
				em.getTransaction().commit();
				System.out.println("REGISTRO DE PRODUCTO OK");
				em.close();
				
			}

	}

