public class IfTest1 {
	public static void main(String[] args) { 
        System.out.println(args.length);
		int x=Integer.parseInt(args[0]);
		if(x>5){
			System.out.println(x+" is Big Number");
		}else {
			System.out.println(x+" is Small Number");
		}
	}
}
