import java.awt.EventQueue;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class DateComboBox extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					DateComboBox frame = new DateComboBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

	int currentDay = localCalendar.get(Calendar.DATE);
	int currentMonth = localCalendar.get(Calendar.MONTH);
	int currentYear = localCalendar.get(Calendar.YEAR);

	String[] Months = { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };

	String[] Days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12",
			"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
			"24", "25", "26", "27", "28", "29", "30", "31" };

	String[] Years = { "2009", "2010", "2011", "2012", "2013", "2014", "2015",
			"2016", "2017", "2018", "2019" };

	/**
	 * Creates the frame.
	 */
	public DateComboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblMonth = new JLabel("Month");
		getContentPane().add(lblMonth, "4, 6");

		JComboBox Month = new JComboBox(Months);
		getContentPane().add(Month, "8, 6, fill, default");
		Month.setSelectedIndex(currentMonth);

		JLabel lblDay = new JLabel("Day");
		getContentPane().add(lblDay, "4, 10");

		JComboBox Day = new JComboBox(Days);
		getContentPane().add(Day, "8, 10, fill, default");
		Day.setSelectedIndex(currentDay - 2);

		JLabel lblYear = new JLabel("Year");
		getContentPane().add(lblYear, "4, 14");

		JComboBox Year = new JComboBox(Years);
		getContentPane().add(Year, "8, 14, fill, default");
		Year.setSelectedIndex(5);

	}
}
