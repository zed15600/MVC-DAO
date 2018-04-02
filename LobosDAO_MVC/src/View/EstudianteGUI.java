package View;

import Controller.*;
import Model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class EstudianteGUI extends JFrame implements ActionListener{
	JLabel lblTitulo;
	JLabel lblCodigo;
	JLabel lblNombre;
	JLabel lblCorreo;
	JLabel lblTelefono;
	JLabel lblDireccion;
	JLabel lblCedula;
	JTextField txtCodigo;
	JTextField txtNombre;
	JTextField txtCorreo;
	JTextField txtTelefono;
	JTextField txtDireccion;
	JTextField txtCedula;
	JButton btnAsignarCarrera;
	JButton btnCreate;
	JButton btnRead;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnExist;
	JButton btnList;
	JButton btnProfesores;
	JButton btnCarreras;
	DefaultTableModel dataModel;
	Object[] cols;
	JTable tblDatos;
	JPanel pnlDatos;
	JScrollPane scrllPnlDatos;
	Font etiquetas = new Font("Arial", Font.BOLD, 25);
	int aligDerecha = SwingConstants.RIGHT;
	EstudianteController estCont = new EstudianteController();
	
	
	public EstudianteGUI(){
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(800, 600);
		setTitle("Estudientes");
		setLocationRelativeTo(this);
		setResizable(false);
		lblTitulo = new JLabel("Estudiantes");
		lblTitulo.setBounds(1, 1, 792, 40);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo);
		lblCodigo = new JLabel("Código de Estudiante");
		lblCodigo.setBounds(1, 62, 396, 25);
		lblCodigo.setFont(etiquetas);
		lblCodigo.setHorizontalAlignment(aligDerecha);
		add(lblCodigo);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(398, 62, 200, 25);
		add(txtCodigo);
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(1, 88, 396, 25);
		lblNombre.setFont(etiquetas);
		lblNombre.setHorizontalAlignment(aligDerecha);
		add(lblNombre);
		txtNombre = new JTextField();
		txtNombre.setBounds(398, 88, 200, 25);
		add(txtNombre);
		lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setBounds(1, 114, 396, 25);
		lblCorreo.setFont(etiquetas);
		lblCorreo.setHorizontalAlignment(aligDerecha);
		add(lblCorreo);
		txtCorreo = new JTextField();
		txtCorreo.setBounds(398, 114, 200, 25);
		add(txtCorreo);
		lblTelefono = new JLabel("Teléfono de Contacto");
		lblTelefono.setBounds(1, 140, 396, 25);
		lblTelefono.setFont(etiquetas);
		lblTelefono.setHorizontalAlignment(aligDerecha);
		add(lblTelefono);
		txtTelefono = new JTextField();
		txtTelefono.setBounds(398, 140, 200, 25);
		add(txtTelefono);
		lblDireccion = new JLabel("Dirección de Residencia");
		lblDireccion.setBounds(1, 166, 396, 25);
		lblDireccion.setFont(etiquetas);
		lblDireccion.setHorizontalAlignment(aligDerecha);
		add(lblDireccion);
		txtDireccion = new JTextField();
		txtDireccion.setBounds(398, 166, 200, 25);
		add(txtDireccion);
		lblCedula = new JLabel("Cédula de Ciudadanía");
		lblCedula.setBounds(1, 192, 396, 25);
		lblCedula.setFont(etiquetas);
		lblCedula.setHorizontalAlignment(aligDerecha);
		add(lblCedula);
		txtCedula = new JTextField();
		txtCedula.setBounds(398, 192, 200, 25);
		add(txtCedula);
		btnCreate = new JButton("Guardar");
		btnCreate.setBounds(46, 237, 100, 40);
		btnCreate.addActionListener(this);
		add(btnCreate);
		btnRead = new JButton("Buscar");
		btnRead.setBounds(166, 237, 100, 40);
		btnRead.addActionListener(this);
		add(btnRead);
		btnUpdate = new JButton("Actualizar");
		btnUpdate.setBounds(286, 237, 100, 40);
		btnUpdate.addActionListener(this);
		add(btnUpdate);
		btnDelete = new JButton("Borrar");
		btnDelete.setBounds(406, 237, 100, 40);
		btnDelete.addActionListener(this);
		add(btnDelete);
		btnExist = new JButton("Existe");
		btnExist.setBounds(526, 237, 100, 40);
		btnExist.addActionListener(this);
		add(btnExist);
		btnList = new JButton("Listar");
		btnList.setBounds(646, 237, 100, 40);
		btnList.addActionListener(this);
		add(btnList);
		dataModel = new DefaultTableModel();
		tblDatos = new JTable(dataModel);
		cols = new Object[]{"Código", "Nombre", "Correo", "Teléfono", "Dirección", "Cédula"};
		dataModel.setColumnIdentifiers(cols);
		scrllPnlDatos = new JScrollPane(tblDatos);
		scrllPnlDatos.setOpaque(true);
		scrllPnlDatos.setBackground(Color.WHITE);
		scrllPnlDatos.setBounds(1, 297, 792, 200);
		add(scrllPnlDatos);
		btnProfesores = new JButton("Profesores");
		btnProfesores.setBounds(1, 530, 110, 40);
		btnProfesores.addActionListener(this);
		add(btnProfesores);
		btnCarreras = new JButton("Carreras");
		btnCarreras.setBounds(683, 530, 110, 40);
		btnCarreras.addActionListener(this);
		add(btnCarreras);
		show();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==btnCreate){
			if(creacion()){
				JOptionPane.showMessageDialog(null,"Estudiante Creado Exitosamente!");
				listado();
			}
	
			
		}else if(e.getSource()==btnRead) {
			if(lectura()){
				JOptionPane.showMessageDialog(null,"Estudiante Leido Exitosamente!");
			}
			
		}else if(e.getSource()==btnUpdate){
			if(actualizacion()){
				JOptionPane.showMessageDialog(null,"Estudiante Actualizado Exitosamente!");
			}
			
			
		}else if(e.getSource()==btnDelete){
			if(borrado()){
				JOptionPane.showMessageDialog(null,"Estudiante Borrado Exitosamente!");
			}
			
		}else if(e.getSource()==btnExist){
			if(existencia()){
				JOptionPane.showMessageDialog(null,"El Estudiante Si Existe!");
			}else {
				JOptionPane.showMessageDialog(null,"El Estudiante No Existe!");
			}
			
			
		}else if(e.getSource()==btnList){
			listado();
			
		}else if(e.getSource()==btnProfesores){
			ProfesoresGUI pg = new ProfesoresGUI();
			setVisible(false);
			pg.setVisible(true);
			dispose();
			
		}else if(e.getSource()==btnCarreras){
			CarreraGUI cg = new CarreraGUI();
			setVisible(false);
			cg.setVisible(true);
			dispose();
		}
	}
	
	public boolean creacion(){
		// Verificar datos de entrada
		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"El codigo debe ser un valor entero");
			return false;
		}
		String nombre = txtNombre.getText();
		String correo = txtCorreo.getText();
		String telefono = txtTelefono.getText();
		String direccion = txtDireccion.getText();
		long cedula;
		try {
			cedula = Long.parseLong(txtCedula.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"La cedula debe ser un valor entero");
			return false;
		}
		
		// Creacion
		return estCont.crear(codigo, nombre, correo, telefono, direccion, cedula);
	}
	
	public boolean lectura(){
		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"El codigo debe ser un valor entero");
			return false;
		}
		DTOEstudiante est;

		
		try {
			est = estCont.leer(codigo);
		}catch(Exception ex){
			return false;
		}
		
		txtNombre.setText(est.getNombre());
		txtTelefono.setText(est.getTelefono());
		txtCorreo.setText(est.getCorreo());
		txtDireccion.setText(est.getDireccion());
		txtCedula.setText(est.getCedula()+"");
		repaint();
		return true;
		
		
		
	}
	
	public boolean actualizacion(){
		// Verificar datos de entrada
		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"El codigo debe ser un valor entero");
			return false;
		}
		String nombre = txtNombre.getText();
		String correo = txtCorreo.getText();
		String telefono = txtTelefono.getText();
		String direccion = txtDireccion.getText();
		long cedula;
		try {
			cedula = Long.parseLong(txtCedula.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"La cedula debe ser un valor entero");
			return false;
		}
		
		// Actualizacion
		return estCont.actualizar(codigo, nombre, correo, telefono, direccion, cedula);
	}
		
	public boolean borrado(){
		// Verificar datos de entrada
		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"El codigo debe ser un valor entero");
			return false;
		}
		String nombre = txtNombre.getText();
		String correo = txtCorreo.getText();
		String telefono = txtTelefono.getText();
		String direccion = txtDireccion.getText();
		long cedula;
		try {
			cedula = Long.parseLong(txtCedula.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"La cedula debe ser un valor entero");
			return false;
		}
		
		// Borrado
		return estCont.borrar(codigo, nombre, correo, telefono, direccion, cedula);
		
	}
	
	public boolean existencia(){
		// Verificar datos de entrada
		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"El codigo debe ser un valor entero");
			return false;
		}
		String nombre = txtNombre.getText();
		String correo = txtCorreo.getText();
		String telefono = txtTelefono.getText();
		String direccion = txtDireccion.getText();
		long cedula;
		try {
			cedula = Long.parseLong(txtCedula.getText());
		}catch(Exception etn){
			JOptionPane.showMessageDialog(null,"La cedula debe ser un valor entero");
			return false;
		}
		
		// Existencia
		return estCont.existe(codigo, nombre, correo, telefono, direccion, cedula);
	
	}
	
	public void listado(){
		ArrayList<Object[]>  listE = estCont.listar();
		for(int i=0; i<listE.size(); i++) {
			dataModel.addRow(listE.get(i));
		}
		repaint();
	}
	
	
}
