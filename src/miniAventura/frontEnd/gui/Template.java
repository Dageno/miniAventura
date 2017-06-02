package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import miniAventura.backEnd.clases.Drop;
import miniAventura.backEnd.clases.FinalObject;
import miniAventura.backEnd.clases.KeyObject;
import miniAventura.backEnd.clases.Potion;
import miniAventura.backEnd.clases.PrincipalObject;
import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.enums.ClassWeapon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import miniAventura.backEnd.enums.Classes;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import miniAventura.backEnd.enums.PotionType;
import miniAventura.backEnd.excepciones.ItemExistsException;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoMaterialSelectedException;
import miniAventura.backEnd.excepciones.NoNameValidException;
import miniAventura.backEnd.interfaces.Valorable;
import miniAventura.backEnd.enums.PotionContainer;
import miniAventura.backEnd.enums.Crystal;
import miniAventura.backEnd.enums.Material;
import javax.swing.border.EtchedBorder;

public class Template extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * JLabels
	 */
	JLabel lblPrecioDelObjeto = new JLabel("Precio del Objeto: ");
	JLabel lblSeleccionarObjeto = new JLabel("Seleccionar Objeto: ");
	JLabel lblNombre = new JLabel("Nombre: ");
	JLabel lblTipoDeArma = new JLabel("Tipo de arma: ");
	JLabel lblDescripcinDelObjeto = new JLabel("Descripci\u00F3n del objeto: ");
	final JLabel lblesteObjetoEs = new JLabel("\u00A1Este objeto es especial y solo debes darle a a\u00F1adir!");
	final JLabel lblTipoDePocion = new JLabel("Tipo de Pocion");
	final JLabel lblTipoDeContenedor = new JLabel("Tipo de contenedor: ");
	final JLabel lblTipoDeCristal = new JLabel("Tipo de cristal: ");

	/**
	 * JText utilizados
	 */
	JTextField name;
	JTextField precio = new JTextField();
	JTextArea description = new JTextArea();

	/**
	 * Paneles de botones y propios botones
	 */
	JPanel panel = new JPanel();
	final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton wood = new JRadioButton("Madera");
	JRadioButton iron = new JRadioButton("Hierro");
	JRadioButton steel = new JRadioButton("Acero");
	JButton search = new JButton("Buscar");
	JButton okButton = new JButton("A\u00F1adir");
	JButton atras = new JButton("<");
	JButton adelante = new JButton(">");
	JButton cancelButton = new JButton("Salir");
	JPanel buttonPane = new JPanel();

	/**
	 * JComboBox usados
	 */
	final JComboBox<PotionType> potionType = new JComboBox<PotionType>();
	final JComboBox<PotionContainer> potionContainer = new JComboBox<PotionContainer>();
	final JComboBox<Crystal> crystal = new JComboBox<Crystal>();
	JComboBox<String> classObject = new JComboBox<String>();
	JComboBox<String> classWeapon = new JComboBox<String>();

	/**
	 * Drop envoltorio
	 */
	public static Drop dataBase = new Drop();

	/**
	 * Iteradores
	 */
	ListIterator<PrincipalObject> rank;
	ListIterator<Valorable> rankIterator;

	/**
	 * Intancias de objetos
	 */
	Weapon weapon;
	Potion potion;
	KeyObject keyObj;
	PrincipalObject object;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Template dialog = new Template();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Template() {

		medidas();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		contentPanel.setBorder(backGroundImage());
		{

			lblSeleccionarObjeto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblSeleccionarObjeto.setForeground(Color.WHITE);
			lblSeleccionarObjeto.setBounds(180, 20, 130, 14);
			contentPanel.add(lblSeleccionarObjeto);
		}

		lblPrecioDelObjeto.setForeground(Color.WHITE);
		lblPrecioDelObjeto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPrecioDelObjeto.setBounds(180, 20, 143, 14);
		contentPanel.add(lblPrecioDelObjeto);

		precio.setBounds(304, 17, 121, 20);
		contentPanel.add(precio);
		precio.setColumns(10);

		/**
		 * Cambio de aspecto de menu segun la clase del objeto
		 */
		classObject.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				name.setEnabled(true);
				description.setEnabled(true);
				allInvisible();
				cleanFieldsAdd();
				switch (classObject.getSelectedItem().toString()) {
				case "Armas":
					menuWeapon();
					break;
				case "Pociones":
					menuPotion();
					break;
				case "Objetos Clave":
					menuKeyObject();
					break;
				default:
					menuFinalObject();
					break;
				}
			}
		});
		classObject.setModel(new DefaultComboBoxModel<String>(Classes.getOpciones()));
		classObject.setBounds(306, 17, 122, 20);

		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNombre.setBounds(145, 70, 75, 14);

		name = new JTextField();
		name.setBounds(214, 67, 140, 20);
		name.setColumns(10);

		lblTipoDeArma.setForeground(Color.WHITE);
		lblTipoDeArma.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTipoDeArma.setBounds(88, 135, 96, 14);

		classWeapon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (classWeapon.getSelectedItem() == "Manos desnudas") {
					allInvisible();
					classWeapon.setVisible(true);
					lblTipoDeArma.setVisible(true);
					

				} else {
					menuWeapon();

				}
			}
		});
		classWeapon.setModel(new DefaultComboBoxModel<String>(ClassWeapon.getOpciones()));

		classWeapon.setBounds(194, 132, 150, 20);
		classWeapon.setVisible(true);
		lblDescripcinDelObjeto.setForeground(Color.WHITE);
		lblDescripcinDelObjeto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDescripcinDelObjeto.setBounds(149, 237, 210, 14);

		description.setBounds(157, 262, 263, 79);

		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Material del objeto",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(73, 180, 312, 46);
		panel.setForeground(new Color(255, 255, 255));
		panel.setOpaque(false);
		wood.setOpaque(false);
		iron.setOpaque(false);
		steel.setOpaque(false);
		contentPanel.add(panel);

		panel.setLayout(null);

		wood.setBounds(22, 16, 74, 23);
		wood.setForeground(new Color(255, 255, 255));
		panel.add(wood);
		buttonGroup.add(wood);

		iron.setBounds(114, 16, 74, 23);
		iron.setForeground(new Color(255, 255, 255));
		panel.add(iron);
		buttonGroup.add(iron);

		steel.setBounds(200, 16, 65, 23);
		steel.setForeground(new Color(255, 255, 255));
		panel.add(steel);
		buttonGroup.add(steel);
		;

		search.setBounds(360, 66, 113, 23);

		/**
		 * Busca el objeto segun su clase y su nombre
		 */
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					switch (classObject.getSelectedItem().toString()) {
					case "Armas":
						object = dataBase.getWeapon(name.getText());
						searchObject((Weapon)object);
						
						break;
					case "Pociones":
						object = dataBase.getPotion(name.getText());
						searchObject((Potion) object);
						
						break;
					case "Objetos Clave":

						object = dataBase.getKeyObject(name.getText());
						searchObject((KeyObject) object);
						
						break;
					}

				} catch (ItemNoExistsException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					cleanFieldsAdd();
				}

			}

		});
		lblTipoDePocion.setForeground(Color.WHITE);
		lblTipoDePocion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTipoDePocion.setBounds(102, 135, 118, 14);

		potionType.setModel(new DefaultComboBoxModel<PotionType>(PotionType.values()));
		potionType.setBounds(194, 132, 133, 20);

		lblTipoDeContenedor.setBounds(88, 197, 132, 14);
		lblTipoDeContenedor.setForeground(Color.WHITE);
		lblTipoDeContenedor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		potionContainer.setBounds(207, 194, 120, 20);
		potionContainer.setModel(new DefaultComboBoxModel<PotionContainer>(PotionContainer.values()));
		lblTipoDeCristal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTipoDeCristal.setForeground(Color.WHITE);
		lblTipoDeCristal.setBounds(125, 135, 102, 14);

		crystal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				actualizarKeyObject();
			}
		});
		crystal.setModel(new DefaultComboBoxModel<Crystal>(Crystal.values()));
		crystal.removeItem(Crystal.YELLOW);
		crystal.setBounds(230, 132, 102, 20);

		lblesteObjetoEs.setForeground(Color.WHITE);
		lblesteObjetoEs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblesteObjetoEs.setBounds(112, 84, 391, 142);

		allInvisible();
		menuWeapon();

		{

			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

			}
			{
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

	/**
	 * Crea el Objeto final del juego
	 */
	protected void makeFinalObject() {
		try {
			dataBase.addObject(new FinalObject());
		} catch (ItemExistsException | NoNameValidException | NoDescriptionValidException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Crea objetos clave del juego
	 */

	protected void makeKeyObject() {
		try {
			KeyObject kObject = new KeyObject(name.getText(), description.getText(),
					(Crystal) crystal.getSelectedItem());
			
			dataBase.addObject(kObject);
		} catch (ItemExistsException | NoNameValidException | NoDescriptionValidException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Crea pociones
	 */

	protected void makePotion() {
		try {
			Potion potion = new Potion(name.getText(), description.getText(), (PotionType) potionType.getSelectedItem(),
					(PotionContainer) potionContainer.getSelectedItem());
			dataBase.addObject(potion);
		} catch (ItemExistsException | NoNameValidException | NoDescriptionValidException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Forja armas
	 */
	protected void forgeWeapon() {

		try {
			if(getClassWeapon() == ClassWeapon.FIST)
				weapon = new Weapon("Manos desnudas", "Manos desnudas",
						getClassWeapon(), getMaterial());
			else
				weapon = new Weapon(name.getText(), description.getText(),
						getClassWeapon(), getMaterial());
			dataBase.addObject(weapon);
		} catch (ItemExistsException | NoNameValidException | NoMaterialSelectedException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NoDescriptionValidException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private ClassWeapon getClassWeapon() {
		switch (classWeapon.getSelectedItem().toString()) {
		case "Espada de una mano":
			return ClassWeapon.SWORD_ONE_HANDED;
		case "Arco de dos manos":
			return ClassWeapon.BOW_TWO_HANDED;
		case "Hacha de una mano":
			return ClassWeapon.AXE_ONE_HANDED;
		default:
			return ClassWeapon.FIST;
		}
	}

	/**
	 * Obtiene el material seleccionado
	 * 
	 * @return
	 * @throws NoMaterialSelectedException
	 */
	private Material getMaterial() throws NoMaterialSelectedException {
		if (wood.isSelected())
			return Material.WOOD;
		else if (iron.isSelected())
			return Material.IRON;
		else if (steel.isSelected())
			return Material.STEEL;
		throw new NoMaterialSelectedException("Debe elegir un material");
	}

	protected void menuFinalObject() {
		allInvisible();
		lblesteObjetoEs.setVisible(true);
		search.setVisible(false);

	}

	protected void menuKeyObject() {

		lblNombre.setVisible(true);
		lblDescripcinDelObjeto.setVisible(true);
		lblTipoDeCristal.setVisible(true);
		name.setVisible(true);
		name.setEnabled(false);
		description.setVisible(true);
		description.setEnabled(false);
		actualizarKeyObject();
		crystal.setVisible(true);
	}

	private void actualizarKeyObject() {

		description.setText(
				getCrystal() + " tremendamente poderoso \n en conjunto a otros cristales, pero solo... \n No es nada.");
		name.setText(getCrystal() + " de poder.");

	}

	private void actualizarKeyObject(KeyObject keyObj) {

		description.setText(
				getCrystal() + " tremendamente poderoso \n en conjunto a otros cristales, pero solo... \n No es nada.");
		name.setText(getCrystal() + " de poder.");
		crystal.setSelectedItem(keyObj.getCrystal());

	}

	private String getCrystal() {
		switch (crystal.getSelectedItem().toString()) {
		case "RED":
			return "Cristal Rojo";
		case "GREEN":
			return "Cristal Verde";
		case "BLUE":
			return "Cristal Azul";
		default:
			return "Cristal Amarillo";
		}

	}

	protected void menuPotion() {

		lblNombre.setVisible(true);
		lblDescripcinDelObjeto.setVisible(true);
		name.setVisible(true);
		description.setVisible(true);
		lblTipoDePocion.setVisible(true);
		lblTipoDeContenedor.setVisible(true);
		potionContainer.setVisible(true);
		potionType.setVisible(true);

	}

	protected void menuWeapon() {

		lblNombre.setVisible(true);
		lblTipoDeArma.setVisible(true);
		lblDescripcinDelObjeto.setVisible(true);
		name.setVisible(true);
		classWeapon.setVisible(true);
		description.setVisible(true);
		panel.setVisible(true);

	}

	protected void menuWeaponRanking() {
		allInvisible();
		lblPrecioDelObjeto.setVisible(true);
		precio.setVisible(true);
		menuWeapon();
	}

	protected void allInvisible() {

		lblNombre.setVisible(false);
		lblTipoDeArma.setVisible(false);
		lblDescripcinDelObjeto.setVisible(false);
		name.setVisible(false);
		classWeapon.setVisible(false);
		description.setVisible(false);
		panel.setVisible(false);
		potionContainer.setVisible(false);
		potionType.setVisible(false);
		lblTipoDePocion.setVisible(false);
		lblTipoDeContenedor.setVisible(false);
		crystal.setVisible(false);
		lblTipoDeCristal.setVisible(false);
		lblesteObjetoEs.setVisible(false);

	}

	protected void medidas() {
		setBounds(550, 200, 700, 440);

	}

	protected PanelImage backGroundImage() {
		try {
			BufferedImage image = null;
			image = ImageIO.read(new File(getClass().getResource("/miniAventura/frontEnd/images/2.jpg").getFile()));
			return new PanelImage(image);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	void cleanFieldsAdd() {
		name.setText("");
		buttonGroup.clearSelection();
		description.setText("");
		

	}

	protected void searchObject(Weapon weapon) {
		name.setText(weapon.getName());
		seleccionarMaterial(weapon.getMaterial());
		description.setText(weapon.getDescription());
		classWeapon.setSelectedItem(weapon.getClassWeapon().getName());
		precio.setText(Integer.toString(weapon.getPrice()));

	}

	protected void searchObject(Potion potion) {
		name.setText(potion.getName());
		potionContainer.setSelectedItem(potion.getContainer());
		potionType.setSelectedItem(potion.getPotionType());
		description.setText(potion.getDescription());
		precio.setText(Integer.toString(potion.getPrice()));

	}

	protected void searchObject(KeyObject keyObj) {
		if (keyObj instanceof FinalObject)
			actualizarFinalObject(keyObj);
		else
			actualizarKeyObject(keyObj);

	}

	private void actualizarFinalObject(KeyObject keyObj2) {

		crystal.setModel(new DefaultComboBoxModel<Crystal>(Crystal.values()));
		crystal.setSelectedIndex(3);
		description.setText(
				getCrystal() + " tremendamente poderoso \n en conjunto a otros cristales, pero solo... \n No es nada.");
		name.setText(getCrystal() + " de poder.");

	}

	protected void allDisable() {
		precio.setEnabled(false);
		name.setEnabled(false);
		description.setEnabled(false);
		potionType.setEnabled(false);
		potionContainer.setEnabled(false);
		crystal.setEnabled(false);
		classWeapon.setEnabled(false);
		wood.setEnabled(false);
		iron.setEnabled(false);
		steel.setEnabled(false);
	}

	protected void seleccionarMaterial(Material material) {

		switch (material) {
		case WOOD:
			wood.setSelected(true);
			break;
		case IRON:
			iron.setSelected(true);
			break;
		case STEEL:
			steel.setSelected(true);
			break;

		}

	}

	protected void mostrarDatabaseRanking(Valorable next) {
		if (next instanceof Weapon) {
			menuWeaponRanking();
			searchObject((Weapon) next);
		} else if (next instanceof Potion) {
			menuPotionRanking();
			searchObject((Potion) next);
		}

	}

	private void menuPotionRanking() {
		allInvisible();
		lblPrecioDelObjeto.setVisible(true);
		precio.setVisible(true);
		menuPotion();

	}

	protected void mostrarDatabase(PrincipalObject object) {
		allInvisible();
		if (object instanceof Weapon) {
			menuWeapon();
			searchObject((Weapon) object);
		} else if (object instanceof Potion) {
			menuPotion();
			searchObject((Potion) object);
		} else if (object instanceof KeyObject) {
			menuKeyObject();
			searchObject((KeyObject) object);
		}

	}

	protected void siguienteObject() {
		if (rank.hasNext()) {
			object = rank.next();
			if (object.getName().equals(name.getText()) && rank.hasNext())
				object = rank.next();

			mostrarDatabase(object);

		}

		if (!rank.hasNext())
			adelante.setEnabled(false);
		else
			adelante.setEnabled(true);
		if (!rank.hasPrevious())
			atras.setEnabled(false);
		else
			atras.setEnabled(true);

	}

	protected void anteriorObject(){
		if (rank.hasPrevious()) {
			object = rank.previous();
			if (object.getName().equals(name.getText()) && rank.hasPrevious())
				object = rank.previous();

			mostrarDatabase(object);

		}
		if (!rank.hasNext())
			adelante.setEnabled(false);
		else
			adelante.setEnabled(true);
		if (!rank.hasPrevious())
			atras.setEnabled(false);
		else
			atras.setEnabled(true);
	}
}
