package de.travelbasys.training.dialog.other.exporting;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Types;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist für das Exportieren der aktuellen Datenbank verantwortlich.
 * 
 * @author tba
 **/
public class ExportDialog implements Dialog {

	private ExportModel model;
	private ExportView view;
	@SuppressWarnings("unused")
	private ExportControl control;
	private File outputFile = null;

	public ExportDialog() {
		model = new ExportModel();
		view = new ExportView(model);
		control = new ExportControl(model, view);
	}

	@Override
	public void run() {

		// Here plays the music!
		view.run();
		if (model.getExportType() == null) {
			return;
		}
		try {
			if (model.getExportType() == ".csv") {
				FileWriter fw = new FileWriter(model.getExportName() + model.getExportType());
				PrintWriter pw = new PrintWriter(fw);
				pw.println(model.getHeader());
				for (Customer customer : Dao.getDAO().findAll()) {
					pw.println(customer.toCSV());
				}
				AppContext.printMessage("ExportOK");
				pw.close();
			} else if (model.getExportType() == ".mdb") {
				outputFile = new File(model.getExportName() + model.getExportType());
				Database db = Database.create(outputFile);
				Table newTable = new TableBuilder("tb_customer")
						.addColumn(
								new ColumnBuilder("customerid").setSQLType(
										Types.INTEGER).toColumn())
						.addColumn(
								new ColumnBuilder("lastname").setSQLType(
										Types.VARCHAR).toColumn())
						.addColumn(
								new ColumnBuilder("firstname").setSQLType(
										Types.VARCHAR).toColumn())
						.addColumn(
								new ColumnBuilder("birthdate").setSQLType(
										Types.DATE).toColumn())
						.addColumn(
								new ColumnBuilder("adress").setSQLType(
										Types.VARCHAR).toColumn())
						.addColumn(
								new ColumnBuilder("postalcode").setSQLType(
										Types.VARCHAR).toColumn())
						.addColumn(
								new ColumnBuilder("email").setSQLType(
										Types.VARCHAR).toColumn()).toTable(db);
				for (Customer customer : Dao.getDAO().findAll()) {
					newTable.addRow(customer.getId(), customer.getLastName(),
							customer.getFirstName(), customer.getBirthdate(),
							customer.getAdress(), customer.getPostalcode(),
							customer.getEmail());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
