
public class ComputeFactory {
	public Compute getCompute(String a) {
		if(a == null)
			return null;
		if(a.equalsIgnoreCase("Add"))
			return new Add();
		if(a.equalsIgnoreCase("Sub"))
			return new Sub();
		if(a.equalsIgnoreCase("Mult"))
			return new Mult();
		if(a.equalsIgnoreCase("Div"))
			return new Div();
		return null;
	}
}
