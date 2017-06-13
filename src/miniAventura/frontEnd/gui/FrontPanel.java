package miniAventura.frontEnd.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;

import miniAventura.backEnd.clases.Drop;
import miniAventura.backEnd.clases.Gestion;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


public class FrontPanel{

	JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPanel window = new FrontPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public FrontPanel() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setTitle("DataBase Butcher of Vlabiken");
		frame.setBounds(550, 200, 700, 440);
	
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (Gestion.getModificado()) {
					if (Gestion.deseaGuardar("Se han hecho modificaciones, Desea guardar los cambios ? (y/n)")) {
						if (Gestion.getFile() == null)
							try {
								Gestion.guardarComo(Template.dataBase);
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(frame, "Se ha producido un error al guardar el archivo.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						else
							try {
								Gestion.guardar(Template.dataBase);
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(frame, "Se ha producido un error al guardar el archivo.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
					}
				}
			}
		});
		
		try {
			BufferedImage image = null;
			image = ImageIO.read(new File(getClass().getResource("/miniAventura/frontEnd/images/1.jpg").getFile()));	
			PanelImage backGround = new PanelImage(image);
			((JComponent) frame.getContentPane()).setBorder(backGround);
			frame.getContentPane().setLayout(null);
		} catch (IOException e) {
			
		}
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('a');
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.setMnemonic('n');
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				try {
					Gestion.nuevo(Template.dataBase);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "No se encuentra el archivo.", "Error",
							JOptionPane.ERROR_MESSAGE);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrirBaseDe = new JMenuItem("Abrir Base de Datos");
		mntmAbrirBaseDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrirBaseDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Template.dataBase = Gestion.abrir(Template.dataBase);
					

				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(frame,
							"El fichero no contiene ningún concesionario.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnArchivo.add(mntmAbrirBaseDe);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gestion.guardar(Template.dataBase);
					JOptionPane.showMessageDialog(frame, "Se ha guardado el archivo con éxito.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Gestion.guardarComo(Template.dataBase);
					
					JOptionPane.showMessageDialog(frame, "Se ha guardado el archivo con éxito.");
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(frame, "No se encuentra el archivo.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Acceso cancelado por el usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnArchivo.add(mntmGuardarComo);
		 mnArchivo.add(new JSeparator());
		 
		 JMenuItem mntmSalir = new JMenuItem("Salir");
		 mntmSalir.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		frame.dispose();
		 	}
		 });
		 mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
		mnAdministracin.setMnemonic('d');
		menuBar.add(mnAdministracin);
		
		JMenuItem mntmAadirObjeto = new JMenuItem("A\u00F1adir objeto");
		mntmAadirObjeto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mntmAadirObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpBase up = new UpBase();
				up.setModal(true);
				up.setVisible(true);
			}
		});
		mnAdministracin.add(mntmAadirObjeto);
		
		JMenuItem mntmEliminarObjeto = new JMenuItem("Eliminar objeto");
		mntmEliminarObjeto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
		mntmEliminarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Template.dataBase.isEmpty())
					JOptionPane.showMessageDialog(frame, "La base de datos está vacía", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					DownBase dBase = new DownBase();
					dBase.setModal(true);
					dBase.setVisible(true);
				}
				
			}
		});
		mnAdministracin.add(mntmEliminarObjeto);
		
		JMenuItem mntmBuscarObjeto = new JMenuItem("Buscar Objeto");
		mntmBuscarObjeto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
		mntmBuscarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Template.dataBase.isEmpty())
					JOptionPane.showMessageDialog(frame, "La base de datos está vacía", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					searchObject search = new searchObject();
					search.setModal(true);
					search.setVisible(true);
				}
			}
		});
		mnAdministracin.add(mntmBuscarObjeto);
		mnAdministracin.add(new JSeparator());
		
		JMenuItem mntmRankingPorPrecio = new JMenuItem("Ranking por precio");
		mntmRankingPorPrecio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		mntmRankingPorPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Template.dataBase.isEmpty())
					JOptionPane.showMessageDialog(frame, "La base de datos está vacía", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					rankingPrice ranking;
					try {
						ranking = new rankingPrice();
						ranking.setModal(true);
						ranking.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "No hay objetos para hacer ranking", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		mnAdministracin.add(mntmRankingPorPrecio);
		
		JMenu mnInventario = new JMenu("Inventario");
		mnInventario.setMnemonic('i');
		menuBar.add(mnInventario);
		
		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_MASK));
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Template.dataBase.isEmpty())
					JOptionPane.showMessageDialog(frame, "La base de datos está vacía", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					try {
						AnnadirInventario annadir = new AnnadirInventario();
						annadir.setModal(true);
						annadir.setVisible(true);
					} catch (ItemNoExistsException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		mnInventario.add(mntmAadir);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mntmBorrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.SHIFT_MASK));
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Drop.inventario.allObjects.isEmpty())
					JOptionPane.showMessageDialog(frame, "El inventario esta vacío", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					try {
						BorrarInventario borrar = new BorrarInventario();
						borrar.setModal(true);
						borrar.setVisible(true);
					} catch (ItemNoExistsException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		mnInventario.add(mntmBorrar);
		
		JMenuItem mntmMostrarInventario = new JMenuItem("Mostrar inventario");
		mntmMostrarInventario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.SHIFT_MASK));
		mntmMostrarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Drop.inventario.allObjects.isEmpty())
					JOptionPane.showMessageDialog(frame, "El inventario esta vacío", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					try {
						MostrarInventario showInv = new MostrarInventario();
						showInv.setModal(true);
						showInv.setVisible(true);
					} catch (ItemNoExistsException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		mnInventario.add(mntmMostrarInventario);
		
		
		JMenu mnBaseDeDatos = new JMenu("Base de Datos");
		mnBaseDeDatos.setMnemonic('b');
		menuBar.add(mnBaseDeDatos);
		
		JMenuItem mntmMostrarBaseDe = new JMenuItem("Mostrar base de datos");
		mntmMostrarBaseDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_GRAPH_MASK));
		mntmMostrarBaseDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Template.dataBase.isEmpty())
					JOptionPane.showMessageDialog(frame, "La base de datos está vacía", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					MostrarBase dataBase;
					try {
			
						dataBase = new MostrarBase();
						dataBase.setModal(true);
						dataBase.setVisible(true);
					} catch (ItemNoExistsException e1) {
						
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			}
		});
		mnBaseDeDatos.add(mntmMostrarBaseDe);
		
		JMenuItem mntmMostrarPorClase = new JMenuItem("Mostrar por Clase");
		mntmMostrarPorClase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_GRAPH_MASK));
		mntmMostrarPorClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Template.dataBase.isEmpty())
					JOptionPane.showMessageDialog(frame, "La base de datos está vacía", "Error",
							JOptionPane.ERROR_MESSAGE);
				else{
					MostrarPorClase mostrarClase;
					try {
			
						mostrarClase = new MostrarPorClase();
						mostrarClase.setModal(true);
						mostrarClase.setVisible(true);
					} catch (ItemNoExistsException e1) {
						
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		mnBaseDeDatos.add(mntmMostrarPorClase);
		// EN DESARROLLO //
//		JMenuItem mntmMostrarLogs = new JMenuItem("Mostrar logs");
//		mnBaseDeDatos.add(mntmMostrarLogs);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('u');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmManualDeUso = new JMenuItem("Manual de uso");
		mntmManualDeUso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmManualDeUso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Ayuda ayuda = Ayuda.getSingleton();
					ayuda.setVisible(true);
					
				
			}
		});
		mnAyuda.add(mntmManualDeUso);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setModal(true);
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);

		
	}
	
	
}
