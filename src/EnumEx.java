
public class EnumEx {

	public enum Weekday{
		Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Weekday w:Weekday.values()) {
			System.out.println(w);
		}
	}

}
