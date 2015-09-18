public class caller {
	public static void main(String[] args) {
		String[] str = {"Hello", "To", "Callee"};
		callee.main(str);
		System.out.println("caller calls callee.main()");
		System.out.println("intMain.main()");
		intMain.main(9);
	}//end main()
}//end class caller
