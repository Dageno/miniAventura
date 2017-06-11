package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Ayuda miAyuda;
	
	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Menu de Ayuda");
		setBounds(100, 100, 319, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblConcesionario = new JLabel("Butcher of Vlabiken:");
			lblConcesionario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblConcesionario.setBounds(10, 50, 108, 14);
			contentPanel.add(lblConcesionario);
		}
		{
			JLabel lblAnnadirObj = new JLabel("A\u00F1adir Objeto -> May\u00FAs+A");
			lblAnnadirObj.setBounds(65, 76, 207, 14);
			contentPanel.add(lblAnnadirObj);
		}
		{
			JLabel label = new JLabel("Eliminar Objeto -> May\u00FAs+B");
			label.setBounds(65, 101, 207, 14);
			contentPanel.add(label);
		}
		{
			JLabel lblBuscarObjeto = new JLabel("Buscar Objeto -> May\u00FAs+F");
			lblBuscarObjeto.setBounds(65, 126, 207, 14);
			contentPanel.add(lblBuscarObjeto);
		}
		{
			JLabel lblRankingPorPrecio = new JLabel("Ranking por Precio -> may\u00FAs+R");
			lblRankingPorPrecio.setBounds(65, 151, 228, 14);
			contentPanel.add(lblRankingPorPrecio);
		}
		{
			JLabel lblMostrarBaseDe = new JLabel("Mostrar Base de Datos-> Alt+A");
			lblMostrarBaseDe.setBounds(65, 176, 228, 14);
			contentPanel.add(lblMostrarBaseDe);
		}
		{
			JLabel label = new JLabel("Ficheros:");
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
			label.setBounds(10, 228, 108, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Ayuda con accesos directos");
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
			label.setBounds(65, 11, 179, 14);
			contentPanel.add(label);
		}
		{
			JLabel lblAbrirBaseDe = new JLabel("Abrir Base de Datos-> Ctrl+A");
			lblAbrirBaseDe.setBounds(65, 278, 207, 14);
			contentPanel.add(lblAbrirBaseDe);
		}
		{
			JLabel lblGuardarBaseDe = new JLabel("Guardar Base de Datos -> Ctrl+G");
			lblGuardarBaseDe.setBounds(65, 303, 207, 14);
			contentPanel.add(lblGuardarBaseDe);
		}
		{
			JLabel lblNuevaBaseDe = new JLabel("Nueva Base de Datos->  Ctrl+N");
			lblNuevaBaseDe.setBounds(65, 253, 228, 14);
			contentPanel.add(lblNuevaBaseDe);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	 public  static Ayuda getSingleton() {
		 
		 if (miAyuda==null) {
		 
			 miAyuda=new Ayuda();
		 }
		 
		 return miAyuda;
	}

}
