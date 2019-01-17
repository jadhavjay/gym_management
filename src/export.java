import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class export {
	public void exportTable(JTable table, File file) throws IOException
	{
	     TableModel model = table.getModel();
	     FileWriter excel = new FileWriter(file);
	     for(int i = 0; i < model.getColumnCount(); i++)
	     {
	       excel.write((String)model.getColumnName(i) + "\t");
	     }
	    excel.write("\n");
	    for(int i=0; i< model.getRowCount(); i++) {
	     for(int j=0; j < model.getColumnCount(); j++) {
	       excel.write((String)model.getValueAt(i,j).toString()+"\t");
	    }
	   excel.write("\n");
	 //  JOptionPane.showM
	}
	 excel.close();
	}
}
