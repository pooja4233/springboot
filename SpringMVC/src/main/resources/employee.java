import lombok.Builder;
import lombok.ToString;
@Builder
@ToString

public class emp {
	int empID;
	string empname;
	double salary;
	public static void main (string[]args) {
		emp emp=emp.builder()
				.empID(111)
				.empname("masala")
				.empsalary(116.45)
				.build();
		System.out.println(emp);
	}