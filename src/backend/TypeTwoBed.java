package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;


//this class represents the King size beds and quanities. All the method comments are similar to the TypeOneBed class.
public class TypeTwoBed extends Bed implements Serializable{

	private static final long serialVersionUID = -402086940508418846L;
	String bed_type, quantity;
	

	@Override
	public String getTypeOfBeds(String room_no) {
		String type_of_bed;
		type_of_bed = getBedDetails(room_no, "bed_type");
		return type_of_bed;
	}

	@Override
	public String getNumberOfBeds(String room_no) {
		String num_of_bed;
		num_of_bed = getBedDetails(room_no, "number_of_beds");
		return num_of_bed;

	}
	
	private String getBedDetails(String room_no, String detail) {
		String roomfilepath = "/home/amsawant/Assignment4/Assignment4/largerooms/Room_"+room_no+".properties";
		FileInputStream in = null; FileOutputStream out = null;
		File fl = new File(roomfilepath);
		String info = null;
		
		if(fl.isFile()) {
			try {
				in = new FileInputStream(fl);
				Properties prop = new Properties();
				prop.load(in);
				info = prop.getProperty(detail);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return info;
		
	}
}